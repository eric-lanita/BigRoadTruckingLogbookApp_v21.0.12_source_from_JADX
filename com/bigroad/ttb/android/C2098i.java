package com.bigroad.ttb.android;

import android.content.Context;
import com.bigroad.shared.aj;
import com.bigroad.ttb.android.AuthMonitor.AuthStatus;
import com.bigroad.ttb.android.AuthMonitor.C1185a;
import com.bigroad.ttb.android.C2474y.C1182a;
import com.bigroad.ttb.android.C2474y.C1183b;
import com.bigroad.ttb.android.logging.C2134e;
import com.bigroad.ttb.android.p035d.C1790a;
import com.bigroad.ttb.android.p035d.p036a.C1769h;
import com.bigroad.ttb.android.p035d.p036a.C1779q;
import com.bigroad.ttb.android.util.C2285f;
import com.bigroad.ttb.protocol.TTProtocol.ConversationData;
import com.bigroad.ttb.protocol.TTProtocol.ConversationParticipant;
import com.bigroad.ttb.protocol.TTProtocol.Message;
import com.bigroad.ttb.protocol.TTProtocol.Message.C2703a;
import com.google.protobuf.C3642c;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class C2098i {
    private static C2098i f7321a;
    private final C2474y f7322b = OurApplication.m6285g();
    private final AuthMonitor f7323c = OurApplication.m6249F();
    private final C1790a f7324d = OurApplication.m6287i();
    private final SyncManager f7325e = OurApplication.m6289k();
    private final Set<C1320a> f7326f = new HashSet();
    private final Map<Long, Integer> f7327g = new HashMap();
    private int f7328h = 0;
    private final C1182a f7329i = new C20961(this);
    private final C1185a f7330j = new C20972(this);

    public interface C1320a {
        void mo952a(C2098i c2098i, long[] jArr);
    }

    class C20961 extends C1183b {
        final /* synthetic */ C2098i f7319a;

        C20961(C2098i c2098i) {
            this.f7319a = c2098i;
        }

        public void mo866c(C2474y c2474y) {
            this.f7319a.m10506c();
        }
    }

    class C20972 implements C1185a {
        final /* synthetic */ C2098i f7320a;

        C20972(C2098i c2098i) {
            this.f7320a = c2098i;
        }

        public void mo912a(AuthStatus authStatus) {
            if (authStatus == AuthStatus.SIGNED_OUT) {
                this.f7320a.m10506c();
            }
        }
    }

    public static C2098i m10497a(Context context) {
        if (f7321a == null) {
            f7321a = new C2098i();
        }
        return f7321a;
    }

    private C2098i() {
        this.f7322b.m12184a(this.f7329i);
        this.f7323c.m6027a(this.f7330j);
        m10501b();
    }

    private void m10501b() {
        List<C1769h> l = this.f7324d.m8797l();
        this.f7328h = 0;
        this.f7327g.clear();
        for (C1769h c1769h : l) {
            long b = c1769h.m8597b();
            int a = C2285f.m11201a(c1769h);
            this.f7327g.put(Long.valueOf(b), Integer.valueOf(a));
            this.f7328h = a + this.f7328h;
        }
    }

    private void m10500a(long[] jArr) {
        for (long j : jArr) {
            Integer num;
            int i;
            C1769h c = this.f7324d.m8762c(j);
            if (c == null) {
                num = (Integer) this.f7327g.remove(Long.valueOf(j));
                i = 0;
            } else {
                i = C2285f.m11201a(c);
                num = (Integer) this.f7327g.put(Long.valueOf(j), Integer.valueOf(i));
            }
            this.f7328h = i + this.f7328h;
            if (num != null) {
                this.f7328h -= num.intValue();
            }
        }
    }

    public void m10511a(C1320a c1320a) {
        this.f7326f.add(c1320a);
    }

    public void m10514b(C1320a c1320a) {
        this.f7326f.remove(c1320a);
    }

    private void m10505b(long[] jArr) {
        m10500a(jArr);
        for (C1320a a : (C1320a[]) this.f7326f.toArray(new C1320a[this.f7326f.size()])) {
            a.mo952a(this, jArr);
        }
    }

    private void m10502b(long j) {
        m10505b(new long[]{j});
    }

    private void m10503b(ConversationData conversationData) {
        m10502b(conversationData.getConversation().getConversationId());
    }

    private void m10499a(Collection<ConversationData> collection) {
        long[] jArr = new long[collection.size()];
        int i = 0;
        for (ConversationData conversation : collection) {
            int i2 = i + 1;
            jArr[i] = conversation.getConversation().getConversationId();
            i = i2;
        }
        Arrays.sort(jArr);
        m10505b(jArr);
    }

    private void m10504b(Collection<C1769h> collection) {
        long[] jArr = new long[collection.size()];
        int i = 0;
        for (C1769h b : collection) {
            int i2 = i + 1;
            jArr[i] = b.m8597b();
            i = i2;
        }
        Arrays.sort(jArr);
        m10505b(jArr);
    }

    public void m10512a(ConversationData conversationData) {
        this.f7324d.m8755b(conversationData);
        m10503b(conversationData);
    }

    public void m10513a(List<ConversationData> list) {
        if (!list.isEmpty()) {
            this.f7324d.m8758b((List) list);
            m10499a((Collection) list);
        }
    }

    public void m10510a(long j, String str) {
        long j2 = 0;
        long d = this.f7322b.m12202d();
        long g = this.f7322b.m12213g();
        if (g < 0) {
            C2134e.m10682e("TT-ConvManager", "Can't send message without a fleet");
            return;
        }
        C2703a a = Message.newBuilder().m14504a(C3642c.m19078a(aj.m4179a())).m14502a(j).m14508b(d).m14510c(g).m14515e(OurApplication.m6269Z().mo913a()).m14506a(str);
        Message c = a.m14511c();
        C1779q e = this.f7324d.m8774e(j);
        if (e != null) {
            j2 = e.m8631b() + 1;
        }
        a.m14513d(j2);
        this.f7324d.m8737a(a.m14511c());
        m10502b(j);
        this.f7325e.m6472a(c);
    }

    public void m10509a(long j, long j2) {
        C2134e.m10676b("TT-ConvManager", "Marking seq=" + j2 + " in conversationId=" + j + " as read");
        C1769h c = this.f7324d.m8762c(j);
        if (c != null) {
            ConversationData f = c.m8600f();
            ConversationParticipant a = C2285f.m11203a(f);
            if (a != null) {
                this.f7324d.m8755b(ConversationData.newBuilder().m12772a(f.getConversation()).m12774a(ConversationParticipant.newBuilder(a).m12811d(j2).m12809c()).m12784c());
                m10502b(j);
            }
        }
        this.f7325e.m6455a(j, j2);
    }

    private void m10506c() {
        Collection l = this.f7324d.m8797l();
        this.f7324d.m8801n();
        this.f7324d.m8799m();
        m10504b(l);
    }

    public int m10507a() {
        return this.f7328h;
    }

    public int m10508a(long j) {
        Integer num = (Integer) this.f7327g.get(Long.valueOf(j));
        return num == null ? 0 : num.intValue();
    }
}
