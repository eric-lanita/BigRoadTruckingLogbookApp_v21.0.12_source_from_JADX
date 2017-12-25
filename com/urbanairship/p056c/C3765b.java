package com.urbanairship.p056c;

import android.net.Uri;
import com.urbanairship.C3761b;
import com.urbanairship.C3783j;
import com.urbanairship.util.C3954i;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;

public class C3765b {
    private static final String f13530a = String.format(Locale.US, "^((\\*)|((%s://%s%s)|(%s://%s)|(file://%s)))", new Object[]{"((\\*)|(http)|(https))", "((\\*)|(\\*\\.[^/\\*]+)|([^/\\*]+))", "(/.*)", "((\\*)|(http)|(https))", "((\\*)|(\\*\\.[^/\\*]+)|([^/\\*]+))", "(/.*)"});
    private static final Pattern f13531b = Pattern.compile(f13530a, 2);
    private final List<C3764a> f13532c = new ArrayList();

    private class C3764a {
        final /* synthetic */ C3765b f13526a;
        private final Pattern f13527b;
        private final Pattern f13528c;
        private final Pattern f13529d;

        C3764a(C3765b c3765b, Pattern pattern, Pattern pattern2, Pattern pattern3) {
            this.f13526a = c3765b;
            this.f13527b = pattern;
            this.f13528c = pattern2;
            this.f13529d = pattern3;
        }

        boolean m19669a(Uri uri) {
            if (this.f13527b != null && (uri.getScheme() == null || !this.f13527b.matcher(uri.getScheme()).matches())) {
                return false;
            }
            if (this.f13528c != null && (uri.getHost() == null || !this.f13528c.matcher(uri.getHost()).matches())) {
                return false;
            }
            if (this.f13529d == null || (uri.getPath() != null && this.f13529d.matcher(uri.getPath()).matches())) {
                return true;
            }
            return false;
        }
    }

    public boolean m19672a(String str) {
        Pattern pattern = null;
        if (str == null || !f13531b.matcher(str).matches()) {
            C3783j.m19721a("Invalid whitelist pattern " + str);
            return false;
        } else if (str.equals("*")) {
            this.f13532c.add(new C3764a(this, Pattern.compile("(http)|(https)"), null, null));
            this.f13532c.add(new C3764a(this, Pattern.compile("file"), null, Pattern.compile("/.*")));
            return true;
        } else {
            Pattern compile;
            Pattern pattern2;
            Uri parse = Uri.parse(str);
            String scheme = parse.getScheme();
            String encodedAuthority = parse.getEncodedAuthority();
            String path = parse.getPath();
            if (C3954i.m20512a(scheme) || scheme.equals("*")) {
                compile = Pattern.compile("(http)|(https)");
            } else {
                compile = Pattern.compile(scheme);
            }
            if (C3954i.m20512a(encodedAuthority) || encodedAuthority.equals("*")) {
                pattern2 = null;
            } else if (encodedAuthority.startsWith("*.")) {
                pattern2 = Pattern.compile("(.*\\.)?" + m19671a(encodedAuthority.substring(2), true));
            } else {
                pattern2 = Pattern.compile(m19671a(encodedAuthority, true));
            }
            if (!C3954i.m20512a(path)) {
                pattern = Pattern.compile(m19671a(path, false));
            }
            this.f13532c.add(new C3764a(this, compile, pattern2, pattern));
            return true;
        }
    }

    public boolean m19673b(String str) {
        if (str == null) {
            return false;
        }
        Uri parse = Uri.parse(str);
        for (C3764a a : this.f13532c) {
            if (a.m19669a(parse)) {
                return true;
            }
        }
        return false;
    }

    private String m19671a(String str, boolean z) {
        StringBuilder stringBuilder = new StringBuilder();
        for (char valueOf : str.toCharArray()) {
            CharSequence valueOf2 = String.valueOf(valueOf);
            if (z || !valueOf2.equals("*")) {
                if ("\\.[]{}()^$?+|*".contains(valueOf2)) {
                    stringBuilder.append("\\");
                }
            } else if (valueOf2.equals("*")) {
                stringBuilder.append(".");
            }
            stringBuilder.append(valueOf2);
        }
        return stringBuilder.toString();
    }

    public static C3765b m19670a(C3761b c3761b) {
        C3765b c3765b = new C3765b();
        c3765b.m19672a("https://*.urbanairship.com");
        if (c3761b.f13510j != null) {
            for (String a : c3761b.f13510j) {
                c3765b.m19672a(a);
            }
        }
        return c3765b;
    }
}
