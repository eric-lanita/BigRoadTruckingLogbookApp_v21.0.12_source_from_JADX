package com.bigroad.ttb.android.eobr.genx;

import com.bigroad.shared.eobr.turbo.messages.C1051n;
import com.bigroad.ttb.android.logging.C2134e;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

public class C1929i {
    public static void m9484a(C1919c c1919c, String str) {
        if (c1919c != null) {
            List asList = Arrays.asList(str.split(","));
            if (asList.size() >= 8 && !((String) asList.get(7)).equals("GPSBAD")) {
                try {
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
                    simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
                    Date parse = simpleDateFormat.parse((String) asList.get(5));
                    long time = (long) ((int) (parse.getTime() / 1000));
                    C1919c c1919c2 = c1919c;
                    c1919c2.m9430a(new C1051n((int) (Double.parseDouble((String) asList.get(0)) * 1.0E7d), (int) (Double.parseDouble((String) asList.get(1)) * 1.0E7d), 0, (int) ((Double.parseDouble((String) asList.get(3)) * 1000000.0d) / 3600.0d), parse.getTime()), parse.getTime(), time);
                } catch (ParseException e) {
                    C2134e.m10682e("TT-GenxVehicleStateUtils", "Could not parse date " + ((String) asList.get(5)));
                }
            }
        }
    }

    public static long m9483a(String str) {
        long j = 0;
        try {
            return (long) (Float.parseFloat(str) * 1000.0f);
        } catch (NumberFormatException e) {
            C2134e.m10680d("TT-GenxVehicleStateUtils", "Unexpected distance " + str);
            return j;
        }
    }
}
