package com.google.android.gms.common.stats;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import java.util.List;

public final class WakeLockEvent extends StatsEvent {
    public static final Creator<WakeLockEvent> CREATOR = new zzg();
    final int f10862a;
    private final long f10863b;
    private int f10864c;
    private final String f10865d;
    private final String f10866e;
    private final String f10867f;
    private final int f10868g;
    private final List<String> f10869h;
    private final String f10870i;
    private final long f10871j;
    private int f10872k;
    private final String f10873l;
    private final float f10874m;
    private final long f10875n;
    private long f10876o;

    WakeLockEvent(int i, long j, int i2, String str, int i3, List<String> list, String str2, long j2, int i4, String str3, String str4, float f, long j3, String str5) {
        this.f10862a = i;
        this.f10863b = j;
        this.f10864c = i2;
        this.f10865d = str;
        this.f10866e = str3;
        this.f10867f = str5;
        this.f10868g = i3;
        this.f10876o = -1;
        this.f10869h = list;
        this.f10870i = str2;
        this.f10871j = j2;
        this.f10872k = i4;
        this.f10873l = str4;
        this.f10874m = f;
        this.f10875n = j3;
    }

    public WakeLockEvent(long j, int i, String str, int i2, List<String> list, String str2, long j2, int i3, String str3, String str4, float f, long j3, String str5) {
        this(2, j, i, str, i2, list, str2, j2, i3, str3, str4, f, j3, str5);
    }

    public int getEventType() {
        return this.f10864c;
    }

    public long getTimeMillis() {
        return this.f10863b;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzg.m17000a(this, parcel, i);
    }

    public String zzaus() {
        return this.f10870i;
    }

    public long zzaut() {
        return this.f10876o;
    }

    public long zzauv() {
        return this.f10871j;
    }

    public String zzauw() {
        String valueOf = String.valueOf("\t");
        String valueOf2 = String.valueOf(zzauz());
        String valueOf3 = String.valueOf("\t");
        int zzavc = zzavc();
        String valueOf4 = String.valueOf("\t");
        String join = zzavd() == null ? "" : TextUtils.join(",", zzavd());
        String valueOf5 = String.valueOf("\t");
        int zzave = zzave();
        String valueOf6 = String.valueOf("\t");
        String zzava = zzava() == null ? "" : zzava();
        String valueOf7 = String.valueOf("\t");
        String zzavf = zzavf() == null ? "" : zzavf();
        String valueOf8 = String.valueOf("\t");
        float zzavg = zzavg();
        String valueOf9 = String.valueOf("\t");
        String zzavb = zzavb() == null ? "" : zzavb();
        return new StringBuilder(((((((((((((String.valueOf(valueOf).length() + 37) + String.valueOf(valueOf2).length()) + String.valueOf(valueOf3).length()) + String.valueOf(valueOf4).length()) + String.valueOf(join).length()) + String.valueOf(valueOf5).length()) + String.valueOf(valueOf6).length()) + String.valueOf(zzava).length()) + String.valueOf(valueOf7).length()) + String.valueOf(zzavf).length()) + String.valueOf(valueOf8).length()) + String.valueOf(valueOf9).length()) + String.valueOf(zzavb).length()).append(valueOf).append(valueOf2).append(valueOf3).append(zzavc).append(valueOf4).append(join).append(valueOf5).append(zzave).append(valueOf6).append(zzava).append(valueOf7).append(zzavf).append(valueOf8).append(zzavg).append(valueOf9).append(zzavb).toString();
    }

    public String zzauz() {
        return this.f10865d;
    }

    public String zzava() {
        return this.f10866e;
    }

    public String zzavb() {
        return this.f10867f;
    }

    public int zzavc() {
        return this.f10868g;
    }

    public List<String> zzavd() {
        return this.f10869h;
    }

    public int zzave() {
        return this.f10872k;
    }

    public String zzavf() {
        return this.f10873l;
    }

    public float zzavg() {
        return this.f10874m;
    }

    public long zzavh() {
        return this.f10875n;
    }
}
