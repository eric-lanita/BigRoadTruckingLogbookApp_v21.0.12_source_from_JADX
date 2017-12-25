package com.bigroad.ttb.android.dialog;

import android.os.AsyncTask;
import com.bigroad.ttb.android.logging.C2134e;

public abstract class C1830c extends AsyncTask<Void, Void, Void> {
    private AsyncTaskDialogFragment f6254a;
    private boolean f6255b;
    private int f6256c;

    protected /* synthetic */ void onPostExecute(Object obj) {
        m8886a((Void) obj);
    }

    public void m8885a(AsyncTaskDialogFragment asyncTaskDialogFragment) {
        this.f6254a = asyncTaskDialogFragment;
    }

    public final boolean m8888c() {
        return this.f6255b;
    }

    public final void m8887a(boolean z) {
        this.f6255b = z;
    }

    public final int m8889d() {
        return this.f6256c;
    }

    public final void m8884a(int i) {
        this.f6256c = i;
    }

    protected void m8886a(Void voidR) {
        if (this.f6254a != null) {
            this.f6254a.m8826a();
        } else {
            C2134e.m10680d("TT-PersistentTask", "Task finished without a dialog reference. Was it started manually?");
        }
    }
}
