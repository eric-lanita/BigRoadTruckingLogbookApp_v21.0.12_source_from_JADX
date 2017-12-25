package com.bigroad.shared.eobr.genx;

import com.bigroad.shared.C1144s;
import com.bigroad.shared.C1180y;
import com.bigroad.shared.eobr.turbo.logs.C1024d;
import com.bigroad.shared.eobr.turbo.logs.EobrEventLogData;
import com.bigroad.ttb.protocol.TTProtocol.Event;
import com.facebook.share.internal.ShareConstants;
import com.google.android.gms.tagmanager.DataLayer;
import com.google.common.base.Ascii;
import com.google.common.base.MoreObjects;
import com.google.common.base.MoreObjects.ToStringHelper;
import java.io.IOException;
import java.util.Arrays;

public class C0991q extends C0981n {
    private final byte[] f3109a;

    public C0991q(byte b, byte[] bArr) {
        this.f3109a = new byte[(bArr.length + 2)];
        this.f3109a[0] = b;
        this.f3109a[1] = (byte) -5;
        System.arraycopy(bArr, 0, this.f3109a, 2, bArr.length);
    }

    protected GenxDataType mo758b() {
        return GenxDataType.STORE_DATA;
    }

    protected byte[] mo759c() {
        return this.f3109a;
    }

    public boolean m5085d() {
        return this.f3109a != null && this.f3109a.length > 0 && this.f3109a[0] == (byte) 10;
    }

    public boolean m5086e() {
        return this.f3109a != null && this.f3109a.length > 0 && this.f3109a[0] == Ascii.VT;
    }

    public C1024d m5087f() {
        if (m5085d()) {
            return new C1024d(Arrays.copyOfRange(this.f3109a, 2, this.f3109a.length));
        }
        return null;
    }

    public Event m5088h() {
        if (m5086e()) {
            return EobrEventLogData.m5242b(Arrays.copyOfRange(this.f3109a, 2, this.f3109a.length));
        }
        return null;
    }

    public String toString() {
        ToStringHelper toStringHelper = MoreObjects.toStringHelper(C0991q.class);
        if (m5086e()) {
            toStringHelper.add(ShareConstants.MEDIA_TYPE, (Object) "EobrEvent");
            Object obj = "INVALID";
            try {
                obj = C1144s.m5763c(m5088h());
            } catch (IOException e) {
            }
            toStringHelper.add(DataLayer.EVENT_KEY, obj);
        } else if (m5085d()) {
            toStringHelper.add(ShareConstants.MEDIA_TYPE, (Object) "ExternalEvent").add(DataLayer.EVENT_KEY, m5087f().toString());
        } else {
            toStringHelper.add(ShareConstants.WEB_DIALOG_PARAM_DATA, "{" + C1180y.m5993b(this.f3109a) + "}");
        }
        return toStringHelper.toString();
    }
}
