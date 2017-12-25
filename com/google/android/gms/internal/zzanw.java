package com.google.android.gms.internal;

import java.io.Writer;

public final class zzanw {

    private static final class zza extends Writer {
        private final Appendable f11248a;
        private final zza f11249b;

        static class zza implements CharSequence {
            char[] f11247a;

            zza() {
            }

            public char charAt(int i) {
                return this.f11247a[i];
            }

            public int length() {
                return this.f11247a.length;
            }

            public CharSequence subSequence(int i, int i2) {
                return new String(this.f11247a, i, i2 - i);
            }
        }

        private zza(Appendable appendable) {
            this.f11249b = new zza();
            this.f11248a = appendable;
        }

        public void close() {
        }

        public void flush() {
        }

        public void write(int i) {
            this.f11248a.append((char) i);
        }

        public void write(char[] cArr, int i, int i2) {
            this.f11249b.f11247a = cArr;
            this.f11248a.append(this.f11249b, i, i + i2);
        }
    }

    public static Writer zza(Appendable appendable) {
        return appendable instanceof Writer ? (Writer) appendable : new zza(appendable);
    }

    public static void zzb(zzamv com_google_android_gms_internal_zzamv, zzaoo com_google_android_gms_internal_zzaoo) {
        zzaok.bgM.zza(com_google_android_gms_internal_zzaoo, com_google_android_gms_internal_zzamv);
    }

    public static zzamv zzh(zzaom com_google_android_gms_internal_zzaom) {
        Object obj = 1;
        try {
            com_google_android_gms_internal_zzaom.mo1835b();
            obj = null;
            return (zzamv) zzaok.bgM.zzb(com_google_android_gms_internal_zzaom);
        } catch (Throwable e) {
            if (obj != null) {
                return zzamx.bei;
            }
            throw new zzane(e);
        } catch (Throwable e2) {
            throw new zzane(e2);
        } catch (Throwable e22) {
            throw new zzamw(e22);
        } catch (Throwable e222) {
            throw new zzane(e222);
        }
    }
}
