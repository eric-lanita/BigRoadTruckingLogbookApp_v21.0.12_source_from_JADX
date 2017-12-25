package io.fabric.sdk.android.services.common;

public class C4015o {
    public static int m20815a(int i) {
        if (i >= 200 && i <= 299) {
            return 0;
        }
        if (i >= 300 && i <= 399) {
            return 1;
        }
        if (i >= 400 && i <= 499) {
            return 0;
        }
        if (i >= 500) {
            return 1;
        }
        return 1;
    }
}
