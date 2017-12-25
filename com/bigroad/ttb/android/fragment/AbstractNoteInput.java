package com.bigroad.ttb.android.fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.bigroad.ttb.android.OurApplication;
import com.bigroad.ttb.android.R;
import com.bigroad.ttb.android.activity.C1632a;
import com.bigroad.ttb.android.activity.OurActivity;
import com.bigroad.ttb.android.logging.C2134e;
import com.bigroad.ttb.android.widget.C1267k;
import java.util.ArrayList;

public abstract class AbstractNoteInput extends Fragment {
    protected final OnEditorActionListener f7010a = new C20331(this);
    private ImageButton f7011b;
    private C1289a f7012c;

    public interface C1289a {
        boolean mo937a(TextView textView);
    }

    class C20331 extends C1267k {
        final /* synthetic */ AbstractNoteInput f7008a;

        C20331(AbstractNoteInput abstractNoteInput) {
            this.f7008a = abstractNoteInput;
        }

        public boolean mo929a(TextView textView) {
            if (this.f7008a.f7012c != null) {
                return this.f7008a.f7012c.mo937a(textView);
            }
            return false;
        }
    }

    class C20342 implements OnClickListener {
        final /* synthetic */ AbstractNoteInput f7009a;

        C20342(AbstractNoteInput abstractNoteInput) {
            this.f7009a = abstractNoteInput;
        }

        public void onClick(View view) {
            C1632a.m7960a(this.f7009a, this.f7009a.getString(R.string.noteInput_voicePrompt));
        }
    }

    protected abstract String mo1184a();

    protected abstract void mo1185a(String str);

    protected abstract int mo1186b();

    protected abstract void mo1187c();

    public static String m10179a(OurActivity ourActivity, int i) {
        AbstractNoteInput abstractNoteInput = (AbstractNoteInput) ourActivity.getSupportFragmentManager().mo148a(i);
        if (abstractNoteInput != null) {
            return abstractNoteInput.mo1184a();
        }
        C2134e.m10682e("TT-NoteInput", "Unable to get text from NoteInput fragment");
        return null;
    }

    public static void m10180b(OurActivity ourActivity, int i) {
        AbstractNoteInput abstractNoteInput = (AbstractNoteInput) ourActivity.getSupportFragmentManager().mo148a(i);
        if (abstractNoteInput != null) {
            abstractNoteInput.mo1187c();
        }
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            this.f7012c = (C1289a) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString() + " must implement NoteInputListener");
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(mo1186b(), viewGroup, false);
        this.f7011b = (ImageButton) inflate.findViewById(R.id.noteInput_speakNow);
        if (OurApplication.ak()) {
            this.f7011b.setOnClickListener(new C20342(this));
        } else {
            this.f7011b.setVisibility(8);
        }
        return inflate;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1 && intent != null) {
            switch (i) {
                case 8:
                    ArrayList stringArrayListExtra = intent.getStringArrayListExtra("android.speech.extra.RESULTS");
                    if (!stringArrayListExtra.isEmpty()) {
                        mo1185a(((String) stringArrayListExtra.get(0)).trim());
                        return;
                    }
                    return;
                default:
                    C2134e.m10676b("TT-NoteInput", "Ignoring completion of activity with requestCode=" + i);
                    return;
            }
        }
    }
}
