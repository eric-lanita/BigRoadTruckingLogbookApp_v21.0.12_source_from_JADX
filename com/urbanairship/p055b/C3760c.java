package com.urbanairship.p055b;

import java.util.List;
import java.util.Map;

public class C3760c {
    private String f13496a;
    private Map<String, List<String>> f13497b;
    private int f13498c;
    private String f13499d;
    private long f13500e;

    public static class C3759a {
        private String f13491a;
        private Map<String, List<String>> f13492b;
        private final int f13493c;
        private String f13494d;
        private long f13495e = 0;

        public C3759a(int i) {
            this.f13493c = i;
        }

        public C3759a m19650a(String str) {
            this.f13494d = str;
            return this;
        }

        public C3759a m19653b(String str) {
            this.f13491a = str;
            return this;
        }

        public C3759a m19651a(Map<String, List<String>> map) {
            this.f13492b = map;
            return this;
        }

        public C3759a m19649a(long j) {
            this.f13495e = j;
            return this;
        }

        public C3760c m19652a() {
            C3760c c3760c = new C3760c();
            c3760c.f13498c = this.f13493c;
            c3760c.f13496a = this.f13491a;
            c3760c.f13497b = this.f13492b;
            c3760c.f13499d = this.f13494d;
            c3760c.f13500e = this.f13495e;
            return c3760c;
        }
    }

    private C3760c() {
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Response: ");
        stringBuilder.append("ResponseBody: ");
        if (this.f13496a != null) {
            stringBuilder.append(this.f13496a);
        }
        stringBuilder.append(" ResponseHeaders: ");
        if (this.f13497b != null) {
            stringBuilder.append(this.f13497b);
        }
        stringBuilder.append(" ResponseMessage: ");
        if (this.f13499d != null) {
            stringBuilder.append(this.f13499d);
        }
        stringBuilder.append(" Status: ").append(Integer.toString(this.f13498c));
        return stringBuilder.toString();
    }

    public int m19659a() {
        return this.f13498c;
    }

    public String m19661b() {
        return this.f13496a;
    }

    public long m19662c() {
        return this.f13500e;
    }

    public Map<String, List<String>> m19663d() {
        return this.f13497b;
    }

    public String m19660a(String str) {
        if (this.f13497b != null) {
            List list = (List) this.f13497b.get(str);
            if (list != null && list.size() > 0) {
                return (String) list.get(0);
            }
        }
        return null;
    }
}
