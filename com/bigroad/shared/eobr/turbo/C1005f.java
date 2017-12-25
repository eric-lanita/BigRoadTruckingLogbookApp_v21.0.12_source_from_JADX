package com.bigroad.shared.eobr.turbo;

import com.bigroad.shared.eobr.turbo.TurboData.AutoWriteTypes;
import com.bigroad.shared.eobr.turbo.logs.C1020a;
import com.bigroad.shared.eobr.turbo.logs.C1021r;
import com.bigroad.shared.eobr.turbo.logs.C1022b;
import com.bigroad.shared.eobr.turbo.logs.C1023c;
import com.bigroad.shared.eobr.turbo.logs.C1025e;
import com.bigroad.shared.eobr.turbo.logs.C1026f;
import com.bigroad.shared.eobr.turbo.logs.C1027g;
import com.bigroad.shared.eobr.turbo.logs.C1028h;
import com.bigroad.shared.eobr.turbo.logs.C1029i;
import com.bigroad.shared.eobr.turbo.logs.C1030j;
import com.bigroad.shared.eobr.turbo.logs.C1031k;
import com.bigroad.shared.eobr.turbo.logs.C1032l;
import com.bigroad.shared.eobr.turbo.logs.C1033m;
import com.bigroad.shared.eobr.turbo.logs.C1034n;
import com.bigroad.shared.eobr.turbo.logs.C1035q;
import com.bigroad.shared.eobr.turbo.logs.C1036s;
import com.bigroad.shared.eobr.turbo.logs.C1037t;
import com.bigroad.shared.eobr.turbo.logs.EngineHoursLogEntry;
import com.bigroad.shared.eobr.turbo.logs.LogworthyLogEntry;
import com.bigroad.shared.eobr.turbo.logs.MobileClientSessionLogEntry;
import com.bigroad.shared.eobr.turbo.logs.MultiOdometerLogEntry;
import com.bigroad.shared.eobr.turbo.logs.PowerLogEntry;
import com.bigroad.shared.eobr.turbo.messages.C1038a;
import com.bigroad.shared.eobr.turbo.messages.C1039b;
import com.bigroad.shared.eobr.turbo.messages.C1040c;
import com.bigroad.shared.eobr.turbo.messages.C1041d;
import com.bigroad.shared.eobr.turbo.messages.C1042e;
import com.bigroad.shared.eobr.turbo.messages.C1043f;
import com.bigroad.shared.eobr.turbo.messages.C1044g;
import com.bigroad.shared.eobr.turbo.messages.C1045h;
import com.bigroad.shared.eobr.turbo.messages.C1046i;
import com.bigroad.shared.eobr.turbo.messages.C1047j;
import com.bigroad.shared.eobr.turbo.messages.C1048k;
import com.bigroad.shared.eobr.turbo.messages.C1050m;
import com.bigroad.shared.eobr.turbo.messages.C1051n;
import com.bigroad.shared.eobr.turbo.messages.C1052o;
import com.bigroad.shared.eobr.turbo.messages.C1053p;
import com.bigroad.shared.eobr.turbo.messages.C1054q;
import com.bigroad.shared.eobr.turbo.messages.C1055r;
import com.bigroad.shared.eobr.turbo.messages.C1056s;
import com.bigroad.shared.eobr.turbo.messages.C1057t;
import com.bigroad.shared.eobr.turbo.messages.C1058u;
import com.bigroad.shared.eobr.turbo.messages.C1059v;
import com.bigroad.shared.eobr.turbo.messages.C1060w;
import com.bigroad.shared.eobr.turbo.messages.C1061x;
import com.bigroad.shared.eobr.turbo.messages.C1062y;
import com.bigroad.shared.eobr.turbo.messages.C1063z;
import com.bigroad.shared.eobr.turbo.messages.FirmwareUpdateRequestMessage;
import com.bigroad.shared.eobr.turbo.messages.SpeedometerMessage;
import com.bigroad.shared.eobr.turbo.messages.TestLoopbackMessage;
import com.bigroad.shared.eobr.turbo.messages.TestRequestMessage;
import com.bigroad.shared.eobr.turbo.messages.TurboResponseMessage;
import com.bigroad.shared.eobr.turbo.messages.UsbStatusMessage;
import com.bigroad.shared.eobr.turbo.messages.aa;
import com.bigroad.shared.eobr.turbo.messages.ab;
import com.bigroad.shared.eobr.turbo.messages.ac;
import com.bigroad.shared.eobr.turbo.messages.ad;
import com.bigroad.shared.eobr.turbo.messages.ae;
import com.bigroad.shared.eobr.turbo.messages.af;
import com.bigroad.shared.eobr.turbo.messages.ag;
import com.bigroad.shared.eobr.turbo.messages.ah;
import com.bigroad.shared.eobr.turbo.messages.ai;
import com.bigroad.shared.eobr.turbo.messages.am;
import com.bigroad.shared.eobr.turbo.messages.an;
import java.io.OutputStream;

abstract class C1005f {
    protected OutputStream f3144a;

    protected abstract void mo766a();

    protected abstract void mo767b();

    C1005f() {
    }

    private void m5153a(int i) {
        C1014k.m5224a(this.f3144a, i);
    }

    private void m5158a(int[] iArr) {
        int i = 0;
        if (iArr == null) {
            m5153a(0);
            return;
        }
        m5153a(iArr.length);
        int length = iArr.length;
        while (i < length) {
            m5153a(iArr[i]);
            i++;
        }
    }

    private void m5154a(long j) {
        C1014k.m5225a(this.f3144a, j);
    }

    private void m5159a(long[] jArr) {
        int i = 0;
        if (jArr == null) {
            m5153a(0);
            return;
        }
        m5153a(jArr.length);
        int length = jArr.length;
        while (i < length) {
            m5154a(jArr[i]);
            i++;
        }
    }

    private void m5162b(int i) {
        C1001a.m5126a(this.f3144a, i);
    }

    private void m5165b(int[] iArr) {
        int i = 0;
        if (iArr == null) {
            m5153a(0);
            return;
        }
        m5153a(iArr.length);
        int length = iArr.length;
        while (i < length) {
            m5162b(iArr[i]);
            i++;
        }
    }

    private void m5163b(long j) {
        C1001a.m5127a(this.f3144a, j);
    }

    private void m5166b(long[] jArr) {
        int i = 0;
        if (jArr == null) {
            m5153a(0);
            return;
        }
        m5153a(jArr.length);
        int length = jArr.length;
        while (i < length) {
            m5163b(jArr[i]);
            i++;
        }
    }

    private void m5155a(C1000c c1000c) {
        m5153a(c1000c.mo760a());
    }

    private void m5160a(C1000c[] c1000cArr) {
        int i = 0;
        if (c1000cArr == null) {
            m5153a(0);
            return;
        }
        m5153a(c1000cArr.length);
        int length = c1000cArr.length;
        while (i < length) {
            m5155a(c1000cArr[i]);
            i++;
        }
    }

    protected int m5167a(AutoWriteTypes autoWriteTypes) {
        return 0;
    }

    private void m5164b(AutoWriteTypes autoWriteTypes) {
        m5153a(m5167a(autoWriteTypes));
    }

    private void m5156a(boolean z) {
        this.f3144a.write(z ? 1 : 0);
    }

    private void m5161a(boolean[] zArr) {
        if (zArr == null) {
            m5153a(0);
            return;
        }
        m5153a(zArr.length);
        for (boolean z : zArr) {
            int i;
            OutputStream outputStream = this.f3144a;
            if (z) {
                i = 1;
            } else {
                i = 0;
            }
            outputStream.write(i);
        }
    }

    private void m5157a(byte[] bArr) {
        int i = 0;
        if (bArr == null) {
            m5153a(0);
            return;
        }
        m5153a(bArr.length);
        int length = bArr.length;
        while (i < length) {
            this.f3144a.write(bArr[i]);
            i++;
        }
    }

    public final synchronized void m5169a(TurboData turboData) {
        switch (C1003d.m5135a(turboData.getClass())) {
            case 0:
                TestLoopbackMessage testLoopbackMessage = (TestLoopbackMessage) turboData;
                mo766a();
                m5153a(0);
                m5156a(testLoopbackMessage.f3320a);
                m5153a(testLoopbackMessage.f3321b);
                m5154a(testLoopbackMessage.f3322c);
                m5162b(testLoopbackMessage.f3323d);
                m5163b(testLoopbackMessage.f3324e);
                m5155a(testLoopbackMessage.f3325f);
                m5161a(testLoopbackMessage.f3326g);
                m5157a(testLoopbackMessage.f3327h);
                m5158a(testLoopbackMessage.f3328i);
                m5165b(testLoopbackMessage.f3329j);
                m5159a(testLoopbackMessage.f3330k);
                m5166b(testLoopbackMessage.f3331l);
                m5160a(testLoopbackMessage.f3332m);
                mo767b();
                break;
            case 1:
                ai aiVar = (ai) turboData;
                mo766a();
                m5153a(1);
                m5153a(aiVar.f3410a);
                m5157a(aiVar.f3411b);
                mo767b();
                break;
            case 2:
                TurboResponseMessage turboResponseMessage = (TurboResponseMessage) turboData;
                mo766a();
                m5153a(2);
                m5153a(turboResponseMessage.f3352d);
                m5155a(turboResponseMessage.f3353e);
                mo767b();
                break;
            case 3:
                C1039b c1039b = (C1039b) turboData;
                mo766a();
                m5153a(3);
                m5153a(c1039b.f3413a);
                m5156a(c1039b.f3414b);
                m5153a(c1039b.f3415c);
                m5153a(c1039b.f3416d);
                m5153a(c1039b.f);
                mo767b();
                break;
            case 4:
                C1040c c1040c = (C1040c) turboData;
                mo766a();
                m5153a(4);
                m5153a(c1040c.f3417a);
                m5153a(c1040c.f3418b);
                m5156a(c1040c.f3419c);
                m5157a(c1040c.f3420d);
                mo767b();
                break;
            case 5:
                C1055r c1055r = (C1055r) turboData;
                mo766a();
                m5153a(5);
                m5153a(c1055r.f3456a);
                m5156a(c1055r.f3457b);
                m5153a(c1055r.f3458c);
                m5153a(c1055r.f);
                mo767b();
                break;
            case 6:
                C1056s c1056s = (C1056s) turboData;
                mo766a();
                m5153a(6);
                m5153a(c1056s.f3459a);
                m5153a(c1056s.f3460b);
                m5153a(c1056s.f3461c);
                m5153a(c1056s.f3462d);
                m5157a(c1056s.f3463e);
                mo767b();
                break;
            case 7:
                C1057t c1057t = (C1057t) turboData;
                mo766a();
                m5153a(7);
                m5153a(c1057t.f3464a);
                m5153a(c1057t.f3465b);
                m5153a(c1057t.f3466c);
                m5153a(c1057t.f3467d);
                m5153a(c1057t.f);
                mo767b();
                break;
            case 8:
                aa aaVar = (aa) turboData;
                mo766a();
                m5153a(8);
                m5153a(aaVar.f3391a);
                m5153a(aaVar.f3392b);
                m5153a(aaVar.f3393c);
                m5153a(aaVar.f3394d);
                m5153a(aaVar.f);
                mo767b();
                break;
            case 9:
                ab abVar = (ab) turboData;
                mo766a();
                m5153a(9);
                m5153a(abVar.f3395a);
                m5153a(abVar.f3396b);
                m5153a(abVar.f3397c);
                m5153a(abVar.f3398d);
                m5157a(abVar.f3399e);
                mo767b();
                break;
            case 12:
                C1038a c1038a = (C1038a) turboData;
                mo766a();
                m5153a(12);
                m5155a(c1038a.f3388a);
                m5153a(c1038a.f3389b);
                m5153a(c1038a.f3390c);
                mo767b();
                break;
            case 13:
                FirmwareUpdateRequestMessage firmwareUpdateRequestMessage = (FirmwareUpdateRequestMessage) turboData;
                mo766a();
                m5153a(13);
                m5155a(firmwareUpdateRequestMessage.f3299a);
                m5157a(firmwareUpdateRequestMessage.f3300b);
                m5153a(firmwareUpdateRequestMessage.f);
                mo767b();
                break;
            case 14:
                ad adVar = (ad) turboData;
                mo766a();
                m5153a(14);
                m5153a(adVar.f3403a);
                mo767b();
                break;
            case 15:
                C1052o c1052o = (C1052o) turboData;
                mo766a();
                m5153a(15);
                m5155a(c1052o.f3448a);
                m5153a(c1052o.f3449b);
                m5153a(c1052o.f);
                mo767b();
                break;
            case 16:
                C1050m c1050m = (C1050m) turboData;
                mo766a();
                m5153a(16);
                m5155a(c1050m.f3440a);
                m5157a(c1050m.f3441b.getBytes("UTF-8"));
                mo767b();
                break;
            case 17:
                C1053p c1053p = (C1053p) turboData;
                mo766a();
                m5153a(17);
                m5156a(c1053p.f3450a);
                m5153a(c1053p.f3451b);
                m5153a(c1053p.f);
                mo767b();
                break;
            case 18:
                C1054q c1054q = (C1054q) turboData;
                mo766a();
                m5153a(18);
                m5153a(c1054q.f3452a);
                m5153a(c1054q.f3453b);
                m5153a(c1054q.f3454c);
                m5157a(c1054q.f3455d);
                mo767b();
                break;
            case 19:
                C1035q c1035q = (C1035q) turboData;
                mo766a();
                m5153a(19);
                m5153a(c1035q.f3280a);
                m5153a(c1035q.f3281b);
                m5153a(c1035q.f3282c);
                mo767b();
                break;
            case 20:
                C1034n c1034n = (C1034n) turboData;
                mo766a();
                m5153a(20);
                m5154a(c1034n.f3279a);
                m5164b(AutoWriteTypes.AUTO_WRITE_TYPE_ELAPSED_TIME);
                mo767b();
                break;
            case 22:
                C1042e c1042e = (C1042e) turboData;
                mo766a();
                m5153a(22);
                m5153a(c1042e.f3422a);
                m5153a(c1042e.f3423b);
                m5153a(c1042e.f3424c);
                m5153a(c1042e.f3425d);
                m5155a(c1042e.f3426e);
                m5155a(c1042e.f3427f);
                m5155a(c1042e.f3428g);
                m5155a(c1042e.f3429h);
                m5155a(c1042e.f3430i);
                m5155a(c1042e.f3431j);
                mo767b();
                break;
            case 23:
                C1058u c1058u = (C1058u) turboData;
                mo766a();
                m5153a(23);
                m5153a(c1058u.f3468a);
                m5153a(c1058u.f);
                mo767b();
                break;
            case 24:
                C1060w c1060w = (C1060w) turboData;
                mo766a();
                m5153a(24);
                m5153a(c1060w.f3469a);
                m5157a(c1060w.f3470b);
                m5153a(c1060w.d);
                m5155a(c1060w.e);
                mo767b();
                break;
            case 25:
                PowerLogEntry powerLogEntry = (PowerLogEntry) turboData;
                mo766a();
                m5153a(25);
                m5155a(powerLogEntry.f3243a);
                m5153a(powerLogEntry.f3244b);
                m5164b(AutoWriteTypes.AUTO_WRITE_TYPE_ELAPSED_TIME);
                mo767b();
                break;
            case 26:
                C1026f c1026f = (C1026f) turboData;
                mo766a();
                m5153a(26);
                m5162b(c1026f.f3254a);
                m5162b(c1026f.f3255b);
                m5153a(c1026f.f3256c);
                m5164b(AutoWriteTypes.AUTO_WRITE_TYPE_ELAPSED_TIME);
                mo767b();
                break;
            case 27:
                C1037t c1037t = (C1037t) turboData;
                mo766a();
                m5153a(27);
                m5157a(c1037t.f3284a.getBytes("UTF-8"));
                m5164b(AutoWriteTypes.AUTO_WRITE_TYPE_ELAPSED_TIME);
                mo767b();
                break;
            case 28:
                C1020a c1020a = (C1020a) turboData;
                mo766a();
                m5153a(28);
                m5153a(c1020a.f3245a);
                m5155a(c1020a.f3246b);
                m5153a(c1020a.f3247c);
                m5153a(c1020a.f3248d);
                m5153a(c1020a.f3249e);
                m5153a(c1020a.f3250f);
                m5164b(AutoWriteTypes.AUTO_WRITE_TYPE_ELAPSED_TIME);
                mo767b();
                break;
            case 29:
                C1033m c1033m = (C1033m) turboData;
                mo766a();
                m5153a(29);
                m5153a(c1033m.f3277a);
                m5153a(c1033m.f3278b);
                m5164b(AutoWriteTypes.AUTO_WRITE_TYPE_ELAPSED_TIME);
                mo767b();
                break;
            case 30:
                UsbStatusMessage usbStatusMessage = (UsbStatusMessage) turboData;
                mo766a();
                m5153a(30);
                m5155a(usbStatusMessage.f3362a);
                mo767b();
                break;
            case 31:
                C1032l c1032l = (C1032l) turboData;
                mo766a();
                m5153a(31);
                m5157a(c1032l.f3276a.getBytes("UTF-8"));
                m5164b(AutoWriteTypes.AUTO_WRITE_TYPE_ELAPSED_TIME);
                mo767b();
                break;
            case 33:
                LogworthyLogEntry logworthyLogEntry = (LogworthyLogEntry) turboData;
                mo766a();
                m5153a(33);
                m5155a(logworthyLogEntry.f3208a);
                m5157a(logworthyLogEntry.f3209b.getBytes("UTF-8"));
                m5164b(AutoWriteTypes.AUTO_WRITE_TYPE_ELAPSED_TIME);
                mo767b();
                break;
            case 34:
                C1031k c1031k = (C1031k) turboData;
                mo766a();
                m5153a(34);
                m5153a(c1031k.f3270a);
                m5153a(c1031k.f3271b);
                m5153a(c1031k.f3272c);
                m5153a(c1031k.f3273d);
                m5153a(c1031k.f3274e);
                m5153a(c1031k.f3275f);
                m5164b(AutoWriteTypes.AUTO_WRITE_TYPE_ELAPSED_TIME);
                mo767b();
                break;
            case 35:
                C1030j c1030j = (C1030j) turboData;
                mo766a();
                m5153a(35);
                m5153a(c1030j.f3268a);
                m5157a(c1030j.f3269b);
                m5164b(AutoWriteTypes.AUTO_WRITE_TYPE_ELAPSED_TIME);
                mo767b();
                break;
            case 37:
                C1051n c1051n = (C1051n) turboData;
                mo766a();
                m5153a(37);
                m5162b(c1051n.f3443a);
                m5162b(c1051n.f3444b);
                m5153a(c1051n.f3445c);
                m5153a(c1051n.f3446d);
                m5154a(c1051n.f3447e);
                mo767b();
                break;
            case 38:
                MultiOdometerLogEntry multiOdometerLogEntry = (MultiOdometerLogEntry) turboData;
                mo766a();
                m5153a(38);
                m5158a(multiOdometerLogEntry.f3234a);
                m5160a(multiOdometerLogEntry.f3235b);
                m5164b(AutoWriteTypes.AUTO_WRITE_TYPE_ELAPSED_TIME);
                mo767b();
                break;
            case 39:
                C1036s c1036s = (C1036s) turboData;
                mo766a();
                m5153a(39);
                m5153a(c1036s.f3283a);
                m5164b(AutoWriteTypes.AUTO_WRITE_TYPE_ELAPSED_TIME);
                mo767b();
                break;
            case 40:
                SpeedometerMessage speedometerMessage = (SpeedometerMessage) turboData;
                mo766a();
                m5153a(40);
                m5153a(speedometerMessage.f3314a);
                m5155a(speedometerMessage.f3315b);
                mo767b();
                break;
            case 41:
                C1043f c1043f = (C1043f) turboData;
                mo766a();
                m5153a(41);
                m5157a(c1043f.f3432a);
                m5153a(c1043f.f);
                mo767b();
                break;
            case 42:
                C1023c c1023c = (C1023c) turboData;
                mo766a();
                m5153a(42);
                m5157a(c1023c.f3251a);
                m5164b(AutoWriteTypes.AUTO_WRITE_TYPE_ELAPSED_TIME);
                mo767b();
                break;
            case 43:
                C1063z c1063z = (C1063z) turboData;
                mo766a();
                m5153a(43);
                m5157a(c1063z.f3476a);
                m5154a(c1063z.f3477b);
                m5154a(c1063z.f3478c);
                m5153a(c1063z.f3479d);
                m5153a(c1063z.f3480e);
                m5153a(c1063z.f);
                mo767b();
                break;
            case 44:
                MobileClientSessionLogEntry mobileClientSessionLogEntry = (MobileClientSessionLogEntry) turboData;
                mo766a();
                m5153a(44);
                m5157a(mobileClientSessionLogEntry.f3215a);
                m5154a(mobileClientSessionLogEntry.f3216b);
                m5154a(mobileClientSessionLogEntry.f3217c);
                m5153a(mobileClientSessionLogEntry.f3218d);
                m5153a(mobileClientSessionLogEntry.f3219e);
                m5155a(mobileClientSessionLogEntry.f3220f);
                m5164b(AutoWriteTypes.AUTO_WRITE_TYPE_ELAPSED_TIME);
                mo767b();
                break;
            case 45:
                C1041d c1041d = (C1041d) turboData;
                mo766a();
                m5153a(45);
                m5153a(c1041d.f3421a);
                m5153a(c1041d.f);
                mo767b();
                break;
            case 46:
                am amVar = (am) turboData;
                mo766a();
                m5153a(46);
                m5153a(amVar.f);
                mo767b();
                break;
            case 47:
                an anVar = (an) turboData;
                mo766a();
                m5153a(47);
                m5157a(anVar.f3412a.getBytes("UTF-8"));
                m5153a(anVar.d);
                m5155a(anVar.e);
                mo767b();
                break;
            case 48:
                C1059v c1059v = (C1059v) turboData;
                mo766a();
                m5153a(48);
                m5153a(c1059v.a);
                m5153a(c1059v.f);
                mo767b();
                break;
            case 49:
                C1061x c1061x = (C1061x) turboData;
                mo766a();
                m5153a(49);
                m5153a(c1061x.f3471c);
                m5153a(c1061x.a);
                m5157a(c1061x.b);
                m5153a(c1061x.d);
                m5155a(c1061x.e);
                mo767b();
                break;
            case 50:
                af afVar = (af) turboData;
                mo766a();
                m5153a(50);
                m5155a(afVar.f3404a);
                m5157a(afVar.f3405b);
                m5153a(afVar.f);
                mo767b();
                break;
            case 51:
                ag agVar = (ag) turboData;
                mo766a();
                m5153a(51);
                m5155a(agVar.f3406a);
                m5154a(agVar.f3407b);
                m5153a(agVar.f);
                mo767b();
                break;
            case 52:
                C1045h c1045h = (C1045h) turboData;
                mo766a();
                m5153a(52);
                m5155a(c1045h.f3434a);
                m5153a(c1045h.f);
                mo767b();
                break;
            case 53:
                C1047j c1047j = (C1047j) turboData;
                mo766a();
                m5153a(53);
                m5155a(c1047j.f3437a);
                m5153a(c1047j.f);
                mo767b();
                break;
            case 54:
                C1046i c1046i = (C1046i) turboData;
                mo766a();
                m5153a(54);
                m5155a(c1046i.f3435a);
                m5157a(c1046i.f3436b);
                m5153a(c1046i.d);
                m5155a(c1046i.e);
                mo767b();
                break;
            case 55:
                C1048k c1048k = (C1048k) turboData;
                mo766a();
                m5153a(55);
                m5155a(c1048k.f3438a);
                m5154a(c1048k.f3439b);
                m5153a(c1048k.d);
                m5155a(c1048k.e);
                mo767b();
                break;
            case 56:
                C1062y c1062y = (C1062y) turboData;
                mo766a();
                m5153a(56);
                m5155a(c1062y.f3472a);
                m5154a(c1062y.f3473b);
                m5157a(c1062y.f3474c.getBytes("UTF-8"));
                m5157a(c1062y.f3475d);
                m5155a(c1062y.e);
                m5157a(c1062y.g);
                m5153a(c1062y.f);
                mo767b();
                break;
            case 57:
                C1028h c1028h = (C1028h) turboData;
                mo766a();
                m5153a(57);
                m5155a(c1028h.f3260a);
                m5154a(c1028h.f3261b);
                m5157a(c1028h.f3262c.getBytes("UTF-8"));
                m5157a(c1028h.f3263d);
                m5164b(AutoWriteTypes.AUTO_WRITE_TYPE_ELAPSED_TIME);
                mo767b();
                break;
            case 58:
                C1044g c1044g = (C1044g) turboData;
                mo766a();
                m5153a(58);
                m5157a(c1044g.f3433a);
                m5153a(c1044g.f);
                mo767b();
                break;
            case 59:
                C1025e c1025e = (C1025e) turboData;
                mo766a();
                m5153a(59);
                m5157a(c1025e.f3253a);
                m5164b(AutoWriteTypes.AUTO_WRITE_TYPE_ELAPSED_TIME);
                mo767b();
                break;
            case 60:
                ac acVar = (ac) turboData;
                mo766a();
                m5153a(60);
                m5158a(acVar.f3400a);
                m5161a(acVar.f3401b);
                m5154a(acVar.f3402c);
                m5153a(acVar.f);
                mo767b();
                break;
            case 61:
                C1029i c1029i = (C1029i) turboData;
                mo766a();
                m5153a(61);
                m5154a(c1029i.f3264a);
                m5158a(c1029i.f3265b);
                m5161a(c1029i.f3266c);
                m5156a(c1029i.f3267d);
                m5164b(AutoWriteTypes.AUTO_WRITE_TYPE_ELAPSED_TIME);
                mo767b();
                break;
            case 62:
                C1027g c1027g = (C1027g) turboData;
                mo766a();
                m5153a(62);
                m5153a(c1027g.f3258d);
                m5154a(c1027g.f3259e);
                m5162b(c1027g.a);
                m5162b(c1027g.b);
                m5153a(c1027g.c);
                m5164b(AutoWriteTypes.AUTO_WRITE_TYPE_ELAPSED_TIME);
                mo767b();
                break;
            case 63:
                C1021r c1021r = (C1021r) turboData;
                mo766a();
                m5153a(63);
                m5164b(AutoWriteTypes.AUTO_WRITE_TYPE_ELAPSED_TIME);
                mo767b();
                break;
            case 64:
                ae aeVar = (ae) turboData;
                mo766a();
                m5153a(64);
                m5153a(aeVar.f);
                mo767b();
                break;
            case 65:
                C1022b c1022b = (C1022b) turboData;
                mo766a();
                m5153a(65);
                m5164b(AutoWriteTypes.AUTO_WRITE_TYPE_ELAPSED_TIME);
                mo767b();
                break;
            case 66:
                TestRequestMessage testRequestMessage = (TestRequestMessage) turboData;
                mo766a();
                m5153a(66);
                m5155a(testRequestMessage.f3339a);
                m5153a(testRequestMessage.f3340b);
                m5157a(testRequestMessage.f3341c);
                m5153a(testRequestMessage.f);
                mo767b();
                break;
            case 67:
                ah ahVar = (ah) turboData;
                mo766a();
                m5153a(67);
                m5153a(ahVar.f3408a);
                m5157a(ahVar.f3409b);
                m5153a(ahVar.d);
                m5155a(ahVar.e);
                mo767b();
                break;
            case 68:
                EngineHoursLogEntry engineHoursLogEntry = (EngineHoursLogEntry) turboData;
                mo766a();
                m5153a(68);
                m5158a(engineHoursLogEntry.f3194a);
                m5160a(engineHoursLogEntry.f3195b);
                m5164b(AutoWriteTypes.AUTO_WRITE_TYPE_ELAPSED_TIME);
                mo767b();
                break;
            default:
                throw new TurboDataSerializationException("Unknown object: " + turboData);
        }
    }
}
