package android.support.v4.widget;

import android.database.Cursor;
import android.widget.Filter;
import android.widget.Filter.FilterResults;

class C0516h extends Filter {
    C0514a f1211a;

    interface C0514a {
        Cursor mo375a();

        Cursor mo376a(CharSequence charSequence);

        void mo377a(Cursor cursor);

        CharSequence mo378c(Cursor cursor);
    }

    C0516h(C0514a c0514a) {
        this.f1211a = c0514a;
    }

    public CharSequence convertResultToString(Object obj) {
        return this.f1211a.mo378c((Cursor) obj);
    }

    protected FilterResults performFiltering(CharSequence charSequence) {
        Cursor a = this.f1211a.mo376a(charSequence);
        FilterResults filterResults = new FilterResults();
        if (a != null) {
            filterResults.count = a.getCount();
            filterResults.values = a;
        } else {
            filterResults.count = 0;
            filterResults.values = null;
        }
        return filterResults;
    }

    protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
        Cursor a = this.f1211a.mo375a();
        if (filterResults.values != null && filterResults.values != a) {
            this.f1211a.mo377a((Cursor) filterResults.values);
        }
    }
}
