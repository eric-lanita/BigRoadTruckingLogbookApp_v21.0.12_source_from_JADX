package com.bigroad.shared.validation;

public class ValidationErrorRelatedLogLink {
    private final Type f3867a;
    private final ValidationErrorLinkIcon f3868b;
    private final int f3869c;
    private final long f3870d;
    private final String f3871e;

    public enum Type {
        ODOMETER_READING("odometer reading");
        
        private final String m_messageTextFragment;

        private Type(String str) {
            this.m_messageTextFragment = str;
        }

        public String m5784a() {
            return this.m_messageTextFragment;
        }
    }

    public ValidationErrorRelatedLogLink(Type type, int i, boolean z, long j) {
        this.f3867a = type;
        this.f3869c = i;
        this.f3870d = j;
        if (z) {
            this.f3868b = ValidationErrorLinkIcon.PAST_LOG;
            this.f3871e = "Go to previous " + this.f3867a.m5784a();
            return;
        }
        this.f3868b = ValidationErrorLinkIcon.FUTURE_LOG;
        this.f3871e = "Go to next " + this.f3867a.m5784a();
    }
}
