package com.google.android.gms.common.images;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.zzaa;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

public final class WebImage extends AbstractSafeParcelable {
    public static final Creator<WebImage> CREATOR = new zzb();
    private final int f10639a;
    private final Uri f10640b;
    private final int f10641c;
    private final int f10642d;

    WebImage(int i, Uri uri, int i2, int i3) {
        this.f10639a = i;
        this.f10640b = uri;
        this.f10641c = i2;
        this.f10642d = i3;
    }

    public WebImage(Uri uri) {
        this(uri, 0, 0);
    }

    public WebImage(Uri uri, int i, int i2) {
        this(1, uri, i, i2);
        if (uri == null) {
            throw new IllegalArgumentException("url cannot be null");
        } else if (i < 0 || i2 < 0) {
            throw new IllegalArgumentException("width and height must not be negative");
        }
    }

    public WebImage(JSONObject jSONObject) {
        this(m16853a(jSONObject), jSONObject.optInt("width", 0), jSONObject.optInt("height", 0));
    }

    private static Uri m16853a(JSONObject jSONObject) {
        Uri uri = null;
        if (jSONObject.has("url")) {
            try {
                uri = Uri.parse(jSONObject.getString("url"));
            } catch (JSONException e) {
            }
        }
        return uri;
    }

    int m16854a() {
        return this.f10639a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof WebImage)) {
            return false;
        }
        WebImage webImage = (WebImage) obj;
        return zzaa.equal(this.f10640b, webImage.f10640b) && this.f10641c == webImage.f10641c && this.f10642d == webImage.f10642d;
    }

    public int getHeight() {
        return this.f10642d;
    }

    public Uri getUrl() {
        return this.f10640b;
    }

    public int getWidth() {
        return this.f10641c;
    }

    public int hashCode() {
        return zzaa.hashCode(this.f10640b, Integer.valueOf(this.f10641c), Integer.valueOf(this.f10642d));
    }

    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("url", this.f10640b.toString());
            jSONObject.put("width", this.f10641c);
            jSONObject.put("height", this.f10642d);
        } catch (JSONException e) {
        }
        return jSONObject;
    }

    public String toString() {
        return String.format(Locale.US, "Image %dx%d %s", new Object[]{Integer.valueOf(this.f10641c), Integer.valueOf(this.f10642d), this.f10640b.toString()});
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzb.m16865a(this, parcel, i);
    }
}
