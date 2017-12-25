package com.urbanairship.messagecenter;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import com.urbanairship.C3860o.C3849b;

@TargetApi(14)
public class ThemedActivity extends FragmentActivity {
    private static Boolean f13653a;
    private C3839a f13654b;

    protected void onCreate(Bundle bundle) {
        if (m19922a((Activity) this)) {
            this.f13654b = C3839a.m19973a((Activity) this);
        }
        if (this.f13654b != null) {
            this.f13654b.m19977a(bundle);
        }
        super.onCreate(bundle);
    }

    protected void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        if (this.f13654b != null) {
            this.f13654b.m19982b(bundle);
        }
    }

    public MenuInflater getMenuInflater() {
        if (this.f13654b != null) {
            return this.f13654b.m19974a();
        }
        return super.getMenuInflater();
    }

    public void setContentView(int i) {
        if (this.f13654b != null) {
            this.f13654b.m19975a(i);
        } else {
            super.setContentView(i);
        }
    }

    public void setContentView(View view) {
        if (this.f13654b != null) {
            this.f13654b.m19978a(view);
        } else {
            super.setContentView(view);
        }
    }

    public void setContentView(View view, LayoutParams layoutParams) {
        if (this.f13654b != null) {
            this.f13654b.m19979a(view, layoutParams);
        } else {
            super.setContentView(view, layoutParams);
        }
    }

    public void addContentView(View view, LayoutParams layoutParams) {
        if (this.f13654b != null) {
            this.f13654b.m19983b(view, layoutParams);
        } else {
            super.addContentView(view, layoutParams);
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.f13654b != null) {
            this.f13654b.m19976a(configuration);
        }
    }

    protected void onStop() {
        super.onStop();
        if (this.f13654b != null) {
            this.f13654b.m19984c();
        }
    }

    protected void onPostResume() {
        super.onPostResume();
        if (this.f13654b != null) {
            this.f13654b.m19981b();
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        if (this.f13654b != null) {
            this.f13654b.m19986e();
        }
    }

    protected void onTitleChanged(CharSequence charSequence, int i) {
        super.onTitleChanged(charSequence, i);
        if (this.f13654b != null) {
            this.f13654b.m19980a(charSequence);
        }
    }

    public void supportInvalidateOptionsMenu() {
        if (this.f13654b != null) {
            this.f13654b.m19985d();
        } else {
            super.supportInvalidateOptionsMenu();
        }
    }

    protected void m19923a(boolean z) {
        if (this.f13654b != null) {
            if (this.f13654b.m19987f() != null) {
                this.f13654b.m19987f().mo481a(z);
                this.f13654b.m19987f().mo483b(z);
            }
        } else if (getActionBar() != null) {
            getActionBar().setDisplayHomeAsUpEnabled(z);
            getActionBar().setHomeButtonEnabled(z);
        }
    }

    static boolean m19922a(Activity activity) {
        if (f13653a == null) {
            try {
                Class.forName("android.support.v7.app.e");
                f13653a = Boolean.valueOf(true);
            } catch (ClassNotFoundException e) {
                f13653a = Boolean.valueOf(false);
            }
        }
        if (!f13653a.booleanValue()) {
            return false;
        }
        TypedArray obtainStyledAttributes = activity.obtainStyledAttributes(new int[]{C3849b.colorPrimary});
        boolean hasValue = obtainStyledAttributes.hasValue(0);
        obtainStyledAttributes.recycle();
        return hasValue;
    }
}
