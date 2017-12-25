package com.bigroad.shared;

import com.bigroad.ttb.protocol.TTProtocol.ct;
import java.util.TimeZone;

public abstract class ah {
    public static String m4160a(ct ctVar) {
        CharSequence firstName = ctVar.getFirstName();
        CharSequence lastName = ctVar.getLastName();
        if (!am.m4188a(firstName)) {
            return am.m4188a(lastName) ? firstName : firstName + " " + lastName;
        } else {
            if (am.m4188a(lastName)) {
                return ctVar.getEmailAddress();
            }
            return lastName;
        }
    }

    public static String m4162b(ct ctVar) {
        CharSequence firstName = ctVar.getFirstName();
        if (!am.m4188a(firstName)) {
            return firstName;
        }
        firstName = ctVar.getLastName();
        if (am.m4188a(firstName)) {
            return ctVar.getEmailAddress();
        }
        return firstName;
    }

    public static String m4161a(ct ctVar, String str, boolean z, boolean z2) {
        CharSequence charSequence = "";
        if (ctVar != null) {
            CharSequence firstName = ctVar.getFirstName();
            charSequence = ctVar.getLastName();
            if (!am.m4188a(firstName)) {
                if (am.m4188a(charSequence)) {
                    charSequence = firstName;
                } else if (z) {
                    charSequence = firstName + " " + charSequence;
                } else {
                    charSequence = firstName.charAt(0) + ". " + charSequence;
                }
            }
        }
        if (!am.m4188a(charSequence) || !z2) {
            return charSequence;
        }
        if (str == null) {
            str = "";
        }
        return str;
    }

    public static TimeZone m4163c(ct ctVar) {
        if (ctVar == null || !ctVar.hasHosHomeTimezoneId()) {
            return TimeZone.getDefault();
        }
        return TimeZone.getTimeZone(ctVar.getHosHomeTimezoneId());
    }

    public static boolean m4164d(ct ctVar) {
        if (ctVar == null) {
            return false;
        }
        return ctVar.getHosUs7DayCycleEnabled();
    }

    public static boolean m4165e(ct ctVar) {
        if (ctVar == null) {
            return true;
        }
        if (ctVar.hasHosUs8DayCycleEnabled()) {
            return ctVar.getHosUs8DayCycleEnabled();
        }
        if (m4164d(ctVar) || m4166f(ctVar) || m4167g(ctVar)) {
            return false;
        }
        return true;
    }

    public static boolean m4166f(ct ctVar) {
        if (ctVar == null) {
            return false;
        }
        return ctVar.getHosCanadianCycle1Enabled();
    }

    public static boolean m4167g(ct ctVar) {
        if (ctVar == null) {
            return false;
        }
        return ctVar.getHosCanadianCycle2Enabled();
    }

    public static long m4168h(ct ctVar) {
        return ctVar == null ? 0 : ctVar.getHosUs7DayCycleFlags();
    }

    public static long m4169i(ct ctVar) {
        return ctVar == null ? 0 : ctVar.getHosUs8DayCycleFlags();
    }

    public static long m4170j(ct ctVar) {
        return ctVar == null ? 0 : ctVar.getHosCanadianCycle1Flags();
    }

    public static long m4171k(ct ctVar) {
        return ctVar == null ? 0 : ctVar.getHosCanadianCycle2Flags();
    }
}
