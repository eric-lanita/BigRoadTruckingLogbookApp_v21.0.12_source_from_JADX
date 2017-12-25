package com.google.android.gms.common.internal;

import com.google.common.base.Ascii;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class zzf {
    public static final zzf xN = zza((CharSequence) "\t\n\u000b\f\r     　 ᠎ ").zza(zza(' ', ' '));
    public static final zzf xO = zza((CharSequence) "\t\n\u000b\f\r     　").zza(zza(' ', ' ')).zza(zza(' ', ' '));
    public static final zzf xP = zza('\u0000', Ascii.MAX);
    public static final zzf xQ;
    public static final zzf xR = zza('\t', '\r').zza(zza('\u001c', ' ')).zza(zzc(' ')).zza(zzc('᠎')).zza(zza(' ', ' ')).zza(zza(' ', '​')).zza(zza(' ', ' ')).zza(zzc(' ')).zza(zzc('　'));
    public static final zzf xS = new C32151();
    public static final zzf xT = new C32195();
    public static final zzf xU = new C32206();
    public static final zzf xV = new C32217();
    public static final zzf xW = new C32228();
    public static final zzf xX = zza('\u0000', '\u001f').zza(zza(Ascii.MAX, ''));
    public static final zzf xY = zza('\u0000', ' ').zza(zza(Ascii.MAX, ' ')).zza(zzc('­')).zza(zza('؀', '؃')).zza(zza((CharSequence) "۝܏ ឴឵᠎")).zza(zza(' ', '‏')).zza(zza(' ', ' ')).zza(zza(' ', '⁤')).zza(zza('⁪', '⁯')).zza(zzc('　')).zza(zza('?', '')).zza(zza((CharSequence) "﻿￹￺￻"));
    public static final zzf xZ = zza('\u0000', 'ӹ').zza(zzc('־')).zza(zza('א', 'ת')).zza(zzc('׳')).zza(zzc('״')).zza(zza('؀', 'ۿ')).zza(zza('ݐ', 'ݿ')).zza(zza('฀', '๿')).zza(zza('Ḁ', '₯')).zza(zza('℀', '℺')).zza(zza('ﭐ', '﷿')).zza(zza('ﹰ', '﻿')).zza(zza('｡', 'ￜ'));
    public static final zzf ya = new C32239();
    public static final zzf yb = new zzf() {
        public zzf zza(zzf com_google_android_gms_common_internal_zzf) {
            return (zzf) zzab.zzy(com_google_android_gms_common_internal_zzf);
        }

        public boolean zzb(CharSequence charSequence) {
            return charSequence.length() == 0;
        }

        public boolean zzd(char c) {
            return false;
        }
    };

    class AnonymousClass11 extends zzf {
        final /* synthetic */ char f10737a;

        AnonymousClass11(char c) {
            this.f10737a = c;
        }

        public zzf zza(zzf com_google_android_gms_common_internal_zzf) {
            return com_google_android_gms_common_internal_zzf.zzd(this.f10737a) ? com_google_android_gms_common_internal_zzf : super.zza(com_google_android_gms_common_internal_zzf);
        }

        public boolean zzd(char c) {
            return c == this.f10737a;
        }
    }

    class C32151 extends zzf {
        C32151() {
        }

        public boolean zzd(char c) {
            return Character.isDigit(c);
        }
    }

    class C32162 extends zzf {
        final /* synthetic */ char f10738a;
        final /* synthetic */ char f10739b;

        C32162(char c, char c2) {
            this.f10738a = c;
            this.f10739b = c2;
        }

        public boolean zzd(char c) {
            return c == this.f10738a || c == this.f10739b;
        }
    }

    class C32173 extends zzf {
        final /* synthetic */ char[] f10740a;

        C32173(char[] cArr) {
            this.f10740a = cArr;
        }

        public boolean zzd(char c) {
            return Arrays.binarySearch(this.f10740a, c) >= 0;
        }
    }

    class C32184 extends zzf {
        final /* synthetic */ char f10741a;
        final /* synthetic */ char f10742b;

        C32184(char c, char c2) {
            this.f10741a = c;
            this.f10742b = c2;
        }

        public boolean zzd(char c) {
            return this.f10741a <= c && c <= this.f10742b;
        }
    }

    class C32195 extends zzf {
        C32195() {
        }

        public boolean zzd(char c) {
            return Character.isLetter(c);
        }
    }

    class C32206 extends zzf {
        C32206() {
        }

        public boolean zzd(char c) {
            return Character.isLetterOrDigit(c);
        }
    }

    class C32217 extends zzf {
        C32217() {
        }

        public boolean zzd(char c) {
            return Character.isUpperCase(c);
        }
    }

    class C32228 extends zzf {
        C32228() {
        }

        public boolean zzd(char c) {
            return Character.isLowerCase(c);
        }
    }

    class C32239 extends zzf {
        C32239() {
        }

        public zzf zza(zzf com_google_android_gms_common_internal_zzf) {
            zzab.zzy(com_google_android_gms_common_internal_zzf);
            return this;
        }

        public boolean zzb(CharSequence charSequence) {
            zzab.zzy(charSequence);
            return true;
        }

        public boolean zzd(char c) {
            return true;
        }
    }

    private static class zza extends zzf {
        List<zzf> f10743a;

        zza(List<zzf> list) {
            this.f10743a = list;
        }

        public zzf zza(zzf com_google_android_gms_common_internal_zzf) {
            List arrayList = new ArrayList(this.f10743a);
            arrayList.add((zzf) zzab.zzy(com_google_android_gms_common_internal_zzf));
            return new zza(arrayList);
        }

        public boolean zzd(char c) {
            for (zzf zzd : this.f10743a) {
                if (zzd.zzd(c)) {
                    return true;
                }
            }
            return false;
        }
    }

    static {
        zzf zza = zza('0', '9');
        zzf com_google_android_gms_common_internal_zzf = zza;
        for (char c : "٠۰߀०০੦૦୦௦౦೦൦๐໐༠၀႐០᠐᥆᧐᭐᮰᱀᱐꘠꣐꤀꩐０".toCharArray()) {
            com_google_android_gms_common_internal_zzf = com_google_android_gms_common_internal_zzf.zza(zza(c, (char) (c + 9)));
        }
        xQ = com_google_android_gms_common_internal_zzf;
    }

    public static zzf zza(char c, char c2) {
        zzab.zzbo(c2 >= c);
        return new C32184(c, c2);
    }

    public static zzf zza(CharSequence charSequence) {
        switch (charSequence.length()) {
            case 0:
                return yb;
            case 1:
                return zzc(charSequence.charAt(0));
            case 2:
                return new C32162(charSequence.charAt(0), charSequence.charAt(1));
            default:
                char[] toCharArray = charSequence.toString().toCharArray();
                Arrays.sort(toCharArray);
                return new C32173(toCharArray);
        }
    }

    public static zzf zzc(char c) {
        return new AnonymousClass11(c);
    }

    public zzf zza(zzf com_google_android_gms_common_internal_zzf) {
        return new zza(Arrays.asList(new zzf[]{this, (zzf) zzab.zzy(com_google_android_gms_common_internal_zzf)}));
    }

    public boolean zzb(CharSequence charSequence) {
        for (int length = charSequence.length() - 1; length >= 0; length--) {
            if (!zzd(charSequence.charAt(length))) {
                return false;
            }
        }
        return true;
    }

    public abstract boolean zzd(char c);
}
