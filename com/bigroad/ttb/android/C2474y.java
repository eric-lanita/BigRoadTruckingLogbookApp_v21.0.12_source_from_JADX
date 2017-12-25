package com.bigroad.ttb.android;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import android.util.Base64;
import com.bigroad.shared.MobileAppDiagnosticFlags;
import com.bigroad.shared.RemoteLogPriority;
import com.bigroad.shared.UserAuthenticationChangeBits.Reason;
import com.bigroad.shared.ah;
import com.bigroad.shared.aj;
import com.bigroad.shared.am;
import com.bigroad.shared.duty.C0956v;
import com.bigroad.ttb.android.event.C2022a;
import com.bigroad.ttb.android.event.EventManager;
import com.bigroad.ttb.android.logging.C2134e;
import com.bigroad.ttb.android.maps.MapTechnology;
import com.bigroad.ttb.protocol.TTProtocol.ActiveDrivingMode;
import com.bigroad.ttb.protocol.TTProtocol.AuthToken;
import com.bigroad.ttb.protocol.TTProtocol.FleetMembership;
import com.bigroad.ttb.protocol.TTProtocol.OdometerUnit;
import com.bigroad.ttb.protocol.TTProtocol.Person;
import com.bigroad.ttb.protocol.TTProtocol.Person.C2723a;
import com.bigroad.ttb.protocol.TTProtocol.Truck;
import com.google.protobuf.C3642c;
import com.google.protobuf.InvalidProtocolBufferException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.TimeZone;

public class C2474y {
    private static final Set<String> f8815a = new HashSet();
    private static C2474y f8816b;
    private final SharedPreferences f8817c;
    private final Set<C1182a> f8818d = new HashSet();
    private final OnSharedPreferenceChangeListener f8819e = new C24731(this);

    public interface C1182a {
        void mo863a(C2474y c2474y);

        void mo864a(C2474y c2474y, String str);

        void mo865b(C2474y c2474y);

        void mo866c(C2474y c2474y);

        void mo867d(C2474y c2474y);

        void mo868e(C2474y c2474y);

        void mo869f(C2474y c2474y);

        void mo870g(C2474y c2474y);

        void mo871h(C2474y c2474y);
    }

    public static class C1183b implements C1182a {
        public void mo869f(C2474y c2474y) {
        }

        public void mo863a(C2474y c2474y) {
        }

        public void mo868e(C2474y c2474y) {
        }

        public void mo866c(C2474y c2474y) {
        }

        public void mo867d(C2474y c2474y) {
        }

        public void mo870g(C2474y c2474y) {
        }

        public void mo865b(C2474y c2474y) {
        }

        public void mo864a(C2474y c2474y, String str) {
        }

        public void mo871h(C2474y c2474y) {
        }
    }

    class C24731 implements OnSharedPreferenceChangeListener {
        final /* synthetic */ C2474y f8814a;

        C24731(C2474y c2474y) {
            this.f8814a = c2474y;
        }

        public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
            int i = 0;
            if (!this.f8814a.f8818d.isEmpty()) {
                C1182a[] c1182aArr = (C1182a[]) this.f8814a.f8818d.toArray(new C1182a[this.f8814a.f8818d.size()]);
                int length;
                if (str.equals("emailAddress")) {
                    length = c1182aArr.length;
                    while (i < length) {
                        c1182aArr[i].mo869f(this.f8814a);
                        i++;
                    }
                } else if (str.equals("authHash")) {
                    length = c1182aArr.length;
                    while (i < length) {
                        c1182aArr[i].mo863a(this.f8814a);
                        i++;
                    }
                } else if (str.equals("person")) {
                    length = c1182aArr.length;
                    while (i < length) {
                        c1182aArr[i].mo868e(this.f8814a);
                        i++;
                    }
                } else if (str.equals("fleetId")) {
                    length = c1182aArr.length;
                    while (i < length) {
                        c1182aArr[i].mo866c(this.f8814a);
                        i++;
                    }
                } else if (str.equals("fleetMembership")) {
                    length = c1182aArr.length;
                    while (i < length) {
                        c1182aArr[i].mo867d(this.f8814a);
                        i++;
                    }
                } else if (str.equals("latestAppVersion")) {
                    length = c1182aArr.length;
                    while (i < length) {
                        c1182aArr[i].mo870g(this.f8814a);
                        i++;
                    }
                } else if (str.equals("diagnosticFlags")) {
                    length = c1182aArr.length;
                    while (i < length) {
                        c1182aArr[i].mo865b(this.f8814a);
                        i++;
                    }
                } else if (str.equals("prominentDisclosureAccepted")) {
                    length = c1182aArr.length;
                    while (i < length) {
                        c1182aArr[i].mo871h(this.f8814a);
                        i++;
                    }
                } else if (C2474y.f8815a.contains(str)) {
                    length = c1182aArr.length;
                    while (i < length) {
                        c1182aArr[i].mo864a(this.f8814a, str);
                        i++;
                    }
                }
            }
        }
    }

    static {
        f8815a.add("autoDutyStatus");
        f8815a.add("lockOutScreen");
    }

    public static C2474y m12144a(Context context) {
        if (f8816b == null) {
            f8816b = new C2474y(context);
        }
        return f8816b;
    }

    private C2474y(Context context) {
        this.f8817c = context.getApplicationContext().getSharedPreferences("globalPreferences", 0);
        this.f8817c.registerOnSharedPreferenceChangeListener(this.f8819e);
        if (m12191a() == null) {
            m12153b("clientId", aj.m4179a());
        }
        m12150a("password", null);
    }

    public void m12184a(C1182a c1182a) {
        this.f8818d.add(c1182a);
    }

    public void m12194b(C1182a c1182a) {
        this.f8818d.remove(c1182a);
    }

    private static String m12146a(byte[] bArr) {
        return Base64.encodeToString(bArr, 2);
    }

    private static byte[] m12154h(String str) {
        return Base64.decode(str, 2);
    }

    private byte[] m12152a(String str, byte[] bArr) {
        String string = this.f8817c.getString(str, null);
        return string == null ? bArr : C2474y.m12154h(string);
    }

    private void m12153b(String str, byte[] bArr) {
        m12150a(str, bArr == null ? null : C2474y.m12146a(bArr));
    }

    @SuppressLint({"CommitPrefEdits"})
    private void m12150a(String str, String str2) {
        Editor edit = this.f8817c.edit();
        if (str2 == null) {
            edit.remove(str);
        } else {
            edit.putString(str, str2);
        }
        edit.apply();
    }

    @SuppressLint({"CommitPrefEdits"})
    private void m12149a(String str, long j) {
        Editor edit = this.f8817c.edit();
        edit.putLong(str, j);
        edit.apply();
    }

    @SuppressLint({"CommitPrefEdits"})
    private void m12148a(String str, int i) {
        Editor edit = this.f8817c.edit();
        edit.putInt(str, i);
        edit.apply();
    }

    @SuppressLint({"CommitPrefEdits"})
    private void m12151a(String str, boolean z) {
        Editor edit = this.f8817c.edit();
        edit.putBoolean(str, z);
        edit.apply();
    }

    @SuppressLint({"CommitPrefEdits"})
    private void m12155i(String str) {
        Editor edit = this.f8817c.edit();
        edit.remove(str);
        edit.apply();
    }

    public byte[] m12191a() {
        return m12152a("clientId", null);
    }

    public String m12192b() {
        return this.f8817c.getString("emailAddress", null);
    }

    public void m12189a(String str) {
        m12150a("emailAddress", str);
    }

    public void m12198c() {
        m12150a("emailAddress", null);
    }

    public long m12202d() {
        return this.f8817c.getLong("personId", -1);
    }

    public byte[] m12209e() {
        return m12152a("authHash", null);
    }

    @SuppressLint({"CommitPrefEdits"})
    public void m12186a(AuthToken authToken, Reason reason) {
        EventManager q = OurApplication.m6295q();
        TruckManager p = OurApplication.m6294p();
        Object obj = null;
        if (authToken == null) {
            q.m10050e(C2022a.m10094b(OurApplication.ac(), reason));
            p.m6588k();
            this.f8817c.edit().remove("personId").remove("person").remove("authHash").apply();
        } else {
            String string = this.f8817c.getString("authHash", null);
            if (string == null) {
                obj = 1;
            }
            String a = C2474y.m12146a(authToken.getToken().m19091d());
            if (!(authToken.getPersonId() == m12202d() && am.m4189a(a, string))) {
                this.f8817c.edit().putLong("personId", authToken.getPersonId()).putString("authHash", a).apply();
            }
        }
        if (obj != null) {
            q.m10050e(C2022a.m10077a(OurApplication.ac(), reason));
        }
    }

    public AuthToken m12210f() {
        long d = m12202d();
        byte[] e = m12209e();
        if (d < 0 || e == null) {
            return null;
        }
        return AuthToken.newBuilder().m12430a(d).m12432a(C3642c.m19078a(e)).m12436c();
    }

    public long m12213g() {
        return this.f8817c.getLong("fleetId", -1);
    }

    public void m12183a(long j) {
        m12149a("fleetId", j);
    }

    public long m12216h() {
        return this.f8817c.getLong("lastFleetId", -1);
    }

    public void m12193b(long j) {
        m12149a("lastFleetId", j);
    }

    public void m12190a(boolean z) {
        m12151a("fleetIsTrial", z);
    }

    public boolean m12219i() {
        return this.f8817c.getBoolean("fleetIsTrial", false);
    }

    public String m12220j() {
        return this.f8817c.getString("activeTruckNumber", "");
    }

    public void m12196b(String str) {
        m12150a("activeTruckNumber", str);
        if (!am.m4188a((CharSequence) str)) {
            m12150a("lastUsedTruckNumber", str);
        }
    }

    public String m12221k() {
        return this.f8817c.getString("lastUsedTruckNumber", "");
    }

    public Person m12222l() {
        Person person = null;
        try {
            byte[] a = m12152a("person", null);
            if (a != null) {
                person = Person.parseFrom(a);
            }
        } catch (InvalidProtocolBufferException e) {
        }
        return person;
    }

    private String m12145a(boolean z, boolean z2) {
        return ah.m4161a(m12222l(), m12192b(), z, z2);
    }

    public String m12223m() {
        return m12145a(true, true);
    }

    public String m12224n() {
        return m12145a(true, false);
    }

    public String m12225o() {
        return m12145a(false, true);
    }

    public boolean m12226p() {
        Person l = m12222l();
        return (l == null || am.m4188a(l.getEmailAddress()) || !l.getPasswordSet()) ? false : true;
    }

    public boolean m12227q() {
        return this.f8817c.getBoolean("hasForsakenTrialAccount", false);
    }

    public void m12197b(boolean z) {
        m12151a("hasForsakenTrialAccount", z);
    }

    public void m12188a(Person person) {
        if (person == null) {
            m12153b("person", null);
        } else if (person.getPersonId() == m12202d()) {
            byte[] toByteArray = person.toByteArray();
            if (!Arrays.equals(toByteArray, m12152a("person", null))) {
                m12153b("person", toByteArray);
            }
        }
    }

    public void m12195b(Person person) {
        if (person != null && person.getPersonId() == m12202d()) {
            Person l = m12222l();
            if (l == null) {
                m12188a(person);
                return;
            }
            C2723a newBuilder = Person.newBuilder(l);
            newBuilder.m14720a(person);
            if (am.m4188a(person.getEmailAddress())) {
                newBuilder.m14731c(l.getEmailAddress());
            }
            if (person.hasSignatureId() && person.getSignatureId().m19090c()) {
                newBuilder.m14750l();
            }
            m12188a(newBuilder.m14733c());
        }
    }

    public C0956v m12228r() {
        return new C0956v(m12222l());
    }

    public TimeZone m12229s() {
        return m12228r().m4868b();
    }

    public OdometerUnit m12230t() {
        C0956v r = m12228r();
        if (r == null || !r.mo706e()) {
            return OdometerUnit.MILES;
        }
        return OdometerUnit.KM;
    }

    public FleetMembership m12231u() {
        FleetMembership fleetMembership = null;
        try {
            byte[] a = m12152a("fleetMembership", null);
            if (a != null) {
                fleetMembership = FleetMembership.parseFrom(a);
            }
        } catch (InvalidProtocolBufferException e) {
        }
        return fleetMembership;
    }

    public void m12187a(FleetMembership fleetMembership) {
        if (fleetMembership == null) {
            m12153b("fleetMembership", null);
        } else if (fleetMembership.getPersonId() == m12202d() && fleetMembership.getFleetId() == m12213g()) {
            byte[] toByteArray = fleetMembership.toByteArray();
            if (!Arrays.equals(toByteArray, m12152a("fleetMembership", null))) {
                m12153b("fleetMembership", toByteArray);
            }
        }
    }

    public boolean m12232v() {
        FleetMembership u = m12231u();
        if (u != null && u.hasAllowLogApproval()) {
            return u.getAllowLogApproval();
        }
        return false;
    }

    public String m12233w() {
        return this.f8817c.getString("mapType", "");
    }

    public void m12200c(String str) {
        m12150a("mapType", str);
    }

    public MapTechnology m12234x() {
        return MapTechnology.m10739a(m12158C());
    }

    public RemoteLogPriority m12235y() {
        return RemoteLogPriority.m4098a(m12158C());
    }

    public boolean m12236z() {
        Long C = m12158C();
        return C != null && MobileAppDiagnosticFlags.LOG_DATA_USE.m4089b(C.longValue());
    }

    public boolean m12156A() {
        Long C = m12158C();
        return C != null && MobileAppDiagnosticFlags.ANALYTICS_DRY_RUN.m4089b(C.longValue());
    }

    public boolean m12157B() {
        Long C = m12158C();
        return C != null && MobileAppDiagnosticFlags.LOG_CLOCK_CHANGES.m4089b(C.longValue());
    }

    public Long m12158C() {
        return this.f8817c.contains("diagnosticFlags") ? Long.valueOf(this.f8817c.getLong("diagnosticFlags", 0)) : null;
    }

    public void m12159D() {
        if (m12158C() != null) {
            C2134e.m10678c("TT-Preferences", "Clearing diagnostic flags.");
            m12155i("diagnosticFlags");
        }
    }

    public void m12199c(long j) {
        Long C = m12158C();
        if (C == null || !C.equals(Long.valueOf(j))) {
            C2134e.m10678c("TT-Preferences", "Setting diagnostic flags to 0x" + Long.toHexString(j));
            m12149a("diagnosticFlags", j);
        }
    }

    public long m12160E() {
        return this.f8817c.getLong("lastUpdatedTime", 0);
    }

    public void m12203d(long j) {
        m12149a("lastUpdatedTime", j);
    }

    public long m12161F() {
        return this.f8817c.getLong("firstLaunch", 0);
    }

    public void m12206e(long j) {
        m12149a("firstLaunch", j);
    }

    public long m12162G() {
        return this.f8817c.getLong("rateLastShown", 0);
    }

    public void m12211f(long j) {
        m12149a("rateLastShown", j);
    }

    public int m12163H() {
        return this.f8817c.getInt("launchCount", 0);
    }

    public void m12164I() {
        m12148a("launchCount", m12163H() + 1);
    }

    public int m12165J() {
        return this.f8817c.getInt("launchState", 0);
    }

    public void m12182a(int i) {
        m12148a("launchState", i);
    }

    public long m12166K() {
        return this.f8817c.getLong("startDrivingCanceled", 0);
    }

    public void m12214g(long j) {
        m12149a("startDrivingCanceled", j);
    }

    public long m12167L() {
        return this.f8817c.getLong("stopDrivingCanceled", 0);
    }

    public void m12217h(long j) {
        m12149a("stopDrivingCanceled", j);
    }

    public long m12168M() {
        return this.f8817c.getLong("lastSentDeviceStatus", 0);
    }

    public void m12218i(long j) {
        m12149a("lastSentDeviceStatus", j);
    }

    public boolean m12169N() {
        return this.f8817c.getBoolean("dashboardHelpComplete", false);
    }

    public void m12201c(boolean z) {
        m12151a("dashboardHelpComplete", z);
    }

    public String m12170O() {
        return this.f8817c.getString("latestAppVersion", null);
    }

    public void m12204d(String str) {
        m12150a("latestAppVersion", str);
    }

    public boolean m12171P() {
        return this.f8817c.getBoolean("autoDutyStatus", true);
    }

    public String m12172Q() {
        return this.f8817c.getString("lockOutScreen", "");
    }

    public Truck m12173R() {
        return TruckManager.m6538a(m12152a("truck", null));
    }

    public void m12174S() {
        m12153b("truck", null);
    }

    public void m12205d(boolean z) {
        m12151a("devMode", z);
    }

    public boolean m12175T() {
        return this.f8817c.getBoolean("devMode", false);
    }

    public void m12207e(String str) {
        m12150a("devServer", str);
    }

    public String m12176U() {
        return this.f8817c.getString("devServer", "app.bigroad.com");
    }

    public boolean m12177V() {
        return this.f8817c.getBoolean("prominentDisclosureAccepted", false);
    }

    public boolean m12178W() {
        return this.f8817c.contains("prominentDisclosureAccepted");
    }

    public void m12208e(boolean z) {
        m12151a("prominentDisclosureAccepted", z);
    }

    public ActiveDrivingMode m12179X() {
        ActiveDrivingMode a = ActiveDrivingMode.m12378a(this.f8817c.getInt("activeDrivingMode", -1));
        return a == null ? ActiveDrivingMode.UNSPECIFIED_DRIVING_MODE : a;
    }

    public void m12185a(ActiveDrivingMode activeDrivingMode) {
        m12148a("activeDrivingMode", activeDrivingMode.ordinal());
    }

    public String m12180Y() {
        return this.f8817c.getString("activeTrailer", "");
    }

    public void m12212f(String str) {
        m12150a("activeTrailer", str);
    }

    public String m12181Z() {
        return this.f8817c.getString("activeShippingDoc", "");
    }

    public void m12215g(String str) {
        m12150a("activeShippingDoc", str);
    }
}
