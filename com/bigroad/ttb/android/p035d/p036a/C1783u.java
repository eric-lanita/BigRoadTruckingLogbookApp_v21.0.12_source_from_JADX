package com.bigroad.ttb.android.p035d.p036a;

import android.database.Cursor;
import com.bigroad.ttb.android.SyncManager;
import com.bigroad.ttb.android.logging.C2134e;
import com.bigroad.ttb.protocol.TTProtocol.CreateEventRequest;
import com.bigroad.ttb.protocol.TTProtocol.Event;
import com.bigroad.ttb.protocol.TTProtocol.Request;
import com.bigroad.ttb.protocol.TTProtocol.RequestType;
import com.bigroad.ttb.protocol.TTProtocol.RequestUnion;
import com.facebook.share.internal.ShareConstants;
import com.google.android.gms.tagmanager.DataLayer;

public class C1783u extends C1762b {
    public C1783u(Cursor cursor) {
        m8558e(cursor, DataLayer.EVENT_KEY);
        m8558e(cursor, ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID);
    }

    public C1783u(byte[] bArr, byte[] bArr2) {
        this.a.put(DataLayer.EVENT_KEY, bArr);
        this.a.put(ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID, bArr2);
    }

    public C1783u(Event event, Request request) {
        this(event.toByteArray(), request.toByteArray());
    }

    public static C1783u m8645a(Event event) {
        return new C1783u(event, SyncManager.m6378a(RequestType.CREATE_EVENT, RequestUnion.newBuilder().m14967a(CreateEventRequest.newBuilder().m12957a(event))));
    }

    public String mo1062a() {
        return "speculative_event";
    }

    public byte[] m8647b() {
        return this.a.getAsByteArray(DataLayer.EVENT_KEY);
    }

    public byte[] m8648d() {
        return this.a.getAsByteArray(ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID);
    }

    public Event m8649e() {
        try {
            return Event.parseFrom(m8647b());
        } catch (Throwable e) {
            C2134e.m10681d("TT-StoredEvent", "Error parsing stored event", e);
            return null;
        }
    }

    public Request m8650f() {
        try {
            return Request.parseFrom(m8648d());
        } catch (Throwable e) {
            C2134e.m10681d("TT-StoredEvent", "Error parsing stored request", e);
            return null;
        }
    }
}
