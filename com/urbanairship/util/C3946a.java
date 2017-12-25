package com.urbanairship.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import com.urbanairship.C3783j;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

public class C3946a {
    public static Bitmap m20488a(Context context, URL url, int i, int i2) {
        C3783j.m19723b("BitmapUtils - Fetching image from: " + url);
        File createTempFile = File.createTempFile("ua_", ".temp", context.getCacheDir());
        C3783j.m19723b("BitmapUtils - Created temp file: " + createTempFile);
        if (C3946a.m20489a(url, createTempFile)) {
            Options options = new Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeFile(createTempFile.getAbsolutePath(), options);
            options.inSampleSize = C3946a.m20487a(options.outWidth, options.outHeight, i, i2);
            options.inJustDecodeBounds = false;
            Bitmap decodeFile = BitmapFactory.decodeFile(createTempFile.getAbsolutePath(), options);
            if (createTempFile.delete()) {
                C3783j.m19723b("BitmapUtils - Deleted temp file: " + createTempFile);
            } else {
                C3783j.m19723b("BitmapUtils - Failed to delete temp file: " + createTempFile);
            }
            C3783j.m19725c(String.format("BitmapUtils - Fetched image from: %s. Original image size: %dx%d. Requested image size: %dx%d. Bitmap size: %dx%d. SampleSize: %d", new Object[]{url, Integer.valueOf(r3), Integer.valueOf(r4), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(decodeFile.getWidth()), Integer.valueOf(decodeFile.getHeight()), Integer.valueOf(options.inSampleSize)}));
            return decodeFile;
        }
        C3783j.m19723b("BitmapUtils - Failed to fetch image from: " + url);
        return null;
    }

    public static int m20487a(int i, int i2, int i3, int i4) {
        int i5 = 1;
        if (i2 > i4 || i > i3) {
            int i6 = i2 / 2;
            int i7 = i / 2;
            while (i6 / i5 > i4 && i7 / i5 > i3) {
                i5 *= 2;
            }
        }
        return i5;
    }

    private static boolean m20489a(URL url, File file) {
        FileOutputStream fileOutputStream;
        Throwable th;
        Object obj;
        InputStream inputStream = null;
        C3783j.m19723b("Downloading file from: " + url + " to: " + file.getAbsolutePath());
        try {
            URLConnection openConnection = url.openConnection();
            openConnection.setConnectTimeout(2000);
            openConnection.setUseCaches(true);
            InputStream inputStream2 = openConnection.getInputStream();
            try {
                if ((openConnection instanceof HttpURLConnection) && !C3952g.m20508a(((HttpURLConnection) openConnection).getResponseCode())) {
                    C3783j.m19721a("Unable to download file from URL. Received response code: " + ((HttpURLConnection) openConnection).getResponseCode());
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    if (inputStream2 != null) {
                        inputStream2.close();
                    }
                    return false;
                } else if (inputStream2 != null) {
                    fileOutputStream = new FileOutputStream(file);
                    try {
                        byte[] bArr = new byte[1024];
                        while (true) {
                            int read = inputStream2.read(bArr);
                            if (read == -1) {
                                break;
                            }
                            fileOutputStream.write(bArr, 0, read);
                        }
                        fileOutputStream.close();
                        inputStream2.close();
                        if (fileOutputStream != null) {
                            fileOutputStream.close();
                        }
                        if (inputStream2 != null) {
                            inputStream2.close();
                        }
                        return true;
                    } catch (Throwable th2) {
                        th = th2;
                        inputStream = inputStream2;
                        if (fileOutputStream != null) {
                            fileOutputStream.close();
                        }
                        if (inputStream != null) {
                            inputStream.close();
                        }
                        throw th;
                    }
                } else {
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    if (inputStream2 != null) {
                        inputStream2.close();
                    }
                    return false;
                }
            } catch (Throwable th3) {
                th = th3;
                obj = inputStream;
                inputStream = inputStream2;
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
                if (inputStream != null) {
                    inputStream.close();
                }
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            obj = inputStream;
            if (fileOutputStream != null) {
                fileOutputStream.close();
            }
            if (inputStream != null) {
                inputStream.close();
            }
            throw th;
        }
    }
}
