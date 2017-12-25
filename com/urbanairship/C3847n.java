package com.urbanairship;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Color;
import com.urbanairship.util.C3954i;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

class C3847n implements C3781h {
    private final List<String> f13723a = new ArrayList();
    private final List<String> f13724b = new ArrayList();
    private final Context f13725c;

    public C3847n(Context context, String str) {
        this.f13725c = context;
        AssetManager assets = context.getResources().getAssets();
        if (Arrays.asList(assets.list("")).contains(str)) {
            Properties properties = new Properties();
            InputStream inputStream = null;
            try {
                inputStream = assets.open(str);
                properties.load(inputStream);
                for (String str2 : properties.stringPropertyNames()) {
                    String property = properties.getProperty(str2);
                    if (property != null) {
                        property = property.trim();
                    }
                    if (!C3954i.m20512a(property)) {
                        this.f13723a.add(str2);
                        this.f13724b.add(property);
                    }
                }
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (Throwable e) {
                        C3783j.m19726c("PropertiesConfigParser - Failed to close input stream.", e);
                    }
                }
            } catch (Throwable th) {
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (Throwable e2) {
                        C3783j.m19726c("PropertiesConfigParser - Failed to close input stream.", e2);
                    }
                }
            }
        } else {
            throw new FileNotFoundException("Unable to find properties file: " + str);
        }
    }

    public int mo2807a() {
        return this.f13723a.size();
    }

    public String mo2808a(int i) {
        return (String) this.f13723a.get(i);
    }

    public String mo2809b(int i) {
        return (String) this.f13724b.get(i);
    }

    public boolean mo2810c(int i) {
        return Boolean.parseBoolean((String) this.f13724b.get(i));
    }

    public String[] mo2811d(int i) {
        return ((String) this.f13724b.get(i)).split("[, ]+");
    }

    public int mo2812e(int i) {
        return this.f13725c.getResources().getIdentifier(mo2809b(i), "drawable", this.f13725c.getPackageName());
    }

    public int mo2813f(int i) {
        return Color.parseColor((String) this.f13724b.get(i));
    }

    public long mo2814g(int i) {
        return Long.parseLong((String) this.f13724b.get(i));
    }
}
