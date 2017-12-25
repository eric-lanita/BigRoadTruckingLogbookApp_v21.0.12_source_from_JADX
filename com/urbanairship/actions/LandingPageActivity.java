package com.urbanairship.actions;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import com.facebook.share.internal.ShareConstants;
import com.urbanairship.C1187d;
import com.urbanairship.C3783j;
import com.urbanairship.C3929q;
import com.urbanairship.analytics.C3735b;
import com.urbanairship.richpush.C3942c;
import com.urbanairship.util.C3949d;
import com.urbanairship.widget.C3685a;
import com.urbanairship.widget.UAWebView;

public class LandingPageActivity extends Activity {
    private UAWebView f13322a;
    private Integer f13323b = null;
    private int f13324c = -1;
    private Handler f13325d;
    private Uri f13326e;

    class C36872 extends WebChromeClient {
        final /* synthetic */ LandingPageActivity f13318a;

        C36872(LandingPageActivity landingPageActivity) {
            this.f13318a = landingPageActivity;
        }

        public Bitmap getDefaultVideoPoster() {
            if (VERSION.SDK_INT >= 11 && VERSION.SDK_INT < 21) {
                this.f13318a.f13322a.setLayerType(2, null);
            }
            return super.getDefaultVideoPoster();
        }
    }

    class C36894 implements Runnable {
        final /* synthetic */ LandingPageActivity f13321a;

        C36894(LandingPageActivity landingPageActivity) {
            this.f13321a = landingPageActivity;
        }

        public void run() {
            this.f13321a.m19345a(0);
        }
    }

    @SuppressLint({"NewApi"})
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        C1187d.m6033a(getApplication());
        if (C3929q.m20384j() || C3929q.m20383i()) {
            C3783j.m19725c("Creating landing page activity.");
            Intent intent = getIntent();
            if (intent == null) {
                C3783j.m19721a("LandingPageActivity - Started activity with null intent");
                finish();
                return;
            }
            ActivityInfo b = C3949d.m20498b(getClass());
            Bundle bundle2 = (b == null || b.metaData == null) ? new Bundle() : b.metaData;
            this.f13324c = bundle2.getInt("com.urbanairship.LANDING_PAGE_BACKGROUND_COLOR", -1);
            this.f13325d = new Handler();
            this.f13326e = intent.getData();
            if (this.f13326e == null) {
                C3783j.m19721a("LandingPageActivity - No landing page uri to load.");
                finish();
                return;
            }
            int i = bundle2.getInt("com.urbanairship.action.LANDING_PAGE_VIEW", -1);
            if (i != -1) {
                setContentView(i);
            } else {
                setContentView(m19341b());
            }
            if (VERSION.SDK_INT >= 11) {
                ActionBar actionBar = getActionBar();
                if (actionBar != null) {
                    actionBar.setDisplayOptions(4, 4);
                }
            }
            this.f13322a = (UAWebView) findViewById(16908300);
            final ProgressBar progressBar = (ProgressBar) findViewById(16908301);
            if (this.f13322a == null) {
                C3783j.m19728e("LandingPageActivity - A UAWebView with id android.R.id.primary is not defined in the custom layout.  Unable to show the landing page.");
                finish();
                return;
            }
            if (VERSION.SDK_INT >= 11 && VERSION.SDK_INT < 21) {
                this.f13322a.setLayerType(1, null);
            }
            if (VERSION.SDK_INT >= 12) {
                this.f13322a.setAlpha(0.0f);
            } else {
                this.f13322a.setVisibility(4);
            }
            this.f13322a.setWebViewClient(new C3685a(this) {
                final /* synthetic */ LandingPageActivity f13317b;

                public void onPageFinished(WebView webView, String str) {
                    super.onPageFinished(webView, str);
                    if (this.f13317b.f13323b != null) {
                        switch (this.f13317b.f13323b.intValue()) {
                            case -8:
                            case -6:
                            case -1:
                                this.f13317b.m19345a(20000);
                                return;
                            default:
                                this.f13317b.f13323b = null;
                                this.f13317b.f13322a.loadData("", "text/html", null);
                                return;
                        }
                    }
                    if (this.f13317b.f13324c != -1) {
                        this.f13317b.f13322a.setBackgroundColor(this.f13317b.f13324c);
                    }
                    this.f13317b.m19339a(this.f13317b.f13322a, progressBar);
                }

                public void onReceivedError(WebView webView, int i, String str, String str2) {
                    if (str2 != null && str2.equals(this.f13317b.getIntent().getDataString())) {
                        C3783j.m19728e("LandingPageActivity - Failed to load page " + str2 + " with error " + i + " " + str);
                        this.f13317b.f13323b = Integer.valueOf(i);
                    }
                }
            });
            this.f13322a.setWebChromeClient(new C36872(this));
            return;
        }
        C3783j.m19728e("LandingPageActivity - unable to create activity, takeOff not called.");
        finish();
    }

    public void onNewIntent(Intent intent) {
        C3783j.m19725c("LandingPageActivity - New intent received for landing page");
        m19338a(intent.getData(), intent.getExtras());
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return false;
        }
        finish();
        return true;
    }

    protected void onStart() {
        super.onStart();
        C3735b.m19444a((Activity) this);
    }

    protected void onStop() {
        super.onStop();
        C3735b.m19448b((Activity) this);
    }

    @SuppressLint({"NewApi"})
    public void onResume() {
        super.onResume();
        if (VERSION.SDK_INT >= 11) {
            this.f13322a.onResume();
        }
        m19344a();
    }

    @SuppressLint({"NewApi"})
    public void onPause() {
        super.onPause();
        if (VERSION.SDK_INT >= 11) {
            this.f13322a.onPause();
        }
        this.f13322a.stopLoading();
        this.f13325d.removeCallbacksAndMessages(this.f13326e);
    }

    @SuppressLint({"NewApi"})
    private void m19339a(View view, final View view2) {
        if (VERSION.SDK_INT < 12) {
            if (view != null) {
                view.setVisibility(0);
            }
            if (view2 != null) {
                view2.setVisibility(8);
                return;
            }
            return;
        }
        if (view != null) {
            view.animate().alpha(1.0f).setDuration(200);
        }
        if (view2 != null) {
            view2.animate().alpha(0.0f).setDuration(200).setListener(new AnimatorListenerAdapter(this) {
                final /* synthetic */ LandingPageActivity f13320b;

                public void onAnimationEnd(Animator animator) {
                    view2.setVisibility(8);
                }
            });
        }
    }

    public void onCloseButtonClick(View view) {
        finish();
    }

    private View m19341b() {
        View frameLayout = new FrameLayout(this);
        View uAWebView = new UAWebView(this);
        uAWebView.setId(16908300);
        LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        frameLayout.addView(uAWebView, layoutParams);
        uAWebView = new ProgressBar(this);
        uAWebView.setIndeterminate(true);
        uAWebView.setId(16908301);
        layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        frameLayout.addView(uAWebView, layoutParams);
        return frameLayout;
    }

    protected void m19344a() {
        m19345a(0);
    }

    @SuppressLint({"NewApi"})
    protected void m19345a(long j) {
        if (this.f13322a != null) {
            this.f13322a.stopLoading();
            if (j > 0) {
                this.f13325d.postAtTime(new C36894(this), this.f13326e, SystemClock.uptimeMillis() + j);
                return;
            }
            C3783j.m19727d("Loading landing page: " + this.f13326e);
            if (this.f13324c != -1) {
                this.f13322a.setBackgroundColor(this.f13324c);
            }
            this.f13323b = null;
            if (this.f13326e.getScheme().equalsIgnoreCase(ShareConstants.WEB_DIALOG_PARAM_MESSAGE)) {
                String schemeSpecificPart = this.f13326e.getSchemeSpecificPart();
                C3942c b = C3929q.m20372a().m20391o().m20438b(schemeSpecificPart);
                if (b != null) {
                    this.f13322a.m20523a(b);
                    b.m20453h();
                    return;
                }
                C3783j.m19728e("Message " + schemeSpecificPart + " not found.");
                finish();
                return;
            }
            this.f13322a.loadUrl(this.f13326e.toString());
        }
    }

    private void m19338a(Uri uri, Bundle bundle) {
        C3783j.m19725c("Relaunching activity");
        finish();
        Intent flags = new Intent().setClass(this, getClass()).setData(uri).setFlags(268435456);
        if (bundle != null) {
            flags.putExtras(bundle);
        }
        startActivity(flags);
    }
}
