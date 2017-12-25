package com.google.android.gms.common.data;

import com.google.android.gms.common.data.DataBufferObserver.Observable;
import java.util.HashSet;
import java.util.Iterator;

public final class DataBufferObserverSet implements DataBufferObserver, Observable {
    private HashSet<DataBufferObserver> f10583a = new HashSet();

    public void addObserver(DataBufferObserver dataBufferObserver) {
        this.f10583a.add(dataBufferObserver);
    }

    public void clear() {
        this.f10583a.clear();
    }

    public boolean hasObservers() {
        return !this.f10583a.isEmpty();
    }

    public void onDataChanged() {
        Iterator it = this.f10583a.iterator();
        while (it.hasNext()) {
            ((DataBufferObserver) it.next()).onDataChanged();
        }
    }

    public void onDataRangeChanged(int i, int i2) {
        Iterator it = this.f10583a.iterator();
        while (it.hasNext()) {
            ((DataBufferObserver) it.next()).onDataRangeChanged(i, i2);
        }
    }

    public void onDataRangeInserted(int i, int i2) {
        Iterator it = this.f10583a.iterator();
        while (it.hasNext()) {
            ((DataBufferObserver) it.next()).onDataRangeInserted(i, i2);
        }
    }

    public void onDataRangeMoved(int i, int i2, int i3) {
        Iterator it = this.f10583a.iterator();
        while (it.hasNext()) {
            ((DataBufferObserver) it.next()).onDataRangeMoved(i, i2, i3);
        }
    }

    public void onDataRangeRemoved(int i, int i2) {
        Iterator it = this.f10583a.iterator();
        while (it.hasNext()) {
            ((DataBufferObserver) it.next()).onDataRangeRemoved(i, i2);
        }
    }

    public void removeObserver(DataBufferObserver dataBufferObserver) {
        this.f10583a.remove(dataBufferObserver);
    }
}
