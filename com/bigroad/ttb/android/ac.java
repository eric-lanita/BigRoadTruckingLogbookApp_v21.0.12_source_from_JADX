package com.bigroad.ttb.android;

import android.os.Handler;
import com.bigroad.ttb.android.p035d.p036a.C1767f;
import com.bigroad.ttb.protocol.TTProtocol.RequestType;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ac {
    private final Handler f4317a = new Handler();
    private C1263c f4318b = null;
    private ExecutorService f4319c = null;
    private C1240a f4320d = null;

    public interface C1240a {
        void mo909a(C1263c c1263c);
    }

    public void m6663a(C1240a c1240a) {
        this.f4320d = c1240a;
    }

    public void m6664a(C1767f c1767f) {
        this.f4318b = new C1263c(this, c1767f) {
            final /* synthetic */ ac f4316a;

            public void mo916a(final C1263c c1263c) {
                this.f4316a.f4317a.post(new Runnable(this) {
                    final /* synthetic */ C12641 f4308b;

                    public void run() {
                        this.f4308b.f4316a.m6662a(c1263c);
                    }
                });
            }
        };
        if (this.f4319c == null) {
            this.f4319c = Executors.newSingleThreadExecutor();
        }
        this.f4319c.execute(this.f4318b);
    }

    public boolean m6665a() {
        return this.f4318b != null;
    }

    public boolean m6666a(RequestType requestType) {
        return m6665a() && aa.m6628a(this.f4318b.m6653a(), requestType);
    }

    public C1263c m6667b() {
        C1263c c1263c = this.f4318b;
        this.f4318b = null;
        if (this.f4319c != null) {
            this.f4319c.shutdown();
            this.f4319c = null;
        }
        return c1263c;
    }

    private void m6662a(C1263c c1263c) {
        if (this.f4318b != null && c1263c == this.f4318b) {
            C1263c c1263c2 = this.f4318b;
            this.f4318b = null;
            if (this.f4320d != null) {
                this.f4320d.mo909a(c1263c2);
            }
        }
    }
}
