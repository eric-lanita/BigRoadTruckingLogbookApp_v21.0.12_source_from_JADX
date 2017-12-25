package com.bigroad.ttb.android.p035d;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import com.bigroad.shared.C1142r;
import com.bigroad.shared.C1142r.C1135c;
import com.bigroad.shared.C1144s;
import com.bigroad.shared.C1180y;
import com.bigroad.shared.EventStatusMaskBits;
import com.bigroad.shared.EventStatusMaskBits.RecordStatus;
import com.bigroad.shared.am;
import com.bigroad.ttb.android.OurApplication;
import com.bigroad.ttb.android.eobr.turbo.VarPage;
import com.bigroad.ttb.android.logging.C2134e;
import com.bigroad.ttb.android.logging.C2136g;
import com.bigroad.ttb.android.p035d.C1790a;
import com.bigroad.ttb.android.p035d.p036a.C1762b;
import com.bigroad.ttb.android.p035d.p036a.C1763a;
import com.bigroad.ttb.android.p035d.p036a.C1764c;
import com.bigroad.ttb.android.p035d.p036a.C1765d;
import com.bigroad.ttb.android.p035d.p036a.C1766e;
import com.bigroad.ttb.android.p035d.p036a.C1767f;
import com.bigroad.ttb.android.p035d.p036a.C1768g;
import com.bigroad.ttb.android.p035d.p036a.C1769h;
import com.bigroad.ttb.android.p035d.p036a.C1770i;
import com.bigroad.ttb.android.p035d.p036a.C1771j;
import com.bigroad.ttb.android.p035d.p036a.C1772k;
import com.bigroad.ttb.android.p035d.p036a.C1773l;
import com.bigroad.ttb.android.p035d.p036a.C1774m;
import com.bigroad.ttb.android.p035d.p036a.C1775n;
import com.bigroad.ttb.android.p035d.p036a.C1776o;
import com.bigroad.ttb.android.p035d.p036a.C1777p;
import com.bigroad.ttb.android.p035d.p036a.C1779q;
import com.bigroad.ttb.android.p035d.p036a.C1780r;
import com.bigroad.ttb.android.p035d.p036a.C1781s;
import com.bigroad.ttb.android.p035d.p036a.C1782t;
import com.bigroad.ttb.android.p035d.p036a.C1783u;
import com.bigroad.ttb.android.p035d.p036a.C1784v;
import com.bigroad.ttb.android.p035d.p036a.C1785w;
import com.bigroad.ttb.android.p035d.p036a.C1786x;
import com.bigroad.ttb.android.p035d.p036a.C1787y;
import com.bigroad.ttb.android.p035d.p036a.C1789z;
import com.bigroad.ttb.android.p035d.p036a.aa;
import com.bigroad.ttb.android.util.C2297q;
import com.bigroad.ttb.protocol.TTProtocol.Conversation;
import com.bigroad.ttb.protocol.TTProtocol.ConversationData;
import com.bigroad.ttb.protocol.TTProtocol.ConversationData.C2555a;
import com.bigroad.ttb.protocol.TTProtocol.ConversationParticipant;
import com.bigroad.ttb.protocol.TTProtocol.Correction;
import com.bigroad.ttb.protocol.TTProtocol.DailyLog;
import com.bigroad.ttb.protocol.TTProtocol.DashLinkFirmwareVersion;
import com.bigroad.ttb.protocol.TTProtocol.Dvir;
import com.bigroad.ttb.protocol.TTProtocol.Event;
import com.bigroad.ttb.protocol.TTProtocol.Fleet;
import com.bigroad.ttb.protocol.TTProtocol.Message;
import com.bigroad.ttb.protocol.TTProtocol.Person;
import com.bigroad.ttb.protocol.TTProtocol.PersonGroup;
import com.bigroad.ttb.protocol.TTProtocol.Request;
import com.bigroad.ttb.protocol.TTProtocol.Truck;
import com.bigroad.ttb.protocol.TTProtocol.TruckGap;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.share.internal.ShareConstants;
import com.google.common.primitives.C3607b;
import com.google.protobuf.C3642c;
import com.google.protobuf.InvalidProtocolBufferException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class C1790a {
    private static C1790a f6119a;
    private final C1135c f6120b = new C17531(this);
    private final SQLiteDatabase f6121c;

    class C17531 implements C1135c {
        final /* synthetic */ C1790a f6084a;

        C17531(C1790a c1790a) {
            this.f6084a = c1790a;
        }

        public boolean mo818a(Event event, List<byte[]> list) {
            this.f6084a.m8735a(event);
            return true;
        }

        public boolean mo817a(Event event) {
            this.f6084a.m8735a(event);
            return true;
        }

        public boolean mo819b(Event event) {
            this.f6084a.m8746a(event.getEventId().m19091d());
            return true;
        }
    }

    public static C1790a m8692a(Context context) {
        if (f6119a == null) {
            f6119a = new C1790a(context);
        }
        return f6119a;
    }

    private C1790a(Context context) {
        this.f6121c = new C1791b(context).getWritableDatabase();
    }

    private static String m8704h(byte[] bArr) {
        return "x'" + C1180y.m5990a(bArr) + "'";
    }

    private long m8687a(C1762b c1762b, int i) {
        long insertWithOnConflict = this.f6121c.insertWithOnConflict(c1762b.mo1062a(), null, c1762b.m8555c(), i);
        if (insertWithOnConflict < 0) {
            C2134e.m10682e("TT-Database", "Failed inserting row into " + c1762b.mo1062a());
        }
        return insertWithOnConflict;
    }

    private long m8686a(C1762b c1762b) {
        return m8687a(c1762b, 4);
    }

    private long m8697b(C1762b c1762b) {
        return m8687a(c1762b, 5);
    }

    private boolean m8705j(String str) {
        Cursor rawQuery = this.f6121c.rawQuery("SELECT 1 FROM " + str + " LIMIT 1", null);
        boolean moveToFirst = rawQuery.moveToFirst();
        rawQuery.close();
        return moveToFirst;
    }

    private C1767f m8691a(boolean z) {
        String str;
        C1767f c1767f = null;
        String str2 = ShareConstants.WEB_DIALOG_PARAM_ID;
        if (z) {
            str = str2 + " ASC";
        } else {
            str = str2 + " DESC";
        }
        Cursor query = this.f6121c.query("queued_request", null, null, null, null, null, str, AppEventsConstants.EVENT_PARAM_VALUE_YES);
        if (query.moveToFirst()) {
            c1767f = new C1767f(query);
        }
        query.close();
        return c1767f;
    }

    private void m8696a(Runnable runnable) {
        this.f6121c.beginTransaction();
        try {
            runnable.run();
            this.f6121c.setTransactionSuccessful();
        } finally {
            this.f6121c.endTransaction();
        }
    }

    private void m8701b(Runnable runnable) {
        if (this.f6121c.inTransaction()) {
            runnable.run();
        } else {
            m8696a(runnable);
        }
    }

    private ConversationData m8694a(ConversationData conversationData, ConversationData conversationData2) {
        if (conversationData2 == null) {
            return conversationData;
        }
        Conversation conversation = conversationData == null ? null : conversationData.getConversation();
        Conversation conversation2 = conversationData2.getConversation();
        C2555a newBuilder = ConversationData.newBuilder();
        if (conversation == null || conversation.getModifiedSeq() <= conversation2.getModifiedSeq()) {
            newBuilder.m12772a(conversation2);
        } else {
            newBuilder.m12772a(conversation);
        }
        if (conversationData != null) {
            newBuilder.mo1377a(conversationData.getParticipantList());
        }
        for (ConversationParticipant conversationParticipant : conversationData2.getParticipantList()) {
            Object obj;
            int i = 0;
            while (i < newBuilder.m12794l()) {
                ConversationParticipant a = newBuilder.m12778a(i);
                if (a.getPersonId() == conversationParticipant.getPersonId() && a.getFleetId() == conversationParticipant.getFleetId()) {
                    if (conversationParticipant.getDeliveredSeq() > a.getDeliveredSeq() || conversationParticipant.getReadSeq() > a.getReadSeq()) {
                        newBuilder.m12771a(i, conversationParticipant);
                    }
                    obj = 1;
                    if (obj == null) {
                        newBuilder.m12774a(conversationParticipant);
                    }
                } else {
                    i++;
                }
            }
            obj = null;
            if (obj == null) {
                newBuilder.m12774a(conversationParticipant);
            }
        }
        return newBuilder.m12784c();
    }

    public void m8741a(String str, String str2) {
        m8686a(new C1764c(str, str2));
    }

    public C1764c m8716a() {
        C1764c c1764c = null;
        Cursor query = this.f6121c.query("file_upload", null, null, null, null, null, ShareConstants.WEB_DIALOG_PARAM_ID, AppEventsConstants.EVENT_PARAM_VALUE_YES);
        if (query.moveToFirst()) {
            c1764c = new C1764c(query);
        }
        query.close();
        return c1764c;
    }

    public void m8739a(String str) {
        this.f6121c.delete("file_upload", "file_hash=?", new String[]{str});
    }

    public List<C1764c> m8751b() {
        List arrayList = new ArrayList();
        Cursor query = this.f6121c.query("file_upload", null, null, null, null, null, null);
        while (query.moveToNext()) {
            arrayList.add(new C1764c(query));
        }
        query.close();
        return arrayList;
    }

    public long m8715a(Request request) {
        return m8686a(new C1767f(request.toByteArray()));
    }

    public void m8725a(long j, Request request) {
        this.f6121c.execSQL("UPDATE queued_request SET request=? WHERE id=?", new Object[]{request.toByteArray(), Long.valueOf(j)});
    }

    public void m8726a(long j, boolean z) {
        this.f6121c.execSQL("UPDATE queued_request SET frozen=? WHERE id=?", new Object[]{Boolean.valueOf(z), Long.valueOf(j)});
    }

    public C1767f m8761c() {
        return m8691a(true);
    }

    public C1767f m8768d() {
        return m8691a(false);
    }

    public void m8724a(long j) {
        this.f6121c.execSQL("DELETE FROM queued_request WHERE id=?", new Object[]{Long.valueOf(j)});
    }

    public boolean m8776e() {
        return m8705j("queued_request");
    }

    public boolean m8782f() {
        return !m8705j("stored_person");
    }

    public Person m8750b(long j) {
        Person person = null;
        Cursor query = this.f6121c.query("stored_person", null, "id=?", new String[]{Long.toString(j)}, null, null, null);
        if (query.moveToFirst()) {
            person = new C1780r(query).m8636d();
        }
        query.close();
        return person;
    }

    public void m8784g() {
        this.f6121c.delete("stored_person", null, null);
    }

    public void m8744a(final List<Person> list) {
        m8701b(new Runnable(this) {
            final /* synthetic */ C1790a f6068b;

            public void run() {
                this.f6068b.m8784g();
                for (Person c1780r : list) {
                    this.f6068b.m8697b(new C1780r(c1780r));
                }
            }
        });
    }

    public List<Truck> m8787h() {
        List arrayList = new ArrayList(50);
        Cursor query = this.f6121c.query("stored_truck", null, null, null, null, null, null);
        while (query.moveToNext()) {
            Truck d = new C1784v(query).m8653d();
            if (d != null) {
                arrayList.add(d);
            }
        }
        query.close();
        return arrayList;
    }

    public void m8791i() {
        this.f6121c.delete("stored_truck", null, null);
    }

    public void m8743a(final Collection<Truck> collection) {
        m8701b(new Runnable(this) {
            final /* synthetic */ C1790a f6079b;

            public void run() {
                this.f6079b.m8791i();
                for (Truck c1784v : collection) {
                    this.f6079b.m8697b(new C1784v(c1784v));
                }
            }
        });
    }

    public List<TruckGap> m8793j() {
        List arrayList = new ArrayList(10);
        Cursor query = this.f6121c.query("stored_truck_gap", null, null, null, null, null, null);
        while (query.moveToNext()) {
            TruckGap d = new C1785w(query).m8656d();
            if (d != null) {
                arrayList.add(d);
            }
        }
        query.close();
        return arrayList;
    }

    public void m8795k() {
        this.f6121c.delete("stored_truck_gap", null, null);
    }

    public void m8757b(final Collection<TruckGap> collection) {
        m8701b(new Runnable(this) {
            final /* synthetic */ C1790a f6081b;

            public void run() {
                this.f6081b.m8795k();
                for (TruckGap c1785w : collection) {
                    this.f6081b.m8697b(new C1785w(c1785w));
                }
            }
        });
    }

    public List<C1769h> m8797l() {
        List arrayList = new ArrayList(50);
        Cursor query = this.f6121c.query("stored_conversation", null, null, null, null, null, null);
        while (query.moveToNext()) {
            arrayList.add(new C1769h(query));
        }
        query.close();
        return arrayList;
    }

    public C1769h m8762c(long j) {
        C1769h c1769h = null;
        Cursor query = this.f6121c.query("stored_conversation", null, "id=?", new String[]{Long.toString(j)}, null, null, null);
        if (query.moveToFirst()) {
            c1769h = new C1769h(query);
        }
        query.close();
        return c1769h;
    }

    public void m8799m() {
        this.f6121c.delete("stored_conversation", null, null);
    }

    public void m8732a(ConversationData conversationData) {
        final long conversationId = conversationData.getConversation().getConversationId();
        m8701b(new Runnable(this) {
            final /* synthetic */ C1790a f6083b;

            public void run() {
                this.f6083b.f6121c.delete("stored_conversation", "id=?", new String[]{String.valueOf(conversationId)});
                this.f6083b.m8780f(conversationId);
            }
        });
    }

    public void m8758b(final List<ConversationData> list) {
        if (!list.isEmpty()) {
            m8701b(new Runnable(this) {
                final /* synthetic */ C1790a f6086b;

                public void run() {
                    for (ConversationData b : list) {
                        this.f6086b.m8755b(b);
                    }
                }
            });
        }
    }

    public void m8755b(final ConversationData conversationData) {
        final long conversationId = conversationData.getConversation().getConversationId();
        m8701b(new Runnable(this) {
            final /* synthetic */ C1790a f6089c;

            public void run() {
                if (conversationData.getDeleted()) {
                    this.f6089c.m8732a(conversationData);
                    return;
                }
                ConversationData conversationData;
                this.f6089c.m8764c(conversationData.getMessageList());
                C1769h c = this.f6089c.m8762c(conversationId);
                if (c == null) {
                    conversationData = null;
                } else {
                    conversationData = c.m8600f();
                }
                conversationData = this.f6089c.m8694a(conversationData, conversationData);
                this.f6089c.m8697b(new C1769h(conversationId, conversationData.getConversation().getModifiedSeq(), conversationData.toByteArray()));
            }
        });
    }

    private List<C1779q> m8695a(Cursor cursor) {
        List arrayList = new ArrayList();
        while (cursor.moveToNext()) {
            arrayList.add(new C1779q(cursor));
        }
        cursor.close();
        return arrayList;
    }

    private Cursor m8689a(long j, long j2) {
        return this.f6121c.query("stored_message", null, "conversation_id=? AND message_seq>?", new String[]{Long.toString(j), Long.toString(j2)}, null, null, null);
    }

    public int m8767d(long j) {
        int i = 0;
        Cursor rawQuery = this.f6121c.rawQuery("SELECT COUNT(*) FROM stored_message WHERE conversation_id=?", new String[]{Long.toString(j)});
        if (rawQuery.moveToFirst()) {
            i = rawQuery.getInt(0);
        }
        rawQuery.close();
        return i;
    }

    public int m8714a(long j, long j2, long j3) {
        Cursor a = m8689a(j, j3);
        int i = 0;
        while (a.moveToNext()) {
            Message e = new C1779q(a).m8633e();
            if (!(e == null || e.getSenderPersonId() == j2)) {
                i++;
            }
        }
        a.close();
        return i;
    }

    public long m8749b(long j, long j2, long j3) {
        Cursor a = m8689a(j, j3);
        while (a.moveToNext()) {
            Message e = new C1779q(a).m8633e();
            if (!(e == null || e.getSenderPersonId() == j2)) {
                long messageSeq = e.getMessageSeq();
                if (messageSeq > j3) {
                    j3 = messageSeq;
                }
            }
        }
        a.close();
        return j3;
    }

    public List<C1779q> m8720a(long j, long j2, int i) {
        return m8695a(this.f6121c.query("stored_message", null, "conversation_id=? AND message_seq<?", new String[]{Long.toString(j), Long.toString(j2)}, null, null, "message_seq DESC", Integer.toString(i)));
    }

    public List<C1779q> m8719a(long j, int i) {
        return m8695a(this.f6121c.query("stored_message", null, "conversation_id=?", new String[]{Long.toString(j)}, null, null, "message_seq DESC", Integer.toString(i)));
    }

    public C1779q m8774e(long j) {
        List a = m8719a(j, 1);
        return a.isEmpty() ? null : (C1779q) a.get(0);
    }

    public void m8801n() {
        this.f6121c.delete("stored_message", null, null);
    }

    public void m8780f(long j) {
        this.f6121c.delete("stored_message", "conversation_id=?", new String[]{String.valueOf(j)});
    }

    public void m8764c(final List<Message> list) {
        if (!list.isEmpty()) {
            m8701b(new Runnable(this) {
                final /* synthetic */ C1790a f6091b;

                public void run() {
                    for (Message a : list) {
                        this.f6091b.m8737a(a);
                    }
                }
            });
        }
    }

    public void m8737a(Message message) {
        m8697b(new C1779q(message));
    }

    public List<C1774m> m8803o() {
        Cursor query = this.f6121c.query("stored_event", null, null, null, null, null, null);
        List arrayList = new ArrayList(16);
        while (query.moveToNext()) {
            arrayList.add(new C1774m(query));
        }
        query.close();
        return arrayList;
    }

    public void m8804p() {
        this.f6121c.delete("stored_event", null, null);
    }

    public void m8772d(final List<Event> list) {
        if (!list.isEmpty()) {
            m8701b(new Runnable(this) {
                final /* synthetic */ C1790a f6093b;

                public void run() {
                    for (Event a : list) {
                        this.f6093b.m8735a(a);
                    }
                }
            });
        }
    }

    public void m8735a(Event event) {
        if (C1144s.m5759a(event)) {
            m8697b(new C1774m(event));
        }
    }

    public void m8775e(final List<Event> list) {
        m8701b(new Runnable(this) {
            final /* synthetic */ C1790a f6095b;

            public void run() {
                this.f6095b.m8804p();
                this.f6095b.m8772d(list);
            }
        });
    }

    public void m8746a(byte[] bArr) {
        this.f6121c.execSQL("DELETE FROM stored_event WHERE id=?", new Object[]{bArr});
    }

    public void m8727a(final C1142r c1142r) {
        m8701b(new Runnable(this) {
            final /* synthetic */ C1790a f6097b;

            public void run() {
                c1142r.m5750a(this.f6097b.f6120b);
            }
        });
    }

    public List<C1783u> m8805q() {
        Cursor query = this.f6121c.query("speculative_event", null, null, null, null, null, null);
        List arrayList = new ArrayList(16);
        while (query.moveToNext()) {
            arrayList.add(new C1783u(query));
        }
        query.close();
        return arrayList;
    }

    public void m8731a(C1783u c1783u) {
        this.f6121c.execSQL("DELETE FROM speculative_event WHERE event=?", new Object[]{c1783u.m8647b()});
    }

    public void m8754b(C1783u c1783u) {
        m8697b((C1762b) c1783u);
    }

    public List<C1786x> m8752b(byte[] bArr) {
        Cursor rawQuery = this.f6121c.rawQuery("SELECT * FROM stored_unclaimed_event WHERE device_id=" + C1790a.m8704h(bArr), new String[0]);
        List arrayList = new ArrayList(16);
        while (rawQuery.moveToNext()) {
            arrayList.add(new C1786x(rawQuery));
        }
        rawQuery.close();
        return arrayList;
    }

    public boolean m8760b(Event event) {
        if (new C1786x(event).m8658b() == null) {
            C2134e.m10680d("TT-Database", "Unclaimed event missing device id: " + C2297q.m11245a(event));
            return false;
        }
        m8697b(new C1786x(event));
        return true;
    }

    public void m8747a(final byte[] bArr, final RecordStatus recordStatus) {
        m8701b(new Runnable(this) {
            final /* synthetic */ C1790a f6100c;

            public void run() {
                Cursor rawQuery = this.f6100c.f6121c.rawQuery("SELECT data FROM stored_unclaimed_event WHERE id=" + C1790a.m8704h(bArr), new String[0]);
                if (rawQuery.moveToNext()) {
                    try {
                        Event parseFrom = Event.parseFrom(rawQuery.getBlob(0));
                        this.f6100c.f6121c.execSQL("UPDATE stored_unclaimed_event SET data=" + C1790a.m8704h(Event.newBuilder(parseFrom).m13886j(EventStatusMaskBits.m4072a(parseFrom.getStatusMask(), recordStatus)).m13862c().toByteArray()) + " WHERE " + ShareConstants.WEB_DIALOG_PARAM_ID + "=" + C1790a.m8704h(bArr), new String[0]);
                    } catch (InvalidProtocolBufferException e) {
                        C2134e.m10682e("TT-Database", "Failed to parse StoredUnclaimedEvent into TTProtocol.Event");
                    }
                }
                rawQuery.close();
            }
        });
    }

    public void m8765c(byte[] bArr) {
        this.f6121c.execSQL("UPDATE stored_unclaimed_event SET is_ignored=? WHERE id=" + C1790a.m8704h(bArr), new Object[]{Boolean.valueOf(true)});
    }

    public List<C1763a> m8806r() {
        List arrayList = new ArrayList(16);
        Cursor query = this.f6121c.query("contact", null, null, null, null, null, null);
        while (query.moveToNext()) {
            arrayList.add(new C1763a(query));
        }
        query.close();
        return arrayList;
    }

    public void m8728a(C1763a c1763a) {
        m8697b((C1762b) c1763a);
    }

    private List<C1771j> m8700b(Cursor cursor) {
        List arrayList = new ArrayList(16);
        while (cursor.moveToNext()) {
            arrayList.add(new C1771j(cursor));
        }
        cursor.close();
        return arrayList;
    }

    public List<C1771j> m8807s() {
        return m8700b(this.f6121c.query("stored_daily_log", null, null, null, null, null, null));
    }

    public void m8808t() {
        this.f6121c.delete("stored_daily_log", null, null);
    }

    public void m8781f(final List<DailyLog> list) {
        if (!list.isEmpty()) {
            m8701b(new Runnable(this) {
                final /* synthetic */ C1790a f6102b;

                public void run() {
                    for (DailyLog a : list) {
                        this.f6102b.m8733a(a);
                    }
                }
            });
        }
    }

    public void m8733a(DailyLog dailyLog) {
        m8697b(new C1771j(dailyLog.getLogDay(), dailyLog.toByteArray()));
    }

    public void m8786g(final List<DailyLog> list) {
        m8701b(new Runnable(this) {
            final /* synthetic */ C1790a f6104b;

            public void run() {
                this.f6104b.m8808t();
                this.f6104b.m8781f(list);
            }
        });
    }

    public List<Dvir> m8809u() {
        List arrayList = new ArrayList(50);
        Cursor query = this.f6121c.query("stored_dvir", null, null, null, null, null, null);
        while (query.moveToNext()) {
            Dvir d = new C1773l(query).m8610d();
            if (d != null) {
                arrayList.add(d);
            }
        }
        query.close();
        return arrayList;
    }

    public void m8810v() {
        this.f6121c.delete("stored_dvir", null, null);
    }

    public void m8789h(final List<Dvir> list) {
        m8701b(new Runnable(this) {
            final /* synthetic */ C1790a f6106b;

            public void run() {
                this.f6106b.m8810v();
                for (Dvir a : list) {
                    this.f6106b.m8734a(a);
                }
            }
        });
    }

    public void m8738a(C3642c c3642c) {
        this.f6121c.execSQL("DELETE FROM stored_dvir WHERE id = ?", new Object[]{c3642c.m19091d()});
    }

    public void m8734a(Dvir dvir) {
        m8697b(new C1773l(dvir));
    }

    public List<C1789z> m8718a(int i, long j) {
        List arrayList = new ArrayList();
        Cursor query = this.f6121c.query("user_text_history", null, "text_type=? AND owning_person_id=?", new String[]{Integer.toString(i), Long.toString(j)}, null, null, null);
        while (query.moveToNext()) {
            arrayList.add(new C1789z(query));
        }
        query.close();
        return arrayList;
    }

    public void m8723a(int i, long j, String str) {
        String num = Integer.toString(i);
        String l = Long.toString(j);
        String l2 = Long.toString(OurApplication.m6269Z().mo913a());
        this.f6121c.execSQL("INSERT OR REPLACE INTO user_text_history (text_type, owning_person_id, text, use_count, last_used_at) VALUES (?, ?, ?, COALESCE((SELECT use_count FROM user_text_history WHERE text_type = ? AND owning_person_id = ? AND text = ?), 0) + 1, ?);", new String[]{num, l, str, num, l, str, l2});
    }

    public void m8753b(int i, long j, String str) {
        this.f6121c.execSQL("DELETE FROM user_text_history WHERE text_type = ? AND owning_person_id = ? AND text = ?", new Object[]{Long.valueOf((long) i), Long.valueOf(j), str});
    }

    public List<PersonGroup> m8811w() {
        List arrayList = new ArrayList(8);
        Cursor query = this.f6121c.query("stored_person_group", null, null, null, null, null, null);
        while (query.moveToNext()) {
            PersonGroup d = new C1781s(query).m8639d();
            if (d != null) {
                arrayList.add(d);
            }
        }
        query.close();
        return arrayList;
    }

    public boolean m8812x() {
        return !m8705j("stored_person_group");
    }

    public void m8813y() {
        this.f6121c.delete("stored_person_group", null, null);
    }

    public void m8792i(final List<PersonGroup> list) {
        m8701b(new Runnable(this) {
            final /* synthetic */ C1790a f6108b;

            public void run() {
                this.f6108b.m8813y();
                for (PersonGroup c1781s : list) {
                    this.f6108b.m8697b(new C1781s(c1781s));
                }
            }
        });
    }

    public void m8814z() {
        this.f6121c.delete("stored_auto_daily_log_truck", null, null);
    }

    public C1768g m8706A() {
        C1768g c1768g = null;
        Cursor query = this.f6121c.query("stored_auto_daily_log_truck", null, null, null, null, null, null, null);
        if (query.moveToNext()) {
            c1768g = new C1768g(query);
        }
        query.close();
        return c1768g;
    }

    public void m8763c(Collection<VarPage> collection) {
        if (!collection.isEmpty()) {
            int i;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("INSERT OR REPLACE INTO ");
            stringBuilder.append("stored_var_page");
            stringBuilder.append('(');
            int length = C1787y.f6117b.length;
            for (i = 0; i < length; i++) {
                if (i > 0) {
                    stringBuilder.append(",");
                }
                stringBuilder.append(C1787y.f6117b[i]);
            }
            stringBuilder.append(')');
            stringBuilder.append(" VALUES (");
            i = 0;
            while (i < length) {
                stringBuilder.append(i > 0 ? ",?" : "?");
                i++;
            }
            stringBuilder.append(')');
            this.f6121c.beginTransaction();
            SQLiteStatement compileStatement = this.f6121c.compileStatement(stringBuilder.toString());
            try {
                for (VarPage a : collection) {
                    C1787y.m8664a(compileStatement, a);
                    compileStatement.executeInsert();
                    compileStatement.clearBindings();
                }
                this.f6121c.setTransactionSuccessful();
                this.f6121c.endTransaction();
            } finally {
                compileStatement.close();
            }
        }
    }

    public VarPage m8717a(byte[] bArr, long j) {
        C1787y c1787y;
        Cursor rawQuery = this.f6121c.rawQuery("SELECT * FROM stored_var_page WHERE dash_link_id=" + C1790a.m8704h(bArr) + " AND page_number = ?", new String[]{Long.toString(j)});
        if (rawQuery.moveToNext()) {
            c1787y = new C1787y(rawQuery);
        } else {
            c1787y = null;
        }
        rawQuery.close();
        if (c1787y != null) {
            return c1787y.m8680p();
        }
        return null;
    }

    public void m8748a(byte[] bArr, List<Long> list) {
        if (!list.isEmpty()) {
            String a = am.m4186a(",", (Iterable) list);
            this.f6121c.execSQL("UPDATE stored_var_page SET was_synced = ? WHERE dash_link_id = " + C1790a.m8704h(bArr) + " AND page_number IN (" + a + ")", new Object[]{Boolean.valueOf(true)});
        }
    }

    public List<VarPage> m8722a(byte[] bArr, long j, int i) {
        Cursor rawQuery = this.f6121c.rawQuery("SELECT * FROM stored_var_page WHERE dash_link_id=" + C1790a.m8704h(bArr) + " AND page_number >= ? AND NOT was_synced ORDER BY page_number ASC LIMIT " + Integer.toString(i), new String[]{Long.toString(j)});
        List<VarPage> arrayList = new ArrayList(i);
        while (rawQuery.moveToNext()) {
            VarPage p = new C1787y(rawQuery).m8680p();
            if (p != null) {
                arrayList.add(p);
            }
        }
        rawQuery.close();
        return arrayList;
    }

    public Long m8770d(byte[] bArr) {
        Long valueOf;
        Cursor rawQuery = this.f6121c.rawQuery("SELECT MIN(page_number) FROM stored_var_page WHERE dash_link_id=" + C1790a.m8704h(bArr), new String[0]);
        if (rawQuery.moveToFirst()) {
            valueOf = Long.valueOf(rawQuery.getLong(0));
        } else {
            valueOf = null;
        }
        rawQuery.close();
        return valueOf;
    }

    public void m8729a(aa aaVar) {
        m8697b((C1762b) aaVar);
    }

    public aa m8773e(byte[] bArr) {
        aa aaVar;
        Cursor query = this.f6121c.query("var_sync_progress", null, "dash_link_id=" + C1790a.m8704h(bArr), new String[0], null, null, null);
        if (query.moveToNext()) {
            aaVar = new aa(query);
        } else {
            aaVar = null;
        }
        query.close();
        if (aaVar == null) {
            return new aa(bArr, null, null);
        }
        return aaVar;
    }

    public List<aa> m8707B() {
        Cursor rawQuery = this.f6121c.rawQuery("SELECT * FROM var_sync_progress WHERE server_min_expected_var_page_number IS NULL OR (highest_fetched_page_number IS NOT NULL AND server_min_expected_var_page_number <= highest_fetched_page_number)", new String[0]);
        List<aa> arrayList = new ArrayList();
        while (rawQuery.moveToNext()) {
            arrayList.add(new aa(rawQuery));
        }
        rawQuery.close();
        return arrayList;
    }

    public void m8745a(final Map<String, Long> map) {
        m8701b(new Runnable(this) {
            final /* synthetic */ C1790a f6110b;

            public void run() {
                for (Entry entry : map.entrySet()) {
                    this.f6110b.m8740a((String) entry.getKey(), (Long) entry.getValue());
                }
            }
        });
    }

    public void m8756b(String str) {
        this.f6121c.execSQL("DELETE FROM stored_key_values WHERE key=?", new Object[]{str});
    }

    public byte[] m8766c(String str) {
        C1777p c1777p;
        Cursor query = this.f6121c.query("stored_key_values", null, "key=?", new String[]{str}, null, null, null);
        if (query.moveToNext()) {
            c1777p = new C1777p(query);
        } else {
            c1777p = null;
        }
        query.close();
        if (c1777p != null) {
            return c1777p.m8628b();
        }
        return null;
    }

    public Long m8769d(String str) {
        byte[] c = m8766c(str);
        if (c == null || c.length != 8) {
            return null;
        }
        return Long.valueOf(C3607b.m18843a(c));
    }

    public void m8740a(String str, Long l) {
        m8697b(new C1777p(str, l != null ? C3607b.m18846a(l.longValue()) : null));
    }

    private List<C1775n> m8702c(Cursor cursor) {
        List arrayList = new ArrayList(2);
        while (cursor.moveToNext()) {
            arrayList.add(new C1775n(cursor));
        }
        cursor.close();
        return arrayList;
    }

    public List<C1775n> m8708C() {
        return m8702c(this.f6121c.query("stored_fleet", null, null, null, null, null, null));
    }

    public void m8709D() {
        this.f6121c.delete("stored_fleet", null, null);
    }

    public void m8794j(final List<Fleet> list) {
        if (!list.isEmpty()) {
            m8701b(new Runnable(this) {
                final /* synthetic */ C1790a f6064b;

                public void run() {
                    for (Fleet a : list) {
                        this.f6064b.m8736a(a);
                    }
                }
            });
        }
    }

    public void m8736a(Fleet fleet) {
        m8697b(new C1775n(fleet.getFleetId(), fleet.toByteArray()));
    }

    public void m8796k(final List<Fleet> list) {
        m8701b(new Runnable(this) {
            final /* synthetic */ C1790a f6066b;

            public void run() {
                this.f6066b.m8709D();
                this.f6066b.m8794j(list);
            }
        });
    }

    public void m8759b(byte[] bArr, long j) {
        m8697b(new C1765d(bArr, j));
    }

    public Long m8778f(byte[] bArr) {
        Long valueOf;
        Cursor rawQuery = this.f6121c.rawQuery("SELECT time FROM firmware_upload_time WHERE dash_link_id=" + C1790a.m8704h(bArr), new String[0]);
        if (rawQuery.moveToFirst()) {
            valueOf = Long.valueOf(rawQuery.getLong(0));
        } else {
            valueOf = null;
        }
        rawQuery.close();
        return valueOf;
    }

    public void m8798l(final List<DashLinkFirmwareVersion> list) {
        m8701b(new Runnable(this) {
            final /* synthetic */ C1790a f6070b;

            public void run() {
                this.f6070b.f6121c.execSQL("DELETE FROM stored_dash_link_firmware_version");
                if (list != null && !list.isEmpty()) {
                    for (DashLinkFirmwareVersion c1772k : list) {
                        this.f6070b.m8697b(new C1772k(c1772k));
                    }
                }
            }
        });
    }

    public boolean m8777e(String str) {
        boolean z;
        Cursor rawQuery = this.f6121c.rawQuery("SELECT 1 FROM stored_dash_link_firmware_version WHERE version_number = ? AND is_valid = 0", new String[]{str});
        if (rawQuery.getCount() > 0) {
            z = true;
        } else {
            z = false;
        }
        rawQuery.close();
        if (z) {
            return false;
        }
        return true;
    }

    public List<List<C2136g>> m8710E() {
        List<List<C2136g>> arrayList = new ArrayList();
        Cursor query = this.f6121c.query("stored_remote_log_requests", null, null, null, null, null, "request_seq");
        while (query.moveToNext()) {
            List d = new C1782t(query).m8644d();
            if (d != null) {
                arrayList.add(d);
            }
        }
        query.close();
        return arrayList;
    }

    public void m8711F() {
        this.f6121c.delete("stored_remote_log_requests", null, null);
    }

    public void m8800m(final List<C2136g> list) {
        m8701b(new Runnable(this) {
            final /* synthetic */ C1790a f6072b;

            public void run() {
                this.f6072b.m8686a(new C1782t(list));
            }
        });
    }

    public List<Correction> m8712G() {
        List arrayList = new ArrayList(14);
        Cursor query = this.f6121c.query("stored_correction", null, null, null, null, null, null);
        while (query.moveToNext()) {
            Correction d = new C1770i(query).m8603d();
            if (d != null) {
                arrayList.add(d);
            }
        }
        query.close();
        return arrayList;
    }

    public void m8713H() {
        this.f6121c.delete("stored_correction", null, null);
    }

    public void m8785g(long j) {
        this.f6121c.execSQL("DELETE FROM stored_correction WHERE id=?", new Object[]{Long.valueOf(j)});
    }

    public void m8802n(final List<Correction> list) {
        m8701b(new Runnable(this) {
            final /* synthetic */ C1790a f6074b;

            public void run() {
                this.f6074b.m8713H();
                for (Correction c1770i : list) {
                    this.f6074b.m8697b(new C1770i(c1770i));
                }
            }
        });
    }

    public List<C1776o> m8779f(String str) {
        List<C1776o> arrayList = new ArrayList();
        Cursor query = this.f6121c.query("stored_mgs_entry", null, "mgs_serial_number = ? AND NOT was_synced", new String[]{str}, null, null, null);
        while (query.moveToNext()) {
            arrayList.add(new C1776o(query));
        }
        query.close();
        return arrayList;
    }

    public C1776o m8783g(String str) {
        C1776o c1776o = null;
        Cursor query = this.f6121c.query("stored_mgs_entry", null, "mgs_serial_number = ?", new String[]{str}, null, null, "entry_id desc");
        if (query.moveToNext()) {
            c1776o = new C1776o(query);
        }
        query.close();
        return c1776o;
    }

    public List<C1776o> m8721a(String str, long j, long j2) {
        List<C1776o> arrayList = new ArrayList();
        Cursor rawQuery = this.f6121c.rawQuery("SELECT * FROM stored_mgs_entry WHERE mgs_serial_number = ?  AND entry_id >= ?  AND entry_id <= ?", new String[]{str, Long.toString(j), Long.toString(j2)});
        while (rawQuery.moveToNext()) {
            arrayList.add(new C1776o(rawQuery));
        }
        rawQuery.close();
        return arrayList;
    }

    public void m8788h(String str) {
        this.f6121c.delete("stored_mgs_entry", "mgs_serial_number=?", new String[]{str});
    }

    public void m8742a(final String str, final List<Long> list) {
        m8701b(new Runnable(this) {
            final /* synthetic */ C1790a f6077c;

            public void run() {
                for (Long l : list) {
                    this.f6077c.f6121c.execSQL("UPDATE stored_mgs_entry SET was_synced=? WHERE mgs_serial_number=? AND entry_id=?", new Object[]{Boolean.valueOf(true), str, l});
                }
            }
        });
    }

    public void m8771d(Collection<C1776o> collection) {
        int i = 0;
        if (!collection.isEmpty()) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("INSERT OR REPLACE INTO ");
            stringBuilder.append("stored_mgs_entry");
            stringBuilder.append(" (");
            int length = C1776o.f6114b.length;
            for (int i2 = 0; i2 < length; i2++) {
                if (i2 != 0) {
                    stringBuilder.append(", ");
                }
                stringBuilder.append(C1776o.f6114b[i2]);
            }
            stringBuilder.append(") VALUES (");
            while (i < length) {
                if (i != 0) {
                    stringBuilder.append(", ");
                }
                stringBuilder.append("?");
                i++;
            }
            stringBuilder.append(")");
            this.f6121c.beginTransaction();
            SQLiteStatement compileStatement = this.f6121c.compileStatement(stringBuilder.toString());
            try {
                for (C1776o a : collection) {
                    C1776o.m8617a(compileStatement, a);
                    compileStatement.executeInsert();
                    compileStatement.clearBindings();
                }
                this.f6121c.setTransactionSuccessful();
                this.f6121c.endTransaction();
            } finally {
                compileStatement.close();
            }
        }
    }

    public void m8730a(C1766e c1766e) {
        m8697b((C1762b) c1766e);
    }

    public C1766e m8790i(String str) {
        C1766e c1766e;
        Cursor query = this.f6121c.query("mgs_sync_progress", null, "associated_serial_number= ?", new String[]{str}, null, null, null);
        if (query.moveToNext()) {
            c1766e = new C1766e(query);
        } else {
            c1766e = null;
        }
        query.close();
        if (c1766e == null) {
            return new C1766e(str, null);
        }
        return c1766e;
    }
}
