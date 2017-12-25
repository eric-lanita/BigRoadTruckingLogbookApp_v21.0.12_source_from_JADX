package android.support.v4.widget;

import android.content.Context;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.os.Handler;
import android.support.v4.widget.C0516h.C0514a;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.FilterQueryProvider;
import android.widget.Filterable;

public abstract class C0515g extends BaseAdapter implements C0514a, Filterable {
    protected boolean f1202a;
    protected boolean f1203b;
    protected Cursor f1204c;
    protected Context f1205d;
    protected int f1206e;
    protected C0512a f1207f;
    protected DataSetObserver f1208g;
    protected C0516h f1209h;
    protected FilterQueryProvider f1210i;

    private class C0512a extends ContentObserver {
        final /* synthetic */ C0515g f1200a;

        public C0512a(C0515g c0515g) {
            this.f1200a = c0515g;
            super(new Handler());
        }

        public boolean deliverSelfNotifications() {
            return true;
        }

        public void onChange(boolean z) {
            this.f1200a.m2373b();
        }
    }

    private class C0513b extends DataSetObserver {
        final /* synthetic */ C0515g f1201a;

        private C0513b(C0515g c0515g) {
            this.f1201a = c0515g;
        }

        public void onChanged() {
            this.f1201a.f1202a = true;
            this.f1201a.notifyDataSetChanged();
        }

        public void onInvalidated() {
            this.f1201a.f1202a = false;
            this.f1201a.notifyDataSetInvalidated();
        }
    }

    public abstract View mo394a(Context context, Cursor cursor, ViewGroup viewGroup);

    public abstract void mo630a(View view, Context context, Cursor cursor);

    public C0515g(Context context, Cursor cursor, boolean z) {
        m2368a(context, cursor, z ? 1 : 2);
    }

    void m2368a(Context context, Cursor cursor, int i) {
        boolean z = true;
        if ((i & 1) == 1) {
            i |= 2;
            this.f1203b = true;
        } else {
            this.f1203b = false;
        }
        if (cursor == null) {
            z = false;
        }
        this.f1204c = cursor;
        this.f1202a = z;
        this.f1205d = context;
        this.f1206e = z ? cursor.getColumnIndexOrThrow("_id") : -1;
        if ((i & 2) == 2) {
            this.f1207f = new C0512a(this);
            this.f1208g = new C0513b();
        } else {
            this.f1207f = null;
            this.f1208g = null;
        }
        if (z) {
            if (this.f1207f != null) {
                cursor.registerContentObserver(this.f1207f);
            }
            if (this.f1208g != null) {
                cursor.registerDataSetObserver(this.f1208g);
            }
        }
    }

    public Cursor mo375a() {
        return this.f1204c;
    }

    public int getCount() {
        if (!this.f1202a || this.f1204c == null) {
            return 0;
        }
        return this.f1204c.getCount();
    }

    public Object getItem(int i) {
        if (!this.f1202a || this.f1204c == null) {
            return null;
        }
        this.f1204c.moveToPosition(i);
        return this.f1204c;
    }

    public long getItemId(int i) {
        if (this.f1202a && this.f1204c != null && this.f1204c.moveToPosition(i)) {
            return this.f1204c.getLong(this.f1206e);
        }
        return 0;
    }

    public boolean hasStableIds() {
        return true;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        if (!this.f1202a) {
            throw new IllegalStateException("this should only be called when the cursor is valid");
        } else if (this.f1204c.moveToPosition(i)) {
            if (view == null) {
                view = mo394a(this.f1205d, this.f1204c, viewGroup);
            }
            mo630a(view, this.f1205d, this.f1204c);
            return view;
        } else {
            throw new IllegalStateException("couldn't move cursor to position " + i);
        }
    }

    public View getDropDownView(int i, View view, ViewGroup viewGroup) {
        if (!this.f1202a) {
            return null;
        }
        this.f1204c.moveToPosition(i);
        if (view == null) {
            view = mo395b(this.f1205d, this.f1204c, viewGroup);
        }
        mo630a(view, this.f1205d, this.f1204c);
        return view;
    }

    public View mo395b(Context context, Cursor cursor, ViewGroup viewGroup) {
        return mo394a(context, cursor, viewGroup);
    }

    public void mo377a(Cursor cursor) {
        Cursor b = m2371b(cursor);
        if (b != null) {
            b.close();
        }
    }

    public Cursor m2371b(Cursor cursor) {
        if (cursor == this.f1204c) {
            return null;
        }
        Cursor cursor2 = this.f1204c;
        if (cursor2 != null) {
            if (this.f1207f != null) {
                cursor2.unregisterContentObserver(this.f1207f);
            }
            if (this.f1208g != null) {
                cursor2.unregisterDataSetObserver(this.f1208g);
            }
        }
        this.f1204c = cursor;
        if (cursor != null) {
            if (this.f1207f != null) {
                cursor.registerContentObserver(this.f1207f);
            }
            if (this.f1208g != null) {
                cursor.registerDataSetObserver(this.f1208g);
            }
            this.f1206e = cursor.getColumnIndexOrThrow("_id");
            this.f1202a = true;
            notifyDataSetChanged();
            return cursor2;
        }
        this.f1206e = -1;
        this.f1202a = false;
        notifyDataSetInvalidated();
        return cursor2;
    }

    public CharSequence mo378c(Cursor cursor) {
        return cursor == null ? "" : cursor.toString();
    }

    public Cursor mo376a(CharSequence charSequence) {
        if (this.f1210i != null) {
            return this.f1210i.runQuery(charSequence);
        }
        return this.f1204c;
    }

    public Filter getFilter() {
        if (this.f1209h == null) {
            this.f1209h = new C0516h(this);
        }
        return this.f1209h;
    }

    protected void m2373b() {
        if (this.f1203b && this.f1204c != null && !this.f1204c.isClosed()) {
            this.f1202a = this.f1204c.requery();
        }
    }
}
