package io.fabric.sdk.android.services.p046b;

import android.content.Context;
import io.fabric.sdk.android.services.common.C4014n;
import io.fabric.sdk.android.services.common.CommonUtils;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class C3984h implements C3983c {
    private final Context f14093a;
    private final File f14094b;
    private final String f14095c;
    private final File f14096d;
    private C4014n f14097e = new C4014n(this.f14096d);
    private File f14098f;

    public C3984h(Context context, File file, String str, String str2) {
        this.f14093a = context;
        this.f14094b = file;
        this.f14095c = str2;
        this.f14096d = new File(this.f14094b, str);
        m20662e();
    }

    private void m20662e() {
        this.f14098f = new File(this.f14094b, this.f14095c);
        if (!this.f14098f.exists()) {
            this.f14098f.mkdirs();
        }
    }

    public void mo2871a(byte[] bArr) {
        this.f14097e.m20809a(bArr);
    }

    public int mo2867a() {
        return this.f14097e.m20807a();
    }

    public void mo2869a(String str) {
        this.f14097e.close();
        m20661a(this.f14096d, new File(this.f14098f, str));
        this.f14097e = new C4014n(this.f14096d);
    }

    private void m20661a(File file, File file2) {
        Closeable fileInputStream;
        Throwable th;
        Closeable closeable = null;
        try {
            fileInputStream = new FileInputStream(file);
            try {
                closeable = mo2876a(file2);
                CommonUtils.m20706a((InputStream) fileInputStream, (OutputStream) closeable, new byte[1024]);
                CommonUtils.m20704a(fileInputStream, "Failed to close file input stream");
                CommonUtils.m20704a(closeable, "Failed to close output stream");
                file.delete();
            } catch (Throwable th2) {
                th = th2;
                CommonUtils.m20704a(fileInputStream, "Failed to close file input stream");
                CommonUtils.m20704a(closeable, "Failed to close output stream");
                file.delete();
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            fileInputStream = null;
            CommonUtils.m20704a(fileInputStream, "Failed to close file input stream");
            CommonUtils.m20704a(closeable, "Failed to close output stream");
            file.delete();
            throw th;
        }
    }

    public OutputStream mo2876a(File file) {
        return new FileOutputStream(file);
    }

    public List<File> mo2868a(int i) {
        List<File> arrayList = new ArrayList();
        for (Object add : this.f14098f.listFiles()) {
            arrayList.add(add);
            if (arrayList.size() >= i) {
                break;
            }
        }
        return arrayList;
    }

    public void mo2870a(List<File> list) {
        for (File file : list) {
            CommonUtils.m20701a(this.f14093a, String.format("deleting sent analytics file %s", new Object[]{file.getName()}));
            file.delete();
        }
    }

    public List<File> mo2874c() {
        return Arrays.asList(this.f14098f.listFiles());
    }

    public void mo2875d() {
        try {
            this.f14097e.close();
        } catch (IOException e) {
        }
        this.f14096d.delete();
    }

    public boolean mo2873b() {
        return this.f14097e.m20812b();
    }

    public boolean mo2872a(int i, int i2) {
        return this.f14097e.m20811a(i, i2);
    }
}
