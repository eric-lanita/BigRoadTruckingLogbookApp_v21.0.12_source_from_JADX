package com.bigroad.shared.eobr.turbo.messages;

import com.bigroad.shared.eobr.turbo.hardware.AccelerometerType;
import com.bigroad.shared.eobr.turbo.hardware.BluetoothType;
import com.bigroad.shared.eobr.turbo.hardware.BoardType;
import com.bigroad.shared.eobr.turbo.hardware.FlashType;
import com.bigroad.shared.eobr.turbo.hardware.GpsType;
import com.bigroad.shared.eobr.turbo.hardware.McuType;

public class C1042e extends aj {
    public final int f3422a;
    public final int f3423b;
    public final int f3424c;
    public final int f3425d;
    public final BoardType f3426e;
    public final McuType f3427f;
    public final FlashType f3428g;
    public final BluetoothType f3429h;
    public final GpsType f3430i;
    public final AccelerometerType f3431j;

    public C1042e(int i, int i2, int i3, int i4, BoardType boardType, McuType mcuType, FlashType flashType, BluetoothType bluetoothType, GpsType gpsType, AccelerometerType accelerometerType) {
        this.f3422a = i;
        this.f3423b = i2;
        this.f3424c = i3;
        this.f3425d = i4;
        this.f3426e = boardType;
        this.f3427f = mcuType;
        this.f3428g = flashType;
        this.f3429h = bluetoothType;
        this.f3430i = gpsType;
        this.f3431j = accelerometerType;
    }
}
