package android.support.customtabs;

import android.app.Service;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IBinder.DeathRecipient;
import android.os.RemoteException;
import android.support.customtabs.C0056f.C0057a;
import android.support.v4.p008d.C0270a;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

public abstract class CustomTabsService extends Service {
    private final Map<IBinder, DeathRecipient> f387a = new C0270a();
    private C0057a f388b = new C00581(this);

    class C00581 extends C0057a {
        final /* synthetic */ CustomTabsService f386a;

        C00581(CustomTabsService customTabsService) {
            this.f386a = customTabsService;
        }

        public boolean mo48a(long j) {
            return this.f386a.m348a(j);
        }

        public boolean mo49a(C0066e c0066e) {
            boolean z = false;
            final C0065d c0065d = new C0065d(c0066e);
            try {
                DeathRecipient c00551 = new DeathRecipient(this) {
                    final /* synthetic */ C00581 f385b;

                    public void binderDied() {
                        this.f385b.f386a.m349a(c0065d);
                    }
                };
                synchronized (this.f386a.f387a) {
                    c0066e.asBinder().linkToDeath(c00551, 0);
                    this.f386a.f387a.put(c0066e.asBinder(), c00551);
                }
                z = this.f386a.m352b(c0065d);
            } catch (RemoteException e) {
            }
            return z;
        }

        public boolean mo50a(C0066e c0066e, Uri uri, Bundle bundle, List<Bundle> list) {
            return this.f386a.m350a(new C0065d(c0066e), uri, bundle, list);
        }

        public Bundle mo47a(String str, Bundle bundle) {
            return this.f386a.m347a(str, bundle);
        }

        public boolean mo51a(C0066e c0066e, Bundle bundle) {
            return this.f386a.m351a(new C0065d(c0066e), bundle);
        }
    }

    protected abstract Bundle m347a(String str, Bundle bundle);

    protected abstract boolean m348a(long j);

    protected abstract boolean m350a(C0065d c0065d, Uri uri, Bundle bundle, List<Bundle> list);

    protected abstract boolean m351a(C0065d c0065d, Bundle bundle);

    protected abstract boolean m352b(C0065d c0065d);

    protected boolean m349a(C0065d c0065d) {
        try {
            synchronized (this.f387a) {
                IBinder a = c0065d.m357a();
                a.unlinkToDeath((DeathRecipient) this.f387a.get(a), 0);
                this.f387a.remove(a);
            }
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}
