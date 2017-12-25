package com.bigroad.shared;

public abstract class as {
    public static float m4241a(float f) {
        return f / 3.6f;
    }

    public static double m4240a(double d) {
        return d / 3.6d;
    }

    public static double m4243b(double d) {
        return 1.60934d * d;
    }

    public static long m4242a(long j) {
        return (1609344 * j) / 1000;
    }

    public static double m4244c(double d) {
        return 1000.0d * d;
    }

    public static double m4245d(double d) {
        return m4244c(m4243b(d));
    }

    public static double m4246e(double d) {
        return 0.621371d * d;
    }
}
