package com.bigroad.ttb.android;

import android.os.Handler;
import com.bigroad.shared.gcm.GcmMessage;
import com.bigroad.shared.gcm.GcmMessage.MessageType;
import com.bigroad.ttb.android.logging.C2134e;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

public class FcmManager {
    private static FcmManager f4116a;
    private static C2032f f4117b;

    public static class InstanceIdService extends FirebaseInstanceIdService {
        public void mo901a() {
            C2134e.m10676b("TT-FcmManager", "FCM token refreshed: " + FirebaseInstanceId.m18878a().m18891d());
            FcmManager.f4117b.mo1298f().m6489b();
        }
    }

    public static class MessagingService extends FirebaseMessagingService {
        private final Handler f4114c = new Handler();
        private final Runnable f4115d = new C12101(this);

        class C12101 implements Runnable {
            final /* synthetic */ MessagingService f4113a;

            C12101(MessagingService messagingService) {
                this.f4113a = messagingService;
            }

            public void run() {
                FcmManager.f4117b.mo1298f().m6451a();
            }
        }

        public void mo902a(RemoteMessage remoteMessage) {
            GcmMessage a = GcmMessage.m5435a(remoteMessage.m18952a());
            if (a == null) {
                C2134e.m10680d("TT-FcmManager", "Unable to handle incoming null GCM message");
                return;
            }
            C2134e.m10676b("TT-FcmManager", "GCM message: " + a.m5437b() + "; " + a.m5438c());
            if (a.m5436a() == MessageType.SYNC) {
                this.f4114c.post(this.f4115d);
            } else {
                C2134e.m10680d("TT-FcmManager", "Unexpected GCM message type");
            }
        }
    }

    public static FcmManager m6238a(C2032f c2032f) {
        if (f4116a == null) {
            f4116a = new FcmManager(c2032f);
        }
        return f4116a;
    }

    private FcmManager(C2032f c2032f) {
        f4117b = c2032f;
    }

    public String m6240a() {
        return FirebaseInstanceId.m18878a().m18891d();
    }
}
