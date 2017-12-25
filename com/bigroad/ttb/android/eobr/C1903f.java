package com.bigroad.ttb.android.eobr;

public class C1903f {
    private long f6579a;
    private long f6580b;
    private long f6581c;
    private long f6582d;
    private long f6583e;
    private long f6584f;
    private long f6585g;
    private long f6586h;
    private long f6587i;
    private long f6588j;
    private long f6589k;
    private long f6590l;
    private long f6591m;
    private long f6592n;
    private int f6593o;
    private int f6594p;

    public void m9301a() {
        this.f6579a++;
    }

    public void m9304b() {
        this.f6580b++;
    }

    public void m9305c() {
        this.f6581c++;
    }

    public void m9306d() {
        this.f6582d++;
    }

    public void m9307e() {
        this.f6583e++;
    }

    public void m9303a(long j, long j2, long j3) {
        this.f6584f++;
        this.f6593o = (int) (j - this.f6590l);
        this.f6594p = (int) (j3 - this.f6592n);
        this.f6590l = j;
        this.f6591m = j2;
        this.f6592n = j3;
    }

    public void m9302a(long j) {
        this.f6585g++;
        this.f6594p = (int) (j - this.f6592n);
        this.f6592n = j;
    }

    public void m9308f() {
        this.f6586h++;
    }

    public void m9309g() {
        this.f6587i++;
    }

    public void m9310h() {
        this.f6588j++;
    }

    public void m9311i() {
        this.f6589k++;
    }

    public String toString() {
        return "Statistics [m_totalFrames=" + this.f6579a + ", m_badChecksum=" + this.f6580b + ", m_shortMessage=" + this.f6581c + ", m_unrecognizedMessage=" + this.f6582d + ", m_shortPayload=" + this.f6583e + ", m_vnaStats=" + this.f6584f + ", m_vnaObdStats=" + this.f6585g + ", m_vnaRx1939=" + this.f6586h + ", m_vnaRx1587=" + this.f6587i + ", m_vnaRxOBD2=" + this.f6588j + ", m_vnaRxODO=" + this.f6589k + ", m_valid1708Messages=" + this.f6590l + ", m_invalid1708Bytes=" + this.f6591m + ", m_canFrames=" + this.f6592n + "]";
    }
}
