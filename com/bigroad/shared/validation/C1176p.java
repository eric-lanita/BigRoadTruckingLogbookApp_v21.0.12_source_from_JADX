package com.bigroad.shared.validation;

import com.bigroad.shared.validation.ValidationError.Category;
import com.bigroad.shared.validation.ValidationError.Severity;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class C1176p<FIELD_ENUM extends Enum<FIELD_ENUM>> {
    private Map<FIELD_ENUM, List<ValidationError>> f3993a = null;
    private List<C1168m> f3994b = null;

    public void m5955a() {
        if (this.f3993a != null) {
            this.f3993a.clear();
        }
        if (this.f3994b != null) {
            this.f3994b.clear();
        }
    }

    public boolean m5962b() {
        return (this.f3993a == null || this.f3993a.isEmpty()) ? false : true;
    }

    public boolean m5959a(Set<Severity> set) {
        if (this.f3993a == null) {
            return false;
        }
        for (List<ValidationError> it : this.f3993a.values()) {
            for (ValidationError d : it) {
                if (set.contains(d.m5782d())) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean m5958a(Category category) {
        if (this.f3993a == null) {
            return false;
        }
        for (List<ValidationError> it : this.f3993a.values()) {
            for (ValidationError e : it) {
                if (e.m5783e() == category) {
                    return true;
                }
            }
        }
        return false;
    }

    public Severity m5954a(FIELD_ENUM field_enum) {
        Severity severity = null;
        if (!(this.f3993a == null || ((List) this.f3993a.get(field_enum)) == null)) {
            for (ValidationError validationError : (List) this.f3993a.get(field_enum)) {
                Severity d;
                if (severity == null || validationError.m5782d().compareTo(severity) > 0) {
                    d = validationError.m5782d();
                } else {
                    d = severity;
                }
                severity = d;
            }
        }
        return severity;
    }

    public List<ValidationError> m5961b(FIELD_ENUM field_enum) {
        if (this.f3993a == null) {
            return Collections.emptyList();
        }
        List<ValidationError> list = (List) this.f3993a.get(field_enum);
        return list == null ? Collections.emptyList() : list;
    }

    public List<ValidationError> m5960b(Category category) {
        if (this.f3993a == null) {
            return Collections.emptyList();
        }
        List<ValidationError> list = null;
        for (List<ValidationError> it : this.f3993a.values()) {
            for (ValidationError validationError : it) {
                if (validationError.m5783e() == category) {
                    if (list == null) {
                        list = new ArrayList();
                    }
                    list.add(validationError);
                }
            }
        }
        if (list == null) {
            return Collections.emptyList();
        }
        return list;
    }

    public List<C1168m> m5963c(Category category) {
        if (this.f3994b == null) {
            return Collections.emptyList();
        }
        List<C1168m> arrayList = new ArrayList();
        for (C1168m c1168m : this.f3994b) {
            if (c1168m.m5783e() == category) {
                arrayList.add(c1168m);
            }
        }
        Collections.sort(arrayList, C1168m.f3954a);
        return arrayList;
    }

    public Map<FIELD_ENUM, List<ValidationError>> m5964c() {
        return this.f3993a == null ? Collections.emptyMap() : this.f3993a;
    }

    public void m5956a(FIELD_ENUM field_enum, ValidationError validationError) {
        if (this.f3993a == null) {
            this.f3993a = new HashMap();
        }
        List list = (List) this.f3993a.get(field_enum);
        if (list == null) {
            list = new LinkedList();
            this.f3993a.put(field_enum, list);
        }
        list.add(validationError);
    }

    public void m5957a(FIELD_ENUM field_enum, C1168m c1168m) {
        m5956a((Enum) field_enum, (ValidationError) c1168m);
        if (this.f3994b == null) {
            this.f3994b = new ArrayList();
        }
        this.f3994b.add(c1168m);
    }
}
