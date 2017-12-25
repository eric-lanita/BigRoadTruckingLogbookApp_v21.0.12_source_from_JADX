package com.google.android.gms.common.internal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class zzaa {

    public static final class zza {
        private final List<String> f10691a;
        private final Object f10692b;

        private zza(Object obj) {
            this.f10692b = zzab.zzy(obj);
            this.f10691a = new ArrayList();
        }

        public String toString() {
            StringBuilder append = new StringBuilder(100).append(this.f10692b.getClass().getSimpleName()).append('{');
            int size = this.f10691a.size();
            for (int i = 0; i < size; i++) {
                append.append((String) this.f10691a.get(i));
                if (i < size - 1) {
                    append.append(", ");
                }
            }
            return append.append('}').toString();
        }

        public zza zzg(String str, Object obj) {
            List list = this.f10691a;
            String str2 = (String) zzab.zzy(str);
            String valueOf = String.valueOf(String.valueOf(obj));
            list.add(new StringBuilder((String.valueOf(str2).length() + 1) + String.valueOf(valueOf).length()).append(str2).append("=").append(valueOf).toString());
            return this;
        }
    }

    public static boolean equal(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public static int hashCode(Object... objArr) {
        return Arrays.hashCode(objArr);
    }

    public static zza zzx(Object obj) {
        return new zza(obj);
    }
}
