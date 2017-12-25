package com.crashlytics.android.core;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;

class C2894d extends FileOutputStream {
    public static final FilenameFilter f9977a = new C28931();
    private final String f9978b;
    private File f9979c;
    private File f9980d;
    private boolean f9981e = false;

    static class C28931 implements FilenameFilter {
        C28931() {
        }

        public boolean accept(File file, String str) {
            return str.endsWith(".cls_temp");
        }
    }

    public C2894d(File file, String str) {
        super(new File(file, str + ".cls_temp"));
        this.f9978b = file + File.separator + str;
        this.f9979c = new File(this.f9978b + ".cls_temp");
    }

    public synchronized void close() {
        if (!this.f9981e) {
            this.f9981e = true;
            super.flush();
            super.close();
            File file = new File(this.f9978b + ".cls");
            if (this.f9979c.renameTo(file)) {
                this.f9979c = null;
                this.f9980d = file;
            } else {
                String str = "";
                if (file.exists()) {
                    str = " (target already exists)";
                } else if (!this.f9979c.exists()) {
                    str = " (source does not exist)";
                }
                throw new IOException("Could not rename temp file: " + this.f9979c + " -> " + file + str);
            }
        }
    }

    public void m16262a() {
        if (!this.f9981e) {
            this.f9981e = true;
            super.flush();
            super.close();
        }
    }
}
