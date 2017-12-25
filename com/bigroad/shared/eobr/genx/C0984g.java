package com.bigroad.shared.eobr.genx;

import com.bigroad.shared.C1144s;
import com.bigroad.shared.C1180y;
import com.bigroad.shared.eobr.C0968a;
import com.bigroad.shared.eobr.turbo.logs.C1024d;
import com.bigroad.shared.eobr.turbo.logs.EobrEventLogData;
import com.bigroad.ttb.protocol.TTProtocol.EobrSessionLogEntry;
import com.bigroad.ttb.protocol.TTProtocol.Event;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.share.internal.ShareConstants;
import com.google.android.gms.tagmanager.DataLayer;
import com.google.common.base.Ascii;
import com.google.common.base.MoreObjects;
import com.google.common.base.MoreObjects.ToStringHelper;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;

public class C0984g extends C0976j {
    private final long f3094a;
    private final byte[] f3095b;

    private C0984g(int i, long j, long j2, byte[] bArr, byte[] bArr2) {
        super(i, j, bArr2);
        this.f3094a = j2;
        this.f3095b = bArr;
    }

    public static C0984g m5043a(int i, long j, byte[] bArr, byte[] bArr2) {
        byte[] copyOfRange = Arrays.copyOfRange(bArr, 0, 4);
        return new C0984g(-1, j, C0968a.m4965a(copyOfRange, 0), Arrays.copyOfRange(bArr, 4, bArr.length), bArr2);
    }

    public boolean mo750h() {
        return false;
    }

    public boolean m5047i() {
        return this.f3095b != null && this.f3095b.length > 2 && this.f3095b[0] == (byte) 10 && this.f3095b[1] == (byte) -5;
    }

    public boolean m5048j() {
        return this.f3095b != null && this.f3095b.length > 2 && this.f3095b[0] == Ascii.VT && this.f3095b[1] == (byte) -5;
    }

    public boolean m5049k() {
        return this.f3095b != null && this.f3095b.length > 2 && ((this.f3095b[0] == (byte) 1 || this.f3095b[0] == (byte) 2 || this.f3095b[0] == (byte) -1) && this.f3095b[1] == (byte) -5);
    }

    public C1024d m5050l() {
        if (m5047i()) {
            return new C1024d(Arrays.copyOfRange(this.f3095b, 2, this.f3095b.length));
        }
        return null;
    }

    public Event m5051m() {
        if (m5048j()) {
            return EobrEventLogData.m5242b(Arrays.copyOfRange(this.f3095b, 2, this.f3095b.length));
        }
        return null;
    }

    public C0977a m5052n() {
        return new C0977a(this);
    }

    public EobrSessionLogEntry m5053o() {
        if (m5049k()) {
            return EobrSessionLogEntry.parseFrom(Arrays.copyOfRange(this.f3095b, 2, this.f3095b.length));
        }
        return null;
    }

    public byte[] m5054p() {
        return this.f3095b;
    }

    public int mo748b() {
        return (int) this.f3094a;
    }

    public long mo749d() {
        return this.f3094a * 1000;
    }

    public String toString() {
        ToStringHelper add = MoreObjects.toStringHelper(C0984g.class).add(ShareConstants.WEB_DIALOG_PARAM_ID, m4995t()).add("time", new Date(this.f3094a * 1000));
        Object c;
        if (m5048j()) {
            add.add(ShareConstants.MEDIA_TYPE, (Object) "EobrEvent");
            try {
                c = C1144s.m5763c(m5051m());
            } catch (IOException e) {
                c = "UNPARSABLE [" + C1180y.m5990a(this.f3095b) + "]";
            }
            add.add(DataLayer.EVENT_KEY, c);
        } else if (m5047i()) {
            add.add(ShareConstants.MEDIA_TYPE, (Object) "ExternalEvent").add(DataLayer.EVENT_KEY, m5050l().toString());
        } else if (m5049k()) {
            try {
                c = m5052n().toString();
            } catch (IOException e2) {
                c = "UNPARSABLE [" + C1180y.m5990a(this.f3095b) + "]";
            }
            add.add(AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS, C0990p.m5079a(this.f3095b));
            add.add(DataLayer.EVENT_KEY, c);
        } else {
            add.add(ShareConstants.WEB_DIALOG_PARAM_DATA, "{" + C1180y.m5993b(this.f3095b) + "}");
        }
        return add.toString();
    }
}
