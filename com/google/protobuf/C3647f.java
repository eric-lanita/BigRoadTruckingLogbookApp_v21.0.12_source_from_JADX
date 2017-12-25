package com.google.protobuf;

import com.google.protobuf.C3648g.C2500a;
import com.google.protobuf.WireFormat.FieldType;
import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;

final class C3647f<FieldDescriptorType extends C3630a<FieldDescriptorType>> {
    private static final C3647f f13230d = new C3647f(true);
    private final C3661p<FieldDescriptorType, Object> f13231a = C3661p.m19214a(16);
    private boolean f13232b;
    private boolean f13233c = false;

    public interface C3630a<T extends C3630a<T>> extends Comparable<T> {
        FieldType mo2742a();

        boolean mo2743b();
    }

    public /* synthetic */ Object clone() {
        return m19150c();
    }

    private C3647f() {
    }

    private C3647f(boolean z) {
        m19148b();
    }

    public static <T extends C3630a<T>> C3647f<T> m19143a() {
        return new C3647f();
    }

    public void m19148b() {
        if (!this.f13232b) {
            this.f13231a.mo2764a();
            this.f13232b = true;
        }
    }

    public C3647f<FieldDescriptorType> m19150c() {
        C3647f<FieldDescriptorType> a = C3647f.m19143a();
        for (int i = 0; i < this.f13231a.m19227c(); i++) {
            Entry b = this.f13231a.m19225b(i);
            a.m19147a((C3630a) b.getKey(), b.getValue());
        }
        for (Entry entry : this.f13231a.m19228d()) {
            a.m19147a((C3630a) entry.getKey(), entry.getValue());
        }
        a.f13233c = this.f13233c;
        return a;
    }

    public Object m19146a(FieldDescriptorType fieldDescriptorType) {
        Object obj = this.f13231a.get(fieldDescriptorType);
        if (obj instanceof C3649h) {
            return ((C3649h) obj).m19152a();
        }
        return obj;
    }

    public void m19147a(FieldDescriptorType fieldDescriptorType, Object obj) {
        if (!fieldDescriptorType.mo2743b()) {
            C3647f.m19145a(fieldDescriptorType.mo2742a(), obj);
        } else if (obj instanceof List) {
            List<Object> arrayList = new ArrayList();
            arrayList.addAll((List) obj);
            for (Object a : arrayList) {
                C3647f.m19145a(fieldDescriptorType.mo2742a(), a);
            }
            obj = arrayList;
        } else {
            throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
        }
        if (obj instanceof C3649h) {
            this.f13233c = true;
        }
        this.f13231a.m19223a((Comparable) fieldDescriptorType, obj);
    }

    public void m19149b(FieldDescriptorType fieldDescriptorType, Object obj) {
        if (fieldDescriptorType.mo2743b()) {
            List arrayList;
            C3647f.m19145a(fieldDescriptorType.mo2742a(), obj);
            Object a = m19146a(fieldDescriptorType);
            if (a == null) {
                arrayList = new ArrayList();
                this.f13231a.m19223a((Comparable) fieldDescriptorType, (Object) arrayList);
            } else {
                arrayList = (List) a;
            }
            arrayList.add(obj);
            return;
        }
        throw new IllegalArgumentException("addRepeatedField() can only be called on repeated fields.");
    }

    private static void m19145a(FieldType fieldType, Object obj) {
        boolean z = false;
        if (obj == null) {
            throw new NullPointerException();
        }
        switch (fieldType.m19064a()) {
            case INT:
                z = obj instanceof Integer;
                break;
            case LONG:
                z = obj instanceof Long;
                break;
            case FLOAT:
                z = obj instanceof Float;
                break;
            case DOUBLE:
                z = obj instanceof Double;
                break;
            case BOOLEAN:
                z = obj instanceof Boolean;
                break;
            case STRING:
                z = obj instanceof String;
                break;
            case BYTE_STRING:
                z = obj instanceof C3642c;
                break;
            case ENUM:
                z = obj instanceof C2500a;
                break;
            case MESSAGE:
                if ((obj instanceof C2487l) || (obj instanceof C3649h)) {
                    z = true;
                    break;
                }
        }
        if (!z) {
            throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
        }
    }

    static int m19142a(FieldType fieldType, boolean z) {
        if (z) {
            return 2;
        }
        return fieldType.m19065b();
    }

    public static Object m19144a(C3643d c3643d, FieldType fieldType) {
        switch (fieldType) {
            case DOUBLE:
                return Double.valueOf(c3643d.m19113c());
            case FLOAT:
                return Float.valueOf(c3643d.m19114d());
            case INT64:
                return Long.valueOf(c3643d.m19118f());
            case UINT64:
                return Long.valueOf(c3643d.m19116e());
            case INT32:
                return Integer.valueOf(c3643d.m19120g());
            case FIXED64:
                return Long.valueOf(c3643d.m19122h());
            case FIXED32:
                return Integer.valueOf(c3643d.m19123i());
            case BOOL:
                return Boolean.valueOf(c3643d.m19124j());
            case STRING:
                return c3643d.m19125k();
            case BYTES:
                return c3643d.m19126l();
            case UINT32:
                return Integer.valueOf(c3643d.m19127m());
            case SFIXED32:
                return Integer.valueOf(c3643d.m19129o());
            case SFIXED64:
                return Long.valueOf(c3643d.m19130p());
            case SINT32:
                return Integer.valueOf(c3643d.m19131q());
            case SINT64:
                return Long.valueOf(c3643d.m19132r());
            case GROUP:
                throw new IllegalArgumentException("readPrimitiveField() cannot handle nested groups.");
            case MESSAGE:
                throw new IllegalArgumentException("readPrimitiveField() cannot handle embedded messages.");
            case ENUM:
                throw new IllegalArgumentException("readPrimitiveField() cannot handle enums.");
            default:
                throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
        }
    }
}
