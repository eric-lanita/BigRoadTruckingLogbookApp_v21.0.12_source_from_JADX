package com.bigroad.ttb.android.p035d.p036a;

import android.database.Cursor;
import com.bigroad.ttb.android.logging.C2134e;
import com.bigroad.ttb.protocol.TTProtocol.Message;
import com.facebook.share.internal.ShareConstants;
import java.util.Collections;
import java.util.Comparator;

public class C1779q extends C1762b {
    public static final Comparator<C1779q> f6115b = new C17781();
    public static final Comparator<C1779q> f6116c = Collections.reverseOrder(f6115b);

    static class C17781 implements Comparator<C1779q> {
        C17781() {
        }

        public /* synthetic */ int compare(Object obj, Object obj2) {
            return m8629a((C1779q) obj, (C1779q) obj2);
        }

        public int m8629a(C1779q c1779q, C1779q c1779q2) {
            return Long.signum(c1779q.m8631b() - c1779q2.m8631b());
        }
    }

    public C1779q(Cursor cursor) {
        m8558e(cursor, ShareConstants.WEB_DIALOG_PARAM_ID);
        m8556c(cursor, "conversation_id");
        m8556c(cursor, "message_seq");
        m8558e(cursor, ShareConstants.WEB_DIALOG_PARAM_DATA);
    }

    public C1779q(byte[] bArr, long j, long j2, byte[] bArr2) {
        this.a.put(ShareConstants.WEB_DIALOG_PARAM_ID, bArr);
        this.a.put("conversation_id", Long.valueOf(j));
        this.a.put("message_seq", Long.valueOf(j2));
        this.a.put(ShareConstants.WEB_DIALOG_PARAM_DATA, bArr2);
    }

    public C1779q(Message message) {
        this(message.getMessageId().m19091d(), message.getConversationId(), message.getMessageSeq(), message.toByteArray());
    }

    public String mo1062a() {
        return "stored_message";
    }

    public long m8631b() {
        return this.a.getAsLong("message_seq").longValue();
    }

    public byte[] m8632d() {
        return this.a.getAsByteArray(ShareConstants.WEB_DIALOG_PARAM_DATA);
    }

    public Message m8633e() {
        try {
            return Message.parseFrom(m8632d());
        } catch (Throwable e) {
            C2134e.m10681d("TT-StoredMsg", "Error parsing stored message", e);
            return null;
        }
    }
}
