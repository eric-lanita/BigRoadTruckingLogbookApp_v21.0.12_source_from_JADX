package com.bigroad.shared;

import com.bigroad.shared.eobr.turbo.C1015l;
import com.bigroad.shared.model.CanonicalOdometerUnit;
import com.bigroad.ttb.protocol.TTProtocol.Event;
import com.bigroad.ttb.protocol.TTProtocol.Event.C2647a;
import com.bigroad.ttb.protocol.TTProtocol.EventType;
import com.bigroad.ttb.protocol.TTProtocol.OdometerUnit;
import com.bigroad.ttb.protocol.TTProtocol.bn;
import com.facebook.share.internal.ShareConstants;
import com.google.common.base.MoreObjects;
import com.google.common.base.MoreObjects.ToStringHelper;
import com.google.common.collect.BoundType;
import com.google.common.collect.Range;
import com.google.protobuf.C3642c;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public abstract class C1144s {
    public static final Comparator<Event> f3800a = new C11431();
    private static final List<String> f3801b = Collections.unmodifiableList(Arrays.asList(new String[]{"DASH_LINK_NOT_CONNECTED", "DASH_LINK_ODOMETER_FAST", "DASH_LINK_ODOMETER_SLOW", "CONNECTED_WITH_NO_ROAD_SPEED", "MISSING_ROAD_SPEED_DATA", "DASH_LINK_UNCALIBRATED_ODOMETER", "WRONG_FIRMWARE_VERSION"}));
    private static final CanonicalOdometerUnit f3802c = CanonicalOdometerUnit.MILES;

    static class C11431 implements Comparator<Event> {
        C11431() {
        }

        public /* synthetic */ int compare(Object obj, Object obj2) {
            return m5755a((Event) obj, (Event) obj2);
        }

        public int m5755a(Event event, Event event2) {
            int signum = Long.signum(event.getOccurredAt() - event2.getOccurredAt());
            if (signum == 0) {
                return ai.f2620a.compare(event.getEventId(), event2.getEventId());
            }
            return signum;
        }
    }

    public static Range<Long> m5758a(bn bnVar) {
        long minDuration;
        long j = 0;
        if (bnVar.hasMinDuration()) {
            minDuration = bnVar.getMinDuration();
        } else {
            minDuration = 0;
        }
        if (minDuration >= 0) {
            j = minDuration;
        }
        return Range.m18691a(Long.valueOf(bnVar.getOccurredAt()), BoundType.CLOSED, Long.valueOf(j + bnVar.getOccurredAt()), BoundType.OPEN);
    }

    public static boolean m5759a(Event event) {
        switch (event.getEventType()) {
            case 3:
            case 4:
            case 5:
            case 6:
            case 9:
            case 11:
            case 13:
            case 15:
            case 16:
            case 23:
            case 25:
            case 26:
            case 27:
            case 28:
            case 29:
            case 30:
            case 31:
            case 32:
            case 33:
            case 34:
            case 36:
                return true;
            default:
                return false;
        }
    }

    public static Event m5757a(Event event, Collection<Event> collection) {
        if (event.getEventType() != 16) {
            return null;
        }
        for (Event event2 : collection) {
            if (event2.getEventType() == 16 && event2.getNotes().equals(C1180y.m5989a(event.getEventId()))) {
                return event2;
            }
        }
        return null;
    }

    public static CanonicalOdometerUnit m5761b(Event event) {
        if (event == null || event.getEventType() != 16) {
            return f3802c;
        }
        if (!am.m4189a("ODOMETER_ADJUSTMENT_BEFORE", event.getEventSubtype()) && !am.m4189a("ODOMETER_ADJUSTMENT_AFTER", event.getEventSubtype())) {
            return f3802c;
        }
        if (!event.hasContextualData()) {
            return f3802c;
        }
        OdometerUnit a = OdometerUnit.m14668a((int) event.getContextualData());
        if (a == null) {
            return f3802c;
        }
        return CanonicalOdometerUnit.m5466a(a);
    }

    public static String m5763c(Event event) {
        if (event == null) {
            return "null";
        }
        ToStringHelper add = MoreObjects.toStringHelper(Event.class).add(ShareConstants.WEB_DIALOG_PARAM_ID, C1180y.m5989a(event.getEventId())).add("personId", event.getPersonId()).add("truckId", event.getTruckId()).add(ShareConstants.MEDIA_TYPE, EventType.m13979a(event.getEventType())).add("occurredAt", aq.m4233e(event.getOccurredAt()));
        if (event.getImmutableDutySegment()) {
            add.add("immutable", true);
        }
        if (event.hasMinDuration()) {
            add.add("minDuration", event.getMinDuration());
        }
        if (event.hasDistanceMeters()) {
            add.add("distanceMeters", event.getDistanceMeters());
        }
        if (event.hasVarPosition()) {
            add.add("position", C1015l.m5227a(event.getVarPosition()));
        }
        if (event.getImmutableDutySegment()) {
            add.add("statusMask", event.getStatusMask());
        }
        if (event.hasNotes()) {
            add.add("notes", event.getNotes());
        }
        if (event.hasAssociatedDashLink()) {
            add.add("dashlink", C1180y.m5996c(event.getAssociatedDashLink().m19091d()));
        }
        if (event.hasAssociatedGenxDevice()) {
            add.add("genx", event.getAssociatedGenxDevice());
        }
        return add.toString();
    }

    public static boolean m5760a(Event event, Event event2) {
        return ai.m4177a(C1144s.m5756a(event.toBuilder()), C1144s.m5756a(event2.toBuilder()));
    }

    public static Event m5756a(C2647a c2647a) {
        return c2647a.m13830G().m13831H().m13829F().m13862c();
    }

    public static byte[] m5764d(Event event) {
        if (event.hasAssociatedGenxDevice()) {
            return event.getAssociatedGenxDevice().getBytes();
        }
        if (event.hasAssociatedDashLink()) {
            return event.getAssociatedDashLink().m19091d();
        }
        return null;
    }

    public static boolean m5762b(Event event, Event event2) {
        if (event == null || event2 == null) {
            return false;
        }
        if (event.hasAssociatedGenxDevice()) {
            String associatedGenxDevice = event.getAssociatedGenxDevice();
            if (event2.hasAssociatedGenxDevice() && am.m4189a(associatedGenxDevice, event2.getAssociatedGenxDevice())) {
                return true;
            }
            return false;
        } else if (!event.hasAssociatedDashLink()) {
            return false;
        } else {
            C3642c associatedDashLink = event.getAssociatedDashLink();
            if (event2.hasAssociatedDashLink() && associatedDashLink.equals(event2.getAssociatedDashLink())) {
                return true;
            }
            return false;
        }
    }
}
