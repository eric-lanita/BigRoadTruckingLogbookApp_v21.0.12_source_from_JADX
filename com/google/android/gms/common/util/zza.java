package com.google.android.gms.common.util;

import android.support.v4.p008d.C0270a;
import java.util.AbstractSet;
import java.util.Collection;
import java.util.Iterator;

public class zza<E> extends AbstractSet<E> {
    private final C0270a<E, E> f10892a;

    public zza() {
        this.f10892a = new C0270a();
    }

    public zza(int i) {
        this.f10892a = new C0270a(i);
    }

    public zza(Collection<E> collection) {
        this(collection.size());
        addAll(collection);
    }

    public boolean add(E e) {
        if (this.f10892a.containsKey(e)) {
            return false;
        }
        this.f10892a.put(e, e);
        return true;
    }

    public boolean addAll(Collection<? extends E> collection) {
        return collection instanceof zza ? zza((zza) collection) : super.addAll(collection);
    }

    public void clear() {
        this.f10892a.clear();
    }

    public boolean contains(Object obj) {
        return this.f10892a.containsKey(obj);
    }

    public Iterator<E> iterator() {
        return this.f10892a.keySet().iterator();
    }

    public boolean remove(Object obj) {
        if (!this.f10892a.containsKey(obj)) {
            return false;
        }
        this.f10892a.remove(obj);
        return true;
    }

    public int size() {
        return this.f10892a.size();
    }

    public boolean zza(zza<? extends E> com_google_android_gms_common_util_zza__extends_E) {
        int size = size();
        this.f10892a.m1147a(com_google_android_gms_common_util_zza__extends_E.f10892a);
        return size() > size;
    }
}
