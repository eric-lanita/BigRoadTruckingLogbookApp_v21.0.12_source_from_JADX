package android.support.v4.media;

import android.app.Service;
import android.os.Binder;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.support.v4.media.MediaBrowserCompat.MediaItem;
import android.support.v4.media.session.MediaSessionCompat.Token;
import android.support.v4.os.ResultReceiver;
import android.support.v4.p008d.C0270a;
import android.text.TextUtils;
import android.util.Log;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public abstract class MediaBrowserServiceCompat extends Service {
    Token f882a;
    private final C0270a<IBinder, C0289b> f883b = new C0270a();
    private final C0292f f884c = new C0292f();

    class C02841 implements Runnable {
        final /* synthetic */ Token f835a;
        final /* synthetic */ MediaBrowserServiceCompat f836b;

        public void run() {
            for (IBinder iBinder : this.f836b.f883b.keySet()) {
                C0289b c0289b = (C0289b) this.f836b.f883b.get(iBinder);
                try {
                    c0289b.f851c.mo180a(c0289b.f852d.m1199a(), this.f835a, c0289b.f852d.m1200b());
                } catch (RemoteException e) {
                    Log.w("MediaBrowserServiceCompat", "Connection for " + c0289b.f849a + " is no longer valid.");
                    this.f836b.f883b.remove(iBinder);
                }
            }
        }
    }

    public static class C0285c<T> {
        private Object f837a;
        private boolean f838b;
        private boolean f839c;
        private int f840d;

        C0285c(Object obj) {
            this.f837a = obj;
        }

        public void m1192a(T t) {
            if (this.f839c) {
                throw new IllegalStateException("sendResult() called twice for: " + this.f837a);
            }
            this.f839c = true;
            mo178a(t, this.f840d);
        }

        boolean m1194a() {
            return this.f838b || this.f839c;
        }

        void m1191a(int i) {
            this.f840d = i;
        }

        void mo178a(T t, int i) {
        }
    }

    public static final class C0288a {
        private final String f847a;
        private final Bundle f848b;

        public String m1199a() {
            return this.f847a;
        }

        public Bundle m1200b() {
            return this.f848b;
        }
    }

    private class C0289b {
        String f849a;
        Bundle f850b;
        C0290d f851c;
        C0288a f852d;
        HashMap<String, List<Bundle>> f853e;
        final /* synthetic */ MediaBrowserServiceCompat f854f;

        private C0289b(MediaBrowserServiceCompat mediaBrowserServiceCompat) {
            this.f854f = mediaBrowserServiceCompat;
            this.f853e = new HashMap();
        }
    }

    private interface C0290d {
        IBinder mo179a();

        void mo180a(String str, Token token, Bundle bundle);

        void mo181a(String str, List<MediaItem> list, Bundle bundle);

        void mo182b();
    }

    private class C0291e implements C0290d {
        final Messenger f855a;
        final /* synthetic */ MediaBrowserServiceCompat f856b;

        C0291e(MediaBrowserServiceCompat mediaBrowserServiceCompat, Messenger messenger) {
            this.f856b = mediaBrowserServiceCompat;
            this.f855a = messenger;
        }

        public IBinder mo179a() {
            return this.f855a.getBinder();
        }

        public void mo180a(String str, Token token, Bundle bundle) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putInt("extra_service_version", 1);
            Bundle bundle2 = new Bundle();
            bundle2.putString("data_media_item_id", str);
            bundle2.putParcelable("data_media_session_token", token);
            bundle2.putBundle("data_root_hints", bundle);
            m1205a(1, bundle2);
        }

        public void mo182b() {
            m1205a(2, null);
        }

        public void mo181a(String str, List<MediaItem> list, Bundle bundle) {
            Bundle bundle2 = new Bundle();
            bundle2.putString("data_media_item_id", str);
            bundle2.putBundle("data_options", bundle);
            if (list != null) {
                String str2 = "data_media_item_list";
                if (list instanceof ArrayList) {
                    list = (ArrayList) list;
                } else {
                    Object arrayList = new ArrayList(list);
                }
                bundle2.putParcelableArrayList(str2, list);
            }
            m1205a(3, bundle2);
        }

        private void m1205a(int i, Bundle bundle) {
            Message obtain = Message.obtain();
            obtain.what = i;
            obtain.arg1 = 1;
            obtain.setData(bundle);
            this.f855a.send(obtain);
        }
    }

    private final class C0292f extends Handler {
        final /* synthetic */ MediaBrowserServiceCompat f857a;
        private final C0300g f858b;

        private C0292f(MediaBrowserServiceCompat mediaBrowserServiceCompat) {
            this.f857a = mediaBrowserServiceCompat;
            this.f858b = new C0300g();
        }

        public void handleMessage(Message message) {
            Bundle data = message.getData();
            switch (message.what) {
                case 1:
                    this.f858b.m1212a(data.getString("data_package_name"), data.getInt("data_calling_uid"), data.getBundle("data_root_hints"), new C0291e(this.f857a, message.replyTo));
                    return;
                case 2:
                    this.f858b.m1211a(new C0291e(this.f857a, message.replyTo));
                    return;
                case 3:
                    this.f858b.m1213a(data.getString("data_media_item_id"), data.getBundle("data_options"), new C0291e(this.f857a, message.replyTo));
                    return;
                case 4:
                    this.f858b.m1216b(data.getString("data_media_item_id"), data.getBundle("data_options"), new C0291e(this.f857a, message.replyTo));
                    return;
                case 5:
                    this.f858b.m1214a(data.getString("data_media_item_id"), (ResultReceiver) data.getParcelable("data_result_receiver"));
                    return;
                case 6:
                    this.f858b.m1215b(new C0291e(this.f857a, message.replyTo));
                    return;
                case 7:
                    this.f858b.m1217c(new C0291e(this.f857a, message.replyTo));
                    return;
                default:
                    Log.w("MediaBrowserServiceCompat", "Unhandled message: " + message + "\n  Service version: " + 1 + "\n  Client version: " + message.arg1);
                    return;
            }
        }

        public boolean sendMessageAtTime(Message message, long j) {
            Bundle data = message.getData();
            data.setClassLoader(MediaBrowserCompat.class.getClassLoader());
            data.putInt("data_calling_uid", Binder.getCallingUid());
            return super.sendMessageAtTime(message, j);
        }

        public void m1210a(Runnable runnable) {
            if (Thread.currentThread() == getLooper().getThread()) {
                runnable.run();
            } else {
                post(runnable);
            }
        }
    }

    private class C0300g {
        final /* synthetic */ MediaBrowserServiceCompat f881a;

        private C0300g(MediaBrowserServiceCompat mediaBrowserServiceCompat) {
            this.f881a = mediaBrowserServiceCompat;
        }

        public void m1212a(String str, int i, Bundle bundle, C0290d c0290d) {
            if (this.f881a.m1224a(str, i)) {
                final C0290d c0290d2 = c0290d;
                final String str2 = str;
                final Bundle bundle2 = bundle;
                final int i2 = i;
                this.f881a.f884c.m1210a(new Runnable(this) {
                    final /* synthetic */ C0300g f863e;

                    public void run() {
                        IBinder a = c0290d2.mo179a();
                        this.f863e.f881a.f883b.remove(a);
                        C0289b c0289b = new C0289b();
                        c0289b.f849a = str2;
                        c0289b.f850b = bundle2;
                        c0289b.f851c = c0290d2;
                        c0289b.f852d = this.f863e.f881a.m1229a(str2, i2, bundle2);
                        if (c0289b.f852d == null) {
                            Log.i("MediaBrowserServiceCompat", "No root for client " + str2 + " from service " + getClass().getName());
                            try {
                                c0290d2.mo182b();
                                return;
                            } catch (RemoteException e) {
                                Log.w("MediaBrowserServiceCompat", "Calling onConnectFailed() failed. Ignoring. pkg=" + str2);
                                return;
                            }
                        }
                        try {
                            this.f863e.f881a.f883b.put(a, c0289b);
                            if (this.f863e.f881a.f882a != null) {
                                c0290d2.mo180a(c0289b.f852d.m1199a(), this.f863e.f881a.f882a, c0289b.f852d.m1200b());
                            }
                        } catch (RemoteException e2) {
                            Log.w("MediaBrowserServiceCompat", "Calling onConnect() failed. Dropping client. pkg=" + str2);
                            this.f863e.f881a.f883b.remove(a);
                        }
                    }
                });
                return;
            }
            throw new IllegalArgumentException("Package/uid mismatch: uid=" + i + " package=" + str);
        }

        public void m1211a(final C0290d c0290d) {
            this.f881a.f884c.m1210a(new Runnable(this) {
                final /* synthetic */ C0300g f865b;

                public void run() {
                    if (((C0289b) this.f865b.f881a.f883b.remove(c0290d.mo179a())) == null) {
                    }
                }
            });
        }

        public void m1213a(final String str, final Bundle bundle, final C0290d c0290d) {
            this.f881a.f884c.m1210a(new Runnable(this) {
                final /* synthetic */ C0300g f869d;

                public void run() {
                    C0289b c0289b = (C0289b) this.f869d.f881a.f883b.get(c0290d.mo179a());
                    if (c0289b == null) {
                        Log.w("MediaBrowserServiceCompat", "addSubscription for callback that isn't registered id=" + str);
                    } else {
                        this.f869d.f881a.m1221a(str, c0289b, bundle);
                    }
                }
            });
        }

        public void m1216b(final String str, final Bundle bundle, final C0290d c0290d) {
            this.f881a.f884c.m1210a(new Runnable(this) {
                final /* synthetic */ C0300g f873d;

                public void run() {
                    C0289b c0289b = (C0289b) this.f873d.f881a.f883b.get(c0290d.mo179a());
                    if (c0289b == null) {
                        Log.w("MediaBrowserServiceCompat", "removeSubscription for callback that isn't registered id=" + str);
                    } else if (!this.f873d.f881a.m1227b(str, c0289b, bundle)) {
                        Log.w("MediaBrowserServiceCompat", "removeSubscription called for " + str + " which is not subscribed");
                    }
                }
            });
        }

        public void m1214a(final String str, final ResultReceiver resultReceiver) {
            if (!TextUtils.isEmpty(str) && resultReceiver != null) {
                this.f881a.f884c.m1210a(new Runnable(this) {
                    final /* synthetic */ C0300g f876c;

                    public void run() {
                        this.f876c.f881a.m1222a(str, resultReceiver);
                    }
                });
            }
        }

        public void m1215b(final C0290d c0290d) {
            this.f881a.f884c.m1210a(new Runnable(this) {
                final /* synthetic */ C0300g f878b;

                public void run() {
                    IBinder a = c0290d.mo179a();
                    this.f878b.f881a.f883b.remove(a);
                    C0289b c0289b = new C0289b();
                    c0289b.f851c = c0290d;
                    this.f878b.f881a.f883b.put(a, c0289b);
                }
            });
        }

        public void m1217c(final C0290d c0290d) {
            this.f881a.f884c.m1210a(new Runnable(this) {
                final /* synthetic */ C0300g f880b;

                public void run() {
                    this.f880b.f881a.f883b.remove(c0290d.mo179a());
                }
            });
        }
    }

    public abstract C0288a m1229a(String str, int i, Bundle bundle);

    public abstract void m1230a(String str, C0285c<List<MediaItem>> c0285c);

    public void m1231a(String str, C0285c<List<MediaItem>> c0285c, Bundle bundle) {
        c0285c.m1191a(1);
        m1230a(str, (C0285c) c0285c);
    }

    public void m1232b(String str, C0285c<MediaItem> c0285c) {
        c0285c.m1192a(null);
    }

    private boolean m1224a(String str, int i) {
        if (str == null) {
            return false;
        }
        for (String equals : getPackageManager().getPackagesForUid(i)) {
            if (equals.equals(str)) {
                return true;
            }
        }
        return false;
    }

    private void m1221a(String str, C0289b c0289b, Bundle bundle) {
        List list = (List) c0289b.f853e.get(str);
        List arrayList;
        if (list == null) {
            arrayList = new ArrayList();
        } else {
            arrayList = list;
        }
        for (Bundle a : r1) {
            if (C0303a.m1247a(bundle, a)) {
                return;
            }
        }
        r1.add(bundle);
        c0289b.f853e.put(str, r1);
        m1228c(str, c0289b, bundle);
    }

    private boolean m1227b(String str, C0289b c0289b, Bundle bundle) {
        List<Bundle> list = (List) c0289b.f853e.get(str);
        if (list == null) {
            return false;
        }
        boolean z;
        for (Bundle bundle2 : list) {
            if (C0303a.m1247a(bundle, bundle2)) {
                list.remove(bundle2);
                z = true;
                break;
            }
        }
        z = false;
        if (list.size() != 0) {
            return z;
        }
        c0289b.f853e.remove(str);
        return z;
    }

    private void m1228c(String str, C0289b c0289b, Bundle bundle) {
        final C0289b c0289b2 = c0289b;
        final String str2 = str;
        final Bundle bundle2 = bundle;
        C0285c c02862 = new C0285c<List<MediaItem>>(this, str) {
            final /* synthetic */ MediaBrowserServiceCompat f844d;

            void m1196a(List<MediaItem> list, int i) {
                if (this.f844d.f883b.get(c0289b2.f851c.mo179a()) == c0289b2) {
                    List a;
                    if ((i & 1) != 0) {
                        a = C0303a.m1246a((List) list, bundle2);
                    }
                    try {
                        c0289b2.f851c.mo181a(str2, a, bundle2);
                    } catch (RemoteException e) {
                        Log.w("MediaBrowserServiceCompat", "Calling onLoadChildren() failed for id=" + str2 + " package=" + c0289b2.f849a);
                    }
                }
            }
        };
        if (bundle == null) {
            m1230a(str, c02862);
        } else {
            m1231a(str, c02862, bundle);
        }
        if (!c02862.m1194a()) {
            throw new IllegalStateException("onLoadChildren must call detach() or sendResult() before returning for package=" + c0289b.f849a + " id=" + str);
        }
    }

    private void m1222a(String str, final ResultReceiver resultReceiver) {
        C0285c c02873 = new C0285c<MediaItem>(this, str) {
            final /* synthetic */ MediaBrowserServiceCompat f846b;

            void m1197a(MediaItem mediaItem, int i) {
                Bundle bundle = new Bundle();
                bundle.putParcelable("media_item", mediaItem);
                resultReceiver.m1277a(0, bundle);
            }
        };
        m1232b(str, c02873);
        if (!c02873.m1194a()) {
            throw new IllegalStateException("onLoadItem must call detach() or sendResult() before returning for id=" + str);
        }
    }
}
