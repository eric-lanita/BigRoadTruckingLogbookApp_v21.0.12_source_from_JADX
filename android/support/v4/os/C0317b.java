package android.support.v4.os;

import android.os.AsyncTask;

class C0317b {
    static <Params, Progress, Result> void m1280a(AsyncTask<Params, Progress, Result> asyncTask, Params... paramsArr) {
        asyncTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, paramsArr);
    }
}
