package com.bigroad.ttb.android.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.bigroad.shared.C1179w;
import com.bigroad.shared.am;
import com.bigroad.shared.model.C1127k;
import com.bigroad.shared.validation.ValidationError;
import com.bigroad.ttb.android.OurApplication;
import com.bigroad.ttb.android.R;
import com.bigroad.ttb.android.activity.OurActivity;
import com.bigroad.ttb.android.location.C2119a;
import com.bigroad.ttb.android.location.C2119a.C1285a;
import com.bigroad.ttb.android.location.Location;
import com.bigroad.ttb.android.logging.C2134e;
import com.bigroad.ttb.android.p039h.C2091e;
import com.bigroad.ttb.android.util.ac;
import com.bigroad.ttb.protocol.TTProtocol.Geocode;
import com.bigroad.ttb.protocol.TTProtocol.RelativeLocation;
import com.google.protobuf.InvalidProtocolBufferException;
import java.util.List;

public class LocationLookupEditText extends Fragment {
    private static final String f7199a = (LocationLookupEditText.class.getName() + ".latlng");
    private static final String f7200b = (LocationLookupEditText.class.getName() + ".useLatlng");
    private static final String f7201c = (LocationLookupEditText.class.getName() + ".addingEldEvent");
    private static final String f7202d = (LocationLookupEditText.class.getName() + ".relativeLocation");
    private EditText f7203e;
    private ImageView f7204f;
    private TextView f7205g;
    private Location f7206h;
    private boolean f7207i;
    private boolean f7208j;
    private boolean f7209k;
    private RelativeLocation f7210l;
    private final C1285a f7211m = new C20581(this);
    private final TextWatcher f7212n = new C20592(this);

    public interface C1356a {
        void mo958H();
    }

    class C20581 implements C1285a {
        final /* synthetic */ LocationLookupEditText f7197a;

        C20581(LocationLookupEditText locationLookupEditText) {
            this.f7197a = locationLookupEditText;
        }

        public void mo936a(C2119a c2119a) {
            this.f7197a.m10360a(c2119a, c2119a.m10615a(this.f7197a.f7206h));
        }
    }

    class C20592 implements TextWatcher {
        final /* synthetic */ LocationLookupEditText f7198a;

        C20592(LocationLookupEditText locationLookupEditText) {
            this.f7198a = locationLookupEditText;
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            this.f7198a.f7207i = false;
            this.f7198a.f7208j = false;
            if (this.f7198a.getActivity() instanceof C1356a) {
                ((C1356a) this.f7198a.getActivity()).mo958H();
            }
        }

        public void afterTextChanged(Editable editable) {
        }
    }

    private void m10360a(C2119a c2119a, Geocode geocode) {
        if (geocode != null) {
            c2119a.m10618b(this.f7211m);
        }
        if (!this.f7207i) {
            return;
        }
        if (geocode == null) {
            this.f7203e.setHint(R.string.locationLookupFragment_lookingUp);
            return;
        }
        this.f7208j = true;
        CharSequence a = C1179w.m5986a(geocode);
        if (this.f7209k) {
            if (geocode.hasRelativeLocation()) {
                a = C1127k.m5706a(geocode.getRelativeLocation());
                this.f7210l = geocode.getRelativeLocation();
            } else {
                this.f7208j = false;
                this.f7203e.setEnabled(true);
            }
        }
        if (am.m4188a(a)) {
            a = "Unknown location";
        }
        this.f7203e.setHint(R.string.locationLookupFragment_noLocation);
        ac.m11179a(this.f7203e, a);
        this.f7207i = false;
    }

    public static RelativeLocation m10355a(OurActivity ourActivity, int i) {
        LocationLookupEditText locationLookupEditText = (LocationLookupEditText) ourActivity.getSupportFragmentManager().mo148a(i);
        if (locationLookupEditText != null) {
            return locationLookupEditText.f7210l;
        }
        C2134e.m10682e("TT-LocationLookupEditText", "Unable to get relative location from LocationLookupEditText fragment");
        return null;
    }

    public static Location m10362b(OurActivity ourActivity, int i) {
        LocationLookupEditText locationLookupEditText = (LocationLookupEditText) ourActivity.getSupportFragmentManager().mo148a(i);
        if (locationLookupEditText != null) {
            return locationLookupEditText.f7206h;
        }
        C2134e.m10682e("TT-LocationLookupEditText", "Unable to get geocoder location from LocationLookupEditText fragment");
        return null;
    }

    public static boolean m10364c(OurActivity ourActivity, int i) {
        LocationLookupEditText locationLookupEditText = (LocationLookupEditText) ourActivity.getSupportFragmentManager().mo148a(i);
        if (locationLookupEditText == null) {
            C2134e.m10682e("TT-LocationLookupEditText", "Unable to focus location view from LocationLookupEditText fragment");
        } else if (locationLookupEditText.f7203e.length() == 0) {
            locationLookupEditText.f7203e.requestFocus();
            return true;
        }
        return false;
    }

    public static String m10365d(OurActivity ourActivity, int i) {
        LocationLookupEditText locationLookupEditText = (LocationLookupEditText) ourActivity.getSupportFragmentManager().mo148a(i);
        if (locationLookupEditText != null) {
            return locationLookupEditText.m10367a();
        }
        C2134e.m10682e("TT-LocationLookupEditText", "Unable to get text from LocationLookupEditText fragment");
        return null;
    }

    protected String m10367a() {
        if (this.f7203e != null) {
            return this.f7203e.getText().toString().trim();
        }
        return null;
    }

    public static void m10357a(OurActivity ourActivity, int i, String str, boolean z) {
        LocationLookupEditText locationLookupEditText = (LocationLookupEditText) ourActivity.getSupportFragmentManager().mo148a(i);
        if (locationLookupEditText != null) {
            locationLookupEditText.m10368a(str, z);
        } else {
            C2134e.m10682e("TT-LocationLookupEditText", "Unable to set text for LocationLookupEditText fragment");
        }
    }

    protected void m10368a(String str, boolean z) {
        if (str != null && this.f7203e != null) {
            ac.m11179a(this.f7203e, (CharSequence) str);
            this.f7207i = false;
            this.f7208j = z;
        }
    }

    public boolean m10370b() {
        return this.f7208j;
    }

    public static boolean m10366e(OurActivity ourActivity, int i) {
        LocationLookupEditText locationLookupEditText = (LocationLookupEditText) ourActivity.getSupportFragmentManager().mo148a(i);
        if (locationLookupEditText != null) {
            return locationLookupEditText.m10370b();
        }
        C2134e.m10682e("TT-LocationLookupEditText", "Unable to get reverse geocode status from LocationLookupEditText fragment");
        return false;
    }

    public static void m10358a(OurActivity ourActivity, int i, List<ValidationError> list) {
        LocationLookupEditText locationLookupEditText = (LocationLookupEditText) ourActivity.getSupportFragmentManager().mo148a(i);
        if (locationLookupEditText != null) {
            locationLookupEditText.m10369a((List) list, (Context) ourActivity);
        } else {
            C2134e.m10682e("TT-LocationLookupEditText", "Unable to show validation errors for LocationLookupEditText fragment");
        }
    }

    protected void m10369a(List<ValidationError> list, Context context) {
        if (this.f7207i) {
            list = null;
        }
        C2091e.m10477a(list, this.f7204f, this.f7205g, context);
    }

    private RelativeLocation m10356a(byte[] bArr) {
        RelativeLocation relativeLocation = null;
        if (bArr != null) {
            try {
                relativeLocation = RelativeLocation.parseFrom(bArr);
            } catch (InvalidProtocolBufferException e) {
            }
        }
        return relativeLocation;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.location_lookup, viewGroup, false);
        this.f7203e = (EditText) inflate.findViewById(R.id.locationLookup_location);
        this.f7204f = (ImageView) inflate.findViewById(R.id.locationLookup_locationError);
        this.f7205g = (TextView) inflate.findViewById(R.id.locationLookup_locationErrorText);
        if (bundle != null) {
            this.f7207i = bundle.getBoolean(f7200b);
            this.f7206h = (Location) bundle.getParcelable(f7199a);
            this.f7209k = bundle.getBoolean(f7201c);
            this.f7210l = m10356a(bundle.getByteArray(f7202d));
        } else {
            Intent intent = getActivity().getIntent();
            this.f7207i = intent.getBooleanExtra("com.bigroad.ttb.useCurrentLoc", false);
            this.f7209k = intent.getBooleanExtra("com.bigroad.ttb.addingEldEvent", false);
        }
        if (this.f7209k) {
            this.f7203e.setEnabled(false);
        }
        C2119a m = OurApplication.m6291m();
        if (this.f7207i && this.f7206h == null) {
            android.location.Location d = OurApplication.m6302x().m10604d();
            if (d == null) {
                this.f7207i = false;
                this.f7206h = null;
            } else {
                this.f7206h = new Location(d);
            }
        }
        if (this.f7207i && this.f7206h != null) {
            m.m10616a(this.f7211m);
            m10360a(m, m.m10615a(this.f7206h));
        }
        return inflate;
    }

    public void onStart() {
        super.onStart();
        this.f7203e.addTextChangedListener(this.f7212n);
    }

    public void onDestroyView() {
        this.f7203e.removeTextChangedListener(this.f7212n);
        OurApplication.m6291m().m10618b(this.f7211m);
        super.onDestroyView();
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putBoolean(f7200b, this.f7207i);
        bundle.putBoolean(f7201c, this.f7209k);
        if (this.f7206h != null) {
            bundle.putParcelable(f7199a, this.f7206h);
        }
        if (this.f7210l != null) {
            bundle.putByteArray(f7202d, this.f7210l.toByteArray());
        }
        super.onSaveInstanceState(bundle);
    }
}
