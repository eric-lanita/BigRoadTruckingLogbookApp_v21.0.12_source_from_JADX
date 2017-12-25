package com.bigroad.shared;

import com.bigroad.ttb.protocol.TTProtocol.Geocode;

public abstract class C1179w {
    public static String m5986a(Geocode geocode) {
        StringBuilder stringBuilder = new StringBuilder();
        if (geocode.hasCity()) {
            stringBuilder.append(geocode.getCity());
        }
        if (geocode.hasState()) {
            if (stringBuilder.length() > 0) {
                stringBuilder.append(", ");
            }
            stringBuilder.append(geocode.getState());
        }
        return stringBuilder.toString().trim();
    }
}
