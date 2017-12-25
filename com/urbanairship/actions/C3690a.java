package com.urbanairship.actions;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import com.urbanairship.C3783j;
import com.urbanairship.C3929q;

public abstract class C3690a {
    public abstract C3701e mo2770d(C3694b c3694b);

    final C3701e m19346a(C3694b c3694b) {
        try {
            if (mo2769b(c3694b)) {
                C3783j.m19727d("Running action: " + this + " arguments: " + c3694b);
                m19350c(c3694b);
                C3701e d = mo2770d(c3694b);
                if (d == null) {
                    d = C3701e.m19372a();
                }
                m19347a(c3694b, d);
                return d;
            }
            C3783j.m19725c("Action " + this + " is unable to accept arguments: " + c3694b);
            return C3701e.m19373a(2);
        } catch (Exception e) {
            C3783j.m19726c("Failed to run action " + this, e);
            return C3701e.m19375a(e);
        }
    }

    public boolean mo2769b(C3694b c3694b) {
        return true;
    }

    public void m19350c(C3694b c3694b) {
    }

    public void m19347a(C3694b c3694b, C3701e c3701e) {
    }

    @TargetApi(23)
    public final int[] m19348a(String... strArr) {
        int i = 0;
        Context h = C3929q.m20382h();
        Object obj = new int[strArr.length];
        int i2 = 0;
        while (i < obj.length) {
            obj[i] = h.checkSelfPermission(strArr[i]);
            if (obj[i] == -1) {
                i2 = 1;
            }
            i++;
        }
        if (i2 == 0) {
            return obj;
        }
        Intent putExtra = new Intent(h, ActionActivity.class).addFlags(268435456).setPackage(C3929q.m20374b()).putExtra("com.urbanairship.actions.actionactivity.PERMISSIONS_EXTRA", strArr).putExtra("com.urbanairship.actions.actionactivity.RESULT_RECEIVER_EXTRA", new Action$1(this, new Handler(Looper.getMainLooper()), obj));
        synchronized (obj) {
            h.startActivity(putExtra);
            try {
                obj.wait();
            } catch (Throwable e) {
                C3783j.m19726c("Thread interrupted when waiting for result from activity.", e);
            }
        }
        return obj;
    }
}
