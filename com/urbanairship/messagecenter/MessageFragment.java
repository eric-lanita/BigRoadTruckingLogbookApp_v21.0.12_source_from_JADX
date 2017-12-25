package com.urbanairship.messagecenter;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.Button;
import com.urbanairship.C3783j;
import com.urbanairship.C3860o.C3852e;
import com.urbanairship.C3860o.C3853f;
import com.urbanairship.C3929q;
import com.urbanairship.richpush.C3942c;
import com.urbanairship.widget.C3685a;
import com.urbanairship.widget.UAWebView;

@TargetApi(14)
public class MessageFragment extends Fragment {
    private UAWebView f13667a;
    private View f13668b;
    private C3942c f13669c;
    private View f13670d;
    private Integer f13671e = null;

    class C38261 extends C3685a {
        final /* synthetic */ MessageFragment f13664a;

        C38261(MessageFragment messageFragment) {
            this.f13664a = messageFragment;
        }

        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            if (this.f13664a.f13671e != null) {
                this.f13664a.m19943d();
                return;
            }
            this.f13664a.f13669c.m20453h();
            this.f13664a.m19942c();
        }

        public void onReceivedError(WebView webView, int i, String str, String str2) {
            if (this.f13664a.f13669c != null && str2 != null && str2.equals(this.f13664a.f13669c.m20447b())) {
                this.f13664a.f13671e = Integer.valueOf(i);
            }
        }
    }

    class C38272 extends WebChromeClient {
        final /* synthetic */ MessageFragment f13665a;

        C38272(MessageFragment messageFragment) {
            this.f13665a = messageFragment;
        }

        public Bitmap getDefaultVideoPoster() {
            if (VERSION.SDK_INT < 21) {
                this.f13665a.f13667a.setLayerType(2, null);
            }
            return super.getDefaultVideoPoster();
        }
    }

    class C38283 implements OnClickListener {
        final /* synthetic */ MessageFragment f13666a;

        C38283(MessageFragment messageFragment) {
            this.f13666a = messageFragment;
        }

        public void onClick(View view) {
            this.f13666a.m19940a();
        }
    }

    public static MessageFragment m19934a(String str) {
        MessageFragment messageFragment = new MessageFragment();
        Bundle bundle = new Bundle();
        bundle.putString("com.urbanairship.richpush.URL_KEY", str);
        messageFragment.setArguments(bundle);
        return messageFragment;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        String e = m19944e();
        this.f13669c = C3929q.m20372a().m20391o().m20438b(e);
        if (this.f13669c == null) {
            C3783j.m19727d("Couldn't retrieve message for ID: " + e);
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(C3853f.ua_fragment_message, viewGroup, false);
        m19937a(inflate);
        return inflate;
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        m19937a(view);
    }

    private void m19937a(View view) {
        if (this.f13667a == null) {
            this.f13668b = view.findViewById(16908301);
            if (this.f13668b == null) {
                throw new RuntimeException("Your content must have a progress View whose id attribute is 'android.R.id.progress'");
            }
            this.f13667a = (UAWebView) view.findViewById(16908299);
            if (this.f13667a == null) {
                throw new RuntimeException("Your content must have a UAWebView whose id attribute is 'android.R.id.message'");
            }
            this.f13670d = view.findViewById(C3852e.error);
            this.f13667a.setAlpha(0.0f);
            this.f13667a.setWebViewClient(new C38261(this));
            this.f13667a.setWebChromeClient(new C38272(this));
            if (VERSION.SDK_INT < 21) {
                this.f13667a.setLayerType(1, null);
            }
            Button button = (Button) view.findViewById(C3852e.retry_button);
            if (button != null) {
                button.setOnClickListener(new C38283(this));
            }
        }
    }

    public void onStart() {
        super.onStart();
        if (this.f13669c != null) {
            m19941b();
            C3783j.m19727d("Loading message: " + this.f13669c.m20446a());
            this.f13667a.m20523a(this.f13669c);
        }
    }

    public void onResume() {
        super.onResume();
        this.f13667a.onResume();
    }

    public void onPause() {
        super.onPause();
        this.f13667a.onPause();
    }

    protected void m19940a() {
        m19941b();
        this.f13671e = null;
        this.f13667a.m20523a(this.f13669c);
    }

    protected void m19941b() {
        if (this.f13670d != null && this.f13670d.getVisibility() == 0) {
            this.f13670d.animate().alpha(0.0f).setDuration(200).setListener(null);
        }
        this.f13667a.animate().alpha(0.0f).setDuration(200).setListener(null);
        this.f13668b.animate().alpha(1.0f).setDuration(200).setListener(null);
    }

    protected void m19942c() {
        this.f13667a.animate().alpha(1.0f).setDuration(200).setListener(null);
        this.f13668b.animate().alpha(0.0f).setDuration(200).setListener(null);
    }

    protected void m19943d() {
        if (this.f13670d != null) {
            if (this.f13670d.getVisibility() == 8) {
                this.f13670d.setAlpha(0.0f);
                this.f13670d.setVisibility(0);
            }
            this.f13670d.animate().alpha(1.0f).setDuration(200).setListener(null);
            this.f13668b.animate().alpha(0.0f).setDuration(200).setListener(null);
        }
    }

    public String m19944e() {
        return getArguments().getString("com.urbanairship.richpush.URL_KEY");
    }
}
