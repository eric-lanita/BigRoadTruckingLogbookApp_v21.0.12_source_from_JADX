package com.google.firebase.iid;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import com.google.firebase.C3611a;

public class FirebaseInstanceIdService extends zzb {
    private static BroadcastReceiver f4109c;
    private static final Object f4110d = new Object();
    private static boolean f4111e = false;
    private boolean f4112f = false;

    private C3619c m6205a(String str) {
        if (str == null) {
            return C3619c.m18906a(this, null);
        }
        Bundle bundle = new Bundle();
        bundle.putString("subtype", str);
        return C3619c.m18906a(this, bundle);
    }

    static void m6206a(Context context) {
        if (C3622e.m18917a(context) != null) {
            synchronized (f4110d) {
                if (!f4111e) {
                    context.sendBroadcast(m6214c(0));
                    f4111e = true;
                }
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static void m6207a(android.content.Context r2, com.google.firebase.iid.FirebaseInstanceId r3) {
        /*
        r1 = f4110d;
        monitor-enter(r1);
        r0 = f4111e;	 Catch:{ all -> 0x001e }
        if (r0 == 0) goto L_0x0009;
    L_0x0007:
        monitor-exit(r1);	 Catch:{ all -> 0x001e }
    L_0x0008:
        return;
    L_0x0009:
        monitor-exit(r1);	 Catch:{ all -> 0x001e }
        r0 = r3.m18892e();
        if (r0 == 0) goto L_0x001a;
    L_0x0010:
        r0 = r3.m18894g();
        r0 = r0.m18915a();
        if (r0 == 0) goto L_0x0008;
    L_0x001a:
        m6206a(r2);
        goto L_0x0008;
    L_0x001e:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x001e }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.iid.FirebaseInstanceIdService.a(android.content.Context, com.google.firebase.iid.FirebaseInstanceId):void");
    }

    private void m6208a(Intent intent, String str) {
        boolean c = m6215c((Context) this);
        final int b = m6212b(intent, c);
        Log.d("FirebaseInstanceId", new StringBuilder(String.valueOf(str).length() + 47).append("background sync failed: ").append(str).append(", retry in ").append(b).append("s").toString());
        synchronized (f4110d) {
            m6216d(b);
            f4111e = true;
        }
        if (!c) {
            if (this.f4112f) {
                Log.d("FirebaseInstanceId", "device not connected. Connectivity change received registered");
            }
            if (f4109c == null) {
                f4109c = new BroadcastReceiver(this) {
                    final /* synthetic */ FirebaseInstanceIdService f13120b;

                    public void onReceive(Context context, Intent intent) {
                        if (FirebaseInstanceIdService.m6215c(context)) {
                            if (this.f13120b.f4112f) {
                                Log.d("FirebaseInstanceId", "connectivity changed. starting background sync.");
                            }
                            this.f13120b.getApplicationContext().unregisterReceiver(this);
                            context.sendBroadcast(FirebaseInstanceIdService.m6214c(b));
                        }
                    }
                };
            }
            getApplicationContext().registerReceiver(f4109c, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m6209a(android.content.Intent r9, boolean r10) {
        /*
        r8 = this;
        r2 = 1;
        r1 = 0;
        r3 = f4110d;
        monitor-enter(r3);
        r0 = 0;
        f4111e = r0;	 Catch:{ all -> 0x0010 }
        monitor-exit(r3);	 Catch:{ all -> 0x0010 }
        r0 = com.google.firebase.iid.C3622e.m18917a(r8);
        if (r0 != 0) goto L_0x0013;
    L_0x000f:
        return;
    L_0x0010:
        r0 = move-exception;
        monitor-exit(r3);	 Catch:{ all -> 0x0010 }
        throw r0;
    L_0x0013:
        r0 = com.google.firebase.iid.FirebaseInstanceId.m18878a();
        r4 = r0.m18894g();
        r3 = r0.m18892e();
        if (r3 != 0) goto L_0x0051;
    L_0x0021:
        r1 = r0.m18893f();	 Catch:{ IOException -> 0x0039, SecurityException -> 0x0048 }
        if (r1 == 0) goto L_0x0042;
    L_0x0027:
        r1 = r8.f4112f;	 Catch:{ IOException -> 0x0039, SecurityException -> 0x0048 }
        if (r1 == 0) goto L_0x0032;
    L_0x002b:
        r1 = "FirebaseInstanceId";
        r2 = "get master token succeeded";
        android.util.Log.d(r1, r2);	 Catch:{ IOException -> 0x0039, SecurityException -> 0x0048 }
    L_0x0032:
        m6207a(r8, r0);	 Catch:{ IOException -> 0x0039, SecurityException -> 0x0048 }
        r8.mo901a();	 Catch:{ IOException -> 0x0039, SecurityException -> 0x0048 }
        goto L_0x000f;
    L_0x0039:
        r0 = move-exception;
        r0 = r0.getMessage();
        r8.m6208a(r9, r0);
        goto L_0x000f;
    L_0x0042:
        r0 = "returned token is null";
        r8.m6208a(r9, r0);	 Catch:{ IOException -> 0x0039, SecurityException -> 0x0048 }
        goto L_0x000f;
    L_0x0048:
        r0 = move-exception;
        r1 = "FirebaseInstanceId";
        r2 = "Unable to get master token";
        android.util.Log.e(r1, r2, r0);
        goto L_0x000f;
    L_0x0051:
        r0 = r4.m18915a();
        r3 = r0;
    L_0x0056:
        if (r3 == 0) goto L_0x00be;
    L_0x0058:
        r0 = "!";
        r0 = r3.split(r0);
        r5 = r0.length;
        r6 = 2;
        if (r5 != r6) goto L_0x0071;
    L_0x0062:
        r5 = r0[r1];
        r6 = r0[r2];
        r0 = -1;
        r7 = r5.hashCode();	 Catch:{ IOException -> 0x00a1 }
        switch(r7) {
            case 83: goto L_0x007a;
            case 84: goto L_0x006e;
            case 85: goto L_0x0084;
            default: goto L_0x006e;
        };
    L_0x006e:
        switch(r0) {
            case 0: goto L_0x008e;
            case 1: goto L_0x00ab;
            default: goto L_0x0071;
        };
    L_0x0071:
        r4.m18916a(r3);
        r0 = r4.m18915a();
        r3 = r0;
        goto L_0x0056;
    L_0x007a:
        r7 = "S";
        r5 = r5.equals(r7);	 Catch:{ IOException -> 0x00a1 }
        if (r5 == 0) goto L_0x006e;
    L_0x0082:
        r0 = r1;
        goto L_0x006e;
    L_0x0084:
        r7 = "U";
        r5 = r5.equals(r7);	 Catch:{ IOException -> 0x00a1 }
        if (r5 == 0) goto L_0x006e;
    L_0x008c:
        r0 = r2;
        goto L_0x006e;
    L_0x008e:
        r0 = com.google.firebase.iid.FirebaseInstanceId.m18878a();	 Catch:{ IOException -> 0x00a1 }
        r0.m18887a(r6);	 Catch:{ IOException -> 0x00a1 }
        r0 = r8.f4112f;	 Catch:{ IOException -> 0x00a1 }
        if (r0 == 0) goto L_0x0071;
    L_0x0099:
        r0 = "FirebaseInstanceId";
        r5 = "subscribe operation succeeded";
        android.util.Log.d(r0, r5);	 Catch:{ IOException -> 0x00a1 }
        goto L_0x0071;
    L_0x00a1:
        r0 = move-exception;
        r0 = r0.getMessage();
        r8.m6208a(r9, r0);
        goto L_0x000f;
    L_0x00ab:
        r0 = com.google.firebase.iid.FirebaseInstanceId.m18878a();	 Catch:{ IOException -> 0x00a1 }
        r0.m18889b(r6);	 Catch:{ IOException -> 0x00a1 }
        r0 = r8.f4112f;	 Catch:{ IOException -> 0x00a1 }
        if (r0 == 0) goto L_0x0071;
    L_0x00b6:
        r0 = "FirebaseInstanceId";
        r5 = "unsubscribe operation succeeded";
        android.util.Log.d(r0, r5);	 Catch:{ IOException -> 0x00a1 }
        goto L_0x0071;
    L_0x00be:
        r0 = "FirebaseInstanceId";
        r1 = "topic sync succeeded";
        android.util.Log.d(r0, r1);
        goto L_0x000f;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.iid.FirebaseInstanceIdService.a(android.content.Intent, boolean):void");
    }

    private void m6210a(C3622e c3622e, Bundle bundle) {
        String a = C3622e.m18917a((Context) this);
        if (a == null) {
            Log.w("FirebaseInstanceId", "Unable to respond to ping due to missing target package");
            return;
        }
        Intent intent = new Intent("com.google.android.gcm.intent.SEND");
        intent.setPackage(a);
        intent.putExtras(bundle);
        c3622e.m18928a(intent);
        intent.putExtra("google.to", "google.com/iid");
        intent.putExtra("google.message_id", C3622e.m18925b());
        sendOrderedBroadcast(intent, "com.google.android.gtalkservice.permission.GTALK_SERVICE");
    }

    private int m6212b(Intent intent, boolean z) {
        int intExtra = intent == null ? 10 : intent.getIntExtra("next_retry_delay_in_seconds", 0);
        return (intExtra >= 10 || z) ? intExtra >= 10 ? intExtra > 28800 ? 28800 : intExtra : 10 : 30;
    }

    private static Intent m6214c(int i) {
        Context a = C3611a.m18861d().m18864a();
        Intent intent = new Intent("ACTION_TOKEN_REFRESH_RETRY");
        intent.putExtra("next_retry_delay_in_seconds", i);
        return FirebaseInstanceIdInternalReceiver.m18897a(a, intent);
    }

    private static boolean m6215c(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    private void m6216d(int i) {
        ((AlarmManager) getSystemService("alarm")).set(3, SystemClock.elapsedRealtime() + ((long) (i * 1000)), PendingIntent.getBroadcast(this, 0, m6214c(i * 2), 268435456));
    }

    private String m6217e(Intent intent) {
        String stringExtra = intent.getStringExtra("subtype");
        return stringExtra == null ? "" : stringExtra;
    }

    protected int mo898a(Intent intent) {
        this.f4112f = Log.isLoggable("FirebaseInstanceId", 3);
        if (intent.getStringExtra("error") == null && intent.getStringExtra("registration_id") == null) {
            return super.mo898a(intent);
        }
        String e = m6217e(intent);
        if (this.f4112f) {
            String str = "FirebaseInstanceId";
            String str2 = "Register result in service ";
            String valueOf = String.valueOf(e);
            Log.d(str, valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
        }
        m6205a(e).m18913d().m18934d(intent);
        m6200b();
        return 2;
    }

    public void mo901a() {
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo899b(android.content.Intent r5) {
        /*
        r4 = this;
        r1 = 0;
        r0 = r5.getAction();
        if (r0 != 0) goto L_0x0009;
    L_0x0007:
        r0 = "";
    L_0x0009:
        r2 = -1;
        r3 = r0.hashCode();
        switch(r3) {
            case -1737547627: goto L_0x0019;
            default: goto L_0x0011;
        };
    L_0x0011:
        r0 = r2;
    L_0x0012:
        switch(r0) {
            case 0: goto L_0x0023;
            default: goto L_0x0015;
        };
    L_0x0015:
        r4.m6222d(r5);
    L_0x0018:
        return;
    L_0x0019:
        r3 = "ACTION_TOKEN_REFRESH_RETRY";
        r0 = r0.equals(r3);
        if (r0 == 0) goto L_0x0011;
    L_0x0021:
        r0 = r1;
        goto L_0x0012;
    L_0x0023:
        r4.m6209a(r5, r1);
        goto L_0x0018;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.iid.FirebaseInstanceIdService.b(android.content.Intent):void");
    }

    protected Intent mo900c(Intent intent) {
        return FirebaseInstanceIdInternalReceiver.m18896a();
    }

    public void m6222d(Intent intent) {
        String e = m6217e(intent);
        C3619c a = m6205a(e);
        String stringExtra = intent.getStringExtra("CMD");
        if (this.f4112f) {
            String valueOf = String.valueOf(intent.getExtras());
            Log.d("FirebaseInstanceId", new StringBuilder(((String.valueOf(e).length() + 18) + String.valueOf(stringExtra).length()) + String.valueOf(valueOf).length()).append("Service command ").append(e).append(" ").append(stringExtra).append(" ").append(valueOf).toString());
        }
        if (intent.getStringExtra("unregistered") != null) {
            C3623f c = a.m18911c();
            if (e == null) {
                e = "";
            }
            c.m18950e(e);
            a.m18913d().m18934d(intent);
        } else if ("gcm.googleapis.com/refresh".equals(intent.getStringExtra("from"))) {
            a.m18911c().m18950e(e);
            m6209a(intent, false);
        } else if ("RST".equals(stringExtra)) {
            a.m18910b();
            a.m18911c().m18950e(e);
            m6209a(intent, true);
        } else if ("RST_FULL".equals(stringExtra)) {
            if (!a.m18911c().m18946b()) {
                a.m18910b();
                a.m18911c().m18948c();
                m6209a(intent, true);
            }
        } else if ("SYNC".equals(stringExtra)) {
            a.m18911c().m18950e(e);
            m6209a(intent, false);
        } else if ("PING".equals(stringExtra)) {
            m6210a(a.m18913d(), intent.getExtras());
        }
    }
}
