package com.bigroad.ttb.android.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import com.bigroad.ttb.android.R;
import com.bigroad.ttb.android.util.ac;

public class NoteInput extends AbstractNoteInput {
    private EditText f7213b;

    protected int mo1186b() {
        return R.layout.note_input;
    }

    protected String mo1184a() {
        if (this.f7213b != null) {
            return this.f7213b.getText().toString().trim();
        }
        return null;
    }

    protected void mo1185a(String str) {
        if (this.f7213b != null) {
            this.f7213b.requestFocus();
            ac.m11179a(this.f7213b, (CharSequence) str);
        }
    }

    protected void mo1187c() {
        this.f7213b.requestFocus();
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View onCreateView = super.onCreateView(layoutInflater, viewGroup, bundle);
        this.f7213b = (EditText) onCreateView.findViewById(R.id.noteInput_text);
        this.f7213b.setOnEditorActionListener(this.a);
        return onCreateView;
    }
}
