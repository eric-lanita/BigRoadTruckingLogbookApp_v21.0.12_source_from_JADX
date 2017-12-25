package com.bigroad.ttb.android.util;

import com.bigroad.shared.C1069g;
import com.bigroad.shared.C1069g.C1066a;
import com.bigroad.shared.C1069g.C1067b;
import com.bigroad.shared.ah;
import com.bigroad.ttb.android.C2474y;
import com.bigroad.ttb.android.OurApplication;
import com.bigroad.ttb.android.p035d.C1790a;
import com.bigroad.ttb.android.p035d.p036a.C1769h;
import com.bigroad.ttb.protocol.TTProtocol.ConversationData;
import com.bigroad.ttb.protocol.TTProtocol.ConversationParticipant;
import com.bigroad.ttb.protocol.TTProtocol.PersonGroup;
import com.bigroad.ttb.protocol.TTProtocol.ct;
import com.facebook.internal.AnalyticsEvents;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public abstract class C2285f {
    public static C1069g m11202a() {
        C2474y g = OurApplication.m6285g();
        final C1790a i = OurApplication.m6287i();
        return new C1069g(new C1066a() {
            public List<C1067b> mo1272a(long j) {
                return C2285f.m11209c();
            }

            public void mo1273a(Map<Long, String> map) {
                C2285f.m11207b(i, map);
            }
        }, g.m12213g(), g.m12202d());
    }

    private static List<C1067b> m11209c() {
        List<PersonGroup> b = OurApplication.m6257N().m11029b();
        List<C1067b> arrayList = new ArrayList(b.size());
        for (PersonGroup personGroup : b) {
            arrayList.add(new C1067b(personGroup.getGroupId(), personGroup.getName(), new HashSet(personGroup.getMemberIdList())));
        }
        return arrayList;
    }

    private static void m11207b(C1790a c1790a, Map<Long, String> map) {
        for (Long l : map.keySet()) {
            ct b = c1790a.m8750b(l.longValue());
            if (b == null) {
                map.put(l, AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN);
            } else {
                map.put(l, ah.m4160a(b));
            }
        }
    }

    public static ConversationParticipant m11203a(ConversationData conversationData) {
        C2474y g = OurApplication.m6285g();
        long d = g.m12202d();
        long g2 = g.m12213g();
        for (ConversationParticipant conversationParticipant : conversationData.getParticipantList()) {
            if (conversationParticipant.getPersonId() == d && (g2 < 0 || conversationParticipant.getFleetId() == g2)) {
                return conversationParticipant;
            }
        }
        return null;
    }

    public static ConversationParticipant m11205b(ConversationData conversationData) {
        C2474y g = OurApplication.m6285g();
        long d = g.m12202d();
        long g2 = g.m12213g();
        for (ConversationParticipant conversationParticipant : conversationData.getParticipantList()) {
            if (conversationParticipant.getPersonId() != d) {
                return conversationParticipant;
            }
            if (g2 >= 0 && conversationParticipant.getFleetId() != g2) {
                return conversationParticipant;
            }
        }
        return null;
    }

    public static int m11208c(ConversationData conversationData) {
        if (conversationData == null) {
            return 0;
        }
        ConversationParticipant a = C2285f.m11203a(conversationData);
        if (a == null) {
            return 0;
        }
        return OurApplication.m6287i().m8714a(conversationData.getConversation().getConversationId(), a.getPersonId(), a.getReadSeq());
    }

    public static int m11201a(C1769h c1769h) {
        if (c1769h == null) {
            return 0;
        }
        return C2285f.m11208c(c1769h.m8600f());
    }
}
