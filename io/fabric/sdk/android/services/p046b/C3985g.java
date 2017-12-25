package io.fabric.sdk.android.services.p046b;

import android.content.Context;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.zip.GZIPOutputStream;

public class C3985g extends C3984h {
    public C3985g(Context context, File file, String str, String str2) {
        super(context, file, str, str2);
    }

    public OutputStream mo2876a(File file) {
        return new GZIPOutputStream(new FileOutputStream(file));
    }
}
