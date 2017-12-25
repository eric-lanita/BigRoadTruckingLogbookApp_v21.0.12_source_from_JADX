package com.bigroad.shared.validation;

public enum ValidationErrorLinkIcon {
    NONE(""),
    FUTURE_LOG("next"),
    PAST_LOG("prev");
    
    final String m_jsName;

    private ValidationErrorLinkIcon(String str) {
        this.m_jsName = str;
    }
}
