package com.bigroad.ttb.android.fragment;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v7.app.C0586c.C0584a;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import com.bigroad.shared.aj;
import com.bigroad.shared.am;
import com.bigroad.ttb.android.OurApplication;
import com.bigroad.ttb.android.R;
import com.bigroad.ttb.android.activity.C1632a;
import com.bigroad.ttb.android.activity.OurActivity;
import com.bigroad.ttb.android.dialog.C1843a;
import com.bigroad.ttb.android.dialog.ProminentDisclosureDialogFragment;
import com.bigroad.ttb.android.dialog.ProminentDisclosureDialogFragment.C1293a;
import com.bigroad.ttb.android.logging.C2134e;
import com.bigroad.ttb.android.p035d.p036a.C1763a;
import com.bigroad.ttb.protocol.TTProtocol.EventShare;
import com.google.protobuf.C3642c;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class SelectRecipients extends Fragment implements C1293a {
    private static final String f7230b = (SelectRecipients.class.getName() + ".emailAddress");
    private static final String f7231c = (SelectRecipients.class.getName() + ".emailList");
    OnClickListener f7232a = new C20641(this);
    private Button f7233d;
    private Button f7234e;
    private ViewGroup f7235f;
    private ArrayList<String> f7236g;
    private C1290a f7237h;
    private int f7238i;
    private String[] f7239j;

    public interface C1290a {
        boolean c_();

        void mo930f();
    }

    class C20641 implements OnClickListener {
        final /* synthetic */ SelectRecipients f7225a;

        C20641(SelectRecipients selectRecipients) {
            this.f7225a = selectRecipients;
        }

        public void onClick(View view) {
            ConfirmRemoveDialogFragment.m10384a(this.f7225a, ((Button) view).getText().toString());
        }
    }

    class C20652 implements OnClickListener {
        final /* synthetic */ SelectRecipients f7226a;

        C20652(SelectRecipients selectRecipients) {
            this.f7226a = selectRecipients;
        }

        public void onClick(View view) {
            this.f7226a.f7237h.mo930f();
            Iterator it = this.f7226a.f7236g.iterator();
            while (it.hasNext()) {
                OurApplication.m6287i().m8728a(new C1763a((String) it.next()));
            }
        }
    }

    class C20663 implements OnClickListener {
        final /* synthetic */ SelectRecipients f7227a;

        C20663(SelectRecipients selectRecipients) {
            this.f7227a = selectRecipients;
        }

        public void onClick(View view) {
            if (OurApplication.m6285g().m12177V()) {
                C1632a.m7961a(this.f7227a, this.f7227a.f7239j);
                return;
            }
            ProminentDisclosureDialogFragment prominentDisclosureDialogFragment = (ProminentDisclosureDialogFragment) this.f7227a.getActivity().getSupportFragmentManager().mo149a(ProminentDisclosureDialogFragment.f6267a);
            if (prominentDisclosureDialogFragment == null) {
                prominentDisclosureDialogFragment = new ProminentDisclosureDialogFragment();
                prominentDisclosureDialogFragment.m8900a(this.f7227a.getActivity().getSupportFragmentManager());
            }
            prominentDisclosureDialogFragment.setTargetFragment(this.f7227a, 0);
        }
    }

    public static class ConfirmRemoveDialogFragment extends DialogFragment {
        public static void m10384a(Fragment fragment, String str) {
            ConfirmRemoveDialogFragment confirmRemoveDialogFragment = new ConfirmRemoveDialogFragment();
            confirmRemoveDialogFragment.setTargetFragment(fragment, 0);
            Bundle bundle = new Bundle();
            bundle.putString(SelectRecipients.f7230b, str);
            confirmRemoveDialogFragment.setArguments(bundle);
            confirmRemoveDialogFragment.show(fragment.getActivity().getSupportFragmentManager(), "dialog");
        }

        public Dialog onCreateDialog(Bundle bundle) {
            final String string = getArguments().getString(SelectRecipients.f7230b);
            return new C0584a(getActivity()).m2678c(R.drawable.ic_dialog_alert_light).m2659a((int) R.string.selectRecipients_removeEmailTitle).m2675b(getResources().getString(R.string.selectRecipients_removeEmailMessage, new Object[]{string})).m2661a((int) R.string.yes, new DialogInterface.OnClickListener(this) {
                final /* synthetic */ ConfirmRemoveDialogFragment f7229b;

                public void onClick(DialogInterface dialogInterface, int i) {
                    ((SelectRecipients) this.f7229b.getTargetFragment()).m10394a(string);
                }
            }).m2673b((int) R.string.no, C1843a.f6286a).m2677b();
        }
    }

    public void m10394a(String str) {
        this.f7236g.remove(str);
        m10390b(str);
        m10391c();
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            this.f7237h = (C1290a) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString() + " must implement SelectRecipientsListener");
        }
    }

    public static List<EventShare> m10386a(OurActivity ourActivity, int i) {
        SelectRecipients selectRecipients = (SelectRecipients) ourActivity.getSupportFragmentManager().mo148a(i);
        if (selectRecipients != null) {
            List<EventShare> arrayList = new ArrayList(selectRecipients.f7236g.size());
            Iterator it = selectRecipients.f7236g.iterator();
            while (it.hasNext()) {
                arrayList.add(EventShare.newBuilder().m13962a(C3642c.m19078a(aj.m4179a())).m13964a((String) it.next()).m13967c());
            }
            return arrayList;
        }
        C2134e.m10682e("TT-SelectRecipients", "Unable to get event shares from SelectRecipients fragment");
        return Collections.emptyList();
    }

    public void m10393a() {
        if (this.f7234e != null && this.f7235f.getVisibility() == 0) {
            this.f7234e.requestFocus();
        } else if (this.f7233d != null) {
            this.f7233d.requestFocus();
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        ViewGroup viewGroup2 = (ViewGroup) layoutInflater.inflate(R.layout.select_recipients, viewGroup, false);
        this.f7233d = (Button) viewGroup2.findViewById(R.id.selectRecipients_addButton);
        this.f7234e = (Button) viewGroup2.findViewById(R.id.selectRecipients_sendButton);
        this.f7235f = (ViewGroup) viewGroup2.findViewById(R.id.selectRecipients_sendButtonWrapper);
        this.f7234e.setOnClickListener(new C20652(this));
        this.f7233d.setOnClickListener(new C20663(this));
        this.f7238i = 0;
        if (bundle != null) {
            this.f7236g = bundle.getStringArrayList(f7231c);
        }
        if (this.f7236g == null) {
            this.f7236g = new ArrayList();
        }
        Iterator it = this.f7236g.iterator();
        while (it.hasNext()) {
            m10387a(viewGroup2, (String) it.next());
        }
        m10391c();
        return viewGroup2;
    }

    public void mo942a(boolean z) {
        if (z) {
            this.f7233d.callOnClick();
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putStringArrayList(f7231c, this.f7236g);
    }

    private void m10391c() {
        if (this.f7238i == 0) {
            if (this.f7237h.c_()) {
                this.f7234e.setText(R.string.selectRecipients_sendToDispatchButton);
            } else {
                this.f7235f.setVisibility(8);
            }
        } else if (this.f7237h.c_()) {
            this.f7234e.setText(R.string.selectRecipients_sendToEmailAndDispatchButton);
        } else {
            this.f7235f.setVisibility(0);
        }
    }

    private void m10387a(ViewGroup viewGroup, String str) {
        int i = (int) (10.0f * getResources().getDisplayMetrics().density);
        Button button = (Button) getActivity().getLayoutInflater().inflate(R.layout.recipient_email_button, null);
        button.setText(str);
        button.setCompoundDrawablePadding(i);
        button.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.remove_icon_white, 0);
        button.setOnClickListener(this.f7232a);
        LinearLayout linearLayout = (LinearLayout) viewGroup.findViewById(R.id.selectRecipients_buttonContainer);
        int i2 = this.f7238i;
        this.f7238i = i2 + 1;
        linearLayout.addView(button, i2);
        m10391c();
    }

    private void m10390b(String str) {
        LinearLayout linearLayout = (LinearLayout) getActivity().findViewById(R.id.selectRecipients_buttonContainer);
        for (int i = 0; i < linearLayout.getChildCount(); i++) {
            View childAt = linearLayout.getChildAt(i);
            if (childAt instanceof Button) {
                Button button = (Button) childAt;
                if (button.getText().toString().equals(str)) {
                    linearLayout.removeView(button);
                    this.f7238i--;
                    return;
                }
            }
        }
        C2134e.m10682e("TT-SelectRecipients", "Unable to find button to remove: " + str);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1 && intent != null) {
            switch (i) {
                case 14:
                    String stringExtra = intent.getStringExtra("com.bigroad.ttb.emailAddress");
                    if (!am.m4188a((CharSequence) stringExtra)) {
                        if (!this.f7236g.contains(stringExtra)) {
                            this.f7236g.add(stringExtra);
                            m10387a((LinearLayout) getActivity().findViewById(R.id.selectRecipients_buttonContainer), stringExtra);
                        }
                        this.f7239j = intent.getStringArrayExtra("com.bigroad.ttb.stringArray");
                        return;
                    }
                    return;
                default:
                    C2134e.m10676b("TT-SelectRecipients", "Ignoring completion of activity with requestCode=" + i);
                    return;
            }
        }
    }
}
