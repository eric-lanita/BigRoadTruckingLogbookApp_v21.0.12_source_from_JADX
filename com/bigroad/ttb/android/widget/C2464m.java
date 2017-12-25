package com.bigroad.ttb.android.widget;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.bigroad.ttb.android.R;

public class C2464m {
    public static View m12116a(Context context, int i) {
        TextView textView = (TextView) LayoutInflater.from(context).inflate(R.layout.list_section_header, null);
        textView.setText(i);
        return textView;
    }

    public static View m12117a(Context context, int i, OnClickListener onClickListener) {
        TextView textView = (TextView) LayoutInflater.from(context).inflate(17367043, null);
        textView.setText(i);
        textView.setOnClickListener(onClickListener);
        textView.setTextColor(context.getResources().getColorStateList(R.color.adder_item_text));
        textView.setBackgroundResource(R.drawable.list_selector_background);
        textView.setPadding(context.getResources().getDimensionPixelSize(R.dimen.border_padding), 0, 0, 0);
        return textView;
    }
}
