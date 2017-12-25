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
import com.bigroad.shared.am;
import com.bigroad.shared.validation.C1178r;
import com.bigroad.shared.validation.ValidationError;
import com.bigroad.shared.validation.ValidationError.ErrorCode;
import com.bigroad.ttb.android.R;
import com.bigroad.ttb.android.p039h.C2091e;
import com.bigroad.ttb.android.util.ac;
import java.util.List;

public class C2460i implements TextWatcher {
    private final EditText f8783a;
    private final EditText f8784b;
    private final EditText f8785c;

    public C2460i(EditText editText, EditText editText2, EditText editText3) {
        this.f8783a = editText;
        this.f8784b = editText2;
        this.f8785c = editText3;
    }

    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public void afterTextChanged(Editable editable) {
        m12105a();
    }

    public static String m12103a(EditText editText, EditText editText2) {
        Integer a = ac.m11173a(editText);
        Integer a2 = ac.m11173a(editText2);
        String str = "";
        if (a == null || a2 == null) {
            return str;
        }
        int intValue = a2.intValue() - a.intValue();
        if (intValue >= 0) {
            return Integer.toString(intValue);
        }
        return str;
    }

    public static void m12104a(List<ValidationError> list, ErrorCode errorCode, final EditText editText, TextView textView, final String str, Context context) {
        CharSequence string = context.getString(R.string.validation_dailyLogTruckTotalDistanceIncorrectText);
        String format = String.format(context.getString(R.string.validation_dailyLogTruckTotalDistanceIncorrectClickable), new Object[]{str});
        CharSequence newSpannable = Factory.getInstance().newSpannable(format);
        newSpannable.setSpan(new ClickableSpan() {
            public void onClick(View view) {
                editText.setText("");
                editText.append(str);
            }
        }, 0, format.length(), 33);
        newSpannable.setSpan(new ForegroundColorSpan(context.getResources().getColor(R.color.validationError)), 0, format.length(), 33);
        List c = C1178r.m5985c(list, errorCode);
        CharSequence spannableStringBuilder = new SpannableStringBuilder();
        spannableStringBuilder.append(string).append(newSpannable);
        if (!c.isEmpty()) {
            spannableStringBuilder.append(System.getProperty("line.separator"));
            spannableStringBuilder.append(C2091e.m10476a(c, context));
        }
        textView.setText(spannableStringBuilder);
        textView.setMovementMethod(LinkMovementMethod.getInstance());
    }

    public void m12105a() {
        String trim = this.f8785c.getText().toString().trim();
        CharSequence a = C2460i.m12103a(this.f8783a, this.f8784b);
        if (!am.m4188a(a) && !am.m4189a(trim, (String) a)) {
            ac.m11179a(this.f8785c, a);
        }
    }
}
