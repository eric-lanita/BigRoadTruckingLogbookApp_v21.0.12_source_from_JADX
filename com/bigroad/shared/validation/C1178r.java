package com.bigroad.shared.validation;

import com.bigroad.shared.am;
import com.bigroad.shared.dailylog.DailyLogUtils.DailyLogType;
import com.bigroad.shared.duty.C0874m;
import com.bigroad.shared.duty.DutyStatus;
import com.bigroad.shared.gaps.model.C1091d;
import com.bigroad.shared.model.CanonicalOdometerUnit;
import com.bigroad.shared.validation.ValidationError.ErrorCode;
import com.bigroad.shared.validation.ValidationError.Severity;
import com.bigroad.shared.validation.model.DailyLog;
import com.bigroad.shared.validation.model.DailyLogHeader;
import com.bigroad.shared.validation.model.DailyLogTruck;
import com.bigroad.shared.validation.model.Event;
import java.util.ArrayList;
import java.util.List;

public class C1178r {
    static boolean m5975a(DailyLog dailyLog) {
        for (Event event : dailyLog.mo859c()) {
            if (event.mo702m() != DutyStatus.OFF_DUTY && event.mo702m() != DutyStatus.OFF_DUTY_DRIVING) {
                return false;
            }
        }
        return true;
    }

    static boolean m5984b(DailyLog dailyLog) {
        for (Event m : dailyLog.mo859c()) {
            if (m.mo702m() == DutyStatus.DRIVING) {
                return true;
            }
        }
        return false;
    }

    static boolean m5974a(C1157a c1157a, int i) {
        if (c1157a == null) {
            return false;
        }
        boolean z;
        C0874m a = c1157a.mo1221a(i);
        if (a.mo704c() && a.mo709h().m4905g()) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return a.mo709h().m4906h();
        }
        if ((a.mo704c() && a.mo709h().m4904f()) || (a.mo705d() && a.mo710i().m4904f())) {
            return true;
        }
        return false;
    }

    public static DailyLogType m5971a(DailyLogHeader dailyLogHeader) {
        if (dailyLogHeader.mo832i().isEmpty() && dailyLogHeader.mo833j().isEmpty() && (!am.m4188a(dailyLogHeader.mo837n()) || dailyLogHeader.mo838o() != null || dailyLogHeader.mo839p() != null)) {
            return DailyLogType.SINGLE_TRUCK_FIELD;
        }
        return DailyLogType.MULTI_TRUCK;
    }

    public static Severity m5972a(C1176p<?> c1176p, ErrorCode errorCode) {
        Severity severity = null;
        if (c1176p != null) {
            for (List<ValidationError> it : c1176p.m5964c().values()) {
                for (ValidationError validationError : it) {
                    Severity severity2;
                    if (validationError.m5780b() != errorCode || (severity != null && validationError.m5782d().compareTo(severity) <= 0)) {
                        severity2 = severity;
                    } else {
                        severity2 = validationError.m5782d();
                    }
                    severity = severity2;
                }
            }
        }
        return severity;
    }

    public static Severity m5973a(C1176p<?> c1176p, List<ErrorCode> list) {
        Severity severity = null;
        if (c1176p != null) {
            for (List<ValidationError> it : c1176p.m5964c().values()) {
                for (ValidationError validationError : it) {
                    Severity severity2;
                    if (!list.contains(validationError.m5780b()) || (severity != null && validationError.m5782d().compareTo(severity) <= 0)) {
                        severity2 = severity;
                    } else {
                        severity2 = validationError.m5782d();
                    }
                    severity = severity2;
                }
            }
        }
        return severity;
    }

    public static boolean m5980a(List<ValidationError> list, ErrorCode errorCode) {
        return C1178r.m5983b((List) list, errorCode) != null;
    }

    public static Severity m5983b(List<ValidationError> list, ErrorCode errorCode) {
        Enum enumR = null;
        for (ValidationError validationError : list) {
            Enum enumR2;
            if (validationError.m5780b() != errorCode || (enumR != null && validationError.m5782d().compareTo(enumR) <= 0)) {
                enumR2 = enumR;
            } else {
                enumR2 = validationError.m5782d();
            }
            enumR = enumR2;
        }
        return enumR;
    }

    public static <FIELD_ENUM extends Enum<FIELD_ENUM>> boolean m5978a(C1176p<FIELD_ENUM> c1176p, FIELD_ENUM field_enum, ErrorCode errorCode) {
        return C1178r.m5982b(c1176p, field_enum, errorCode) != null;
    }

    public static <FIELD_ENUM extends Enum<FIELD_ENUM>> Severity m5982b(C1176p<FIELD_ENUM> c1176p, FIELD_ENUM field_enum, ErrorCode errorCode) {
        if (c1176p == null) {
            return null;
        }
        return C1178r.m5983b(c1176p.m5961b((Enum) field_enum), errorCode);
    }

    public static boolean m5977a(C0887n<?> c0887n, ErrorCode[] errorCodeArr) {
        return C1178r.m5981b((C0887n) c0887n, errorCodeArr) != null;
    }

    public static Severity m5981b(C0887n<?> c0887n, ErrorCode[] errorCodeArr) {
        Severity severity = null;
        if (c0887n != null) {
            C1176p A = c0887n.mo716A();
            if (A != null) {
                for (List<ValidationError> it : A.m5964c().values()) {
                    for (ValidationError validationError : it) {
                        Object obj;
                        Severity severity2;
                        for (ErrorCode errorCode : errorCodeArr) {
                            if (errorCode == validationError.m5780b()) {
                                obj = 1;
                                break;
                            }
                        }
                        obj = null;
                        if (obj != null || (severity != null && validationError.m5782d().compareTo(severity) <= 0)) {
                            severity2 = severity;
                        } else {
                            severity2 = validationError.m5782d();
                        }
                        severity = severity2;
                    }
                }
            }
        }
        return severity;
    }

    public static List<ValidationError> m5985c(List<ValidationError> list, ErrorCode errorCode) {
        List arrayList = new ArrayList(list.size());
        for (ValidationError validationError : list) {
            if (validationError.m5780b() != errorCode) {
                arrayList.add(validationError);
            }
        }
        return arrayList;
    }

    public static boolean m5976a(DailyLogTruck dailyLogTruck, C1091d c1091d) {
        CanonicalOdometerUnit f = c1091d.m5422f();
        if (dailyLogTruck.a_() != c1091d.m5418b() || !am.m4189a(dailyLogTruck.mo823b(), c1091d.m5420d()) || dailyLogTruck.mo782t().m14669a() != f.m5472b().m14669a()) {
            return false;
        }
        int i;
        if (c1091d.m5425i()) {
            i = (dailyLogTruck.mo779f() == null && dailyLogTruck.mo780g() == null) ? 1 : 0;
        } else {
            if (C1178r.m5979a(dailyLogTruck.mo779f(), Long.valueOf(c1091d.m5421e()), c1091d.m5422f())) {
                i = 2;
            } else {
                i = 0;
            }
            if (C1178r.m5979a(dailyLogTruck.mo780g(), Long.valueOf(c1091d.m5423g()), c1091d.m5424h())) {
                i += 2;
            }
        }
        if (C1178r.m5979a(dailyLogTruck.mo781i(), Long.valueOf(c1091d.m5426j()), f)) {
            i++;
        }
        if (i < 2) {
            return false;
        }
        return true;
    }

    public static boolean m5979a(Integer num, Long l, CanonicalOdometerUnit canonicalOdometerUnit) {
        if (num == null || l == null) {
            if (num == null && l == null) {
                return true;
            }
            return false;
        } else if (Math.round(canonicalOdometerUnit.m5471b(l.longValue())) != num.longValue()) {
            return false;
        } else {
            return true;
        }
    }
}
