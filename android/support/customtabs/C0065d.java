package android.support.customtabs;

import android.os.IBinder;

public class C0065d {
    private final C0066e f398a;
    private final C0059a f399b = new C00641(this);

    class C00641 extends C0059a {
        final /* synthetic */ C0065d f397a;

        C00641(C0065d c0065d) {
            this.f397a = c0065d;
        }
    }

    C0065d(C0066e c0066e) {
        this.f398a = c0066e;
    }

    IBinder m357a() {
        return this.f398a.asBinder();
    }

    public int hashCode() {
        return m357a().hashCode();
    }

    public boolean equals(Object obj) {
        if (obj instanceof C0065d) {
            return ((C0065d) obj).m357a().equals(this.f398a.asBinder());
        }
        return false;
    }
}
