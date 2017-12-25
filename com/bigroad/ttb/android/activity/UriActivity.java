package com.bigroad.ttb.android.activity;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import com.bigroad.shared.am;
import com.bigroad.ttb.android.C2474y;
import com.bigroad.ttb.android.OurApplication;
import com.bigroad.ttb.android.p030a.C1258c;

public class UriActivity extends Activity {
    private void m7899a(String str) {
        C2474y g = OurApplication.m6285g();
        if (OurApplication.m6249F().m6031d() && str.equalsIgnoreCase(g.m12192b())) {
            m7898a();
            return;
        }
        Intent m = C1632a.m8005m(getApplicationContext());
        m.putExtra("com.bigroad.ttb.emailAddress", str);
        startActivity(m);
    }

    private void m7898a() {
        Intent a = C1258c.m6615a(new ComponentName(getApplicationContext(), MainActivity.class));
        a.addFlags(268435456);
        startActivity(a);
    }

    private boolean m7900b() {
        Uri data = getIntent().getData();
        if (data == null) {
            return false;
        }
        CharSequence queryParameter = data.getQueryParameter("emailAddress");
        if (am.m4188a(queryParameter)) {
            return false;
        }
        m7899a(queryParameter);
        return true;
    }

    protected void onStart() {
        super.onStart();
        if (!m7900b()) {
            m7898a();
        }
        finish();
    }
}
