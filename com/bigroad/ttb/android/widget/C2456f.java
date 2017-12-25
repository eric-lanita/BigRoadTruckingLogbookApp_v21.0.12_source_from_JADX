package com.bigroad.ttb.android.widget;

import android.content.Context;
import com.bigroad.ttb.protocol.TTProtocol.TruckLogType;

public class C2456f extends C2455e {
    boolean f8777a;

    public C2456f(Context context, boolean z) {
        super(context);
        this.f8777a = z;
    }

    protected boolean mo1345a(TruckLogType truckLogType) {
        return this.f8777a && truckLogType == TruckLogType.ELD;
    }

    protected boolean mo1344a() {
        return true;
    }

    protected boolean mo1346b(TruckLogType truckLogType) {
        return this.f8777a && truckLogType == TruckLogType.ELD;
    }
}
