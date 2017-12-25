package android.support.v4.app;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.content.C0126a;
import android.util.Log;
import java.util.ArrayList;
import java.util.Iterator;

public final class at implements Iterable<Intent> {
    private static final C0176b f601a;
    private final ArrayList<Intent> f602b = new ArrayList();
    private final Context f603c;

    public interface C0175a {
        Intent mo410a();
    }

    interface C0176b {
    }

    static class C0177c implements C0176b {
        C0177c() {
        }
    }

    static class C0178d implements C0176b {
        C0178d() {
        }
    }

    static {
        if (VERSION.SDK_INT >= 11) {
            f601a = new C0178d();
        } else {
            f601a = new C0177c();
        }
    }

    private at(Context context) {
        this.f603c = context;
    }

    public static at m780a(Context context) {
        return new at(context);
    }

    public at m783a(Intent intent) {
        this.f602b.add(intent);
        return this;
    }

    public at m781a(Activity activity) {
        Intent a;
        Intent intent = null;
        if (activity instanceof C0175a) {
            intent = ((C0175a) activity).mo410a();
        }
        if (intent == null) {
            a = C0230y.m1041a(activity);
        } else {
            a = intent;
        }
        if (a != null) {
            ComponentName component = a.getComponent();
            if (component == null) {
                component = a.resolveActivity(this.f603c.getPackageManager());
            }
            m782a(component);
            m783a(a);
        }
        return this;
    }

    public at m782a(ComponentName componentName) {
        int size = this.f602b.size();
        try {
            Intent a = C0230y.m1042a(this.f603c, componentName);
            while (a != null) {
                this.f602b.add(size, a);
                a = C0230y.m1042a(this.f603c, a.getComponent());
            }
            return this;
        } catch (Throwable e) {
            Log.e("TaskStackBuilder", "Bad ComponentName while traversing activity parent metadata");
            throw new IllegalArgumentException(e);
        }
    }

    public Iterator<Intent> iterator() {
        return this.f602b.iterator();
    }

    public void m784a() {
        m785a(null);
    }

    public void m785a(Bundle bundle) {
        if (this.f602b.isEmpty()) {
            throw new IllegalStateException("No intents added to TaskStackBuilder; cannot startActivities");
        }
        Intent[] intentArr = (Intent[]) this.f602b.toArray(new Intent[this.f602b.size()]);
        intentArr[0] = new Intent(intentArr[0]).addFlags(268484608);
        if (!C0126a.m583a(this.f603c, intentArr, bundle)) {
            Intent intent = new Intent(intentArr[intentArr.length - 1]);
            intent.addFlags(268435456);
            this.f603c.startActivity(intent);
        }
    }
}
