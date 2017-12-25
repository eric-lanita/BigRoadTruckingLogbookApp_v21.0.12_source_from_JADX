package com.urbanairship.actions;

import android.util.SparseArray;
import com.urbanairship.C3929q;
import com.urbanairship.actions.p054a.C3692a;
import com.urbanairship.actions.p054a.C3693c;
import com.urbanairship.util.C3954i;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class C3700d {
    private final Map<String, C3699a> f13337a = new HashMap();

    public interface C3695b {
        boolean mo2771a(C3694b c3694b);
    }

    class C36961 implements C3695b {
        final /* synthetic */ C3700d f13330a;

        C36961(C3700d c3700d) {
            this.f13330a = c3700d;
        }

        public boolean mo2771a(C3694b c3694b) {
            if (1 != c3694b.m19358b()) {
                return true;
            }
            if (System.currentTimeMillis() - C3929q.m20372a().m20395s().m19676b() <= 604800000) {
                return true;
            }
            return false;
        }
    }

    class C36972 implements C3695b {
        final /* synthetic */ C3700d f13331a;

        C36972(C3700d c3700d) {
            this.f13331a = c3700d;
        }

        public boolean mo2771a(C3694b c3694b) {
            return 1 != c3694b.m19358b();
        }
    }

    class C36983 implements C3695b {
        final /* synthetic */ C3700d f13332a;

        C36983(C3700d c3700d) {
            this.f13332a = c3700d;
        }

        public boolean mo2771a(C3694b c3694b) {
            return c3694b.m19358b() == 0 || 3 == c3694b.m19358b();
        }
    }

    public static final class C3699a {
        private final List<String> f13333a;
        private C3690a f13334b;
        private C3695b f13335c;
        private final SparseArray<C3690a> f13336d;

        private C3699a(C3690a c3690a, String[] strArr) {
            this.f13336d = new SparseArray();
            this.f13334b = c3690a;
            this.f13333a = new ArrayList(Arrays.asList(strArr));
        }

        public C3690a m19366a(int i) {
            C3690a c3690a = (C3690a) this.f13336d.get(i);
            return c3690a != null ? c3690a : this.f13334b;
        }

        public C3695b m19367a() {
            return this.f13335c;
        }

        public void m19368a(C3695b c3695b) {
            this.f13335c = c3695b;
        }

        private void m19365a(String str) {
            synchronized (this.f13333a) {
                this.f13333a.remove(str);
            }
        }

        public String toString() {
            return "Action Entry: " + this.f13333a;
        }
    }

    public C3699a m19369a(C3690a c3690a, String... strArr) {
        if (c3690a == null) {
            throw new IllegalArgumentException("Unable to an register a null action");
        } else if (strArr == null || strArr.length == 0) {
            throw new IllegalArgumentException("Unable to an action without a name.");
        } else {
            C3699a c3699a;
            for (String a : strArr) {
                if (C3954i.m20512a(a)) {
                    throw new IllegalArgumentException("Unable to register action because one or more of the names was null or empty.");
                }
            }
            synchronized (this.f13337a) {
                c3699a = new C3699a(c3690a, strArr);
                for (String str : strArr) {
                    if (!C3954i.m20512a(str)) {
                        C3699a c3699a2 = (C3699a) this.f13337a.remove(str);
                        if (c3699a2 != null) {
                            c3699a2.m19365a(str);
                        }
                        this.f13337a.put(str, c3699a);
                    }
                }
            }
            return c3699a;
        }
    }

    public C3699a m19370a(String str) {
        if (C3954i.m20512a(str)) {
            return null;
        }
        C3699a c3699a;
        synchronized (this.f13337a) {
            c3699a = (C3699a) this.f13337a.get(str);
        }
        return c3699a;
    }

    public void m19371a() {
        m19369a(new C3719o(), "share_action", "^s");
        m19369a(new C3709l(), "open_external_url_action", "^u");
        m19369a(new C3710j(), "deep_link_action", "^d");
        m19369a(new C3722q(), "wallet_action", "^w");
        m19369a(new C3713k(), "landing_page_action", "^p").m19368a(new C36961(this));
        C3695b c36972 = new C36972(this);
        m19369a(new C3692a(), "add_tags_action", "^+t").m19368a(c36972);
        m19369a(new C3693c(), "remove_tags_action", "^-t").m19368a(c36972);
        m19369a(new C3706h(), "add_custom_event_action").m19368a(new C36983(this));
        m19369a(new C3715m(), "open_mc_action", "^mc");
        m19369a(new C3717n(), "open_mc_overlay_action", "^mco");
        m19369a(new C3708i(), "clipboard_action", "^c");
        m19369a(new C3721p(), "toast_action");
    }
}
