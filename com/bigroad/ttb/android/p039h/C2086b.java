package com.bigroad.ttb.android.p039h;

import android.widget.TextView;
import com.bigroad.shared.validation.C1176p;
import com.bigroad.shared.validation.ValidationError.Severity;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class C2086b<FIELD_ENUM extends Enum<FIELD_ENUM>> {
    private final Map<TextView, EnumSet<FIELD_ENUM>> f7292a = new HashMap();

    public void m10463a(FIELD_ENUM field_enum, TextView textView) {
        if (textView != null) {
            EnumSet enumSet = (EnumSet) this.f7292a.get(textView);
            if (enumSet == null) {
                this.f7292a.put(textView, EnumSet.of(field_enum));
                return;
            }
            enumSet.add(field_enum);
        }
    }

    public void m10462a(C1176p<FIELD_ENUM> c1176p) {
        for (Entry entry : this.f7292a.entrySet()) {
            Severity severity = null;
            if (c1176p != null) {
                Iterator it = ((EnumSet) entry.getValue()).iterator();
                while (it.hasNext()) {
                    Severity a = c1176p.m5954a((Enum) it.next());
                    if (a == null || (severity != null && a.compareTo(severity) <= 0)) {
                        a = severity;
                    }
                    severity = a;
                }
            }
            C2091e.m10478a(severity, (TextView) entry.getKey());
        }
    }
}
