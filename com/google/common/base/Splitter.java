package com.google.common.base;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

public final class Splitter {
    private final int limit;
    private final boolean omitEmptyStrings;
    private final Strategy strategy;
    private final CharMatcher trimmer;

    private static abstract class SplittingIterator extends AbstractIterator<String> {
        int limit;
        int offset = 0;
        final boolean omitEmptyStrings;
        final CharSequence toSplit;
        final CharMatcher trimmer;

        abstract int separatorEnd(int i);

        abstract int separatorStart(int i);

        protected SplittingIterator(Splitter splitter, CharSequence charSequence) {
            this.trimmer = splitter.trimmer;
            this.omitEmptyStrings = splitter.omitEmptyStrings;
            this.limit = splitter.limit;
            this.toSplit = charSequence;
        }

        protected String computeNext() {
            int i = this.offset;
            while (this.offset != -1) {
                int separatorStart = separatorStart(this.offset);
                if (separatorStart == -1) {
                    separatorStart = this.toSplit.length();
                    this.offset = -1;
                } else {
                    this.offset = separatorEnd(separatorStart);
                }
                if (this.offset == i) {
                    this.offset++;
                    if (this.offset > this.toSplit.length()) {
                        this.offset = -1;
                    }
                } else {
                    int i2 = i;
                    while (i2 < separatorStart && this.trimmer.matches(this.toSplit.charAt(i2))) {
                        i2++;
                    }
                    i = separatorStart;
                    while (i > i2 && this.trimmer.matches(this.toSplit.charAt(i - 1))) {
                        i--;
                    }
                    if (this.omitEmptyStrings && i2 == i) {
                        i = this.offset;
                    } else {
                        if (this.limit == 1) {
                            i = this.toSplit.length();
                            this.offset = -1;
                            while (i > i2 && this.trimmer.matches(this.toSplit.charAt(i - 1))) {
                                i--;
                            }
                        } else {
                            this.limit--;
                        }
                        return this.toSplit.subSequence(i2, i).toString();
                    }
                }
            }
            return (String) endOfData();
        }
    }

    private interface Strategy {
        Iterator<String> iterator(Splitter splitter, CharSequence charSequence);
    }

    public static final class MapSplitter {
        private static final String INVALID_ENTRY_MESSAGE = "Chunk [%s] is not a valid entry";
        private final Splitter entrySplitter;
        private final Splitter outerSplitter;

        private MapSplitter(Splitter splitter, Splitter splitter2) {
            this.outerSplitter = splitter;
            this.entrySplitter = (Splitter) Preconditions.checkNotNull(splitter2);
        }

        public Map<String, String> split(CharSequence charSequence) {
            Map linkedHashMap = new LinkedHashMap();
            for (Object obj : this.outerSplitter.split(charSequence)) {
                Iterator access$000 = this.entrySplitter.splittingIterator(obj);
                Preconditions.checkArgument(access$000.hasNext(), INVALID_ENTRY_MESSAGE, obj);
                Object obj2 = (String) access$000.next();
                Preconditions.checkArgument(!linkedHashMap.containsKey(obj2), "Duplicate key [%s] found.", obj2);
                Preconditions.checkArgument(access$000.hasNext(), INVALID_ENTRY_MESSAGE, obj);
                linkedHashMap.put(obj2, (String) access$000.next());
                Preconditions.checkArgument(!access$000.hasNext(), INVALID_ENTRY_MESSAGE, obj);
            }
            return Collections.unmodifiableMap(linkedHashMap);
        }
    }

    private Splitter(Strategy strategy) {
        this(strategy, false, CharMatcher.none(), Integer.MAX_VALUE);
    }

    private Splitter(Strategy strategy, boolean z, CharMatcher charMatcher, int i) {
        this.strategy = strategy;
        this.omitEmptyStrings = z;
        this.trimmer = charMatcher;
        this.limit = i;
    }

    public static Splitter on(char c) {
        return on(CharMatcher.is(c));
    }

    public static Splitter on(final CharMatcher charMatcher) {
        Preconditions.checkNotNull(charMatcher);
        return new Splitter(new Strategy() {
            public SplittingIterator iterator(Splitter splitter, CharSequence charSequence) {
                return new SplittingIterator(splitter, charSequence) {
                    int separatorStart(int i) {
                        return charMatcher.indexIn(this.toSplit, i);
                    }

                    int separatorEnd(int i) {
                        return i + 1;
                    }
                };
            }
        });
    }

    public static Splitter on(final String str) {
        boolean z;
        if (str.length() != 0) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkArgument(z, "The separator may not be the empty string.");
        if (str.length() == 1) {
            return on(str.charAt(0));
        }
        return new Splitter(new Strategy() {
            public SplittingIterator iterator(Splitter splitter, CharSequence charSequence) {
                return new SplittingIterator(splitter, charSequence) {
                    public int separatorStart(int i) {
                        int length = str.length();
                        int length2 = this.toSplit.length() - length;
                        int i2 = i;
                        while (i2 <= length2) {
                            int i3 = 0;
                            while (i3 < length) {
                                if (this.toSplit.charAt(i3 + i2) != str.charAt(i3)) {
                                    i2++;
                                } else {
                                    i3++;
                                }
                            }
                            return i2;
                        }
                        return -1;
                    }

                    public int separatorEnd(int i) {
                        return str.length() + i;
                    }
                };
            }
        });
    }

    public static Splitter on(Pattern pattern) {
        return on(new JdkPattern(pattern));
    }

    private static Splitter on(final CommonPattern commonPattern) {
        Preconditions.checkArgument(!commonPattern.matcher("").matches(), "The pattern may not match the empty string: %s", (Object) commonPattern);
        return new Splitter(new Strategy() {
            public SplittingIterator iterator(Splitter splitter, CharSequence charSequence) {
                final CommonMatcher matcher = commonPattern.matcher(charSequence);
                return new SplittingIterator(splitter, charSequence) {
                    public int separatorStart(int i) {
                        return matcher.find(i) ? matcher.start() : -1;
                    }

                    public int separatorEnd(int i) {
                        return matcher.end();
                    }
                };
            }
        });
    }

    public static Splitter onPattern(String str) {
        return on(Platform.compilePattern(str));
    }

    public static Splitter fixedLength(final int i) {
        Preconditions.checkArgument(i > 0, "The length may not be less than 1");
        return new Splitter(new Strategy() {
            public SplittingIterator iterator(Splitter splitter, CharSequence charSequence) {
                return new SplittingIterator(splitter, charSequence) {
                    public int separatorStart(int i) {
                        int i2 = i + i;
                        return i2 < this.toSplit.length() ? i2 : -1;
                    }

                    public int separatorEnd(int i) {
                        return i;
                    }
                };
            }
        });
    }

    public Splitter omitEmptyStrings() {
        return new Splitter(this.strategy, true, this.trimmer, this.limit);
    }

    public Splitter limit(int i) {
        Preconditions.checkArgument(i > 0, "must be greater than zero: %s", i);
        return new Splitter(this.strategy, this.omitEmptyStrings, this.trimmer, i);
    }

    public Splitter trimResults() {
        return trimResults(CharMatcher.whitespace());
    }

    public Splitter trimResults(CharMatcher charMatcher) {
        Preconditions.checkNotNull(charMatcher);
        return new Splitter(this.strategy, this.omitEmptyStrings, charMatcher, this.limit);
    }

    public Iterable<String> split(final CharSequence charSequence) {
        Preconditions.checkNotNull(charSequence);
        return new Iterable<String>() {
            public Iterator<String> iterator() {
                return Splitter.this.splittingIterator(charSequence);
            }

            public String toString() {
                return Joiner.on(", ").appendTo(new StringBuilder().append('['), (Iterable) this).append(']').toString();
            }
        };
    }

    private Iterator<String> splittingIterator(CharSequence charSequence) {
        return this.strategy.iterator(this, charSequence);
    }

    public List<String> splitToList(CharSequence charSequence) {
        Preconditions.checkNotNull(charSequence);
        Iterator splittingIterator = splittingIterator(charSequence);
        List arrayList = new ArrayList();
        while (splittingIterator.hasNext()) {
            arrayList.add(splittingIterator.next());
        }
        return Collections.unmodifiableList(arrayList);
    }

    public MapSplitter withKeyValueSeparator(String str) {
        return withKeyValueSeparator(on(str));
    }

    public MapSplitter withKeyValueSeparator(char c) {
        return withKeyValueSeparator(on(c));
    }

    public MapSplitter withKeyValueSeparator(Splitter splitter) {
        return new MapSplitter(splitter);
    }
}
