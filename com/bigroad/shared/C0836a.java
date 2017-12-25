package com.bigroad.shared;

import java.text.DateFormat;
import java.util.Date;
import java.util.TimeZone;

public abstract class C0836a implements ao {
    public long mo689a() {
        return Math.max(0, mo698g() - mo697f());
    }

    public boolean mo691a(ao aoVar) {
        return mo697f() <= aoVar.mo697f() && aoVar.mo698g() <= mo698g();
    }

    public boolean mo690a(long j) {
        return mo697f() <= j && j < mo698g();
    }

    public boolean mo693b(ao aoVar) {
        return aoVar.mo698g() > mo697f() && mo698g() > aoVar.mo697f();
    }

    public boolean m4128c(ao aoVar) {
        return mo698g() <= aoVar.mo697f();
    }

    public boolean mo692b(long j) {
        return mo698g() <= j;
    }

    public boolean mo695d(ao aoVar) {
        return aoVar.mo698g() <= mo697f();
    }

    public boolean mo694c(long j) {
        return mo697f() > j;
    }

    public ao mo696e(ao aoVar) {
        if (aoVar.mo691a((ao) this)) {
            return this;
        }
        if (mo691a(aoVar)) {
            return aoVar;
        }
        long max = Math.max(mo697f(), aoVar.mo697f());
        super(max, Math.max(max, Math.min(mo698g(), aoVar.mo698g())));
        return this;
    }

    public String toString() {
        DateFormat dateTimeInstance = DateFormat.getDateTimeInstance(2, 2);
        dateTimeInstance.setTimeZone(TimeZone.getTimeZone("UTC"));
        return "TimeInterval [startTimeUTC=" + dateTimeInstance.format(new Date(mo697f())) + ", endTimeUTC=" + dateTimeInstance.format(new Date(mo698g())) + ", duration=" + aq.m4232d(mo689a()) + "]";
    }
}
