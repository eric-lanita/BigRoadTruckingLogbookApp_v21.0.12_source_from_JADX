package com.bigroad.ttb.android.status.messages;

import android.content.Context;
import com.bigroad.shared.C1180y;
import com.bigroad.shared.an;
import com.bigroad.ttb.android.OurApplication;
import com.bigroad.ttb.android.R;
import com.bigroad.ttb.android.logging.C2134e;
import com.bigroad.ttb.android.status.C2263a;
import com.bigroad.ttb.android.status.Type;
import com.bigroad.ttb.protocol.TTProtocol.Truck;

public enum DashLinkStatusMessages implements C2263a {
    UNCALIBRATED_ODOMETER,
    NO_ODOMETER,
    NO_VIN_SPECIFIED,
    BLUETOOTH_UNSUPPORTED,
    BLUETOOTH_DISABLED,
    DISCONNECTED,
    WRONG_EOBR_TYPE,
    CONNECTED_NOT_PLUGGED_IN,
    RECONNECTING,
    NOT_CURRENT,
    WAITING_FOR_TURBO_GPS,
    SEARCHING,
    CONNECTED,
    VAR_DATA_CORRUPTED,
    TURBO_FIRMWARE_UPDATING,
    FIRMWARE_NOT_COMPATIBLE,
    FIRMWARE_DETECTING;

    public Type mo1264a() {
        switch (this) {
            case CONNECTED_NOT_PLUGGED_IN:
                return Type.DASHLINK_BATTERY_WARNING;
            default:
                return Type.DASHLINK_WARNING;
        }
    }

    public String mo1265c(Context context) {
        switch (this) {
            case CONNECTED_NOT_PLUGGED_IN:
                return context.getString(R.string.dashLink_customTitle_connectedNotPluggedIn);
            case UNCALIBRATED_ODOMETER:
                return context.getString(R.string.dashLink_calibrateOdometerMessage);
            case NO_ODOMETER:
                return context.getString(R.string.dashLink_customTitle_noOdometerReadingsMessage);
            case NO_VIN_SPECIFIED:
                return context.getString(R.string.dashLink_customTitle_noVinMessage);
            case BLUETOOTH_UNSUPPORTED:
                return context.getString(R.string.dashLink_customTitle_bluetoothUnsupportedMessage);
            case BLUETOOTH_DISABLED:
                return context.getString(R.string.dashLink_customTitle_bluetoothDisabledMessage);
            case DISCONNECTED:
                return context.getString(R.string.dashLink_customTitle_disconnectedMessage);
            case WRONG_EOBR_TYPE:
                return context.getString(R.string.dashLink_customTitle_wrongDashLinkTypeMessage);
            case NOT_CURRENT:
                return context.getString(R.string.dashLink_customTitle_readingData);
            case WAITING_FOR_TURBO_GPS:
                return context.getString(R.string.dashLink_customTitle_noAbsoluteTimeFix);
            case TURBO_FIRMWARE_UPDATING:
                return context.getString(R.string.dashlink_customTitle_fwUpdating);
            case VAR_DATA_CORRUPTED:
                return context.getString(R.string.dashLink_customTitle_corruptedVarDataMessage);
            case FIRMWARE_NOT_COMPATIBLE:
                return context.getString(R.string.dashlink_customTitle_fwNotCompatible);
            case FIRMWARE_DETECTING:
                return context.getString(R.string.dashlink_customTitle_fwDetecting);
            default:
                return null;
        }
    }

    public String mo1266d(Context context) {
        switch (this) {
            case CONNECTED_NOT_PLUGGED_IN:
                return context.getString(R.string.notification_dashLink_connectedNotPluggedIn);
            case UNCALIBRATED_ODOMETER:
                return context.getString(R.string.notification_dashLink_calibrateOdometer);
            case NO_ODOMETER:
                return context.getString(R.string.notification_dashLink_noOdometerReadings);
            case NO_VIN_SPECIFIED:
                return context.getString(R.string.notification_dashLink_noVinSpecified, new Object[]{OurApplication.m6294p().m6583h()});
            case BLUETOOTH_UNSUPPORTED:
                return context.getString(R.string.notification_dashLink_bluetoothUnsupported);
            case BLUETOOTH_DISABLED:
                return context.getString(R.string.notification_dashLink_bluetoothDisabled);
            case DISCONNECTED:
                return context.getString(R.string.notification_dashLink_disconnected);
            case WRONG_EOBR_TYPE:
                return context.getString(R.string.notification_dashLink_wrongDashLinkType);
            case NOT_CURRENT:
                return context.getString(R.string.notification_dashLink_readingData);
            case CONNECTED:
                return context.getString(R.string.notification_dashLink_connected);
            case TURBO_FIRMWARE_UPDATING:
                return context.getString(R.string.notification_dashLink_fwUpdating);
            case VAR_DATA_CORRUPTED:
                return context.getString(R.string.notification_dashLinkNotReadyTitle);
            case FIRMWARE_NOT_COMPATIBLE:
                return context.getString(R.string.notification_dashLink_fwNotCompatible);
            case FIRMWARE_DETECTING:
                return context.getString(R.string.notification_dashLink_fwDetecting);
            default:
                return null;
        }
    }

    public String mo1267a(Context context) {
        switch (this) {
            case CONNECTED_NOT_PLUGGED_IN:
            case RECONNECTING:
            case CONNECTED:
                return context.getString(R.string.dashLink_statusTitle_connected);
            case UNCALIBRATED_ODOMETER:
            case NO_ODOMETER:
            case NO_VIN_SPECIFIED:
            case BLUETOOTH_DISABLED:
            case DISCONNECTED:
            case SEARCHING:
            case NOT_CURRENT:
            case WAITING_FOR_TURBO_GPS:
            case TURBO_FIRMWARE_UPDATING:
                return context.getString(R.string.dashLink_statusTitle_notReady);
            case BLUETOOTH_UNSUPPORTED:
            case WRONG_EOBR_TYPE:
                return context.getString(R.string.dashLink_statusTitle_notAvailable);
            case VAR_DATA_CORRUPTED:
                return context.getString(R.string.dashLink_statusTitle_notReady);
            case FIRMWARE_NOT_COMPATIBLE:
                return context.getString(R.string.dashLink_statusTitle_fwNotCompatible);
            case FIRMWARE_DETECTING:
                return context.getString(R.string.dashLink_statusTitle_fwDetecting);
            default:
                return null;
        }
    }

    private StringBuilder m11118a(Truck truck) {
        if (truck == null) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder(truck.getTruckNumber());
        if (truck.hasAssociatedDashLink()) {
            String d = C1180y.m5997d(truck.getAssociatedDashLink().m19091d());
            stringBuilder.append(" (Device ID: ");
            stringBuilder.append(d);
            stringBuilder.append(")");
            return stringBuilder;
        } else if (!truck.hasVin()) {
            return stringBuilder;
        } else {
            stringBuilder.append(" (VIN: ");
            stringBuilder.append(truck.getVin());
            stringBuilder.append(")");
            return stringBuilder;
        }
    }

    public String mo1268b(Context context) {
        Truck f = OurApplication.m6294p().m6578f();
        switch (this) {
            case CONNECTED_NOT_PLUGGED_IN:
                return context.getString(R.string.dashLink_notConnectedText);
            case UNCALIBRATED_ODOMETER:
                return context.getString(R.string.dashLink_calibrateOdometerText);
            case NO_ODOMETER:
                return context.getString(R.string.dashLink_noOdometerReadingsText);
            case NO_VIN_SPECIFIED:
                String str;
                Object[] objArr = new Object[1];
                if (f == null) {
                    str = "";
                } else {
                    str = f.getTruckNumber();
                }
                objArr[0] = str;
                return context.getString(R.string.dashLink_noVinText, objArr);
            case BLUETOOTH_UNSUPPORTED:
                return context.getString(R.string.dashLink_bluetoothUnsupportedText);
            case BLUETOOTH_DISABLED:
                return context.getString(R.string.dashLink_bluetoothDisabledText);
            case DISCONNECTED:
                if (f == null) {
                    C2134e.m10676b("TT-DashLinkStatusMessages", "DISCONNECTED but we don't know the truck? This shouldn't happen");
                    return null;
                }
                return context.getString(R.string.dashLink_disconnectedText, new Object[]{m11118a(f)});
            case SEARCHING:
                if (f == null) {
                    C2134e.m10676b("TT-DashLinkStatusMessages", "SEARCHING but we don't know the truck?  This shouldn't happen");
                    return null;
                }
                return context.getString(R.string.dashLink_searchingText, new Object[]{m11118a(f)});
            case WRONG_EOBR_TYPE:
                if (f == null) {
                    C2134e.m10676b("TT-DashLinkStatusMessages", "EOBR_TYPE_MATCH but we don't know the truck? This shouldn't happen");
                    return null;
                }
                if (an.m4194a(f.getSupportedBusTypes())) {
                    if (an.m4197d(f.getSupportedBusTypes())) {
                        return context.getString(R.string.dashLink_jbusInObdVehicle);
                    }
                    if (an.m4198e(f.getSupportedBusTypes())) {
                        return context.getString(R.string.dashLink_obdInJbusVehicle);
                    }
                }
                return context.getString(R.string.dashLink_unknownEobr_wrongDashLinkTypeText);
            case RECONNECTING:
                return context.getString(R.string.dashLink_reconnectingText);
            case NOT_CURRENT:
                return context.getString(R.string.dashLink_readingDataText);
            case WAITING_FOR_TURBO_GPS:
                return context.getString(R.string.dashLink_noAbsoluteTimeFixText);
            case TURBO_FIRMWARE_UPDATING:
                return context.getString(R.string.dashLink_fwUpdating);
            case VAR_DATA_CORRUPTED:
                return context.getString(R.string.dashLink_corruptedVarDataText);
            case FIRMWARE_NOT_COMPATIBLE:
                return context.getString(R.string.dashLink_fwNotCompatible);
            case FIRMWARE_DETECTING:
                return context.getString(R.string.dashLink_fwDetecting);
            default:
                return null;
        }
    }
}
