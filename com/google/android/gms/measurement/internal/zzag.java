package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.zzab;
import com.google.android.gms.internal.zzuf.zzf;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;

class zzag {
    final int f12233a;
    final boolean f12234b;
    final String f12235c;
    final List<String> f12236d;
    final String f12237e;
    final boolean f12238f;

    public zzag(zzf com_google_android_gms_internal_zzuf_zzf) {
        boolean z;
        boolean z2 = false;
        zzab.zzy(com_google_android_gms_internal_zzuf_zzf);
        if (com_google_android_gms_internal_zzuf_zzf.amV == null || com_google_android_gms_internal_zzuf_zzf.amV.intValue() == 0) {
            z = false;
        } else {
            if (com_google_android_gms_internal_zzuf_zzf.amV.intValue() == 6) {
                if (com_google_android_gms_internal_zzuf_zzf.amY == null || com_google_android_gms_internal_zzuf_zzf.amY.length == 0) {
                    z = false;
                }
            } else if (com_google_android_gms_internal_zzuf_zzf.amW == null) {
                z = false;
            }
            z = true;
        }
        if (z) {
            this.f12233a = com_google_android_gms_internal_zzuf_zzf.amV.intValue();
            if (com_google_android_gms_internal_zzuf_zzf.amX != null && com_google_android_gms_internal_zzuf_zzf.amX.booleanValue()) {
                z2 = true;
            }
            this.f12234b = z2;
            if (this.f12234b || this.f12233a == 1 || this.f12233a == 6) {
                this.f12235c = com_google_android_gms_internal_zzuf_zzf.amW;
            } else {
                this.f12235c = com_google_android_gms_internal_zzuf_zzf.amW.toUpperCase(Locale.ENGLISH);
            }
            this.f12236d = com_google_android_gms_internal_zzuf_zzf.amY == null ? null : m17793a(com_google_android_gms_internal_zzuf_zzf.amY, this.f12234b);
            if (this.f12233a == 1) {
                this.f12237e = this.f12235c;
            } else {
                this.f12237e = null;
            }
        } else {
            this.f12233a = 0;
            this.f12234b = false;
            this.f12235c = null;
            this.f12236d = null;
            this.f12237e = null;
        }
        this.f12238f = z;
    }

    private List<String> m17793a(String[] strArr, boolean z) {
        if (z) {
            return Arrays.asList(strArr);
        }
        List<String> arrayList = new ArrayList();
        for (String toUpperCase : strArr) {
            arrayList.add(toUpperCase.toUpperCase(Locale.ENGLISH));
        }
        return arrayList;
    }

    public Boolean zzmi(String str) {
        if (!this.f12238f || str == null) {
            return null;
        }
        if (!(this.f12234b || this.f12233a == 1)) {
            str = str.toUpperCase(Locale.ENGLISH);
        }
        switch (this.f12233a) {
            case 1:
                return Boolean.valueOf(Pattern.compile(this.f12237e, this.f12234b ? 0 : 66).matcher(str).matches());
            case 2:
                return Boolean.valueOf(str.startsWith(this.f12235c));
            case 3:
                return Boolean.valueOf(str.endsWith(this.f12235c));
            case 4:
                return Boolean.valueOf(str.contains(this.f12235c));
            case 5:
                return Boolean.valueOf(str.equals(this.f12235c));
            case 6:
                return Boolean.valueOf(this.f12236d.contains(str));
            default:
                return null;
        }
    }
}
