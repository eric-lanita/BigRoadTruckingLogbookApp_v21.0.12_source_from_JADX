package com.urbanairship.analytics;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.os.Build.VERSION;
import android.support.v4.content.C0265i;
import com.urbanairship.C3680a;
import com.urbanairship.C3731i;
import com.urbanairship.C3761b;
import com.urbanairship.C3783j;
import com.urbanairship.C3796l;
import com.urbanairship.C3929q;
import com.urbanairship.C3929q.C1186a;
import com.urbanairship.analytics.C3725a.C3724a;
import com.urbanairship.analytics.C3741g.C3733a;
import com.urbanairship.location.LocationRequestOptions;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class C3735b extends C3680a {
    private static C3731i f13399a;
    private final C3725a f13400b;
    private final C3747k f13401c;
    private final C3736c f13402d;
    private final Context f13403e;
    private boolean f13404f;
    private final C3761b f13405g;
    private String f13406h;
    private String f13407i;
    private String f13408j;
    private String f13409k;
    private String f13410l;
    private long f13411m;
    private final Object f13412n;

    class C37261 extends C3724a {
        final /* synthetic */ C3735b f13381a;

        C37261(C3735b c3735b) {
            this.f13381a = c3735b;
        }

        public void mo2772a(long j) {
            this.f13381a.m19464g();
            this.f13381a.f13404f = false;
            if (this.f13381a.f13409k == null) {
                this.f13381a.m19460c(this.f13381a.f13410l);
            }
            if (this.f13381a.m19466i()) {
                this.f13381a.f13403e.startService(new Intent(this.f13381a.f13403e, EventService.class).setAction("com.urbanairship.com.analytics.UPDATE_ADVERTISING_ID"));
            }
            C0265i.m1105a(this.f13381a.f13403e).m1110a(new Intent("com.urbanairship.analytics.APP_FOREGROUND"));
            this.f13381a.m19455a(new C3739e(j));
        }

        public void mo2773b(long j) {
            this.f13381a.f13404f = true;
            this.f13381a.m19460c(null);
            this.f13381a.m19455a(new C3738d(j));
            C0265i.m1105a(this.f13381a.f13403e).m1110a(new Intent("com.urbanairship.analytics.APP_BACKGROUND"));
            this.f13381a.m19456a(null);
            this.f13381a.m19457b(null);
        }
    }

    class C37345 extends C3733a {
        final /* synthetic */ C3735b f13398a;

        C37345(C3735b c3735b) {
            this.f13398a = c3735b;
        }

        void mo2776a(boolean z, Map<String, String> map, List<String> list) {
            synchronized (this.f13398a.f13412n) {
                Map hashMap = new HashMap();
                if (!z) {
                    hashMap.putAll(this.f13398a.m19468k().m19507a());
                }
                hashMap.putAll(map);
                for (String remove : list) {
                    hashMap.remove(remove);
                }
                C3741g c3741g = new C3741g(hashMap);
                this.f13398a.f13402d.m19472a(c3741g);
                this.f13398a.m19455a(new C3740f(c3741g));
            }
        }
    }

    public C3735b(Context context, C3796l c3796l, C3761b c3761b) {
        this(context, c3796l, c3761b, new C3725a());
    }

    C3735b(Context context, C3796l c3796l, C3761b c3761b, C3725a c3725a) {
        this.f13412n = new Object();
        this.f13403e = context.getApplicationContext();
        this.f13402d = new C3736c(c3796l);
        this.f13401c = new C3747k(context, c3761b.m19664a());
        this.f13404f = true;
        this.f13405g = c3761b;
        this.f13400b = c3725a;
    }

    protected void mo2777a() {
        m19464g();
        this.f13400b.m19423a(new C37261(this));
    }

    public static void m19444a(final Activity activity) {
        if (VERSION.SDK_INT < 14) {
            final long currentTimeMillis = System.currentTimeMillis();
            C3929q.m20370a(new C1186a() {
                public void mo872a(C3929q c3929q) {
                    c3929q.m20394r().f13400b.m19422a(activity, currentTimeMillis);
                }
            });
        }
    }

    public static void m19448b(final Activity activity) {
        if (VERSION.SDK_INT < 14) {
            final long currentTimeMillis = System.currentTimeMillis();
            C3929q.m20370a(new C1186a() {
                public void mo872a(C3929q c3929q) {
                    c3929q.m20394r().f13400b.m19424b(activity, currentTimeMillis);
                }
            });
        }
    }

    public boolean m19458b() {
        return !this.f13404f;
    }

    public void m19455a(C3737i c3737i) {
        if (c3737i == null || !c3737i.mo2780c()) {
            C3783j.m19721a("Analytics - Invalid event: " + c3737i);
        } else if (m19465h()) {
            String a = c3737i.m19487a(this.f13406h);
            if (a == null) {
                C3783j.m19728e("Analytics - Failed to add event " + c3737i.mo2778a());
            }
            if (this.f13403e.startService(new Intent(this.f13403e, EventService.class).setAction("com.urbanairship.analytics.ADD").putExtra("EXTRA_EVENT_TYPE", c3737i.mo2778a()).putExtra("EXTRA_EVENT_ID", c3737i.m19490d()).putExtra("EXTRA_EVENT_DATA", a).putExtra("EXTRA_EVENT_TIME_STAMP", c3737i.m19491e()).putExtra("EXTRA_EVENT_SESSION_ID", this.f13406h).putExtra("EXTRA_EVENT_PRIORITY", c3737i.mo2786l())) == null) {
                C3783j.m19721a("Unable to start analytics service. Check that the event service is added to the manifest.");
            } else {
                C3783j.m19725c("Analytics - Added event: " + c3737i.mo2778a() + ": " + a);
            }
        } else {
            C3783j.m19725c("Analytics disabled - ignoring event: " + c3737i.mo2778a());
        }
    }

    public void m19454a(Location location, LocationRequestOptions locationRequestOptions, int i) {
        int i2 = 1;
        int i3 = -1;
        if (locationRequestOptions == null) {
            i2 = -1;
        } else {
            i3 = (int) locationRequestOptions.m19834c();
            if (locationRequestOptions.m19832a() != 1) {
                i2 = 2;
            }
        }
        m19455a(new C3751o(location, i, i2, i3, m19458b()));
    }

    public String m19459c() {
        return this.f13407i;
    }

    public void m19456a(String str) {
        C3783j.m19725c("Analytics - Setting conversion send ID: " + str);
        this.f13407i = str;
    }

    public String m19461d() {
        return this.f13408j;
    }

    public void m19457b(String str) {
        C3783j.m19725c("Analytics - Setting conversion metadata: " + str);
        this.f13408j = str;
    }

    C3747k m19462e() {
        return this.f13401c;
    }

    C3736c m19463f() {
        return this.f13402d;
    }

    @TargetApi(14)
    public static void m19445a(Application application) {
        if (f13399a == null) {
            f13399a = new C3731i(application) {
                public void mo2775b(final Activity activity) {
                    final long currentTimeMillis = System.currentTimeMillis();
                    C3929q.m20370a(new C1186a(this) {
                        final /* synthetic */ C37324 f13388c;

                        public void mo872a(C3929q c3929q) {
                            c3929q.m20394r().f13400b.m19422a(activity, currentTimeMillis);
                        }
                    });
                }

                public void mo2774a(final Activity activity) {
                    final long currentTimeMillis = System.currentTimeMillis();
                    C3929q.m20370a(new C1186a(this) {
                        final /* synthetic */ C37324 f13391c;

                        public void mo872a(C3929q c3929q) {
                            c3929q.m20394r().f13400b.m19424b(activity, currentTimeMillis);
                        }
                    });
                }
            };
            f13399a.m19431a();
        }
    }

    void m19464g() {
        this.f13406h = UUID.randomUUID().toString();
        C3783j.m19725c("Analytics - New session: " + this.f13406h);
    }

    public boolean m19465h() {
        return this.f13405g.f13512l && this.f13402d.m19482g();
    }

    public boolean m19466i() {
        return this.f13402d.m19483h();
    }

    public C3733a m19467j() {
        return new C37345(this);
    }

    public C3741g m19468k() {
        C3741g i;
        synchronized (this.f13412n) {
            i = this.f13402d.m19484i();
        }
        return i;
    }

    public void m19460c(String str) {
        if (this.f13409k == null || !this.f13409k.equals(str)) {
            if (this.f13409k != null) {
                C3737i c3753q = new C3753q(this.f13409k, this.f13410l, this.f13411m, System.currentTimeMillis());
                this.f13410l = this.f13409k;
                m19455a(c3753q);
            }
            this.f13409k = str;
            this.f13411m = System.currentTimeMillis();
        }
    }
}
