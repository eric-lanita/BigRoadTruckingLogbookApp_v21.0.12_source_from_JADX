package com.google.android.gms.flags.impl;

import android.content.SharedPreferences;
import com.google.android.gms.internal.zzua;
import java.util.concurrent.Callable;

public abstract class zza<T> {

    public static class zza extends zza<Boolean> {

        class C32381 implements Callable<Boolean> {
            final /* synthetic */ SharedPreferences f10954a;
            final /* synthetic */ String f10955b;
            final /* synthetic */ Boolean f10956c;

            C32381(SharedPreferences sharedPreferences, String str, Boolean bool) {
                this.f10954a = sharedPreferences;
                this.f10955b = str;
                this.f10956c = bool;
            }

            public /* synthetic */ Object call() {
                return zztn();
            }

            public Boolean zztn() {
                return Boolean.valueOf(this.f10954a.getBoolean(this.f10955b, this.f10956c.booleanValue()));
            }
        }

        public static Boolean zza(SharedPreferences sharedPreferences, String str, Boolean bool) {
            return (Boolean) zzua.zzb(new C32381(sharedPreferences, str, bool));
        }
    }

    public static class zzb extends zza<Integer> {

        class C32391 implements Callable<Integer> {
            final /* synthetic */ SharedPreferences f10957a;
            final /* synthetic */ String f10958b;
            final /* synthetic */ Integer f10959c;

            C32391(SharedPreferences sharedPreferences, String str, Integer num) {
                this.f10957a = sharedPreferences;
                this.f10958b = str;
                this.f10959c = num;
            }

            public /* synthetic */ Object call() {
                return zzbev();
            }

            public Integer zzbev() {
                return Integer.valueOf(this.f10957a.getInt(this.f10958b, this.f10959c.intValue()));
            }
        }

        public static Integer zza(SharedPreferences sharedPreferences, String str, Integer num) {
            return (Integer) zzua.zzb(new C32391(sharedPreferences, str, num));
        }
    }

    public static class zzc extends zza<Long> {

        class C32401 implements Callable<Long> {
            final /* synthetic */ SharedPreferences f10960a;
            final /* synthetic */ String f10961b;
            final /* synthetic */ Long f10962c;

            C32401(SharedPreferences sharedPreferences, String str, Long l) {
                this.f10960a = sharedPreferences;
                this.f10961b = str;
                this.f10962c = l;
            }

            public /* synthetic */ Object call() {
                return zzbew();
            }

            public Long zzbew() {
                return Long.valueOf(this.f10960a.getLong(this.f10961b, this.f10962c.longValue()));
            }
        }

        public static Long zza(SharedPreferences sharedPreferences, String str, Long l) {
            return (Long) zzua.zzb(new C32401(sharedPreferences, str, l));
        }
    }

    public static class zzd extends zza<String> {

        class C32411 implements Callable<String> {
            final /* synthetic */ SharedPreferences f10963a;
            final /* synthetic */ String f10964b;
            final /* synthetic */ String f10965c;

            C32411(SharedPreferences sharedPreferences, String str, String str2) {
                this.f10963a = sharedPreferences;
                this.f10964b = str;
                this.f10965c = str2;
            }

            public /* synthetic */ Object call() {
                return zzaba();
            }

            public String zzaba() {
                return this.f10963a.getString(this.f10964b, this.f10965c);
            }
        }

        public static String zza(SharedPreferences sharedPreferences, String str, String str2) {
            return (String) zzua.zzb(new C32411(sharedPreferences, str, str2));
        }
    }
}
