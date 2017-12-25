package com.bigroad.ttb.android.dialog;

import android.content.DialogInterface;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.ViewTreeObserver.OnScrollChangedListener;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ScrollView;
import android.widget.TextView;
import com.bigroad.ttb.android.OurApplication;
import com.bigroad.ttb.android.R;
import com.bigroad.ttb.android.logging.C2134e;
import com.bigroad.ttb.android.widget.HelpOverlayLayout;

public class HelpDialogFragment extends DialogFragment {
    private View f6224a;
    private HelpOverlayLayout f6225b;
    private ScrollView f6226c;
    private TextView f6227d;
    private ViewGroup f6228e;
    private Button f6229f;
    private boolean f6230g = false;
    private final OnGlobalLayoutListener f6231h = new C18221(this);
    private final OnScrollChangedListener f6232i = new C18232(this);

    class C18221 implements OnGlobalLayoutListener {
        final /* synthetic */ HelpDialogFragment f6220a;

        C18221(HelpDialogFragment helpDialogFragment) {
            this.f6220a = helpDialogFragment;
        }

        public void onGlobalLayout() {
            this.f6220a.m8870a(this.f6220a.f6224a);
        }
    }

    class C18232 implements OnScrollChangedListener {
        final /* synthetic */ HelpDialogFragment f6221a;

        C18232(HelpDialogFragment helpDialogFragment) {
            this.f6221a = helpDialogFragment;
        }

        public void onScrollChanged() {
            this.f6221a.m8870a(this.f6221a.f6224a);
        }
    }

    private class C1824a implements OnClickListener {
        final /* synthetic */ HelpDialogFragment f6222a;

        private C1824a(HelpDialogFragment helpDialogFragment) {
            this.f6222a = helpDialogFragment;
        }

        public void onClick(View view) {
            OurApplication.m6246C().m10148c(view);
        }
    }

    private class C1825b implements OnClickListener {
        final /* synthetic */ HelpDialogFragment f6223a;

        private C1825b(HelpDialogFragment helpDialogFragment) {
            this.f6223a = helpDialogFragment;
        }

        public void onClick(View view) {
            if (this.f6223a.f6230g) {
                this.f6223a.dismiss();
            } else if (view == this.f6223a.f6225b) {
                this.f6223a.f6226c.fullScroll(130);
            }
        }
    }

    public static HelpDialogFragment m8863a(boolean z) {
        HelpDialogFragment helpDialogFragment = new HelpDialogFragment();
        Bundle bundle = new Bundle();
        bundle.putBoolean("cancelOnTouchOutside", z);
        helpDialogFragment.setArguments(bundle);
        return helpDialogFragment;
    }

    public void onCancel(DialogInterface dialogInterface) {
        super.onCancel(dialogInterface);
        OurApplication.m6246C().m10149d();
        getActivity().setResult(1);
        getActivity().finish();
    }

    public void onDismiss(DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
        m8868d();
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        OurApplication.m6246C().m10141a(bundle);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setStyle(2, R.style.OurTransparentBackgroundTheme);
        OurApplication.m6246C().m10144a(this, bundle);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f6225b = (HelpOverlayLayout) layoutInflater.inflate(R.layout.help_overlay, viewGroup, false);
        this.f6226c = (ScrollView) this.f6225b.findViewById(R.id.helpOverlay_note);
        this.f6227d = (TextView) this.f6225b.findViewById(R.id.helpOverlay_titleText);
        this.f6228e = (ViewGroup) this.f6225b.findViewById(R.id.helpOverlay_noteTextContainer);
        this.f6229f = (Button) this.f6225b.findViewById(R.id.helpOverlay_continueButton);
        this.f6229f.setOnClickListener(new C1824a());
        this.f6225b.setOnClickListener(new C1825b());
        if (getArguments() != null) {
            this.f6230g = getArguments().getBoolean("cancelOnTouchOutside");
        }
        OurApplication.m6246C().m10145b();
        return this.f6225b;
    }

    public void m8870a(View view) {
        m8868d();
        if (getActivity() != null) {
            boolean a;
            if (view != null) {
                m8864b(view);
                Rect rect = new Rect();
                Rect rect2 = new Rect();
                Window window = getActivity().getWindow();
                if (window != null) {
                    window.getDecorView().getWindowVisibleDisplayFrame(rect);
                }
                if (rect.isEmpty() || !view.getGlobalVisibleRect(rect2) || rect2.isEmpty()) {
                    C2134e.m10676b("TT-HelpDialogFragment", "Position of highlight rect not available or is empty");
                    a = this.f6225b.m11969a(null, true);
                } else {
                    if (!(rect2.width() == view.getWidth() && rect2.height() == view.getHeight())) {
                        OurApplication.m6246C().m10142a(view);
                    }
                    rect2.offset(-rect.left, -rect.top);
                    a = this.f6225b.m11968a(rect2);
                }
            } else {
                a = this.f6225b.m11968a(null);
            }
            if (a) {
                this.f6225b.requestLayout();
            }
        }
    }

    public boolean m8871a(int i) {
        if (this.f6227d == null) {
            return false;
        }
        this.f6227d.setText(i);
        this.f6227d.setVisibility(0);
        return true;
    }

    public void m8869a() {
        this.f6227d.setVisibility(8);
    }

    public boolean m8873b(int i) {
        return m8874c(i) != null;
    }

    public TextView m8874c(int i) {
        if (this.f6228e == null) {
            return null;
        }
        TextView textView = (TextView) getActivity().getLayoutInflater().inflate(R.layout.help_dialog_paragraph_text, null, false);
        textView.setText(i);
        this.f6228e.addView(textView, new LayoutParams(-2, -2));
        this.f6228e.setVisibility(0);
        return textView;
    }

    public void m8872b() {
        this.f6229f.setVisibility(8);
    }

    public boolean m8876d(int i) {
        if (this.f6229f == null) {
            return false;
        }
        this.f6229f.setText(i);
        return true;
    }

    public void m8875c() {
        if (this.f6227d != null) {
            this.f6227d.setVisibility(4);
        }
        if (this.f6228e != null) {
            this.f6228e.removeAllViews();
            this.f6228e.setVisibility(4);
        }
        m8876d((int) R.string.helpOverlay_continueButtonDefaultText);
        this.f6225b.setChildPadding(4);
        m8870a(null);
    }

    private void m8864b(View view) {
        this.f6224a = view;
        if (this.f6224a != null) {
            this.f6224a.getViewTreeObserver().addOnGlobalLayoutListener(this.f6231h);
            this.f6224a.getViewTreeObserver().addOnScrollChangedListener(this.f6232i);
        }
    }

    private void m8868d() {
        if (this.f6224a != null) {
            this.f6224a.getViewTreeObserver().removeGlobalOnLayoutListener(this.f6231h);
            this.f6224a.getViewTreeObserver().removeOnScrollChangedListener(this.f6232i);
            this.f6224a = null;
        }
    }
}
