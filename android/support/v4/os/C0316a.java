package android.support.v4.os;

import android.os.AsyncTask;
import android.os.Build.VERSION;

public final class C0316a {
    public static <Params, Progress, Result> AsyncTask<Params, Progress, Result> m1279a(AsyncTask<Params, Progress, Result> asyncTask, Params... paramsArr) {
        if (asyncTask == null) {
            throw new IllegalArgumentException("task can not be null");
        }
        if (VERSION.SDK_INT >= 11) {
            C0317b.m1280a(asyncTask, paramsArr);
        } else {
            asyncTask.execute(paramsArr);
        }
        return asyncTask;
    }
}
