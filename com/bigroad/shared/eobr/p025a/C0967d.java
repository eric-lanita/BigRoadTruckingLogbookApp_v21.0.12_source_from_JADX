package com.bigroad.shared.eobr.p025a;

import com.bigroad.shared.C1180y;

public abstract class C0967d {
    public static String m4964a(byte b) {
        switch (b) {
            case (byte) -1:
                return "REQ";
            case (byte) 0:
                return "ACK";
            case (byte) 1:
                return "FA_J1939";
            case (byte) 2:
                return "FD_J1939";
            case (byte) 3:
                return "FA_J1587";
            case (byte) 4:
                return "FD_J1587";
            case (byte) 5:
                return "TX_J1939";
            case (byte) 6:
                return "RX_J1939";
            case (byte) 7:
                return "PX_J1939";
            case (byte) 8:
                return "TX_J1587";
            case (byte) 9:
                return "RX_J1587";
            case (byte) 10:
                return "PX_J1587";
            case (byte) 17:
                return "CPU_RESET";
            case (byte) 18:
                return "PAMODE_SET";
            case (byte) 23:
                return "STATS";
            case (byte) 25:
                return "ACONN";
            case (byte) 40:
                return "FA_OBD2";
            case (byte) 41:
                return "FD_OBD2";
            case (byte) 42:
                return "TX_OBD2";
            case (byte) 43:
                return "RX_OBD2";
            case (byte) 44:
                return "PX_OBD2";
            case (byte) 45:
                return "OBD_STATS";
            case (byte) 46:
                return "ODO";
            default:
                return "MSG_" + C1180y.m5988a(b);
        }
    }
}
