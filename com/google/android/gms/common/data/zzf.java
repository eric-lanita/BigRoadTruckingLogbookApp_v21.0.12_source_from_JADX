package com.google.android.gms.common.data;

import java.util.ArrayList;

public abstract class zzf<T> extends AbstractDataBuffer<T> {
    private boolean f10608b;
    private ArrayList<Integer> f10609c;

    private void m16825c() {
        synchronized (this) {
            if (!this.f10608b) {
                int count = this.a.getCount();
                this.f10609c = new ArrayList();
                if (count > 0) {
                    this.f10609c.add(Integer.valueOf(0));
                    String a = m16828a();
                    String zzd = this.a.zzd(a, 0, this.a.zzfs(0));
                    int i = 1;
                    while (i < count) {
                        int zzfs = this.a.zzfs(i);
                        String zzd2 = this.a.zzd(a, i, zzfs);
                        if (zzd2 == null) {
                            throw new NullPointerException(new StringBuilder(String.valueOf(a).length() + 78).append("Missing value for markerColumn: ").append(a).append(", at row: ").append(i).append(", for window: ").append(zzfs).toString());
                        }
                        if (zzd2.equals(zzd)) {
                            zzd2 = zzd;
                        } else {
                            this.f10609c.add(Integer.valueOf(i));
                        }
                        i++;
                        zzd = zzd2;
                    }
                }
                this.f10608b = true;
            }
        }
    }

    int m16826a(int i) {
        if (i >= 0 && i < this.f10609c.size()) {
            return ((Integer) this.f10609c.get(i)).intValue();
        }
        throw new IllegalArgumentException("Position " + i + " is out of bounds for this buffer");
    }

    protected abstract T m16827a(int i, int i2);

    protected abstract String m16828a();

    protected int m16829b(int i) {
        if (i < 0 || i == this.f10609c.size()) {
            return 0;
        }
        int count = i == this.f10609c.size() + -1 ? this.a.getCount() - ((Integer) this.f10609c.get(i)).intValue() : ((Integer) this.f10609c.get(i + 1)).intValue() - ((Integer) this.f10609c.get(i)).intValue();
        if (count != 1) {
            return count;
        }
        int a = m16826a(i);
        int zzfs = this.a.zzfs(a);
        String b = m16830b();
        return (b == null || this.a.zzd(b, a, zzfs) != null) ? count : 0;
    }

    protected String m16830b() {
        return null;
    }

    public final T get(int i) {
        m16825c();
        return m16827a(m16826a(i), m16829b(i));
    }

    public int getCount() {
        m16825c();
        return this.f10609c.size();
    }
}
