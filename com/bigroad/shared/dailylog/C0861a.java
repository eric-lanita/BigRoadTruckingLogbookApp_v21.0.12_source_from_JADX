package com.bigroad.shared.dailylog;

import com.bigroad.shared.am;
import com.bigroad.ttb.protocol.TTProtocol.DailyLog;
import com.bigroad.ttb.protocol.TTProtocol.Fleet;

public class C0861a {
    private static final C0861a f2670a = new C0861a();
    private final String f2671b;
    private final String f2672c;

    public C0861a(String str, String str2) {
        this.f2671b = str;
        this.f2672c = str2;
    }

    private C0861a() {
        this(null, null);
    }

    public String m4308a() {
        return this.f2671b;
    }

    public String m4309b() {
        return this.f2672c;
    }

    public static C0861a m4307a(DailyLog dailyLog, Fleet fleet) {
        String carrierAddress;
        C0861a c0861a;
        C0861a c0861a2;
        String str = null;
        if (dailyLog != null) {
            String carrierName = dailyLog.hasCarrierName() ? dailyLog.getCarrierName() : null;
            if (dailyLog.hasCarrierAddress()) {
                carrierAddress = dailyLog.getCarrierAddress();
            } else {
                carrierAddress = null;
            }
            c0861a = new C0861a(carrierName, carrierAddress);
        } else {
            c0861a = f2670a;
        }
        if (fleet != null) {
            String name = fleet.getName();
            String str2 = ", ";
            Object[] objArr = new Object[5];
            if (fleet.hasAddress1()) {
                carrierName = fleet.getAddress1();
            } else {
                carrierName = null;
            }
            objArr[0] = carrierName;
            if (fleet.hasAddress2()) {
                carrierName = fleet.getAddress2();
            } else {
                carrierName = null;
            }
            objArr[1] = carrierName;
            if (fleet.hasCity()) {
                carrierName = fleet.getCity();
            } else {
                carrierName = null;
            }
            objArr[2] = carrierName;
            if (fleet.hasState()) {
                carrierName = fleet.getState();
            } else {
                carrierName = null;
            }
            objArr[3] = carrierName;
            if (fleet.hasPostalCode()) {
                str = fleet.getPostalCode();
            }
            objArr[4] = str;
            c0861a2 = new C0861a(name, am.m4187a(str2, objArr));
        } else {
            c0861a2 = f2670a;
        }
        if (am.m4188a(c0861a2.m4308a())) {
            carrierAddress = c0861a.m4308a();
            str = c0861a.m4309b();
        } else {
            carrierAddress = c0861a2.m4308a();
            str = c0861a2.m4309b();
        }
        if (am.m4188a((CharSequence) str) && am.m4189a(c0861a.m4308a(), c0861a2.m4308a())) {
            str = am.m4188a(c0861a2.m4309b()) ? c0861a.m4309b() : c0861a2.m4309b();
        }
        return new C0861a(carrierAddress, str);
    }
}
