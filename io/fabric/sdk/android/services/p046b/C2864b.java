package io.fabric.sdk.android.services.p046b;

import android.content.Context;
import io.fabric.sdk.android.services.common.C4004j;
import io.fabric.sdk.android.services.common.CommonUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.TreeSet;
import java.util.concurrent.CopyOnWriteArrayList;

public abstract class C2864b<T> {
    protected final Context f9863a;
    protected final C2869a<T> f9864b;
    protected final C4004j f9865c;
    protected final C3983c f9866d;
    protected volatile long f9867e;
    protected final List<C2844d> f9868f = new CopyOnWriteArrayList();
    private final int f9869g;

    class C39811 implements Comparator<C3982a> {
        final /* synthetic */ C2864b f14090a;

        C39811(C2864b c2864b) {
            this.f14090a = c2864b;
        }

        public /* synthetic */ int compare(Object obj, Object obj2) {
            return m20651a((C3982a) obj, (C3982a) obj2);
        }

        public int m20651a(C3982a c3982a, C3982a c3982a2) {
            return (int) (c3982a.f14092b - c3982a2.f14092b);
        }
    }

    static class C3982a {
        final File f14091a;
        final long f14092b;

        public C3982a(File file, long j) {
            this.f14091a = file;
            this.f14092b = j;
        }
    }

    protected abstract String mo1449a();

    public C2864b(Context context, C2869a<T> c2869a, C4004j c4004j, C3983c c3983c, int i) {
        this.f9863a = context.getApplicationContext();
        this.f9864b = c2869a;
        this.f9866d = c3983c;
        this.f9865c = c4004j;
        this.f9867e = this.f9865c.mo2882a();
        this.f9869g = i;
    }

    public void m16095a(T t) {
        byte[] a = this.f9864b.mo1453a(t);
        m16090a(a.length);
        this.f9866d.mo2871a(a);
    }

    public void m16094a(C2844d c2844d) {
        if (c2844d != null) {
            this.f9868f.add(c2844d);
        }
    }

    public boolean m16099d() {
        boolean z = true;
        String str = null;
        if (this.f9866d.mo2873b()) {
            z = false;
        } else {
            str = mo1449a();
            this.f9866d.mo2869a(str);
            CommonUtils.m20700a(this.f9863a, 4, "Fabric", String.format(Locale.US, "generated new file %s", new Object[]{str}));
            this.f9867e = this.f9865c.mo2882a();
        }
        m16091b(str);
        return z;
    }

    private void m16090a(int i) {
        if (!this.f9866d.mo2872a(i, mo1451c())) {
            CommonUtils.m20700a(this.f9863a, 4, "Fabric", String.format(Locale.US, "session analytics events file is %d bytes, new event is %d bytes, this is over flush limit of %d, rolling it over", new Object[]{Integer.valueOf(this.f9866d.mo2867a()), Integer.valueOf(i), Integer.valueOf(mo1451c())}));
            m16099d();
        }
    }

    protected int mo1450b() {
        return this.f9869g;
    }

    protected int mo1451c() {
        return 8000;
    }

    private void m16091b(String str) {
        for (C2844d a : this.f9868f) {
            try {
                a.mo1433a(str);
            } catch (Throwable e) {
                CommonUtils.m20702a(this.f9863a, "One of the roll over listeners threw an exception", e);
            }
        }
    }

    public List<File> m16100e() {
        return this.f9866d.mo2868a(1);
    }

    public void m16096a(List<File> list) {
        this.f9866d.mo2870a((List) list);
    }

    public void m16101f() {
        this.f9866d.mo2870a(this.f9866d.mo2874c());
        this.f9866d.mo2875d();
    }

    public void m16102g() {
        List<File> c = this.f9866d.mo2874c();
        int b = mo1450b();
        if (c.size() > b) {
            int size = c.size() - b;
            CommonUtils.m20701a(this.f9863a, String.format(Locale.US, "Found %d files in  roll over directory, this is greater than %d, deleting %d oldest files", new Object[]{Integer.valueOf(c.size()), Integer.valueOf(b), Integer.valueOf(size)}));
            TreeSet treeSet = new TreeSet(new C39811(this));
            for (File file : c) {
                treeSet.add(new C3982a(file, m16092a(file.getName())));
            }
            List arrayList = new ArrayList();
            Iterator it = treeSet.iterator();
            while (it.hasNext()) {
                arrayList.add(((C3982a) it.next()).f14091a);
                if (arrayList.size() == size) {
                    break;
                }
            }
            this.f9866d.mo2870a(arrayList);
        }
    }

    public long m16092a(String str) {
        long j = 0;
        String[] split = str.split("_");
        if (split.length == 3) {
            try {
                j = Long.valueOf(split[2]).longValue();
            } catch (NumberFormatException e) {
            }
        }
        return j;
    }
}
