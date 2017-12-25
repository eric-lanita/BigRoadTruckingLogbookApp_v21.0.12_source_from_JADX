package com.google.android.gms.internal;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.InetAddress;
import java.net.URI;
import java.net.URL;
import java.sql.Timestamp;
import java.util.BitSet;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.StringTokenizer;
import java.util.UUID;

public final class zzaok {
    public static final zzanh<Class> bfX = new C32991();
    public static final zzani bfY = zza(Class.class, bfX);
    public static final zzanh<BitSet> bfZ = new zzanh<BitSet>() {
        public void zza(zzaoo com_google_android_gms_internal_zzaoo, BitSet bitSet) {
            if (bitSet == null) {
                com_google_android_gms_internal_zzaoo.mo1858l();
                return;
            }
            com_google_android_gms_internal_zzaoo.mo1854h();
            for (int i = 0; i < bitSet.length(); i++) {
                com_google_android_gms_internal_zzaoo.zzcr((long) (bitSet.get(i) ? 1 : 0));
            }
            com_google_android_gms_internal_zzaoo.mo1855i();
        }

        public /* synthetic */ Object zzb(zzaom com_google_android_gms_internal_zzaom) {
            return zzx(com_google_android_gms_internal_zzaom);
        }

        public BitSet zzx(zzaom com_google_android_gms_internal_zzaom) {
            if (com_google_android_gms_internal_zzaom.mo1835b() == zzaon.NULL) {
                com_google_android_gms_internal_zzaom.nextNull();
                return null;
            }
            BitSet bitSet = new BitSet();
            com_google_android_gms_internal_zzaom.beginArray();
            zzaon b = com_google_android_gms_internal_zzaom.mo1835b();
            int i = 0;
            while (b != zzaon.END_ARRAY) {
                boolean z;
                String valueOf;
                switch (b) {
                    case NUMBER:
                        if (com_google_android_gms_internal_zzaom.nextInt() == 0) {
                            z = false;
                            break;
                        }
                        z = true;
                        break;
                    case BOOLEAN:
                        z = com_google_android_gms_internal_zzaom.nextBoolean();
                        break;
                    case STRING:
                        Object nextString = com_google_android_gms_internal_zzaom.nextString();
                        try {
                            if (Integer.parseInt(nextString) == 0) {
                                z = false;
                                break;
                            }
                            z = true;
                            break;
                        } catch (NumberFormatException e) {
                            String str = "Error: Expecting: bitset number value (1, 0), Found: ";
                            valueOf = String.valueOf(nextString);
                            throw new zzane(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
                        }
                    default:
                        valueOf = String.valueOf(b);
                        throw new zzane(new StringBuilder(String.valueOf(valueOf).length() + 27).append("Invalid bitset value type: ").append(valueOf).toString());
                }
                if (z) {
                    bitSet.set(i);
                }
                i++;
                b = com_google_android_gms_internal_zzaom.mo1835b();
            }
            com_google_android_gms_internal_zzaom.endArray();
            return bitSet;
        }
    };
    public static final zzani bgA = zza(URL.class, bgz);
    public static final zzanh<URI> bgB = new zzanh<URI>() {
        public void zza(zzaoo com_google_android_gms_internal_zzaoo, URI uri) {
            com_google_android_gms_internal_zzaoo.zzts(uri == null ? null : uri.toASCIIString());
        }

        public /* synthetic */ Object zzb(zzaom com_google_android_gms_internal_zzaom) {
            return zzw(com_google_android_gms_internal_zzaom);
        }

        public URI zzw(zzaom com_google_android_gms_internal_zzaom) {
            URI uri = null;
            if (com_google_android_gms_internal_zzaom.mo1835b() == zzaon.NULL) {
                com_google_android_gms_internal_zzaom.nextNull();
            } else {
                try {
                    String nextString = com_google_android_gms_internal_zzaom.nextString();
                    if (!"null".equals(nextString)) {
                        uri = new URI(nextString);
                    }
                } catch (Throwable e) {
                    throw new zzamw(e);
                }
            }
            return uri;
        }
    };
    public static final zzani bgC = zza(URI.class, bgB);
    public static final zzanh<InetAddress> bgD = new zzanh<InetAddress>() {
        public void zza(zzaoo com_google_android_gms_internal_zzaoo, InetAddress inetAddress) {
            com_google_android_gms_internal_zzaoo.zzts(inetAddress == null ? null : inetAddress.getHostAddress());
        }

        public /* synthetic */ Object zzb(zzaom com_google_android_gms_internal_zzaom) {
            return zzy(com_google_android_gms_internal_zzaom);
        }

        public InetAddress zzy(zzaom com_google_android_gms_internal_zzaom) {
            if (com_google_android_gms_internal_zzaom.mo1835b() != zzaon.NULL) {
                return InetAddress.getByName(com_google_android_gms_internal_zzaom.nextString());
            }
            com_google_android_gms_internal_zzaom.nextNull();
            return null;
        }
    };
    public static final zzani bgE = zzb(InetAddress.class, bgD);
    public static final zzanh<UUID> bgF = new zzanh<UUID>() {
        public void zza(zzaoo com_google_android_gms_internal_zzaoo, UUID uuid) {
            com_google_android_gms_internal_zzaoo.zzts(uuid == null ? null : uuid.toString());
        }

        public /* synthetic */ Object zzb(zzaom com_google_android_gms_internal_zzaom) {
            return zzz(com_google_android_gms_internal_zzaom);
        }

        public UUID zzz(zzaom com_google_android_gms_internal_zzaom) {
            if (com_google_android_gms_internal_zzaom.mo1835b() != zzaon.NULL) {
                return UUID.fromString(com_google_android_gms_internal_zzaom.nextString());
            }
            com_google_android_gms_internal_zzaom.nextNull();
            return null;
        }
    };
    public static final zzani bgG = zza(UUID.class, bgF);
    public static final zzani bgH = new zzani() {
        public <T> zzanh<T> zza(zzamp com_google_android_gms_internal_zzamp, zzaol<T> com_google_android_gms_internal_zzaol_T) {
            if (com_google_android_gms_internal_zzaol_T.m17303m() != Timestamp.class) {
                return null;
            }
            final zzanh zzk = com_google_android_gms_internal_zzamp.zzk(Date.class);
            return new zzanh<Timestamp>(this) {
                final /* synthetic */ AnonymousClass15 f11327b;

                public void zza(zzaoo com_google_android_gms_internal_zzaoo, Timestamp timestamp) {
                    zzk.zza(com_google_android_gms_internal_zzaoo, timestamp);
                }

                public Timestamp zzaa(zzaom com_google_android_gms_internal_zzaom) {
                    Date date = (Date) zzk.zzb(com_google_android_gms_internal_zzaom);
                    return date != null ? new Timestamp(date.getTime()) : null;
                }

                public /* synthetic */ Object zzb(zzaom com_google_android_gms_internal_zzaom) {
                    return zzaa(com_google_android_gms_internal_zzaom);
                }
            };
        }
    };
    public static final zzanh<Calendar> bgI = new zzanh<Calendar>() {
        public void zza(zzaoo com_google_android_gms_internal_zzaoo, Calendar calendar) {
            if (calendar == null) {
                com_google_android_gms_internal_zzaoo.mo1858l();
                return;
            }
            com_google_android_gms_internal_zzaoo.mo1856j();
            com_google_android_gms_internal_zzaoo.zztr("year");
            com_google_android_gms_internal_zzaoo.zzcr((long) calendar.get(1));
            com_google_android_gms_internal_zzaoo.zztr("month");
            com_google_android_gms_internal_zzaoo.zzcr((long) calendar.get(2));
            com_google_android_gms_internal_zzaoo.zztr("dayOfMonth");
            com_google_android_gms_internal_zzaoo.zzcr((long) calendar.get(5));
            com_google_android_gms_internal_zzaoo.zztr("hourOfDay");
            com_google_android_gms_internal_zzaoo.zzcr((long) calendar.get(11));
            com_google_android_gms_internal_zzaoo.zztr("minute");
            com_google_android_gms_internal_zzaoo.zzcr((long) calendar.get(12));
            com_google_android_gms_internal_zzaoo.zztr("second");
            com_google_android_gms_internal_zzaoo.zzcr((long) calendar.get(13));
            com_google_android_gms_internal_zzaoo.mo1857k();
        }

        public Calendar zzab(zzaom com_google_android_gms_internal_zzaom) {
            int i = 0;
            if (com_google_android_gms_internal_zzaom.mo1835b() == zzaon.NULL) {
                com_google_android_gms_internal_zzaom.nextNull();
                return null;
            }
            com_google_android_gms_internal_zzaom.beginObject();
            int i2 = 0;
            int i3 = 0;
            int i4 = 0;
            int i5 = 0;
            int i6 = 0;
            while (com_google_android_gms_internal_zzaom.mo1835b() != zzaon.END_OBJECT) {
                String nextName = com_google_android_gms_internal_zzaom.nextName();
                int nextInt = com_google_android_gms_internal_zzaom.nextInt();
                if ("year".equals(nextName)) {
                    i6 = nextInt;
                } else if ("month".equals(nextName)) {
                    i5 = nextInt;
                } else if ("dayOfMonth".equals(nextName)) {
                    i4 = nextInt;
                } else if ("hourOfDay".equals(nextName)) {
                    i3 = nextInt;
                } else if ("minute".equals(nextName)) {
                    i2 = nextInt;
                } else if ("second".equals(nextName)) {
                    i = nextInt;
                }
            }
            com_google_android_gms_internal_zzaom.endObject();
            return new GregorianCalendar(i6, i5, i4, i3, i2, i);
        }

        public /* synthetic */ Object zzb(zzaom com_google_android_gms_internal_zzaom) {
            return zzab(com_google_android_gms_internal_zzaom);
        }
    };
    public static final zzani bgJ = zzb(Calendar.class, GregorianCalendar.class, bgI);
    public static final zzanh<Locale> bgK = new zzanh<Locale>() {
        public void zza(zzaoo com_google_android_gms_internal_zzaoo, Locale locale) {
            com_google_android_gms_internal_zzaoo.zzts(locale == null ? null : locale.toString());
        }

        public Locale zzac(zzaom com_google_android_gms_internal_zzaom) {
            if (com_google_android_gms_internal_zzaom.mo1835b() == zzaon.NULL) {
                com_google_android_gms_internal_zzaom.nextNull();
                return null;
            }
            StringTokenizer stringTokenizer = new StringTokenizer(com_google_android_gms_internal_zzaom.nextString(), "_");
            String nextToken = stringTokenizer.hasMoreElements() ? stringTokenizer.nextToken() : null;
            String nextToken2 = stringTokenizer.hasMoreElements() ? stringTokenizer.nextToken() : null;
            String nextToken3 = stringTokenizer.hasMoreElements() ? stringTokenizer.nextToken() : null;
            return (nextToken2 == null && nextToken3 == null) ? new Locale(nextToken) : nextToken3 == null ? new Locale(nextToken, nextToken2) : new Locale(nextToken, nextToken2, nextToken3);
        }

        public /* synthetic */ Object zzb(zzaom com_google_android_gms_internal_zzaom) {
            return zzac(com_google_android_gms_internal_zzaom);
        }
    };
    public static final zzani bgL = zza(Locale.class, bgK);
    public static final zzanh<zzamv> bgM = new zzanh<zzamv>() {
        public void zza(zzaoo com_google_android_gms_internal_zzaoo, zzamv com_google_android_gms_internal_zzamv) {
            if (com_google_android_gms_internal_zzamv == null || com_google_android_gms_internal_zzamv.zzczj()) {
                com_google_android_gms_internal_zzaoo.mo1858l();
            } else if (com_google_android_gms_internal_zzamv.zzczi()) {
                zzanb zzczm = com_google_android_gms_internal_zzamv.zzczm();
                if (zzczm.zzczp()) {
                    com_google_android_gms_internal_zzaoo.zza(zzczm.zzcze());
                } else if (zzczm.zzczo()) {
                    com_google_android_gms_internal_zzaoo.zzda(zzczm.getAsBoolean());
                } else {
                    com_google_android_gms_internal_zzaoo.zzts(zzczm.zzczf());
                }
            } else if (com_google_android_gms_internal_zzamv.zzczg()) {
                com_google_android_gms_internal_zzaoo.mo1854h();
                Iterator it = com_google_android_gms_internal_zzamv.zzczl().iterator();
                while (it.hasNext()) {
                    zza(com_google_android_gms_internal_zzaoo, (zzamv) it.next());
                }
                com_google_android_gms_internal_zzaoo.mo1855i();
            } else if (com_google_android_gms_internal_zzamv.zzczh()) {
                com_google_android_gms_internal_zzaoo.mo1856j();
                for (Entry entry : com_google_android_gms_internal_zzamv.zzczk().entrySet()) {
                    com_google_android_gms_internal_zzaoo.zztr((String) entry.getKey());
                    zza(com_google_android_gms_internal_zzaoo, (zzamv) entry.getValue());
                }
                com_google_android_gms_internal_zzaoo.mo1857k();
            } else {
                String valueOf = String.valueOf(com_google_android_gms_internal_zzamv.getClass());
                throw new IllegalArgumentException(new StringBuilder(String.valueOf(valueOf).length() + 15).append("Couldn't write ").append(valueOf).toString());
            }
        }

        public zzamv zzad(zzaom com_google_android_gms_internal_zzaom) {
            zzamv com_google_android_gms_internal_zzams;
            switch (com_google_android_gms_internal_zzaom.mo1835b()) {
                case NUMBER:
                    return new zzanb(new zzans(com_google_android_gms_internal_zzaom.nextString()));
                case BOOLEAN:
                    return new zzanb(Boolean.valueOf(com_google_android_gms_internal_zzaom.nextBoolean()));
                case STRING:
                    return new zzanb(com_google_android_gms_internal_zzaom.nextString());
                case NULL:
                    com_google_android_gms_internal_zzaom.nextNull();
                    return zzamx.bei;
                case BEGIN_ARRAY:
                    com_google_android_gms_internal_zzams = new zzams();
                    com_google_android_gms_internal_zzaom.beginArray();
                    while (com_google_android_gms_internal_zzaom.hasNext()) {
                        com_google_android_gms_internal_zzams.zzc((zzamv) zzb(com_google_android_gms_internal_zzaom));
                    }
                    com_google_android_gms_internal_zzaom.endArray();
                    return com_google_android_gms_internal_zzams;
                case BEGIN_OBJECT:
                    com_google_android_gms_internal_zzams = new zzamy();
                    com_google_android_gms_internal_zzaom.beginObject();
                    while (com_google_android_gms_internal_zzaom.hasNext()) {
                        com_google_android_gms_internal_zzams.zza(com_google_android_gms_internal_zzaom.nextName(), (zzamv) zzb(com_google_android_gms_internal_zzaom));
                    }
                    com_google_android_gms_internal_zzaom.endObject();
                    return com_google_android_gms_internal_zzams;
                default:
                    throw new IllegalArgumentException();
            }
        }

        public /* synthetic */ Object zzb(zzaom com_google_android_gms_internal_zzaom) {
            return zzad(com_google_android_gms_internal_zzaom);
        }
    };
    public static final zzani bgN = zzb(zzamv.class, bgM);
    public static final zzani bgO = new zzani() {
        public <T> zzanh<T> zza(zzamp com_google_android_gms_internal_zzamp, zzaol<T> com_google_android_gms_internal_zzaol_T) {
            Class m = com_google_android_gms_internal_zzaol_T.m17303m();
            if (!Enum.class.isAssignableFrom(m) || m == Enum.class) {
                return null;
            }
            if (!m.isEnum()) {
                m = m.getSuperclass();
            }
            return new zza(m);
        }
    };
    public static final zzani bga = zza(BitSet.class, bfZ);
    public static final zzanh<Boolean> bgb = new zzanh<Boolean>() {
        public void zza(zzaoo com_google_android_gms_internal_zzaoo, Boolean bool) {
            if (bool == null) {
                com_google_android_gms_internal_zzaoo.mo1858l();
            } else {
                com_google_android_gms_internal_zzaoo.zzda(bool.booleanValue());
            }
        }

        public Boolean zzae(zzaom com_google_android_gms_internal_zzaom) {
            if (com_google_android_gms_internal_zzaom.mo1835b() != zzaon.NULL) {
                return com_google_android_gms_internal_zzaom.mo1835b() == zzaon.STRING ? Boolean.valueOf(Boolean.parseBoolean(com_google_android_gms_internal_zzaom.nextString())) : Boolean.valueOf(com_google_android_gms_internal_zzaom.nextBoolean());
            } else {
                com_google_android_gms_internal_zzaom.nextNull();
                return null;
            }
        }

        public /* synthetic */ Object zzb(zzaom com_google_android_gms_internal_zzaom) {
            return zzae(com_google_android_gms_internal_zzaom);
        }
    };
    public static final zzanh<Boolean> bgc = new zzanh<Boolean>() {
        public void zza(zzaoo com_google_android_gms_internal_zzaoo, Boolean bool) {
            com_google_android_gms_internal_zzaoo.zzts(bool == null ? "null" : bool.toString());
        }

        public Boolean zzae(zzaom com_google_android_gms_internal_zzaom) {
            if (com_google_android_gms_internal_zzaom.mo1835b() != zzaon.NULL) {
                return Boolean.valueOf(com_google_android_gms_internal_zzaom.nextString());
            }
            com_google_android_gms_internal_zzaom.nextNull();
            return null;
        }

        public /* synthetic */ Object zzb(zzaom com_google_android_gms_internal_zzaom) {
            return zzae(com_google_android_gms_internal_zzaom);
        }
    };
    public static final zzani bgd = zza(Boolean.TYPE, Boolean.class, bgb);
    public static final zzanh<Number> bge = new zzanh<Number>() {
        public void zza(zzaoo com_google_android_gms_internal_zzaoo, Number number) {
            com_google_android_gms_internal_zzaoo.zza(number);
        }

        public /* synthetic */ Object zzb(zzaom com_google_android_gms_internal_zzaom) {
            return zzg(com_google_android_gms_internal_zzaom);
        }

        public Number zzg(zzaom com_google_android_gms_internal_zzaom) {
            if (com_google_android_gms_internal_zzaom.mo1835b() == zzaon.NULL) {
                com_google_android_gms_internal_zzaom.nextNull();
                return null;
            }
            try {
                return Byte.valueOf((byte) com_google_android_gms_internal_zzaom.nextInt());
            } catch (Throwable e) {
                throw new zzane(e);
            }
        }
    };
    public static final zzani bgf = zza(Byte.TYPE, Byte.class, bge);
    public static final zzanh<Number> bgg = new zzanh<Number>() {
        public void zza(zzaoo com_google_android_gms_internal_zzaoo, Number number) {
            com_google_android_gms_internal_zzaoo.zza(number);
        }

        public /* synthetic */ Object zzb(zzaom com_google_android_gms_internal_zzaom) {
            return zzg(com_google_android_gms_internal_zzaom);
        }

        public Number zzg(zzaom com_google_android_gms_internal_zzaom) {
            if (com_google_android_gms_internal_zzaom.mo1835b() == zzaon.NULL) {
                com_google_android_gms_internal_zzaom.nextNull();
                return null;
            }
            try {
                return Short.valueOf((short) com_google_android_gms_internal_zzaom.nextInt());
            } catch (Throwable e) {
                throw new zzane(e);
            }
        }
    };
    public static final zzani bgh = zza(Short.TYPE, Short.class, bgg);
    public static final zzanh<Number> bgi = new zzanh<Number>() {
        public void zza(zzaoo com_google_android_gms_internal_zzaoo, Number number) {
            com_google_android_gms_internal_zzaoo.zza(number);
        }

        public /* synthetic */ Object zzb(zzaom com_google_android_gms_internal_zzaom) {
            return zzg(com_google_android_gms_internal_zzaom);
        }

        public Number zzg(zzaom com_google_android_gms_internal_zzaom) {
            if (com_google_android_gms_internal_zzaom.mo1835b() == zzaon.NULL) {
                com_google_android_gms_internal_zzaom.nextNull();
                return null;
            }
            try {
                return Integer.valueOf(com_google_android_gms_internal_zzaom.nextInt());
            } catch (Throwable e) {
                throw new zzane(e);
            }
        }
    };
    public static final zzani bgj = zza(Integer.TYPE, Integer.class, bgi);
    public static final zzanh<Number> bgk = new zzanh<Number>() {
        public void zza(zzaoo com_google_android_gms_internal_zzaoo, Number number) {
            com_google_android_gms_internal_zzaoo.zza(number);
        }

        public /* synthetic */ Object zzb(zzaom com_google_android_gms_internal_zzaom) {
            return zzg(com_google_android_gms_internal_zzaom);
        }

        public Number zzg(zzaom com_google_android_gms_internal_zzaom) {
            if (com_google_android_gms_internal_zzaom.mo1835b() == zzaon.NULL) {
                com_google_android_gms_internal_zzaom.nextNull();
                return null;
            }
            try {
                return Long.valueOf(com_google_android_gms_internal_zzaom.nextLong());
            } catch (Throwable e) {
                throw new zzane(e);
            }
        }
    };
    public static final zzanh<Number> bgl = new zzanh<Number>() {
        public void zza(zzaoo com_google_android_gms_internal_zzaoo, Number number) {
            com_google_android_gms_internal_zzaoo.zza(number);
        }

        public /* synthetic */ Object zzb(zzaom com_google_android_gms_internal_zzaom) {
            return zzg(com_google_android_gms_internal_zzaom);
        }

        public Number zzg(zzaom com_google_android_gms_internal_zzaom) {
            if (com_google_android_gms_internal_zzaom.mo1835b() != zzaon.NULL) {
                return Float.valueOf((float) com_google_android_gms_internal_zzaom.nextDouble());
            }
            com_google_android_gms_internal_zzaom.nextNull();
            return null;
        }
    };
    public static final zzanh<Number> bgm = new C33002();
    public static final zzanh<Number> bgn = new C33013();
    public static final zzani bgo = zza(Number.class, bgn);
    public static final zzanh<Character> bgp = new C33024();
    public static final zzani bgq = zza(Character.TYPE, Character.class, bgp);
    public static final zzanh<String> bgr = new C33035();
    public static final zzanh<BigDecimal> bgs = new C33046();
    public static final zzanh<BigInteger> bgt = new C33057();
    public static final zzani bgu = zza(String.class, bgr);
    public static final zzanh<StringBuilder> bgv = new C33068();
    public static final zzani bgw = zza(StringBuilder.class, bgv);
    public static final zzanh<StringBuffer> bgx = new C33079();
    public static final zzani bgy = zza(StringBuffer.class, bgx);
    public static final zzanh<URL> bgz = new zzanh<URL>() {
        public void zza(zzaoo com_google_android_gms_internal_zzaoo, URL url) {
            com_google_android_gms_internal_zzaoo.zzts(url == null ? null : url.toExternalForm());
        }

        public /* synthetic */ Object zzb(zzaom com_google_android_gms_internal_zzaom) {
            return zzv(com_google_android_gms_internal_zzaom);
        }

        public URL zzv(zzaom com_google_android_gms_internal_zzaom) {
            if (com_google_android_gms_internal_zzaom.mo1835b() == zzaon.NULL) {
                com_google_android_gms_internal_zzaom.nextNull();
                return null;
            }
            String nextString = com_google_android_gms_internal_zzaom.nextString();
            return !"null".equals(nextString) ? new URL(nextString) : null;
        }
    };

    static class C32991 extends zzanh<Class> {
        C32991() {
        }

        public void zza(zzaoo com_google_android_gms_internal_zzaoo, Class cls) {
            if (cls == null) {
                com_google_android_gms_internal_zzaoo.mo1858l();
            } else {
                String valueOf = String.valueOf(cls.getName());
                throw new UnsupportedOperationException(new StringBuilder(String.valueOf(valueOf).length() + 76).append("Attempted to serialize java.lang.Class: ").append(valueOf).append(". Forgot to register a type adapter?").toString());
            }
        }

        public /* synthetic */ Object zzb(zzaom com_google_android_gms_internal_zzaom) {
            return zzo(com_google_android_gms_internal_zzaom);
        }

        public Class zzo(zzaom com_google_android_gms_internal_zzaom) {
            if (com_google_android_gms_internal_zzaom.mo1835b() == zzaon.NULL) {
                com_google_android_gms_internal_zzaom.nextNull();
                return null;
            }
            throw new UnsupportedOperationException("Attempted to deserialize a java.lang.Class. Forgot to register a type adapter?");
        }
    }

    static class C33002 extends zzanh<Number> {
        C33002() {
        }

        public void zza(zzaoo com_google_android_gms_internal_zzaoo, Number number) {
            com_google_android_gms_internal_zzaoo.zza(number);
        }

        public /* synthetic */ Object zzb(zzaom com_google_android_gms_internal_zzaom) {
            return zzg(com_google_android_gms_internal_zzaom);
        }

        public Number zzg(zzaom com_google_android_gms_internal_zzaom) {
            if (com_google_android_gms_internal_zzaom.mo1835b() != zzaon.NULL) {
                return Double.valueOf(com_google_android_gms_internal_zzaom.nextDouble());
            }
            com_google_android_gms_internal_zzaom.nextNull();
            return null;
        }
    }

    static class C33013 extends zzanh<Number> {
        C33013() {
        }

        public void zza(zzaoo com_google_android_gms_internal_zzaoo, Number number) {
            com_google_android_gms_internal_zzaoo.zza(number);
        }

        public /* synthetic */ Object zzb(zzaom com_google_android_gms_internal_zzaom) {
            return zzg(com_google_android_gms_internal_zzaom);
        }

        public Number zzg(zzaom com_google_android_gms_internal_zzaom) {
            zzaon b = com_google_android_gms_internal_zzaom.mo1835b();
            switch (b) {
                case NUMBER:
                    return new zzans(com_google_android_gms_internal_zzaom.nextString());
                case NULL:
                    com_google_android_gms_internal_zzaom.nextNull();
                    return null;
                default:
                    String valueOf = String.valueOf(b);
                    throw new zzane(new StringBuilder(String.valueOf(valueOf).length() + 23).append("Expecting number, got: ").append(valueOf).toString());
            }
        }
    }

    static class C33024 extends zzanh<Character> {
        C33024() {
        }

        public void zza(zzaoo com_google_android_gms_internal_zzaoo, Character ch) {
            com_google_android_gms_internal_zzaoo.zzts(ch == null ? null : String.valueOf(ch));
        }

        public /* synthetic */ Object zzb(zzaom com_google_android_gms_internal_zzaom) {
            return zzp(com_google_android_gms_internal_zzaom);
        }

        public Character zzp(zzaom com_google_android_gms_internal_zzaom) {
            if (com_google_android_gms_internal_zzaom.mo1835b() == zzaon.NULL) {
                com_google_android_gms_internal_zzaom.nextNull();
                return null;
            }
            String nextString = com_google_android_gms_internal_zzaom.nextString();
            if (nextString.length() == 1) {
                return Character.valueOf(nextString.charAt(0));
            }
            String str = "Expecting character, got: ";
            nextString = String.valueOf(nextString);
            throw new zzane(nextString.length() != 0 ? str.concat(nextString) : new String(str));
        }
    }

    static class C33035 extends zzanh<String> {
        C33035() {
        }

        public void zza(zzaoo com_google_android_gms_internal_zzaoo, String str) {
            com_google_android_gms_internal_zzaoo.zzts(str);
        }

        public /* synthetic */ Object zzb(zzaom com_google_android_gms_internal_zzaom) {
            return zzq(com_google_android_gms_internal_zzaom);
        }

        public String zzq(zzaom com_google_android_gms_internal_zzaom) {
            zzaon b = com_google_android_gms_internal_zzaom.mo1835b();
            if (b != zzaon.NULL) {
                return b == zzaon.BOOLEAN ? Boolean.toString(com_google_android_gms_internal_zzaom.nextBoolean()) : com_google_android_gms_internal_zzaom.nextString();
            } else {
                com_google_android_gms_internal_zzaom.nextNull();
                return null;
            }
        }
    }

    static class C33046 extends zzanh<BigDecimal> {
        C33046() {
        }

        public void zza(zzaoo com_google_android_gms_internal_zzaoo, BigDecimal bigDecimal) {
            com_google_android_gms_internal_zzaoo.zza(bigDecimal);
        }

        public /* synthetic */ Object zzb(zzaom com_google_android_gms_internal_zzaom) {
            return zzr(com_google_android_gms_internal_zzaom);
        }

        public BigDecimal zzr(zzaom com_google_android_gms_internal_zzaom) {
            if (com_google_android_gms_internal_zzaom.mo1835b() == zzaon.NULL) {
                com_google_android_gms_internal_zzaom.nextNull();
                return null;
            }
            try {
                return new BigDecimal(com_google_android_gms_internal_zzaom.nextString());
            } catch (Throwable e) {
                throw new zzane(e);
            }
        }
    }

    static class C33057 extends zzanh<BigInteger> {
        C33057() {
        }

        public void zza(zzaoo com_google_android_gms_internal_zzaoo, BigInteger bigInteger) {
            com_google_android_gms_internal_zzaoo.zza(bigInteger);
        }

        public /* synthetic */ Object zzb(zzaom com_google_android_gms_internal_zzaom) {
            return zzs(com_google_android_gms_internal_zzaom);
        }

        public BigInteger zzs(zzaom com_google_android_gms_internal_zzaom) {
            if (com_google_android_gms_internal_zzaom.mo1835b() == zzaon.NULL) {
                com_google_android_gms_internal_zzaom.nextNull();
                return null;
            }
            try {
                return new BigInteger(com_google_android_gms_internal_zzaom.nextString());
            } catch (Throwable e) {
                throw new zzane(e);
            }
        }
    }

    static class C33068 extends zzanh<StringBuilder> {
        C33068() {
        }

        public void zza(zzaoo com_google_android_gms_internal_zzaoo, StringBuilder stringBuilder) {
            com_google_android_gms_internal_zzaoo.zzts(stringBuilder == null ? null : stringBuilder.toString());
        }

        public /* synthetic */ Object zzb(zzaom com_google_android_gms_internal_zzaom) {
            return zzt(com_google_android_gms_internal_zzaom);
        }

        public StringBuilder zzt(zzaom com_google_android_gms_internal_zzaom) {
            if (com_google_android_gms_internal_zzaom.mo1835b() != zzaon.NULL) {
                return new StringBuilder(com_google_android_gms_internal_zzaom.nextString());
            }
            com_google_android_gms_internal_zzaom.nextNull();
            return null;
        }
    }

    static class C33079 extends zzanh<StringBuffer> {
        C33079() {
        }

        public void zza(zzaoo com_google_android_gms_internal_zzaoo, StringBuffer stringBuffer) {
            com_google_android_gms_internal_zzaoo.zzts(stringBuffer == null ? null : stringBuffer.toString());
        }

        public /* synthetic */ Object zzb(zzaom com_google_android_gms_internal_zzaom) {
            return zzu(com_google_android_gms_internal_zzaom);
        }

        public StringBuffer zzu(zzaom com_google_android_gms_internal_zzaom) {
            if (com_google_android_gms_internal_zzaom.mo1835b() != zzaon.NULL) {
                return new StringBuffer(com_google_android_gms_internal_zzaom.nextString());
            }
            com_google_android_gms_internal_zzaom.nextNull();
            return null;
        }
    }

    private static final class zza<T extends Enum<T>> extends zzanh<T> {
        private final Map<String, T> f11341a = new HashMap();
        private final Map<T, String> f11342b = new HashMap();

        public zza(Class<T> cls) {
            try {
                for (Enum enumR : (Enum[]) cls.getEnumConstants()) {
                    String name = enumR.name();
                    zzank com_google_android_gms_internal_zzank = (zzank) cls.getField(name).getAnnotation(zzank.class);
                    if (com_google_android_gms_internal_zzank != null) {
                        name = com_google_android_gms_internal_zzank.value();
                        for (Object put : com_google_android_gms_internal_zzank.zzczs()) {
                            this.f11341a.put(put, enumR);
                        }
                    }
                    String str = name;
                    this.f11341a.put(str, enumR);
                    this.f11342b.put(enumR, str);
                }
            } catch (NoSuchFieldException e) {
                throw new AssertionError();
            }
        }

        public void zza(zzaoo com_google_android_gms_internal_zzaoo, T t) {
            com_google_android_gms_internal_zzaoo.zzts(t == null ? null : (String) this.f11342b.get(t));
        }

        public T zzaf(zzaom com_google_android_gms_internal_zzaom) {
            if (com_google_android_gms_internal_zzaom.mo1835b() != zzaon.NULL) {
                return (Enum) this.f11341a.get(com_google_android_gms_internal_zzaom.nextString());
            }
            com_google_android_gms_internal_zzaom.nextNull();
            return null;
        }

        public /* synthetic */ Object zzb(zzaom com_google_android_gms_internal_zzaom) {
            return zzaf(com_google_android_gms_internal_zzaom);
        }
    }

    public static <TT> zzani zza(final zzaol<TT> com_google_android_gms_internal_zzaol_TT, final zzanh<TT> com_google_android_gms_internal_zzanh_TT) {
        return new zzani() {
            public <T> zzanh<T> zza(zzamp com_google_android_gms_internal_zzamp, zzaol<T> com_google_android_gms_internal_zzaol_T) {
                return com_google_android_gms_internal_zzaol_T.equals(com_google_android_gms_internal_zzaol_TT) ? com_google_android_gms_internal_zzanh_TT : null;
            }
        };
    }

    public static <TT> zzani zza(final Class<TT> cls, final zzanh<TT> com_google_android_gms_internal_zzanh_TT) {
        return new zzani() {
            public String toString() {
                String valueOf = String.valueOf(cls.getName());
                String valueOf2 = String.valueOf(com_google_android_gms_internal_zzanh_TT);
                return new StringBuilder((String.valueOf(valueOf).length() + 23) + String.valueOf(valueOf2).length()).append("Factory[type=").append(valueOf).append(",adapter=").append(valueOf2).append("]").toString();
            }

            public <T> zzanh<T> zza(zzamp com_google_android_gms_internal_zzamp, zzaol<T> com_google_android_gms_internal_zzaol_T) {
                return com_google_android_gms_internal_zzaol_T.m17303m() == cls ? com_google_android_gms_internal_zzanh_TT : null;
            }
        };
    }

    public static <TT> zzani zza(final Class<TT> cls, final Class<TT> cls2, final zzanh<? super TT> com_google_android_gms_internal_zzanh__super_TT) {
        return new zzani() {
            public String toString() {
                String valueOf = String.valueOf(cls2.getName());
                String valueOf2 = String.valueOf(cls.getName());
                String valueOf3 = String.valueOf(com_google_android_gms_internal_zzanh__super_TT);
                return new StringBuilder(((String.valueOf(valueOf).length() + 24) + String.valueOf(valueOf2).length()) + String.valueOf(valueOf3).length()).append("Factory[type=").append(valueOf).append("+").append(valueOf2).append(",adapter=").append(valueOf3).append("]").toString();
            }

            public <T> zzanh<T> zza(zzamp com_google_android_gms_internal_zzamp, zzaol<T> com_google_android_gms_internal_zzaol_T) {
                Class m = com_google_android_gms_internal_zzaol_T.m17303m();
                return (m == cls || m == cls2) ? com_google_android_gms_internal_zzanh__super_TT : null;
            }
        };
    }

    public static <TT> zzani zzb(final Class<TT> cls, final zzanh<TT> com_google_android_gms_internal_zzanh_TT) {
        return new zzani() {
            public String toString() {
                String valueOf = String.valueOf(cls.getName());
                String valueOf2 = String.valueOf(com_google_android_gms_internal_zzanh_TT);
                return new StringBuilder((String.valueOf(valueOf).length() + 32) + String.valueOf(valueOf2).length()).append("Factory[typeHierarchy=").append(valueOf).append(",adapter=").append(valueOf2).append("]").toString();
            }

            public <T> zzanh<T> zza(zzamp com_google_android_gms_internal_zzamp, zzaol<T> com_google_android_gms_internal_zzaol_T) {
                return cls.isAssignableFrom(com_google_android_gms_internal_zzaol_T.m17303m()) ? com_google_android_gms_internal_zzanh_TT : null;
            }
        };
    }

    public static <TT> zzani zzb(final Class<TT> cls, final Class<? extends TT> cls2, final zzanh<? super TT> com_google_android_gms_internal_zzanh__super_TT) {
        return new zzani() {
            public String toString() {
                String valueOf = String.valueOf(cls.getName());
                String valueOf2 = String.valueOf(cls2.getName());
                String valueOf3 = String.valueOf(com_google_android_gms_internal_zzanh__super_TT);
                return new StringBuilder(((String.valueOf(valueOf).length() + 24) + String.valueOf(valueOf2).length()) + String.valueOf(valueOf3).length()).append("Factory[type=").append(valueOf).append("+").append(valueOf2).append(",adapter=").append(valueOf3).append("]").toString();
            }

            public <T> zzanh<T> zza(zzamp com_google_android_gms_internal_zzamp, zzaol<T> com_google_android_gms_internal_zzaol_T) {
                Class m = com_google_android_gms_internal_zzaol_T.m17303m();
                return (m == cls || m == cls2) ? com_google_android_gms_internal_zzanh__super_TT : null;
            }
        };
    }
}
