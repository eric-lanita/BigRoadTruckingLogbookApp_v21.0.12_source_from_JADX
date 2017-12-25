package com.urbanairship.actions;

import android.os.Build.VERSION;
import com.urbanairship.C3929q;

public class C3722q extends C3709l {
    public boolean mo2769b(C3694b c3694b) {
        if (C3929q.m20372a().m20399w() == 2 && VERSION.SDK_INT >= 19) {
            return super.mo2769b(c3694b);
        }
        return false;
    }
}
