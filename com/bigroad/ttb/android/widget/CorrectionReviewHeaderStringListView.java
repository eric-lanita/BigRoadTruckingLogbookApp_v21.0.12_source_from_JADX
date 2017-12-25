package com.bigroad.ttb.android.widget;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bigroad.ttb.android.R;
import java.util.ArrayList;
import java.util.List;

public class CorrectionReviewHeaderStringListView extends LinearLayout {
    private LinearLayout f8317a;
    private LinearLayout f8318b;
    private TextView f8319c;
    private TextView f8320d;
    private List<String> f8321e = new ArrayList();
    private List<String> f8322f = new ArrayList();

    public CorrectionReviewHeaderStringListView(Context context) {
        super(context);
        m11767a(context);
    }

    public CorrectionReviewHeaderStringListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m11767a(context);
    }

    private void m11767a(Context context) {
        setOrientation(1);
        LayoutInflater.from(context).inflate(R.layout.correction_review_header_string_list, this);
        this.f8317a = (LinearLayout) findViewById(R.id.correctionReviewHeaderStringsList_addedSection);
        this.f8318b = (LinearLayout) findViewById(R.id.correctionReviewHeaderStringsList_removedSection);
        this.f8319c = (TextView) findViewById(R.id.correctionReviewHeaderStringList_added);
        this.f8320d = (TextView) findViewById(R.id.correctionReviewHeaderStringList_removed);
    }

    public boolean m11769a() {
        return (this.f8321e.isEmpty() && this.f8322f.isEmpty()) ? false : true;
    }

    public void m11768a(List<String> list, List<String> list2) {
        int i;
        int i2 = 8;
        this.f8322f.clear();
        for (String str : list) {
            if (!list2.contains(str)) {
                this.f8322f.add(str);
            }
        }
        this.f8321e.clear();
        for (String str2 : list2) {
            if (!list.contains(str2)) {
                this.f8321e.add(str2);
            }
        }
        LinearLayout linearLayout = this.f8317a;
        if (this.f8321e.isEmpty()) {
            i = 8;
        } else {
            i = 0;
        }
        linearLayout.setVisibility(i);
        this.f8319c.setText(TextUtils.join("\n", this.f8321e));
        LinearLayout linearLayout2 = this.f8318b;
        if (!this.f8322f.isEmpty()) {
            i2 = 0;
        }
        linearLayout2.setVisibility(i2);
        this.f8320d.setText(TextUtils.join("\n", this.f8322f));
    }
}
