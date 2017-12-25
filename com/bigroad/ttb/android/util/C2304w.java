package com.bigroad.ttb.android.util;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import com.bigroad.shared.C1181z;
import com.bigroad.ttb.android.OurApplication;
import com.bigroad.ttb.android.activity.C1632a;
import com.bigroad.ttb.android.logging.C2128b;
import com.bigroad.ttb.android.logging.C2134e;
import com.bigroad.ttb.android.logging.C2135f;
import java.io.Closeable;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class C2304w {
    public static void m11272a(Activity activity, String str) {
        File a = C2304w.m11271a(str);
        if (a != null) {
            try {
                Intent intent = new Intent("android.intent.action.SEND");
                intent.putExtra("android.intent.extra.EMAIL", new String[]{"support@bigroad.com"});
                intent.putExtra("android.intent.extra.SUBJECT", C2135f.f7457a);
                intent.putExtra("android.intent.extra.STREAM", OurApplication.m6271a(a));
                intent.setType("message/rfc822");
                activity.startActivity(intent);
                return;
            } catch (ActivityNotFoundException e) {
                C2134e.m10682e(str, e.getMessage());
            }
        }
        C1632a.m7949a((Context) activity, OurApplication.aq());
    }

    private static File m11271a(String str) {
        Closeable fileWriter;
        IOException e;
        Throwable th;
        C2128b c2128b = OurApplication.f4123a;
        try {
            File ao = OurApplication.ao();
            if (ao.exists()) {
                File file = new File(ao, "log.txt");
                if (!file.exists()) {
                    file.createNewFile();
                }
                if (file.canWrite()) {
                    fileWriter = new FileWriter(file, false);
                    try {
                        fileWriter.write("Log: " + C2135f.f7457a + "\n");
                        fileWriter.write(c2128b.toString());
                        C1181z.m5999a(fileWriter);
                        return file;
                    } catch (IOException e2) {
                        e = e2;
                        try {
                            Log.d(str, e.getMessage());
                            C1181z.m5999a(fileWriter);
                            return null;
                        } catch (Throwable th2) {
                            th = th2;
                            C1181z.m5999a(fileWriter);
                            throw th;
                        }
                    }
                }
                Log.d(str, "Can't write.");
                C1181z.m5999a(null);
                return null;
            }
            C1181z.m5999a(null);
            return null;
        } catch (IOException e3) {
            e = e3;
            fileWriter = null;
            Log.d(str, e.getMessage());
            C1181z.m5999a(fileWriter);
            return null;
        } catch (Throwable th3) {
            fileWriter = null;
            th = th3;
            C1181z.m5999a(fileWriter);
            throw th;
        }
    }
}
