package com.bigroad.ttb.android.eobr;

import com.bigroad.shared.am;
import com.bigroad.ttb.android.logging.C2134e;
import com.bigroad.ttb.android.p030a.C1257b;
import com.bigroad.ttb.android.p038g.C2078a;
import java.io.IOException;
import java.net.Socket;

class C1932h implements C1888d {
    private final String f6658a;
    private final int f6659b;
    private final String f6660c;
    private final String f6661d;

    public C1932h(String str, int i, String str2, String str3) {
        this.f6658a = str;
        this.f6659b = i;
        this.f6660c = am.m4185a(str2);
        this.f6661d = "SimSim-" + str3;
    }

    public String mo1087a() {
        return this.f6660c;
    }

    public String mo1088b() {
        return this.f6661d;
    }

    public C1886c mo1086a(final EobrDevice eobrDevice) {
        return new C1886c(this) {
            final /* synthetic */ C1932h f6656b;
            private C2078a f6657c = null;

            private Socket m9498b() {
                Socket socket;
                IOException iOException;
                int i = 1;
                while (i <= 2) {
                    try {
                        Socket socket2 = new Socket(this.f6656b.f6658a, this.f6656b.f6659b);
                        try {
                            C2134e.m10676b("TT-SimConn", "Connect ok, attempt " + i);
                            return socket2;
                        } catch (IOException e) {
                            IOException iOException2 = e;
                            socket = socket2;
                            iOException = iOException2;
                        }
                    } catch (IOException e2) {
                        iOException = e2;
                        socket = null;
                        C2134e.m10676b("TT-SimConn", "Exception creating socket by UUID, attempt " + i + "; " + iOException.getMessage());
                        C1257b.m6614a(socket);
                        i++;
                    }
                }
                return null;
            }

            public void run() {
                this.f6657c = C2078a.m10431a(m9498b());
                eobrDevice.m8987a((C1886c) this);
            }

            public C2078a mo1085a() {
                return this.f6657c;
            }
        };
    }
}
