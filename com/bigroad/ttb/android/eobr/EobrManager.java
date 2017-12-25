package com.bigroad.ttb.android.eobr;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.Context;
import android.os.Handler;
import com.bigroad.shared.ag;
import com.bigroad.shared.ag.C0837a;
import com.bigroad.shared.ai;
import com.bigroad.shared.am;
import com.bigroad.ttb.android.BluetoothMonitor;
import com.bigroad.ttb.android.BluetoothMonitor.C1188a;
import com.bigroad.ttb.android.BluetoothMonitor.C1189b;
import com.bigroad.ttb.android.OurApplication;
import com.bigroad.ttb.android.eobr.EobrDevice.C1859a;
import com.bigroad.ttb.android.eobr.EobrDevice.ConnectionState;
import com.bigroad.ttb.android.eobr.genx.C1916b;
import com.bigroad.ttb.android.eobr.genx.C1919c;
import com.bigroad.ttb.android.eobr.turbo.C1955b;
import com.bigroad.ttb.android.eobr.turbo.C1960c;
import com.bigroad.ttb.android.eobr.vna.C1982a;
import com.bigroad.ttb.android.eobr.vna.C1992b;
import com.bigroad.ttb.android.logging.C2134e;
import com.bigroad.ttb.android.util.C2281d;
import com.bigroad.ttb.protocol.TTProtocol.Truck;
import com.google.protobuf.C3642c;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class EobrManager {
    private static EobrManager f6431a;
    private final Handler f6432b = new Handler();
    private final ag<ChangeListener> f6433c = new ag();
    private final BluetoothMonitor f6434d = OurApplication.m6250G();
    private final C1904g f6435e;
    private final Map<String, EobrDevice> f6436f = new HashMap();
    private final Map<String, C1880a> f6437g = new HashMap();
    private ScanState f6438h = ScanState.STOPPED;
    private final Runnable f6439i = new C18711(this);
    private final C1188a f6440j = new C18722(this);
    private final C1859a f6441k = new C18733(this);

    public interface ChangeListener {

        public enum Priority {
            AOBRD_MANAGER,
            AOBRD_ENGINE_USE,
            VAR_MANAGER,
            DEFAULT
        }

        void mo997a(EobrDevice eobrDevice);

        void mo998a(EobrDevice eobrDevice, boolean z);

        void mo999a(EobrManager eobrManager);

        void mo1000b(EobrDevice eobrDevice);

        void mo1001c(EobrDevice eobrDevice);
    }

    public static class C1449b implements ChangeListener {
        public void mo999a(EobrManager eobrManager) {
        }

        public void mo998a(EobrDevice eobrDevice, boolean z) {
        }

        public void mo997a(EobrDevice eobrDevice) {
        }

        public void mo1000b(EobrDevice eobrDevice) {
        }

        public void mo1001c(EobrDevice eobrDevice) {
        }
    }

    class C18711 implements Runnable {
        final /* synthetic */ EobrManager f6406a;

        C18711(EobrManager eobrManager) {
            this.f6406a = eobrManager;
        }

        public void run() {
            this.f6406a.m9125d();
        }
    }

    class C18722 extends C1189b {
        final /* synthetic */ EobrManager f6407a;

        C18722(EobrManager eobrManager) {
            this.f6407a = eobrManager;
        }

        public void mo877b() {
            C2134e.m10678c("TT-EobrMgr", "Bluetooth Discovery has begun");
        }

        public void mo878c() {
            this.f6407a.m9125d();
        }

        public void mo876a(BluetoothDevice bluetoothDevice, short s) {
            this.f6407a.m9098a(bluetoothDevice, s);
        }
    }

    class C18733 implements C1859a {
        final /* synthetic */ EobrManager f6408a;

        C18733(EobrManager eobrManager) {
            this.f6408a = eobrManager;
        }

        public void mo1082c(EobrDevice eobrDevice) {
            this.f6408a.m9107d(eobrDevice);
        }

        public void mo1083d(EobrDevice eobrDevice) {
            this.f6408a.m9108e(eobrDevice);
        }

        public void mo1084e(EobrDevice eobrDevice) {
            this.f6408a.m9109f(eobrDevice);
        }

        public void mo1080a(EobrDevice eobrDevice) {
            this.f6408a.m9099a(eobrDevice, true);
        }

        public void mo1081b(EobrDevice eobrDevice) {
            this.f6408a.m9099a(eobrDevice, false);
        }
    }

    class C18744 implements Comparator<C1880a> {
        final /* synthetic */ EobrManager f6409a;

        C18744(EobrManager eobrManager) {
            this.f6409a = eobrManager;
        }

        public /* synthetic */ int compare(Object obj, Object obj2) {
            return m9086a((C1880a) obj, (C1880a) obj2);
        }

        public int m9086a(C1880a c1880a, C1880a c1880a2) {
            if (c1880a.f6429b > c1880a2.f6429b) {
                return -1;
            }
            if (c1880a.f6429b < c1880a2.f6429b) {
                return 1;
            }
            return 0;
        }
    }

    class C18755 implements C0837a<ChangeListener> {
        final /* synthetic */ EobrManager f6410a;

        C18755(EobrManager eobrManager) {
            this.f6410a = eobrManager;
        }

        public void m9087a(ChangeListener changeListener) {
            changeListener.mo999a(this.f6410a);
        }
    }

    private enum ScanState {
        STARTED,
        STOPPED
    }

    private class C1880a {
        final String f6428a;
        short f6429b;
        final /* synthetic */ EobrManager f6430c;

        public C1880a(EobrManager eobrManager, String str, short s) {
            this.f6430c = eobrManager;
            this.f6428a = str;
            this.f6429b = s;
        }
    }

    public static EobrManager m9097a(Context context) {
        if (f6431a == null) {
            f6431a = new EobrManager(context);
        }
        return f6431a;
    }

    private EobrManager(Context context) {
        this.f6435e = C1904g.m9313a(context);
        this.f6434d.m6060a(this.f6440j);
    }

    private void m9098a(BluetoothDevice bluetoothDevice, short s) {
        if (bluetoothDevice == null) {
            if (this.f6438h != ScanState.STOPPED) {
                C2134e.m10680d("TT-EobrMgr", "Received NULL device from state " + this.f6438h);
            }
        } else if (this.f6438h != ScanState.STOPPED) {
            String address = bluetoothDevice.getAddress();
            C1880a c1880a = (C1880a) this.f6437g.get(address);
            if (C1992b.m9829a(bluetoothDevice)) {
                m9105c(new C1982a(new C1889a(bluetoothDevice), false));
                if (c1880a == null) {
                    C2134e.m10678c("TT-EobrMgr", "Found VNA device: " + address + " (" + C2281d.m11194a(bluetoothDevice) + ") ");
                    m9111i();
                }
            } else if (C1960c.m9639a(bluetoothDevice)) {
                m9105c(new C1955b(new C1889a(bluetoothDevice), false));
                if (c1880a == null) {
                    C2134e.m10678c("TT-EobrMgr", "Found Turbo device: " + address + " (" + C2281d.m11194a(bluetoothDevice) + ") ");
                    m9111i();
                }
            } else if (C1919c.m9415a(bluetoothDevice)) {
                m9105c(new C1916b(new C1889a(bluetoothDevice), false));
                if (c1880a == null) {
                    C2134e.m10678c("TT-EobrMgr", "Found GENX device: " + address + " (" + C2281d.m11194a(bluetoothDevice) + ") ");
                    m9111i();
                }
            } else if (c1880a == null) {
                C2134e.m10678c("TT-EobrMgr", "Device " + address + " does not appear to be an EOBR; skipping");
            }
            if (c1880a == null) {
                this.f6437g.put(address, new C1880a(this, address, s));
            } else if (s > Short.MIN_VALUE) {
                c1880a.f6429b = s;
            }
        }
    }

    public static boolean m9103a(BluetoothDevice bluetoothDevice) {
        return C1992b.m9829a(bluetoothDevice) || C1960c.m9639a(bluetoothDevice) || C1919c.m9415a(bluetoothDevice);
    }

    private void m9105c(EobrDevice eobrDevice) {
        eobrDevice.m8986a(this.f6441k);
        String c = eobrDevice.m8991c();
        EobrDevice eobrDevice2 = (EobrDevice) this.f6436f.get(c);
        if (eobrDevice2 == null) {
            this.f6436f.put(eobrDevice.m8991c(), eobrDevice);
            return;
        }
        ConnectionState i = eobrDevice2.m8997i();
        if (i == ConnectionState.NOT_CONNECTED) {
            this.f6436f.put(eobrDevice.m8991c(), eobrDevice);
        } else {
            C2134e.m10678c("TT-EobrMgr", "Not updating EobrDevice with MAC " + c + " because it is " + i);
        }
    }

    private void m9110h() {
        for (EobrDevice eobrDevice : this.f6435e.m9316a()) {
            m9105c(eobrDevice);
            this.f6437g.put(eobrDevice.m8991c(), new C1880a(this, eobrDevice.m8991c(), Short.MAX_VALUE));
        }
    }

    public ArrayList<EobrDevice> m9115a() {
        Object arrayList = new ArrayList();
        arrayList.addAll(this.f6437g.values());
        Collections.sort(arrayList, new C18744(this));
        ArrayList<EobrDevice> arrayList2 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            EobrDevice eobrDevice = (EobrDevice) this.f6436f.get(((C1880a) it.next()).f6428a);
            if (eobrDevice != null) {
                arrayList2.add(eobrDevice);
            }
        }
        return arrayList2;
    }

    private void m9111i() {
        this.f6433c.m4157a(new C18755(this));
    }

    private void m9099a(final EobrDevice eobrDevice, final boolean z) {
        this.f6433c.m4157a(new C0837a<ChangeListener>(this) {
            final /* synthetic */ EobrManager f6413c;

            public void m9089a(ChangeListener changeListener) {
                changeListener.mo998a(eobrDevice, z);
            }
        });
    }

    private void m9107d(final EobrDevice eobrDevice) {
        this.f6433c.m4157a(new C0837a<ChangeListener>(this) {
            final /* synthetic */ EobrManager f6415b;

            public void m9091a(ChangeListener changeListener) {
                changeListener.mo997a(eobrDevice);
            }
        });
    }

    private void m9108e(final EobrDevice eobrDevice) {
        this.f6433c.m4157a(new C0837a<ChangeListener>(this) {
            final /* synthetic */ EobrManager f6417b;

            public void m9093a(ChangeListener changeListener) {
                changeListener.mo1000b(eobrDevice);
            }
        });
    }

    private void m9109f(final EobrDevice eobrDevice) {
        this.f6433c.m4157a(new C0837a<ChangeListener>(this) {
            final /* synthetic */ EobrManager f6419b;

            public void m9095a(ChangeListener changeListener) {
                changeListener.mo1001c(eobrDevice);
            }
        });
    }

    public void m9118a(ChangeListener changeListener) {
        m9119a(changeListener, Priority.DEFAULT);
    }

    public void m9119a(ChangeListener changeListener, Priority priority) {
        this.f6433c.m4159a(changeListener, priority.ordinal());
    }

    public void m9122b(ChangeListener changeListener) {
        this.f6433c.m4158a((Object) changeListener);
    }

    public boolean m9123b() {
        return this.f6438h != ScanState.STOPPED;
    }

    public void m9116a(long j) {
        if (j < 0) {
            throw new IllegalArgumentException("duration must be >= 0 (was " + j + ")");
        }
        if (this.f6434d.m6065f()) {
            C2134e.m10676b("TT-EobrMgr", "discovery already in progress");
        } else {
            this.f6437g.clear();
            if (!(this.f6434d.m6064e() || this.f6434d.m6066g())) {
                C2134e.m10680d("TT-EobrMgr", "startDiscovery failed.  startScan will timeout.");
            }
        }
        this.f6438h = ScanState.STARTED;
        this.f6432b.removeCallbacks(this.f6439i);
        this.f6432b.postDelayed(this.f6439i, j);
        EobrDevice j2 = OurApplication.m6252I().m11412j();
        if (j2 != null && j2.m9007s()) {
            C2134e.m10678c("TT-EobrMgr", "Disconnecting from simulated EobrDevice with MAC " + j2.m8991c());
            j2.m8999k();
        }
        m9110h();
        if (this.f6434d.m6064e() && this.f6438h == ScanState.STARTED) {
            m9125d();
        } else {
            m9111i();
        }
    }

    public void m9124c() {
        m9116a(30000);
    }

    public void m9125d() {
        this.f6438h = ScanState.STOPPED;
        this.f6432b.removeCallbacks(this.f6439i);
        this.f6434d.m6067h();
        m9111i();
    }

    public void m9126e() {
        m9110h();
        m9111i();
    }

    public void m9117a(EobrDevice eobrDevice) {
        m9125d();
        eobrDevice.m8998j();
    }

    public void m9121b(EobrDevice eobrDevice) {
        if (eobrDevice != null) {
            eobrDevice.m8999k();
        }
    }

    public void m9127f() {
        for (EobrDevice b : this.f6436f.values()) {
            m9121b(b);
        }
    }

    public EobrDevice m9113a(String str) {
        return str == null ? null : (EobrDevice) this.f6436f.get(str);
    }

    public List<EobrDevice> m9128g() {
        List arrayList = new ArrayList();
        for (EobrDevice eobrDevice : this.f6436f.values()) {
            if (eobrDevice.m8997i() == ConnectionState.CONNECTED) {
                arrayList.add(eobrDevice);
            }
        }
        return arrayList;
    }

    public EobrDevice m9112a(Truck truck) {
        C3642c c3642c = null;
        if (truck == null) {
            return null;
        }
        String genxSerialNumber;
        String vin = truck.getVin();
        if (truck.hasGenxSerialNumber()) {
            genxSerialNumber = truck.getGenxSerialNumber();
        } else {
            genxSerialNumber = null;
        }
        if (truck.hasAssociatedDashLink()) {
            c3642c = truck.getAssociatedDashLink();
        }
        return m9114a(ai.m4178b(c3642c), genxSerialNumber, vin);
    }

    public EobrDevice m9114a(byte[] bArr, String str, String str2) {
        List<EobrDevice> g = m9128g();
        if (am.m4188a((CharSequence) str)) {
            if (bArr != null) {
                for (EobrDevice eobrDevice : g) {
                    if (Arrays.equals(bArr, eobrDevice.m8992d())) {
                        return eobrDevice;
                    }
                }
            }
            if (!am.m4188a((CharSequence) str2)) {
                for (EobrDevice eobrDevice2 : g) {
                    if (str2.equalsIgnoreCase(eobrDevice2.m9000l())) {
                        return eobrDevice2;
                    }
                }
            }
        }
        String str3 = "GENX_" + str;
        for (EobrDevice eobrDevice22 : g) {
            if (str3.equals(eobrDevice22.m8993e())) {
                return eobrDevice22;
            }
        }
        return null;
    }

    public EobrDevice m9120b(String str) {
        EobrDevice eobrDevice = null;
        if (BluetoothAdapter.getDefaultAdapter() != null) {
            try {
                EobrDevice c1982a;
                BluetoothDevice remoteDevice = BluetoothAdapter.getDefaultAdapter().getRemoteDevice(str);
                if (C1992b.m9829a(remoteDevice)) {
                    c1982a = new C1982a(new C1889a(remoteDevice), false);
                } else if (C1960c.m9639a(remoteDevice)) {
                    c1982a = new C1955b(new C1889a(remoteDevice), false);
                } else if (C1919c.m9415a(remoteDevice)) {
                    c1982a = new C1916b(new C1889a(remoteDevice), false);
                } else {
                    C2134e.m10678c("TT-EobrMgr", "Cannot identify device " + str);
                    c1982a = null;
                }
                eobrDevice = c1982a;
            } catch (IllegalArgumentException e) {
                C2134e.m10680d("TT-EobrMgr", e.toString());
            }
            if (eobrDevice != null) {
                m9105c(eobrDevice);
            }
        }
        return eobrDevice;
    }
}
