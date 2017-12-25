package com.bigroad.ttb.android.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import com.bigroad.shared.C1131p;
import com.bigroad.shared.ah;
import com.bigroad.shared.am;
import com.bigroad.ttb.android.C2472x;
import com.bigroad.ttb.android.C2472x.C1306a;
import com.bigroad.ttb.android.OurApplication;
import com.bigroad.ttb.android.R;
import com.bigroad.ttb.android.activity.OurActivity.Feature;
import com.bigroad.ttb.android.adapter.C1312m;
import com.bigroad.ttb.protocol.TTProtocol.Person;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.EnumSet;
import java.util.List;

public class ContactPickerActivity extends OurKeyboardActivity {
    private EditText f4461a;
    private TextWatcher f4462b;
    private ListView f4463c;
    private C1313b f4464d;
    private View f4465e;
    private View f4466f;
    private final C1306a f4467g = new C13071(this);

    class C13071 implements C1306a {
        final /* synthetic */ ContactPickerActivity f4447a;

        C13071(ContactPickerActivity contactPickerActivity) {
            this.f4447a = contactPickerActivity;
        }

        public void mo948a(C2472x c2472x, List<Person> list) {
            this.f4447a.m6832a((List) list);
            this.f4447a.m6831h();
        }
    }

    class C13082 implements TextWatcher {
        final /* synthetic */ ContactPickerActivity f4448a;

        C13082(ContactPickerActivity contactPickerActivity) {
            this.f4448a = contactPickerActivity;
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            this.f4448a.f4464d.getFilter().filter(charSequence);
            this.f4448a.f4463c.smoothScrollToPosition(0);
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void afterTextChanged(Editable editable) {
        }
    }

    class C13093 implements OnItemClickListener {
        final /* synthetic */ ContactPickerActivity f4449a;

        C13093(ContactPickerActivity contactPickerActivity) {
            this.f4449a = contactPickerActivity;
        }

        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            this.f4449a.m6830d(i);
        }
    }

    private static final class C1310a {
        private final Person f4450a;
        private final String f4451b;
        private final List<String> f4452c = C1131p.m5720c(this.f4451b);

        public C1310a(Person person) {
            this.f4450a = person;
            this.f4451b = ah.m4160a(person);
        }

        public Person m6806a() {
            return this.f4450a;
        }

        public String m6807b() {
            return this.f4451b;
        }

        public List<String> m6808c() {
            return this.f4452c;
        }
    }

    private static final class C1313b extends C1312m<C1310a> {
        private static final Comparator<C1310a> f4459b = new C13111();
        private final LayoutInflater f4460a;

        static class C13111 implements Comparator<C1310a> {
            C13111() {
            }

            public /* synthetic */ int compare(Object obj, Object obj2) {
                return m6809a((C1310a) obj, (C1310a) obj2);
            }

            public int m6809a(C1310a c1310a, C1310a c1310a2) {
                return am.f2631d.compare(c1310a.m6807b(), c1310a2.m6807b());
            }
        }

        public C1313b(Context context, List<C1310a> list) {
            super(context, 17367043, list);
            this.f4460a = LayoutInflater.from(context);
        }

        public C1313b(Context context) {
            this(context, new ArrayList());
        }

        public View mo949a(int i, ViewGroup viewGroup, boolean z) {
            return this.f4460a.inflate(i, viewGroup, z);
        }

        public boolean hasStableIds() {
            return true;
        }

        protected boolean m6824a(C1310a c1310a, CharSequence charSequence) {
            String b = c1310a.m6807b();
            String charSequence2 = charSequence.toString();
            return am.m4190a(b, charSequence2, c1310a.m6808c(), am.m4192c(charSequence2));
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            View a;
            C1310a c1310a = (C1310a) getItem(i);
            if (view == null) {
                a = mo949a(17367043, viewGroup, false);
            } else {
                a = view;
            }
            ((TextView) a).setText(c1310a.m6807b());
            return a;
        }

        public void m6823a(List<Person> list) {
            m6816a();
            long d = OurApplication.m6285g().m12202d();
            for (Person person : list) {
                if (person.getPersonId() != d) {
                    m6817a((Object) new C1310a(person));
                }
            }
            m6818a(f4459b);
        }
    }

    protected TextView mo930f() {
        if (this.f4464d.isEmpty()) {
            return this.f4461a;
        }
        return null;
    }

    public void m6832a(List<Person> list) {
        this.f4464d.m6823a(list);
    }

    private void m6831h() {
        if (OurApplication.m6293o().m12143b()) {
            this.f4463c.setEmptyView(this.f4465e);
        } else {
            this.f4463c.setEmptyView(this.f4466f);
        }
    }

    public ContactPickerActivity() {
        super(EnumSet.of(Feature.FINISH_ON_SIGN_OUT, Feature.FINISH_ON_FLEET_LOSS, Feature.DEFAULT_MENU));
    }

    private void m6830d(int i) {
        if (i >= 0 && i < this.f4464d.getCount()) {
            Person a = ((C1310a) this.f4464d.getItem(i)).m6806a();
            Intent intent = new Intent();
            intent.putExtra("com.bigroad.ttb.personId", a.getPersonId());
            setResult(-1, intent);
            finish();
        }
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.contact_picker);
        m6692K().setStatusMessageVisible(false);
        this.f4466f = findViewById(R.id.contactPicker_loadingView);
        this.f4465e = findViewById(R.id.contactPicker_noContactsTextView);
        this.f4463c = (ListView) findViewById(R.id.contactPicker_listView);
        this.f4461a = (EditText) findViewById(R.id.contactPicker_searchBox);
        this.f4464d = new C1313b(this);
        m6832a(OurApplication.m6293o().m12139a());
        m6831h();
        this.f4462b = new C13082(this);
        this.f4461a.addTextChangedListener(this.f4462b);
        this.f4463c.setAdapter(this.f4464d);
        this.f4463c.setOnItemClickListener(new C13093(this));
        OurApplication.m6293o().m12140a(this.f4467g);
        if (bundle == null) {
            OurApplication.m6289k().m6502g();
        }
    }

    protected void onDestroy() {
        OurApplication.m6293o().m12142b(this.f4467g);
        super.onDestroy();
        this.f4461a.removeTextChangedListener(this.f4462b);
    }
}
