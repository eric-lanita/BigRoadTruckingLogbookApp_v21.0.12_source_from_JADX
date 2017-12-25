package com.bigroad.shared;

import com.bigroad.ttb.protocol.TTProtocol.ConversationData;
import com.bigroad.ttb.protocol.TTProtocol.ConversationParticipant;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class C1069g {
    private static final Comparator<C1067b> f3488a = new C10651();
    private final C1066a f3489b;
    private final List<C1067b> f3490c;
    private final long f3491d;

    static class C10651 implements Comparator<C1067b> {
        C10651() {
        }

        public /* synthetic */ int compare(Object obj, Object obj2) {
            return m5309a((C1067b) obj, (C1067b) obj2);
        }

        public int m5309a(C1067b c1067b, C1067b c1067b2) {
            return Integer.signum(c1067b2.m5316c() - c1067b.m5316c());
        }
    }

    public interface C1066a {
        List<C1067b> mo1272a(long j);

        void mo1273a(Map<Long, String> map);
    }

    public static class C1067b {
        private final long f3482a;
        private final String f3483b;
        private final Set<Long> f3484c;

        public C1067b(long j, String str, Set<Long> set) {
            this.f3482a = j;
            this.f3483b = str;
            this.f3484c = set;
        }

        public String m5312a() {
            return this.f3483b;
        }

        public Set<Long> m5315b() {
            return this.f3484c;
        }

        public int m5316c() {
            return this.f3484c.size();
        }

        public boolean m5314a(Map<Long, String> map) {
            if (this.f3484c.size() > map.size()) {
                return false;
            }
            return map.keySet().containsAll(this.f3484c);
        }

        public boolean m5313a(Long l) {
            return this.f3484c.contains(l);
        }
    }

    public static class C1068c {
        private final String f3485a;
        private final Set<Long> f3486b;
        private final List<C1067b> f3487c;

        public C1068c(String str, Set<Long> set, List<C1067b> list) {
            this.f3485a = str;
            this.f3486b = set;
            this.f3487c = list;
        }

        public String m5317a() {
            return this.f3485a;
        }
    }

    public C1069g(C1066a c1066a, long j, long j2) {
        this.f3489b = c1066a;
        this.f3490c = c1066a.mo1272a(j);
        Collections.sort(this.f3490c, f3488a);
        this.f3491d = j2;
    }

    private Long m5320b(List<Long> list) {
        for (Long l : list) {
            if (l.longValue() != this.f3491d) {
                return l;
            }
        }
        return null;
    }

    private static List<Long> m5321b(ConversationData conversationData) {
        List<ConversationParticipant> participantList = conversationData.getParticipantList();
        List<Long> arrayList = new ArrayList(participantList.size());
        for (ConversationParticipant personId : participantList) {
            arrayList.add(Long.valueOf(personId.getPersonId()));
        }
        return arrayList;
    }

    public String m5323a(ConversationData conversationData) {
        return m5322a(C1069g.m5321b(conversationData)).m5317a();
    }

    public C1068c m5322a(List<Long> list) {
        Map hashMap = new HashMap(list.size());
        if (list.size() == 2) {
            Long b = m5320b((List) list);
            hashMap.put(b, null);
            this.f3489b.mo1273a(hashMap);
            return new C1068c((String) hashMap.get(b), hashMap.keySet(), new ArrayList());
        }
        for (Long b2 : list) {
            hashMap.put(b2, null);
        }
        List linkedList = new LinkedList();
        for (C1067b c1067b : this.f3490c) {
            if (c1067b.m5316c() > 1 && c1067b.m5314a(hashMap)) {
                linkedList.add(c1067b);
            }
        }
        return m5318a(linkedList, hashMap);
    }

    private C1068c m5318a(List<C1067b> list, Map<Long, String> map) {
        Iterable arrayList = new ArrayList();
        List arrayList2 = new ArrayList();
        while (!list.isEmpty() && !map.isEmpty()) {
            C1067b c1067b = (C1067b) list.remove(0);
            Collection b = c1067b.m5315b();
            map.keySet().removeAll(b);
            C1069g.m5319a((List) list, b);
            arrayList.add(c1067b.m5312a());
            arrayList2.add(c1067b);
        }
        map.remove(Long.valueOf(this.f3491d));
        this.f3489b.mo1273a((Map) map);
        Collection arrayList3 = new ArrayList(map.values());
        Collections.sort(arrayList3);
        arrayList.addAll(arrayList3);
        return new C1068c(am.m4186a(", ", arrayList), map.keySet(), arrayList2);
    }

    private static void m5319a(List<C1067b> list, Collection<Long> collection) {
        for (Long l : collection) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                if (((C1067b) it.next()).m5313a(l)) {
                    it.remove();
                }
            }
        }
    }
}
