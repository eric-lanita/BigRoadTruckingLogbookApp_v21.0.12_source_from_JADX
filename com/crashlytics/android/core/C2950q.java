package com.crashlytics.android.core;

import android.content.Context;
import io.fabric.sdk.android.services.common.CommonUtils;
import io.fabric.sdk.android.services.settings.C4067o;

class C2950q {
    private final Context f10093a;
    private final C4067o f10094b;

    public C2950q(Context context, C4067o c4067o) {
        this.f10093a = context;
        this.f10094b = c4067o;
    }

    public String m16435a() {
        return m16432a("com.crashlytics.CrashSubmissionPromptTitle", this.f10094b.f14316a);
    }

    public String m16436b() {
        return m16432a("com.crashlytics.CrashSubmissionPromptMessage", this.f10094b.f14317b);
    }

    public String m16437c() {
        return m16432a("com.crashlytics.CrashSubmissionSendTitle", this.f10094b.f14318c);
    }

    public String m16438d() {
        return m16432a("com.crashlytics.CrashSubmissionAlwaysSendTitle", this.f10094b.f14322g);
    }

    public String m16439e() {
        return m16432a("com.crashlytics.CrashSubmissionCancelTitle", this.f10094b.f14320e);
    }

    private String m16432a(String str, String str2) {
        return m16434b(CommonUtils.m20711b(this.f10093a, str), str2);
    }

    private String m16434b(String str, String str2) {
        return m16433a(str) ? str2 : str;
    }

    private boolean m16433a(String str) {
        return str == null || str.length() == 0;
    }
}
