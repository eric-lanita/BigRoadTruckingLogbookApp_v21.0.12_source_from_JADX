package com.crashlytics.android.core;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.Comparator;

final class al {
    private static final FilenameFilter f9967a = new C28901();

    static class C28901 implements FilenameFilter {
        C28901() {
        }

        public boolean accept(File file, String str) {
            return true;
        }
    }

    static int m16249a(File file, int i, Comparator<File> comparator) {
        return m16250a(file, f9967a, i, comparator);
    }

    static int m16250a(File file, FilenameFilter filenameFilter, int i, Comparator<File> comparator) {
        int i2 = 0;
        File[] listFiles = file.listFiles(filenameFilter);
        if (listFiles != null) {
            int length = listFiles.length;
            Arrays.sort(listFiles, comparator);
            int length2 = listFiles.length;
            i2 = length;
            length = 0;
            while (length < length2) {
                File file2 = listFiles[length];
                if (i2 <= i) {
                    break;
                }
                file2.delete();
                length++;
                i2--;
            }
        }
        return i2;
    }
}
