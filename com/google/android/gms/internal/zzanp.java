package com.google.android.gms.internal;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

public final class zzanp {
    private final Map<Type, zzamr<?>> f11215a;

    class C32722 implements zzanu<T> {
        final /* synthetic */ zzanp f11200a;

        C32722(zzanp com_google_android_gms_internal_zzanp) {
            this.f11200a = com_google_android_gms_internal_zzanp;
        }

        public T zzczu() {
            return new LinkedHashMap();
        }
    }

    class C32733 implements zzanu<T> {
        final /* synthetic */ zzanp f11201a;

        C32733(zzanp com_google_android_gms_internal_zzanp) {
            this.f11201a = com_google_android_gms_internal_zzanp;
        }

        public T zzczu() {
            return new zzant();
        }
    }

    class C32777 implements zzanu<T> {
        final /* synthetic */ zzanp f11211a;

        C32777(zzanp com_google_android_gms_internal_zzanp) {
            this.f11211a = com_google_android_gms_internal_zzanp;
        }

        public T zzczu() {
            return new TreeSet();
        }
    }

    class C32799 implements zzanu<T> {
        final /* synthetic */ zzanp f11214a;

        C32799(zzanp com_google_android_gms_internal_zzanp) {
            this.f11214a = com_google_android_gms_internal_zzanp;
        }

        public T zzczu() {
            return new LinkedHashSet();
        }
    }

    public zzanp(Map<Type, zzamr<?>> map) {
        this.f11215a = map;
    }

    private <T> zzanu<T> m17206a(Class<? super T> cls) {
        try {
            final Constructor declaredConstructor = cls.getDeclaredConstructor(new Class[0]);
            if (!declaredConstructor.isAccessible()) {
                declaredConstructor.setAccessible(true);
            }
            return new zzanu<T>(this) {
                final /* synthetic */ zzanp f11210b;

                public T zzczu() {
                    String valueOf;
                    try {
                        return declaredConstructor.newInstance(null);
                    } catch (Throwable e) {
                        valueOf = String.valueOf(declaredConstructor);
                        throw new RuntimeException(new StringBuilder(String.valueOf(valueOf).length() + 30).append("Failed to invoke ").append(valueOf).append(" with no args").toString(), e);
                    } catch (InvocationTargetException e2) {
                        valueOf = String.valueOf(declaredConstructor);
                        throw new RuntimeException(new StringBuilder(String.valueOf(valueOf).length() + 30).append("Failed to invoke ").append(valueOf).append(" with no args").toString(), e2.getTargetException());
                    } catch (IllegalAccessException e3) {
                        throw new AssertionError(e3);
                    }
                }
            };
        } catch (NoSuchMethodException e) {
            return null;
        }
    }

    private <T> zzanu<T> m17207a(final Type type, Class<? super T> cls) {
        return Collection.class.isAssignableFrom(cls) ? SortedSet.class.isAssignableFrom(cls) ? new C32777(this) : EnumSet.class.isAssignableFrom(cls) ? new zzanu<T>(this) {
            final /* synthetic */ zzanp f11213b;

            public T zzczu() {
                if (type instanceof ParameterizedType) {
                    Type type = ((ParameterizedType) type).getActualTypeArguments()[0];
                    if (type instanceof Class) {
                        return EnumSet.noneOf((Class) type);
                    }
                    String str = "Invalid EnumSet type: ";
                    String valueOf = String.valueOf(type.toString());
                    throw new zzamw(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
                }
                str = "Invalid EnumSet type: ";
                valueOf = String.valueOf(type.toString());
                throw new zzamw(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
            }
        } : Set.class.isAssignableFrom(cls) ? new C32799(this) : Queue.class.isAssignableFrom(cls) ? new zzanu<T>(this) {
            final /* synthetic */ zzanp f11194a;

            {
                this.f11194a = r1;
            }

            public T zzczu() {
                return new LinkedList();
            }
        } : new zzanu<T>(this) {
            final /* synthetic */ zzanp f11195a;

            {
                this.f11195a = r1;
            }

            public T zzczu() {
                return new ArrayList();
            }
        } : Map.class.isAssignableFrom(cls) ? SortedMap.class.isAssignableFrom(cls) ? new zzanu<T>(this) {
            final /* synthetic */ zzanp f11196a;

            {
                this.f11196a = r1;
            }

            public T zzczu() {
                return new TreeMap();
            }
        } : (!(type instanceof ParameterizedType) || String.class.isAssignableFrom(zzaol.zzl(((ParameterizedType) type).getActualTypeArguments()[0]).m17303m())) ? new C32733(this) : new C32722(this) : null;
    }

    private <T> zzanu<T> m17208b(final Type type, final Class<? super T> cls) {
        return new zzanu<T>(this) {
            final /* synthetic */ zzanp f11204c;
            private final zzanx f11205d = zzanx.zzczz();

            public T zzczu() {
                try {
                    return this.f11205d.zzf(cls);
                } catch (Throwable e) {
                    String valueOf = String.valueOf(type);
                    throw new RuntimeException(new StringBuilder(String.valueOf(valueOf).length() + 116).append("Unable to invoke no-args constructor for ").append(valueOf).append(". ").append("Register an InstanceCreator with Gson for this type may fix this problem.").toString(), e);
                }
            }
        };
    }

    public String toString() {
        return this.f11215a.toString();
    }

    public <T> zzanu<T> zzb(zzaol<T> com_google_android_gms_internal_zzaol_T) {
        final Type n = com_google_android_gms_internal_zzaol_T.m17304n();
        Class m = com_google_android_gms_internal_zzaol_T.m17303m();
        final zzamr com_google_android_gms_internal_zzamr = (zzamr) this.f11215a.get(n);
        if (com_google_android_gms_internal_zzamr != null) {
            return new zzanu<T>(this) {
                final /* synthetic */ zzanp f11199c;

                public T zzczu() {
                    return com_google_android_gms_internal_zzamr.zza(n);
                }
            };
        }
        com_google_android_gms_internal_zzamr = (zzamr) this.f11215a.get(m);
        if (com_google_android_gms_internal_zzamr != null) {
            return new zzanu<T>(this) {
                final /* synthetic */ zzanp f11208c;

                public T zzczu() {
                    return com_google_android_gms_internal_zzamr.zza(n);
                }
            };
        }
        zzanu<T> a = m17206a(m);
        if (a != null) {
            return a;
        }
        a = m17207a(n, m);
        return a == null ? m17208b(n, m) : a;
    }
}
