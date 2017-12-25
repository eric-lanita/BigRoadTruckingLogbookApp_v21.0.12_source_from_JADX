package com.bigroad.ttb.android.p035d.p036a;

import com.bigroad.ttb.protocol.TTProtocol.DashLinkFirmwareVersion;

public class C1772k extends C1762b {
    public C1772k(String str, boolean z, int i) {
        this.a.put("version_number", str);
        this.a.put("is_valid", Boolean.valueOf(z));
        this.a.put("crc", Integer.valueOf(i));
    }

    public C1772k(DashLinkFirmwareVersion dashLinkFirmwareVersion) {
        this(dashLinkFirmwareVersion.getVersionNumber(), dashLinkFirmwareVersion.getIsValid(), dashLinkFirmwareVersion.getCrc());
    }

    public String mo1062a() {
        return "stored_dash_link_firmware_version";
    }
}
