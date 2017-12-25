package com.bigroad.ttb.android.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.bigroad.ttb.android.OurApplication;
import com.bigroad.ttb.android.R;
import com.bigroad.ttb.android.activity.OurActivity;
import com.bigroad.ttb.android.ai;
import com.bigroad.ttb.android.logging.C2134e;
import com.bigroad.ttb.android.util.ac;
import com.bigroad.ttb.android.widget.InstantAutoComplete;

public class AutoCompleteNoteInput extends AbstractNoteInput {
    private static final ai f7013b = OurApplication.m6256M();
    private InstantAutoComplete f7014c;

    public static void m10185a(OurActivity ourActivity, int i, int i2) {
        AutoCompleteNoteInput autoCompleteNoteInput = (AutoCompleteNoteInput) ourActivity.getSupportFragmentManager().mo148a(i);
        if (autoCompleteNoteInput == null) {
            C2134e.m10682e("TT-NoteInput", "Unable to set autocomplete on NoteInput fragment");
        } else {
            autoCompleteNoteInput.f7014c.setAdapter(f7013b.m8372a((Context) ourActivity, i2));
        }
    }

    public static void m10186b(OurActivity ourActivity, int i, int i2) {
        f7013b.m8377a(AbstractNoteInput.m10179a(ourActivity, i), i2);
    }

    protected int mo1186b() {
        return R.layout.autocomplete_note_input;
    }

    protected String mo1184a() {
        if (this.f7014c != null) {
            return this.f7014c.getText().toString().trim();
        }
        return null;
    }

    protected void mo1185a(String str) {
        if (this.f7014c != null) {
            this.f7014c.requestFocus();
            ac.m11179a(this.f7014c, (CharSequence) str);
        }
    }

    protected void mo1187c() {
        this.f7014c.requestFocus();
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View onCreateView = super.onCreateView(layoutInflater, viewGroup, bundle);
        this.f7014c = (InstantAutoComplete) onCreateView.findViewById(R.id.noteInput_text);
        this.f7014c.setOnEditorActionListener(this.a);
        return onCreateView;
    }
}
