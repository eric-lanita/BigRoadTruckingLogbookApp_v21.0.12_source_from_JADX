package android.support.v4.widget;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public abstract class C0544v extends C0515g {
    private int f1262j;
    private int f1263k;
    private LayoutInflater f1264l;

    public C0544v(Context context, int i, Cursor cursor, boolean z) {
        super(context, cursor, z);
        this.f1263k = i;
        this.f1262j = i;
        this.f1264l = (LayoutInflater) context.getSystemService("layout_inflater");
    }

    public View mo394a(Context context, Cursor cursor, ViewGroup viewGroup) {
        return this.f1264l.inflate(this.f1262j, viewGroup, false);
    }

    public View mo395b(Context context, Cursor cursor, ViewGroup viewGroup) {
        return this.f1264l.inflate(this.f1263k, viewGroup, false);
    }
}
