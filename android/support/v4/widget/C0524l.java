package android.support.v4.widget;

import android.widget.ListView;

public class C0524l extends C0497a {
    private final ListView f1214a;

    public C0524l(ListView listView) {
        super(listView);
        this.f1214a = listView;
    }

    public void mo388a(int i, int i2) {
        C0525m.m2423a(this.f1214a, i2);
    }

    public boolean mo389e(int i) {
        return false;
    }

    public boolean mo390f(int i) {
        ListView listView = this.f1214a;
        int count = listView.getCount();
        if (count == 0) {
            return false;
        }
        int childCount = listView.getChildCount();
        int firstVisiblePosition = listView.getFirstVisiblePosition();
        int i2 = firstVisiblePosition + childCount;
        if (i > 0) {
            if (i2 >= count && listView.getChildAt(childCount - 1).getBottom() <= listView.getHeight()) {
                return false;
            }
        } else if (i >= 0) {
            return false;
        } else {
            if (firstVisiblePosition <= 0 && listView.getChildAt(0).getTop() >= 0) {
                return false;
            }
        }
        return true;
    }
}
