package com.bigroad.ttb.android.activity;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.Preference.OnPreferenceClickListener;
import com.bigroad.ttb.android.OurApplication;
import com.bigroad.ttb.android.R;
import com.bigroad.ttb.android.logging.C2134e;

public class ShareActivity extends OurPreferenceActivity {
    private static final String f5486a = ("http://mobile.twitter.com/home?status=" + Uri.encode(OurApplication.m6279b().getResources().getString(R.string.shareApp_twitterMessage)));

    class C15751 implements OnPreferenceClickListener {
        final /* synthetic */ ShareActivity f5482a;

        C15751(ShareActivity shareActivity) {
            this.f5482a = shareActivity;
        }

        public boolean onPreferenceClick(Preference preference) {
            Intent intent = new Intent("android.intent.action.SENDTO");
            intent.putExtra("android.intent.extra.SUBJECT", this.f5482a.getString(R.string.shareApp_emailSubject));
            intent.putExtra("android.intent.extra.TEXT", this.f5482a.getString(R.string.shareApp_emailBody));
            intent.setData(Uri.parse("mailto:"));
            this.f5482a.startActivity(intent);
            this.f5482a.mo1017a().m8304f();
            return true;
        }
    }

    class C15762 implements OnPreferenceClickListener {
        final /* synthetic */ ShareActivity f5483a;

        C15762(ShareActivity shareActivity) {
            this.f5483a = shareActivity;
        }

        public boolean onPreferenceClick(Preference preference) {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.putExtra("sms_body", this.f5483a.getString(R.string.shareApp_smsBody));
            intent.setType("vnd.android-dir/mms-sms");
            try {
                this.f5483a.startActivity(intent);
                this.f5483a.mo1017a().m8303e();
            } catch (ActivityNotFoundException e) {
                C2134e.m10680d("TT-ShareActivity", "Device does not support text messaging: " + e);
            }
            return true;
        }
    }

    class C15773 implements OnPreferenceClickListener {
        final /* synthetic */ ShareActivity f5484a;

        C15773(ShareActivity shareActivity) {
            this.f5484a = shareActivity;
        }

        public boolean onPreferenceClick(Preference preference) {
            this.f5484a.m7818a(ShareActivity.f5486a);
            this.f5484a.mo1017a().m8305g();
            return true;
        }
    }

    class C15784 implements OnPreferenceClickListener {
        final /* synthetic */ ShareActivity f5485a;

        C15784(ShareActivity shareActivity) {
            this.f5485a = shareActivity;
        }

        public boolean onPreferenceClick(Preference preference) {
            this.f5485a.m7818a("http://m.facebook.com/pages/BigRoad/260062004086626");
            this.f5485a.mo1017a().m8306h();
            return true;
        }
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        addPreferencesFromResource(R.xml.share_app);
        findPreference("shareEmail").setOnPreferenceClickListener(new C15751(this));
        findPreference("shareSms").setOnPreferenceClickListener(new C15762(this));
        findPreference("shareTwitter").setOnPreferenceClickListener(new C15773(this));
        findPreference("shareLike").setOnPreferenceClickListener(new C15784(this));
    }

    private void m7818a(String str) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse(str));
        startActivity(intent);
    }

    protected boolean isValidFragment(String str) {
        return false;
    }
}
