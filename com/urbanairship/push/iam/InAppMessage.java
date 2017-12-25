package com.urbanairship.push.iam;

import android.graphics.Color;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.internal.ServerProtocol;
import com.facebook.share.internal.ShareConstants;
import com.urbanairship.C3783j;
import com.urbanairship.actions.ActionValue;
import com.urbanairship.json.C3684c;
import com.urbanairship.json.C3788b;
import com.urbanairship.json.JsonException;
import com.urbanairship.json.JsonValue;
import com.urbanairship.util.C3948c;
import com.urbanairship.util.C3954i;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.TimeUnit;

public class InAppMessage implements Parcelable, C3684c {
    public static final Creator<InAppMessage> CREATOR = new C38861();
    private final long f13816a;
    private final String f13817b;
    private final String f13818c;
    private final Long f13819d;
    private final Integer f13820e;
    private final Integer f13821f;
    private final int f13822g;
    private final String f13823h;
    private final Map<String, ActionValue> f13824i;
    private final C3788b f13825j;
    private final Map<String, Map<String, ActionValue>> f13826k;

    static class C38861 implements Creator<InAppMessage> {
        C38861() {
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return m20146a(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return m20147a(i);
        }

        public InAppMessage m20146a(Parcel parcel) {
            return new InAppMessage(parcel);
        }

        public InAppMessage[] m20147a(int i) {
            return new InAppMessage[i];
        }
    }

    public static class C3887a {
        private Map<String, ActionValue> f13805a;
        private C3788b f13806b;
        private Map<String, Map<String, ActionValue>> f13807c = new HashMap();
        private String f13808d;
        private String f13809e;
        private String f13810f;
        private Long f13811g;
        private Long f13812h;
        private int f13813i = 0;
        private Integer f13814j;
        private Integer f13815k;

        public C3887a(InAppMessage inAppMessage) {
            this.f13810f = inAppMessage.f13817b;
            this.f13808d = inAppMessage.f13823h;
            this.f13809e = inAppMessage.f13818c;
            this.f13811g = Long.valueOf(inAppMessage.f13816a);
            this.f13812h = inAppMessage.f13819d;
            this.f13813i = inAppMessage.f13822g;
            this.f13805a = new HashMap(inAppMessage.f13824i);
            this.f13807c = new HashMap(inAppMessage.f13826k);
            this.f13806b = inAppMessage.f13825j;
            this.f13814j = inAppMessage.f13820e;
            this.f13815k = inAppMessage.f13821f;
        }

        public C3887a m20163a(String str) {
            this.f13810f = str;
            return this;
        }

        public C3887a m20162a(Long l) {
            this.f13811g = l;
            return this;
        }

        public C3887a m20160a(C3788b c3788b) {
            this.f13806b = c3788b;
            return this;
        }

        public C3887a m20165a(Map<String, ActionValue> map) {
            if (map == null) {
                this.f13805a = null;
            } else {
                this.f13805a = new HashMap(map);
            }
            return this;
        }

        public C3887a m20164a(String str, Map<String, ActionValue> map) {
            if (map == null) {
                this.f13807c.remove(str);
            } else {
                this.f13807c.put(str, new HashMap(map));
            }
            return this;
        }

        public C3887a m20169b(String str) {
            this.f13808d = str;
            return this;
        }

        public C3887a m20170c(String str) {
            this.f13809e = str;
            return this;
        }

        public C3887a m20168b(Long l) {
            if (l == null || l.longValue() > 0) {
                this.f13812h = l;
                return this;
            }
            throw new IllegalArgumentException("Duration must be greater than 0 milliseconds");
        }

        public C3887a m20159a(int i) {
            if (i == 1 || i == 0) {
                this.f13813i = i;
                return this;
            }
            throw new IllegalArgumentException("Position must be either InAppMessage.POSITION_BOTTOM or InAppMessage.POSITION_TOP.");
        }

        public C3887a m20161a(Integer num) {
            this.f13814j = num;
            return this;
        }

        public C3887a m20167b(Integer num) {
            this.f13815k = num;
            return this;
        }

        public InAppMessage m20166a() {
            return new InAppMessage();
        }
    }

    private InAppMessage(C3887a c3887a) {
        this.f13816a = c3887a.f13811g == null ? System.currentTimeMillis() + 2592000000L : c3887a.f13811g.longValue();
        this.f13817b = c3887a.f13810f;
        this.f13825j = c3887a.f13806b == null ? new C3788b(null) : c3887a.f13806b;
        this.f13818c = c3887a.f13809e;
        this.f13819d = c3887a.f13812h;
        this.f13823h = c3887a.f13808d;
        this.f13826k = c3887a.f13807c;
        this.f13824i = c3887a.f13805a == null ? new HashMap() : c3887a.f13805a;
        this.f13822g = c3887a.f13813i;
        this.f13820e = c3887a.f13814j;
        this.f13821f = c3887a.f13815k;
    }

    private InAppMessage(Parcel parcel) {
        Integer valueOf;
        C3788b f;
        this.f13817b = parcel.readString();
        this.f13818c = parcel.readString();
        this.f13816a = parcel.readLong();
        this.f13822g = parcel.readInt();
        this.f13819d = parcel.readByte() == (byte) 1 ? Long.valueOf(parcel.readLong()) : null;
        if (parcel.readByte() == (byte) 1) {
            valueOf = Integer.valueOf(parcel.readInt());
        } else {
            valueOf = null;
        }
        this.f13820e = valueOf;
        if (parcel.readByte() == (byte) 1) {
            valueOf = Integer.valueOf(parcel.readInt());
        } else {
            valueOf = null;
        }
        this.f13821f = valueOf;
        try {
            f = JsonValue.m19740b(parcel.readString()).m19755f();
        } catch (JsonException e) {
            C3783j.m19728e("InAppMessage - unable to parse extras from parcel.");
            f = null;
        }
        if (f == null) {
            f = new C3788b(null);
        }
        this.f13825j = f;
        this.f13823h = parcel.readString();
        this.f13826k = new HashMap();
        parcel.readMap(this.f13826k, ActionValue.class.getClassLoader());
        this.f13824i = new HashMap();
        parcel.readMap(this.f13824i, ActionValue.class.getClassLoader());
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f13817b);
        parcel.writeString(this.f13818c);
        parcel.writeLong(this.f13816a);
        parcel.writeInt(this.f13822g);
        if (this.f13819d == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeLong(this.f13819d.longValue());
        }
        if (this.f13820e == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeInt(this.f13820e.intValue());
        }
        if (this.f13821f == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeInt(this.f13821f.intValue());
        }
        parcel.writeString(this.f13825j.toString());
        parcel.writeString(this.f13823h);
        parcel.writeMap(this.f13826k);
        parcel.writeMap(this.f13824i);
    }

    public int describeContents() {
        return 0;
    }

    public long m20184a() {
        return this.f13816a;
    }

    public boolean m20186b() {
        return System.currentTimeMillis() > this.f13816a;
    }

    public String m20187c() {
        return this.f13817b;
    }

    public String m20188d() {
        return this.f13818c;
    }

    public Map<String, ActionValue> m20190f() {
        return Collections.unmodifiableMap(this.f13824i);
    }

    public Map<String, ActionValue> m20185a(String str) {
        if (this.f13826k.containsKey(str)) {
            return Collections.unmodifiableMap((Map) this.f13826k.get(str));
        }
        return null;
    }

    public String m20191g() {
        return this.f13823h;
    }

    public Long m20192h() {
        return this.f13819d;
    }

    public int m20193i() {
        return this.f13822g;
    }

    public Integer m20194j() {
        return this.f13820e;
    }

    public Integer m20195k() {
        return this.f13821f;
    }

    public static InAppMessage m20172b(String str) {
        C3788b f = JsonValue.m19740b(str).m19755f();
        if (f == null) {
            return null;
        }
        C3788b f2 = f.m19782c(ServerProtocol.DIALOG_PARAM_DISPLAY).m19755f();
        C3788b f3 = f.m19782c("actions").m19755f();
        if (f2 == null || !"banner".equals(f2.m19782c(ShareConstants.MEDIA_TYPE).m19747a())) {
            C3783j.m19728e("InAppMessage - Unable to parse json: " + str);
            return null;
        }
        C3887a c3887a = new C3887a();
        c3887a.m20163a(f.m19782c(ShareConstants.WEB_DIALOG_PARAM_ID).m19747a()).m20160a(f.m19782c("extra").m19755f()).m20170c(f2.m19782c("alert").m19747a()).m20161a(m20174c(f2.m19782c("primary_color").m19747a())).m20167b(m20174c(f2.m19782c("secondary_color").m19747a()));
        long a;
        if (f2.m19779a("duration_ms")) {
            a = f2.m19780b("duration_ms").m19746a(0);
            if (a > 0) {
                c3887a.m20168b(Long.valueOf(a));
            }
        } else {
            a = f2.m19782c("duration").m19746a(0);
            if (a > 0) {
                c3887a.m20168b(Long.valueOf(TimeUnit.SECONDS.toMillis(a)));
            }
        }
        if (f.m19779a("expiry_ms")) {
            c3887a.m20162a(Long.valueOf(f.m19780b("expiry_ms").m19746a(System.currentTimeMillis() + 2592000000L)));
        } else if (f.m19779a("expiry")) {
            c3887a.m20162a(Long.valueOf(C3948c.m20491a(f.m19782c("expiry").m19747a(), System.currentTimeMillis() + 2592000000L)));
        }
        if ("top".equalsIgnoreCase(f2.m19782c("position").m19747a())) {
            c3887a.m20159a(1);
        } else {
            c3887a.m20159a(0);
        }
        if (f3 != null) {
            Entry entry;
            C3788b f4 = f3.m19782c("on_click").m19755f();
            if (f4 != null) {
                Map hashMap = new HashMap();
                Iterator it = f4.iterator();
                while (it.hasNext()) {
                    entry = (Entry) it.next();
                    hashMap.put(entry.getKey(), new ActionValue((JsonValue) entry.getValue()));
                }
                c3887a.m20165a(hashMap);
            }
            c3887a.m20169b(f3.m19782c("button_group").m19747a());
            f2 = f3.m19782c("button_actions").m19755f();
            if (f2 != null) {
                for (Entry entry2 : f2.m19781b()) {
                    String str2 = (String) entry2.getKey();
                    f = f2.m19782c(str2).m19755f();
                    Map hashMap2 = new HashMap();
                    for (Entry entry3 : f.m19781b()) {
                        hashMap2.put(entry3.getKey(), new ActionValue((JsonValue) entry3.getValue()));
                    }
                    c3887a.m20164a(str2, hashMap2);
                }
            }
        }
        return c3887a.m20166a();
    }

    private static Integer m20174c(String str) {
        Integer num = null;
        if (!C3954i.m20512a(str)) {
            try {
                num = Integer.valueOf(Color.parseColor(str));
            } catch (Throwable e) {
                C3783j.m19722a("InAppMessage - Unable to parse color: " + str, e);
            }
        }
        return num;
    }

    public JsonValue mo2767e() {
        Object hashMap = new HashMap();
        hashMap.put(ShareConstants.WEB_DIALOG_PARAM_ID, this.f13817b);
        hashMap.put("expiry_ms", Long.valueOf(this.f13816a));
        hashMap.put("extra", this.f13825j);
        Map hashMap2 = new HashMap();
        hashMap.put(ServerProtocol.DIALOG_PARAM_DISPLAY, hashMap2);
        hashMap2.put(ShareConstants.MEDIA_TYPE, "banner");
        hashMap2.put("alert", this.f13818c);
        hashMap2.put("position", this.f13822g == 1 ? "top" : "bottom");
        if (this.f13819d != null) {
            hashMap2.put("duration_ms", this.f13819d);
        }
        if (this.f13820e != null) {
            hashMap2.put("primary_color", String.format(Locale.US, "#%06X", new Object[]{Integer.valueOf(this.f13820e.intValue() & 16777215)}));
        }
        if (this.f13821f != null) {
            hashMap2.put("secondary_color", String.format(Locale.US, "#%06X", new Object[]{Integer.valueOf(this.f13821f.intValue() & 16777215)}));
        }
        Map hashMap3 = new HashMap();
        hashMap.put("actions", hashMap3);
        hashMap3.put("on_click", this.f13824i);
        hashMap3.put("button_group", this.f13823h);
        hashMap3.put("button_actions", this.f13826k);
        return JsonValue.m19732a(hashMap);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean equals(java.lang.Object r7) {
        /*
        r6 = this;
        r0 = 1;
        r1 = 0;
        if (r6 != r7) goto L_0x0005;
    L_0x0004:
        return r0;
    L_0x0005:
        r2 = r7 instanceof com.urbanairship.push.iam.InAppMessage;
        if (r2 != 0) goto L_0x000b;
    L_0x0009:
        r0 = r1;
        goto L_0x0004;
    L_0x000b:
        r7 = (com.urbanairship.push.iam.InAppMessage) r7;
        r2 = r6.f13817b;
        if (r2 != 0) goto L_0x006b;
    L_0x0011:
        r2 = r7.f13817b;
        if (r2 != 0) goto L_0x0069;
    L_0x0015:
        r2 = r6.f13818c;
        if (r2 != 0) goto L_0x0076;
    L_0x0019:
        r2 = r7.f13818c;
        if (r2 != 0) goto L_0x0069;
    L_0x001d:
        r2 = r6.f13823h;
        if (r2 != 0) goto L_0x0081;
    L_0x0021:
        r2 = r7.f13823h;
        if (r2 != 0) goto L_0x0069;
    L_0x0025:
        r2 = r6.f13825j;
        r3 = r7.f13825j;
        r2 = r2.equals(r3);
        if (r2 == 0) goto L_0x0069;
    L_0x002f:
        r2 = r6.f13824i;
        r3 = r7.f13824i;
        r2 = r2.equals(r3);
        if (r2 == 0) goto L_0x0069;
    L_0x0039:
        r2 = r6.f13826k;
        r3 = r7.f13826k;
        r2 = r2.equals(r3);
        if (r2 == 0) goto L_0x0069;
    L_0x0043:
        r2 = r6.f13820e;
        if (r2 != 0) goto L_0x008c;
    L_0x0047:
        r2 = r7.f13820e;
        if (r2 != 0) goto L_0x0069;
    L_0x004b:
        r2 = r6.f13821f;
        if (r2 != 0) goto L_0x0097;
    L_0x004f:
        r2 = r7.f13821f;
        if (r2 != 0) goto L_0x0069;
    L_0x0053:
        r2 = r6.f13819d;
        if (r2 != 0) goto L_0x00a2;
    L_0x0057:
        r2 = r7.f13819d;
        if (r2 != 0) goto L_0x0069;
    L_0x005b:
        r2 = r6.f13822g;
        r3 = r7.f13822g;
        if (r2 != r3) goto L_0x0069;
    L_0x0061:
        r2 = r6.f13816a;
        r4 = r7.f13816a;
        r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1));
        if (r2 == 0) goto L_0x0004;
    L_0x0069:
        r0 = r1;
        goto L_0x0004;
    L_0x006b:
        r2 = r6.f13817b;
        r3 = r7.f13817b;
        r2 = r2.equals(r3);
        if (r2 == 0) goto L_0x0069;
    L_0x0075:
        goto L_0x0015;
    L_0x0076:
        r2 = r6.f13818c;
        r3 = r7.f13818c;
        r2 = r2.equals(r3);
        if (r2 == 0) goto L_0x0069;
    L_0x0080:
        goto L_0x001d;
    L_0x0081:
        r2 = r6.f13823h;
        r3 = r7.f13823h;
        r2 = r2.equals(r3);
        if (r2 == 0) goto L_0x0069;
    L_0x008b:
        goto L_0x0025;
    L_0x008c:
        r2 = r6.f13820e;
        r3 = r7.f13820e;
        r2 = r2.equals(r3);
        if (r2 == 0) goto L_0x0069;
    L_0x0096:
        goto L_0x004b;
    L_0x0097:
        r2 = r6.f13821f;
        r3 = r7.f13821f;
        r2 = r2.equals(r3);
        if (r2 == 0) goto L_0x0069;
    L_0x00a1:
        goto L_0x0053;
    L_0x00a2:
        r2 = r6.f13819d;
        r3 = r7.f13819d;
        r2 = r2.equals(r3);
        if (r2 == 0) goto L_0x0069;
    L_0x00ac:
        goto L_0x005b;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.push.iam.InAppMessage.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        int i = 0;
        int intValue = ((this.f13820e == null ? 0 : this.f13820e.intValue()) + (((this.f13821f == null ? 0 : this.f13821f.intValue()) + (((((((((this.f13823h == null ? 0 : this.f13823h.hashCode()) + (((this.f13818c == null ? 0 : this.f13818c.hashCode()) + (((this.f13817b == null ? 0 : this.f13817b.hashCode()) + 403) * 31)) * 31)) * 31) + this.f13825j.hashCode()) * 31) + this.f13824i.hashCode()) * 31) + this.f13826k.hashCode()) * 31)) * 31)) * 31;
        if (this.f13819d != null) {
            i = this.f13819d.hashCode();
        }
        return ((((intValue + i) * 31) + this.f13822g) * 31) + Long.valueOf(this.f13816a).hashCode();
    }
}
