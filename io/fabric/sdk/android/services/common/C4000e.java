package io.fabric.sdk.android.services.common;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import io.fabric.sdk.android.C3969c;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

class C4000e implements C3995f {
    private final Context f14159a;

    private static final class C3998a implements ServiceConnection {
        private boolean f14156a;
        private final LinkedBlockingQueue<IBinder> f14157b;

        private C3998a() {
            this.f14156a = false;
            this.f14157b = new LinkedBlockingQueue(1);
        }

        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                this.f14157b.put(iBinder);
            } catch (InterruptedException e) {
            }
        }

        public void onServiceDisconnected(ComponentName componentName) {
            this.f14157b.clear();
        }

        public IBinder m20765a() {
            if (this.f14156a) {
                C3969c.m20576h().mo2856e("Fabric", "getBinder already called");
            }
            this.f14156a = true;
            try {
                return (IBinder) this.f14157b.poll(200, TimeUnit.MILLISECONDS);
            } catch (InterruptedException e) {
                return null;
            }
        }
    }

    private static final class C3999b implements IInterface {
        private final IBinder f14158a;

        public boolean m20767b() {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.ssa.SSATransform.placePhi(SSATransform.java:82)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:50)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r7 = this;
            r0 = 1;
            r1 = 0;
            r2 = android.os.Parcel.obtain();
            r3 = android.os.Parcel.obtain();
            r4 = "com.google.android.gms.ads.identifier.internal.IAdvertisingIdService";	 Catch:{ Exception -> 0x002c, all -> 0x0040 }
            r2.writeInterfaceToken(r4);	 Catch:{ Exception -> 0x002c, all -> 0x0040 }
            r4 = 1;	 Catch:{ Exception -> 0x002c, all -> 0x0040 }
            r2.writeInt(r4);	 Catch:{ Exception -> 0x002c, all -> 0x0040 }
            r4 = r7.f14158a;	 Catch:{ Exception -> 0x002c, all -> 0x0040 }
            r5 = 2;	 Catch:{ Exception -> 0x002c, all -> 0x0040 }
            r6 = 0;	 Catch:{ Exception -> 0x002c, all -> 0x0040 }
            r4.transact(r5, r2, r3, r6);	 Catch:{ Exception -> 0x002c, all -> 0x0040 }
            r3.readException();	 Catch:{ Exception -> 0x002c, all -> 0x0040 }
            r4 = r3.readInt();	 Catch:{ Exception -> 0x002c, all -> 0x0040 }
            if (r4 == 0) goto L_0x002a;
        L_0x0023:
            r3.recycle();
            r2.recycle();
        L_0x0029:
            return r0;
        L_0x002a:
            r0 = r1;
            goto L_0x0023;
        L_0x002c:
            r0 = move-exception;
            r0 = io.fabric.sdk.android.C3969c.m20576h();	 Catch:{ Exception -> 0x002c, all -> 0x0040 }
            r4 = "Fabric";	 Catch:{ Exception -> 0x002c, all -> 0x0040 }
            r5 = "Could not get parcel from Google Play Service to capture Advertising limitAdTracking";	 Catch:{ Exception -> 0x002c, all -> 0x0040 }
            r0.mo2849a(r4, r5);	 Catch:{ Exception -> 0x002c, all -> 0x0040 }
            r3.recycle();
            r2.recycle();
            r0 = r1;
            goto L_0x0029;
        L_0x0040:
            r0 = move-exception;
            r3.recycle();
            r2.recycle();
            throw r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: io.fabric.sdk.android.services.common.e.b.b():boolean");
        }

        public C3999b(IBinder iBinder) {
            this.f14158a = iBinder;
        }

        public IBinder asBinder() {
            return this.f14158a;
        }

        public String m20766a() {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            String str = null;
            try {
                obtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                this.f14158a.transact(1, obtain, obtain2, 0);
                obtain2.readException();
                str = obtain2.readString();
            } catch (Exception e) {
                C3969c.m20576h().mo2849a("Fabric", "Could not get parcel from Google Play Service to capture AdvertisingId");
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
            return str;
        }
    }

    public C4000e(Context context) {
        this.f14159a = context.getApplicationContext();
    }

    public C3992b mo2881a() {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            C3969c.m20576h().mo2849a("Fabric", "AdvertisingInfoServiceStrategy cannot be called on the main thread");
            return null;
        }
        try {
            this.f14159a.getPackageManager().getPackageInfo("com.android.vending", 0);
            ServiceConnection c3998a = new C3998a();
            Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
            intent.setPackage("com.google.android.gms");
            try {
                if (this.f14159a.bindService(intent, c3998a, 1)) {
                    C3999b c3999b = new C3999b(c3998a.m20765a());
                    C3992b c3992b = new C3992b(c3999b.m20766a(), c3999b.m20767b());
                    this.f14159a.unbindService(c3998a);
                    return c3992b;
                }
                C3969c.m20576h().mo2849a("Fabric", "Could not bind to Google Play Service to capture AdvertisingId");
                return null;
            } catch (Throwable e) {
                C3969c.m20576h().mo2855d("Fabric", "Exception in binding to Google Play Service to capture AdvertisingId", e);
                this.f14159a.unbindService(c3998a);
                return null;
            } catch (Throwable e2) {
                C3969c.m20576h().mo2850a("Fabric", "Could not bind to Google Play Service to capture AdvertisingId", e2);
                return null;
            }
        } catch (NameNotFoundException e3) {
            C3969c.m20576h().mo2849a("Fabric", "Unable to find Google Play Services package name");
            return null;
        } catch (Throwable e22) {
            C3969c.m20576h().mo2850a("Fabric", "Unable to determine if Google Play Services is available", e22);
            return null;
        }
    }
}
