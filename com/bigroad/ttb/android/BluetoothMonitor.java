package com.bigroad.ttb.android;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.Context;
import com.bigroad.ttb.android.logging.C2134e;
import java.util.HashSet;
import java.util.Set;

public class BluetoothMonitor {
    private static BluetoothMonitor f4014a;
    private final BluetoothAdapter f4015b = BluetoothAdapter.getDefaultAdapter();
    private final Set<C1188a> f4016c = new HashSet();
    private boolean f4017d = m6065f();

    public enum BluetoothStatus {
        UNSUPPORTED,
        DISABLED,
        ENABLED
    }

    public interface C1188a {
        void mo875a();

        void mo876a(BluetoothDevice bluetoothDevice, short s);

        void mo877b();

        void mo878c();
    }

    public static class C1189b implements C1188a {
        public void mo875a() {
        }

        public void mo877b() {
        }

        public void mo878c() {
        }

        public void mo876a(BluetoothDevice bluetoothDevice, short s) {
        }
    }

    public static BluetoothMonitor m6051a(Context context) {
        if (f4014a == null) {
            f4014a = new BluetoothMonitor();
        }
        return f4014a;
    }

    private BluetoothMonitor() {
    }

    private C1188a[] m6053i() {
        return (C1188a[]) this.f4016c.toArray(new C1188a[this.f4016c.size()]);
    }

    private void m6054j() {
        for (C1188a a : m6053i()) {
            a.mo875a();
        }
    }

    private void m6055k() {
        for (C1188a b : m6053i()) {
            b.mo877b();
        }
    }

    private void m6056l() {
        for (C1188a c : m6053i()) {
            c.mo878c();
        }
    }

    private void m6052b(BluetoothDevice bluetoothDevice, short s) {
        for (C1188a a : m6053i()) {
            a.mo876a(bluetoothDevice, s);
        }
    }

    private void m6057m() {
        boolean f = m6065f();
        if (f != this.f4017d) {
            this.f4017d = f;
            if (f) {
                m6055k();
            } else {
                m6056l();
            }
        }
    }

    public void m6058a() {
        m6054j();
    }

    public void m6061b() {
        m6057m();
    }

    public void m6062c() {
        m6057m();
    }

    public void m6059a(BluetoothDevice bluetoothDevice, short s) {
        if (bluetoothDevice != null) {
            m6052b(bluetoothDevice, s);
        }
    }

    public void m6060a(C1188a c1188a) {
        this.f4016c.add(c1188a);
    }

    public BluetoothStatus m6063d() {
        if (this.f4015b == null) {
            return BluetoothStatus.UNSUPPORTED;
        }
        BluetoothStatus bluetoothStatus = BluetoothStatus.DISABLED;
        try {
            return this.f4015b.isEnabled() ? BluetoothStatus.ENABLED : BluetoothStatus.DISABLED;
        } catch (Throwable e) {
            C2134e.m10674a("TT-BtMon", "getBluetoothStatus", e);
            return bluetoothStatus;
        }
    }

    public boolean m6064e() {
        return this.f4015b == null;
    }

    public boolean m6065f() {
        try {
            return this.f4015b != null && this.f4015b.isDiscovering();
        } catch (Throwable e) {
            C2134e.m10674a("TT-BtMon", "BluetoothAdapter.isDiscovering (handleDiscoveryEvent)", e);
            return false;
        }
    }

    public boolean m6066g() {
        if (this.f4015b == null) {
            C2134e.m10680d("TT-BtMon", "startDiscovery ignored with null bluetooth adapter");
            return false;
        }
        try {
            if (this.f4015b.startDiscovery()) {
                return true;
            }
            C2134e.m10678c("TT-BtMon", "startDiscovery failed");
            return false;
        } catch (Throwable e) {
            C2134e.m10674a("TT-BtMon", "startDiscovery", e);
            return false;
        }
    }

    public void m6067h() {
        if (this.f4015b != null) {
            try {
                if (!this.f4015b.cancelDiscovery()) {
                    C2134e.m10678c("TT-BtMon", "cancelDiscovery failed");
                }
            } catch (Throwable e) {
                C2134e.m10674a("TT-BtMon", "cancelDiscovery", e);
            }
        }
    }
}
