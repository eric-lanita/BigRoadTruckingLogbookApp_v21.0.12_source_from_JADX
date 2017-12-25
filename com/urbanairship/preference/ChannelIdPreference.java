package com.urbanairship.preference;

import android.os.Handler;
import android.os.Looper;
import android.preference.Preference;
import android.view.View;
import android.view.ViewGroup;
import com.urbanairship.C3929q;
import java.lang.ref.WeakReference;

public class ChannelIdPreference extends Preference {
    private int f13734a;

    protected void onAttachedToActivity() {
        super.onAttachedToActivity();
        final WeakReference weakReference = new WeakReference(this);
        final Handler handler = new Handler(Looper.getMainLooper());
        handler.post(new Runnable(this) {
            final /* synthetic */ ChannelIdPreference f13733c;

            public void run() {
                ChannelIdPreference channelIdPreference = (ChannelIdPreference) weakReference.get();
                if (channelIdPreference != null) {
                    if (C3929q.m20372a().m20390n().m20329u() != null) {
                        channelIdPreference.setSummary(C3929q.m20372a().m20390n().m20329u());
                    } else if (channelIdPreference.f13734a < 4) {
                        handler.postDelayed(this, 1000);
                        channelIdPreference.f13734a = channelIdPreference.f13734a + 1;
                    }
                }
            }
        });
    }

    public View onCreateView(ViewGroup viewGroup) {
        View onCreateView = super.onCreateView(viewGroup);
        onCreateView.setContentDescription("CHANNEL_ID");
        return onCreateView;
    }
}
