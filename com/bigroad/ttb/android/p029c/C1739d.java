package com.bigroad.ttb.android.p029c;

import com.bigroad.shared.dailylog.C0866b.C0863a;
import com.bigroad.ttb.android.OurApplication;
import com.bigroad.ttb.protocol.TTProtocol.DailyLog;
import com.bigroad.ttb.protocol.TTProtocol.Fleet;
import com.bigroad.ttb.protocol.TTProtocol.Person;
import com.bigroad.ttb.protocol.TTProtocol.Truck;

public class C1739d implements C0863a {
    private static C1739d f6018a;

    private C1739d() {
    }

    public static C1739d m8519d() {
        if (f6018a == null) {
            f6018a = new C1739d();
        }
        return f6018a;
    }

    public Person mo1058a() {
        return OurApplication.m6285g().m12222l();
    }

    public Fleet mo1060b() {
        return OurApplication.m6292n().m11013b();
    }

    public Truck mo1061c() {
        return OurApplication.m6294p().m6578f();
    }

    public Truck mo1059a(String str) {
        return OurApplication.m6294p().m6574d(str);
    }

    public DailyLog mo1057a(int i) {
        return OurApplication.m6296r().m8486c(i);
    }
}
