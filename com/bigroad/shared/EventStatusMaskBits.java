package com.bigroad.shared;

public class EventStatusMaskBits {

    public interface C0825a {
        long mo687a();
    }

    public enum LocationStatus implements C0825a {
        REVERSE_GEOCODED(17),
        REVERSE_GEOCODE_ATTEMPTED(18),
        RELATIVE_LOCATION_ATTEMPTED(19);
        
        private final long m_bitmask;

        private LocationStatus(long j) {
            this.m_bitmask = 1 << ((int) j);
        }

        public long mo687a() {
            return this.m_bitmask;
        }
    }

    public enum RecordOrigin {
        UNKNOWN,
        AUTOMATICALLY_RECORDED,
        MANUAL_ENTRY,
        EDIT_REQUEST,
        UNIDENTIFIED_DRIVER
    }

    public enum RecordStatus {
        UNKNOWN,
        ACTIVE,
        INACTIVE_CHANGED,
        INACTIVE_CHANGE_REQUESTED,
        INACTIVE_CHANGE_REJECTED
    }

    public static RecordStatus m4077a(long j) {
        int i = (int) (255 & j);
        RecordStatus recordStatus = RecordStatus.UNKNOWN;
        if (i < RecordStatus.values().length) {
            return RecordStatus.values()[i];
        }
        return recordStatus;
    }

    public static long m4076a(RecordStatus recordStatus) {
        if (recordStatus == null) {
            recordStatus = RecordStatus.UNKNOWN;
        }
        return ((long) recordStatus.ordinal()) & 255;
    }

    public static long m4072a(long j, RecordStatus recordStatus) {
        if (recordStatus == null) {
            recordStatus = RecordStatus.UNKNOWN;
        }
        return (-256 & j) | (((long) recordStatus.ordinal()) & 255);
    }

    public static RecordOrigin m4081b(long j) {
        int i = (int) ((65280 & j) >> 8);
        RecordOrigin recordOrigin = RecordOrigin.UNKNOWN;
        if (i < RecordOrigin.values().length) {
            return RecordOrigin.values()[i];
        }
        return recordOrigin;
    }

    public static long m4071a(long j, RecordOrigin recordOrigin) {
        if (recordOrigin == null) {
            recordOrigin = RecordOrigin.UNKNOWN;
        }
        return (-65281 & j) | (((long) (recordOrigin.ordinal() << 8)) & 65280);
    }

    public static boolean m4082c(long j) {
        return m4079a(j, LocationStatus.REVERSE_GEOCODED);
    }

    public static long m4074a(long j, boolean z) {
        return m4073a(j, LocationStatus.REVERSE_GEOCODED, z);
    }

    public static long m4080b(long j, boolean z) {
        return m4073a(j, LocationStatus.REVERSE_GEOCODE_ATTEMPTED, z);
    }

    public static boolean m4083d(long j) {
        return m4079a(j, LocationStatus.RELATIVE_LOCATION_ATTEMPTED);
    }

    private static boolean m4079a(long j, C0825a c0825a) {
        return m4078a(j, c0825a.mo687a());
    }

    private static boolean m4078a(long j, long j2) {
        return (j & j2) != 0;
    }

    private static long m4073a(long j, C0825a c0825a, boolean z) {
        return m4070a(j, c0825a.mo687a(), z);
    }

    private static long m4070a(long j, long j2, boolean z) {
        if (z) {
            return j | j2;
        }
        return (-1 ^ j2) & j;
    }

    public static long m4075a(RecordOrigin recordOrigin, RecordStatus recordStatus) {
        return m4072a(m4071a(0, recordOrigin), recordStatus);
    }
}
