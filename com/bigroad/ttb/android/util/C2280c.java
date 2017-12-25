package com.bigroad.ttb.android.util;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Matrix;
import android.media.ExifInterface;
import com.bigroad.ttb.android.logging.C2134e;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import java.io.File;

public abstract class C2280c {
    private static Bitmap m11191a(Bitmap bitmap, float f) {
        Matrix matrix = new Matrix();
        matrix.postRotate(f);
        return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, false);
    }

    private static Bitmap m11193b(Bitmap bitmap, float f) {
        Bitmap a = C2280c.m11191a(bitmap, f);
        bitmap.recycle();
        return a;
    }

    public static Bitmap m11192a(File file, int i, int i2) {
        int attributeInt;
        String absolutePath = file.getAbsolutePath();
        try {
            attributeInt = new ExifInterface(absolutePath).getAttributeInt("Orientation", 0);
        } catch (Throwable e) {
            C2134e.m10681d("TT-BitmapLdr", "Error reading EXIF data for " + absolutePath, e);
            attributeInt = 0;
        }
        Options options = new Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(absolutePath, options);
        int max = Math.max(i, i2);
        int i3 = options.outWidth;
        int i4 = options.outHeight;
        int i5 = 2;
        while (i3 / i5 > max && i4 / i5 > max) {
            i5++;
        }
        i5--;
        options.inJustDecodeBounds = false;
        options.inSampleSize = i5;
        Bitmap decodeFile = BitmapFactory.decodeFile(absolutePath, options);
        switch (attributeInt) {
            case 0:
            case 1:
                return decodeFile;
            case 3:
                return C2280c.m11193b(decodeFile, BitmapDescriptorFactory.HUE_CYAN);
            case 6:
                return C2280c.m11193b(decodeFile, 90.0f);
            case 8:
                return C2280c.m11193b(decodeFile, BitmapDescriptorFactory.HUE_VIOLET);
            default:
                C2134e.m10682e("TT-BitmapLdr", "Unhandled image orientation: " + attributeInt);
                return decodeFile;
        }
    }
}
