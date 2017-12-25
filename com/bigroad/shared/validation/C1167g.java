package com.bigroad.shared.validation;

import com.bigroad.shared.validation.model.Event;
import com.bigroad.shared.validation.model.Event.Field;

public abstract class C1167g {
    private static C1176p<Field> m5933a(Event event) {
        C1176p<Field> A = event.mo716A();
        A.m5955a();
        return A;
    }

    private static boolean m5938c(Event event, C1157a c1157a, int i) {
        return (C1178r.m5974a(c1157a, i) || event.mo720v()) ? false : true;
    }

    public static void m5934a(Event event, C1157a c1157a, int i) {
        C1167g.m5939d(event, c1157a, i);
    }

    public static void m5936b(Event event, C1157a c1157a, int i) {
        C1176p a = C1167g.m5933a(event);
        C1167g.m5935a(event, c1157a, i, a);
        C1167g.m5937b(event, c1157a, i, a);
    }

    private static void m5939d(Event event, C1157a c1157a, int i) {
        if (C1167g.m5938c(event, c1157a, i)) {
            C1171j.m5945a(Field.LOCATION_NAME, event.mo724t(), C1167g.m5933a(event), new C1175o(ValidationMessageId.EVENT_LOCATION_REQUIRED));
        }
    }

    private static void m5935a(Event event, C1157a c1157a, int i, C1176p<Field> c1176p) {
        if (C1167g.m5938c(event, c1157a, i)) {
            C1173l.m5950a(Field.LOCATION_NAME, event.mo724t(), 5, 60, c1176p, new C1175o(ValidationMessageId.EVENT_LOCATION_TOO_SHORT), new C1175o(ValidationMessageId.EVENT_LOCATION_TOO_LONG));
        }
    }

    private static void m5937b(Event event, C1157a c1157a, int i, C1176p<Field> c1176p) {
        if (C1167g.m5938c(event, c1157a, i)) {
            C1173l.m5950a(Field.EVENT_NOTE, event.mo725u(), 4, 60, c1176p, new C1175o(ValidationMessageId.EVENT_NOTE_TOO_SHORT), new C1175o(ValidationMessageId.EVENT_NOTE_TOO_LONG));
        }
    }
}
