package com.bigroad.shared.model;

import com.bigroad.ttb.protocol.TTProtocol.Person;

public class C1125g {
    private final long f3773a;
    private final String f3774b;
    private final String f3775c;
    private final String f3776d;
    private final String f3777e;
    private final String f3778f;

    public static class C1124a {
        private long f3767a;
        private String f3768b;
        private String f3769c;
        private String f3770d;
        private String f3771e;
        private String f3772f;

        public C1124a(long j) {
            this.f3767a = j;
        }

        public C1124a(long j, String str, String str2, String str3) {
            this.f3767a = j;
            this.f3768b = str;
            this.f3769c = str2;
            this.f3770d = str3;
        }

        public C1125g m5703a() {
            return new C1125g();
        }
    }

    private C1125g(C1124a c1124a) {
        this.f3773a = c1124a.f3767a;
        this.f3774b = c1124a.f3768b;
        this.f3775c = c1124a.f3769c;
        this.f3776d = c1124a.f3770d;
        this.f3777e = c1124a.f3771e;
        this.f3778f = c1124a.f3772f;
    }

    public static C1125g m5704a(Person person) {
        return new C1124a(person.getPersonId(), person.getFirstName(), person.getLastName(), person.getEmailAddress()).m5703a();
    }
}
