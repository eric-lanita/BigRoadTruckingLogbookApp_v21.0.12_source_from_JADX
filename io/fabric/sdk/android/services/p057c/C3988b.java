package io.fabric.sdk.android.services.p057c;

import android.content.Context;
import io.fabric.sdk.android.C2822h;
import io.fabric.sdk.android.C3969c;
import java.io.File;

public class C3988b implements C3987a {
    private final Context f14101a;
    private final String f14102b;
    private final String f14103c;

    public C3988b(C2822h c2822h) {
        if (c2822h.m15970r() == null) {
            throw new IllegalStateException("Cannot get directory before context has been set. Call Fabric.with() first");
        }
        this.f14101a = c2822h.m15970r();
        this.f14102b = c2822h.m15972t();
        this.f14103c = "Android/" + this.f14101a.getPackageName();
    }

    public File mo2877a() {
        return m20676a(this.f14101a.getFilesDir());
    }

    File m20676a(File file) {
        if (file == null) {
            C3969c.m20576h().mo2849a("Fabric", "Null File");
        } else if (file.exists() || file.mkdirs()) {
            return file;
        } else {
            C3969c.m20576h().mo2854d("Fabric", "Couldn't create file");
        }
        return null;
    }
}
