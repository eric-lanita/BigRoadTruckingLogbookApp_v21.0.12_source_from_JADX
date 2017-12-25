package com.bigroad.ttb.android.eobr.genx;

import com.bigroad.shared.am;
import com.bigroad.shared.eobr.C0971c;
import com.bigroad.shared.eobr.C0973f;
import com.bigroad.shared.eobr.genx.C0975o;
import com.bigroad.shared.eobr.genx.C0976j;
import com.bigroad.shared.eobr.genx.C0978b;
import com.bigroad.shared.eobr.genx.C0983f;
import com.bigroad.shared.eobr.genx.C0985h;
import com.bigroad.shared.eobr.genx.C0994r;
import com.bigroad.shared.eobr.genx.GenxDataSerializationException;
import com.bigroad.shared.eobr.turbo.logs.MultiOdometerLogEntry.OdometerSource;
import com.bigroad.shared.eobr.turbo.messages.SpeedometerMessage.SpeedometerSource;
import com.bigroad.ttb.android.eobr.EobrReader;
import com.bigroad.ttb.android.eobr.RpmSource;
import com.bigroad.ttb.android.eobr.genx.C1928h.C1925a;
import com.bigroad.ttb.android.logging.C2134e;
import com.bigroad.ttb.android.p038g.C2078a;
import com.google.common.collect.C3540t;
import com.google.common.collect.C3589f;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class C1927g extends EobrReader {
    private static final Comparator<C0971c> f6651e = new C19241();
    private List<C0976j> f6652f = new ArrayList(32);
    private final C1925a f6653g = new C19262(this);

    static class C19241 implements Comparator<C0971c> {
        C19241() {
        }

        public /* synthetic */ int compare(Object obj, Object obj2) {
            return m9473a((C0971c) obj, (C0971c) obj2);
        }

        public int m9473a(C0971c c0971c, C0971c c0971c2) {
            return C3589f.m18773a().mo2738a(c0971c.mo747c(), c0971c2.mo747c(), C3540t.m18450c().mo2708a()).mo2740b();
        }
    }

    class C19262 implements C1925a {
        final /* synthetic */ C1927g f6650a;

        C19262(C1927g c1927g) {
            this.f6650a = c1927g;
        }
    }

    public C1927g(C1919c c1919c, C2078a c2078a) {
        super(c1919c, c2078a);
    }

    protected void mo1148b(String str) {
        m9190a(str);
    }

    public void mo1146a(RpmSource rpmSource, int i) {
    }

    public void mo1144a(OdometerSource odometerSource, long j, long j2) {
    }

    public void mo1145a(SpeedometerSource speedometerSource, int i, int i2, long j) {
    }

    private void m9474a(C0975o c0975o, C0994r c0994r) {
        m9194d();
        if (c0975o instanceof C0976j) {
            this.f6652f.add((C0976j) c0975o);
            return;
        }
        if (c0975o instanceof C0978b) {
            if (m9475a((C0978b) c0975o)) {
                Collections.sort(this.f6652f, f6651e);
                try {
                    m9476b((C0978b) c0975o);
                    c0994r.m5096c();
                    return;
                } finally {
                    this.f6652f.clear();
                }
            }
        } else if (c0975o instanceof C0983f) {
            C0983f c0983f = (C0983f) c0975o;
            if (!am.m4188a(c0983f.m5041a()) && (c0983f.m5041a().startsWith("+DOTELD") || c0983f.m5041a().startsWith("+GNXEVENT"))) {
                if (c0983f.mo743e() != 0) {
                    C2134e.m10680d("TT-GenxReader", "Received AT response of DOTELD broadcast with non-zero sequence number: " + c0975o.toString());
                    return;
                }
                return;
            }
        }
        this.f6652f.clear();
        this.a.m9266a((C0973f) c0975o);
    }

    protected void mo1147a(InputStream inputStream) {
        C0994r c0994r = new C0994r(inputStream);
        while (!this.d) {
            try {
                C0975o b = c0994r.m5095b();
                if (b != null) {
                    m9474a(b, c0994r);
                }
            } catch (GenxDataSerializationException e) {
                C2134e.m10680d("TT-GenxReader", e.getMessage());
            }
        }
    }

    protected void mo1149f() {
    }

    private boolean m9475a(C0978b c0978b) {
        CharSequence a = c0978b.m5025a();
        return !am.m4188a(a) && a.startsWith("DUMPQ");
    }

    private void m9476b(C0978b c0978b) {
        String[] split = c0978b.m5025a().split(",");
        if (split.length >= 6) {
            String[] split2 = split[0].split(":");
            if (split2.length != 2) {
                throw new GenxDataSerializationException("Ack Response is missing a proper Command:Num_Of_Events entry: " + split[0]);
            } else if (split2[0].startsWith("DUMPQ")) {
                String str = split2[1];
                try {
                    int parseInt = Integer.parseInt(str);
                    if (parseInt != this.f6652f.size()) {
                        throw new GenxDataSerializationException("Number of events sent did not match number received! Expected: " + parseInt + " but got: " + this.f6652f.size());
                    }
                    try {
                        long parseLong = Long.parseLong(am.m4191b(split[1]));
                        long parseLong2 = Long.parseLong(am.m4191b(split[2]));
                        long parseLong3 = Long.parseLong(am.m4191b(split[3]));
                        this.a.m9266a(new C0985h(c0978b.m4990v(), this.f6652f, parseLong2, parseLong, Long.parseLong(am.m4191b(split[4])), parseLong3, Long.parseLong(am.m4191b(split[5])) * 1000));
                        return;
                    } catch (NumberFormatException e) {
                        throw new GenxDataSerializationException("Invalid number format in DUMPQ ACK Text: " + c0978b.m5025a());
                    }
                } catch (NumberFormatException e2) {
                    throw new GenxDataSerializationException("Invalid row number found in response: " + str);
                }
            } else {
                throw new GenxDataSerializationException("Expected Command: DUMPQ but got: " + split2[0]);
            }
        }
        throw new GenxDataSerializationException("Data missing in response ACK Text. Expected 6 entries, but only received " + split.length + ". ACK text: " + c0978b.m5025a());
    }
}
