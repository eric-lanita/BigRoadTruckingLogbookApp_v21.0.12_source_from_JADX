package com.google.protobuf;

import com.google.protobuf.C2487l.C2482a;
import com.google.protobuf.C2488a.C2483a;
import com.google.protobuf.C3647f.C3630a;
import com.google.protobuf.C3648g.C2498b;
import com.google.protobuf.C3648g.C2500a;
import com.google.protobuf.WireFormat.FieldType;
import com.google.protobuf.WireFormat.JavaType;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.util.Collections;

public abstract class GeneratedMessageLite extends C2488a implements Serializable {
    private static final long serialVersionUID = 1;

    public static abstract class C2484a<MessageType extends GeneratedMessageLite, BuilderType extends C2484a> extends C2483a<BuilderType> {
        public /* synthetic */ Object clone() {
            return mo1364f();
        }

        public /* synthetic */ C2483a mo1362h() {
            return mo1364f();
        }

        protected C2484a() {
        }

        public BuilderType mo1365g() {
            return this;
        }

        public BuilderType mo1364f() {
            throw new UnsupportedOperationException("This is supposed to be overridden by subclasses.");
        }
    }

    static final class SerializedForm implements Serializable {
        private static final long serialVersionUID = 0;
        private byte[] asBytes;
        private String messageClassName;

        SerializedForm(C2487l c2487l) {
            this.messageClassName = c2487l.getClass().getName();
            this.asBytes = c2487l.toByteArray();
        }

        protected Object readResolve() {
            try {
                C2482a c2482a = (C2482a) Class.forName(this.messageClassName).getMethod("newBuilder", new Class[0]).invoke(null, new Object[0]);
                c2482a.mo1359b(this.asBytes);
                return c2482a.mo1366i();
            } catch (Throwable e) {
                throw new RuntimeException("Unable to find proto buffer class", e);
            } catch (Throwable e2) {
                throw new RuntimeException("Unable to find newBuilder method", e2);
            } catch (Throwable e22) {
                throw new RuntimeException("Unable to call newBuilder method", e22);
            } catch (InvocationTargetException e3) {
                throw new RuntimeException("Error calling newBuilder", e3.getCause());
            } catch (Throwable e222) {
                throw new RuntimeException("Unable to understand proto buffer", e222);
            }
        }
    }

    private static final class C3631b implements C3630a<C3631b> {
        private final C2498b<?> f13165a;
        private final int f13166b;
        private final FieldType f13167c;
        private final boolean f13168d;
        private final boolean f13169e;

        public /* synthetic */ int compareTo(Object obj) {
            return m19044a((C3631b) obj);
        }

        private C3631b(C2498b<?> c2498b, int i, FieldType fieldType, boolean z, boolean z2) {
            this.f13165a = c2498b;
            this.f13166b = i;
            this.f13167c = fieldType;
            this.f13168d = z;
            this.f13169e = z2;
        }

        public int m19047c() {
            return this.f13166b;
        }

        public FieldType mo2742a() {
            return this.f13167c;
        }

        public JavaType m19048d() {
            return this.f13167c.m19064a();
        }

        public boolean mo2743b() {
            return this.f13168d;
        }

        public C2498b<?> m19049e() {
            return this.f13165a;
        }

        public int m19044a(C3631b c3631b) {
            return this.f13166b - c3631b.f13166b;
        }
    }

    public static final class C3632c<ContainingType extends C2487l, Type> {
        private final ContainingType f13170a;
        private final Type f13171b;
        private final C2487l f13172c;
        private final C3631b f13173d;

        private C3632c(ContainingType containingType, Type type, C2487l c2487l, C3631b c3631b) {
            if (containingType == null) {
                throw new IllegalArgumentException("Null containingTypeDefaultInstance");
            } else if (c3631b.mo2742a() == FieldType.MESSAGE && c2487l == null) {
                throw new IllegalArgumentException("Null messageDefaultInstance");
            } else {
                this.f13170a = containingType;
                this.f13171b = type;
                this.f13172c = c2487l;
                this.f13173d = c3631b;
            }
        }

        public int m19052a() {
            return this.f13173d.m19047c();
        }
    }

    protected GeneratedMessageLite() {
    }

    protected GeneratedMessageLite(C2484a c2484a) {
    }

    public C2478n<? extends C2487l> getParserForType() {
        throw new UnsupportedOperationException("This is supposed to be overridden by subclasses.");
    }

    protected boolean parseUnknownField(C3643d c3643d, C3645e c3645e, int i) {
        return c3643d.m19112b(i);
    }

    protected void makeExtensionsImmutable() {
    }

    private static <MessageType extends C2487l> boolean parseUnknownField(C3647f<C3631b> c3647f, MessageType messageType, C3643d c3643d, C3645e c3645e, int i) {
        boolean z;
        boolean z2 = false;
        int a = WireFormat.m19071a(i);
        C3632c a2 = c3645e.m19141a(messageType, WireFormat.m19073b(i));
        if (a2 == null) {
            z = true;
        } else if (a == C3647f.m19142a(a2.f13173d.mo2742a(), false)) {
            z = false;
        } else if (a2.f13173d.f13168d && a2.f13173d.f13167c.mo2744c() && a == C3647f.m19142a(a2.f13173d.mo2742a(), true)) {
            z = false;
            z2 = true;
        } else {
            z = true;
        }
        if (z) {
            return c3643d.m19112b(i);
        }
        if (z2) {
            int d = c3643d.m19115d(c3643d.m19133s());
            if (a2.f13173d.mo2742a() == FieldType.ENUM) {
                while (c3643d.m19137w() > 0) {
                    C2500a b = a2.f13173d.m19049e().mo1376b(c3643d.m19128n());
                    if (b == null) {
                        return true;
                    }
                    c3647f.m19149b(a2.f13173d, b);
                }
            } else {
                while (c3643d.m19137w() > 0) {
                    c3647f.m19149b(a2.f13173d, C3647f.m19144a(c3643d, a2.f13173d.mo2742a()));
                }
            }
            c3643d.m19117e(d);
        } else {
            Object j;
            switch (a2.f13173d.m19048d()) {
                case MESSAGE:
                    C2482a toBuilder;
                    if (!a2.f13173d.mo2743b()) {
                        C2487l c2487l = (C2487l) c3647f.m19146a(a2.f13173d);
                        if (c2487l != null) {
                            toBuilder = c2487l.toBuilder();
                            if (toBuilder == null) {
                                toBuilder = a2.f13172c.newBuilderForType();
                            }
                            if (a2.f13173d.mo2742a() != FieldType.GROUP) {
                                c3643d.m19109a(a2.m19052a(), toBuilder, c3645e);
                            } else {
                                c3643d.m19110a(toBuilder, c3645e);
                            }
                            j = toBuilder.mo1368j();
                            break;
                        }
                    }
                    toBuilder = null;
                    if (toBuilder == null) {
                        toBuilder = a2.f13172c.newBuilderForType();
                    }
                    if (a2.f13173d.mo2742a() != FieldType.GROUP) {
                        c3643d.m19110a(toBuilder, c3645e);
                    } else {
                        c3643d.m19109a(a2.m19052a(), toBuilder, c3645e);
                    }
                    j = toBuilder.mo1368j();
                case ENUM:
                    j = a2.f13173d.m19049e().mo1376b(c3643d.m19128n());
                    if (j == null) {
                        return true;
                    }
                    break;
                default:
                    j = C3647f.m19144a(c3643d, a2.f13173d.mo2742a());
                    break;
            }
            if (a2.f13173d.mo2743b()) {
                c3647f.m19149b(a2.f13173d, j);
            } else {
                c3647f.m19147a(a2.f13173d, j);
            }
        }
        return true;
    }

    public static <ContainingType extends C2487l, Type> C3632c<ContainingType, Type> newSingularGeneratedExtension(ContainingType containingType, Type type, C2487l c2487l, C2498b<?> c2498b, int i, FieldType fieldType) {
        return new C3632c(containingType, type, c2487l, new C3631b(c2498b, i, fieldType, false, false));
    }

    public static <ContainingType extends C2487l, Type> C3632c<ContainingType, Type> newRepeatedGeneratedExtension(ContainingType containingType, C2487l c2487l, C2498b<?> c2498b, int i, FieldType fieldType, boolean z) {
        return new C3632c(containingType, Collections.emptyList(), c2487l, new C3631b(c2498b, i, fieldType, true, z));
    }

    protected Object writeReplace() {
        return new SerializedForm(this);
    }
}
