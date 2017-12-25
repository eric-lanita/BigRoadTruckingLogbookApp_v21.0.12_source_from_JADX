package com.bigroad.shared.eobr.turbo.messages;

import com.bigroad.shared.eobr.turbo.C1000c;

public class UsbStatusMessage extends aj {
    public final UsbStatus f3362a;

    public enum UsbStatus implements C1000c {
        USB_STATUS_FATFS_CONNECTED(0),
        USB_STATUS_UNKNOWN(1);
        
        private final int m_id;

        private UsbStatus(int i) {
            this.m_id = i;
        }

        public int mo760a() {
            return this.m_id;
        }

        public boolean mo761b() {
            return this == USB_STATUS_UNKNOWN;
        }
    }

    public UsbStatusMessage(UsbStatus usbStatus) {
        this.f3362a = usbStatus;
    }
}
