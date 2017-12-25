package com.bigroad.ttb.android.p038g;

import android.bluetooth.BluetoothSocket;
import java.io.Closeable;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public abstract class C2078a implements Closeable {

    private static class C2079a extends C2078a {
        private BluetoothSocket f7276a;

        private C2079a(BluetoothSocket bluetoothSocket) {
            this.f7276a = bluetoothSocket;
        }

        public InputStream mo1216a() {
            return this.f7276a.getInputStream();
        }

        public OutputStream mo1217b() {
            return this.f7276a.getOutputStream();
        }

        public void close() {
            this.f7276a.close();
        }
    }

    private static class C2080b extends C2078a {
        private Socket f7277a;

        private C2080b(Socket socket) {
            this.f7277a = socket;
        }

        public InputStream mo1216a() {
            return this.f7277a.getInputStream();
        }

        public OutputStream mo1217b() {
            return this.f7277a.getOutputStream();
        }

        public void close() {
            this.f7277a.close();
        }
    }

    public abstract InputStream mo1216a();

    public abstract OutputStream mo1217b();

    public static C2078a m10430a(BluetoothSocket bluetoothSocket) {
        if (bluetoothSocket == null) {
            return null;
        }
        return new C2079a(bluetoothSocket);
    }

    public static C2078a m10431a(Socket socket) {
        if (socket == null) {
            return null;
        }
        return new C2080b(socket);
    }
}
