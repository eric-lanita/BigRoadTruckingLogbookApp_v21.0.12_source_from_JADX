package com.bigroad.ttb.android.util;

import com.bigroad.shared.EventStatusMaskBits.RecordOrigin;
import com.bigroad.ttb.android.R;

public abstract class C2289i {
    public static int m11215a(RecordOrigin recordOrigin) {
        switch (recordOrigin) {
            case AUTOMATICALLY_RECORDED:
                return R.string.recordOrigin_automaticallyRecorded;
            case MANUAL_ENTRY:
                return R.string.recordOrigin_manualEntry;
            case EDIT_REQUEST:
                return R.string.recordOrigin_editRequest;
            case UNIDENTIFIED_DRIVER:
                return R.string.recordOrigin_unidentifiedDriver;
            default:
                return R.string.recordOrigin_unknown;
        }
    }
}
