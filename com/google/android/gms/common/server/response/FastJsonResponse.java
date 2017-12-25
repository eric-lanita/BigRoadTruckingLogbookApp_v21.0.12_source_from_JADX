package com.google.android.gms.common.server.response;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.zzab;
import com.google.android.gms.common.server.converter.ConverterWrapper;
import com.google.android.gms.common.util.zzc;
import com.google.android.gms.common.util.zzp;
import com.google.android.gms.common.util.zzq;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public abstract class FastJsonResponse {

    public interface zza<I, O> {
        I convertBack(O o);

        int zzatt();

        int zzatu();
    }

    public static class Field<I, O> extends AbstractSafeParcelable {
        public static final zza CREATOR = new zza();
        protected final int f10822a;
        protected final boolean f10823b;
        protected final int f10824c;
        protected final boolean f10825d;
        protected final String f10826e;
        protected final int f10827f;
        protected final Class<? extends FastJsonResponse> f10828g;
        protected final String f10829h;
        private final int f10830i;
        private FieldMappingDictionary f10831j;
        private zza<I, O> f10832k;

        Field(int i, int i2, boolean z, int i3, boolean z2, String str, int i4, String str2, ConverterWrapper converterWrapper) {
            this.f10830i = i;
            this.f10822a = i2;
            this.f10823b = z;
            this.f10824c = i3;
            this.f10825d = z2;
            this.f10826e = str;
            this.f10827f = i4;
            if (str2 == null) {
                this.f10828g = null;
                this.f10829h = null;
            } else {
                this.f10828g = SafeParcelResponse.class;
                this.f10829h = str2;
            }
            if (converterWrapper == null) {
                this.f10832k = null;
            } else {
                this.f10832k = converterWrapper.zzatr();
            }
        }

        protected Field(int i, boolean z, int i2, boolean z2, String str, int i3, Class<? extends FastJsonResponse> cls, zza<I, O> com_google_android_gms_common_server_response_FastJsonResponse_zza_I__O) {
            this.f10830i = 1;
            this.f10822a = i;
            this.f10823b = z;
            this.f10824c = i2;
            this.f10825d = z2;
            this.f10826e = str;
            this.f10827f = i3;
            this.f10828g = cls;
            if (cls == null) {
                this.f10829h = null;
            } else {
                this.f10829h = cls.getCanonicalName();
            }
            this.f10832k = com_google_android_gms_common_server_response_FastJsonResponse_zza_I__O;
        }

        public static Field zza(String str, int i, zza<?, ?> com_google_android_gms_common_server_response_FastJsonResponse_zza___, boolean z) {
            return new Field(com_google_android_gms_common_server_response_FastJsonResponse_zza___.zzatt(), z, com_google_android_gms_common_server_response_FastJsonResponse_zza___.zzatu(), false, str, i, null, com_google_android_gms_common_server_response_FastJsonResponse_zza___);
        }

        public static <T extends FastJsonResponse> Field<T, T> zza(String str, int i, Class<T> cls) {
            return new Field(11, false, 11, false, str, i, cls, null);
        }

        public static <T extends FastJsonResponse> Field<ArrayList<T>, ArrayList<T>> zzb(String str, int i, Class<T> cls) {
            return new Field(11, true, 11, true, str, i, cls, null);
        }

        public static Field<Integer, Integer> zzj(String str, int i) {
            return new Field(0, false, 0, false, str, i, null, null);
        }

        public static Field<Boolean, Boolean> zzk(String str, int i) {
            return new Field(6, false, 6, false, str, i, null, null);
        }

        public static Field<String, String> zzl(String str, int i) {
            return new Field(7, false, 7, false, str, i, null, null);
        }

        String m16957a() {
            return this.f10829h == null ? null : this.f10829h;
        }

        ConverterWrapper m16958b() {
            return this.f10832k == null ? null : ConverterWrapper.zza(this.f10832k);
        }

        public I convertBack(O o) {
            return this.f10832k.convertBack(o);
        }

        public int getVersionCode() {
            return this.f10830i;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Field\n");
            stringBuilder.append("            versionCode=").append(this.f10830i).append('\n');
            stringBuilder.append("                 typeIn=").append(this.f10822a).append('\n');
            stringBuilder.append("            typeInArray=").append(this.f10823b).append('\n');
            stringBuilder.append("                typeOut=").append(this.f10824c).append('\n');
            stringBuilder.append("           typeOutArray=").append(this.f10825d).append('\n');
            stringBuilder.append("        outputFieldName=").append(this.f10826e).append('\n');
            stringBuilder.append("      safeParcelFieldId=").append(this.f10827f).append('\n');
            stringBuilder.append("       concreteTypeName=").append(m16957a()).append('\n');
            if (zzauc() != null) {
                stringBuilder.append("     concreteType.class=").append(zzauc().getCanonicalName()).append('\n');
            }
            stringBuilder.append("          converterName=").append(this.f10832k == null ? "null" : this.f10832k.getClass().getCanonicalName()).append('\n');
            return stringBuilder.toString();
        }

        public void writeToParcel(Parcel parcel, int i) {
            zza com_google_android_gms_common_server_response_zza = CREATOR;
            zza.m16980a(this, parcel, i);
        }

        public void zza(FieldMappingDictionary fieldMappingDictionary) {
            this.f10831j = fieldMappingDictionary;
        }

        public int zzatt() {
            return this.f10822a;
        }

        public int zzatu() {
            return this.f10824c;
        }

        public boolean zzaty() {
            return this.f10823b;
        }

        public boolean zzatz() {
            return this.f10825d;
        }

        public String zzaua() {
            return this.f10826e;
        }

        public int zzaub() {
            return this.f10827f;
        }

        public Class<? extends FastJsonResponse> zzauc() {
            return this.f10828g;
        }

        public boolean zzaue() {
            return this.f10832k != null;
        }

        public Map<String, Field<?, ?>> zzaug() {
            zzab.zzy(this.f10829h);
            zzab.zzy(this.f10831j);
            return this.f10831j.zzhw(this.f10829h);
        }
    }

    private void m16959a(StringBuilder stringBuilder, Field field, Object obj) {
        if (field.zzatt() == 11) {
            stringBuilder.append(((FastJsonResponse) field.zzauc().cast(obj)).toString());
        } else if (field.zzatt() == 7) {
            stringBuilder.append("\"");
            stringBuilder.append(zzp.zzia((String) obj));
            stringBuilder.append("\"");
        } else {
            stringBuilder.append(obj);
        }
    }

    private void m16960a(StringBuilder stringBuilder, Field field, ArrayList<Object> arrayList) {
        stringBuilder.append("[");
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            if (i > 0) {
                stringBuilder.append(",");
            }
            Object obj = arrayList.get(i);
            if (obj != null) {
                m16959a(stringBuilder, field, obj);
            }
        }
        stringBuilder.append("]");
    }

    protected <O, I> I m16961a(Field<I, O> field, Object obj) {
        return field.f10832k != null ? field.convertBack(obj) : obj;
    }

    protected boolean m16962a(Field field) {
        return field.zzatu() == 11 ? field.zzatz() ? m16965b(field.zzaua()) : m16963a(field.zzaua()) : zzht(field.zzaua());
    }

    protected boolean m16963a(String str) {
        throw new UnsupportedOperationException("Concrete types not supported");
    }

    protected Object m16964b(Field field) {
        String zzaua = field.zzaua();
        if (field.zzauc() == null) {
            return zzhs(field.zzaua());
        }
        zzab.zza(zzhs(field.zzaua()) == null, "Concrete field shouldn't be value object: %s", field.zzaua());
        Map zzatx = field.zzatz() ? zzatx() : zzatw();
        if (zzatx != null) {
            return zzatx.get(zzaua);
        }
        try {
            char toUpperCase = Character.toUpperCase(zzaua.charAt(0));
            String valueOf = String.valueOf(zzaua.substring(1));
            return getClass().getMethod(new StringBuilder(String.valueOf(valueOf).length() + 4).append("get").append(toUpperCase).append(valueOf).toString(), new Class[0]).invoke(this, new Object[0]);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    protected boolean m16965b(String str) {
        throw new UnsupportedOperationException("Concrete type arrays not supported");
    }

    public String toString() {
        Map zzatv = zzatv();
        StringBuilder stringBuilder = new StringBuilder(100);
        for (String str : zzatv.keySet()) {
            Field field = (Field) zzatv.get(str);
            if (m16962a(field)) {
                Object a = m16961a(field, m16964b(field));
                if (stringBuilder.length() == 0) {
                    stringBuilder.append("{");
                } else {
                    stringBuilder.append(",");
                }
                stringBuilder.append("\"").append(str).append("\":");
                if (a != null) {
                    switch (field.zzatu()) {
                        case 8:
                            stringBuilder.append("\"").append(zzc.zzp((byte[]) a)).append("\"");
                            break;
                        case 9:
                            stringBuilder.append("\"").append(zzc.zzq((byte[]) a)).append("\"");
                            break;
                        case 10:
                            zzq.zza(stringBuilder, (HashMap) a);
                            break;
                        default:
                            if (!field.zzaty()) {
                                m16959a(stringBuilder, field, a);
                                break;
                            }
                            m16960a(stringBuilder, field, (ArrayList) a);
                            break;
                    }
                }
                stringBuilder.append("null");
            }
        }
        if (stringBuilder.length() > 0) {
            stringBuilder.append("}");
        } else {
            stringBuilder.append("{}");
        }
        return stringBuilder.toString();
    }

    public abstract Map<String, Field<?, ?>> zzatv();

    public HashMap<String, Object> zzatw() {
        return null;
    }

    public HashMap<String, Object> zzatx() {
        return null;
    }

    protected abstract Object zzhs(String str);

    protected abstract boolean zzht(String str);
}
