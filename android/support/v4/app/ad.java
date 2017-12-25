package android.support.v4.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.ae.C0152a;
import android.support.v4.app.af.C0153a;
import android.support.v4.app.ag.C0133a;
import android.support.v4.app.ag.C0133a.C0129a;
import android.support.v4.app.aj.C0154a;
import android.support.v4.app.ak.C0155a;
import android.support.v4.app.al.C0156a;
import android.support.v4.app.aq.C0174a;
import android.widget.RemoteViews;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ad {
    private static final C0142h f543a;

    public static class C0134a extends C0133a {
        public static final C0129a f487d = new C01301();
        public int f488a;
        public CharSequence f489b;
        public PendingIntent f490c;
        private final Bundle f491e;
        private final ao[] f492f;

        static class C01301 implements C0129a {
            C01301() {
            }
        }

        public static final class C0131a {
            private final int f482a;
            private final CharSequence f483b;
            private final PendingIntent f484c;
            private final Bundle f485d;
            private ArrayList<ao> f486e;

            public C0131a(int i, CharSequence charSequence, PendingIntent pendingIntent) {
                this(i, charSequence, pendingIntent, new Bundle());
            }

            private C0131a(int i, CharSequence charSequence, PendingIntent pendingIntent, Bundle bundle) {
                this.f482a = i;
                this.f483b = C0138d.m624e(charSequence);
                this.f484c = pendingIntent;
                this.f485d = bundle;
            }

            public C0131a m600a(Bundle bundle) {
                if (bundle != null) {
                    this.f485d.putAll(bundle);
                }
                return this;
            }

            public C0131a m602a(ao aoVar) {
                if (this.f486e == null) {
                    this.f486e = new ArrayList();
                }
                this.f486e.add(aoVar);
                return this;
            }

            public C0131a m601a(C0132b c0132b) {
                c0132b.m604a(this);
                return this;
            }

            public C0134a m603a() {
                ao[] aoVarArr;
                if (this.f486e != null) {
                    aoVarArr = (ao[]) this.f486e.toArray(new ao[this.f486e.size()]);
                } else {
                    aoVarArr = null;
                }
                return new C0134a(this.f482a, this.f483b, this.f484c, this.f485d, aoVarArr);
            }
        }

        public interface C0132b {
            C0131a m604a(C0131a c0131a);
        }

        public /* synthetic */ C0174a[] mo117f() {
            return m614e();
        }

        public C0134a(int i, CharSequence charSequence, PendingIntent pendingIntent) {
            this(i, charSequence, pendingIntent, new Bundle(), null);
        }

        private C0134a(int i, CharSequence charSequence, PendingIntent pendingIntent, Bundle bundle, ao[] aoVarArr) {
            this.f488a = i;
            this.f489b = C0138d.m624e(charSequence);
            this.f490c = pendingIntent;
            if (bundle == null) {
                bundle = new Bundle();
            }
            this.f491e = bundle;
            this.f492f = aoVarArr;
        }

        public int mo113a() {
            return this.f488a;
        }

        public CharSequence mo114b() {
            return this.f489b;
        }

        public PendingIntent mo115c() {
            return this.f490c;
        }

        public Bundle mo116d() {
            return this.f491e;
        }

        public ao[] m614e() {
            return this.f492f;
        }
    }

    public static abstract class C0135q {
        C0138d f493d;
        CharSequence f494e;
        CharSequence f495f;
        boolean f496g = false;

        public void m616a(C0138d c0138d) {
            if (this.f493d != c0138d) {
                this.f493d = c0138d;
                if (this.f493d != null) {
                    this.f493d.m635a(this);
                }
            }
        }
    }

    public static class C0136b extends C0135q {
        Bitmap f497a;
        Bitmap f498b;
        boolean f499c;

        public C0136b m618a(CharSequence charSequence) {
            this.e = C0138d.m624e(charSequence);
            return this;
        }

        public C0136b m619b(CharSequence charSequence) {
            this.f = C0138d.m624e(charSequence);
            this.g = true;
            return this;
        }

        public C0136b m617a(Bitmap bitmap) {
            this.f497a = bitmap;
            return this;
        }
    }

    public static class C0137c extends C0135q {
        CharSequence f500a;

        public C0137c m620a(CharSequence charSequence) {
            this.e = C0138d.m624e(charSequence);
            return this;
        }

        public C0137c m621b(CharSequence charSequence) {
            this.f = C0138d.m624e(charSequence);
            this.g = true;
            return this;
        }

        public C0137c m622c(CharSequence charSequence) {
            this.f500a = C0138d.m624e(charSequence);
            return this;
        }
    }

    public static class C0138d {
        Notification f501A;
        public Notification f502B = new Notification();
        public ArrayList<String> f503C;
        public Context f504a;
        public CharSequence f505b;
        public CharSequence f506c;
        PendingIntent f507d;
        PendingIntent f508e;
        RemoteViews f509f;
        public Bitmap f510g;
        public CharSequence f511h;
        public int f512i;
        int f513j;
        boolean f514k = true;
        public boolean f515l;
        public C0135q f516m;
        public CharSequence f517n;
        int f518o;
        int f519p;
        boolean f520q;
        String f521r;
        boolean f522s;
        String f523t;
        public ArrayList<C0134a> f524u = new ArrayList();
        boolean f525v = false;
        String f526w;
        Bundle f527x;
        int f528y = 0;
        int f529z = 0;

        public C0138d(Context context) {
            this.f504a = context;
            this.f502B.when = System.currentTimeMillis();
            this.f502B.audioStreamType = -1;
            this.f513j = 0;
            this.f503C = new ArrayList();
        }

        public C0138d m628a(long j) {
            this.f502B.when = j;
            return this;
        }

        public C0138d m626a(int i) {
            this.f502B.icon = i;
            return this;
        }

        public C0138d m636a(CharSequence charSequence) {
            this.f505b = C0138d.m624e(charSequence);
            return this;
        }

        public C0138d m642b(CharSequence charSequence) {
            this.f506c = C0138d.m624e(charSequence);
            return this;
        }

        public C0138d m645c(CharSequence charSequence) {
            this.f517n = C0138d.m624e(charSequence);
            return this;
        }

        public C0138d m630a(PendingIntent pendingIntent) {
            this.f507d = pendingIntent;
            return this;
        }

        public C0138d m641b(PendingIntent pendingIntent) {
            this.f502B.deleteIntent = pendingIntent;
            return this;
        }

        public C0138d m649d(CharSequence charSequence) {
            this.f502B.tickerText = C0138d.m624e(charSequence);
            return this;
        }

        public C0138d m631a(Bitmap bitmap) {
            this.f510g = bitmap;
            return this;
        }

        public C0138d m632a(Uri uri) {
            this.f502B.sound = uri;
            this.f502B.audioStreamType = -1;
            return this;
        }

        public C0138d m627a(int i, int i2, int i3) {
            int i4;
            int i5 = 1;
            this.f502B.ledARGB = i;
            this.f502B.ledOnMS = i2;
            this.f502B.ledOffMS = i3;
            if (this.f502B.ledOnMS == 0 || this.f502B.ledOffMS == 0) {
                i4 = 0;
            } else {
                i4 = 1;
            }
            Notification notification = this.f502B;
            int i6 = this.f502B.flags & -2;
            if (i4 == 0) {
                i5 = 0;
            }
            notification.flags = i6 | i5;
            return this;
        }

        public C0138d m638a(boolean z) {
            m623a(2, z);
            return this;
        }

        public C0138d m643b(boolean z) {
            m623a(8, z);
            return this;
        }

        public C0138d m646c(boolean z) {
            m623a(16, z);
            return this;
        }

        public C0138d m650d(boolean z) {
            this.f525v = z;
            return this;
        }

        public C0138d m637a(String str) {
            this.f526w = str;
            return this;
        }

        public C0138d m640b(int i) {
            this.f502B.defaults = i;
            if ((i & 4) != 0) {
                Notification notification = this.f502B;
                notification.flags |= 1;
            }
            return this;
        }

        private void m623a(int i, boolean z) {
            if (z) {
                Notification notification = this.f502B;
                notification.flags |= i;
                return;
            }
            notification = this.f502B;
            notification.flags &= i ^ -1;
        }

        public C0138d m644c(int i) {
            this.f513j = i;
            return this;
        }

        public Bundle m625a() {
            if (this.f527x == null) {
                this.f527x = new Bundle();
            }
            return this.f527x;
        }

        public C0138d m633a(C0134a c0134a) {
            this.f524u.add(c0134a);
            return this;
        }

        public C0138d m635a(C0135q c0135q) {
            if (this.f516m != c0135q) {
                this.f516m = c0135q;
                if (this.f516m != null) {
                    this.f516m.m616a(this);
                }
            }
            return this;
        }

        public C0138d m648d(int i) {
            this.f528y = i;
            return this;
        }

        public C0138d m651e(int i) {
            this.f529z = i;
            return this;
        }

        public C0138d m629a(Notification notification) {
            this.f501A = notification;
            return this;
        }

        public C0138d m634a(C0140f c0140f) {
            c0140f.mo121a(this);
            return this;
        }

        public Notification m639b() {
            return ad.f543a.mo118a(this, m647c());
        }

        protected C0139e m647c() {
            return new C0139e();
        }

        protected static CharSequence m624e(CharSequence charSequence) {
            if (charSequence != null && charSequence.length() > 5120) {
                return charSequence.subSequence(0, 5120);
            }
            return charSequence;
        }
    }

    protected static class C0139e {
        protected C0139e() {
        }

        public Notification m652a(C0138d c0138d, ac acVar) {
            return acVar.mo124b();
        }
    }

    public interface C0140f {
        C0138d mo121a(C0138d c0138d);
    }

    public static class C0141g extends C0135q {
        ArrayList<CharSequence> f530a = new ArrayList();

        public C0141g m654a(CharSequence charSequence) {
            this.e = C0138d.m624e(charSequence);
            return this;
        }

        public C0141g m655b(CharSequence charSequence) {
            this.f = C0138d.m624e(charSequence);
            this.g = true;
            return this;
        }

        public C0141g m656c(CharSequence charSequence) {
            this.f530a.add(C0138d.m624e(charSequence));
            return this;
        }
    }

    interface C0142h {
        Notification mo118a(C0138d c0138d, C0139e c0139e);

        Bundle mo119a(Notification notification);

        ArrayList<Parcelable> mo120a(C0134a[] c0134aArr);
    }

    static class C0143k implements C0142h {
        C0143k() {
        }

        public Notification mo118a(C0138d c0138d, C0139e c0139e) {
            Notification a = ag.m694a(c0138d.f502B, c0138d.f504a, c0138d.f505b, c0138d.f506c, c0138d.f507d);
            if (c0138d.f513j > 0) {
                a.flags |= 128;
            }
            return a;
        }

        public Bundle mo119a(Notification notification) {
            return null;
        }

        public ArrayList<Parcelable> mo120a(C0134a[] c0134aArr) {
            return null;
        }
    }

    static class C0144o extends C0143k {
        C0144o() {
        }

        public Notification mo118a(C0138d c0138d, C0139e c0139e) {
            ac c0155a = new C0155a(c0138d.f504a, c0138d.f502B, c0138d.f505b, c0138d.f506c, c0138d.f511h, c0138d.f509f, c0138d.f512i, c0138d.f507d, c0138d.f508e, c0138d.f510g, c0138d.f518o, c0138d.f519p, c0138d.f520q, c0138d.f515l, c0138d.f513j, c0138d.f517n, c0138d.f525v, c0138d.f527x, c0138d.f521r, c0138d.f522s, c0138d.f523t);
            ad.m683b((ab) c0155a, c0138d.f524u);
            ad.m684b(c0155a, c0138d.f516m);
            return c0139e.m652a(c0138d, c0155a);
        }

        public Bundle mo119a(Notification notification) {
            return ak.m703a(notification);
        }

        public ArrayList<Parcelable> mo120a(C0134a[] c0134aArr) {
            return ak.m706a((C0133a[]) c0134aArr);
        }
    }

    static class C0145p extends C0144o {
        C0145p() {
        }

        public Notification mo118a(C0138d c0138d, C0139e c0139e) {
            ac c0156a = new C0156a(c0138d.f504a, c0138d.f502B, c0138d.f505b, c0138d.f506c, c0138d.f511h, c0138d.f509f, c0138d.f512i, c0138d.f507d, c0138d.f508e, c0138d.f510g, c0138d.f518o, c0138d.f519p, c0138d.f520q, c0138d.f514k, c0138d.f515l, c0138d.f513j, c0138d.f517n, c0138d.f525v, c0138d.f503C, c0138d.f527x, c0138d.f521r, c0138d.f522s, c0138d.f523t);
            ad.m683b((ab) c0156a, c0138d.f524u);
            ad.m684b(c0156a, c0138d.f516m);
            return c0139e.m652a(c0138d, c0156a);
        }

        public Bundle mo119a(Notification notification) {
            return al.m713a(notification);
        }
    }

    static class C0146i extends C0145p {
        C0146i() {
        }

        public Notification mo118a(C0138d c0138d, C0139e c0139e) {
            ac c0152a = new C0152a(c0138d.f504a, c0138d.f502B, c0138d.f505b, c0138d.f506c, c0138d.f511h, c0138d.f509f, c0138d.f512i, c0138d.f507d, c0138d.f508e, c0138d.f510g, c0138d.f518o, c0138d.f519p, c0138d.f520q, c0138d.f514k, c0138d.f515l, c0138d.f513j, c0138d.f517n, c0138d.f525v, c0138d.f503C, c0138d.f527x, c0138d.f521r, c0138d.f522s, c0138d.f523t);
            ad.m683b((ab) c0152a, c0138d.f524u);
            ad.m684b(c0152a, c0138d.f516m);
            return c0139e.m652a(c0138d, c0152a);
        }

        public ArrayList<Parcelable> mo120a(C0134a[] c0134aArr) {
            return ae.m689a((C0133a[]) c0134aArr);
        }
    }

    static class C0147j extends C0146i {
        C0147j() {
        }

        public Notification mo118a(C0138d c0138d, C0139e c0139e) {
            ac c0153a = new C0153a(c0138d.f504a, c0138d.f502B, c0138d.f505b, c0138d.f506c, c0138d.f511h, c0138d.f509f, c0138d.f512i, c0138d.f507d, c0138d.f508e, c0138d.f510g, c0138d.f518o, c0138d.f519p, c0138d.f520q, c0138d.f514k, c0138d.f515l, c0138d.f513j, c0138d.f517n, c0138d.f525v, c0138d.f526w, c0138d.f503C, c0138d.f527x, c0138d.f528y, c0138d.f529z, c0138d.f501A, c0138d.f521r, c0138d.f522s, c0138d.f523t);
            ad.m683b((ab) c0153a, c0138d.f524u);
            ad.m684b(c0153a, c0138d.f516m);
            return c0139e.m652a(c0138d, c0153a);
        }
    }

    static class C0148l extends C0143k {
        C0148l() {
        }

        public Notification mo118a(C0138d c0138d, C0139e c0139e) {
            Notification a = ah.m695a(c0138d.f502B, c0138d.f504a, c0138d.f505b, c0138d.f506c, c0138d.f507d, c0138d.f508e);
            if (c0138d.f513j > 0) {
                a.flags |= 128;
            }
            return a;
        }
    }

    static class C0149m extends C0143k {
        C0149m() {
        }

        public Notification mo118a(C0138d c0138d, C0139e c0139e) {
            return ai.m696a(c0138d.f504a, c0138d.f502B, c0138d.f505b, c0138d.f506c, c0138d.f511h, c0138d.f509f, c0138d.f512i, c0138d.f507d, c0138d.f508e, c0138d.f510g);
        }
    }

    static class C0150n extends C0143k {
        C0150n() {
        }

        public Notification mo118a(C0138d c0138d, C0139e c0139e) {
            return c0139e.m652a(c0138d, new C0154a(c0138d.f504a, c0138d.f502B, c0138d.f505b, c0138d.f506c, c0138d.f511h, c0138d.f509f, c0138d.f512i, c0138d.f507d, c0138d.f508e, c0138d.f510g, c0138d.f518o, c0138d.f519p, c0138d.f520q));
        }
    }

    public static final class C0151r implements C0140f {
        private ArrayList<C0134a> f531a = new ArrayList();
        private int f532b = 1;
        private PendingIntent f533c;
        private ArrayList<Notification> f534d = new ArrayList();
        private Bitmap f535e;
        private int f536f;
        private int f537g = 8388613;
        private int f538h = -1;
        private int f539i = 0;
        private int f540j;
        private int f541k = 80;
        private int f542l;

        public /* synthetic */ Object clone() {
            return m675a();
        }

        public C0138d mo121a(C0138d c0138d) {
            Bundle bundle = new Bundle();
            if (!this.f531a.isEmpty()) {
                bundle.putParcelableArrayList("actions", ad.f543a.mo120a((C0134a[]) this.f531a.toArray(new C0134a[this.f531a.size()])));
            }
            if (this.f532b != 1) {
                bundle.putInt("flags", this.f532b);
            }
            if (this.f533c != null) {
                bundle.putParcelable("displayIntent", this.f533c);
            }
            if (!this.f534d.isEmpty()) {
                bundle.putParcelableArray("pages", (Parcelable[]) this.f534d.toArray(new Notification[this.f534d.size()]));
            }
            if (this.f535e != null) {
                bundle.putParcelable("background", this.f535e);
            }
            if (this.f536f != 0) {
                bundle.putInt("contentIcon", this.f536f);
            }
            if (this.f537g != 8388613) {
                bundle.putInt("contentIconGravity", this.f537g);
            }
            if (this.f538h != -1) {
                bundle.putInt("contentActionIndex", this.f538h);
            }
            if (this.f539i != 0) {
                bundle.putInt("customSizePreset", this.f539i);
            }
            if (this.f540j != 0) {
                bundle.putInt("customContentHeight", this.f540j);
            }
            if (this.f541k != 80) {
                bundle.putInt("gravity", this.f541k);
            }
            if (this.f542l != 0) {
                bundle.putInt("hintScreenTimeout", this.f542l);
            }
            c0138d.m625a().putBundle("android.wearable.EXTENSIONS", bundle);
            return c0138d;
        }

        public C0151r m675a() {
            C0151r c0151r = new C0151r();
            c0151r.f531a = new ArrayList(this.f531a);
            c0151r.f532b = this.f532b;
            c0151r.f533c = this.f533c;
            c0151r.f534d = new ArrayList(this.f534d);
            c0151r.f535e = this.f535e;
            c0151r.f536f = this.f536f;
            c0151r.f537g = this.f537g;
            c0151r.f538h = this.f538h;
            c0151r.f539i = this.f539i;
            c0151r.f540j = this.f540j;
            c0151r.f541k = this.f541k;
            c0151r.f542l = this.f542l;
            return c0151r;
        }

        public C0151r m678a(List<C0134a> list) {
            this.f531a.addAll(list);
            return this;
        }

        public C0151r m676a(Notification notification) {
            this.f534d.add(notification);
            return this;
        }

        public C0151r m677a(Bitmap bitmap) {
            this.f535e = bitmap;
            return this;
        }
    }

    private static void m683b(ab abVar, ArrayList<C0134a> arrayList) {
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            abVar.mo123a((C0134a) it.next());
        }
    }

    private static void m684b(ac acVar, C0135q c0135q) {
        if (c0135q == null) {
            return;
        }
        if (c0135q instanceof C0137c) {
            C0137c c0137c = (C0137c) c0135q;
            ak.m708a(acVar, c0137c.e, c0137c.g, c0137c.f, c0137c.f500a);
        } else if (c0135q instanceof C0141g) {
            C0141g c0141g = (C0141g) c0135q;
            ak.m709a(acVar, c0141g.e, c0141g.g, c0141g.f, c0141g.f530a);
        } else if (c0135q instanceof C0136b) {
            C0136b c0136b = (C0136b) c0135q;
            ak.m707a(acVar, c0136b.e, c0136b.g, c0136b.f, c0136b.f497a, c0136b.f498b, c0136b.f499c);
        }
    }

    static {
        if (VERSION.SDK_INT >= 21) {
            f543a = new C0147j();
        } else if (VERSION.SDK_INT >= 20) {
            f543a = new C0146i();
        } else if (VERSION.SDK_INT >= 19) {
            f543a = new C0145p();
        } else if (VERSION.SDK_INT >= 16) {
            f543a = new C0144o();
        } else if (VERSION.SDK_INT >= 14) {
            f543a = new C0150n();
        } else if (VERSION.SDK_INT >= 11) {
            f543a = new C0149m();
        } else if (VERSION.SDK_INT >= 9) {
            f543a = new C0148l();
        } else {
            f543a = new C0143k();
        }
    }

    public static Bundle m679a(Notification notification) {
        return f543a.mo119a(notification);
    }
}
