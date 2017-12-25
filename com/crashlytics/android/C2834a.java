package com.crashlytics.android;

import com.crashlytics.android.answers.C2837a;
import com.crashlytics.android.core.C2939h;
import com.crashlytics.android.p044a.C2824c;
import io.fabric.sdk.android.C2822h;
import io.fabric.sdk.android.C2833i;
import io.fabric.sdk.android.C3969c;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class C2834a extends C2822h<Void> implements C2833i {
    public final C2837a f9783a;
    public final C2824c f9784b;
    public final C2939h f9785c;
    public final Collection<? extends C2822h> f9786d;

    protected /* synthetic */ Object mo1429f() {
        return m16008d();
    }

    public C2834a() {
        this(new C2837a(), new C2824c(), new C2939h());
    }

    C2834a(C2837a c2837a, C2824c c2824c, C2939h c2939h) {
        this.f9783a = c2837a;
        this.f9784b = c2824c;
        this.f9785c = c2939h;
        this.f9786d = Collections.unmodifiableCollection(Arrays.asList(new C2822h[]{c2837a, c2824c, c2939h}));
    }

    public String mo1426a() {
        return "2.6.8.dev";
    }

    public String mo1427b() {
        return "com.crashlytics.sdk.android:crashlytics";
    }

    public Collection<? extends C2822h> mo1432c() {
        return this.f9786d;
    }

    protected Void m16008d() {
        return null;
    }

    public static C2834a m16004e() {
        return (C2834a) C3969c.m20567a(C2834a.class);
    }
}
