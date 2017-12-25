package com.bigroad.shared;

public class UserAuthenticationChangeBits {

    public enum Reason {
        UNKNOWN,
        EXPLICIT_SIGN_IN,
        EXPLICIT_SIGN_OUT,
        OFF_DUTY_AND_SIGN_OUT,
        BAD_OR_MISSING_CREDENTIALS,
        AUTHENTICATION_TOKEN_CLEARED,
        LOGIN_NOT_FOUND,
        AUTHENTICATION_FAILURE,
        CREDENTIAL_CHANGE,
        SELECT_TRUCK_FAILED,
        TRIAL_USER_CONVERSION,
        CANCELLED_FLEET_SELECTION,
        OFF_DUTY_AND_SIGN_OUT_TIMEOUT
    }

    public static long m4102a(Reason reason) {
        if (reason == null) {
            reason = Reason.UNKNOWN;
        }
        return ((long) reason.ordinal()) & 31;
    }
}
