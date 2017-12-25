package com.bigroad.ttb.android.eobr.genx;

import com.bigroad.shared.C1098j;
import com.bigroad.shared.eobr.C0972e;
import com.bigroad.shared.eobr.C0973f;
import com.bigroad.shared.eobr.genx.C0983f;
import com.bigroad.ttb.android.eobr.C1902e.C1206c;
import com.bigroad.ttb.android.logging.C2134e;

public class C1920d implements C1206c {
    private C1919c f6643a;

    public C1920d(C1919c c1919c) {
        this.f6643a = c1919c;
    }

    public void mo897a(C0972e c0972e, C0973f c0973f) {
        if (c0973f == null) {
            C2134e.m10680d("TT-GenxFirmwareVersionResponseCallback", "Unexpected null response received! Requesting firmware version again...");
            this.f6643a.m9438b(true);
            return;
        }
        C2134e.m10673a("TT-GenxFirmwareVersionResponseCallback", c0973f.toString());
        if (c0973f instanceof C0983f) {
            m9445a(((C0983f) c0973f).m5041a().trim());
            return;
        }
        C2134e.m10673a("TT-GenxFirmwareVersionResponseCallback", "Callback received for class " + c0973f.getClass().getSimpleName() + ". Expected GenAtResponse. Requesting firmware version again...");
        this.f6643a.m9438b(true);
    }

    private void m9445a(String str) {
        C2134e.m10676b("TT-GenxFirmwareVersionResponseCallback", "Firmware version value " + str);
        if (this.f6643a == null) {
            C2134e.m10676b("TT-GenxFirmwareVersionResponseCallback", "Driver not ready! Firmware version not updated in Driver");
            return;
        }
        String[] split = str.split(" ");
        if (split.length > 0) {
            this.f6643a.m9431a(new C1098j(split[0].replaceAll("[^\\d.]", "")));
            return;
        }
        C2134e.m10682e("TT-GenxFirmwareVersionResponseCallback", "Error reading firmware version. Setting to 0.0.0.");
        this.f6643a.m9431a(new C1098j(0, 0, 0));
    }
}
