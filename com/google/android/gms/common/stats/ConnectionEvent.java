package com.google.android.gms.common.stats;

import android.os.Parcel;
import android.os.Parcelable.Creator;

public final class ConnectionEvent extends StatsEvent {
    public static final Creator<ConnectionEvent> CREATOR = new zza();
    final int f10850a;
    private final long f10851b;
    private int f10852c;
    private final String f10853d;
    private final String f10854e;
    private final String f10855f;
    private final String f10856g;
    private final String f10857h;
    private final String f10858i;
    private final long f10859j;
    private final long f10860k;
    private long f10861l;

    ConnectionEvent(int i, long j, int i2, String str, String str2, String str3, String str4, String str5, String str6, long j2, long j3) {
        this.f10850a = i;
        this.f10851b = j;
        this.f10852c = i2;
        this.f10853d = str;
        this.f10854e = str2;
        this.f10855f = str3;
        this.f10856g = str4;
        this.f10861l = -1;
        this.f10857h = str5;
        this.f10858i = str6;
        this.f10859j = j2;
        this.f10860k = j3;
    }

    public ConnectionEvent(long j, int i, String str, String str2, String str3, String str4, String str5, String str6, long j2, long j3) {
        this(1, j, i, str, str2, str3, str4, str5, str6, j2, j3);
    }

    public int getEventType() {
        return this.f10852c;
    }

    public long getTimeMillis() {
        return this.f10851b;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zza.m16986a(this, parcel, i);
    }

    public String zzaun() {
        return this.f10853d;
    }

    public String zzauo() {
        return this.f10854e;
    }

    public String zzaup() {
        return this.f10855f;
    }

    public String zzauq() {
        return this.f10856g;
    }

    public String zzaur() {
        return this.f10857h;
    }

    public String zzaus() {
        return this.f10858i;
    }

    public long zzaut() {
        return this.f10861l;
    }

    public long zzauu() {
        return this.f10860k;
    }

    public long zzauv() {
        return this.f10859j;
    }

    public String zzauw() {
        String valueOf = String.valueOf("\t");
        String valueOf2 = String.valueOf(zzaun());
        String valueOf3 = String.valueOf(zzauo());
        String valueOf4 = String.valueOf("\t");
        String valueOf5 = String.valueOf(zzaup());
        String valueOf6 = String.valueOf(zzauq());
        String valueOf7 = String.valueOf("\t");
        String str = this.f10857h == null ? "" : this.f10857h;
        String valueOf8 = String.valueOf("\t");
        return new StringBuilder(((((((((String.valueOf(valueOf).length() + 22) + String.valueOf(valueOf2).length()) + String.valueOf(valueOf3).length()) + String.valueOf(valueOf4).length()) + String.valueOf(valueOf5).length()) + String.valueOf(valueOf6).length()) + String.valueOf(valueOf7).length()) + String.valueOf(str).length()) + String.valueOf(valueOf8).length()).append(valueOf).append(valueOf2).append("/").append(valueOf3).append(valueOf4).append(valueOf5).append("/").append(valueOf6).append(valueOf7).append(str).append(valueOf8).append(zzauu()).toString();
    }
}
