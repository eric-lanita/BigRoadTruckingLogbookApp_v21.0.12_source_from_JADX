package com.google.android.gms.internal;

import java.io.IOException;

public class zzapu extends IOException {
    public zzapu(String str) {
        super(str);
    }

    static zzapu m17336a() {
        return new zzapu("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either than the input has been truncated or that an embedded message misreported its own length.");
    }

    static zzapu m17337b() {
        return new zzapu("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
    }

    static zzapu m17338c() {
        return new zzapu("CodedInputStream encountered a malformed varint.");
    }

    static zzapu m17339d() {
        return new zzapu("Protocol message contained an invalid tag (zero).");
    }

    static zzapu m17340e() {
        return new zzapu("Protocol message end-group tag did not match expected tag.");
    }

    static zzapu m17341f() {
        return new zzapu("Protocol message tag had invalid wire type.");
    }

    static zzapu m17342g() {
        return new zzapu("Protocol message had too many levels of nesting.  May be malicious.  Use CodedInputStream.setRecursionLimit() to increase the depth limit.");
    }
}
