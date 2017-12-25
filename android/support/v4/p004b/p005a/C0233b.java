package android.support.v4.p004b.p005a;

import android.support.v4.view.C0434d;
import android.support.v4.view.C0466p.C0465e;
import android.view.MenuItem;
import android.view.View;

public interface C0233b extends MenuItem {
    C0233b mo530a(C0434d c0434d);

    C0233b mo531a(C0465e c0465e);

    C0434d mo532a();

    boolean collapseActionView();

    boolean expandActionView();

    View getActionView();

    boolean isActionViewExpanded();

    MenuItem setActionView(int i);

    MenuItem setActionView(View view);

    void setShowAsAction(int i);

    MenuItem setShowAsActionFlags(int i);
}
