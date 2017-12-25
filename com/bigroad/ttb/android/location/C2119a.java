package com.bigroad.ttb.android.location;

import android.content.Context;
import com.bigroad.shared.LRUCache;
import com.bigroad.ttb.android.OurApplication;
import com.bigroad.ttb.android.SyncManager;
import com.bigroad.ttb.android.SyncManager.C1238b;
import com.bigroad.ttb.android.logging.C2134e;
import com.bigroad.ttb.protocol.TTProtocol.Geocode;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class C2119a {
    private static C2119a f7407a;
    private final SyncManager f7408b = OurApplication.m6289k();
    private final Set<C1285a> f7409c = new HashSet();
    private final LRUCache<ApproximateLocation, Geocode> f7410d = new LRUCache(500);
    private final Set<ApproximateLocation> f7411e = new HashSet();
    private boolean f7412f = false;
    private final C1238b f7413g = new C21181(this);

    public interface C1285a {
        void mo936a(C2119a c2119a);
    }

    class C21181 implements C1238b {
        final /* synthetic */ C2119a f7406a;

        C21181(C2119a c2119a) {
            this.f7406a = c2119a;
        }

        public void mo1045a() {
            this.f7406a.m10612b();
        }

        public void mo1046b() {
        }
    }

    public static C2119a m10609a(Context context) {
        if (f7407a == null) {
            f7407a = new C2119a();
        }
        return f7407a;
    }

    private C2119a() {
        this.f7408b.m6461a(this.f7413g);
    }

    public void m10616a(C1285a c1285a) {
        this.f7409c.add(c1285a);
    }

    public void m10618b(C1285a c1285a) {
        this.f7409c.remove(c1285a);
    }

    private void m10610a() {
        for (C1285a a : (C1285a[]) this.f7409c.toArray(new C1285a[this.f7409c.size()])) {
            a.mo936a(this);
        }
    }

    private void m10612b() {
        if (!this.f7411e.isEmpty() && !this.f7408b.m6498c() && this.f7412f) {
            this.f7412f = false;
            List arrayList = new ArrayList(this.f7411e.size());
            for (Location a : this.f7411e) {
                arrayList.add(a.m10554a());
            }
            this.f7408b.m6487a(arrayList);
        }
    }

    public void m10617a(List<Geocode> list) {
        for (Geocode geocode : list) {
            C2134e.m10678c("TT-Geocoder", "Geocode for " + geocode.getLatlon().getLatitudeE6() + "," + geocode.getLatlon().getLongitudeE6() + ": " + geocode.getCity() + ", " + geocode.getState());
            ApproximateLocation approximateLocation = new ApproximateLocation(geocode.getLatlon());
            this.f7410d.put(approximateLocation, geocode);
            this.f7411e.remove(approximateLocation);
        }
        m10610a();
        m10612b();
    }

    public Geocode m10615a(Location location) {
        return m10613a(location.m10555b(), location.m10556c());
    }

    public Geocode m10613a(int i, int i2) {
        return m10614a(new ApproximateLocation(i, i2));
    }

    public Geocode m10614a(ApproximateLocation approximateLocation) {
        if (approximateLocation == null) {
            return null;
        }
        Geocode geocode = (Geocode) this.f7410d.get(approximateLocation);
        if (geocode != null) {
            return geocode;
        }
        this.f7411e.add(approximateLocation);
        this.f7412f = true;
        m10612b();
        return geocode;
    }
}
