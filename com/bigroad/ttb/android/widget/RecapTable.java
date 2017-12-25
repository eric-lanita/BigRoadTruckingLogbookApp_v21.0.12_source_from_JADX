package com.bigroad.ttb.android.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import com.bigroad.shared.ak.C0840a;
import com.bigroad.shared.dailylog.DailyLogUtils;
import com.bigroad.shared.duty.DutyCycle;
import com.bigroad.ttb.android.R;
import com.bigroad.ttb.android.util.C2292l;
import com.bigroad.ttb.android.util.C2293m;
import com.bigroad.ttb.protocol.TTProtocol.RecapType;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Locale;
import java.util.TimeZone;

public class RecapTable extends LinearLayout {
    private final Context f8607a;
    private final LayoutInflater f8608b;
    private final int f8609c;
    private final int f8610d;
    private RecapType f8611e;
    private int f8612f;
    private TimeZone f8613g;
    private C0840a f8614h;
    private Style f8615i;
    private int f8616j;
    private boolean f8617k;
    private LayoutType f8618l;
    private RelativeLayout f8619m;
    private boolean f8620n;

    private enum CellType {
        VALUE,
        HEADER
    }

    private enum LayoutType {
        VERTICAL,
        HORIZONTAL,
        MIXED;

        public static LayoutType m11988a(Context context, DutyCycle dutyCycle, int i) {
            int b = C2293m.m11240b(context);
            int i2 = Integer.MAX_VALUE;
            if (dutyCycle == DutyCycle.DUTY_CYCLE_CANADIAN_CYCLE_2) {
                i2 = (((dutyCycle.m4332a() * 70) / 2) + 180) + (i * 2);
            }
            if (b >= ((dutyCycle.m4332a() * 70) + 180) + (i * 2)) {
                return HORIZONTAL;
            }
            if (b >= i2) {
                return MIXED;
            }
            return VERTICAL;
        }
    }

    public enum Style {
        DARK(R.color.black, R.color.gray),
        LIGHT(R.color.white, R.color.gray);
        
        private final int m_backgroundColor;
        private final int m_borderColor;

        private Style(int i, int i2) {
            this.m_backgroundColor = i;
            this.m_borderColor = i2;
        }

        public int m11989a() {
            return this.m_backgroundColor;
        }

        public int m11990b() {
            return this.m_borderColor;
        }
    }

    public RecapTable(Context context) {
        this(context, null);
    }

    public RecapTable(Context context, AttributeSet attributeSet) {
        int i = 0;
        super(context, attributeSet);
        this.f8607a = context;
        this.f8608b = LayoutInflater.from(context);
        this.f8609c = Math.round(getResources().getDimension(R.dimen.group_spacing));
        this.f8610d = Math.round(getResources().getDimension(R.dimen.table_border_width));
        if (isInEditMode()) {
            DutyCycle dutyCycle = DutyCycle.DUTY_CYCLE_CANADIAN_CYCLE_2;
            int a = DailyLogUtils.m4284a(Calendar.getInstance());
            C0840a c0840a = new C0840a();
            c0840a.f2623a = "70";
            c0840a.f2624b = "70";
            c0840a.f2625c = new String[dutyCycle.m4332a()];
            for (int i2 = 0; i2 < c0840a.f2625c.length; i2++) {
                c0840a.f2625c[i2] = "0:00";
            }
            c0840a.f2626d = new String[dutyCycle.m4332a()];
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MMM d", Locale.getDefault());
            while (i < c0840a.f2626d.length) {
                c0840a.f2626d[i] = simpleDateFormat.format(DailyLogUtils.m4298a(a - i, TimeZone.getDefault()).getTime());
                i++;
            }
            c0840a.f2627e = new HashSet();
            c0840a.f2627e.add(Integer.valueOf(a - 3));
            if (dutyCycle.m4332a() > 8) {
                c0840a.f2627e.add(Integer.valueOf(a - 10));
            }
            m12000a(RecapType.FULL, dutyCycle, DailyLogUtils.m4284a(Calendar.getInstance()), TimeZone.getDefault(), c0840a, Style.DARK);
        }
    }

    public void m12000a(RecapType recapType, DutyCycle dutyCycle, int i, TimeZone timeZone, C0840a c0840a, Style style) {
        int i2 = 0;
        removeAllViews();
        this.f8611e = recapType;
        if (this.f8611e != RecapType.NO_RECAP) {
            this.f8612f = i;
            this.f8613g = timeZone;
            this.f8614h = c0840a;
            this.f8615i = style;
            this.f8616j = dutyCycle.m4332a();
            this.f8617k = dutyCycle == DutyCycle.DUTY_CYCLE_CANADIAN_CYCLE_2;
            Context context = this.f8607a;
            if (this.f8620n) {
                i2 = this.f8609c;
            }
            this.f8618l = LayoutType.m11988a(context, dutyCycle, i2);
            this.f8619m = new RelativeLayout(this.f8607a);
            LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
            if (this.f8620n) {
                layoutParams.setMargins(this.f8609c, this.f8609c, this.f8609c, this.f8609c);
            }
            this.f8619m.setLayoutParams(layoutParams);
            addView(this.f8619m);
            if (this.f8611e == RecapType.SUMMARY) {
                m11995b();
            } else if (this.f8618l == LayoutType.VERTICAL) {
                m11997c();
            } else {
                m11999d();
            }
        }
    }

    public void setUseMargins(boolean z) {
        this.f8620n = z;
    }

    private void m11995b() {
        View tableLayout = new TableLayout(this.f8607a);
        View tableRow = new TableRow(this.f8607a);
        m11994b(tableRow).setText(this.f8614h.f2625c[0]);
        m11994b(tableRow).setText(this.f8614h.f2623a);
        m11994b(tableRow).setText(getTomorrowValue());
        tableLayout.addView(tableRow);
        tableRow = new TableRow(this.f8607a);
        TextView c = m11996c(tableRow);
        c.setGravity(49);
        c.setText(this.f8607a.getString(R.string.recap_workedToday));
        c = m11996c(tableRow);
        c.setGravity(49);
        if (this.f8614h.f2627e.isEmpty()) {
            c.setText(this.f8607a.getString(R.string.recap_workedCycle, new Object[]{Integer.valueOf(this.f8616j)}));
        } else {
            c.setText(this.f8607a.getString(R.string.recap_workedCycleReset));
        }
        c = m11996c(tableRow);
        c.setGravity(49);
        c.setText(this.f8607a.getString(R.string.recap_availableTomorrow));
        tableLayout.addView(tableRow);
        tableLayout.setShrinkAllColumns(true);
        this.f8619m.addView(tableLayout);
    }

    private void m11997c() {
        View tableLayout = new TableLayout(this.f8607a);
        tableLayout.setLayoutParams(new RelativeLayout.LayoutParams(-1, -2));
        int i = this.f8617k ? this.f8616j / 2 : this.f8616j;
        TableRow[] tableRowArr = new TableRow[i];
        for (int i2 = 0; i2 < i; i2++) {
            int i3;
            tableRowArr[i2] = new TableRow(this.f8607a);
            if (this.f8617k) {
                i3 = 2;
            } else {
                i3 = 1;
            }
            for (int i4 = 0; i4 < i3; i4++) {
                CharSequence string;
                int i5 = ((this.f8616j - 1) - i2) - (i * i4);
                boolean contains = this.f8614h.f2627e.contains(Integer.valueOf(this.f8612f - i5));
                TextView d = m11998d(tableRowArr[i2]);
                d.setText(this.f8614h.f2625c[i5]);
                if (i4 == 1) {
                    ((TableRow.LayoutParams) d.getLayoutParams()).setMargins(this.f8609c, 0, 0, 0);
                }
                if (i5 == 0) {
                    string = this.f8607a.getString(R.string.recap_workedToday);
                } else {
                    string = this.f8614h.f2626d[i5];
                }
                if (contains) {
                    string = string + (i3 == 1 ? " " : "\n") + this.f8607a.getString(R.string.recap_reset);
                }
                m11996c(tableRowArr[i2]).setText(string);
            }
        }
        for (View addView : tableRowArr) {
            tableLayout.addView(addView);
        }
        View view = new View(this.f8607a);
        view.setBackgroundResource(this.f8615i.m11990b());
        LayoutParams layoutParams = new TableRow.LayoutParams(-2, this.f8610d);
        layoutParams.setMargins(0, this.f8609c / 2, 0, this.f8609c / 2);
        layoutParams.span = this.f8617k ? 4 : 2;
        view.setLayoutParams(layoutParams);
        View tableRow = new TableRow(this.f8607a);
        tableRow.addView(view);
        tableLayout.addView(tableRow);
        tableRow = new TableRow(this.f8607a);
        LayoutParams layoutParams2 = new TableRow.LayoutParams(-2, -1);
        if (this.f8617k) {
            layoutParams2.span = 3;
        }
        m11998d(tableRow).setText(this.f8614h.f2623a);
        TextView c = m11996c(tableRow);
        if (this.f8614h.f2627e.isEmpty()) {
            c.setText(this.f8607a.getString(R.string.recap_workedCycle, new Object[]{Integer.valueOf(this.f8616j)}).replace('\n', ' '));
        } else {
            c.setText(this.f8607a.getString(R.string.recap_workedCycleReset).replace('\n', ' '));
        }
        c.setLayoutParams(layoutParams2);
        c.setSingleLine();
        tableLayout.addView(tableRow);
        tableRow = new TableRow(this.f8607a);
        m11998d(tableRow).setText(getTomorrowValue());
        c = m11996c(tableRow);
        c.setText(this.f8607a.getString(R.string.recap_availableTomorrow).replace('\n', ' '));
        c.setLayoutParams(layoutParams2);
        c.setSingleLine();
        tableLayout.addView(tableRow);
        this.f8619m.addView(tableLayout);
    }

    private void m11999d() {
        int i;
        View tableLayout = new TableLayout(this.f8607a);
        tableLayout.setBackgroundResource(this.f8615i.m11990b());
        View tableRow = new TableRow(this.f8607a);
        m11994b(tableRow).setText(this.f8614h.f2623a);
        m11994b(tableRow).setText(getTomorrowValue());
        tableLayout.addView(tableRow);
        tableRow = new TableRow(this.f8607a);
        if (this.f8614h.f2627e.isEmpty()) {
            m11991a(tableRow).setText(this.f8607a.getString(R.string.recap_workedCycle, new Object[]{Integer.valueOf(this.f8616j)}));
        } else {
            m11991a(tableRow).setText(this.f8607a.getString(R.string.recap_workedCycleReset));
        }
        m11991a(tableRow).setText(this.f8607a.getString(R.string.recap_availableTomorrow));
        tableLayout.addView(tableRow);
        LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -1);
        layoutParams.addRule(1, 1);
        tableLayout.setLayoutParams(layoutParams);
        tableLayout.setPadding(this.f8610d, 0, 0, 0);
        tableRow = new LinearLayout(this.f8607a);
        tableRow.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        tableRow.setBackgroundResource(this.f8615i.m11989a());
        tableLayout.addView(tableRow);
        this.f8619m.addView(tableLayout);
        if (this.f8617k && this.f8618l == LayoutType.MIXED) {
            i = this.f8616j / 2;
        } else {
            i = this.f8616j;
        }
        tableRow = new TableLayout(this.f8607a);
        tableRow.setId(1);
        tableRow.setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
        m11993a(tableRow, this.f8616j - 1, this.f8616j - i, false);
        this.f8619m.addView(tableRow);
        if (this.f8617k && this.f8618l == LayoutType.MIXED) {
            m11993a(tableRow, (this.f8616j - i) - 1, 0, true);
        }
    }

    private void m11993a(TableLayout tableLayout, int i, int i2, boolean z) {
        View tableRow = new TableRow(this.f8607a);
        if (z) {
            LayoutParams layoutParams = new TableLayout.LayoutParams();
            layoutParams.setMargins(0, this.f8609c, 0, 0);
            tableRow.setLayoutParams(layoutParams);
        }
        for (int i3 = i; i3 >= i2; i3--) {
            m11998d(tableRow).setText(this.f8614h.f2625c[i3]);
        }
        tableLayout.addView(tableRow);
        tableRow = new TableRow(this.f8607a);
        while (i >= i2) {
            CharSequence string;
            if (i == 0) {
                string = this.f8607a.getString(R.string.recap_workedToday);
            } else {
                string = this.f8614h.f2626d[i];
            }
            if (this.f8614h.f2627e.contains(Integer.valueOf(this.f8612f - i))) {
                string = string + "\n" + this.f8607a.getString(R.string.recap_reset);
            }
            m11996c(tableRow).setText(string);
            i--;
        }
        tableLayout.addView(tableRow);
    }

    private String getTomorrowValue() {
        if (m12001a()) {
            return this.f8614h.f2624b;
        }
        return getResources().getString(R.string.recap_notApplicable);
    }

    public boolean m12001a() {
        return !isInEditMode() && (this.f8612f != DailyLogUtils.m4285a(this.f8613g) || C2292l.m11230a(this.f8612f));
    }

    private TextView m11991a(TableRow tableRow) {
        TextView c = m11996c(tableRow);
        c.setGravity(17);
        c.setWidth(C2293m.m11238a(this.f8607a, 90));
        return c;
    }

    private TextView m11994b(TableRow tableRow) {
        TextView d = m11998d(tableRow);
        d.setGravity(17);
        d.setWidth(C2293m.m11238a(this.f8607a, 90));
        return d;
    }

    private TextView m11996c(TableRow tableRow) {
        return m11992a(tableRow, R.layout.recap_table_header, CellType.HEADER);
    }

    private TextView m11998d(TableRow tableRow) {
        return m11992a(tableRow, R.layout.recap_table_value, CellType.VALUE);
    }

    private TextView m11992a(TableRow tableRow, int i, CellType cellType) {
        TextView textView = (TextView) this.f8608b.inflate(i, tableRow, false);
        if (this.f8618l != LayoutType.VERTICAL) {
            textView.setGravity(1);
            textView.setWidth(C2293m.m11238a(this.f8607a, 70));
        } else if (cellType == CellType.HEADER) {
            textView.setGravity(51);
        } else {
            textView.setGravity(53);
        }
        textView.setBackgroundResource(this.f8615i.m11989a());
        tableRow.addView(textView);
        return textView;
    }
}
