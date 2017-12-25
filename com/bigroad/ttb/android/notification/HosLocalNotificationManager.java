package com.bigroad.ttb.android.notification;

import android.app.AlarmManager;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.support.v4.app.ad.C0137c;
import android.support.v4.app.ad.C0138d;
import com.bigroad.shared.ap;
import com.bigroad.shared.ap.C0842a;
import com.bigroad.shared.aq;
import com.bigroad.shared.duty.C0898i;
import com.bigroad.shared.duty.C0956v;
import com.bigroad.shared.duty.DutyLimits;
import com.bigroad.shared.duty.DutyStatus;
import com.bigroad.shared.duty.UpcomingDutyLimit;
import com.bigroad.ttb.android.AuthMonitor;
import com.bigroad.ttb.android.AuthMonitor.AuthStatus;
import com.bigroad.ttb.android.AuthMonitor.C1185a;
import com.bigroad.ttb.android.C2081g;
import com.bigroad.ttb.android.C2081g.C1230a;
import com.bigroad.ttb.android.C2081g.C1231b;
import com.bigroad.ttb.android.C2474y;
import com.bigroad.ttb.android.C2474y.C1182a;
import com.bigroad.ttb.android.C2474y.C1183b;
import com.bigroad.ttb.android.OurApplication;
import com.bigroad.ttb.android.R;
import com.bigroad.ttb.android.activity.C1632a;
import com.bigroad.ttb.android.event.EventManager;
import com.bigroad.ttb.android.event.EventManager.C1199e;
import com.bigroad.ttb.android.event.EventManager.ChangeListener;
import com.bigroad.ttb.android.p030a.C1257b;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class HosLocalNotificationManager extends C2204d {
    private static HosLocalNotificationManager f7622c;
    private final EventManager f7623d = OurApplication.m6295q();
    private C2081g f7624e = OurApplication.m6284f();
    private AlarmManager f7625f;
    private AuthMonitor f7626g = OurApplication.m6249F();
    private ap f7627h = OurApplication.m6269Z();
    private Map<NotificationType, C2203b> f7628i = new HashMap();
    private Set<NotificationType> f7629j = new HashSet();
    private Set<NotificationCategory> f7630k = new HashSet();
    private Intent f7631l = new Intent("com.bigroad.ttb.android.notification.HosLocalNotificationManager.ALARM");
    private final C2199a f7632m;
    private final C1230a f7633n = new C21891(this);
    private final ChangeListener f7634o = new C21902(this);
    private final C1182a f7635p = new C21913(this);
    private final C1185a f7636q = new C21924(this);
    private final Runnable f7637r = new C21935(this);
    private final BroadcastReceiver f7638s = new C21946(this);
    private final BroadcastReceiver f7639t = new C21957(this);

    class C21891 extends C1231b {
        final /* synthetic */ HosLocalNotificationManager f7585a;

        C21891(HosLocalNotificationManager hosLocalNotificationManager) {
            this.f7585a = hosLocalNotificationManager;
        }

        public void mo906a(C2081g c2081g) {
            this.f7585a.m10883a(true);
        }
    }

    class C21902 extends C1199e {
        final /* synthetic */ HosLocalNotificationManager f7586a;

        C21902(HosLocalNotificationManager hosLocalNotificationManager) {
            this.f7586a = hosLocalNotificationManager;
        }

        public void mo884a(EventManager eventManager, boolean z) {
            this.f7586a.m10883a(true);
        }
    }

    class C21913 extends C1183b {
        final /* synthetic */ HosLocalNotificationManager f7587a;

        C21913(HosLocalNotificationManager hosLocalNotificationManager) {
            this.f7587a = hosLocalNotificationManager;
        }

        public void mo868e(C2474y c2474y) {
            this.f7587a.m10883a(true);
        }
    }

    class C21924 implements C1185a {
        final /* synthetic */ HosLocalNotificationManager f7588a;

        C21924(HosLocalNotificationManager hosLocalNotificationManager) {
            this.f7588a = hosLocalNotificationManager;
        }

        public void mo912a(AuthStatus authStatus) {
            this.f7588a.m10883a(true);
        }
    }

    class C21935 implements Runnable {
        final /* synthetic */ HosLocalNotificationManager f7589a;

        C21935(HosLocalNotificationManager hosLocalNotificationManager) {
            this.f7589a = hosLocalNotificationManager;
        }

        public void run() {
            this.f7589a.m10878a(this.f7589a.f7627h.mo914b());
        }
    }

    class C21946 extends BroadcastReceiver {
        final /* synthetic */ HosLocalNotificationManager f7590a;

        C21946(HosLocalNotificationManager hosLocalNotificationManager) {
            this.f7590a = hosLocalNotificationManager;
        }

        public void onReceive(Context context, Intent intent) {
            this.f7590a.m10878a(this.f7590a.f7627h.mo914b());
        }
    }

    class C21957 extends BroadcastReceiver {
        final /* synthetic */ HosLocalNotificationManager f7591a;

        C21957(HosLocalNotificationManager hosLocalNotificationManager) {
            this.f7591a = hosLocalNotificationManager;
        }

        public void onReceive(Context context, Intent intent) {
            this.f7591a.m10883a(true);
        }
    }

    private enum NotificationCategory {
        BACKGROUND(R.string.dutyStatusNotification_readyTitle, 4),
        LOW_DRIVING_TIME(R.string.dutyStatusNotification_lowDriveTimeTitle, 5);
        
        private int m_id;
        private int m_title;

        private NotificationCategory(int i, int i2) {
            this.m_title = i;
            this.m_id = i2;
        }

        public int m10846a() {
            return this.m_title;
        }

        public int m10847b() {
            return this.m_id;
        }
    }

    private enum NotificationType {
        BREAK(true, false, R.string.dutyStatusNotification_breakComplete, NotificationCategory.BACKGROUND),
        SHIFT(false, false, R.string.dutyStatusNotification_shiftReset, NotificationCategory.BACKGROUND),
        CYCLE(false, false, R.string.dutyStatusNotification_cycleReset, NotificationCategory.BACKGROUND),
        SLEEPER_SPLIT(false, false, R.string.dutyStatusNotification_sleeperSplitComplete, NotificationCategory.BACKGROUND),
        LOW_DRIVE_TIME(true, true, R.plurals.dutyStatusNotification_lowDriveTime, NotificationCategory.LOW_DRIVING_TIME, 2);
        
        private NotificationCategory m_category;
        private boolean m_persistent;
        private int m_priority;
        private boolean m_sound;
        private int m_text;

        private NotificationType(boolean z, boolean z2, int i, NotificationCategory notificationCategory) {
            this(r9, r10, z, z2, i, notificationCategory, 0);
        }

        private NotificationType(boolean z, boolean z2, int i, NotificationCategory notificationCategory, int i2) {
            this.m_sound = z;
            this.m_persistent = z2;
            this.m_text = i;
            this.m_category = notificationCategory;
            this.m_priority = i2;
        }

        public boolean m10848a() {
            return this.m_sound;
        }

        public boolean m10849b() {
            return this.m_persistent;
        }

        public NotificationCategory m10850c() {
            return this.m_category;
        }

        public int m10851d() {
            return this.m_text;
        }

        public int m10852e() {
            return this.m_priority;
        }
    }

    private static class C2199a {
        private final ap f7604a;
        private Handler f7605b = new Handler();
        private Runnable f7606c;
        private long f7607d = 0;
        private long f7608e = 0;
        private C0842a f7609f;

        class C21971 implements C0842a {
            final /* synthetic */ C2199a f7602a;

            C21971(C2199a c2199a) {
                this.f7602a = c2199a;
            }

            public void mo1016a() {
                this.f7602a.m10857b(this.f7602a.f7604a.mo914b());
            }
        }

        class C21982 implements Runnable {
            final /* synthetic */ C2199a f7603a;

            C21982(C2199a c2199a) {
                this.f7603a = c2199a;
            }

            public void run() {
                this.f7603a.f7606c.run();
                this.f7603a.m10857b(this.f7603a.f7604a.mo914b());
            }
        }

        public C2199a(Runnable runnable, ap apVar) {
            this.f7604a = apVar;
            this.f7606c = runnable;
            this.f7609f = new C21971(this);
        }

        public void m10859a(long j, long j2, long j3) {
            if (m10860a()) {
                this.f7604a.m4203b(this.f7609f);
            }
            if (j < j3 + 60000) {
                this.f7607d = aq.m4214a(j2);
                this.f7608e = aq.m4214a(j3 + 60000);
            } else {
                this.f7607d = 0;
                this.f7608e = 0;
            }
            if (m10860a()) {
                this.f7604a.m4201a(this.f7609f);
            }
            this.f7604a.m4201a(this.f7609f);
        }

        public void m10858a(long j) {
            m10859a(j, 0, 0);
        }

        public boolean m10860a() {
            return this.f7607d < this.f7608e;
        }

        private void m10857b(long j) {
            if (this.f7606c != null) {
                this.f7605b.removeCallbacks(this.f7606c);
                if (m10860a() && j <= this.f7608e) {
                    long j2;
                    if (j < this.f7607d - 60000) {
                        j2 = this.f7607d;
                    } else {
                        j2 = aq.m4214a(j + 60000);
                    }
                    this.f7605b.postDelayed(new C21982(this), (j2 - j) + 1);
                }
            }
        }
    }

    private static class C2203b {
        private NotificationType f7616a;
        private long f7617b;
        private long f7618c;
        private C2200a f7619d;

        private interface C2200a {
            String mo1259a(long j);
        }

        private C2203b(NotificationType notificationType, long j, long j2, C2200a c2200a) {
            this.f7616a = notificationType;
            this.f7617b = j;
            this.f7618c = j2;
            this.f7619d = c2200a;
        }

        public static C2203b m10864a(final Context context, final NotificationType notificationType, long j, final long j2) {
            return new C2203b(notificationType, j, j, new C2200a() {
                public String mo1259a(long j) {
                    return context.getResources().getString(notificationType.m10851d(), new Object[]{C2203b.m10867b(context, j2)});
                }
            });
        }

        public static C2203b m10866b(final Context context, final NotificationType notificationType, long j, final long j2) {
            return new C2203b(notificationType, j, j2, new C2200a() {
                public String mo1259a(long j) {
                    int max = Math.max(0, ((int) (j2 / 60000)) - ((int) (j / 60000)));
                    return context.getResources().getQuantityString(notificationType.m10851d(), max, new Object[]{Integer.valueOf(max)});
                }
            });
        }

        public long m10868a() {
            return this.f7617b;
        }

        public long m10870b() {
            return this.f7618c;
        }

        public boolean m10871c() {
            return this.f7618c > this.f7617b;
        }

        public NotificationType m10872d() {
            return this.f7616a;
        }

        public String m10869a(long j) {
            return this.f7619d == null ? "" : this.f7619d.mo1259a(j);
        }

        private static String m10867b(Context context, long j) {
            StringBuilder stringBuilder = new StringBuilder();
            long j2 = j / 3600000;
            long j3 = (j - (3600000 * j2)) / 60000;
            if (j2 != 0) {
                stringBuilder.append(context.getResources().getString(R.string.dutyStatusNotification_hours, new Object[]{Integer.valueOf((int) j2)})).append(' ');
            }
            if (j3 != 0) {
                stringBuilder.append(context.getResources().getString(R.string.dutyStatusNotification_minutes, new Object[]{Integer.valueOf((int) j3)})).append(' ');
            }
            return stringBuilder.toString();
        }
    }

    public static HosLocalNotificationManager m10877a(Context context) {
        if (f7622c == null) {
            f7622c = new HosLocalNotificationManager(context);
        }
        return f7622c;
    }

    private HosLocalNotificationManager(Context context) {
        super(context);
        for (NotificationType notificationType : NotificationType.values()) {
            if (PendingIntent.getBroadcast(this.b, notificationType.ordinal(), this.f7631l, 536870912) != null) {
                this.f7629j.add(notificationType);
            }
        }
        for (NotificationType notificationType2 : NotificationType.values()) {
            if (notificationType2.m10849b()) {
                this.f7630k.add(notificationType2.m10850c());
            }
        }
        this.f7624e.m10446a(this.f7633n);
        this.f7623d.m10012a(this.f7634o);
        this.f7626g.m6027a(this.f7636q);
        this.f7625f = (AlarmManager) context.getSystemService("alarm");
        OurApplication.m6285g().m12184a(this.f7635p);
        this.b.registerReceiver(this.f7638s, new IntentFilter("com.bigroad.ttb.android.notification.HosLocalNotificationManager.ALARM"));
        this.b.registerReceiver(this.f7639t, new IntentFilter("android.intent.action.TIME_SET"));
        this.f7632m = new C2199a(this.f7637r, this.f7627h);
        m10883a(false);
    }

    private PendingIntent m10875a(NotificationCategory notificationCategory) {
        return PendingIntent.getActivity(this.b, notificationCategory.m10847b(), C1632a.m8005m(this.b), 0);
    }

    private void m10879a(long j, C2203b c2203b) {
        if (c2203b.m10872d().m10849b()) {
            this.f7630k.add(c2203b.m10872d().m10850c());
        }
        m10874a(c2203b.m10872d().m10850c().m10847b(), m10884b(j, c2203b));
    }

    private void m10886b(NotificationCategory notificationCategory) {
        this.f7630k.remove(notificationCategory);
        m10873a(notificationCategory.m10847b());
    }

    private void m10883a(boolean z) {
        long b = this.f7627h.mo914b();
        if (z) {
            m10878a(b);
        }
        this.f7628i = new HashMap();
        for (C2203b c2203b : m10887c(b)) {
            this.f7628i.put(c2203b.m10872d(), c2203b);
        }
        m10889d(b);
        m10885b(b);
        m10878a(b);
    }

    private void m10878a(long j) {
        if (this.f7624e.m10447a()) {
            m10886b(NotificationCategory.BACKGROUND);
        }
        List<C2203b> arrayList = new ArrayList();
        for (C2203b c2203b : this.f7628i.values()) {
            if (j >= c2203b.m10868a()) {
                arrayList.add(c2203b);
            }
        }
        Set<NotificationCategory> hashSet = new HashSet(this.f7630k);
        for (C2203b c2203b2 : arrayList) {
            if (!c2203b2.m10872d().m10849b()) {
                this.f7628i.remove(c2203b2.m10872d());
            }
            hashSet.remove(c2203b2.m10872d().m10850c());
            m10879a(j, c2203b2);
        }
        for (NotificationCategory b : hashSet) {
            m10886b(b);
        }
        m10889d(j);
    }

    private void m10885b(long j) {
        C2203b c2203b = null;
        for (C2203b c2203b2 : this.f7628i.values()) {
            C2203b c2203b22;
            if (!c2203b22.m10871c() || c2203b22.m10870b() < j || (c2203b != null && c2203b22.m10868a() >= c2203b.m10868a())) {
                c2203b22 = c2203b;
            }
            c2203b = c2203b22;
        }
        if (c2203b != null) {
            this.f7632m.m10859a(j, c2203b.m10868a(), c2203b.m10870b());
            return;
        }
        this.f7632m.m10858a(j);
    }

    private List<C2203b> m10887c(long j) {
        if (!this.f7626g.m6031d()) {
            return Collections.emptyList();
        }
        C0956v r = OurApplication.m6285g().m12228r();
        DutyLimits a = DutyLimits.m4362a(r.m4881o(), new C0898i(OurApplication.m6296r().m8493g(), this.f7623d.m10025b(), j, r.m4868b()));
        DutyStatus j2 = this.f7623d.m10060j();
        List<C2203b> arrayList = new ArrayList();
        if (this.f7624e.m10450b()) {
            for (UpcomingDutyLimit upcomingDutyLimit : UpcomingDutyLimit.m4409a(a, j2)) {
                NotificationType notificationType;
                switch (upcomingDutyLimit.m4411a()) {
                    case BREAK_COMPLETE:
                        notificationType = NotificationType.BREAK;
                        break;
                    case SHIFT_COMPLETE:
                        notificationType = NotificationType.SHIFT;
                        break;
                    case CYCLE_COMPLETE:
                        notificationType = NotificationType.CYCLE;
                        break;
                    case SLEEPER_SPLIT:
                        notificationType = NotificationType.SLEEPER_SPLIT;
                        break;
                    default:
                        continue;
                }
                arrayList.add(C2203b.m10864a(this.b, notificationType, aq.m4214a(upcomingDutyLimit.m4412b().m4402b() + j), upcomingDutyLimit.m4412b().m4403c()));
            }
        }
        if (j2.m4395c()) {
            long a2;
            for (UpcomingDutyLimit upcomingDutyLimit2 : UpcomingDutyLimit.m4409a(a, DutyStatus.DRIVING)) {
                if (upcomingDutyLimit2.m4411a().m4408a()) {
                    if (upcomingDutyLimit2 != null) {
                        a2 = aq.m4214a(upcomingDutyLimit2.m4412b().m4402b() + j);
                        arrayList.add(C2203b.m10866b(this.b, NotificationType.LOW_DRIVE_TIME, a2 - 1800000, a2));
                    }
                }
            }
            UpcomingDutyLimit upcomingDutyLimit22 = null;
            if (upcomingDutyLimit22 != null) {
                a2 = aq.m4214a(upcomingDutyLimit22.m4412b().m4402b() + j);
                arrayList.add(C2203b.m10866b(this.b, NotificationType.LOW_DRIVE_TIME, a2 - 1800000, a2));
            }
        }
        return arrayList;
    }

    private Notification m10884b(long j, C2203b c2203b) {
        NotificationType d = c2203b.m10872d();
        CharSequence string = this.b.getResources().getString(d.m10850c().m10846a());
        CharSequence a = c2203b.m10869a(j);
        C0138d c = new C0138d(this.b).m636a(string).m642b(a).m630a(m10875a(d.m10850c())).m626a((int) R.drawable.status_notification_icon).m649d(string).m628a(c2203b.m10868a()).m644c(d.m10852e());
        c.m635a(new C0137c().m622c(a));
        if (d.m10848a()) {
            c.m640b(3);
        }
        if (c2203b.m10872d().m10849b()) {
            c.m638a(true).m643b(true);
        } else {
            c.m646c(true);
        }
        c.m627a(this.b.getResources().getColor(R.color.brand), 1000, 5000);
        return c.m639b();
    }

    private void m10889d(long j) {
        Set<NotificationType> hashSet = new HashSet(this.f7629j);
        for (C2203b c2203b : this.f7628i.values()) {
            m10888c(j, c2203b);
            hashSet.remove(c2203b.m10872d());
        }
        for (NotificationType a : hashSet) {
            m10880a(a);
        }
    }

    private void m10888c(long j, C2203b c2203b) {
        long a = c2203b.m10868a();
        if (j > a) {
            a = c2203b.m10870b();
            if (j > a) {
                return;
            }
        }
        C1257b.m6610a(this.f7625f, 0, a, PendingIntent.getBroadcast(this.b, c2203b.m10872d().ordinal(), this.f7631l, 134217728));
        this.f7629j.add(c2203b.m10872d());
    }

    private void m10880a(NotificationType notificationType) {
        PendingIntent broadcast = PendingIntent.getBroadcast(this.b, notificationType.ordinal(), this.f7631l, 536870912);
        if (broadcast != null) {
            this.f7625f.cancel(broadcast);
            broadcast.cancel();
        }
        this.f7629j.remove(notificationType);
    }
}
