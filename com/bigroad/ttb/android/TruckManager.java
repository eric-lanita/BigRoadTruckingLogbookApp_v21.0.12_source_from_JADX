package com.bigroad.ttb.android;

import android.content.Context;
import com.bigroad.shared.ag;
import com.bigroad.shared.ag.C0837a;
import com.bigroad.shared.ai;
import com.bigroad.shared.am;
import com.bigroad.shared.ar;
import com.bigroad.shared.gaps.model.C1091d;
import com.bigroad.ttb.android.AuthMonitor.AuthStatus;
import com.bigroad.ttb.android.AuthMonitor.C1185a;
import com.bigroad.ttb.android.C2474y.C1182a;
import com.bigroad.ttb.android.C2474y.C1183b;
import com.bigroad.ttb.android.eobr.EobrDevice;
import com.bigroad.ttb.android.event.C2022a;
import com.bigroad.ttb.android.logging.C2134e;
import com.bigroad.ttb.android.p035d.C1790a;
import com.bigroad.ttb.protocol.TTProtocol.DailyLogTruck;
import com.bigroad.ttb.protocol.TTProtocol.DvirInspection;
import com.bigroad.ttb.protocol.TTProtocol.Event;
import com.bigroad.ttb.protocol.TTProtocol.OdometerOffsets;
import com.bigroad.ttb.protocol.TTProtocol.OdometerUnit;
import com.bigroad.ttb.protocol.TTProtocol.Truck;
import com.bigroad.ttb.protocol.TTProtocol.Truck.C2782a;
import com.bigroad.ttb.protocol.TTProtocol.TruckGap;
import com.bigroad.ttb.protocol.TTProtocol.TruckLogType;
import com.google.protobuf.C2487l;
import com.google.protobuf.C3642c;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class TruckManager {
    private static TruckManager f4257a;
    private final C2474y f4258b = OurApplication.m6285g();
    private final C1790a f4259c = OurApplication.m6287i();
    private final AuthMonitor f4260d = OurApplication.m6249F();
    private final ag<ChangeListener> f4261e = new ag();
    private Truck f4262f = null;
    private final Map<String, Truck> f4263g;
    private String f4264h = null;
    private Map<String, TruckGap> f4265i = new HashMap();
    private final C1185a f4266j = new C12461(this);
    private final C1182a f4267k = new C1250a(this);

    public interface ChangeListener {

        public enum Priority {
            MALFUNCTION_MONITOR,
            AOBRD_MANAGER,
            AOBRD_ENGINE_USE,
            AOBRD_DRIVING_MONITOR,
            DUTY_MONITOR,
            EVENT_MANAGER,
            LOG_DAY_STATUS_MANAGER,
            DEFAULT
        }

        void mo893a();

        void mo894a(Truck truck);

        void mo895b();
    }

    public static class C1203b implements ChangeListener {
        public void mo895b() {
        }

        public void mo894a(Truck truck) {
        }

        public void mo893a() {
        }
    }

    class C12461 implements C1185a {
        final /* synthetic */ TruckManager f4241a;

        C12461(TruckManager truckManager) {
            this.f4241a = truckManager;
        }

        public void mo912a(AuthStatus authStatus) {
            if (authStatus == AuthStatus.SIGNED_OUT) {
                this.f4241a.m6550s();
                this.f4241a.m6588k();
            }
        }
    }

    class C12472 implements C0837a<ChangeListener> {
        final /* synthetic */ TruckManager f4242a;

        C12472(TruckManager truckManager) {
            this.f4242a = truckManager;
        }

        public void m6529a(ChangeListener changeListener) {
            changeListener.mo895b();
        }
    }

    class C12494 implements C0837a<ChangeListener> {
        final /* synthetic */ TruckManager f4245a;

        C12494(TruckManager truckManager) {
            this.f4245a = truckManager;
        }

        public void m6533a(ChangeListener changeListener) {
            changeListener.mo893a();
        }
    }

    private class C1250a extends C1183b {
        final /* synthetic */ TruckManager f4255a;
        private long f4256b = OurApplication.m6285g().m12213g();

        C1250a(TruckManager truckManager) {
            this.f4255a = truckManager;
        }

        public void mo866c(C2474y c2474y) {
            long g = c2474y.m12213g();
            if (g < 0) {
                this.f4255a.m6545n();
                this.f4255a.m6588k();
            } else if (g != this.f4256b) {
                this.f4255a.m6588k();
            }
            this.f4256b = g;
            this.f4255a.m6550s();
        }
    }

    public static TruckManager m6536a(Context context) {
        if (f4257a == null) {
            f4257a = new TruckManager();
        }
        return f4257a;
    }

    private TruckManager() {
        this.f4258b.m12184a(this.f4267k);
        this.f4260d.m6027a(this.f4266j);
        List<Truck> h = this.f4259c.m8787h();
        this.f4263g = new HashMap(h.size());
        for (Truck truck : h) {
            this.f4263g.put(truck.getTruckNumber(), truck);
        }
        List<TruckGap> j = this.f4259c.m8793j();
        this.f4265i = new HashMap(j.size());
        for (TruckGap truckGap : j) {
            this.f4265i.put(truckGap.getTruckNumber(), truckGap);
        }
        m6542k(this.f4258b.m12220j());
        m6547p();
        m6544m();
    }

    private void m6543l() {
        this.f4259c.m8743a(this.f4263g.values());
    }

    public void m6559a(ChangeListener changeListener) {
        m6560a(changeListener, Priority.DEFAULT);
    }

    public void m6560a(ChangeListener changeListener, Priority priority) {
        this.f4261e.m4159a(changeListener, priority.ordinal());
    }

    public void m6568b(ChangeListener changeListener) {
        this.f4261e.m4158a((Object) changeListener);
    }

    public boolean m6566a() {
        return !this.f4263g.isEmpty();
    }

    public boolean m6570b() {
        return this.f4262f == null && this.f4264h != null;
    }

    public void m6564a(Truck truck) {
        Truck truck2 = (Truck) this.f4263g.get(truck.getTruckNumber());
        if (truck2 == null || !ai.m4177a(truck2, truck)) {
            this.f4263g.put(truck.getTruckNumber(), truck);
            m6543l();
            m6547p();
            m6544m();
        }
    }

    public List<Truck> m6573c() {
        List arrayList = new ArrayList(this.f4263g.size());
        for (Truck truck : this.f4263g.values()) {
            if (!truck.getIsHidden()) {
                arrayList.add(truck);
            }
        }
        return arrayList;
    }

    public Set<String> m6575d() {
        return Collections.unmodifiableSet(this.f4263g.keySet());
    }

    public Map<Long, Truck> m6576e() {
        Map hashMap = new HashMap(this.f4263g.size());
        for (Truck truck : this.f4263g.values()) {
            hashMap.put(Long.valueOf(truck.getTruckId()), truck);
        }
        return Collections.unmodifiableMap(hashMap);
    }

    public boolean m6567a(String str) {
        return m6572c(str) != null;
    }

    public boolean m6571b(String str) {
        return m6574d(str) != null;
    }

    public Truck m6572c(String str) {
        return am.m4188a((CharSequence) str) ? null : (Truck) this.f4263g.get(str);
    }

    public Truck m6574d(String str) {
        Truck c = m6572c(str);
        return (c == null || !ar.m4238b(c)) ? null : c;
    }

    public Truck m6578f() {
        return this.f4262f;
    }

    public long m6580g() {
        return this.f4262f == null ? -2 : this.f4262f.getTruckId();
    }

    public String m6583h() {
        return this.f4262f == null ? null : this.f4262f.getTruckNumber();
    }

    public TruckLogType m6584i() {
        if (this.f4262f == null) {
            return TruckLogType.ELECTRONIC;
        }
        return TruckLogType.m15634a(this.f4262f.getTruckLogType());
    }

    public String m6586j() {
        return this.f4264h;
    }

    public void m6588k() {
        Object obj = this.f4262f != null ? 1 : null;
        this.f4262f = null;
        this.f4258b.m12196b("");
        this.f4264h = null;
        m6548q();
        if (obj != null) {
            OurApplication.m6295q().m10050e(C2022a.m10073a(OurApplication.ac()));
        }
        this.f4260d.m6028b();
    }

    public boolean m6577e(String str) {
        long j;
        long j2;
        if (this.f4262f == null) {
            j = -2;
        } else {
            j = this.f4262f.getTruckId();
        }
        boolean k = m6542k(str);
        if (this.f4262f == null) {
            j2 = -2;
        } else {
            j2 = this.f4262f.getTruckId();
        }
        if (!(j2 == j || j2 == -2)) {
            OurApplication.m6295q().m10050e(C2022a.m10073a(OurApplication.ac()));
        }
        return k;
    }

    private boolean m6542k(String str) {
        Truck truck = (Truck) this.f4263g.get(str);
        if (truck == null) {
            return false;
        }
        if (truck.getTruckId() == -1) {
            this.f4264h = str;
            this.f4262f = null;
            this.f4258b.m12196b("");
            m6548q();
        } else {
            this.f4264h = null;
            if (!ai.m4177a(truck, this.f4262f)) {
                this.f4262f = truck;
                C2134e.m10678c("TT-TruckMgr", "Setting active truck to truck number: " + this.f4262f.getTruckNumber());
                m6548q();
            }
            this.f4260d.m6028b();
            this.f4258b.m12196b(str);
        }
        return true;
    }

    public Truck m6552a(long j) {
        if (j < 0) {
            return null;
        }
        for (Truck truck : this.f4263g.values()) {
            if (truck.getTruckId() == j) {
                return truck;
            }
        }
        return null;
    }

    public Truck m6579f(String str) {
        Truck f = m6578f();
        if (f != null && f.getTruckId() >= 0 && f.hasVin() && am.m4189a(str, f.getVin())) {
            return f;
        }
        for (Truck f2 : this.f4263g.values()) {
            if (am.m4189a(str, f2.getVin()) && f2.getTruckId() >= 0) {
                return f2;
            }
        }
        return null;
    }

    public void m6565a(List<Truck> list) {
        Truck truck;
        Map hashMap = new HashMap(list.size());
        for (Truck truck2 : list) {
            hashMap.put(truck2.getTruckNumber(), truck2);
        }
        this.f4263g.putAll(hashMap);
        Iterator it = this.f4263g.values().iterator();
        while (it.hasNext()) {
            truck2 = (Truck) it.next();
            if (!(hashMap.containsKey(truck2.getTruckNumber()) || truck2.getTruckId() == -1)) {
                it.remove();
            }
        }
        m6543l();
        m6547p();
        m6544m();
    }

    private void m6544m() {
        if (this.f4264h != null) {
            Truck truck = (Truck) this.f4263g.get(this.f4264h);
            if (truck != null) {
                this.f4264h = null;
                m6577e(truck.getTruckNumber());
                return;
            }
        }
        if (this.f4262f != null) {
            C2487l c2487l = this.f4262f;
            this.f4262f = m6574d(this.f4262f.getTruckNumber());
            if (c2487l != this.f4262f || !ai.m4177a(c2487l, this.f4262f)) {
                m6548q();
            }
        }
    }

    private void m6545n() {
        this.f4263g.clear();
        this.f4259c.m8791i();
        this.f4262f = null;
        this.f4264h = null;
        m6547p();
        m6548q();
    }

    private boolean m6546o() {
        Iterator it = new ArrayList(this.f4263g.values()).iterator();
        boolean z = false;
        while (it.hasNext()) {
            boolean z2;
            Truck truck = (Truck) it.next();
            if (truck.getTruckId() == -1) {
                this.f4263g.remove(truck.getTruckNumber());
                z2 = true;
            } else {
                z2 = z;
            }
            z = z2;
        }
        return z;
    }

    private Truck m6540b(Truck truck) {
        boolean z;
        if (OurApplication.m6289k().m6498c()) {
            z = false;
        } else {
            z = m6546o();
        }
        Truck truck2 = (Truck) this.f4263g.get(truck.getTruckNumber());
        if (truck2 == null || truck2.getTruckId() == -1) {
            truck2 = Truck.newBuilder(truck).m15572a(-1).m15592c();
            this.f4263g.put(truck2.getTruckNumber(), truck2);
            m6543l();
            m6547p();
            OurApplication.m6289k().m6474a(truck2);
            return truck2;
        } else if (!z) {
            return truck2;
        } else {
            m6547p();
            return truck2;
        }
    }

    private Truck m6537a(C2782a c2782a, boolean z) {
        Truck c = c2782a.m15592c();
        this.f4263g.put(c.getTruckNumber(), c);
        m6543l();
        m6547p();
        m6544m();
        OurApplication.m6289k().m6475a(c, z);
        return c;
    }

    public void m6562a(DailyLogTruck dailyLogTruck) {
        OdometerUnit a;
        String truckLicense;
        if (dailyLogTruck.hasOdometerUnit()) {
            a = OdometerUnit.m14668a(dailyLogTruck.getOdometerUnit());
        } else {
            a = null;
        }
        String truckNumber = dailyLogTruck.getTruckNumber();
        if (dailyLogTruck.hasTruckLicense()) {
            truckLicense = dailyLogTruck.getTruckLicense();
        } else {
            truckLicense = null;
        }
        m6554a(truckNumber, truckLicense, a, null, null, false, null, null);
    }

    public void m6563a(DvirInspection dvirInspection) {
        if (dvirInspection.getVehicleType() == 1) {
            m6554a(dvirInspection.getVehicleNumber(), dvirInspection.getVehicleLicense(), null, null, null, false, null, null);
        }
    }

    public Truck m6554a(String str, String str2, OdometerUnit odometerUnit, String str3, byte[] bArr, boolean z, OdometerOffsets odometerOffsets, byte[] bArr2) {
        return m6556a(str, str2, odometerUnit, str3, bArr, z, odometerOffsets, bArr2, false);
    }

    public Truck m6556a(String str, String str2, OdometerUnit odometerUnit, String str3, byte[] bArr, boolean z, OdometerOffsets odometerOffsets, byte[] bArr2, boolean z2) {
        Truck truck = (Truck) this.f4263g.get(str);
        if (truck == null) {
            return null;
        }
        Object obj;
        Object obj2;
        C2782a newBuilder;
        Object obj3 = (truck.hasOdometerUnit() && (odometerUnit == null || truck.getOdometerUnit() == odometerUnit.m14669a())) ? null : 1;
        Object obj4 = (am.m4188a((CharSequence) str2) || am.m4189a(str2, truck.getTruckLicense())) ? null : 1;
        Object obj5 = (am.m4188a((CharSequence) str3) || am.m4189a(str3, truck.getVin())) ? null : 1;
        Object obj6 = (bArr == null || Arrays.equals(bArr, truck.getAssociatedDashLink().m19091d())) ? null : 1;
        if (bArr2 != null) {
            if (!Arrays.equals(bArr2, truck.getFirmwareOdometerAssociatedDashLink().m19091d())) {
                obj = 1;
                Object obj7 = (z || truck.getHasAobrd()) ? null : 1;
                obj2 = odometerOffsets == null ? 1 : null;
                if (obj3 != null && obj4 == null && obj5 == null && obj6 == null && obj7 == null && obj2 == null && !z2) {
                    return truck;
                }
                newBuilder = Truck.newBuilder(truck);
                if (obj3 != null) {
                    if (odometerUnit == null) {
                        odometerUnit = this.f4258b.m12230t();
                    }
                    newBuilder.m15580b(odometerUnit.m14669a());
                }
                if (obj4 != null) {
                    newBuilder.m15584b(str2);
                }
                if (obj5 != null) {
                    newBuilder.m15590c(str3);
                }
                if (obj6 != null) {
                    newBuilder.m15575a(C3642c.m19078a(bArr));
                }
                if (z) {
                    newBuilder.m15578a(true);
                }
                if (obj2 != null) {
                    newBuilder.m15573a(odometerOffsets);
                }
                if (obj != null) {
                    newBuilder.m15583b(C3642c.m19078a(bArr2));
                }
                return m6537a(newBuilder, z2);
            }
        }
        obj = null;
        if (z) {
        }
        if (odometerOffsets == null) {
        }
        if (obj3 != null) {
        }
        newBuilder = Truck.newBuilder(truck);
        if (obj3 != null) {
            if (odometerUnit == null) {
                odometerUnit = this.f4258b.m12230t();
            }
            newBuilder.m15580b(odometerUnit.m14669a());
        }
        if (obj4 != null) {
            newBuilder.m15584b(str2);
        }
        if (obj5 != null) {
            newBuilder.m15590c(str3);
        }
        if (obj6 != null) {
            newBuilder.m15575a(C3642c.m19078a(bArr));
        }
        if (z) {
            newBuilder.m15578a(true);
        }
        if (obj2 != null) {
            newBuilder.m15573a(odometerOffsets);
        }
        if (obj != null) {
            newBuilder.m15583b(C3642c.m19078a(bArr2));
        }
        return m6537a(newBuilder, z2);
    }

    public Truck m6581g(String str) {
        Truck truck = (Truck) this.f4263g.get(str);
        if (truck == null) {
            return null;
        }
        return m6537a(Truck.newBuilder(truck).m15606m().m15607n(), true);
    }

    public void m6561a(EobrDevice eobrDevice) {
        if (this.f4262f != null) {
            byte[] bArr;
            if (eobrDevice == null) {
                bArr = null;
            } else {
                bArr = eobrDevice.m8992d();
            }
            if (bArr != null) {
                m6537a(Truck.newBuilder(this.f4262f).m15589c(C3642c.m19078a(bArr)), false);
            }
        }
    }

    public Truck m6582h(String str) {
        return m6555a(str, null, null, null, null, false, null, null, null);
    }

    public Truck m6553a(String str, String str2) {
        return m6555a(str, str2, null, null, null, false, null, null, null);
    }

    public Truck m6555a(String str, String str2, OdometerUnit odometerUnit, String str3, byte[] bArr, boolean z, OdometerOffsets odometerOffsets, byte[] bArr2, Long l) {
        C2782a a = Truck.newBuilder().m15581b(OurApplication.m6285g().m12213g()).m15572a(-1).m15577a(str);
        if (odometerUnit == null) {
            odometerUnit = this.f4258b.m12230t();
        }
        a.m15580b(odometerUnit.m14669a());
        if (!am.m4188a((CharSequence) str2)) {
            a.m15584b(str2);
        }
        if (!am.m4188a((CharSequence) str3)) {
            a.m15590c(str3);
        }
        if (bArr != null) {
            a.m15575a(C3642c.m19078a(bArr));
        }
        if (z) {
            a.m15578a(true);
        }
        if (odometerOffsets != null) {
            a.m15573a(odometerOffsets);
        }
        if (bArr2 != null) {
            a.m15583b(C3642c.m19078a(bArr2));
        }
        if (l != null) {
            a.m15595d(l.longValue());
        }
        return m6540b(a.m15592c());
    }

    private void m6547p() {
        this.f4261e.m4157a(new C12472(this));
    }

    private void m6548q() {
        final Truck f = m6578f();
        this.f4261e.m4157a(new C0837a<ChangeListener>(this) {
            final /* synthetic */ TruckManager f4244b;

            public void m6531a(ChangeListener changeListener) {
                changeListener.mo894a(f);
            }
        });
    }

    private void m6549r() {
        this.f4261e.m4157a(new C12494(this));
    }

    public static Truck m6538a(byte[] bArr) {
        Truck truck = null;
        if (bArr != null) {
            try {
                truck = Truck.parseFrom(C3642c.m19078a(bArr));
            } catch (Throwable e) {
                C2134e.m10679c("TT-TruckMgr", "Error parsing truck from byte array", e);
            }
        }
        return truck;
    }

    private void m6550s() {
        if (this.f4265i.isEmpty()) {
            this.f4259c.m8795k();
            return;
        }
        this.f4265i = new HashMap();
        this.f4259c.m8795k();
        m6549r();
    }

    private boolean m6551t() {
        boolean z = false;
        List<Truck> i = OurApplication.m6296r().m8495i();
        Set hashSet = new HashSet(i.size());
        for (Truck truckNumber : i) {
            hashSet.add(truckNumber.getTruckNumber());
        }
        Iterator it = this.f4265i.keySet().iterator();
        while (it.hasNext()) {
            boolean z2;
            if (hashSet.contains((String) it.next())) {
                z2 = z;
            } else {
                it.remove();
                z2 = true;
            }
            z = z2;
        }
        return z;
    }

    public void m6569b(List<TruckGap> list) {
        if (!list.isEmpty()) {
            for (TruckGap truckGap : list) {
                this.f4265i.put(truckGap.getTruckNumber(), truckGap);
            }
            m6551t();
            this.f4259c.m8757b(this.f4265i.values());
            m6549r();
        }
    }

    public List<C1091d> m6585i(String str) {
        TruckGap truckGap = this.f4265i != null ? (TruckGap) this.f4265i.get(str) : null;
        if (truckGap == null || !truckGap.hasOdometerSegmentList()) {
            return Collections.emptyList();
        }
        return C1091d.m5406a(truckGap.getOdometerSegmentList().getOdometerSegmentList());
    }

    public List<C1091d> m6558a(String str, int i) {
        List<C1091d> i2 = m6585i(str);
        List<C1091d> arrayList = new ArrayList(i2.size());
        for (C1091d c1091d : i2) {
            if (c1091d.m5418b() != i) {
                arrayList.add(c1091d);
            }
        }
        return arrayList;
    }

    public byte[] m6587j(String str) {
        TruckGap truckGap;
        if (this.f4265i != null) {
            truckGap = (TruckGap) this.f4265i.get(str);
        } else {
            truckGap = null;
        }
        if (truckGap == null) {
            return null;
        }
        if (truckGap.hasGapDigest()) {
            return truckGap.getGapDigest().m19091d();
        }
        return null;
    }

    public TruckLogType m6557a(Event event) {
        if (event == null) {
            return TruckLogType.UNKNOWN_LOG_TYPE;
        }
        Truck a = m6552a(event.getTruckId());
        if (a == null) {
            return TruckLogType.UNKNOWN_LOG_TYPE;
        }
        return TruckLogType.m15634a(a.getTruckLogType());
    }
}
