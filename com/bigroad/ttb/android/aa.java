package com.bigroad.ttb.android;

import android.content.Context;
import com.bigroad.ttb.android.logging.C2134e;
import com.bigroad.ttb.android.p035d.C1790a;
import com.bigroad.ttb.android.p035d.p036a.C1767f;
import com.bigroad.ttb.protocol.TTProtocol.AuthToken;
import com.bigroad.ttb.protocol.TTProtocol.Request;
import com.bigroad.ttb.protocol.TTProtocol.Request.C2739a;
import com.bigroad.ttb.protocol.TTProtocol.RequestType;
import com.google.protobuf.InvalidProtocolBufferException;

public class aa {
    private static aa f4294a;
    private final C1790a f4295b = OurApplication.m6287i();

    public static aa m6626a(Context context) {
        if (f4294a == null) {
            f4294a = new aa();
        }
        return f4294a;
    }

    private aa() {
    }

    private Request m6627a(Request request, Request request2) {
        if (!request.getClientId().equals(request2.getClientId()) || request.hasToken() != request2.hasToken()) {
            return null;
        }
        if (request.hasToken() && request2.hasToken()) {
            AuthToken token = request.getToken();
            AuthToken token2 = request2.getToken();
            if (!(token.getPersonId() == token2.getPersonId() && token.getToken().equals(token2.getToken()))) {
                return null;
            }
        }
        C2739a newBuilder = Request.newBuilder(request);
        newBuilder.m14892a(request2.getClientVersion());
        newBuilder.mo1377a(request2.getRequestList());
        return newBuilder.m14903c();
    }

    public void m6632a(Request request) {
        if (request != null) {
            Request request2 = null;
            C1767f d = this.f4295b.m8768d();
            if (!(d == null || d.m8590e())) {
                try {
                    byte[] d2 = d.m8589d();
                    if (d2.length < 4096) {
                        request2 = m6627a(Request.parseFrom(d2), request);
                    }
                } catch (InvalidProtocolBufferException e) {
                }
            }
            if (request2 == null) {
                this.f4295b.m8715a(request);
            } else {
                this.f4295b.m8725a(d.m8588b(), request2);
            }
        }
    }

    public C1767f m6629a() {
        C1767f c = this.f4295b.m8761c();
        if (!(c == null || c.m8590e())) {
            this.f4295b.m8726a(c.m8588b(), true);
        }
        return c;
    }

    public void m6630a(long j) {
        if (j >= 0) {
            this.f4295b.m8724a(j);
        }
    }

    public void m6631a(C1767f c1767f) {
        if (c1767f != null) {
            m6630a(c1767f.m8588b());
        }
    }

    public boolean m6633b() {
        return !this.f4295b.m8776e();
    }

    public static boolean m6628a(C1767f c1767f, RequestType requestType) {
        if (c1767f == null) {
            return false;
        }
        try {
            Request parseFrom = Request.parseFrom(c1767f.m8589d());
            if (parseFrom.getRequestCount() == 1 && parseFrom.getRequest(0).getRequestType() == requestType) {
                return true;
            }
            return false;
        } catch (Throwable e) {
            C2134e.m10681d("TT-RequestQ", "Could not parse protocol buffer", e);
            return false;
        }
    }
}
