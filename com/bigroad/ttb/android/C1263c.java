package com.bigroad.ttb.android;

import com.bigroad.shared.C1181z;
import com.bigroad.shared.ap;
import com.bigroad.ttb.android.logging.C2134e;
import com.bigroad.ttb.android.p035d.p036a.C1767f;
import com.bigroad.ttb.android.util.C2283e;
import com.bigroad.ttb.protocol.TTProtocol.Response;
import com.bigroad.ttb.protocol.TTProtocol.ResponseStatus;
import com.google.protobuf.InvalidProtocolBufferException;
import java.io.BufferedInputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class C1263c implements Runnable {
    private static URL f4309a;
    private final ap f4310b = OurApplication.m6269Z();
    private final C1767f f4311c;
    private ResponseStatus f4312d = null;
    private Response f4313e = null;
    private long f4314f = 0;
    private long f4315g = 0;

    static {
        C1263c.m6651f();
    }

    private static String m6650a(Response response) {
        int responseCount = response.getResponseCount();
        if (responseCount <= 0) {
            return "(empty)";
        }
        StringBuilder stringBuilder = new StringBuilder(responseCount * 10);
        int min = Math.min(10, responseCount);
        for (int i = 0; i < min; i++) {
            if (stringBuilder.length() > 0) {
                stringBuilder.append(',');
            }
            stringBuilder.append(response.getResponse(i).getRequestType().toString());
        }
        if (min < responseCount) {
            stringBuilder.append(',').append(responseCount - min).append(" more");
        }
        return stringBuilder.toString();
    }

    public C1263c(C1767f c1767f) {
        this.f4311c = c1767f;
    }

    private ResponseStatus m6652g() {
        Throwable th;
        HttpURLConnection httpURLConnection;
        Closeable closeable = null;
        HttpURLConnection b;
        try {
            byte[] d = this.f4311c.m8589d();
            b = C2283e.m11198b(f4309a);
            try {
                b.setUseCaches(false);
                b.setConnectTimeout(30000);
                b.setReadTimeout(30000);
                b.setRequestMethod("POST");
                b.setRequestProperty("Content-Type", "application/octet-stream");
                b.setRequestProperty("Content-Length", Integer.toString(d.length));
                b.setFixedLengthStreamingMode(d.length);
                b.setDoInput(true);
                b.setDoOutput(true);
                Closeable outputStream;
                try {
                    outputStream = b.getOutputStream();
                    try {
                        outputStream.write(d);
                        C1181z.m5999a(outputStream);
                        switch (b.getResponseCode()) {
                            case 200:
                                try {
                                    InputStream bufferedInputStream = new BufferedInputStream(b.getInputStream(), 4096);
                                    try {
                                        this.f4313e = Response.parseFrom(bufferedInputStream);
                                        C1181z.m5999a(bufferedInputStream);
                                        this.f4312d = this.f4313e.getStatus();
                                        C2134e.m10676b("TT-APIRequest", "Received response " + C1263c.m6650a(this.f4313e) + ", status " + this.f4313e.getStatus());
                                        break;
                                    } catch (Throwable th2) {
                                        th = th2;
                                        Object obj = bufferedInputStream;
                                        C1181z.m5999a(closeable);
                                        throw th;
                                    }
                                } catch (Throwable th3) {
                                    th = th3;
                                    C1181z.m5999a(closeable);
                                    throw th;
                                }
                            case 400:
                                C2134e.m10682e("TT-APIRequest", "HTTP post failed, bad request");
                                this.f4312d = ResponseStatus.RS_INVALID_REQUEST;
                                break;
                            default:
                                C2134e.m10680d("TT-APIRequest", "HTTP post failed, response code " + b.getResponseCode() + ": " + b.getResponseMessage());
                                this.f4312d = ResponseStatus.RS_TRANSPORT_ERROR;
                                break;
                        }
                        if (b != null) {
                            b.disconnect();
                        }
                        this.f4314f = this.f4310b.mo913a();
                        this.f4315g = this.f4310b.mo915c();
                    } catch (Throwable th4) {
                        th = th4;
                        C1181z.m5999a(outputStream);
                        throw th;
                    }
                } catch (Throwable th5) {
                    th = th5;
                    outputStream = null;
                    C1181z.m5999a(outputStream);
                    throw th;
                }
            } catch (ClassCastException e) {
                th = e;
                httpURLConnection = b;
                try {
                    C2134e.m10681d("TT-APIRequest", "Unexpected exception", th);
                    this.f4312d = ResponseStatus.RS_TRANSPORT_ERROR;
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    this.f4314f = this.f4310b.mo913a();
                    this.f4315g = this.f4310b.mo915c();
                    return this.f4312d;
                } catch (Throwable th6) {
                    th = th6;
                    b = httpURLConnection;
                    if (b != null) {
                        b.disconnect();
                    }
                    this.f4314f = this.f4310b.mo913a();
                    this.f4315g = this.f4310b.mo915c();
                    throw th;
                }
            } catch (IOException e2) {
                th = e2;
                try {
                    C2134e.m10679c("TT-APIRequest", "IOException while running API request", th);
                    if (th instanceof InvalidProtocolBufferException) {
                        this.f4312d = ResponseStatus.RS_RESPONSE_PARSING_FAILED;
                    } else {
                        this.f4312d = ResponseStatus.RS_TRANSPORT_ERROR;
                    }
                    if (b != null) {
                        b.disconnect();
                    }
                    this.f4314f = this.f4310b.mo913a();
                    this.f4315g = this.f4310b.mo915c();
                    return this.f4312d;
                } catch (Throwable th7) {
                    th = th7;
                    if (b != null) {
                        b.disconnect();
                    }
                    this.f4314f = this.f4310b.mo913a();
                    this.f4315g = this.f4310b.mo915c();
                    throw th;
                }
            }
        } catch (ClassCastException e3) {
            th = e3;
            C2134e.m10681d("TT-APIRequest", "Unexpected exception", th);
            this.f4312d = ResponseStatus.RS_TRANSPORT_ERROR;
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
            this.f4314f = this.f4310b.mo913a();
            this.f4315g = this.f4310b.mo915c();
            return this.f4312d;
        } catch (IOException e4) {
            th = e4;
            b = null;
            C2134e.m10679c("TT-APIRequest", "IOException while running API request", th);
            if (th instanceof InvalidProtocolBufferException) {
                this.f4312d = ResponseStatus.RS_RESPONSE_PARSING_FAILED;
            } else {
                this.f4312d = ResponseStatus.RS_TRANSPORT_ERROR;
            }
            if (b != null) {
                b.disconnect();
            }
            this.f4314f = this.f4310b.mo913a();
            this.f4315g = this.f4310b.mo915c();
            return this.f4312d;
        } catch (Throwable th8) {
            th = th8;
            b = null;
            if (b != null) {
                b.disconnect();
            }
            this.f4314f = this.f4310b.mo913a();
            this.f4315g = this.f4310b.mo915c();
            throw th;
        }
        return this.f4312d;
    }

    public C1767f m6653a() {
        return this.f4311c;
    }

    public ResponseStatus m6655b() {
        return this.f4312d;
    }

    public Response m6656c() {
        return this.f4313e;
    }

    public long m6657d() {
        return this.f4314f;
    }

    public long m6658e() {
        return this.f4315g;
    }

    public void run() {
        try {
            m6652g();
        } catch (Throwable e) {
            if (e instanceof SecurityException) {
                C2134e.m10679c("TT-APIRequest", "Security exception", e);
            } else {
                C2134e.m10681d("TT-APIRequest", "Unexpected exception", e);
            }
            if (this.f4312d == null) {
                this.f4312d = ResponseStatus.RS_TRANSPORT_ERROR;
            }
        }
        mo916a(this);
    }

    public void mo916a(C1263c c1263c) {
    }

    public static void m6651f() {
        try {
            f4309a = new URL("https://" + OurApplication.m6245B().m10545a() + "/" + "api/v1");
            C2134e.m10678c("TT-APIRequest", "Using request URL: '" + f4309a + "'");
        } catch (Throwable e) {
            C2134e.m10682e("TT-APIRequest", e.toString());
            throw new RuntimeException(e);
        }
    }
}
