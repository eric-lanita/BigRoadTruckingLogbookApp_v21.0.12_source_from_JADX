package com.google.common.collect;

import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class ArrayListMultimap<K, V> extends ArrayListMultimapGwtSerializationDependencies<K, V> {
    private static final long serialVersionUID = 0;
    transient int f12971a = 3;

    public /* bridge */ /* synthetic */ List mo2628a(Object obj) {
        return super.mo2628a(obj);
    }

    @CanIgnoreReturnValue
    public /* bridge */ /* synthetic */ boolean mo2614a(Object obj, Object obj2) {
        return super.mo2614a(obj, obj2);
    }

    public /* bridge */ /* synthetic */ Map mo2615b() {
        return super.mo2615b();
    }

    public /* bridge */ /* synthetic */ boolean mo2616b(Object obj, Object obj2) {
        return super.mo2616b(obj, obj2);
    }

    /* synthetic */ Collection mo2629c() {
        return mo2655a();
    }

    @CanIgnoreReturnValue
    public /* bridge */ /* synthetic */ boolean mo2617c(Object obj, Object obj2) {
        return super.mo2617c(obj, obj2);
    }

    public /* bridge */ /* synthetic */ boolean mo2656d(Object obj) {
        return super.mo2656d(obj);
    }

    public /* bridge */ /* synthetic */ int mo2622e() {
        return super.mo2622e();
    }

    public /* bridge */ /* synthetic */ boolean equals(Object obj) {
        return super.equals(obj);
    }

    public /* bridge */ /* synthetic */ void mo2623f() {
        super.mo2623f();
    }

    public /* bridge */ /* synthetic */ Collection mo2618h() {
        return super.mo2618h();
    }

    public /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    public /* bridge */ /* synthetic */ Collection mo2619j() {
        return super.mo2619j();
    }

    public /* bridge */ /* synthetic */ boolean mo2620m() {
        return super.mo2620m();
    }

    public /* bridge */ /* synthetic */ Set mo2658o() {
        return super.mo2658o();
    }

    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    public static <K, V> ArrayListMultimap<K, V> m18434q() {
        return new ArrayListMultimap();
    }

    private ArrayListMultimap() {
        super(new HashMap());
    }

    List<V> mo2655a() {
        return new ArrayList(this.f12971a);
    }

    private void writeObject(ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        C3604v.m18823a(this, objectOutputStream);
    }

    private void readObject(ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        this.f12971a = 3;
        int a = C3604v.m18821a(objectInputStream);
        m18356a(Maps.m18663c());
        C3604v.m18822a(this, objectInputStream, a);
    }
}
