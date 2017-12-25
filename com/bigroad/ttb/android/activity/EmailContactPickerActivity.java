package com.bigroad.ttb.android.activity;

import android.app.Dialog;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract.CommonDataKinds.Email;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.C0586c.C0584a;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import com.bigroad.shared.C1131p;
import com.bigroad.shared.am;
import com.bigroad.ttb.android.OurApplication;
import com.bigroad.ttb.android.R;
import com.bigroad.ttb.android.activity.OurActivity.Feature;
import com.bigroad.ttb.android.activity.OurActivity.TitleStyle;
import com.bigroad.ttb.android.adapter.C1685l;
import com.bigroad.ttb.android.dialog.C1843a;
import com.bigroad.ttb.android.logging.C2134e;
import com.bigroad.ttb.android.p035d.p036a.C1763a;
import com.bigroad.ttb.android.widget.C1267k;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class EmailContactPickerActivity extends OurKeyboardActivity {
    private EditText f5199a;
    private C1685l f5200b;
    private TextWatcher f5201c;
    private Button f5202d;
    private List<C1763a> f5203e = new ArrayList();
    private Set<String> f5204f = new HashSet();
    private Comparator<C1763a> f5205g = new C15021(this);

    class C15021 implements Comparator<C1763a> {
        final /* synthetic */ EmailContactPickerActivity f5193a;

        C15021(EmailContactPickerActivity emailContactPickerActivity) {
            this.f5193a = emailContactPickerActivity;
        }

        public /* synthetic */ int compare(Object obj, Object obj2) {
            return m7580a((C1763a) obj, (C1763a) obj2);
        }

        public int m7580a(C1763a c1763a, C1763a c1763a2) {
            return c1763a.m8560b().compareToIgnoreCase(c1763a2.m8560b());
        }
    }

    class C15043 extends C1267k {
        final /* synthetic */ EmailContactPickerActivity f5196a;

        C15043(EmailContactPickerActivity emailContactPickerActivity) {
            this.f5196a = emailContactPickerActivity;
        }

        public boolean mo929a(TextView textView) {
            if (this.f5196a.f5202d != null) {
                this.f5196a.f5202d.performClick();
            }
            return true;
        }
    }

    class C15054 implements OnItemClickListener {
        final /* synthetic */ EmailContactPickerActivity f5197a;

        C15054(EmailContactPickerActivity emailContactPickerActivity) {
            this.f5197a = emailContactPickerActivity;
        }

        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            this.f5197a.m7591d(i);
        }
    }

    class C15065 implements OnClickListener {
        final /* synthetic */ EmailContactPickerActivity f5198a;

        C15065(EmailContactPickerActivity emailContactPickerActivity) {
            this.f5198a = emailContactPickerActivity;
        }

        public void onClick(View view) {
            String trim = this.f5198a.f5199a.getText().toString().trim();
            if (!am.m4188a((CharSequence) trim)) {
                if (C1131p.m5718a(trim)) {
                    C1763a c1763a = new C1763a(trim);
                    int indexOf = this.f5198a.f5203e.indexOf(c1763a);
                    if (indexOf < 0) {
                        this.f5198a.f5204f.add(trim);
                        this.f5198a.f5200b.m6817a((Object) c1763a);
                        this.f5198a.f5200b.m8239a(c1763a);
                    } else {
                        trim = ((C1763a) this.f5198a.f5203e.get(indexOf)).m8560b();
                    }
                    this.f5198a.m7586a(trim);
                } else {
                    InvalidEmailDialogFragment.m7582a(this.f5198a);
                    return;
                }
            }
            this.f5198a.finish();
        }
    }

    public static class InvalidEmailDialogFragment extends DialogFragment {
        public static void m7582a(OurActivity ourActivity) {
            new InvalidEmailDialogFragment().show(ourActivity.getSupportFragmentManager(), "dialog");
        }

        public Dialog onCreateDialog(Bundle bundle) {
            return new C0584a(getActivity()).m2678c(R.drawable.ic_dialog_alert_light).m2659a((int) R.string.emailContactPicker_invalidEmailTitle).m2672b((int) R.string.emailContactPicker_invalidEmailMessage).m2661a(17039370, C1843a.f6286a).m2677b();
        }
    }

    public EmailContactPickerActivity() {
        super(Feature.FINISH_ON_SIGN_OUT, TitleStyle.NONE);
    }

    protected TextView mo930f() {
        if (this.f5200b.isEmpty()) {
            return this.f5199a;
        }
        return null;
    }

    private void m7586a(String str) {
        Intent intent = new Intent();
        intent.putExtra("com.bigroad.ttb.emailAddress", str);
        intent.putExtra("com.bigroad.ttb.stringArray", (String[]) this.f5204f.toArray(new String[this.f5204f.size()]));
        setResult(-1, intent);
    }

    private void m7591d(int i) {
        if (i >= 0 && i < this.f5200b.getCount()) {
            m7586a(((C1763a) this.f5200b.getItem(i)).m8560b());
            finish();
        }
    }

    private void m7587a(Set<C1763a> set) {
        Cursor query = getContentResolver().query(Email.CONTENT_URI, new String[]{"data1", "in_visible_group"}, "data1 IS NOT NULL AND in_visible_group = 1", null, null);
        if (query == null) {
            C2134e.m10680d("TT-ECPickerActivity", "Internal error querying ContentResolver for contact list");
            return;
        }
        while (query.moveToNext()) {
            String string = query.getString(query.getColumnIndex("data1"));
            if (!am.m4188a((CharSequence) string) && C1131p.m5719b(string)) {
                set.add(new C1763a(string));
            }
        }
        query.close();
    }

    private void m7593h() {
        Set hashSet = new HashSet();
        for (C1763a c1763a : OurApplication.m6287i().m8806r()) {
            if (C1131p.m5718a(c1763a.m8560b())) {
                hashSet.add(c1763a);
            }
        }
        if (this.f5204f != null) {
            for (String c1763a2 : this.f5204f) {
                hashSet.add(new C1763a(c1763a2));
            }
        }
        m7587a(hashSet);
        if (this.f5203e == null) {
            this.f5203e = new ArrayList();
        }
        this.f5203e.clear();
        this.f5203e.addAll(hashSet);
        Collections.sort(this.f5203e, this.f5205g);
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.email_contact_picker);
        m6692K().setStatusMessageVisible(false);
        getWindow().setLayout(-1, -1);
        final ListView listView = (ListView) findViewById(R.id.emailContactPicker_listView);
        this.f5202d = (Button) findViewById(R.id.emailContactPicker_addNewRecipientButton);
        this.f5199a = (EditText) findViewById(R.id.emailContactPicker_searchBox);
        String[] stringArrayExtra = getIntent().getStringArrayExtra("com.bigroad.ttb.stringArray");
        if (stringArrayExtra != null) {
            Collections.addAll(this.f5204f, stringArrayExtra);
        }
        m7593h();
        this.f5200b = new C1685l(this, this.f5203e);
        this.f5201c = new TextWatcher(this) {
            final /* synthetic */ EmailContactPickerActivity f5195b;

            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                this.f5195b.f5200b.getFilter().filter(charSequence);
                listView.smoothScrollToPosition(0);
            }

            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public void afterTextChanged(Editable editable) {
            }
        };
        this.f5199a.addTextChangedListener(this.f5201c);
        this.f5199a.setOnEditorActionListener(new C15043(this));
        listView.setAdapter(this.f5200b);
        listView.setEmptyView(findViewById(R.id.emailContactPicker_emptyText));
        listView.setOnItemClickListener(new C15054(this));
        this.f5202d.setOnClickListener(new C15065(this));
    }

    protected void onDestroy() {
        super.onDestroy();
        this.f5199a.removeTextChangedListener(this.f5201c);
    }
}
