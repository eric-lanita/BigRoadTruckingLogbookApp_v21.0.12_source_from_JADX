package com.bigroad.ttb.android.vehicle;

import android.text.TextUtils;
import com.bigroad.shared.C1096h;
import com.bigroad.shared.ap;
import com.bigroad.shared.eobr.ConnectionError;
import com.bigroad.shared.eobr.ConnectionFlag;
import com.bigroad.shared.eobr.ConnectionSetupFlag;
import com.bigroad.ttb.android.util.C2276a;
import com.bigroad.ttb.android.util.C2276a.C2275a;
import com.google.common.base.MoreObjects;
import com.google.common.base.MoreObjects.ToStringHelper;
import com.google.common.base.Objects;
import java.util.ArrayList;

public class C2338a {
    private final ap f8105a;
    private final C2276a<ConnectionSetupFlag> f8106b;
    private final C2276a<ConnectionFlag> f8107c;
    private final ConnectionError f8108d;

    public static class C2331a {
        private final C2338a f8082a;
        private final ap f8083b;
        private C2275a<ConnectionSetupFlag> f8084c;
        private C2275a<ConnectionFlag> f8085d;
        private ConnectionError f8086e;

        public C2331a(C2338a c2338a) {
            this.f8082a = c2338a;
            this.f8083b = c2338a.f8105a;
            this.f8084c = c2338a.f8106b.m11161a();
            this.f8085d = c2338a.f8107c.m11161a();
            this.f8086e = c2338a.m11455c();
        }

        boolean m11418a() {
            return this.f8085d.m11156a(ConnectionFlag.CONNECTED);
        }

        boolean m11420a(ConnectionSetupFlag connectionSetupFlag) {
            return this.f8084c.m11156a((Object) connectionSetupFlag);
        }

        boolean m11419a(ConnectionFlag connectionFlag) {
            return this.f8085d.m11156a((Object) connectionFlag);
        }

        boolean m11423b() {
            for (ConnectionFlag a : ConnectionFlag.values()) {
                if (!m11419a(a)) {
                    return false;
                }
            }
            return true;
        }

        C2331a m11417a(ConnectionSetupFlag connectionSetupFlag, boolean z) {
            this.f8084c.m11154a(connectionSetupFlag, z);
            return this;
        }

        public C2331a m11422b(ConnectionSetupFlag connectionSetupFlag) {
            m11417a(connectionSetupFlag, true);
            return this;
        }

        public C2331a m11426c(ConnectionSetupFlag connectionSetupFlag) {
            m11417a(connectionSetupFlag, false);
            return this;
        }

        C2331a m11416a(ConnectionFlag connectionFlag, boolean z) {
            this.f8085d.m11154a(connectionFlag, z);
            return this;
        }

        public C2331a m11421b(ConnectionFlag connectionFlag) {
            m11416a(connectionFlag, true);
            return this;
        }

        public C2331a m11425c(ConnectionFlag connectionFlag) {
            m11416a(connectionFlag, false);
            return this;
        }

        C2331a m11424c() {
            this.f8084c.m11153a();
            this.f8085d.m11153a();
            return this;
        }

        public C2331a m11427d() {
            this.f8085d.m11153a();
            return this;
        }

        public C2331a m11415a(ConnectionError connectionError) {
            this.f8086e = connectionError;
            if (connectionError != ConnectionError.NONE) {
                m11426c(ConnectionSetupFlag.SEARCHING);
                m11426c(ConnectionSetupFlag.RECONNECTING);
                m11427d();
                if (connectionError != ConnectionError.BLUETOOTH_NOT_ENABLED) {
                    m11426c(ConnectionSetupFlag.RECONNECTING);
                }
            }
            return this;
        }

        public C2338a m11428e() {
            long c = this.f8083b.mo915c();
            if (m11420a(ConnectionSetupFlag.RECONNECTING)) {
                if (m11423b()) {
                    m11426c(ConnectionSetupFlag.RECONNECTING);
                }
                if (m11420a(ConnectionSetupFlag.CORRUPTED)) {
                    m11426c(ConnectionSetupFlag.RECONNECTING);
                }
                Long b = this.f8082a.m11452b();
                if (b != null && c >= b.longValue()) {
                    m11426c(ConnectionSetupFlag.RECONNECTING);
                }
            }
            return new C2338a(this.f8084c.m11155a(c), this.f8085d.m11155a(c), this.f8086e, this.f8083b);
        }
    }

    private C2338a(C2276a<ConnectionSetupFlag> c2276a, C2276a<ConnectionFlag> c2276a2, ConnectionError connectionError, ap apVar) {
        this.f8105a = apVar;
        this.f8106b = c2276a;
        this.f8107c = c2276a2;
        this.f8108d = connectionError;
    }

    public boolean m11451a(ConnectionSetupFlag connectionSetupFlag) {
        return this.f8106b.m11163a((Object) connectionSetupFlag);
    }

    public boolean m11450a(ConnectionFlag connectionFlag) {
        return this.f8107c.m11163a((Object) connectionFlag);
    }

    public Long m11454b(ConnectionSetupFlag connectionSetupFlag) {
        return this.f8106b.m11164b((Object) connectionSetupFlag);
    }

    public Long m11453b(ConnectionFlag connectionFlag) {
        return this.f8107c.m11164b((Object) connectionFlag);
    }

    public boolean m11449a() {
        return this.f8106b.m11163a(ConnectionSetupFlag.RECONNECTING);
    }

    public Long m11452b() {
        Long b = this.f8106b.m11164b(ConnectionSetupFlag.RECONNECTING);
        return b == null ? null : Long.valueOf(b.longValue() + 120000);
    }

    public ConnectionError m11455c() {
        return this.f8108d;
    }

    public long m11448a(long j) {
        long a = C1096h.m5440a(j, m11449a(), this.f8106b.m11162a(new ArrayList()), this.f8107c.m11162a(new ArrayList()), this.f8108d);
        if (m11449a()) {
            return a;
        }
        return a | 2048;
    }

    public C2331a m11456d() {
        return new C2331a(this);
    }

    public static C2338a m11444a(ap apVar) {
        return new C2338a(new C2276a(), new C2276a(), ConnectionError.NONE, apVar);
    }

    public boolean equals(Object obj) {
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        C2338a c2338a = (C2338a) obj;
        if (Objects.equal(this.f8108d, c2338a.f8108d) && Objects.equal(this.f8107c, c2338a.f8107c) && Objects.equal(this.f8106b, c2338a.f8106b)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return Objects.hashCode(this.f8106b, this.f8107c, this.f8108d);
    }

    public String toString() {
        return m11445a(true);
    }

    private String m11445a(boolean z) {
        int i = 0;
        ToStringHelper toStringHelper = MoreObjects.toStringHelper((Object) this);
        if (m11451a(ConnectionSetupFlag.REQUIRED)) {
            Iterable arrayList = new ArrayList();
            for (ConnectionSetupFlag connectionSetupFlag : ConnectionSetupFlag.values()) {
                if (m11451a(connectionSetupFlag)) {
                    arrayList.add(connectionSetupFlag.toString());
                }
            }
            ConnectionFlag[] values = ConnectionFlag.values();
            int length = values.length;
            while (i < length) {
                ConnectionFlag connectionFlag = values[i];
                if (m11450a(connectionFlag)) {
                    arrayList.add(connectionFlag.toString());
                }
                i++;
            }
            toStringHelper.add("flags", "(" + TextUtils.join(",", arrayList) + ")");
        } else {
            toStringHelper.add("flags", (Object) "(NOT_REQUIRED)");
        }
        if (this.f8108d != ConnectionError.NONE) {
            toStringHelper.add("error", this.f8108d);
        }
        return toStringHelper.toString();
    }
}
