package com.bigroad.ttb.android.adapter;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.constraint.C0025b;
import android.support.constraint.ConstraintLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.bigroad.shared.C0906x;
import com.bigroad.shared.ai;
import com.bigroad.shared.am;
import com.bigroad.shared.validation.C1176p;
import com.bigroad.shared.validation.C1178r;
import com.bigroad.shared.validation.ValidationError.ErrorCode;
import com.bigroad.shared.validation.model.Dvir.Field;
import com.bigroad.ttb.android.C2047k;
import com.bigroad.ttb.android.C2315v;
import com.bigroad.ttb.android.OurApplication;
import com.bigroad.ttb.android.R;
import com.bigroad.ttb.android.SignatureManager;
import com.bigroad.ttb.android.activity.C1632a;
import com.bigroad.ttb.android.activity.DailyLogEditActivity;
import com.bigroad.ttb.android.activity.OurActivity;
import com.bigroad.ttb.android.p039h.C2091e;
import com.bigroad.ttb.android.util.C2292l;
import com.bigroad.ttb.android.util.C2303v;
import com.bigroad.ttb.android.util.ab;
import com.bigroad.ttb.android.util.ac;
import com.bigroad.ttb.android.widget.C1643q;
import com.bigroad.ttb.android.widget.C2464m;
import com.bigroad.ttb.android.widget.TruckInfoView;
import com.bigroad.ttb.protocol.TTProtocol.Dvir;
import com.bigroad.ttb.protocol.TTProtocol.DvirInspection;
import com.bigroad.ttb.protocol.TTProtocol.Truck;
import com.bigroad.ttb.protocol.TTProtocol.TruckLogType;
import com.google.protobuf.C3642c;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.TimeZone;

public abstract class C1402k extends BaseAdapter {
    private static final String f4759a = (C1402k.class.getName() + ".selectedItem");
    private final OurActivity f4760b;
    private final C2315v f4761c;
    private final boolean f4762d;
    private final ArrayList<C1677a> f4763e;
    private final C2047k f4764f;

    public abstract class C1677a implements C1643q {
        final /* synthetic */ C1402k f5821a;

        public abstract View mo1041a(TimeZone timeZone, View view, ViewGroup viewGroup);

        public abstract C3642c mo1042a();

        public abstract C3642c mo1043b();

        public abstract int mo1044c();

        public C1677a(C1402k c1402k) {
            this.f5821a = c1402k;
        }

        public boolean mo1036a(C1643q c1643q) {
            if (this == c1643q) {
                return true;
            }
            if (!(c1643q instanceof C1677a)) {
                return false;
            }
            return mo1042a().equals(((C1677a) c1643q).mo1042a());
        }

        public void mo1035a(Bundle bundle) {
            bundle.putByteArray(C1402k.f4759a, mo1042a().m19091d());
        }

        protected LayoutInflater m8207d() {
            return this.f5821a.f4760b.getLayoutInflater();
        }
    }

    private final class C1678b extends C1677a {
        final /* synthetic */ C1402k f5822b;
        private final Dvir f5823c;
        private final int f5824d;
        private final boolean f5825e;

        public C1678b(C1402k c1402k, Dvir dvir, int i, boolean z) {
            this.f5822b = c1402k;
            super(c1402k);
            this.f5823c = dvir;
            this.f5824d = i;
            this.f5825e = z;
        }

        public Dvir m8212e() {
            return this.f5823c;
        }

        public C3642c mo1042a() {
            return m8212e().getId();
        }

        public C3642c mo1043b() {
            return mo1042a();
        }

        public int mo1044c() {
            return 0;
        }

        public View mo1041a(TimeZone timeZone, View view, ViewGroup viewGroup) {
            int i;
            Resources resources = viewGroup.getResources();
            if (view == null) {
                view = m8207d().inflate(R.layout.dvir_log_item, viewGroup, false);
            }
            TextView textView = (TextView) view.findViewById(R.id.dvirItem_title);
            TextView textView2 = (TextView) view.findViewById(R.id.dvirItem_carrier);
            TextView textView3 = (TextView) view.findViewById(R.id.dvirItem_inspector);
            Button button = (Button) view.findViewById(R.id.dvirItem_editButton);
            if (this.f5824d > 1) {
                textView.setText(resources.getString(R.string.dvirItem_titleMany, new Object[]{Integer.valueOf(this.f5824d)}));
            } else {
                textView.setText(R.string.dvirItem_title);
            }
            String carrierName = this.f5823c.getCarrierName();
            String inspectorName = this.f5823c.getInspectorName();
            ac.m11183a(textView2, carrierName, (int) R.string.dvirHeader_none);
            ac.m11183a(textView3, inspectorName, (int) R.string.dvirHeader_none);
            if (this.f5825e) {
                i = 8;
            } else {
                i = 0;
            }
            button.setVisibility(i);
            if (this.f5822b.mo986b()) {
                C1176p a = this.f5822b.f4761c.m11300a(this.f5823c);
                C2091e.m10479a(a, textView3, Field.INSPECTOR_NAME);
                C2091e.m10479a(a, textView2, Field.CARRIER_NAME);
            }
            return view;
        }
    }

    public final class C1679c extends C1677a {
        final /* synthetic */ C1402k f5826b;
        private final C3642c f5827c;
        private final DvirInspection f5828d;
        private final C2303v f5829e = C2303v.m11258c();
        private final boolean f5830f;

        public C1679c(C1402k c1402k, Dvir dvir, DvirInspection dvirInspection, boolean z) {
            this.f5826b = c1402k;
            super(c1402k);
            this.f5827c = dvir.getId();
            this.f5828d = dvirInspection;
            this.f5830f = z;
        }

        public DvirInspection m8218e() {
            return this.f5828d;
        }

        public C3642c mo1042a() {
            return m8218e().getId();
        }

        public C3642c mo1043b() {
            return this.f5827c;
        }

        public int mo1044c() {
            return 1;
        }

        public View mo1041a(TimeZone timeZone, View view, ViewGroup viewGroup) {
            int i;
            int i2;
            int i3 = 8;
            boolean z = false;
            if (view == null) {
                view = m8207d().inflate(R.layout.dvir_inspection_item, viewGroup, false);
            }
            TextView textView = (TextView) view.findViewById(R.id.inspectionItem_time);
            DateFormat timeFormat = android.text.format.DateFormat.getTimeFormat(view.getContext());
            timeFormat.setTimeZone(timeZone);
            textView.setText(timeFormat.format(Long.valueOf(this.f5828d.getOccurredAt())));
            ((TextView) view.findViewById(R.id.inspectionItem_defects)).setText(this.f5828d.getFoundDefects() ? R.string.inspectionItem_foundDefects : R.string.inspectionItem_noDefects);
            TextView textView2 = (TextView) view.findViewById(R.id.inspectionItem_location);
            if (am.m4188a(this.f5828d.getLocationName())) {
                int i4;
                textView2.setText(R.string.inspectionItem_noLocation);
                if (this.f5826b.mo986b()) {
                    i4 = 0;
                } else {
                    i4 = 8;
                }
                textView2.setVisibility(i4);
            } else {
                textView2.setText(this.f5828d.getLocationName());
            }
            ((TextView) view.findViewById(R.id.inspectionItem_vehicleLabel)).setText(ab.m11167a(this.f5828d.getVehicleType()));
            TruckInfoView truckInfoView = (TruckInfoView) view.findViewById(R.id.inspectionItem_vehicle);
            truckInfoView.m12043a(this.f5826b.f4762d, false, false, false, this.f5828d.getVehicleLicense());
            String vehicleNumber = this.f5828d.getVehicleNumber();
            Truck c = OurApplication.m6294p().m6572c(vehicleNumber);
            if (c == null) {
                truckInfoView.m12041a(vehicleNumber, TruckLogType.ELECTRONIC);
            } else {
                truckInfoView.m12040a(c);
            }
            View findViewById = view.findViewById(R.id.inspectionItem_odometerRow);
            textView = (TextView) view.findViewById(R.id.inspectionItem_odometer);
            textView.setText(this.f5828d.hasOdometer() ? Integer.toString(this.f5828d.getOdometer()) : "");
            if (this.f5828d.hasOdometer()) {
                i = 0;
            } else {
                i = 8;
            }
            findViewById.setVisibility(i);
            TextView textView3 = (TextView) view.findViewById(R.id.inspectionItem_note);
            ac.m11183a(textView3, this.f5828d.getRemarks(), (int) R.string.none);
            if (am.m4188a(this.f5828d.getRemarks())) {
                i2 = 8;
            } else {
                i2 = 0;
            }
            textView3.setVisibility(i2);
            Button button = (Button) view.findViewById(R.id.inspectionItem_editButton);
            if (!this.f5830f) {
                i3 = 0;
            }
            button.setVisibility(i3);
            if (this.f5826b.mo986b()) {
                C1176p a = this.f5826b.f4761c.m11299a(this.f5826b.m7191c(), this.f5828d);
                C2091e.m10479a(a, textView3, com.bigroad.shared.validation.model.DvirInspection.Field.VEHICLE_NUMBER, com.bigroad.shared.validation.model.DvirInspection.Field.VEHICLE_LICENSE);
                C2091e.m10479a(a, textView2, com.bigroad.shared.validation.model.DvirInspection.Field.LOCATION_NAME);
                if (C2091e.m10479a(a, textView, com.bigroad.shared.validation.model.DvirInspection.Field.ODOMETER)) {
                    findViewById.setVisibility(0);
                }
                if (C2091e.m10479a(a, textView3, com.bigroad.shared.validation.model.DvirInspection.Field.REMARKS)) {
                    textView3.setVisibility(0);
                }
            }
            if (findViewById.getVisibility() == 0) {
                z = true;
            }
            m8213a(view, z);
            return view;
        }

        private void m8213a(View view, boolean z) {
            C0025b c0025b = new C0025b();
            ConstraintLayout constraintLayout = (ConstraintLayout) view.findViewById(R.id.inspectionItem_constraintLayout);
            c0025b.m113a(constraintLayout);
            c0025b.m110a((int) R.id.inspectionItem_locationContainer, 2);
            if (z) {
                c0025b.m111a(R.id.inspectionItem_locationContainer, 2, 0, 2);
            } else {
                c0025b.m111a(R.id.inspectionItem_locationContainer, 2, R.id.inspectionItem_editButton, 1);
            }
            c0025b.m115b(constraintLayout);
        }
    }

    private final class C1680d extends C1677a {
        final /* synthetic */ C1402k f5831b;
        private final Dvir f5832c;
        private final boolean f5833d;

        public C1680d(C1402k c1402k, Dvir dvir, boolean z) {
            this.f5831b = c1402k;
            super(c1402k);
            this.f5832c = dvir;
            this.f5833d = z;
        }

        public C3642c mo1042a() {
            return C3642c.f13210a;
        }

        public C3642c mo1043b() {
            return this.f5832c.getId();
        }

        public boolean mo1036a(C1643q c1643q) {
            return false;
        }

        public void mo1035a(Bundle bundle) {
        }

        public int mo1044c() {
            return 3;
        }

        public View mo1041a(TimeZone timeZone, View view, ViewGroup viewGroup) {
            if (view == null) {
                view = m8207d().inflate(R.layout.dvir_approved, viewGroup, false);
            }
            TextView textView = (TextView) view.findViewById(R.id.dvirApproved_signatureNotAvailableIndicator);
            TextView textView2 = (TextView) view.findViewById(R.id.dvirApproved_approvalIndicator);
            if (!this.f5831b.f4762d) {
                ac.m11176a(this.f5831b.f4760b, textView2);
            }
            ImageView imageView = (ImageView) view.findViewById(R.id.dvirApproved_signatureImageView);
            if (this.f5833d) {
                imageView.setColorFilter(SignatureManager.f4157a);
            }
            textView2.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
            textView.setVisibility(8);
            imageView.setVisibility(8);
            if (C2292l.m11234b(this.f5832c)) {
                Bitmap b = SignatureManager.m6336b(C2292l.m11236c(this.f5832c));
                if (b != null) {
                    imageView.setImageBitmap(b);
                    imageView.setVisibility(0);
                } else {
                    textView.setVisibility(0);
                }
            } else {
                textView2.setCompoundDrawablesWithIntrinsicBounds(this.f5831b.f4760b.m6714c(5), 0, 0, 0);
            }
            return view;
        }
    }

    private final class C1682e extends C1677a {
        final /* synthetic */ C1402k f5836b;
        private final Dvir f5837c;

        public C1682e(C1402k c1402k, Dvir dvir) {
            this.f5836b = c1402k;
            super(c1402k);
            this.f5837c = dvir;
        }

        public C3642c mo1042a() {
            return C3642c.f13210a;
        }

        public C3642c mo1043b() {
            return this.f5837c.getId();
        }

        public boolean mo1036a(C1643q c1643q) {
            return false;
        }

        public void mo1035a(Bundle bundle) {
        }

        public int mo1044c() {
            return 2;
        }

        public View mo1041a(TimeZone timeZone, View view, ViewGroup viewGroup) {
            final boolean a = C2292l.m11232a(this.f5837c);
            OnClickListener c16811 = new OnClickListener(this) {
                final /* synthetic */ C1682e f5835b;

                public void onClick(View view) {
                    if (!(this.f5835b.f5836b.f4760b instanceof DailyLogEditActivity)) {
                        return;
                    }
                    if (a) {
                        this.f5835b.f5836b.f4764f.mo1199c(this.f5835b.f5837c.getId().m19091d());
                    } else {
                        C1632a.m7935a(this.f5835b.f5836b.f4760b, this.f5835b.f5837c.getId(), this.f5835b.f5837c.getLogDay());
                    }
                }
            };
            if (view == null) {
                return C2464m.m12117a(viewGroup.getContext(), R.string.dailyLogHeader_newInspection, c16811);
            }
            view.setOnClickListener(c16811);
            return view;
        }
    }

    private final class C1684f extends C1677a {
        final /* synthetic */ C1402k f5840b;
        private final Dvir f5841c;

        public C1684f(C1402k c1402k, Dvir dvir) {
            this.f5840b = c1402k;
            super(c1402k);
            this.f5841c = dvir;
        }

        public C3642c mo1042a() {
            return C3642c.f13210a;
        }

        public C3642c mo1043b() {
            return this.f5841c.getId();
        }

        public boolean mo1036a(C1643q c1643q) {
            return false;
        }

        public void mo1035a(Bundle bundle) {
        }

        public int mo1044c() {
            return 4;
        }

        public View mo1041a(TimeZone timeZone, View view, ViewGroup viewGroup) {
            View a;
            final boolean a2 = C2292l.m11232a(this.f5841c);
            int i = a2 ? R.string.dailyLog_editInspection : R.string.dailyLog_approveInspection;
            OnClickListener c16831 = new OnClickListener(this) {
                final /* synthetic */ C1684f f5839b;

                public void onClick(View view) {
                    if (!(this.f5839b.f5840b.f4760b instanceof DailyLogEditActivity)) {
                        return;
                    }
                    if (a2) {
                        this.f5839b.f5840b.f4764f.mo1196b(this.f5839b.f5841c.getId().m19091d());
                    } else {
                        this.f5839b.f5840b.f4764f.mo1195a(this.f5839b.f5841c.getId().m19091d());
                    }
                }
            };
            if (view == null) {
                a = C2464m.m12117a(viewGroup.getContext(), i, c16831);
                ((TextView) a).setCompoundDrawablePadding(Math.round(this.f5840b.f4760b.getResources().getDimension(R.dimen.widget_spacing)));
            } else {
                view.setOnClickListener(c16831);
                ((TextView) view).setText(i);
                a = view;
            }
            TextView textView = (TextView) a;
            if (a2) {
                textView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
            } else {
                textView.setCompoundDrawablesWithIntrinsicBounds(C2091e.m10475a(C1178r.m5972a(this.f5840b.f4761c.m11300a(this.f5841c), ErrorCode.DVIR_NOT_SIGNED)), 0, 0, 0);
            }
            return a;
        }
    }

    protected abstract TimeZone mo985a();

    public abstract boolean mo986b();

    public /* synthetic */ Object getItem(int i) {
        return m7185a(i);
    }

    public <ACTIVITY extends OurActivity & C0906x> C1402k(ACTIVITY activity, C2047k c2047k) {
        this(activity, false, c2047k);
    }

    public <ACTIVITY extends OurActivity & C0906x> C1402k(ACTIVITY activity, boolean z, C2047k c2047k) {
        this.f4763e = new ArrayList();
        this.f4760b = activity;
        this.f4762d = z;
        this.f4761c = OurApplication.m6298t();
        this.f4764f = c2047k;
    }

    public int m7191c() {
        return ((C0906x) this.f4760b).a_();
    }

    public C1677a m7187a(C3642c c3642c) {
        if (c3642c == null) {
            return null;
        }
        Iterator it = this.f4763e.iterator();
        while (it.hasNext()) {
            C1677a c1677a = (C1677a) it.next();
            if (c3642c.equals(c1677a.mo1042a())) {
                return c1677a;
            }
        }
        return null;
    }

    public C1677a m7186a(Bundle bundle) {
        if (bundle.containsKey(f4759a)) {
            return m7187a(ai.m4175a(bundle.getByteArray(f4759a)));
        }
        return null;
    }

    public void m7189a(List<Dvir> list, boolean z, boolean z2) {
        this.f4763e.clear();
        int i = 1;
        for (Dvir dvir : list) {
            boolean a = C2292l.m11232a(dvir);
            ArrayList arrayList = this.f4763e;
            boolean z3 = z || a;
            arrayList.add(new C1678b(this, dvir, i, z3));
            for (DvirInspection c1679c : dvir.getInspectionList()) {
                this.f4763e.add(new C1679c(this, dvir, c1679c, z));
            }
            if (a) {
                this.f4763e.add(new C1680d(this, dvir, z2));
            }
            if (!z) {
                this.f4763e.add(new C1682e(this, dvir));
                this.f4763e.add(new C1684f(this, dvir));
            }
            i++;
        }
        notifyDataSetChanged();
    }

    public int getCount() {
        return this.f4763e.size();
    }

    public C1677a m7185a(int i) {
        if (i < 0 || i >= getCount()) {
            return null;
        }
        return (C1677a) this.f4763e.get(i);
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public int getItemViewType(int i) {
        if (i < 0 || i >= this.f4763e.size()) {
            return 0;
        }
        return ((C1677a) this.f4763e.get(i)).mo1044c();
    }

    public int getViewTypeCount() {
        return 5;
    }

    public boolean areAllItemsEnabled() {
        return true;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        return m7185a(i).mo1041a(mo985a(), view, viewGroup);
    }
}
