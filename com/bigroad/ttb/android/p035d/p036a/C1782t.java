package com.bigroad.ttb.android.p035d.p036a;

import android.database.Cursor;
import com.bigroad.ttb.android.OurApplication;
import com.bigroad.ttb.android.SyncManager;
import com.bigroad.ttb.android.logging.C2134e;
import com.bigroad.ttb.android.logging.C2136g;
import com.bigroad.ttb.android.logging.C2138i;
import com.bigroad.ttb.protocol.TTProtocol.RemoteLogEvent;
import com.bigroad.ttb.protocol.TTProtocol.RemoteLogEvent.C2732a;
import com.bigroad.ttb.protocol.TTProtocol.RemoteLogEventRequest;
import com.bigroad.ttb.protocol.TTProtocol.RemoteLogEventRequest.C2734a;
import com.bigroad.ttb.protocol.TTProtocol.Request;
import com.bigroad.ttb.protocol.TTProtocol.RequestType;
import com.bigroad.ttb.protocol.TTProtocol.RequestUnion;
import com.facebook.share.internal.ShareConstants;
import java.util.ArrayList;
import java.util.List;

public class C1782t extends C1762b {
    public C1782t(Cursor cursor) {
        m8558e(cursor, ShareConstants.WEB_DIALOG_PARAM_DATA);
    }

    public C1782t(byte[] bArr) {
        this.a.put(ShareConstants.WEB_DIALOG_PARAM_DATA, bArr);
    }

    public C1782t(Request request) {
        this(request.toByteArray());
    }

    public C1782t(List<C2136g> list) {
        this(C1782t.m8640a(list));
    }

    public String mo1062a() {
        return "stored_remote_log_requests";
    }

    public byte[] m8643b() {
        return this.a.getAsByteArray(ShareConstants.WEB_DIALOG_PARAM_DATA);
    }

    private Request m8641e() {
        try {
            return Request.parseFrom(m8643b());
        } catch (Throwable e) {
            C2134e.m10681d("TT-StoredRLR", "Error parsing stored remote log", e);
            return null;
        }
    }

    public List<C2136g> m8644d() {
        Request e = m8641e();
        if (e == null) {
            return null;
        }
        List<C2136g> arrayList = new ArrayList();
        for (RequestUnion requestUnion : e.getRequestList()) {
            if (requestUnion.hasRemoteLogEvent()) {
                for (RemoteLogEvent remoteLogEvent : requestUnion.getRemoteLogEvent().getLogEventList()) {
                    arrayList.add(new C2136g(C2138i.m10689a(remoteLogEvent.getPriority()), remoteLogEvent.getOccurredAt(), remoteLogEvent.getTag(), remoteLogEvent.getMessage()));
                }
            }
        }
        return arrayList;
    }

    private static Request m8640a(List<C2136g> list) {
        C2734a newBuilder = RemoteLogEventRequest.newBuilder();
        C2732a newBuilder2 = RemoteLogEvent.newBuilder();
        for (C2136g c2136g : list) {
            newBuilder2.m14821a().m14822a(c2136g.m10685c()).m14824a(C2138i.m10693b(c2136g.m10683a()).m4101b()).m14826a(c2136g.m10686d()).m14828b(c2136g.m10687e());
            newBuilder.m14849a(newBuilder2.m14830c());
        }
        OurApplication.m6289k();
        return SyncManager.m6378a(RequestType.REMOTE_LOG_EVENT, RequestUnion.newBuilder().m14997a(newBuilder));
    }
}
