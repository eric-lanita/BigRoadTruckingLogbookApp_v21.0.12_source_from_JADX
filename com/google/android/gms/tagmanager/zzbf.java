package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.zzaf;
import com.google.android.gms.internal.zzag;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class zzbf extends zzal {
    private static final String f12562a = zzaf.JOINER.toString();
    private static final String f12563b = zzag.ARG0.toString();
    private static final String f12564c = zzag.ITEM_SEPARATOR.toString();
    private static final String f12565d = zzag.KEY_VALUE_SEPARATOR.toString();
    private static final String f12566e = zzag.ESCAPE.toString();

    private enum zza {
        NONE,
        URL,
        BACKSLASH
    }

    public zzbf() {
        super(f12562a, f12563b);
    }

    private String m18098a(String str, zza com_google_android_gms_tagmanager_zzbf_zza, Set<Character> set) {
        switch (com_google_android_gms_tagmanager_zzbf_zza) {
            case URL:
                try {
                    return zzdp.m18220a(str);
                } catch (Throwable e) {
                    zzbn.zzb("Joiner: unsupported encoding", e);
                    return str;
                }
            case BACKSLASH:
                String replace = str.replace("\\", "\\\\");
                String str2 = replace;
                for (Character ch : set) {
                    CharSequence ch2 = ch.toString();
                    String str3 = "\\";
                    replace = String.valueOf(ch2);
                    str2 = str2.replace(ch2, replace.length() != 0 ? str3.concat(replace) : new String(str3));
                }
                return str2;
            default:
                return str;
        }
    }

    private void m18099a(StringBuilder stringBuilder, String str, zza com_google_android_gms_tagmanager_zzbf_zza, Set<Character> set) {
        stringBuilder.append(m18098a(str, com_google_android_gms_tagmanager_zzbf_zza, set));
    }

    private void m18100a(Set<Character> set, String str) {
        for (int i = 0; i < str.length(); i++) {
            set.add(Character.valueOf(str.charAt(i)));
        }
    }

    public com.google.android.gms.internal.zzai.zza zzav(Map<String, com.google.android.gms.internal.zzai.zza> map) {
        com.google.android.gms.internal.zzai.zza com_google_android_gms_internal_zzai_zza = (com.google.android.gms.internal.zzai.zza) map.get(f12563b);
        if (com_google_android_gms_internal_zzai_zza == null) {
            return zzdl.zzcdu();
        }
        zza com_google_android_gms_tagmanager_zzbf_zza;
        Set set;
        com.google.android.gms.internal.zzai.zza com_google_android_gms_internal_zzai_zza2 = (com.google.android.gms.internal.zzai.zza) map.get(f12564c);
        String zzg = com_google_android_gms_internal_zzai_zza2 != null ? zzdl.zzg(com_google_android_gms_internal_zzai_zza2) : "";
        com_google_android_gms_internal_zzai_zza2 = (com.google.android.gms.internal.zzai.zza) map.get(f12565d);
        String zzg2 = com_google_android_gms_internal_zzai_zza2 != null ? zzdl.zzg(com_google_android_gms_internal_zzai_zza2) : "=";
        zza com_google_android_gms_tagmanager_zzbf_zza2 = zza.NONE;
        com_google_android_gms_internal_zzai_zza2 = (com.google.android.gms.internal.zzai.zza) map.get(f12566e);
        if (com_google_android_gms_internal_zzai_zza2 != null) {
            String zzg3 = zzdl.zzg(com_google_android_gms_internal_zzai_zza2);
            if ("url".equals(zzg3)) {
                com_google_android_gms_tagmanager_zzbf_zza = zza.URL;
                set = null;
            } else if ("backslash".equals(zzg3)) {
                com_google_android_gms_tagmanager_zzbf_zza = zza.BACKSLASH;
                set = new HashSet();
                m18100a(set, zzg);
                m18100a(set, zzg2);
                set.remove(Character.valueOf('\\'));
            } else {
                zzg = "Joiner: unsupported escape type: ";
                String valueOf = String.valueOf(zzg3);
                zzbn.m18105e(valueOf.length() != 0 ? zzg.concat(valueOf) : new String(zzg));
                return zzdl.zzcdu();
            }
        }
        set = null;
        com_google_android_gms_tagmanager_zzbf_zza = com_google_android_gms_tagmanager_zzbf_zza2;
        StringBuilder stringBuilder = new StringBuilder();
        switch (com_google_android_gms_internal_zzai_zza.type) {
            case 2:
                Object obj = 1;
                com.google.android.gms.internal.zzai.zza[] com_google_android_gms_internal_zzai_zzaArr = com_google_android_gms_internal_zzai_zza.zzwu;
                int length = com_google_android_gms_internal_zzai_zzaArr.length;
                int i = 0;
                while (i < length) {
                    com.google.android.gms.internal.zzai.zza com_google_android_gms_internal_zzai_zza3 = com_google_android_gms_internal_zzai_zzaArr[i];
                    if (obj == null) {
                        stringBuilder.append(zzg);
                    }
                    m18099a(stringBuilder, zzdl.zzg(com_google_android_gms_internal_zzai_zza3), com_google_android_gms_tagmanager_zzbf_zza, set);
                    i++;
                    obj = null;
                }
                break;
            case 3:
                for (int i2 = 0; i2 < com_google_android_gms_internal_zzai_zza.zzwv.length; i2++) {
                    if (i2 > 0) {
                        stringBuilder.append(zzg);
                    }
                    String zzg4 = zzdl.zzg(com_google_android_gms_internal_zzai_zza.zzwv[i2]);
                    String zzg5 = zzdl.zzg(com_google_android_gms_internal_zzai_zza.zzww[i2]);
                    m18099a(stringBuilder, zzg4, com_google_android_gms_tagmanager_zzbf_zza, set);
                    stringBuilder.append(zzg2);
                    m18099a(stringBuilder, zzg5, com_google_android_gms_tagmanager_zzbf_zza, set);
                }
                break;
            default:
                m18099a(stringBuilder, zzdl.zzg(com_google_android_gms_internal_zzai_zza), com_google_android_gms_tagmanager_zzbf_zza, set);
                break;
        }
        return zzdl.zzap(stringBuilder.toString());
    }

    public boolean zzcag() {
        return true;
    }
}
