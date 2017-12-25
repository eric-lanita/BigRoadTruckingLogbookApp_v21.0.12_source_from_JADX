package com.bigroad.ttb.android.widget;

import android.content.Context;
import android.text.Editable;
import android.text.Spannable.Factory;
import android.text.SpannableStringBuilder;
import android.text.TextWatcher;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.bigroad.shared.af;
import com.bigroad.shared.dailylog.DailyLogUtils;
import com.bigroad.shared.dailylog.DailyLogUtils.C0859a;
import com.bigroad.shared.validation.C1178r;
import com.bigroad.shared.validation.ValidationError;
import com.bigroad.shared.validation.ValidationError.ErrorCode;
import com.bigroad.ttb.android.R;
import com.bigroad.ttb.android.p039h.C2091e;
import com.bigroad.ttb.protocol.TTProtocol.OdometerUnit;
import java.util.Collections;
import java.util.List;

public class C2466o implements TextWatcher {
    private final C1379a f8795a;

    public interface C1379a {
        void mo979a(C0859a c0859a);

        List<DailyLogEditHeaderTruckView> mo962j();

        List<DailyLogEditHeaderTruckView> mo963k();

        OdometerUnit mo931l();
    }

    public C2466o(C1379a c1379a) {
        this.f8795a = c1379a;
    }

    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public void afterTextChanged(Editable editable) {
        m12119a();
    }

    public static void m12118a(List<ValidationError> list, ErrorCode errorCode, final EditText editText, TextView textView, final String str, OdometerUnit odometerUnit, Context context) {
        String a = af.m4154a("Set total distance to " + str, odometerUnit);
        CharSequence newSpannable = Factory.getInstance().newSpannable(a);
        newSpannable.setSpan(new ClickableSpan() {
            public void onClick(View view) {
                editText.setText("");
                editText.append(str);
            }
        }, 0, a.length(), 33);
        newSpannable.setSpan(new ForegroundColorSpan(context.getResources().getColor(R.color.validationError)), 0, a.length(), 33);
        List c = C1178r.m5985c(list, errorCode);
        CharSequence spannableStringBuilder = new SpannableStringBuilder();
        spannableStringBuilder.append("Distance value for all trucks does not agree with the truck distances. ").append(newSpannable).append(".");
        if (!c.isEmpty()) {
            spannableStringBuilder.append(System.getProperty("line.separator"));
            spannableStringBuilder.append(C2091e.m10476a(c, context));
        }
        textView.setText(spannableStringBuilder);
        textView.setMovementMethod(LinkMovementMethod.getInstance());
    }

    public void m12119a() {
        this.f8795a.mo979a(DailyLogUtils.m4290a(this.f8795a.mo931l(), this.f8795a.mo962j(), this.f8795a.mo963k(), Collections.emptyList()));
    }
}
