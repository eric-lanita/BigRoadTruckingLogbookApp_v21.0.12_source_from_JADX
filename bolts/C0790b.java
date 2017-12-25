package bolts;

import android.net.Uri;
import java.util.Collections;
import java.util.List;

public class C0790b {
    private Uri f2379a;
    private List<C0789a> f2380b;
    private Uri f2381c;

    public static class C0789a {
        private final Uri f2375a;
        private final String f2376b;
        private final String f2377c;
        private final String f2378d;

        public C0789a(String str, String str2, Uri uri, String str3) {
            this.f2376b = str;
            this.f2377c = str2;
            this.f2375a = uri;
            this.f2378d = str3;
        }
    }

    public C0790b(Uri uri, List<C0789a> list, Uri uri2) {
        this.f2379a = uri;
        if (list == null) {
            list = Collections.emptyList();
        }
        this.f2380b = list;
        this.f2381c = uri2;
    }
}
