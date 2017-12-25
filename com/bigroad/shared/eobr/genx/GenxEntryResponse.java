package com.bigroad.shared.eobr.genx;

import com.bigroad.shared.am;
import com.bigroad.shared.eobr.C0968a;
import com.facebook.share.internal.ShareConstants;
import com.google.common.base.Charsets;
import com.google.common.base.MoreObjects;
import com.google.common.base.MoreObjects.ToStringHelper;
import java.io.ByteArrayOutputStream;
import java.util.Arrays;
import java.util.Date;

public class GenxEntryResponse extends C0976j {
    private static int f3062a = 1000000;
    private final GenxEntryReasonCode f3063b;
    private final long f3064c;
    private final int f3065d;
    private final int f3066e;
    private final int f3067f;
    private final boolean f3068g;
    private final int f3069h;
    private final int f3070i;
    private final MotionStatus f3071j;
    private final int f3072k;
    private final int f3073l;
    private final long f3074m;
    private final long f3075n;
    private final long f3076o;
    private final long f3077p;
    private final int f3078q;
    private final int f3079r;
    private final String f3080s;
    private final int f3081t;

    public enum MotionStatus {
        MOVING,
        IDLING,
        STOPPED
    }

    private GenxEntryResponse(long j, GenxEntryReasonCode genxEntryReasonCode, long j2, int i, int i2, int i3, boolean z, int i4, int i5, MotionStatus motionStatus, int i6, int i7, long j3, long j4, long j5, long j6, int i8, int i9, String str, byte[] bArr, int i10) {
        super(-1, j, bArr);
        this.f3063b = genxEntryReasonCode;
        this.f3064c = j2;
        this.f3065d = i;
        this.f3066e = i2;
        this.f3067f = i3;
        this.f3068g = z;
        this.f3069h = i4;
        this.f3070i = i5;
        this.f3071j = motionStatus;
        this.f3072k = i6;
        this.f3073l = i7;
        this.f3074m = j3;
        this.f3075n = j4;
        this.f3076o = j5;
        this.f3077p = j6;
        this.f3078q = i8;
        this.f3079r = i9;
        this.f3080s = str;
        this.f3081t = i10;
    }

    public static C0975o m4997a(byte[] bArr) {
        try {
            switch (C0968a.m4970d(bArr, 0)) {
                case 1:
                    return m4998a(bArr, 2);
                default:
                    return null;
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new GenxDataSerializationException("Unexpected ELD_EVENT length: " + e.getMessage());
        }
    }

    private static C0975o m4998a(byte[] bArr, int i) {
        try {
            String str;
            long a = C0968a.m4965a(bArr, i);
            int i2 = i + 4;
            int i3 = i2 + 1;
            int i4 = bArr[i2] & 255;
            String str2 = "";
            if (i4 == 254) {
                int i5 = i3 + 1;
                if (bArr[i3] == (byte) 109) {
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    while (bArr[i5] != (byte) 0) {
                        i2 = i5 + 1;
                        byteArrayOutputStream.write(bArr[i5]);
                        i5 = i2;
                    }
                    i5++;
                    str2 = new String(byteArrayOutputStream.toByteArray(), Charsets.UTF_8);
                    i4 = 109;
                }
                str = str2;
                i2 = i5;
            } else if (i4 == 125) {
                return C0984g.m5043a(-1, a, Arrays.copyOfRange(bArr, i3, bArr.length), bArr);
            } else {
                str = str2;
                i2 = i3;
            }
            GenxEntryReasonCode a2 = GenxEntryReasonCode.m4982a(i4);
            long a3 = C0968a.m4965a(bArr, i2);
            i2 += 4;
            int b = C0968a.m4967b(bArr, i2);
            i2 += 4;
            int b2 = C0968a.m4967b(bArr, i2);
            i2 += 4;
            i4 = i2 + 1;
            int i6 = bArr[i2] & 255;
            i2 = i4 + 1;
            boolean z = bArr[i4] == (byte) 0;
            i4 = i2 + 1;
            int i7 = bArr[i2] & 255;
            int d = C0968a.m4970d(bArr, i4);
            i2 = i4 + 2;
            i4 = i2 + 1;
            byte b3 = bArr[i2];
            MotionStatus motionStatus = MotionStatus.STOPPED;
            if (b3 == (byte) 77) {
                motionStatus = MotionStatus.MOVING;
            } else if (b3 == (byte) 73) {
                motionStatus = MotionStatus.IDLING;
            }
            int d2 = C0968a.m4970d(bArr, i4);
            i2 = i4 + 2;
            i4 = i2 + 1;
            int i8 = bArr[i2] & 255;
            long a4 = C0968a.m4965a(bArr, i4);
            i2 = i4 + 4;
            long a5 = C0968a.m4965a(bArr, i2);
            i2 += 4;
            long a6 = C0968a.m4965a(bArr, i2);
            i2 += 4;
            long a7 = C0968a.m4965a(bArr, i2);
            i2 += 4;
            int d3 = C0968a.m4970d(bArr, i2);
            i2 += 2;
            i4 = i2 + 1;
            int i9 = bArr[i2] & 255;
            if (i4 == bArr.length) {
                return new GenxEntryResponse(a, a2, a3, b, b2, i6, z, i7, d, motionStatus, d2, i8, a4, a5, a6, a7, d3, i9, str, bArr, 1);
            }
            throw new GenxDataSerializationException("Unexpected ELD_EVENT length. Unparsed bytes: " + (bArr.length - i4), bArr);
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new GenxDataSerializationException("Unexpected ELD_EVENT length: " + e.getMessage());
        }
    }

    public boolean mo750h() {
        return false;
    }

    public int m5003i() {
        return this.f3079r;
    }

    public GenxEntryReasonCode m5004j() {
        return this.f3063b;
    }

    public long m5005k() {
        return this.f3074m * 10;
    }

    public long m5006l() {
        return this.f3075n * 10;
    }

    public long m5007m() {
        return (3600000 * this.f3076o) / 100;
    }

    public long m5008n() {
        return (3600000 * this.f3077p) / 100;
    }

    public int m5009o() {
        return Math.round((((float) this.f3065d) / 3600000.0f) * ((float) f3062a));
    }

    public int m5010p() {
        return Math.round((((float) this.f3066e) / 3600000.0f) * ((float) f3062a));
    }

    public boolean m5011q() {
        return this.f3070i != 65535;
    }

    public boolean m5012r() {
        return m5011q() && this.f3079r < 60;
    }

    public String m5013s() {
        return this.f3080s;
    }

    public long mo749d() {
        return this.f3064c * 1000;
    }

    public int mo748b() {
        return (int) this.f3064c;
    }

    public boolean mo746a() {
        return GenxEntryReasonCode.m4983a(m5004j());
    }

    public String toString() {
        ToStringHelper add = MoreObjects.toStringHelper(GenxEntryResponse.class).add(ShareConstants.WEB_DIALOG_PARAM_ID, m4995t()).add("reason", this.f3063b).add("time", new Date(this.f3064c * 1000)).add("lat", ((float) this.f3065d) / 3600000.0f).add("lng", ((float) this.f3066e) / 3600000.0f).add("age", this.f3067f).add("isGpsCurrent", this.f3068g).add("pdop", this.f3069h).add("speed", this.f3070i).add("motion", this.f3071j).add("heading", this.f3072k).add("ignition", this.f3073l).add("odo", this.f3074m).add("dOdo", this.f3075n).add("eng", this.f3076o).add("dEng", this.f3077p).add("tripTime", this.f3078q).add("ageOfBusInfo", this.f3079r);
        if (!am.m4188a(this.f3080s)) {
            add.add("vin", this.f3080s);
        }
        add.add("encVer", this.f3081t);
        return add.toString();
    }
}
