package com.urbanairship.actions;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.urbanairship.C3783j;
import com.urbanairship.C3929q;
import com.urbanairship.actions.C3700d.C3699a;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class C3704f {
    static Executor f13347a = Executors.newCachedThreadPool();
    private C3700d f13348b;
    private String f13349c;
    private C3690a f13350d;
    private ActionValue f13351e;
    private Bundle f13352f;
    private int f13353g = 0;

    public static C3704f m19382a(String str) {
        return new C3704f(str, null);
    }

    public static C3704f m19381a(C3690a c3690a) {
        if (c3690a != null) {
            return new C3704f(c3690a);
        }
        throw new IllegalArgumentException("Unable to run null action");
    }

    C3704f(String str, C3700d c3700d) {
        this.f13349c = str;
        this.f13348b = c3700d;
    }

    C3704f(C3690a c3690a) {
        this.f13350d = c3690a;
    }

    public C3704f m19387a(ActionValue actionValue) {
        this.f13351e = actionValue;
        return this;
    }

    public C3704f m19386a(Bundle bundle) {
        this.f13352f = bundle;
        return this;
    }

    public C3704f m19385a(int i) {
        this.f13353g = i;
        return this;
    }

    private C3701e m19379a(C3694b c3694b) {
        if (this.f13349c != null) {
            C3699a b = m19384b(this.f13349c);
            if (b == null) {
                return C3701e.m19373a(3);
            }
            if (b.m19367a() == null || b.m19367a().mo2771a(c3694b)) {
                return b.m19366a(this.f13353g).m19346a(c3694b);
            }
            C3783j.m19727d("Action " + this.f13349c + " will not be run. Registry predicate rejected the arguments: " + c3694b);
            return C3701e.m19373a(2);
        } else if (this.f13350d != null) {
            return this.f13350d.m19346a(c3694b);
        } else {
            return C3701e.m19373a(3);
        }
    }

    public void m19388a() {
        m19390a(null, null);
    }

    public void m19389a(C3681c c3681c) {
        m19390a(c3681c, null);
    }

    public void m19390a(final C3681c c3681c, Looper looper) {
        Looper myLooper;
        if (looper == null) {
            myLooper = Looper.myLooper();
            if (myLooper == null) {
                myLooper = Looper.getMainLooper();
            }
        } else {
            myLooper = looper;
        }
        final C3694b b = m19383b();
        final Handler handler = new Handler(myLooper);
        f13347a.execute(new Runnable(this) {
            final /* synthetic */ C3704f f13346d;

            public void run() {
                final C3701e a = this.f13346d.m19379a(b);
                if (c3681c != null) {
                    handler.post(new Runnable(this) {
                        final /* synthetic */ C37031 f13342b;

                        public void run() {
                            c3681c.mo2766a(b, a);
                        }
                    });
                }
            }
        });
    }

    private C3694b m19383b() {
        Bundle bundle = this.f13352f == null ? new Bundle() : new Bundle(this.f13352f);
        if (this.f13349c != null) {
            bundle.putString("com.urbanairship.REGISTRY_ACTION_NAME", this.f13349c);
        }
        return new C3694b(this.f13353g, this.f13351e, bundle);
    }

    private C3699a m19384b(String str) {
        if (this.f13348b != null) {
            return this.f13348b.m19370a(str);
        }
        return C3929q.m20372a().m20397u().m19370a(str);
    }
}
