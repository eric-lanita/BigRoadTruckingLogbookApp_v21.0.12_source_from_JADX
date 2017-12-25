package com.bigroad.ttb.android.eobr;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import com.bigroad.shared.C1181z;
import com.bigroad.ttb.android.logging.C2134e;
import com.bigroad.ttb.android.p038g.C2078a;
import com.bigroad.ttb.android.util.C2281d;
import com.bigroad.ttb.android.util.C2291k;
import java.io.Closeable;
import java.io.IOException;
import java.util.UUID;

class C1889a implements C1888d {
    private static final UUID f6519a = UUID.fromString("00001101-0000-1000-8000-00805F9B34FB");
    private final BluetoothDevice f6520b;

    public C1889a(BluetoothDevice bluetoothDevice) {
        this.f6520b = bluetoothDevice;
    }

    public String mo1087a() {
        return this.f6520b.getAddress();
    }

    public String mo1088b() {
        return C2281d.m11194a(this.f6520b);
    }

    public C1886c mo1086a(final EobrDevice eobrDevice) {
        return new C1886c(this) {
            final /* synthetic */ C1889a f6517b;
            private C2078a f6518c = null;

            private BluetoothSocket m9216b() {
                BluetoothSocket createInsecureRfcommSocketToServiceRecord;
                Throwable th;
                int i = 1;
                while (i <= 2) {
                    try {
                        C2134e.m10676b("TT-BtConn", "Connecting to " + eobrDevice.m8993e() + "; attempt " + i);
                        if (C2291k.m11225d() >= 10) {
                            createInsecureRfcommSocketToServiceRecord = this.f6517b.f6520b.createInsecureRfcommSocketToServiceRecord(C1889a.f6519a);
                        } else {
                            createInsecureRfcommSocketToServiceRecord = this.f6517b.f6520b.createRfcommSocketToServiceRecord(C1889a.f6519a);
                        }
                        try {
                            createInsecureRfcommSocketToServiceRecord.connect();
                            C2134e.m10676b("TT-BtConn", "Connect succeeded");
                            return createInsecureRfcommSocketToServiceRecord;
                        } catch (Throwable e) {
                            Throwable th2 = e;
                            Object obj = createInsecureRfcommSocketToServiceRecord;
                            th = th2;
                        }
                    } catch (IOException e2) {
                        th = e2;
                        Closeable closeable = null;
                        C2134e.m10677b("TT-BtConn", "Connect failed", th);
                        C1181z.m5999a(closeable);
                        i++;
                    }
                }
                return null;
            }

            public void run() {
                this.f6518c = C2078a.m10430a(m9216b());
                eobrDevice.m8987a((C1886c) this);
            }

            public C2078a mo1085a() {
                return this.f6518c;
            }
        };
    }
}
