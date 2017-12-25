package com.bigroad.shared.gaps;

public enum LogDayCalculationError {
    TOO_MANY_TRUCK_LOGS("Too many logs prevents gap analysis from proceeding"),
    GRAPH_NOT_SPANNABLE("Log a bug; A constructed graph did not have a valid span. The gap analysis algorithm assumes that all constructed DayGraph objects have a valid span."),
    INVALID_LOG_INPUT("Log a bug; inspect code for issues"),
    INVALID_GRAPH_INPUT("Log a bug; inspect code for issues"),
    INVALID_TRAVERSAL_INPUT("Log a bug; inspect code for issues"),
    NO_TRUCK_LOGS("Presumably this means that there are only odometer adjustments on a log day; gap analysis should continue."),
    ONLY_AMBIGUOUS_LOGS("Ambiguous logs on this day should have suspicious log warnings; gap analysis should be broken."),
    ONLY_ODOMETER_ADJUSTMENTS("There are no visible truck; gap analysis should ignore this day.");
    
    private final String m_prognosis;

    private LogDayCalculationError(String str) {
        this.m_prognosis = str;
    }
}
