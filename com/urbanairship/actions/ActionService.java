package com.urbanairship.actions;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcelable;
import com.urbanairship.C1187d;
import com.urbanairship.C3783j;
import com.urbanairship.C3929q;
import com.urbanairship.json.C3788b;
import com.urbanairship.json.JsonException;
import com.urbanairship.json.JsonValue;
import com.urbanairship.util.C3954i;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class ActionService extends Service {
    private int f13308a;
    private int f13309b;
    private final C3705g f13310c;

    class C36821 implements C3681c {
        final /* synthetic */ ActionService f13307a;

        C36821(ActionService actionService) {
            this.f13307a = actionService;
        }

        public void mo2766a(C3694b c3694b, C3701e c3701e) {
            this.f13307a.f13309b = this.f13307a.f13309b - 1;
            if (this.f13307a.f13309b == 0) {
                this.f13307a.stopSelf(this.f13307a.f13308a);
            }
        }
    }

    ActionService(C3705g c3705g) {
        this.f13308a = 0;
        this.f13309b = 0;
        this.f13310c = c3705g;
    }

    public ActionService() {
        this(new C3705g());
    }

    public void onCreate() {
        super.onCreate();
        C1187d.m6035c(getApplicationContext());
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        if (C3929q.m20384j() || C3929q.m20383i()) {
            this.f13308a = i2;
            if (intent != null && "com.urbanairship.actionservice.ACTION_RUN_ACTIONS".equals(intent.getAction())) {
                C3783j.m19723b("ActionService - Received intent: " + intent.getAction() + " startId: " + i2);
                m19306a(intent);
            }
            if (this.f13309b == 0) {
                stopSelf(i2);
            }
        } else {
            C3783j.m19728e("ActionService - unable to start service, takeOff not called.");
            stopSelf(i2);
        }
        return 2;
    }

    public IBinder onBind(Intent intent) {
        return null;
    }

    public static void m19304a(Context context, String str, int i, Bundle bundle) {
        Bundle a = m19303a(str);
        if (!a.isEmpty()) {
            Intent putExtra = new Intent("com.urbanairship.actionservice.ACTION_RUN_ACTIONS").setClass(context, ActionService.class).putExtra("com.urbanairship.actionservice.EXTRA_ACTIONS", a).putExtra("com.urbanairship.actionservice.EXTRA_SITUATION", i);
            if (bundle != null) {
                putExtra.putExtra("com.urbanairship.actionservice.EXTRA_METADATA", bundle);
            }
            context.startService(putExtra);
        }
    }

    public static void m19305a(Context context, Map<String, ActionValue> map, int i, Bundle bundle) {
        if (!map.isEmpty()) {
            Bundle bundle2 = new Bundle();
            for (Entry entry : map.entrySet()) {
                bundle2.putParcelable((String) entry.getKey(), (Parcelable) entry.getValue());
            }
            Intent putExtra = new Intent("com.urbanairship.actionservice.ACTION_RUN_ACTIONS").setClass(context, ActionService.class).putExtra("com.urbanairship.actionservice.EXTRA_ACTIONS", bundle2).putExtra("com.urbanairship.actionservice.EXTRA_SITUATION", i);
            if (bundle != null) {
                putExtra.putExtra("com.urbanairship.actionservice.EXTRA_METADATA", bundle);
            }
            context.startService(putExtra);
        }
    }

    private void m19306a(Intent intent) {
        Bundle bundle;
        Bundle bundle2;
        int i = 0;
        Bundle bundleExtra = intent.getBundleExtra("com.urbanairship.actionservice.EXTRA_ACTIONS");
        if (bundleExtra == null) {
            bundle = new Bundle();
        } else {
            bundle = bundleExtra;
        }
        switch (intent.getIntExtra("com.urbanairship.actionservice.EXTRA_SITUATION", 0)) {
            case 1:
                i = 1;
                break;
            case 2:
                i = 2;
                break;
            case 3:
                i = 3;
                break;
            case 4:
                i = 4;
                break;
            case 5:
                i = 5;
                break;
        }
        bundleExtra = intent.getBundleExtra("com.urbanairship.actionservice.EXTRA_METADATA");
        if (bundleExtra == null) {
            bundle2 = new Bundle();
        } else {
            bundle2 = bundleExtra;
        }
        if (bundle.isEmpty()) {
            C3783j.m19725c("ActionService - No actions to run.");
            return;
        }
        for (String str : bundle.keySet()) {
            this.f13309b++;
            this.f13310c.m19391a(str).m19386a(bundle2).m19387a((ActionValue) bundle.getParcelable(str)).m19385a(i).m19389a(new C36821(this));
        }
    }

    private static Bundle m19303a(String str) {
        Bundle bundle = new Bundle();
        if (C3954i.m20512a(str)) {
            return bundle;
        }
        try {
            C3788b f = JsonValue.m19740b(str).m19755f();
            if (f != null) {
                Iterator it = f.iterator();
                while (it.hasNext()) {
                    Entry entry = (Entry) it.next();
                    bundle.putParcelable((String) entry.getKey(), new ActionValue((JsonValue) entry.getValue()));
                }
            }
        } catch (JsonException e) {
            C3783j.m19728e("Unable to parse action payload: " + str);
        }
        return bundle;
    }
}
