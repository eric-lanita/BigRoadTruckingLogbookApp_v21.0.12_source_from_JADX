package android.support.v4.app;

import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.app.aq.C0174a;
import android.support.v4.app.aq.C0174a.C0167a;
import android.util.Log;

public final class ao extends C0174a {
    public static final C0167a f592a = new C01681();
    private static final C0170b f593g;
    private final String f594b;
    private final CharSequence f595c;
    private final CharSequence[] f596d;
    private final boolean f597e;
    private final Bundle f598f;

    static class C01681 implements C0167a {
        C01681() {
        }
    }

    public static final class C0169a {
        private final String f587a;
        private CharSequence f588b;
        private CharSequence[] f589c;
        private boolean f590d = true;
        private Bundle f591e = new Bundle();

        public C0169a(String str) {
            if (str == null) {
                throw new IllegalArgumentException("Result key can't be null");
            }
            this.f587a = str;
        }

        public C0169a m748a(CharSequence charSequence) {
            this.f588b = charSequence;
            return this;
        }

        public C0169a m750a(CharSequence[] charSequenceArr) {
            this.f589c = charSequenceArr;
            return this;
        }

        public C0169a m749a(boolean z) {
            this.f590d = z;
            return this;
        }

        public C0169a m747a(Bundle bundle) {
            if (bundle != null) {
                this.f591e.putAll(bundle);
            }
            return this;
        }

        public ao m751a() {
            return new ao(this.f587a, this.f588b, this.f589c, this.f590d, this.f591e);
        }
    }

    interface C0170b {
        Bundle mo129a(Intent intent);
    }

    static class C0171c implements C0170b {
        C0171c() {
        }

        public Bundle mo129a(Intent intent) {
            return ap.m767a(intent);
        }
    }

    static class C0172d implements C0170b {
        C0172d() {
        }

        public Bundle mo129a(Intent intent) {
            Log.w("RemoteInput", "RemoteInput is only supported from API Level 16");
            return null;
        }
    }

    static class C0173e implements C0170b {
        C0173e() {
        }

        public Bundle mo129a(Intent intent) {
            return ar.m769a(intent);
        }
    }

    private ao(String str, CharSequence charSequence, CharSequence[] charSequenceArr, boolean z, Bundle bundle) {
        this.f594b = str;
        this.f595c = charSequence;
        this.f596d = charSequenceArr;
        this.f597e = z;
        this.f598f = bundle;
    }

    public String mo130a() {
        return this.f594b;
    }

    public CharSequence mo131b() {
        return this.f595c;
    }

    public CharSequence[] mo132c() {
        return this.f596d;
    }

    public boolean mo133d() {
        return this.f597e;
    }

    public Bundle mo134e() {
        return this.f598f;
    }

    public static Bundle m761a(Intent intent) {
        return f593g.mo129a(intent);
    }

    static {
        if (VERSION.SDK_INT >= 20) {
            f593g = new C0171c();
        } else if (VERSION.SDK_INT >= 16) {
            f593g = new C0173e();
        } else {
            f593g = new C0172d();
        }
    }
}
