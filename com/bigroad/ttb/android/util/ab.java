package com.bigroad.ttb.android.util;

import android.content.Context;
import android.content.res.Resources;
import com.bigroad.ttb.android.R;
import com.bigroad.ttb.protocol.TTProtocol.VehicleType;

public class ab {
    public static int m11167a(int i) {
        switch (i) {
            case 1:
                return R.string.inspectionItem_truckLabel;
            case 2:
                return R.string.inspectionItem_trailerLabel;
            default:
                return R.string.inspectionItem_unknownVehicleTypeLabel;
        }
    }

    public static String m11168a(Context context, int i) {
        return m11170a(context.getResources(), i);
    }

    public static String m11169a(Context context, VehicleType vehicleType) {
        return m11170a(context.getResources(), vehicleType.m15918a());
    }

    private static String m11170a(Resources resources, int i) {
        String[] stringArray = resources.getStringArray(R.array.vehicleTypeNames);
        if (i < 0 || i >= stringArray.length) {
            i = 0;
        }
        return stringArray[i];
    }
}
