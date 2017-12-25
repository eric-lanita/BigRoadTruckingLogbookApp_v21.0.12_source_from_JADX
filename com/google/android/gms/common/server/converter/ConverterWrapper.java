package com.google.android.gms.common.server.converter;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.server.response.FastJsonResponse.zza;

public class ConverterWrapper extends AbstractSafeParcelable {
    public static final zza CREATOR = new zza();
    private final int f10813a;
    private final StringToIntConverter f10814b;

    ConverterWrapper(int i, StringToIntConverter stringToIntConverter) {
        this.f10813a = i;
        this.f10814b = stringToIntConverter;
    }

    private ConverterWrapper(StringToIntConverter stringToIntConverter) {
        this.f10813a = 1;
        this.f10814b = stringToIntConverter;
    }

    public static ConverterWrapper zza(zza<?, ?> com_google_android_gms_common_server_response_FastJsonResponse_zza___) {
        if (com_google_android_gms_common_server_response_FastJsonResponse_zza___ instanceof StringToIntConverter) {
            return new ConverterWrapper((StringToIntConverter) com_google_android_gms_common_server_response_FastJsonResponse_zza___);
        }
        throw new IllegalArgumentException("Unsupported safe parcelable field converter class.");
    }

    int m16948a() {
        return this.f10813a;
    }

    StringToIntConverter m16949b() {
        return this.f10814b;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zza com_google_android_gms_common_server_converter_zza = CREATOR;
        zza.m16953a(this, parcel, i);
    }

    public zza<?, ?> zzatr() {
        if (this.f10814b != null) {
            return this.f10814b;
        }
        throw new IllegalStateException("There was no converter wrapped in this ConverterWrapper.");
    }
}
