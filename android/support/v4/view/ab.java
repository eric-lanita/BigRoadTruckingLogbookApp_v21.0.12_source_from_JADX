package android.support.v4.view;

import android.database.DataSetObservable;
import android.database.DataSetObserver;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;

public abstract class ab {
    private final DataSetObservable f1002a = new DataSetObservable();
    private DataSetObserver f1003b;

    public abstract int mo1334a();

    public abstract boolean mo1338a(View view, Object obj);

    public void m1607a(ViewGroup viewGroup) {
        m1605a((View) viewGroup);
    }

    public Object mo1336a(ViewGroup viewGroup, int i) {
        return m1601a((View) viewGroup, i);
    }

    public void mo1337a(ViewGroup viewGroup, int i, Object obj) {
        m1606a((View) viewGroup, i, obj);
    }

    public void m1614b(ViewGroup viewGroup, int i, Object obj) {
        m1612b((View) viewGroup, i, obj);
    }

    public void m1613b(ViewGroup viewGroup) {
        m1611b((View) viewGroup);
    }

    public void m1605a(View view) {
    }

    public Object m1601a(View view, int i) {
        throw new UnsupportedOperationException("Required method instantiateItem was not overridden");
    }

    public void m1606a(View view, int i, Object obj) {
        throw new UnsupportedOperationException("Required method destroyItem was not overridden");
    }

    public void m1612b(View view, int i, Object obj) {
    }

    public void m1611b(View view) {
    }

    public Parcelable m1610b() {
        return null;
    }

    public void m1604a(Parcelable parcelable, ClassLoader classLoader) {
    }

    public int mo1335a(Object obj) {
        return -1;
    }

    public void m1615c() {
        synchronized (this) {
            if (this.f1003b != null) {
                this.f1003b.onChanged();
            }
        }
        this.f1002a.notifyChanged();
    }

    void m1603a(DataSetObserver dataSetObserver) {
        synchronized (this) {
            this.f1003b = dataSetObserver;
        }
    }

    public float m1598a(int i) {
        return 1.0f;
    }
}
