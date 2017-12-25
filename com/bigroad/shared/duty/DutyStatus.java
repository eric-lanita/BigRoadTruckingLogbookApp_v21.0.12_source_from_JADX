package com.bigroad.shared.duty;

import com.bigroad.shared.duty.C0896g.C0870a;
import com.bigroad.ttb.protocol.TTProtocol.Event;
import com.bigroad.ttb.protocol.TTProtocol.EventType;
import java.util.ArrayList;
import java.util.List;

public enum DutyStatus implements C0870a, C0871l {
    OFF_DUTY(EventType.OFF_DUTY, false, false),
    SLEEPER(EventType.SLEEPER, false, false),
    DRIVING(EventType.DRIVING, true, true),
    ON_DUTY_NOT_DRIVING(EventType.ON_DUTY_NOT_DRIVING, true, false),
    OFF_DUTY_WAITING(EventType.OFF_DUTY_WAITING, false, false),
    OFF_DUTY_DRIVING(EventType.OFF_DUTY_DRIVING, false, true),
    ELD_YARD_MOVE(EventType.ELD_YARD_MOVE, true, true);
    
    private final EventType m_eventType;
    private final boolean m_isDriving;
    private final boolean m_isOnDuty;

    private DutyStatus(EventType eventType, boolean z, boolean z2) {
        this.m_eventType = eventType;
        this.m_isOnDuty = z;
        this.m_isDriving = z2;
    }

    public DutyStatus mo702m() {
        return this;
    }

    public EventType m4392a() {
        return this.m_eventType;
    }

    public int m4394b() {
        return this.m_eventType.m13980a();
    }

    public boolean m4395c() {
        return this.m_isOnDuty;
    }

    public boolean m4396d() {
        return !this.m_isOnDuty;
    }

    public boolean m4397e() {
        return this.m_isDriving;
    }

    public DutyStatus m4398f() {
        if (!m4397e()) {
            return this;
        }
        if (m4396d()) {
            return OFF_DUTY;
        }
        return ON_DUTY_NOT_DRIVING;
    }

    public boolean mo701a(DutyStatus dutyStatus) {
        return dutyStatus == this;
    }

    public static DutyStatus m4385a(EventType eventType) {
        switch (eventType) {
            case OFF_DUTY:
                return OFF_DUTY;
            case SLEEPER:
                return SLEEPER;
            case DRIVING:
                return DRIVING;
            case ON_DUTY_NOT_DRIVING:
                return ON_DUTY_NOT_DRIVING;
            case OFF_DUTY_WAITING:
                return OFF_DUTY_WAITING;
            case OFF_DUTY_DRIVING:
                return OFF_DUTY_DRIVING;
            case ELD_YARD_MOVE:
                return ELD_YARD_MOVE;
            default:
                throw new IllegalArgumentException(eventType.toString() + " is not a valid duty status event type.");
        }
    }

    public static DutyStatus m4383a(int i) {
        return m4385a(EventType.m13979a(i));
    }

    public static DutyStatus m4384a(Event event) {
        return m4383a(event.getEventType());
    }

    public static boolean m4389b(Event event) {
        return m4387b(event.getEventType());
    }

    public static boolean m4390b(EventType eventType) {
        return m4387b(eventType.m13980a());
    }

    public static boolean m4387b(int i) {
        switch (i) {
            case 3:
            case 4:
            case 5:
            case 6:
            case 9:
            case 23:
            case 34:
                return true;
            default:
                return false;
        }
    }

    public static boolean m4391c(Event event) {
        return m4389b(event) && m4384a(event).m4397e();
    }

    public static boolean m4388b(DutyStatus dutyStatus) {
        return dutyStatus != null && dutyStatus.m4397e();
    }

    public static List<Event> m4386a(List<Event> list) {
        List<Event> arrayList = new ArrayList();
        for (Event event : list) {
            if (m4389b(event)) {
                arrayList.add(event);
            }
        }
        return arrayList;
    }
}
