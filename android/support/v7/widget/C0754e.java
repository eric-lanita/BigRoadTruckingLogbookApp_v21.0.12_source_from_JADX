package android.support.v7.widget;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.database.DataSetObservable;
import android.os.AsyncTask;
import android.support.v4.os.C0316a;
import android.text.TextUtils;
import android.util.Log;
import android.util.Xml;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;

class C0754e extends DataSetObservable {
    private static final String f2256a = C0754e.class.getSimpleName();
    private static final Object f2257b = new Object();
    private static final Map<String, C0754e> f2258c = new HashMap();
    private final Object f2259d;
    private final List<C0749a> f2260e;
    private final List<C0751c> f2261f;
    private final Context f2262g;
    private final String f2263h;
    private Intent f2264i;
    private C0750b f2265j;
    private int f2266k;
    private boolean f2267l;
    private boolean f2268m;
    private boolean f2269n;
    private boolean f2270o;
    private C0752d f2271p;

    public final class C0749a implements Comparable<C0749a> {
        public final ResolveInfo f2249a;
        public float f2250b;
        final /* synthetic */ C0754e f2251c;

        public /* synthetic */ int compareTo(Object obj) {
            return m3850a((C0749a) obj);
        }

        public C0749a(C0754e c0754e, ResolveInfo resolveInfo) {
            this.f2251c = c0754e;
            this.f2249a = resolveInfo;
        }

        public int hashCode() {
            return Float.floatToIntBits(this.f2250b) + 31;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null) {
                return false;
            }
            if (getClass() != obj.getClass()) {
                return false;
            }
            if (Float.floatToIntBits(this.f2250b) != Float.floatToIntBits(((C0749a) obj).f2250b)) {
                return false;
            }
            return true;
        }

        public int m3850a(C0749a c0749a) {
            return Float.floatToIntBits(c0749a.f2250b) - Float.floatToIntBits(this.f2250b);
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("[");
            stringBuilder.append("resolveInfo:").append(this.f2249a.toString());
            stringBuilder.append("; weight:").append(new BigDecimal((double) this.f2250b));
            stringBuilder.append("]");
            return stringBuilder.toString();
        }
    }

    public interface C0750b {
        void m3851a(Intent intent, List<C0749a> list, List<C0751c> list2);
    }

    public static final class C0751c {
        public final ComponentName f2252a;
        public final long f2253b;
        public final float f2254c;

        public C0751c(String str, long j, float f) {
            this(ComponentName.unflattenFromString(str), j, f);
        }

        public C0751c(ComponentName componentName, long j, float f) {
            this.f2252a = componentName;
            this.f2253b = j;
            this.f2254c = f;
        }

        public int hashCode() {
            return (((((this.f2252a == null ? 0 : this.f2252a.hashCode()) + 31) * 31) + ((int) (this.f2253b ^ (this.f2253b >>> 32)))) * 31) + Float.floatToIntBits(this.f2254c);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null) {
                return false;
            }
            if (getClass() != obj.getClass()) {
                return false;
            }
            C0751c c0751c = (C0751c) obj;
            if (this.f2252a == null) {
                if (c0751c.f2252a != null) {
                    return false;
                }
            } else if (!this.f2252a.equals(c0751c.f2252a)) {
                return false;
            }
            if (this.f2253b != c0751c.f2253b) {
                return false;
            }
            if (Float.floatToIntBits(this.f2254c) != Float.floatToIntBits(c0751c.f2254c)) {
                return false;
            }
            return true;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("[");
            stringBuilder.append("; activity:").append(this.f2252a);
            stringBuilder.append("; time:").append(this.f2253b);
            stringBuilder.append("; weight:").append(new BigDecimal((double) this.f2254c));
            stringBuilder.append("]");
            return stringBuilder.toString();
        }
    }

    public interface C0752d {
        boolean m3852a(C0754e c0754e, Intent intent);
    }

    private final class C0753e extends AsyncTask<Object, Void, Void> {
        final /* synthetic */ C0754e f2255a;

        private C0753e(C0754e c0754e) {
            this.f2255a = c0754e;
        }

        public /* synthetic */ Object doInBackground(Object[] objArr) {
            return m3853a(objArr);
        }

        public Void m3853a(Object... objArr) {
            int i = 0;
            List list = (List) objArr[0];
            String str = (String) objArr[1];
            try {
                OutputStream openFileOutput = this.f2255a.f2262g.openFileOutput(str, 0);
                XmlSerializer newSerializer = Xml.newSerializer();
                try {
                    newSerializer.setOutput(openFileOutput, null);
                    newSerializer.startDocument("UTF-8", Boolean.valueOf(true));
                    newSerializer.startTag(null, "historical-records");
                    int size = list.size();
                    while (i < size) {
                        C0751c c0751c = (C0751c) list.remove(0);
                        newSerializer.startTag(null, "historical-record");
                        newSerializer.attribute(null, "activity", c0751c.f2252a.flattenToString());
                        newSerializer.attribute(null, "time", String.valueOf(c0751c.f2253b));
                        newSerializer.attribute(null, "weight", String.valueOf(c0751c.f2254c));
                        newSerializer.endTag(null, "historical-record");
                        i++;
                    }
                    newSerializer.endTag(null, "historical-records");
                    newSerializer.endDocument();
                    this.f2255a.f2267l = true;
                    if (openFileOutput != null) {
                        try {
                            openFileOutput.close();
                        } catch (IOException e) {
                        }
                    }
                } catch (Throwable e2) {
                    Log.e(C0754e.f2256a, "Error writing historical recrod file: " + this.f2255a.f2263h, e2);
                    this.f2255a.f2267l = true;
                    if (openFileOutput != null) {
                        try {
                            openFileOutput.close();
                        } catch (IOException e3) {
                        }
                    }
                } catch (Throwable e22) {
                    Log.e(C0754e.f2256a, "Error writing historical recrod file: " + this.f2255a.f2263h, e22);
                    this.f2255a.f2267l = true;
                    if (openFileOutput != null) {
                        try {
                            openFileOutput.close();
                        } catch (IOException e4) {
                        }
                    }
                } catch (Throwable e222) {
                    Log.e(C0754e.f2256a, "Error writing historical recrod file: " + this.f2255a.f2263h, e222);
                    this.f2255a.f2267l = true;
                    if (openFileOutput != null) {
                        try {
                            openFileOutput.close();
                        } catch (IOException e5) {
                        }
                    }
                } catch (Throwable th) {
                    this.f2255a.f2267l = true;
                    if (openFileOutput != null) {
                        try {
                            openFileOutput.close();
                        } catch (IOException e6) {
                        }
                    }
                }
            } catch (Throwable e2222) {
                Log.e(C0754e.f2256a, "Error writing historical recrod file: " + str, e2222);
            }
            return null;
        }
    }

    public int m3866a() {
        int size;
        synchronized (this.f2259d) {
            m3860e();
            size = this.f2260e.size();
        }
        return size;
    }

    public ResolveInfo m3868a(int i) {
        ResolveInfo resolveInfo;
        synchronized (this.f2259d) {
            m3860e();
            resolveInfo = ((C0749a) this.f2260e.get(i)).f2249a;
        }
        return resolveInfo;
    }

    public int m3867a(ResolveInfo resolveInfo) {
        synchronized (this.f2259d) {
            m3860e();
            List list = this.f2260e;
            int size = list.size();
            for (int i = 0; i < size; i++) {
                if (((C0749a) list.get(i)).f2249a == resolveInfo) {
                    return i;
                }
            }
            return -1;
        }
    }

    public Intent m3869b(int i) {
        synchronized (this.f2259d) {
            if (this.f2264i == null) {
                return null;
            }
            m3860e();
            C0749a c0749a = (C0749a) this.f2260e.get(i);
            ComponentName componentName = new ComponentName(c0749a.f2249a.activityInfo.packageName, c0749a.f2249a.activityInfo.name);
            Intent intent = new Intent(this.f2264i);
            intent.setComponent(componentName);
            if (this.f2271p != null) {
                if (this.f2271p.m3852a(this, new Intent(intent))) {
                    return null;
                }
            }
            m3855a(new C0751c(componentName, System.currentTimeMillis(), 1.0f));
            return intent;
        }
    }

    public ResolveInfo m3870b() {
        synchronized (this.f2259d) {
            m3860e();
            if (this.f2260e.isEmpty()) {
                return null;
            }
            ResolveInfo resolveInfo = ((C0749a) this.f2260e.get(0)).f2249a;
            return resolveInfo;
        }
    }

    public void m3871c(int i) {
        synchronized (this.f2259d) {
            float f;
            m3860e();
            C0749a c0749a = (C0749a) this.f2260e.get(i);
            C0749a c0749a2 = (C0749a) this.f2260e.get(0);
            if (c0749a2 != null) {
                f = (c0749a2.f2250b - c0749a.f2250b) + 5.0f;
            } else {
                f = 1.0f;
            }
            m3855a(new C0751c(new ComponentName(c0749a.f2249a.activityInfo.packageName, c0749a.f2249a.activityInfo.name), System.currentTimeMillis(), f));
        }
    }

    private void m3859d() {
        if (!this.f2268m) {
            throw new IllegalStateException("No preceding call to #readHistoricalData");
        } else if (this.f2269n) {
            this.f2269n = false;
            if (!TextUtils.isEmpty(this.f2263h)) {
                C0316a.m1279a(new C0753e(), new ArrayList(this.f2261f), this.f2263h);
            }
        }
    }

    private void m3860e() {
        int g = m3862g() | m3863h();
        m3864i();
        if (g != 0) {
            m3861f();
            notifyChanged();
        }
    }

    private boolean m3861f() {
        if (this.f2265j == null || this.f2264i == null || this.f2260e.isEmpty() || this.f2261f.isEmpty()) {
            return false;
        }
        this.f2265j.m3851a(this.f2264i, this.f2260e, Collections.unmodifiableList(this.f2261f));
        return true;
    }

    private boolean m3862g() {
        if (!this.f2270o || this.f2264i == null) {
            return false;
        }
        this.f2270o = false;
        this.f2260e.clear();
        List queryIntentActivities = this.f2262g.getPackageManager().queryIntentActivities(this.f2264i, 0);
        int size = queryIntentActivities.size();
        for (int i = 0; i < size; i++) {
            this.f2260e.add(new C0749a(this, (ResolveInfo) queryIntentActivities.get(i)));
        }
        return true;
    }

    private boolean m3863h() {
        if (!this.f2267l || !this.f2269n || TextUtils.isEmpty(this.f2263h)) {
            return false;
        }
        this.f2267l = false;
        this.f2268m = true;
        m3865j();
        return true;
    }

    private boolean m3855a(C0751c c0751c) {
        boolean add = this.f2261f.add(c0751c);
        if (add) {
            this.f2269n = true;
            m3864i();
            m3859d();
            m3861f();
            notifyChanged();
        }
        return add;
    }

    private void m3864i() {
        int size = this.f2261f.size() - this.f2266k;
        if (size > 0) {
            this.f2269n = true;
            for (int i = 0; i < size; i++) {
                C0751c c0751c = (C0751c) this.f2261f.remove(0);
            }
        }
    }

    private void m3865j() {
        try {
            InputStream openFileInput = this.f2262g.openFileInput(this.f2263h);
            try {
                XmlPullParser newPullParser = Xml.newPullParser();
                newPullParser.setInput(openFileInput, "UTF-8");
                int i = 0;
                while (i != 1 && i != 2) {
                    i = newPullParser.next();
                }
                if ("historical-records".equals(newPullParser.getName())) {
                    List list = this.f2261f;
                    list.clear();
                    while (true) {
                        int next = newPullParser.next();
                        if (next == 1) {
                            break;
                        } else if (!(next == 3 || next == 4)) {
                            if ("historical-record".equals(newPullParser.getName())) {
                                list.add(new C0751c(newPullParser.getAttributeValue(null, "activity"), Long.parseLong(newPullParser.getAttributeValue(null, "time")), Float.parseFloat(newPullParser.getAttributeValue(null, "weight"))));
                            } else {
                                throw new XmlPullParserException("Share records file not well-formed.");
                            }
                        }
                    }
                    if (openFileInput != null) {
                        try {
                            openFileInput.close();
                            return;
                        } catch (IOException e) {
                            return;
                        }
                    }
                    return;
                }
                throw new XmlPullParserException("Share records file does not start with historical-records tag.");
            } catch (Throwable e2) {
                Log.e(f2256a, "Error reading historical recrod file: " + this.f2263h, e2);
                if (openFileInput != null) {
                    try {
                        openFileInput.close();
                    } catch (IOException e3) {
                    }
                }
            } catch (Throwable e22) {
                Log.e(f2256a, "Error reading historical recrod file: " + this.f2263h, e22);
                if (openFileInput != null) {
                    try {
                        openFileInput.close();
                    } catch (IOException e4) {
                    }
                }
            } catch (Throwable th) {
                if (openFileInput != null) {
                    try {
                        openFileInput.close();
                    } catch (IOException e5) {
                    }
                }
            }
        } catch (FileNotFoundException e6) {
        }
    }
}
