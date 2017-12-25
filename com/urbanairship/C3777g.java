package com.urbanairship;

import android.annotation.TargetApi;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.app.ad.C0134a;
import android.support.v4.app.ad.C0138d;
import android.support.v4.app.am;
import android.support.v4.content.C0126a;
import android.support.v4.content.C0265i;
import android.text.ClipboardManager;
import android.util.Base64;
import com.urbanairship.C3860o.C3850c;
import com.urbanairship.C3860o.C3851d;
import com.urbanairship.C3860o.C3856i;
import com.urbanairship.json.JsonValue;
import com.urbanairship.push.C3919j;
import com.urbanairship.util.C3954i;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

@TargetApi(8)
class C3777g extends C3680a {
    Executor f13550a;
    private final Context f13551b;
    private final C3761b f13552c;
    private final C3919j f13553d;
    private final am f13554e;
    private C3774a f13555f;
    private final BroadcastReceiver f13556g;

    class C37721 extends BroadcastReceiver {
        final /* synthetic */ C3777g f13544a;

        class C37711 implements Runnable {
            final /* synthetic */ C37721 f13543a;

            C37711(C37721 c37721) {
                this.f13543a = c37721;
            }

            public void run() {
                this.f13543a.f13544a.m19696b();
            }
        }

        C37721(C3777g c3777g) {
            this.f13544a = c3777g;
        }

        public void onReceive(Context context, Intent intent) {
            this.f13544a.f13550a.execute(new C37711(this));
        }
    }

    class C37732 implements Runnable {
        final /* synthetic */ C3777g f13545a;

        C37732(C3777g c3777g) {
            this.f13545a = c3777g;
        }

        public void run() {
            this.f13545a.f13555f = VERSION.SDK_INT >= 11 ? new C3776c(this.f13545a) : new C3775b(this.f13545a);
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("com.urbanairship.analytics.APP_FOREGROUND");
            C0265i.m1105a(this.f13545a.f13551b).m1109a(this.f13545a.f13556g, intentFilter);
        }
    }

    private interface C3774a {
        String mo2789a();

        void mo2790b();
    }

    private class C3775b implements C3774a {
        final /* synthetic */ C3777g f13546a;
        private final ClipboardManager f13547b;

        C3775b(C3777g c3777g) {
            this.f13546a = c3777g;
            this.f13547b = (ClipboardManager) c3777g.f13551b.getSystemService("clipboard");
        }

        public String mo2789a() {
            return String.valueOf(this.f13547b.getText());
        }

        public void mo2790b() {
            this.f13547b.setText("");
        }
    }

    @TargetApi(11)
    private class C3776c implements C3774a {
        final /* synthetic */ C3777g f13548a;
        private final android.content.ClipboardManager f13549b;

        C3776c(C3777g c3777g) {
            this.f13548a = c3777g;
            this.f13549b = (android.content.ClipboardManager) c3777g.f13551b.getSystemService("clipboard");
        }

        public String mo2789a() {
            if (!this.f13549b.hasPrimaryClip()) {
                return null;
            }
            ClipData primaryClip = this.f13549b.getPrimaryClip();
            if (primaryClip != null && primaryClip.getItemCount() > 0) {
                for (int i = 0; i < primaryClip.getItemCount(); i++) {
                    CharSequence text = primaryClip.getItemAt(i).getText();
                    if (text != null) {
                        return text.toString();
                    }
                }
            }
            return null;
        }

        public void mo2790b() {
            this.f13549b.setPrimaryClip(ClipData.newPlainText("", ""));
        }
    }

    C3777g(Context context, C3761b c3761b, C3919j c3919j) {
        this(context, c3761b, c3919j, am.m737a(context));
    }

    C3777g(Context context, C3761b c3761b, C3919j c3919j, am amVar) {
        this.f13550a = Executors.newSingleThreadExecutor();
        this.f13551b = context.getApplicationContext();
        this.f13552c = c3761b;
        this.f13553d = c3919j;
        this.f13554e = amVar;
        this.f13556g = new C37721(this);
    }

    protected void mo2777a() {
        if (this.f13552c.f13519s) {
            new Handler(Looper.getMainLooper()).post(new C37732(this));
        }
    }

    private void m19696b() {
        String u = this.f13553d.m20329u();
        if (!C3954i.m20512a(u)) {
            try {
                String a = m19691a(this.f13555f.mo2789a());
                CharSequence c = m19699c();
                if (!C3954i.m20512a(a) && a.startsWith(c)) {
                    if (a.length() > c.length()) {
                        a = a.replace(c, "https://go.urbanairship.com/").replace("CHANNEL", u).trim();
                    } else {
                        a = null;
                    }
                    try {
                        this.f13555f.mo2790b();
                    } catch (SecurityException e) {
                        C3783j.m19725c("Unable to clear clipboard: " + e.getMessage());
                    }
                    m19693a(u, a);
                }
            } catch (SecurityException e2) {
                C3783j.m19725c("Unable to read clipboard: " + e2.getMessage());
            }
        }
    }

    private String m19691a(String str) {
        if (C3954i.m20512a(str)) {
            return null;
        }
        try {
            return new String(Base64.decode(str, 0), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            C3783j.m19723b("ClipBoardMagic - Unsupported encoding.");
            return null;
        } catch (IllegalArgumentException e2) {
            C3783j.m19723b("ClipBoardMagic - Failed to decode string.");
            return null;
        }
    }

    private void m19693a(String str, String str2) {
        PendingIntent pendingIntent;
        PendingIntent b = m19694b(str);
        PendingIntent c = str2 == null ? null : m19697c(str2);
        C0138d d = new C0138d(this.f13551b).m646c(true).m650d(true).m636a(this.f13551b.getPackageManager().getApplicationLabel(this.f13551b.getApplicationInfo()).toString()).m642b((CharSequence) str).m626a(C3851d.ua_ic_urbanairship_notification).m648d(C0126a.m584b(this.f13551b, C3850c.urban_airship_blue)).m640b(-1).m644c(2).m649d(this.f13551b.getString(C3856i.ua_channel_notification_ticker));
        if (c == null) {
            pendingIntent = b;
        } else {
            pendingIntent = c;
        }
        C0138d a = d.m630a(pendingIntent).m633a(new C0134a(C3851d.ua_ic_notification_button_copy, this.f13551b.getString(C3856i.ua_notification_button_copy), b));
        if (c != null) {
            a.m633a(new C0134a(C3851d.ua_ic_notification_button_open_browser, this.f13551b.getString(C3856i.ua_notification_button_save), c));
        }
        this.f13554e.m742a(3000, a.m639b());
    }

    private String m19699c() {
        byte[] bytes = this.f13552c.m19664a().getBytes();
        byte[] bytes2 = this.f13552c.m19666b().getBytes();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < bytes.length; i++) {
            stringBuilder.append(String.format("%02x", new Object[]{Byte.valueOf((byte) (bytes[i] ^ bytes2[i % bytes2.length]))}));
        }
        return stringBuilder.toString();
    }

    private PendingIntent m19694b(String str) {
        Map hashMap = new HashMap();
        hashMap.put("text", str);
        hashMap.put("label", "Urban Airship Channel");
        Object hashMap2 = new HashMap();
        hashMap2.put("clipboard_action", hashMap);
        hashMap2.put("toast_action", this.f13551b.getString(C3856i.ua_channel_copy_toast));
        return PendingIntent.getBroadcast(this.f13551b, 3000, new Intent(this.f13551b, CoreReceiver.class).setAction("com.urbanairship.ACTION_CHANNEL_CAPTURE").addCategory(UUID.randomUUID().toString()).putExtra("com.urbanairship.EXTRA_NOTIFICATION_ID", 3000).putExtra("com.urbanairship.EXTRA_ACTIONS", JsonValue.m19732a(hashMap2).toString()), 0);
    }

    private PendingIntent m19697c(String str) {
        Object hashMap = new HashMap();
        hashMap.put("open_external_url_action", str);
        return PendingIntent.getActivity(this.f13551b, 3000, new Intent(this.f13551b, CoreActivity.class).setAction("com.urbanairship.ACTION_CHANNEL_CAPTURE").addCategory(UUID.randomUUID().toString()).putExtra("com.urbanairship.EXTRA_NOTIFICATION_ID", 3000).putExtra("com.urbanairship.EXTRA_ACTIONS", JsonValue.m19732a(hashMap).toString()), 0);
    }
}
