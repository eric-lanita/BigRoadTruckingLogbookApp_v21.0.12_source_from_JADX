package com.urbanairship.push;

import android.content.Context;
import android.content.Intent;
import com.google.android.gms.gcm.GoogleCloudMessaging;
import com.urbanairship.BaseIntentService.C3676a;
import com.urbanairship.C3783j;
import com.urbanairship.C3796l;
import com.urbanairship.C3929q;
import com.urbanairship.analytics.EventService;
import com.urbanairship.google.C3780c;
import com.urbanairship.json.C3684c;
import com.urbanairship.json.JsonValue;
import com.urbanairship.p053a.C3678a;
import com.urbanairship.p055b.C3760c;
import com.urbanairship.util.C3952g;
import com.urbanairship.util.C3954i;
import java.io.IOException;
import java.net.URL;

class C3879d extends C3676a {
    private static boolean f13786a = false;
    private static boolean f13787b = false;
    private final C3929q f13788c;
    private final C3919j f13789d;
    private final C3875b f13790e;
    private final C3883g f13791f;

    public C3879d(Context context, C3796l c3796l) {
        this(context, c3796l, new C3875b(), C3929q.m20372a());
    }

    public C3879d(Context context, C3796l c3796l, C3875b c3875b, C3929q c3929q) {
        super(context, c3796l);
        this.f13790e = c3875b;
        this.f13788c = c3929q;
        this.f13789d = c3929q.m20390n();
        this.f13791f = c3929q.m20389m();
    }

    protected void mo2820a(Intent intent) {
        String action = intent.getAction();
        Object obj = -1;
        switch (action.hashCode()) {
            case -1003583816:
                if (action.equals("com.urbanairship.push.ACTION_START_REGISTRATION")) {
                    obj = null;
                    break;
                }
                break;
            case -901120150:
                if (action.equals("com.urbanairship.push.ACTION_UPDATE_PUSH_REGISTRATION")) {
                    obj = 1;
                    break;
                }
                break;
            case 720921569:
                if (action.equals("com.urbanairship.push.ACTION_ADM_REGISTRATION_FINISHED")) {
                    obj = 2;
                    break;
                }
                break;
            case 1402665321:
                if (action.equals("com.urbanairship.push.ACTION_UPDATE_CHANNEL_REGISTRATION")) {
                    obj = 3;
                    break;
                }
                break;
        }
        switch (obj) {
            case null:
                m20111c();
                return;
            case 1:
                m20113e(intent);
                return;
            case 2:
                m20116f(intent);
                return;
            case 3:
                m20118g(intent);
                return;
            default:
                return;
        }
    }

    private void m20111c() {
        if (!f13787b) {
            f13787b = true;
            if (m20114e()) {
                f13786a = true;
                m19269a().startService(new Intent(m19269a(), PushService.class).setAction("com.urbanairship.push.ACTION_UPDATE_PUSH_REGISTRATION"));
                return;
            }
            m19269a().startService(new Intent(m19269a(), PushService.class).setAction("com.urbanairship.push.ACTION_UPDATE_CHANNEL_REGISTRATION"));
        }
    }

    private void m20113e(Intent intent) {
        Exception e;
        f13786a = false;
        switch (this.f13788c.m20399w()) {
            case 1:
                if (!C3678a.m19293b()) {
                    C3783j.m19728e("ADM is not supported on this device.");
                    break;
                }
                String b = C3678a.m19292b(m19269a());
                if (b != null) {
                    if (!b.equals(this.f13789d.m20319k())) {
                        C3783j.m19727d("ADM registration successful. Registration ID: " + b);
                        this.f13789d.m20309c(b);
                        break;
                    }
                }
                this.f13789d.m20309c(null);
                C3678a.m19290a(m19269a());
                f13786a = true;
                break;
                break;
            case 2:
                if (C3780c.m19708b()) {
                    try {
                        C3880e.m20120a();
                    } catch (IOException e2) {
                        e = e2;
                        C3783j.m19728e("GCM registration failed, will retry. GCM error: " + e.getMessage());
                        f13786a = true;
                        m19274d(intent);
                        if (f13786a) {
                            m19269a().startService(new Intent(m19269a(), PushService.class).setAction("com.urbanairship.push.ACTION_UPDATE_CHANNEL_REGISTRATION"));
                        }
                    } catch (SecurityException e3) {
                        e = e3;
                        C3783j.m19728e("GCM registration failed, will retry. GCM error: " + e.getMessage());
                        f13786a = true;
                        m19274d(intent);
                        if (f13786a) {
                            m19269a().startService(new Intent(m19269a(), PushService.class).setAction("com.urbanairship.push.ACTION_UPDATE_CHANNEL_REGISTRATION"));
                        }
                    }
                }
                C3783j.m19728e("GCM is unavailable. Unable to register for push notifications. If using the modular Google Play Services dependencies, make sure the application includes the com.google.android.gms:play-services-gcm dependency.");
            default:
                C3783j.m19728e("Unknown platform type. Unable to register for push.");
                break;
        }
        if (f13786a) {
            m19269a().startService(new Intent(m19269a(), PushService.class).setAction("com.urbanairship.push.ACTION_UPDATE_CHANNEL_REGISTRATION"));
        }
    }

    private void m20116f(Intent intent) {
        if (this.f13788c.m20399w() == 1 && C3678a.m19291a()) {
            Intent intent2 = (Intent) intent.getParcelableExtra("com.urbanairship.push.EXTRA_INTENT");
            if (intent2 == null) {
                C3783j.m19728e("ChannelServiceDelegate - Received ADM message missing original intent.");
                return;
            }
            if (intent2.hasExtra("error")) {
                C3783j.m19728e("ADM error occurred: " + intent2.getStringExtra("error"));
            } else {
                String stringExtra = intent2.getStringExtra("registration_id");
                if (stringExtra != null) {
                    C3783j.m19727d("ADM registration successful. Registration ID: " + stringExtra);
                    this.f13789d.m20309c(stringExtra);
                }
            }
            f13786a = false;
            m19269a().startService(new Intent(m19269a(), PushService.class).setAction("com.urbanairship.push.ACTION_UPDATE_CHANNEL_REGISTRATION"));
            return;
        }
        C3783j.m19728e("Received intent from invalid transport acting as ADM.");
    }

    private void m20118g(Intent intent) {
        if (f13786a) {
            C3783j.m19723b("ChannelServiceDelegate - Push registration in progress, skipping registration update.");
            return;
        }
        C3783j.m19723b("ChannelServiceDelegate - Performing channel registration.");
        C3878c g = this.f13789d.m20315g();
        String u = this.f13789d.m20329u();
        URL d = m20112d();
        if (d == null || C3954i.m20512a(u)) {
            m20106a(intent, g);
        } else {
            m20107a(intent, d, g);
        }
    }

    private void m20107a(Intent intent, URL url, C3878c c3878c) {
        if (m20109a(c3878c)) {
            C3760c a = this.f13790e.m20085a(url, c3878c);
            if (a == null || C3952g.m20509b(a.m19659a())) {
                C3783j.m19728e("Channel registration failed, will retry.");
                m19274d(intent);
                m20108a(false, false);
                return;
            } else if (C3952g.m20508a(a.m19659a())) {
                C3783j.m19727d("Channel registration succeeded with status: " + a.m19659a());
                m20110b(c3878c);
                m20108a(true, false);
                return;
            } else if (a.m19659a() == 409) {
                this.f13789d.m20303a(null, null);
                m19269a().startService(new Intent(m19269a(), PushService.class).setAction("com.urbanairship.push.ACTION_UPDATE_CHANNEL_REGISTRATION"));
                return;
            } else {
                C3783j.m19728e("Channel registration failed with status: " + a.m19659a());
                m20108a(false, false);
                return;
            }
        }
        C3783j.m19723b("ChannelServiceDelegate - Channel already up to date.");
    }

    private void m20106a(Intent intent, C3878c c3878c) {
        if (this.f13789d.m20326r()) {
            C3783j.m19727d("Channel registration is currently disabled.");
            return;
        }
        C3760c a = this.f13790e.m20084a(c3878c);
        if (a == null || C3952g.m20509b(a.m19659a())) {
            C3783j.m19728e("Channel registration failed, will retry.");
            m20108a(false, true);
            m19274d(intent);
        } else if (a.m19659a() == 200 || a.m19659a() == 201) {
            String str = null;
            try {
                str = JsonValue.m19740b(a.m19661b()).m19756g().m19782c("channel_id").m19747a();
            } catch (Throwable e) {
                C3783j.m19724b("Unable to parse channel registration response body: " + a.m19661b(), e);
            }
            String a2 = a.m19660a("Location");
            if (C3954i.m20512a(a2) || C3954i.m20512a(str)) {
                C3783j.m19728e("Failed to register with channel ID: " + str + " channel location: " + a2);
                m20108a(false, true);
                return;
            }
            C3783j.m19727d("Channel creation succeeded with status: " + a.m19659a() + " channel ID: " + str);
            this.f13789d.m20303a(str, a2);
            m20110b(c3878c);
            m20108a(true, true);
            if (a.m19659a() == 200 && this.f13788c.m20388l().f13514n) {
                this.f13791f.m20137e();
            }
            this.f13791f.m20138f();
            this.f13789d.m20316h();
            this.f13789d.m20331w();
            this.f13788c.m20391o().m20439b().m20477a(true);
            m19269a().startService(new Intent(m19269a(), EventService.class).setAction("com.urbanairship.analytics.SEND"));
        } else {
            C3783j.m19728e("Channel registration failed with status: " + a.m19659a());
            m20108a(false, true);
        }
    }

    private boolean m20109a(C3878c c3878c) {
        return !c3878c.equals(m20115f()) || System.currentTimeMillis() - m20117g() >= 86400000;
    }

    private URL m20112d() {
        String v = this.f13789d.m20330v();
        if (!C3954i.m20512a(v)) {
            try {
                return new URL(v);
            } catch (Throwable e) {
                C3783j.m19726c("Channel location from preferences was invalid: " + v, e);
            }
        }
        return null;
    }

    private boolean m20114e() {
        switch (this.f13788c.m20399w()) {
            case 1:
                if (this.f13788c.m20388l().m19665a("ADM")) {
                    return true;
                }
                C3783j.m19727d("Unable to register for push. ADM transport type is not allowed.");
                return false;
            case 2:
                if (this.f13788c.m20388l().m19665a(GoogleCloudMessaging.INSTANCE_ID_SCOPE)) {
                    return true;
                }
                C3783j.m19727d("Unable to register for push. GCM transport type is not allowed.");
                return false;
            default:
                return false;
        }
    }

    private void m20110b(C3878c c3878c) {
        m19272b().m19814a("com.urbanairship.push.LAST_REGISTRATION_PAYLOAD", (C3684c) c3878c);
        m19272b().m19818b("com.urbanairship.push.LAST_REGISTRATION_TIME", System.currentTimeMillis());
    }

    private C3878c m20115f() {
        C3878c c3878c = null;
        try {
            c3878c = C3878c.m20104a(m19272b().m19810a("com.urbanairship.push.LAST_REGISTRATION_PAYLOAD", (String) c3878c));
        } catch (Throwable e) {
            C3783j.m19726c("ChannelServiceDelegate - Failed to parse payload from JSON.", e);
        }
        return c3878c;
    }

    private long m20117g() {
        long a = m19272b().m19808a("com.urbanairship.push.LAST_REGISTRATION_TIME", 0);
        if (a <= System.currentTimeMillis()) {
            return a;
        }
        m19272b().m19817b("com.urbanairship.push.LAST_REGISTRATION_TIME", 0);
        return 0;
    }

    private void m20108a(boolean z, boolean z2) {
        Intent intent = new Intent("com.urbanairship.push.CHANNEL_UPDATED").putExtra("com.urbanairship.push.EXTRA_CHANNEL_ID", this.f13789d.m20329u()).putExtra("com.urbanairship.push.EXTRA_CHANNEL_CREATE_REQUEST", z2).addCategory(C3929q.m20374b()).setPackage(C3929q.m20374b());
        if (!z) {
            intent.putExtra("com.urbanairship.push.EXTRA_ERROR", true);
        }
        m19269a().sendBroadcast(intent, C3929q.m20376c());
    }
}
