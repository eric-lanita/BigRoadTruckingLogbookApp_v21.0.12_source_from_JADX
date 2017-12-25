package com.bigroad.shared;

import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class C1145t {
    public static void m5766a(File file, File file2) {
        Closeable fileOutputStream;
        Throwable th;
        Closeable closeable = null;
        if (file == null) {
            throw new NullPointerException("Source must not be null");
        } else if (file2 == null) {
            throw new NullPointerException("Destination must not be null");
        } else if (!file.exists()) {
            throw new FileNotFoundException("Source '" + file + "' does not exist");
        } else if (file.isDirectory()) {
            throw new IOException("Source '" + file + "' is a directory");
        } else {
            if (file2.exists()) {
                if (file2.isDirectory()) {
                    throw new IOException("Destination '" + file2 + "' is a directory");
                } else if (!file2.canWrite()) {
                    throw new IOException("Destination '" + file2 + "' is read only");
                }
            }
            if (file.getCanonicalPath().equals(file2.getCanonicalPath())) {
                throw new IOException("Source '" + file + "' and destination '" + file2 + "' are the same");
            }
            try {
                Closeable fileInputStream = new FileInputStream(file);
                try {
                    fileOutputStream = new FileOutputStream(file2);
                } catch (Throwable th2) {
                    th = th2;
                    fileOutputStream = null;
                    closeable = fileInputStream;
                    C1181z.m5999a(fileOutputStream);
                    C1181z.m5999a(closeable);
                    throw th;
                }
                try {
                    C1181z.m5998a(fileInputStream, fileOutputStream);
                    C1181z.m5999a(fileOutputStream);
                    C1181z.m5999a(fileInputStream);
                } catch (Throwable th3) {
                    th = th3;
                    closeable = fileInputStream;
                    C1181z.m5999a(fileOutputStream);
                    C1181z.m5999a(closeable);
                    throw th;
                }
            } catch (Throwable th4) {
                th = th4;
                fileOutputStream = null;
                C1181z.m5999a(fileOutputStream);
                C1181z.m5999a(closeable);
                throw th;
            }
        }
    }

    public static void m5768b(File file, File file2) {
        if (file == null) {
            throw new NullPointerException("Source must not be null");
        } else if (file2 == null) {
            throw new NullPointerException("Destination must not be null");
        } else if (file.exists()) {
            File[] listFiles = file.listFiles();
            if (listFiles == null) {
                throw new IOException("Failed to list contents of " + file);
            }
            if (file2.exists()) {
                if (!file2.isDirectory()) {
                    throw new IOException("Destination '" + file2 + "' exists but is not a directory");
                }
            } else if (!(file2.mkdirs() || file2.isDirectory())) {
                throw new IOException("Destination '" + file2 + "' directory cannot be created");
            }
            if (file2.canWrite()) {
                for (File file3 : listFiles) {
                    if (!file3.isDirectory()) {
                        C1145t.m5766a(file3, new File(file2, file3.getName()));
                    }
                }
                return;
            }
            throw new IOException("Destination '" + file2 + "' cannot be written to");
        } else {
            throw new FileNotFoundException("Source '" + file + "' does not exist");
        }
    }

    public static void m5767a(File[] fileArr) {
        if (fileArr != null) {
            for (File file : fileArr) {
                if (file.isDirectory()) {
                    C1145t.m5765a(file);
                }
                file.delete();
            }
        }
    }

    public static void m5765a(File file) {
        if (!C1145t.m5769b(file)) {
            C1145t.m5767a(file.listFiles());
        }
    }

    public static boolean m5769b(File file) {
        if (file == null || !file.exists() || !file.isDirectory()) {
            return true;
        }
        File[] listFiles = file.listFiles();
        if (listFiles == null || listFiles.length == 0) {
            return true;
        }
        return false;
    }
}
