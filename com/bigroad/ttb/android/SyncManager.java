package com.bigroad.ttb.android;

import android.content.Context;
import android.location.Location;
import android.os.Handler;
import com.bigroad.shared.C1142r;
import com.bigroad.shared.C1142r.C1135c;
import com.bigroad.shared.C1144s;
import com.bigroad.shared.UserAuthenticationChangeBits.Reason;
import com.bigroad.shared.am;
import com.bigroad.shared.ap;
import com.bigroad.ttb.android.C2081g.C1230a;
import com.bigroad.ttb.android.C2081g.C1231b;
import com.bigroad.ttb.android.C2474y.C1182a;
import com.bigroad.ttb.android.C2474y.C1183b;
import com.bigroad.ttb.android.PowerStatus.C1216a;
import com.bigroad.ttb.android.ac.C1240a;
import com.bigroad.ttb.android.eobr.turbo.VarPage;
import com.bigroad.ttb.android.event.EventManager;
import com.bigroad.ttb.android.location.C2119a;
import com.bigroad.ttb.android.logging.C2134e;
import com.bigroad.ttb.android.logging.C2136g;
import com.bigroad.ttb.android.logging.C2138i;
import com.bigroad.ttb.android.p029c.C1736b;
import com.bigroad.ttb.android.p035d.C1790a;
import com.bigroad.ttb.android.p035d.p036a.C1767f;
import com.bigroad.ttb.android.p035d.p036a.C1769h;
import com.bigroad.ttb.android.p035d.p036a.C1783u;
import com.bigroad.ttb.android.util.C2279b;
import com.bigroad.ttb.android.util.C2291k;
import com.bigroad.ttb.android.util.C2306y;
import com.bigroad.ttb.protocol.TTProtocol;
import com.bigroad.ttb.protocol.TTProtocol.AckMessageRequest;
import com.bigroad.ttb.protocol.TTProtocol.AckMessageResponse;
import com.bigroad.ttb.protocol.TTProtocol.AcknowledgeCorrectionRequest;
import com.bigroad.ttb.protocol.TTProtocol.AcknowledgeCorrectionRequest.C2494a;
import com.bigroad.ttb.protocol.TTProtocol.AcknowledgeCorrectionResponse;
import com.bigroad.ttb.protocol.TTProtocol.AuthCredential;
import com.bigroad.ttb.protocol.TTProtocol.AuthToken;
import com.bigroad.ttb.protocol.TTProtocol.AutoDailyLogTruck;
import com.bigroad.ttb.protocol.TTProtocol.AutoSignInAccountRequest;
import com.bigroad.ttb.protocol.TTProtocol.AutoSignInAccountResponse;
import com.bigroad.ttb.protocol.TTProtocol.Breadcrumb;
import com.bigroad.ttb.protocol.TTProtocol.Breadcrumb.C2521a;
import com.bigroad.ttb.protocol.TTProtocol.BreadcrumbRequest;
import com.bigroad.ttb.protocol.TTProtocol.BreadcrumbRequest.C2524a;
import com.bigroad.ttb.protocol.TTProtocol.BreadcrumbResponse;
import com.bigroad.ttb.protocol.TTProtocol.CertifyLogRequest;
import com.bigroad.ttb.protocol.TTProtocol.CertifyLogResponse;
import com.bigroad.ttb.protocol.TTProtocol.ClaimUnidentifiedEventsRequest;
import com.bigroad.ttb.protocol.TTProtocol.ClaimUnidentifiedEventsResponse;
import com.bigroad.ttb.protocol.TTProtocol.ClientVersion;
import com.bigroad.ttb.protocol.TTProtocol.CoalesceEventRequest;
import com.bigroad.ttb.protocol.TTProtocol.CoalesceEventResponse;
import com.bigroad.ttb.protocol.TTProtocol.Conversation;
import com.bigroad.ttb.protocol.TTProtocol.ConversationData;
import com.bigroad.ttb.protocol.TTProtocol.ConversationParticipant;
import com.bigroad.ttb.protocol.TTProtocol.ConversationRequest;
import com.bigroad.ttb.protocol.TTProtocol.ConversationRequest.C2561a;
import com.bigroad.ttb.protocol.TTProtocol.ConversationResponse;
import com.bigroad.ttb.protocol.TTProtocol.Correction;
import com.bigroad.ttb.protocol.TTProtocol.CreateEobrEventRequest;
import com.bigroad.ttb.protocol.TTProtocol.CreateEobrEventResponse;
import com.bigroad.ttb.protocol.TTProtocol.CreateEventRequest;
import com.bigroad.ttb.protocol.TTProtocol.CreateEventRequest.C2575a;
import com.bigroad.ttb.protocol.TTProtocol.CreateEventResponse;
import com.bigroad.ttb.protocol.TTProtocol.DailyLog;
import com.bigroad.ttb.protocol.TTProtocol.DailyLogShare;
import com.bigroad.ttb.protocol.TTProtocol.DailyLogShareRequest;
import com.bigroad.ttb.protocol.TTProtocol.DailyLogShareResponse;
import com.bigroad.ttb.protocol.TTProtocol.DeleteDvirInspectionRequest;
import com.bigroad.ttb.protocol.TTProtocol.DeleteDvirInspectionResponse;
import com.bigroad.ttb.protocol.TTProtocol.DeleteDvirRequest;
import com.bigroad.ttb.protocol.TTProtocol.DeleteDvirResponse;
import com.bigroad.ttb.protocol.TTProtocol.DeleteEventRequest;
import com.bigroad.ttb.protocol.TTProtocol.DeleteEventResponse;
import com.bigroad.ttb.protocol.TTProtocol.DescribeClientRequest;
import com.bigroad.ttb.protocol.TTProtocol.DescribeClientRequest.C2622a;
import com.bigroad.ttb.protocol.TTProtocol.DescribeClientResponse;
import com.bigroad.ttb.protocol.TTProtocol.DiagnosticConfig;
import com.bigroad.ttb.protocol.TTProtocol.Dvir;
import com.bigroad.ttb.protocol.TTProtocol.DvirInspection;
import com.bigroad.ttb.protocol.TTProtocol.EobrStopDrivingRequest;
import com.bigroad.ttb.protocol.TTProtocol.EobrStopDrivingResponse;
import com.bigroad.ttb.protocol.TTProtocol.EulaAcknowledgementRequest;
import com.bigroad.ttb.protocol.TTProtocol.EulaAcknowledgementResponse;
import com.bigroad.ttb.protocol.TTProtocol.Event;
import com.bigroad.ttb.protocol.TTProtocol.EventChangeListEntry;
import com.bigroad.ttb.protocol.TTProtocol.Fleet;
import com.bigroad.ttb.protocol.TTProtocol.GenxEntry;
import com.bigroad.ttb.protocol.TTProtocol.GenxEntrySyncRequest;
import com.bigroad.ttb.protocol.TTProtocol.GenxEntrySyncRequest.C2673a;
import com.bigroad.ttb.protocol.TTProtocol.GenxEntrySyncResponse;
import com.bigroad.ttb.protocol.TTProtocol.LatLon;
import com.bigroad.ttb.protocol.TTProtocol.ListDashLinkFirmwareVersionsResponse;
import com.bigroad.ttb.protocol.TTProtocol.ListPeopleRequest;
import com.bigroad.ttb.protocol.TTProtocol.ListPeopleResponse;
import com.bigroad.ttb.protocol.TTProtocol.ListTrucksRequest;
import com.bigroad.ttb.protocol.TTProtocol.ListTrucksRequest.C2694a;
import com.bigroad.ttb.protocol.TTProtocol.ListTrucksResponse;
import com.bigroad.ttb.protocol.TTProtocol.LookupTruckRequest;
import com.bigroad.ttb.protocol.TTProtocol.LookupTruckRequest.C2698a;
import com.bigroad.ttb.protocol.TTProtocol.LookupTruckResponse;
import com.bigroad.ttb.protocol.TTProtocol.Message;
import com.bigroad.ttb.protocol.TTProtocol.OdometerUnit;
import com.bigroad.ttb.protocol.TTProtocol.Person;
import com.bigroad.ttb.protocol.TTProtocol.RemoteLogEvent;
import com.bigroad.ttb.protocol.TTProtocol.RemoteLogEvent.C2732a;
import com.bigroad.ttb.protocol.TTProtocol.RemoteLogEventRequest;
import com.bigroad.ttb.protocol.TTProtocol.RemoteLogEventRequest.C2734a;
import com.bigroad.ttb.protocol.TTProtocol.RemoteLogEventResponse;
import com.bigroad.ttb.protocol.TTProtocol.Request;
import com.bigroad.ttb.protocol.TTProtocol.Request.C2739a;
import com.bigroad.ttb.protocol.TTProtocol.RequestType;
import com.bigroad.ttb.protocol.TTProtocol.RequestUnion;
import com.bigroad.ttb.protocol.TTProtocol.RequestUnion.C2742a;
import com.bigroad.ttb.protocol.TTProtocol.ResponseStatus;
import com.bigroad.ttb.protocol.TTProtocol.ReverseGeocodeRequest;
import com.bigroad.ttb.protocol.TTProtocol.ReverseGeocodeResponse;
import com.bigroad.ttb.protocol.TTProtocol.SendMessageRequest;
import com.bigroad.ttb.protocol.TTProtocol.SendMessageResponse;
import com.bigroad.ttb.protocol.TTProtocol.SetAutoDailyLogTruckRequest;
import com.bigroad.ttb.protocol.TTProtocol.SetAutoDailyLogTruckResponse;
import com.bigroad.ttb.protocol.TTProtocol.SetDailyLogRequest;
import com.bigroad.ttb.protocol.TTProtocol.SetDailyLogResponse;
import com.bigroad.ttb.protocol.TTProtocol.SetDvirInspectionRequest;
import com.bigroad.ttb.protocol.TTProtocol.SetDvirInspectionResponse;
import com.bigroad.ttb.protocol.TTProtocol.SetDvirRequest;
import com.bigroad.ttb.protocol.TTProtocol.SetDvirResponse;
import com.bigroad.ttb.protocol.TTProtocol.SignInRequest;
import com.bigroad.ttb.protocol.TTProtocol.SignInRequest.C2774a;
import com.bigroad.ttb.protocol.TTProtocol.SignInResponse;
import com.bigroad.ttb.protocol.TTProtocol.SyncRequest;
import com.bigroad.ttb.protocol.TTProtocol.SyncRequest.C2778a;
import com.bigroad.ttb.protocol.TTProtocol.SyncResponse;
import com.bigroad.ttb.protocol.TTProtocol.Truck;
import com.bigroad.ttb.protocol.TTProtocol.TruckGap;
import com.bigroad.ttb.protocol.TTProtocol.TruckGap.C2784a;
import com.bigroad.ttb.protocol.TTProtocol.UpdateEobrDrivingEventRequest;
import com.bigroad.ttb.protocol.TTProtocol.UpdateEobrDrivingEventResponse;
import com.bigroad.ttb.protocol.TTProtocol.UpdateEventRequest;
import com.bigroad.ttb.protocol.TTProtocol.UpdateEventResponse;
import com.bigroad.ttb.protocol.TTProtocol.UpdatePersonRequest;
import com.bigroad.ttb.protocol.TTProtocol.UpdatePersonRequest.C2795a;
import com.bigroad.ttb.protocol.TTProtocol.UpdatePersonResponse;
import com.bigroad.ttb.protocol.TTProtocol.UpdateTruckRequest;
import com.bigroad.ttb.protocol.TTProtocol.UpdateTruckResponse;
import com.bigroad.ttb.protocol.TTProtocol.VarSyncRequest;
import com.bigroad.ttb.protocol.TTProtocol.VarSyncRequest.C2807a;
import com.bigroad.ttb.protocol.TTProtocol.VarSyncResponse;
import com.google.protobuf.C3642c;
import com.google.protobuf.InvalidProtocolBufferException;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class SyncManager implements C1240a {
    private static SyncManager f4189a;
    private static final int f4190b = ClientVersion.values()[ClientVersion.values().length - 1].m12678a();
    private boolean f4191A;
    private final Runnable f4192B = new C12283(this);
    private final C1182a f4193C = new C12294(this);
    private final C1230a f4194D = new C12325(this);
    private final C1216a f4195E = new C12336(this);
    private final C1135c f4196F = new C12347(this);
    private final Runnable f4197G = new C12369(this);
    private final Runnable f4198H = new Runnable(this) {
        final /* synthetic */ SyncManager f4170a;

        {
            this.f4170a = r1;
        }

        public void run() {
            this.f4170a.m6443s();
            this.f4170a.m6372C();
        }
    };
    private final Runnable f4199c = new C12261(this);
    private final Handler f4200d = new Handler();
    private final C2474y f4201e;
    private final C1790a f4202f;
    private final C2081g f4203g;
    private final PowerStatus f4204h;
    private final C2230r f4205i;
    private final TruckManager f4206j;
    private final C1736b f4207k;
    private final FcmManager f4208l;
    private final ClockMonitor f4209m;
    private final ap f4210n;
    private ai f4211o;
    private final Set<C1239c> f4212p = new HashSet();
    private final Set<C1238b> f4213q = new HashSet();
    private final Set<C1237a> f4214r = new HashSet();
    private final C2279b f4215s = new C2279b(this.f4199c, 250, 20000, 2.0f);
    private final DescribeClientRequest f4216t;
    private final ac f4217u = new ac();
    private final aa f4218v;
    private final LinkedList<C1767f> f4219w = new LinkedList();
    private SyncMode f4220x = SyncMode.STOPPED;
    private long f4221y = 0;
    private boolean f4222z = true;

    class C12261 implements Runnable {
        final /* synthetic */ SyncManager f4171a;

        C12261(SyncManager syncManager) {
            this.f4171a = syncManager;
        }

        public void run() {
            this.f4171a.m6372C();
        }
    }

    class C12283 implements Runnable {
        final /* synthetic */ SyncManager f4175a;

        C12283(SyncManager syncManager) {
            this.f4175a = syncManager;
        }

        public void run() {
            this.f4175a.m6443s();
            this.f4175a.m6372C();
        }
    }

    class C12294 extends C1183b {
        final /* synthetic */ SyncManager f4176a;

        C12294(SyncManager syncManager) {
            this.f4176a = syncManager;
        }

        public void mo863a(C2474y c2474y) {
            this.f4176a.m6443s();
            this.f4176a.m6372C();
        }
    }

    class C12325 extends C1231b {
        final /* synthetic */ SyncManager f4177a;

        C12325(SyncManager syncManager) {
            this.f4177a = syncManager;
        }

        public void mo906a(C2081g c2081g) {
            this.f4177a.m6442r();
        }
    }

    class C12336 implements C1216a {
        final /* synthetic */ SyncManager f4178a;

        C12336(SyncManager syncManager) {
            this.f4178a = syncManager;
        }

        public void mo908a(PowerStatus powerStatus) {
            this.f4178a.m6442r();
        }
    }

    class C12347 implements C1135c {
        final /* synthetic */ SyncManager f4179a;

        C12347(SyncManager syncManager) {
            this.f4179a = syncManager;
        }

        public boolean mo818a(Event event, List<byte[]> list) {
            this.f4179a.m6471a(event, (List) list);
            return true;
        }

        public boolean mo817a(Event event) {
            this.f4179a.m6469a(event);
            return true;
        }

        public boolean mo819b(Event event) {
            this.f4179a.m6476a(event.getEventId());
            return true;
        }
    }

    class C12358 implements Runnable {
        final /* synthetic */ SyncManager f4180a;

        C12358(SyncManager syncManager) {
            this.f4180a = syncManager;
        }

        public void run() {
            this.f4180a.m6442r();
        }
    }

    class C12369 implements Runnable {
        final /* synthetic */ SyncManager f4181a;

        C12369(SyncManager syncManager) {
            this.f4181a = syncManager;
        }

        public void run() {
            if (this.f4181a.f4220x == SyncMode.BG_WAITING) {
                this.f4181a.m6379a(SyncMode.BG_DRAINING);
            }
        }
    }

    private enum SyncMode {
        RUNNING,
        RUNNING_ONE_SYNC,
        STOPPED,
        BG_DRAINING,
        BG_WAITING,
        DISABLED
    }

    public interface C1237a {
        void mo910a(Person person);
    }

    public interface C1238b {
        void mo1045a();

        void mo1046b();
    }

    public interface C1239c {
        void mo911a(ResponseStatus responseStatus, List<Fleet> list);
    }

    public static SyncManager m6377a(Context context) {
        if (f4189a == null) {
            f4189a = new SyncManager(context);
        }
        return f4189a;
    }

    private SyncManager(Context context) {
        this.f4217u.m6663a((C1240a) this);
        this.f4201e = OurApplication.m6285g();
        this.f4202f = OurApplication.m6287i();
        this.f4204h = OurApplication.m6286h();
        this.f4203g = OurApplication.m6284f();
        this.f4205i = OurApplication.m6292n();
        this.f4206j = OurApplication.m6294p();
        this.f4207k = OurApplication.m6296r();
        this.f4208l = OurApplication.m6301w();
        this.f4209m = OurApplication.m6262S();
        this.f4210n = OurApplication.m6269Z();
        this.f4211o = OurApplication.m6256M();
        this.f4216t = DescribeClientRequest.newBuilder().m13545d(C2291k.m11224c(context)).m13538a(C2291k.m11219a()).m13540b(C2291k.m11222b()).m13542c(C2291k.m11223c()).m13547e(C2291k.m11220a(context)).m13543c();
        this.f4218v = aa.m6626a(context);
        this.f4203g.m10446a(this.f4194D);
        this.f4204h.m6311a(this.f4195E);
        this.f4201e.m12184a(this.f4193C);
        this.f4191A = m6375F();
        this.f4200d.post(new C12358(this));
    }

    private static C2119a m6436l() {
        return OurApplication.m6291m();
    }

    private static EventManager m6437m() {
        return OurApplication.m6295q();
    }

    private static C1736b m6438n() {
        return OurApplication.m6296r();
    }

    private static C2226q m6439o() {
        return OurApplication.m6297s();
    }

    private static C2098i m6440p() {
        return OurApplication.m6299u();
    }

    private static C2103j m6441q() {
        return OurApplication.ae();
    }

    private void m6379a(SyncMode syncMode) {
        if (syncMode != this.f4220x) {
            C2134e.m10676b("TT-SyncManager", "Entering sync mode " + syncMode);
            SyncMode syncMode2 = this.f4220x;
            this.f4220x = syncMode;
            switch (this.f4220x) {
                case RUNNING:
                    m6445u();
                    if (syncMode2 != SyncMode.RUNNING_ONE_SYNC) {
                        m6443s();
                    }
                    this.f4215s.m11187a();
                    this.f4215s.m11190d();
                    break;
                case RUNNING_ONE_SYNC:
                    m6445u();
                    m6443s();
                    this.f4215s.m11187a();
                    this.f4215s.m11190d();
                    break;
                case STOPPED:
                case DISABLED:
                    m6445u();
                    m6447w();
                    m6450z();
                    this.f4215s.m11187a();
                    break;
                case BG_DRAINING:
                    m6445u();
                    m6448x();
                    break;
                case BG_WAITING:
                    m6446v();
                    m6448x();
                    break;
                default:
                    throw new RuntimeException("Unhandled sync mode: " + this.f4220x);
            }
            m6372C();
        }
    }

    private void m6442r() {
        if (this.f4220x == SyncMode.DISABLED) {
            C2134e.m10680d("TT-SyncManager", "SyncManager has been disabled");
        } else if (this.f4220x == SyncMode.RUNNING_ONE_SYNC) {
        } else {
            if (this.f4203g.m10447a() || this.f4204h.m6312a()) {
                m6379a(SyncMode.RUNNING);
            } else if (this.f4220x != SyncMode.BG_DRAINING && this.f4220x != SyncMode.BG_WAITING) {
                m6379a(SyncMode.BG_DRAINING);
            }
        }
    }

    private void m6443s() {
        this.f4222z = true;
        m6447w();
    }

    public void m6451a() {
        m6379a(SyncMode.RUNNING_ONE_SYNC);
    }

    public void m6489b() {
        this.f4221y = 0;
        if (this.f4220x != SyncMode.RUNNING) {
            m6451a();
        } else {
            m6372C();
        }
    }

    private void m6444t() {
        this.f4200d.removeCallbacks(this.f4192B);
        this.f4200d.postDelayed(this.f4192B, 150);
    }

    private void m6445u() {
        this.f4200d.removeCallbacks(this.f4197G);
    }

    private void m6446v() {
        m6445u();
        this.f4200d.postDelayed(this.f4197G, 900000);
    }

    private void m6447w() {
        this.f4200d.removeCallbacks(this.f4198H);
    }

    private void m6448x() {
        m6447w();
        this.f4200d.postDelayed(this.f4198H, 20000);
    }

    public void m6462a(C1239c c1239c) {
        this.f4212p.add(c1239c);
    }

    public void m6491b(C1239c c1239c) {
        this.f4212p.remove(c1239c);
    }

    private void m6411a(ResponseStatus responseStatus, List<Fleet> list) {
        if (!this.f4212p.isEmpty()) {
            for (C1239c a : (C1239c[]) this.f4212p.toArray(new C1239c[this.f4212p.size()])) {
                a.mo911a(responseStatus, list);
            }
        }
    }

    public void m6461a(C1238b c1238b) {
        this.f4213q.add(c1238b);
    }

    private void m6449y() {
        if (!this.f4213q.isEmpty()) {
            for (C1238b c1238b : (C1238b[]) this.f4213q.toArray(new C1238b[this.f4213q.size()])) {
                if (this.f4191A) {
                    c1238b.mo1046b();
                } else {
                    c1238b.mo1045a();
                }
            }
        }
    }

    public void m6460a(C1237a c1237a) {
        this.f4214r.add(c1237a);
    }

    public void m6490b(C1237a c1237a) {
        this.f4214r.remove(c1237a);
    }

    private void m6427b(Person person) {
        if (!this.f4214r.isEmpty()) {
            for (C1237a a : (C1237a[]) this.f4214r.toArray(new C1237a[this.f4214r.size()])) {
                a.mo910a(person);
            }
        }
    }

    private void m6383a(C1767f c1767f) {
        this.f4217u.m6664a(c1767f);
    }

    private void m6450z() {
        C1263c b = this.f4217u.m6667b();
        if (b != null) {
            this.f4219w.addFirst(b.m6653a());
        }
    }

    private void m6425b(Reason reason) {
        this.f4201e.m12186a(null, reason);
        this.f4205i.m11014b(-1);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo909a(com.bigroad.ttb.android.C1263c r7) {
        /*
        r6 = this;
        r1 = 1;
        r0 = r7.m6655b();
        r2 = r7.m6656c();
        r3 = com.bigroad.ttb.android.SyncManager.C12272.f4174c;
        r4 = r0.ordinal();
        r3 = r3[r4];
        switch(r3) {
            case 1: goto L_0x0047;
            case 2: goto L_0x01f6;
            case 3: goto L_0x01f6;
            case 4: goto L_0x01f6;
            case 5: goto L_0x01f6;
            case 6: goto L_0x0223;
            case 7: goto L_0x0223;
            case 8: goto L_0x0223;
            default: goto L_0x0014;
        };
    L_0x0014:
        r2 = "TT-SyncManager";
        r3 = new java.lang.StringBuilder;
        r3.<init>();
        r4 = "Request failed with unexpected status ";
        r3 = r3.append(r4);
        r0 = r3.append(r0);
        r3 = "; aborting";
        r0 = r0.append(r3);
        r0 = r0.toString();
        com.bigroad.ttb.android.logging.C2134e.m10680d(r2, r0);
        r0 = r6.f4215s;
        r0.m11190d();
    L_0x0037:
        r0 = r1;
    L_0x0038:
        if (r0 == 0) goto L_0x0043;
    L_0x003a:
        r0 = r6.f4218v;
        r1 = r7.m6653a();
        r0.m6631a(r1);
    L_0x0043:
        r6.m6372C();
        return;
    L_0x0047:
        r0 = r6.f4215s;
        r0.m11190d();
        r0 = r2.getStatus();
        r3 = com.bigroad.ttb.protocol.TTProtocol.ResponseStatus.RS_SUCCESS;
        if (r0 == r3) goto L_0x0078;
    L_0x0054:
        r0 = "TT-SyncManager";
        r3 = new java.lang.StringBuilder;
        r3.<init>();
        r4 = "Request failed with status ";
        r3 = r3.append(r4);
        r2 = r2.getStatus();
        r2 = r3.append(r2);
        r3 = "; dropping";
        r2 = r2.append(r3);
        r2 = r2.toString();
        com.bigroad.ttb.android.logging.C2134e.m10682e(r0, r2);
        r0 = r1;
        goto L_0x0038;
    L_0x0078:
        r0 = r2.getResponseList();
        r2 = r0.iterator();
    L_0x0080:
        r0 = r2.hasNext();
        if (r0 == 0) goto L_0x01f3;
    L_0x0086:
        r0 = r2.next();
        r0 = (com.bigroad.ttb.protocol.TTProtocol.ResponseUnion) r0;
        r3 = com.bigroad.ttb.android.SyncManager.C12272.f4173b;
        r4 = r0.getRequestType();
        r4 = r4.ordinal();
        r3 = r3[r4];
        switch(r3) {
            case 1: goto L_0x0080;
            case 2: goto L_0x00b8;
            case 3: goto L_0x00c0;
            case 4: goto L_0x00c8;
            case 5: goto L_0x00d0;
            case 6: goto L_0x00d8;
            case 7: goto L_0x00e0;
            case 8: goto L_0x00e8;
            case 9: goto L_0x00f0;
            case 10: goto L_0x00f8;
            case 11: goto L_0x0100;
            case 12: goto L_0x0109;
            case 13: goto L_0x0112;
            case 14: goto L_0x011b;
            case 15: goto L_0x0124;
            case 16: goto L_0x012d;
            case 17: goto L_0x0136;
            case 18: goto L_0x013f;
            case 19: goto L_0x0148;
            case 20: goto L_0x0151;
            case 21: goto L_0x015a;
            case 22: goto L_0x0163;
            case 23: goto L_0x016c;
            case 24: goto L_0x0175;
            case 25: goto L_0x017e;
            case 26: goto L_0x0187;
            case 27: goto L_0x0190;
            case 28: goto L_0x0199;
            case 29: goto L_0x01a2;
            case 30: goto L_0x01ab;
            case 31: goto L_0x01b4;
            case 32: goto L_0x01bd;
            case 33: goto L_0x01c6;
            case 34: goto L_0x01cf;
            case 35: goto L_0x01d8;
            case 36: goto L_0x01e1;
            case 37: goto L_0x01ea;
            default: goto L_0x009b;
        };
    L_0x009b:
        r3 = "TT-SyncManager";
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r5 = "Received unhandled response type: ";
        r4 = r4.append(r5);
        r0 = r0.getRequestType();
        r0 = r4.append(r0);
        r0 = r0.toString();
        com.bigroad.ttb.android.logging.C2134e.m10682e(r3, r0);
        goto L_0x0080;
    L_0x00b8:
        r0 = r0.getDescribeClient();
        r6.m6400a(r0);
        goto L_0x0080;
    L_0x00c0:
        r0 = r0.getBreadcrumb();
        r6.m6388a(r0);
        goto L_0x0080;
    L_0x00c8:
        r0 = r0.getSignIn();
        r6.m6418a(r0);
        goto L_0x0080;
    L_0x00d0:
        r0 = r0.getLookupTruck();
        r6.m6407a(r0);
        goto L_0x0080;
    L_0x00d8:
        r0 = r0.getCreateEvent();
        r6.m6395a(r0);
        goto L_0x0080;
    L_0x00e0:
        r0 = r0.getSync();
        r6.m6419a(r0, r7);
        goto L_0x0080;
    L_0x00e8:
        r0 = r0.getListPeople();
        r6.m6405a(r0);
        goto L_0x0080;
    L_0x00f0:
        r0 = r0.getConversation();
        r6.m6393a(r0);
        goto L_0x0080;
    L_0x00f8:
        r0 = r0.getSendMessage();
        r6.m6413a(r0);
        goto L_0x0080;
    L_0x0100:
        r0 = r0.getAckMessage();
        r6.m6385a(r0);
        goto L_0x0080;
    L_0x0109:
        r0 = r0.getReverseGeocode();
        r6.m6412a(r0);
        goto L_0x0080;
    L_0x0112:
        r0 = r0.getUpdatePerson();
        r6.m6422a(r0);
        goto L_0x0080;
    L_0x011b:
        r0 = r0.getUpdateEvent();
        r6.m6421a(r0);
        goto L_0x0080;
    L_0x0124:
        r0 = r0.getDeleteEvent();
        r6.m6399a(r0);
        goto L_0x0080;
    L_0x012d:
        r0 = r0.getCoalesceEvent();
        r6.m6391a(r0);
        goto L_0x0080;
    L_0x0136:
        r0 = r0.getSetDailyLog();
        r6.m6415a(r0);
        goto L_0x0080;
    L_0x013f:
        r0 = r0.getEulaAcknowledgement();
        r6.m6402a(r0);
        goto L_0x0080;
    L_0x0148:
        r0 = r0.getDailyLogShare();
        r6.m6396a(r0);
        goto L_0x0080;
    L_0x0151:
        r0 = r0.getSetDvir();
        r6.m6417a(r0);
        goto L_0x0080;
    L_0x015a:
        r0 = r0.getDeleteDvir();
        r6.m6398a(r0);
        goto L_0x0080;
    L_0x0163:
        r0 = r0.getSetDvirInspection();
        r6.m6416a(r0);
        goto L_0x0080;
    L_0x016c:
        r0 = r0.getDeleteDvirInspection();
        r6.m6397a(r0);
        goto L_0x0080;
    L_0x0175:
        r0 = r0.getUpdateTruck();
        r6.m6423a(r0);
        goto L_0x0080;
    L_0x017e:
        r0 = r0.getListTrucks();
        r6.m6406a(r0);
        goto L_0x0080;
    L_0x0187:
        r0 = r0.getAutoSigninAccount();
        r6.m6387a(r0);
        goto L_0x0080;
    L_0x0190:
        r0 = r0.getSetAutoDailyLogTruck();
        r6.m6414a(r0);
        goto L_0x0080;
    L_0x0199:
        r0 = r0.getRemoteLogEvent();
        r6.m6408a(r0);
        goto L_0x0080;
    L_0x01a2:
        r0 = r0.getVarSync();
        r6.m6382a(r7, r0);
        goto L_0x0080;
    L_0x01ab:
        r0 = r0.getListDashLinkFirmwareVersions();
        r6.m6404a(r0);
        goto L_0x0080;
    L_0x01b4:
        r0 = r0.getUpdateEobrDrivingEvent();
        r6.m6420a(r0);
        goto L_0x0080;
    L_0x01bd:
        r0 = r0.getClaimUnidentifiedEvents();
        r6.m6390a(r0);
        goto L_0x0080;
    L_0x01c6:
        r0 = r0.getCreateEobrEvent();
        r6.m6394a(r0);
        goto L_0x0080;
    L_0x01cf:
        r0 = r0.getEobrStopDriving();
        r6.m6401a(r0);
        goto L_0x0080;
    L_0x01d8:
        r0 = r0.getGenxEntrySync();
        r6.m6403a(r0);
        goto L_0x0080;
    L_0x01e1:
        r0 = r0.getAcknowledgeCorrection();
        r6.m6386a(r0);
        goto L_0x0080;
    L_0x01ea:
        r0 = r0.getCertifyLog();
        r6.m6389a(r0);
        goto L_0x0080;
    L_0x01f3:
        r0 = r1;
        goto L_0x0038;
    L_0x01f6:
        r1 = "TT-SyncManager";
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r3 = "Request failed with status ";
        r2 = r2.append(r3);
        r0 = r2.append(r0);
        r2 = "; retrying";
        r0 = r0.append(r2);
        r0 = r0.toString();
        com.bigroad.ttb.android.logging.C2134e.m10673a(r1, r0);
        r0 = r7.m6653a();
        r6.m6433c(r0);
        r0 = r6.f4215s;
        r0.m11188b();
        r0 = 0;
        goto L_0x0038;
    L_0x0223:
        r0 = r6.f4215s;
        r0.m11190d();
        r0 = "TT-SyncManager";
        r2 = "Request failed - authentication required; aborting";
        com.bigroad.ttb.android.logging.C2134e.m10680d(r0, r2);
        r0 = r7.m6653a();
        r0 = r6.m6431b(r0);
        if (r0 == 0) goto L_0x0037;
    L_0x0239:
        r0 = "TT-SyncManager";
        r2 = "Credentials rejected by server - signing out locally";
        com.bigroad.ttb.android.logging.C2134e.m10678c(r0, r2);
        r0 = com.bigroad.shared.UserAuthenticationChangeBits.Reason.BAD_OR_MISSING_CREDENTIALS;
        r6.m6425b(r0);
        r0 = r1;
        goto L_0x0038;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bigroad.ttb.android.SyncManager.a(com.bigroad.ttb.android.c):void");
    }

    private boolean m6431b(C1767f c1767f) {
        try {
            Request parseFrom = Request.parseFrom(c1767f.m8589d());
            if (!parseFrom.hasToken()) {
                return false;
            }
            AuthToken token = parseFrom.getToken();
            if (token.getPersonId() == this.f4201e.m12202d() && Arrays.equals(token.getToken().m19091d(), this.f4201e.m12209e())) {
                return true;
            }
            return false;
        } catch (InvalidProtocolBufferException e) {
            return false;
        }
    }

    private void m6400a(DescribeClientResponse describeClientResponse) {
        String newSwRelease = describeClientResponse.getNewSwRelease();
        if (!am.m4188a((CharSequence) newSwRelease)) {
            this.f4201e.m12204d(newSwRelease);
        }
    }

    private void m6388a(BreadcrumbResponse breadcrumbResponse) {
    }

    private void m6418a(SignInResponse signInResponse) {
        ResponseStatus status = signInResponse.getStatus();
        Collection fleetList = signInResponse.getFleetList();
        if (signInResponse.hasToken()) {
            this.f4201e.m12186a(signInResponse.getToken(), Reason.EXPLICIT_SIGN_IN);
        }
        if (signInResponse.hasPerson()) {
            this.f4201e.m12188a(signInResponse.getPerson());
        }
        switch (status) {
            case RS_SUCCESS:
                if (signInResponse.hasPerson()) {
                    Person person = signInResponse.getPerson();
                    String emailAddress = person.getEmailAddress();
                    this.f4201e.m12189a(emailAddress);
                    this.f4211o.m8376a(emailAddress);
                    if (C2306y.m11275b(person)) {
                        this.f4201e.m12197b(true);
                    }
                }
                if (fleetList.size() == 1) {
                    this.f4205i.m11014b(((Fleet) fleetList.get(0)).getFleetId());
                }
                this.f4206j.m6565a(signInResponse.getTruckList());
                this.f4205i.m11011a(fleetList);
                break;
            case RS_FLEET_NOT_FOUND:
            case RS_TOO_MANY_FLEETS:
                this.f4205i.m11011a(fleetList);
                break;
        }
        m6411a(status, signInResponse.getFleetList());
        if (status == ResponseStatus.RS_SUCCESS) {
            m6443s();
        }
    }

    private void m6407a(LookupTruckResponse lookupTruckResponse) {
        if (lookupTruckResponse.hasTruck()) {
            this.f4206j.m6564a(lookupTruckResponse.getTruck());
        }
    }

    private void m6395a(CreateEventResponse createEventResponse) {
        m6443s();
    }

    private void m6421a(UpdateEventResponse updateEventResponse) {
        m6443s();
    }

    private void m6399a(DeleteEventResponse deleteEventResponse) {
        m6443s();
    }

    private void m6391a(CoalesceEventResponse coalesceEventResponse) {
        m6443s();
    }

    private void m6415a(SetDailyLogResponse setDailyLogResponse) {
        m6443s();
    }

    private void m6389a(CertifyLogResponse certifyLogResponse) {
        m6443s();
    }

    private void m6402a(EulaAcknowledgementResponse eulaAcknowledgementResponse) {
        m6443s();
    }

    private void m6396a(DailyLogShareResponse dailyLogShareResponse) {
    }

    private void m6392a(ConversationData conversationData) {
        if (this.f4201e.m12213g() < 0) {
            C2134e.m10682e("TT-SyncManager", "No fleet - ignoring conversation response");
            return;
        }
        m6440p().m10512a(conversationData);
        if (conversationData.getServerHasMore()) {
            m6444t();
        }
    }

    private void m6430b(List<ConversationData> list) {
        if (!list.isEmpty()) {
            if (this.f4201e.m12213g() < 0) {
                C2134e.m10682e("TT-SyncManager", "No fleet - ignoring conversation response");
                return;
            }
            m6440p().m10513a((List) list);
            for (ConversationData serverHasMore : list) {
                if (serverHasMore.getServerHasMore()) {
                    m6444t();
                    return;
                }
            }
        }
    }

    private void m6419a(SyncResponse syncResponse, C1263c c1263c) {
        if (m6374E()) {
            C2134e.m10676b("TT-SyncManager", "Ignoring sync response while draining pending requests from queue.");
            m6443s();
            return;
        }
        this.f4209m.m6100a(syncResponse, c1263c);
        if (syncResponse.hasMobileAppDiagnosticConfig()) {
            DiagnosticConfig mobileAppDiagnosticConfig = syncResponse.getMobileAppDiagnosticConfig();
            if (mobileAppDiagnosticConfig.hasFlags()) {
                this.f4201e.m12199c(mobileAppDiagnosticConfig.getFlags());
            } else {
                this.f4201e.m12159D();
            }
        } else {
            this.f4201e.m12159D();
        }
        if (syncResponse.hasEventDigest() && syncResponse.hasEventList()) {
            m6437m().m10016a(syncResponse.getEventDigest(), syncResponse.getEventList());
        }
        if (syncResponse.hasDailyLogDigest() && syncResponse.hasDailyLogList()) {
            m6438n().m8477a(syncResponse.getDailyLogDigest(), syncResponse.getDailyLogList());
        }
        if (syncResponse.hasDvirListDigest() && syncResponse.hasDvirList()) {
            m6439o().m10977a(syncResponse.getDvirListDigest(), syncResponse.getDvirList());
        }
        if (syncResponse.hasTruck()) {
            this.f4206j.m6564a(syncResponse.getTruck());
        }
        if (syncResponse.hasPerson()) {
            this.f4201e.m12188a(syncResponse.getPerson());
        }
        if (syncResponse.hasFleetMembership()) {
            this.f4201e.m12187a(syncResponse.getFleetMembership());
        }
        if (syncResponse.hasFleetDigest() && syncResponse.hasFleetList()) {
            this.f4205i.m11010a(syncResponse.getFleetDigest(), syncResponse.getFleetList());
        }
        if (syncResponse.hasCorrectionListDigest() && syncResponse.hasCorrectionList()) {
            m6441q().m10535a(syncResponse.getCorrectionListDigest(), syncResponse.getCorrectionList());
        }
        m6430b(syncResponse.getConversationDataList());
        this.f4206j.m6569b(syncResponse.getTruckGapList());
        if (syncResponse.hasRecommendedFleetId() && this.f4201e.m12213g() < 0) {
            long recommendedFleetId = syncResponse.getRecommendedFleetId();
            C2134e.m10678c("TT-SyncManager", "Switching to fleet " + recommendedFleetId + " by server recommendation");
            this.f4205i.m11014b(recommendedFleetId);
            m6504i();
            m6443s();
        }
        this.f4205i.m11012a(syncResponse.getIsTrialFleet());
        if (!this.f4222z) {
            OurApplication.m6264U().m9807y();
            OurApplication.m6265V().m9407z();
        }
    }

    private void m6405a(ListPeopleResponse listPeopleResponse) {
        if (listPeopleResponse.getFleetCount() != 1) {
            C2134e.m10682e("TT-SyncManager", "ListPeopleResponse with unexpected fleet count " + listPeopleResponse.getFleetCount());
            return;
        }
        long g = this.f4201e.m12213g();
        Fleet fleet = listPeopleResponse.getFleet(0);
        if (fleet.getFleetId() != g) {
            C2134e.m10680d("TT-SyncManager", "Our fleetId=" + g + " doesn't match " + fleet.getFleetId() + ": ignoring people list");
            return;
        }
        OurApplication.m6293o().m12141a(listPeopleResponse.getPersonList());
        OurApplication.m6257N().m11028a(listPeopleResponse.getPersonGroupList());
    }

    private void m6393a(ConversationResponse conversationResponse) {
        if (conversationResponse.hasConversationData()) {
            m6392a(conversationResponse.getConversationData());
        }
    }

    private void m6413a(SendMessageResponse sendMessageResponse) {
        if (sendMessageResponse.hasConversationData()) {
            m6392a(sendMessageResponse.getConversationData());
        }
    }

    private void m6385a(AckMessageResponse ackMessageResponse) {
        if (ackMessageResponse.hasConversationData()) {
            m6392a(ackMessageResponse.getConversationData());
        }
    }

    private void m6412a(ReverseGeocodeResponse reverseGeocodeResponse) {
        m6436l().m10617a(reverseGeocodeResponse.getGeocodeList());
    }

    private void m6422a(UpdatePersonResponse updatePersonResponse) {
        m6443s();
    }

    private void m6417a(SetDvirResponse setDvirResponse) {
        m6443s();
    }

    private void m6398a(DeleteDvirResponse deleteDvirResponse) {
        m6443s();
    }

    private void m6416a(SetDvirInspectionResponse setDvirInspectionResponse) {
        m6443s();
    }

    private void m6397a(DeleteDvirInspectionResponse deleteDvirInspectionResponse) {
        m6443s();
    }

    private void m6423a(UpdateTruckResponse updateTruckResponse) {
        m6443s();
    }

    private void m6406a(ListTrucksResponse listTrucksResponse) {
        long g = this.f4201e.m12213g();
        if (!listTrucksResponse.hasFleetId() || listTrucksResponse.getFleetId() == g) {
            OurApplication.m6294p().m6565a(listTrucksResponse.getTruckList());
        } else {
            C2134e.m10680d("TT-SyncManager", "Our fleetId=" + g + " doesn't match " + listTrucksResponse.getFleetId() + ": ignoring truck list");
        }
    }

    private void m6387a(AutoSignInAccountResponse autoSignInAccountResponse) {
        Person autoSigninPerson = autoSignInAccountResponse.getAutoSigninPerson();
        if (!autoSignInAccountResponse.getAutoSigninIsMostRecentLogin() || C2306y.m11275b(autoSigninPerson)) {
            autoSigninPerson = null;
        }
        m6427b(autoSigninPerson);
    }

    private void m6414a(SetAutoDailyLogTruckResponse setAutoDailyLogTruckResponse) {
        m6443s();
    }

    private void m6382a(C1263c c1263c, VarSyncResponse varSyncResponse) {
        try {
            for (RequestUnion requestUnion : Request.parseFrom(c1263c.m6653a().m8589d()).getRequestList()) {
                if (requestUnion.getRequestType() == RequestType.VAR_SYNC && requestUnion.hasVarSync()) {
                    OurApplication.m6264U().m9778a(requestUnion.getVarSync());
                }
            }
        } catch (InvalidProtocolBufferException e) {
        }
        OurApplication.m6264U().m9781a(varSyncResponse.getDashLinkId().m19091d(), varSyncResponse.getMinExpectedVarPage());
    }

    private void m6408a(RemoteLogEventResponse remoteLogEventResponse) {
    }

    private void m6404a(ListDashLinkFirmwareVersionsResponse listDashLinkFirmwareVersionsResponse) {
        OurApplication.m6267X().m9593a(listDashLinkFirmwareVersionsResponse.getDashLinkFirmwareVersionList());
    }

    private void m6420a(UpdateEobrDrivingEventResponse updateEobrDrivingEventResponse) {
        m6443s();
    }

    private void m6390a(ClaimUnidentifiedEventsResponse claimUnidentifiedEventsResponse) {
        m6443s();
    }

    private void m6394a(CreateEobrEventResponse createEobrEventResponse) {
    }

    private void m6401a(EobrStopDrivingResponse eobrStopDrivingResponse) {
        m6443s();
    }

    private void m6403a(GenxEntrySyncResponse genxEntrySyncResponse) {
        OurApplication.m6265V().m9381a(genxEntrySyncResponse.getSerialNumber(), genxEntrySyncResponse.getEntryIdsList());
        OurApplication.m6265V().m9380a(genxEntrySyncResponse.getSerialNumber(), genxEntrySyncResponse.getMinExpectedEntryId());
    }

    private void m6386a(AcknowledgeCorrectionResponse acknowledgeCorrectionResponse) {
        m6443s();
    }

    public static Request m6378a(RequestType requestType, C2742a c2742a) {
        c2742a.m14999a(requestType);
        C2474y g = OurApplication.m6285g();
        C2739a a = Request.newBuilder().m14896a(C3642c.m19078a(g.m12191a())).m14892a(f4190b).m14895a(c2742a);
        AuthToken f = g.m12210f();
        if (f != null) {
            a.m14893a(f);
        }
        return a.m14903c();
    }

    private void m6409a(Request request) {
        if (this.f4220x != SyncMode.DISABLED) {
            this.f4218v.m6632a(request);
            m6372C();
        }
    }

    private void m6429b(RequestType requestType, C2742a c2742a) {
        m6409a(m6378a(requestType, c2742a));
    }

    private void m6433c(C1767f c1767f) {
        this.f4219w.addFirst(c1767f);
        m6372C();
    }

    private void m6384a(C1767f c1767f, boolean z) {
        if (this.f4220x != SyncMode.DISABLED) {
            this.f4219w.add(c1767f);
            if (z) {
                m6372C();
            }
        }
    }

    private void m6410a(Request request, boolean z) {
        m6384a(new C1767f(-1, request.toByteArray()), z);
    }

    private void m6428b(Request request) {
        m6410a(request, true);
    }

    private void m6434c(RequestType requestType, C2742a c2742a) {
        m6428b(m6378a(requestType, c2742a));
    }

    private void m6370A() {
        C2622a newBuilder = DescribeClientRequest.newBuilder(this.f4216t);
        CharSequence a = this.f4208l.m6240a();
        if (!am.m4188a(a)) {
            newBuilder.m13548f(a);
        }
        m6410a(m6378a(RequestType.DESCRIBE_CLIENT, RequestUnion.newBuilder().m14979a(newBuilder)), false);
    }

    private void m6371B() {
        C2778a newBuilder = SyncRequest.newBuilder();
        long g = this.f4201e.m12213g();
        if (g >= 0) {
            newBuilder.m15490a(g);
        }
        C3642c a = m6437m().m10006a();
        if (a != null) {
            newBuilder.m15495a(a);
        }
        a = m6438n().m8472a();
        if (a != null) {
            newBuilder.m15499b(a);
        }
        a = m6439o().m10972a();
        if (a != null) {
            newBuilder.m15505d(a);
        }
        a = this.f4205i.m11008a();
        if (a != null) {
            newBuilder.m15502c(a);
        }
        a = m6441q().m10532a();
        if (a != null) {
            newBuilder.m15507e(a);
        }
        Truck f = this.f4206j.m6578f();
        if (f != null) {
            newBuilder.m15498b(f.getTruckId());
        }
        for (C1769h c1769h : this.f4202f.m8797l()) {
            newBuilder.m15491a(Conversation.newBuilder().m12747a(c1769h.m8597b()).m12751b(c1769h.m8598d()));
        }
        if (newBuilder.m15515l() == 0) {
            newBuilder.m15491a(Conversation.newBuilder().m12747a(0).m12751b(0));
        }
        for (Truck f2 : this.f4207k.m8495i()) {
            C2784a a2 = TruckGap.newBuilder().m15618a(f2.getTruckNumber());
            byte[] j = this.f4206j.m6587j(f2.getTruckNumber());
            if (j != null) {
                a2.m15616a(C3642c.m19078a(j));
            }
            newBuilder.m15494a(a2.m15621c());
        }
        m6410a(m6378a(RequestType.SYNC, RequestUnion.newBuilder().m15015a(newBuilder)), false);
    }

    private int m6376a(RequestType requestType) {
        if (this.f4217u.m6666a(requestType)) {
            m6450z();
        }
        Iterator it = this.f4219w.iterator();
        int i = 0;
        while (it.hasNext()) {
            if (aa.m6628a((C1767f) it.next(), requestType)) {
                it.remove();
                i++;
            }
        }
        m6372C();
        return i;
    }

    private void m6372C() {
        if (this.f4220x != SyncMode.STOPPED && this.f4220x != SyncMode.BG_WAITING && !this.f4217u.m6665a() && !this.f4215s.m11189c()) {
            if (this.f4219w.isEmpty()) {
                this.f4215s.m11190d();
            }
            if (this.f4219w.isEmpty()) {
                C1767f a = this.f4218v.m6629a();
                if (a != null) {
                    this.f4219w.add(a);
                }
            }
            if (this.f4219w.isEmpty()) {
                long c = this.f4210n.mo915c();
                if (this.f4221y == 0 || c - this.f4221y >= 86400000) {
                    this.f4221y = c;
                    m6370A();
                } else if (this.f4222z && this.f4201e.m12202d() >= 0) {
                    this.f4222z = false;
                    m6371B();
                    m6448x();
                }
            }
            if (!this.f4219w.isEmpty()) {
                m6383a((C1767f) this.f4219w.removeFirst());
            } else if (this.f4220x == SyncMode.BG_DRAINING) {
                m6379a(SyncMode.BG_WAITING);
            } else if (this.f4220x == SyncMode.RUNNING_ONE_SYNC) {
                m6379a(SyncMode.RUNNING);
                m6442r();
            }
            m6373D();
        }
    }

    private void m6373D() {
        boolean F = m6375F();
        if (F != this.f4191A) {
            this.f4191A = F;
            m6449y();
        }
    }

    private boolean m6374E() {
        return (this.f4219w.isEmpty() && this.f4218v.m6633b()) ? false : true;
    }

    private boolean m6375F() {
        return this.f4217u.m6665a() || m6374E();
    }

    public boolean m6498c() {
        return this.f4191A;
    }

    public void m6457a(Location location) {
        if (location != null) {
            int round = (int) Math.round(location.getLongitude() * 1000000.0d);
            C2521a b = Breadcrumb.newBuilder().m12527a(location.getTime()).m12526a((int) Math.round(location.getLatitude() * 1000000.0d)).m12531b(round);
            if (location.hasAccuracy()) {
                b.m12525a(location.getAccuracy());
            }
            if (location.hasSpeed()) {
                b.m12533c(Math.round(location.getSpeed() * 100.0f));
            }
            C2524a a = BreadcrumbRequest.newBuilder().m12554a(b);
            long d = this.f4201e.m12202d();
            if (d >= 0) {
                a.m12559b(d);
            }
            Truck f = this.f4206j.m6578f();
            if (f != null) {
                a.m12553a(f.getTruckId());
            }
            m6429b(RequestType.BREADCRUMB, RequestUnion.newBuilder().m14955a(a));
        }
    }

    private void m6424a(String str, String str2, long j) {
        m6501f();
        String a = am.m4185a(str2);
        C2774a a2 = SignInRequest.newBuilder().m15428a(AuthCredential.newBuilder().m12410a(a).m12412b(am.m4185a(str)));
        if (j >= 0) {
            a2.m15427a(j);
        }
        m6434c(RequestType.SIGN_IN, RequestUnion.newBuilder().m15013a(a2));
    }

    public void m6483a(String str, long j) {
        m6424a(str, this.f4201e.m12192b(), j);
    }

    public void m6499d() {
        m6424a(null, null, -1);
    }

    public void m6485a(String str, String str2, String str3, String str4) {
        m6501f();
        C2774a b = SignInRequest.newBuilder().m15428a(AuthCredential.newBuilder().m12410a("").m12412b("")).m15432a(str2).m15435b(str).m15436b(this.f4201e.m12227q());
        if (str3 != null) {
            b.m15438c(str3);
        }
        if (str4 != null) {
            b.m15441d(str4);
        }
        m6434c(RequestType.SIGN_IN, RequestUnion.newBuilder().m15013a(b));
    }

    public void m6482a(String str) {
        m6484a("", str);
    }

    public void m6484a(String str, String str2) {
        m6501f();
        C2774a b = SignInRequest.newBuilder().m15428a(AuthCredential.newBuilder().m12410a(am.m4185a(this.f4201e.m12192b())).m12412b(str)).m15435b(str2);
        long g = this.f4201e.m12213g();
        if (g >= 0) {
            b.m15427a(g);
        }
        m6434c(RequestType.SIGN_IN, RequestUnion.newBuilder().m15013a(b));
    }

    public void m6494b(String str) {
        m6495b("", str);
    }

    public void m6495b(String str, String str2) {
        m6501f();
        C2774a a = SignInRequest.newBuilder().m15428a(AuthCredential.newBuilder().m12410a(am.m4185a(this.f4201e.m12192b())).m12412b(str)).m15432a(str2);
        long g = this.f4201e.m12213g();
        if (g >= 0) {
            a.m15427a(g);
        }
        m6434c(RequestType.SIGN_IN, RequestUnion.newBuilder().m15013a(a));
    }

    public void m6500e() {
        m6501f();
        m6434c(RequestType.SIGN_IN, RequestUnion.newBuilder().m15013a(SignInRequest.newBuilder().m15428a(AuthCredential.newBuilder().m12410a(am.m4185a(this.f4201e.m12192b())).m12412b("")).m15433a(true)));
    }

    public void m6458a(Reason reason) {
        m6501f();
        m6425b(reason);
    }

    public void m6501f() {
        if (m6376a(RequestType.SIGN_IN) > 0) {
            m6411a(ResponseStatus.RS_REQUEST_CANCELLED, Collections.emptyList());
        }
    }

    public void m6474a(Truck truck) {
        m6475a(truck, false);
    }

    public void m6475a(Truck truck, boolean z) {
        if (truck == null || am.m4188a(truck.getTruckNumber())) {
            C2134e.m10682e("TT-SyncManager", "Unexpected attempt to lookup an empty truck");
            return;
        }
        long g = this.f4201e.m12213g();
        C2698a a = LookupTruckRequest.newBuilder().m14449a(truck.getTruckNumber());
        if (truck.hasTruckLicense()) {
            a.m14455b(truck.getTruckLicense());
        }
        if (truck.hasOdometerUnit()) {
            a.m14443a(truck.getOdometerUnit());
        }
        if (truck.hasVin()) {
            a.m14458c(truck.getVin());
        }
        if (truck.hasAssociatedDashLink()) {
            a.m14447a(truck.getAssociatedDashLink());
        }
        if (truck.getHasAobrd()) {
            a.m14450a(true);
        }
        if (truck.hasOdometerOffsets()) {
            a.m14446a(truck.getOdometerOffsets());
        }
        if (g >= 0) {
            a.m14444a(g);
        }
        if (truck.hasFirmwareOdometerAssociatedDashLink() && !z) {
            a.m14454b(truck.getFirmwareOdometerAssociatedDashLink());
        }
        if (truck.hasLastConnectedDashLink()) {
            a.m14457c(truck.getLastConnectedDashLink());
        }
        if (truck.hasSupportedBusTypes()) {
            a.m14452b(truck.getSupportedBusTypes());
        }
        m6429b(RequestType.LOOKUP_TRUCK, RequestUnion.newBuilder().m14995a(a));
    }

    public void m6471a(Event event, List<byte[]> list) {
        C2575a a = CreateEventRequest.newBuilder().m12957a(event);
        if (list != null) {
            for (byte[] a2 : list) {
                a.m12958a(C3642c.m19078a(a2));
            }
        }
        Request a3 = m6378a(RequestType.CREATE_EVENT, RequestUnion.newBuilder().m14967a(a));
        if (C1144s.m5759a(event) || !a3.getToken().getToken().m19090c()) {
            m6409a(a3);
        } else {
            C2134e.m10680d("TT-SyncManager", "Attempted to create diagnostic event without an AuthToken.");
        }
    }

    public void m6469a(Event event) {
        m6429b(RequestType.UPDATE_EVENT, RequestUnion.newBuilder().m15019a(UpdateEventRequest.newBuilder().m15682a(event)));
    }

    public void m6476a(C3642c c3642c) {
        m6429b(RequestType.DELETE_EVENT, RequestUnion.newBuilder().m14977a(DeleteEventRequest.newBuilder().m13467a(c3642c)));
    }

    public void m6492b(Event event) {
        m6429b(RequestType.COALESCE_EVENT, RequestUnion.newBuilder().m14961a(CoalesceEventRequest.newBuilder().m12686a(event)));
    }

    public void m6459a(C1142r c1142r) {
        c1142r.m5750a(this.f4196F);
    }

    public void m6466a(DailyLog dailyLog) {
        m6429b(RequestType.SET_DAILY_LOG, RequestUnion.newBuilder().m15007a(SetDailyLogRequest.newBuilder().m15305a(dailyLog).m15304a(this.f4201e.m12213g())));
    }

    public void m6470a(Event event, C3642c c3642c) {
        m6429b(RequestType.CERTIFY_LOG, RequestUnion.newBuilder().m14957a(CertifyLogRequest.newBuilder().m12597a(event).m12598a(c3642c)));
    }

    public void m6502g() {
        long g = this.f4201e.m12213g();
        if (g < 0) {
            C2134e.m10680d("TT-SyncManager", "Can't list people without a fleet");
            return;
        }
        m6434c(RequestType.LIST_PEOPLE, RequestUnion.newBuilder().m14991a(ListPeopleRequest.newBuilder().m14352a(g)));
    }

    public void m6454a(long j) {
        long d = this.f4201e.m12202d();
        long g = this.f4201e.m12213g();
        if (g < 0) {
            C2134e.m10682e("TT-SyncManager", "Can't start conversation without a fleet");
            return;
        }
        C2561a newBuilder = ConversationRequest.newBuilder();
        newBuilder.m12829a(ConversationParticipant.newBuilder().m12802a(d).m12806b(g).m12808c(0).m12811d(0));
        newBuilder.m12829a(ConversationParticipant.newBuilder().m12802a(j).m12806b(g).m12808c(0).m12811d(0));
        m6434c(RequestType.CONVERSATION, RequestUnion.newBuilder().m14963a(newBuilder));
    }

    public void m6472a(Message message) {
        C1769h c = this.f4202f.m8762c(message.getConversationId());
        m6429b(RequestType.SEND_MESSAGE, RequestUnion.newBuilder().m15003a(SendMessageRequest.newBuilder().m15219a(message).m15218a(c == null ? 0 : c.m8598d())));
    }

    public void m6455a(long j, long j2) {
        long g = this.f4201e.m12213g();
        if (g < 0) {
            C2134e.m10682e("TT-SyncManager", "Can't acknowledge a message without a fleet");
            return;
        }
        m6429b(RequestType.ACK_MESSAGE, RequestUnion.newBuilder().m14949a(AckMessageRequest.newBuilder().m12298a(j).m12302b(g).m12304c(j2)));
    }

    public void m6487a(List<LatLon> list) {
        m6434c(RequestType.REVERSE_GEOCODE, RequestUnion.newBuilder().m15001a(ReverseGeocodeRequest.newBuilder().mo1377a((Iterable) list)));
    }

    public void m6473a(Person person) {
        this.f4201e.m12195b(person);
        C2795a newBuilder = UpdatePersonRequest.newBuilder();
        newBuilder.m15722a(person);
        m6429b(RequestType.UPDATE_PERSON, RequestUnion.newBuilder().m15021a(newBuilder));
    }

    public void m6503h() {
        Person l = this.f4201e.m12222l();
        if (l == null) {
            C2134e.m10682e("TT-SyncManager", "Can't acknowledge EULA when not signed in");
            return;
        }
        this.f4201e.m12188a(Person.newBuilder(l).m14741e(true).m14733c());
        m6429b(RequestType.EULA_ACKNOWLEDGEMENT, RequestUnion.newBuilder().m14983a(EulaAcknowledgementRequest.newBuilder().m13785a(this.f4210n.mo913a())));
    }

    public void m6467a(DailyLogShare dailyLogShare) {
        m6429b(RequestType.DAILY_LOG_SHARE, RequestUnion.newBuilder().m14971a(DailyLogShareRequest.newBuilder().m13272a(dailyLogShare)));
    }

    public void m6468a(Dvir dvir) {
        m6429b(RequestType.SET_DVIR, RequestUnion.newBuilder().m15011a(SetDvirRequest.newBuilder().m15387a(dvir)));
    }

    public void m6493b(C3642c c3642c) {
        m6429b(RequestType.DELETE_DVIR, RequestUnion.newBuilder().m14975a(DeleteDvirRequest.newBuilder().m13429a(c3642c)));
    }

    public void m6478a(C3642c c3642c, DvirInspection dvirInspection) {
        m6429b(RequestType.SET_DVIR_INSPECTION, RequestUnion.newBuilder().m15009a(SetDvirInspectionRequest.newBuilder().m15347a(c3642c).m15345a(dvirInspection)));
    }

    public void m6497c(C3642c c3642c) {
        m6429b(RequestType.DELETE_DVIR_INSPECTION, RequestUnion.newBuilder().m14973a(DeleteDvirInspectionRequest.newBuilder().m13391a(c3642c)));
    }

    public void m6456a(long j, OdometerUnit odometerUnit) {
        Truck a = this.f4206j.m6552a(j);
        if (a != null) {
            this.f4206j.m6564a(Truck.newBuilder(a).m15580b(odometerUnit.m14669a()).m15592c());
        }
        m6429b(RequestType.UPDATE_TRUCK, RequestUnion.newBuilder().m15023a(UpdateTruckRequest.newBuilder().m15767a(j).m15766a(odometerUnit.m14669a())));
    }

    public void m6504i() {
        long g = this.f4201e.m12213g();
        C2694a newBuilder = ListTrucksRequest.newBuilder();
        if (g >= 0) {
            newBuilder.m14402a(g);
        }
        m6434c(RequestType.LIST_TRUCKS, RequestUnion.newBuilder().m14993a(newBuilder));
    }

    public void m6453a(int i, Iterable<AutoDailyLogTruck> iterable) {
        m6429b(RequestType.SET_AUTO_DAILY_LOG_TRUCK, RequestUnion.newBuilder().m15005a(SetAutoDailyLogTruckRequest.newBuilder().m15263a(i).mo1377a((Iterable) iterable)));
    }

    public void m6452a(int i, AutoDailyLogTruck autoDailyLogTruck) {
        m6453a(i, Collections.singleton(autoDailyLogTruck));
    }

    public void m6488a(byte[] bArr, List<VarPage> list, long j) {
        C2807a a = VarSyncRequest.newBuilder().m15857a(C3642c.m19078a(bArr)).m15854a(j);
        for (VarPage varPage : list) {
            a.m15855a(TTProtocol.VarPage.newBuilder().m15828a(varPage.m9607b()).m15830a(C3642c.m19078a(varPage.m9610c())).m15832a(varPage.m9611d()));
        }
        m6434c(RequestType.VAR_SYNC, RequestUnion.newBuilder().m15025a(a));
    }

    public void m6480a(Iterable<C2136g> iterable) {
        C2734a newBuilder = RemoteLogEventRequest.newBuilder();
        C2732a newBuilder2 = RemoteLogEvent.newBuilder();
        for (C2136g c2136g : iterable) {
            newBuilder2.m14821a().m14822a(c2136g.m10685c()).m14824a(C2138i.m10693b(c2136g.m10683a()).m4101b()).m14826a(c2136g.m10686d()).m14828b(c2136g.m10687e());
            newBuilder.m14849a(newBuilder2.m14830c());
        }
        m6409a(m6378a(RequestType.REMOTE_LOG_EVENT, RequestUnion.newBuilder().m14997a(newBuilder)));
    }

    public void m6505j() {
        m6434c(RequestType.LIST_DASH_LINK_FIRMWARE_VERSIONS, RequestUnion.newBuilder());
    }

    public void m6506k() {
        m6434c(RequestType.AUTO_SIGNIN_ACCOUNT, RequestUnion.newBuilder().m14953a(AutoSignInAccountRequest.newBuilder()));
    }

    public void m6477a(C3642c c3642c, long j, long j2) {
        m6434c(RequestType.UPDATE_EOBR_DRIVING_EVENT, RequestUnion.newBuilder().m15017a(UpdateEobrDrivingEventRequest.newBuilder().m15644a(c3642c).m15642a(j).m15647b(j2)));
    }

    public void m6481a(Iterable<Event> iterable, Iterable<EventChangeListEntry> iterable2) {
        m6429b(RequestType.CLAIM_UNIDENTIFIED_EVENTS, RequestUnion.newBuilder().m14959a(ClaimUnidentifiedEventsRequest.newBuilder().mo1377a((Iterable) iterable).m12644b((Iterable) iterable2)));
    }

    public void m6496c(Event event) {
        if (event != null) {
            m6409a(m6378a(RequestType.CREATE_EOBR_EVENT, RequestUnion.newBuilder().m14965a(CreateEobrEventRequest.newBuilder().m12917a(event))));
        }
    }

    public void m6479a(C3642c c3642c, C3642c c3642c2) {
        m6409a(m6378a(RequestType.EOBR_STOP_DRIVING, RequestUnion.newBuilder().m14981a(EobrStopDrivingRequest.newBuilder().m13746a(c3642c).m13749b(c3642c2))));
    }

    public void m6465a(Correction correction, boolean z, String str) {
        C2494a a = AcknowledgeCorrectionRequest.newBuilder().m12341a(correction.getId()).m12345a(z);
        if (!am.m4188a((CharSequence) str)) {
            a.m12344a(str);
        }
        m6429b(RequestType.ACKNOWLEDGE_CORRECTION, RequestUnion.newBuilder().m14951a(a));
    }

    public void m6486a(String str, List<GenxEntry> list, long j) {
        C2673a a = GenxEntrySyncRequest.newBuilder().m14185a(str).m14181a(j);
        for (GenxEntry a2 : list) {
            a.m14182a(a2);
        }
        m6409a(m6378a(RequestType.GENX_ENTRY_SYNC, RequestUnion.newBuilder().m14987a(a)));
    }

    public void m6464a(C1783u c1783u) {
        Request f = c1783u.m8650f();
        if (f != null) {
            m6409a(f);
        }
    }
}
