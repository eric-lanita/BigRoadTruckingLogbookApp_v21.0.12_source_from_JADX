package com.bigroad.ttb.android.eobr;

import android.content.Context;
import android.os.Bundle;
import com.bigroad.shared.am;
import com.bigroad.ttb.android.eobr.turbo.C1955b;
import com.bigroad.ttb.android.eobr.vna.C1982a;
import com.bigroad.ttb.android.logging.C2134e;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

public class C1904g {
    private static C1904g f6595a;
    private final Set<EobrDevice> f6596b = new HashSet();

    public static C1904g m9313a(Context context) {
        if (f6595a == null) {
            f6595a = new C1904g(context);
        }
        return f6595a;
    }

    public List<EobrDevice> m9316a() {
        return new ArrayList(this.f6596b);
    }

    private C1904g(Context context) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(context.getResources().getAssets().open("simulated-eobrs.json")));
            StringBuilder stringBuilder = new StringBuilder();
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                stringBuilder.append(readLine);
            }
            Object nextValue = new JSONTokener(stringBuilder.toString()).nextValue();
            if (nextValue instanceof JSONArray) {
                JSONArray jSONArray = (JSONArray) nextValue;
                for (int i = 0; i < jSONArray.length(); i++) {
                    m9315a(jSONArray.getJSONObject(i));
                }
            } else if (nextValue instanceof JSONObject) {
                m9315a((JSONObject) nextValue);
            } else {
                C2134e.m10680d("TT-SimEobrAdapter", "simulated-eobrs.json contains invalid JSON markup");
            }
        } catch (FileNotFoundException e) {
            C2134e.m10678c("TT-SimEobrAdapter", "No simulated-eobrs.json asset found. Ignoring.");
        } catch (Throwable e2) {
            C2134e.m10679c("TT-SimEobrAdapter", "Failed to open developer properties file: simulated-eobrs.json", e2);
        } catch (JSONException e3) {
            C2134e.m10680d("TT-SimEobrAdapter", "Exception parsing simulated-eobrs.json: " + e3);
        }
    }

    private void m9314a(String str, int i, String str2, String str3, boolean z) {
        if (am.m4188a((CharSequence) str2)) {
            C2134e.m10680d("TT-SimEobrAdapter", "MAC address is required for simulated EOBR");
            return;
        }
        EobrDevice c1955b;
        if (z) {
            c1955b = new C1955b(new C1932h(str, i, str2, str3), true);
        } else {
            c1955b = new C1982a(new C1932h(str, i, str2, str3), true);
        }
        EobrDevice a = m9312a(c1955b.m8991c());
        if (a != null) {
            C2134e.m10678c("TT-SimEobrAdapter", "Replacing existing EOBR entry");
            this.f6596b.remove(a);
        }
        this.f6596b.add(c1955b);
        C2134e.m10678c("TT-SimEobrAdapter", "Added simulated EOBR with MAC " + str2 + " at " + str + ":" + i);
    }

    private EobrDevice m9312a(String str) {
        for (EobrDevice eobrDevice : this.f6596b) {
            if (am.m4189a(eobrDevice.m8991c(), str)) {
                return eobrDevice;
            }
        }
        return null;
    }

    private void m9315a(JSONObject jSONObject) {
        try {
            if (!jSONObject.has("active") || jSONObject.getBoolean("active")) {
                String string = jSONObject.getString("host");
                int i = jSONObject.getInt("port");
                String string2 = jSONObject.getString("mac");
                String str = "";
                if (jSONObject.has("name")) {
                    str = jSONObject.getString("name");
                }
                boolean z = false;
                if (jSONObject.has("turbo")) {
                    z = true;
                }
                m9314a(string, i, string2, str, z);
            }
        } catch (JSONException e) {
            C2134e.m10680d("TT-SimEobrAdapter", "Exception parsing simulated-eobrs.json: " + e);
        }
    }

    public void m9317a(Bundle bundle) {
        if (!bundle.containsKey("active") || bundle.getBoolean("active")) {
            String string = bundle.getString("host");
            int i = bundle.getInt("port");
            String string2 = bundle.getString("mac");
            String str = "";
            if (bundle.containsKey("name")) {
                str = bundle.getString("name");
            }
            boolean z = false;
            if (bundle.containsKey("turbo")) {
                z = true;
            }
            m9314a(string, i, string2, str, z);
        }
    }
}
