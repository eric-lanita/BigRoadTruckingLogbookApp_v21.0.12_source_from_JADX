package com.bigroad.shared.eobr.genx;

public enum GenxEntryReasonCode {
    UNKNOWN(-1),
    POWERUP(0),
    SHORT_PWROUT(1),
    IGNITION_OFF(2),
    IGNITION_ON(3),
    ALARM_TRIPPED(4),
    POWER_OFF(5),
    PERIODIC(6),
    ILLEGAL_PWRUP(7),
    POLL(8),
    GPS_LOST(10),
    GPS_FOUND(11),
    ARRIVED(12),
    DEPARTED(13),
    IN_REGION(14),
    OUT_REGION(15),
    IDLE_TIMER(16),
    PARK_TIMER(17),
    SPEEDING_START(18),
    SPEEDING_STOP(19),
    S1_ON(20),
    S2_ON(21),
    S3_ON(22),
    S4_ON(23),
    S1_OFF(24),
    S2_OFF(25),
    S3_OFF(26),
    S4_OFF(27),
    BEGIN_STOP(28),
    BEGIN_MOVE(29),
    DISTANCE(30),
    POWER_OFF_BATT(31),
    USER_MESSAGE(32),
    USER_RESET(33),
    Q_RESET(34),
    START_OTAP(35),
    CR(36),
    SW_MOVING_START(37),
    SW_MOVING_END(38),
    GPS_ANT_SHORT(39),
    GPS_ANT_OPEN(40),
    IN_COVERAGE(41),
    NO_COVERAGE(42),
    SIM_REMOVED(43),
    EMERGENCY(44),
    TEMP_HIGH(45),
    TEMP_LOW(46),
    POWER_CONNECTED(48),
    POWER_DISCONNECTED(49),
    BACKUP_POWER_GOOD(50),
    BACKUP_POWER_BAD(51),
    FIRST_FIX(54),
    S5_ON(55),
    S5_OFF(56),
    SPEEDING2_START(57),
    SPEEDING2_END(58),
    ILLEGAL_POWEROFF(59),
    HEADING(60),
    GPS_ACCEL(61),
    GPS_DECEL(62),
    ENGINE_OFF(63),
    ENGINE_ON(64),
    IB_IN(65),
    IB_OUT(66),
    CALLFAILED(70),
    PND_CONNECT(71),
    PND_DISCONNECT(72),
    ALARMEND(77),
    C_START(87),
    C_END(88),
    AGPS(95),
    SHORT_BIN(96),
    M_OFF(97),
    M_ON(98),
    PEPTO(99),
    HARSH_TURN(100),
    IB_BAD(102),
    TILT(103),
    SBD(104),
    INTFC(106),
    IPSUM(107),
    GPSJAM(108),
    VIN(109),
    TOW_START(110),
    TOW_STOP(111),
    TOW_EVENT(112),
    TPERIODIC(113),
    RELAY(115),
    CS440(116),
    TAMPER(117),
    USAGE(119),
    BUS(120),
    RPM_LOAD(121),
    ELD(123);
    
    private final int m_reasonCode;

    private GenxEntryReasonCode(int i) {
        this.m_reasonCode = i;
    }

    public int m4986a() {
        return this.m_reasonCode;
    }

    public static GenxEntryReasonCode m4982a(int i) {
        for (GenxEntryReasonCode genxEntryReasonCode : values()) {
            if (genxEntryReasonCode.m4986a() == i) {
                return genxEntryReasonCode;
            }
        }
        return UNKNOWN;
    }

    public static boolean m4983a(GenxEntryReasonCode genxEntryReasonCode) {
        return genxEntryReasonCode == POWERUP || genxEntryReasonCode == ILLEGAL_PWRUP;
    }

    public static boolean m4984b(GenxEntryReasonCode genxEntryReasonCode) {
        return genxEntryReasonCode == ENGINE_ON;
    }

    public static boolean m4985c(GenxEntryReasonCode genxEntryReasonCode) {
        return genxEntryReasonCode == ENGINE_OFF;
    }
}
