package com.bigroad.ttb.android.widget;

import android.location.Location;
import android.os.Bundle;
import android.support.v4.app.C0202r;
import android.support.v4.app.Fragment;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.Spinner;
import com.bigroad.ttb.android.C2474y;
import com.bigroad.ttb.android.C2474y.C1183b;
import com.bigroad.ttb.android.OurApplication;
import com.bigroad.ttb.android.R;
import com.bigroad.ttb.android.location.LocationTracker;
import com.bigroad.ttb.android.location.LocationTracker.C1191c;
import com.bigroad.ttb.android.location.LocationTracker.C1192d;
import com.bigroad.ttb.android.logging.C2134e;
import com.bigroad.ttb.android.maps.C2158c;
import com.bigroad.ttb.android.maps.C2166a;
import com.bigroad.ttb.android.maps.C2167b;
import com.bigroad.ttb.android.maps.C2168d;
import com.bigroad.ttb.android.maps.C2170e;
import com.bigroad.ttb.android.maps.C2170e.C2169a;
import com.bigroad.ttb.android.maps.MapTechnology;
import com.bigroad.ttb.android.maps.MapType;
import com.bigroad.ttb.android.maps.NativeMapFragment;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.UiSettings;
import com.google.android.gms.maps.model.LatLng;
import java.util.LinkedList;
import java.util.Queue;

public class DashboardMapFragment extends Fragment implements C2167b {
    private final C1183b f8514a = new C24151(this);
    private FrameLayout f8515b;
    private View f8516c;
    private C2166a f8517d;
    private Spinner f8518e;
    private C2168d f8519f;
    private Button f8520g;
    private MapType f8521h;
    private C2169a f8522i;
    private C2474y f8523j;
    private LocationTracker f8524k;
    private boolean f8525l = false;
    private Queue<Location> f8526m = new LinkedList();
    private C2422a f8527n = new C2422a();
    private boolean f8528o;
    private final C1191c f8529p = new C24206(this);

    class C24151 extends C1183b {
        final /* synthetic */ DashboardMapFragment f8504a;

        C24151(DashboardMapFragment dashboardMapFragment) {
            this.f8504a = dashboardMapFragment;
        }

        public void mo865b(C2474y c2474y) {
            this.f8504a.m11896a(this.f8504a.f8521h);
        }
    }

    class C24162 implements OnItemSelectedListener {
        final /* synthetic */ DashboardMapFragment f8505a;

        C24162(DashboardMapFragment dashboardMapFragment) {
            this.f8505a = dashboardMapFragment;
        }

        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
            this.f8505a.m11896a((MapType) adapterView.getItemAtPosition(i));
        }

        public void onNothingSelected(AdapterView<?> adapterView) {
        }
    }

    class C24173 implements OnClickListener {
        final /* synthetic */ DashboardMapFragment f8506a;

        C24173(DashboardMapFragment dashboardMapFragment) {
            this.f8506a = dashboardMapFragment;
        }

        public void onClick(View view) {
            C2158c b = this.f8506a.m11904f();
            if (b != null) {
                b.mo1250a(this.f8506a.f8524k.m10603c());
            }
        }
    }

    class C24184 implements OnClickListener {
        final /* synthetic */ DashboardMapFragment f8507a;

        C24184(DashboardMapFragment dashboardMapFragment) {
            this.f8507a = dashboardMapFragment;
        }

        public void onClick(View view) {
            C2158c b = this.f8507a.m11904f();
            if (b != null) {
                b.mo1249a();
            }
        }
    }

    class C24195 implements OnClickListener {
        final /* synthetic */ DashboardMapFragment f8508a;

        C24195(DashboardMapFragment dashboardMapFragment) {
            this.f8508a = dashboardMapFragment;
        }

        public void onClick(View view) {
            C2158c b = this.f8508a.m11904f();
            if (b != null) {
                b.mo1253b();
            }
        }
    }

    class C24206 extends C1192d {
        final /* synthetic */ DashboardMapFragment f8509a;

        C24206(DashboardMapFragment dashboardMapFragment) {
            this.f8509a = dashboardMapFragment;
        }

        public void mo881b(Location location) {
            this.f8509a.m11895a(location, false);
        }
    }

    private static final class C2422a {
        private Location f8512a;
        private float f8513b;

        private C2422a() {
        }

        public boolean m11892a(Location location, float f) {
            if (this.f8512a != null && this.f8512a.distanceTo(location) < 1.0f && Math.abs(this.f8512a.getAccuracy() - location.getAccuracy()) < 1.0f && Math.abs(this.f8512a.getSpeed() - location.getSpeed()) < 1.0f && Math.abs(this.f8513b - f) < 1.0f) {
                return false;
            }
            return true;
        }

        public void m11893b(Location location, float f) {
            this.f8512a = location;
            this.f8513b = f;
        }
    }

    public DashboardMapFragment() {
        setRetainInstance(true);
        this.f8523j = OurApplication.m6285g();
        this.f8524k = OurApplication.m6302x();
    }

    private C2158c m11904f() {
        if (this.f8517d != null) {
            return this.f8517d;
        }
        return m11906h();
    }

    public void onResume() {
        super.onResume();
        m11905g();
        C2158c f = m11904f();
        if (f != null) {
            f.setViewTarget(this.f8522i);
        }
        this.f8523j.m12184a(this.f8514a);
    }

    public void onPause() {
        this.f8523j.m12194b(this.f8514a);
        C2158c f = m11904f();
        if (f != null) {
            this.f8522i = f.getViewTarget();
        }
        super.onPause();
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.cloneInContext(new ContextThemeWrapper(getActivity(), R.style.OurMapTheme)).inflate(R.layout.dashboard_map_fragment, viewGroup, false);
        this.f8515b = (FrameLayout) inflate.findViewById(R.id.dashboard_mapFragmentContainer);
        this.f8516c = inflate.findViewById(R.id.dashboard_mapControls);
        this.f8518e = (Spinner) inflate.findViewById(R.id.dashboard_mapTypeSpinner);
        this.f8519f = new C2168d(getActivity());
        this.f8518e.setAdapter(this.f8519f);
        this.f8518e.setOnItemSelectedListener(new C24162(this));
        this.f8520g = (Button) inflate.findViewById(R.id.dashboard_homeButton);
        this.f8520g.setOnClickListener(new C24173(this));
        ((Button) inflate.findViewById(R.id.dashboard_zoomIn)).setOnClickListener(new C24184(this));
        ((Button) inflate.findViewById(R.id.dashboard_zoomOut)).setOnClickListener(new C24195(this));
        m11905g();
        this.f8528o = true;
        return inflate;
    }

    public boolean m11918c() {
        return this.f8528o;
    }

    public void onDestroyView() {
        this.f8515b.removeAllViews();
        super.onDestroyView();
    }

    private void m11905g() {
        m11912n();
        m11896a(this.f8521h);
    }

    private void m11896a(MapType mapType) {
        MapTechnology x = this.f8523j.m12234x();
        this.f8521h = mapType;
        m11899a(this.f8521h.m10744c());
        C2158c f = m11904f();
        if (f != null) {
            this.f8522i = f.getViewTarget();
        }
        if (this.f8521h.m10745d() > 0) {
            if (x.m10740a()) {
                m11907i();
            } else if (x.m10741b()) {
                m11908j();
            } else {
                m11909k();
            }
        } else if (x.m10741b()) {
            m11908j();
        } else {
            m11909k();
        }
        C2158c f2 = m11904f();
        if (f2 != null) {
            f2.mo1252a(mapType);
        }
        m11903d(true);
    }

    private NativeMapFragment m11906h() {
        return (NativeMapFragment) getChildFragmentManager().mo148a(this.f8515b.getId());
    }

    private void m11907i() {
        if (this.f8523j.m12234x().m10740a()) {
            C2134e.m10678c("TT-DashMapFrag", "Switching to native map technology.");
            m11910l();
            Fragment h = m11906h();
            if (h == null) {
                h = new NativeMapFragment();
                this.f8516c.setVisibility(4);
            }
            if (!h.isAdded()) {
                C0202r childFragmentManager = getChildFragmentManager();
                childFragmentManager.mo150a().mo139a(this.f8515b.getId(), h).mo138a();
                childFragmentManager.mo154b();
            }
        }
    }

    private void m11908j() {
        if (this.f8523j.m12234x().m10741b()) {
            C2134e.m10678c("TT-DashMapFrag", "Switching to web map technology.");
            m11911m();
            if (this.f8517d == null) {
                this.f8517d = new C2166a(getActivity());
                this.f8517d.setMapReadyCallback(this);
                this.f8517d.m10765e();
            }
            if (this.f8515b.getChildCount() == 0) {
                this.f8515b.addView(this.f8517d);
            }
        }
    }

    private void m11909k() {
        C2134e.m10678c("TT-DashMapFrag", "Switching to no map technology.");
        m11910l();
        m11911m();
    }

    private void m11910l() {
        if (this.f8517d != null) {
            this.f8515b.removeView(this.f8517d);
            this.f8517d = null;
        }
    }

    private void m11911m() {
        Fragment h = m11906h();
        if (h != null && h.isAdded()) {
            C0202r childFragmentManager = getChildFragmentManager();
            childFragmentManager.mo150a().mo141a(h).mo138a();
            childFragmentManager.mo154b();
        }
    }

    public void mo1331a() {
        m11903d(true);
    }

    public void mo1333b() {
        NativeMapFragment h = m11906h();
        if (h != null) {
            GoogleMap c = h.m10761c();
            if (c != null) {
                this.f8516c.setVisibility(0);
                c.setTrafficEnabled(true);
                c.setMapType(this.f8521h.m10745d());
                UiSettings uiSettings = c.getUiSettings();
                uiSettings.setTiltGesturesEnabled(false);
                uiSettings.setRotateGesturesEnabled(false);
                uiSettings.setCompassEnabled(false);
                uiSettings.setZoomControlsEnabled(false);
                uiSettings.setMyLocationButtonEnabled(false);
                Location c2 = this.f8524k.m10603c();
                if (c2 != null) {
                    c.moveCamera(CameraUpdateFactory.newLatLngZoom(C2170e.m10785a(c2), 12.0f));
                }
            }
        } else {
            this.f8516c.setVisibility(0);
        }
        C2158c f = m11904f();
        if (f != null) {
            f.setViewTarget(this.f8522i);
        }
    }

    public void mo1332a(boolean z) {
        this.f8520g.setVisibility(z ? 0 : 4);
    }

    private void m11912n() {
        String w = this.f8523j.m12233w();
        for (MapType mapType : MapType.values()) {
            if (mapType.m10744c().equals(w)) {
                this.f8521h = mapType;
                this.f8518e.setSelection(this.f8519f.m10777a(mapType));
                return;
            }
        }
        this.f8521h = MapType.MAP;
        this.f8518e.setSelection(this.f8519f.m10777a(this.f8521h));
    }

    private void m11899a(String str) {
        if (!this.f8523j.m12233w().equals(str)) {
            this.f8523j.m12200c(str);
            OurApplication.m6282d().m8301c(str);
        }
    }

    private void m11902c(boolean z) {
        if (this.f8525l != z) {
            if (z) {
                this.f8524k.m10599a(this.f8529p);
            } else {
                this.f8524k.m10602b(this.f8529p);
            }
            this.f8524k.m10600a((Object) this, z);
            this.f8525l = z;
        }
    }

    public void m11919d() {
        m11917b(false);
    }

    public void m11917b(boolean z) {
        m11915a(z, this.f8524k.m10603c());
    }

    public void m11915a(boolean z, Location location) {
        m11902c(true);
        C2158c f = m11904f();
        if (f != null && location != null) {
            if (z) {
                final LatLng a = C2170e.m10785a(location);
                NativeMapFragment h = m11906h();
                if (h != null) {
                    h.getMapAsync(new OnMapReadyCallback(this) {
                        final /* synthetic */ DashboardMapFragment f8511b;

                        public void onMapReady(GoogleMap googleMap) {
                            googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(a, 12.0f));
                        }
                    });
                    return;
                } else {
                    f.setViewTarget(new C2169a(a, 12.0f));
                    return;
                }
            }
            f.mo1250a(this.f8524k.m10603c());
        }
    }

    public void m11920e() {
        m11902c(false);
    }

    private void m11903d(boolean z) {
        m11895a(this.f8524k.m10603c(), z);
    }

    private void m11895a(Location location, boolean z) {
        if (location == null) {
            return;
        }
        if (this.f8517d == null || this.f8517d.m10763c()) {
            this.f8526m.offer(location);
            if (this.f8526m.size() > 5) {
                this.f8526m.poll();
            }
            float bearingTo = ((Location) this.f8526m.peek()).bearingTo(location);
            if (z || this.f8527n.m11892a(location, bearingTo)) {
                this.f8527n.m11893b(location, bearingTo);
                C2158c f = m11904f();
                if (f != null) {
                    f.mo1251a(location, bearingTo);
                }
            }
        }
    }
}
