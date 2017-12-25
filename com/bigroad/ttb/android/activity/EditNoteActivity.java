package com.bigroad.ttb.android.activity;

import android.content.Context;
import android.os.Bundle;
import android.widget.ScrollView;
import android.widget.TextView;
import com.bigroad.ttb.android.OurApplication;
import com.bigroad.ttb.android.R;
import com.bigroad.ttb.android.activity.OurActivity.Feature;
import com.bigroad.ttb.android.activity.OurActivity.TitleStyle;
import com.bigroad.ttb.android.event.C2022a;
import com.bigroad.ttb.android.fragment.AbstractNoteInput;
import com.bigroad.ttb.android.fragment.AbstractNoteInput.C1289a;
import com.bigroad.ttb.android.fragment.AutoCompleteNoteInput;
import com.bigroad.ttb.android.fragment.OurGallery;
import com.bigroad.ttb.android.fragment.SelectRecipients;
import com.bigroad.ttb.android.fragment.SelectRecipients.C1290a;
import java.util.EnumSet;
import java.util.List;

public class EditNoteActivity extends OurActivity implements C1289a, C1290a {
    private ScrollView f5155a;

    public void mo930f() {
        m7545h();
    }

    public boolean c_() {
        return m6699R().m12213g() >= 0;
    }

    public boolean mo937a(TextView textView) {
        this.f5155a.fullScroll(130);
        SelectRecipients selectRecipients = (SelectRecipients) getSupportFragmentManager().mo148a((int) R.id.selectRecipients_fragment);
        if (selectRecipients != null) {
            selectRecipients.m10393a();
        }
        return false;
    }

    public EditNoteActivity() {
        super(EnumSet.of(Feature.FINISH_ON_SIGN_OUT, Feature.DEFAULT_MENU), TitleStyle.IDENTITY);
    }

    private void m7545h() {
        m7546i();
        finish();
        OurApplication.m6278b((Context) this).show();
    }

    private void m7546i() {
        List a = OurGallery.m10375a(this, R.id.ourGallery_fragment);
        OurApplication.m6295q().m10014a(C2022a.m10082a(OurApplication.ac(), AbstractNoteInput.m10179a(this, R.id.noteInput_fragment), SelectRecipients.m10386a((OurActivity) this, (int) R.id.selectRecipients_fragment)), a);
        m6702U().m8291a(a.size());
        AutoCompleteNoteInput.m10186b(this, R.id.noteInput_fragment, 15);
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.edit_note);
        this.f5155a = (ScrollView) findViewById(R.id.root);
        AutoCompleteNoteInput.m10185a(this, R.id.noteInput_fragment, 15);
        AbstractNoteInput.m10180b(this, R.id.noteInput_fragment);
    }
}
