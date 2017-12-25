package com.bigroad.ttb.android;

import android.content.Context;
import com.bigroad.ttb.android.AuthMonitor.AuthStatus;
import com.bigroad.ttb.android.AuthMonitor.C1185a;
import com.bigroad.ttb.android.SyncManager.C1238b;
import com.bigroad.ttb.android.p032e.C1851a;
import com.bigroad.ttb.android.p032e.C1851a.C1698a;
import com.bigroad.ttb.android.service.SyncService;

public class ae {
    private static ae f5874a;
    private final AuthMonitor f5875b = OurApplication.m6249F();
    private final SyncManager f5876c = OurApplication.m6289k();
    private final C1851a f5877d = OurApplication.m6288j();
    private boolean f5878e = false;
    private boolean f5879f = false;
    private boolean f5880g = false;
    private boolean f5881h = false;
    private final C1185a f5882i = new C16961(this);
    private final C1238b f5883j = new C16972(this);
    private final C1698a f5884k = new C16993(this);

    class C16961 implements C1185a {
        final /* synthetic */ ae f5871a;

        C16961(ae aeVar) {
            this.f5871a = aeVar;
        }

        public void mo912a(AuthStatus authStatus) {
            this.f5871a.m8275a();
            this.f5871a.m8278b();
        }
    }

    class C16972 implements C1238b {
        final /* synthetic */ ae f5872a;

        C16972(ae aeVar) {
            this.f5872a = aeVar;
        }

        public void mo1045a() {
            this.f5872a.f5880g = false;
            this.f5872a.m8278b();
        }

        public void mo1046b() {
            this.f5872a.f5880g = true;
            this.f5872a.m8278b();
        }
    }

    class C16993 implements C1698a {
        final /* synthetic */ ae f5873a;

        C16993(ae aeVar) {
            this.f5873a = aeVar;
        }

        public void mo1047a() {
            this.f5873a.f5881h = false;
            this.f5873a.m8278b();
        }

        public void mo1048b() {
            this.f5873a.f5881h = true;
            this.f5873a.m8278b();
        }
    }

    public static ae m8274a(Context context) {
        if (f5874a == null) {
            f5874a = new ae(context);
        }
        return f5874a;
    }

    private void m8275a() {
        this.f5879f = !this.f5875b.m6030c();
    }

    private ae(Context context) {
        this.f5875b.m6027a(this.f5882i);
        this.f5876c.m6461a(this.f5883j);
        this.f5877d.m8933a(this.f5884k);
        m8275a();
        this.f5880g = this.f5876c.m6498c();
        this.f5881h = this.f5877d.m8935a();
        m8278b();
    }

    private void m8278b() {
        boolean c = m8281c();
        if (c != this.f5878e) {
            if (c) {
                SyncService.m11031a();
            } else {
                SyncService.m11034b();
            }
            this.f5878e = c;
        }
    }

    private boolean m8281c() {
        return this.f5879f || this.f5880g || this.f5881h;
    }
}
