package com.bigroad.ttb.android.dialog;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.C0586c.C0584a;
import com.bigroad.ttb.android.R;
import java.util.ArrayList;
import java.util.List;

public abstract class ListOptionDialogFragment<T extends Enum<T> & C1829a> extends DialogFragment implements OnClickListener {
    private final List<T> f6218a;

    public interface C1829a {
        int mo1069a();

        boolean mo1070b();
    }

    protected abstract int mo1066a();

    protected abstract void mo1067a(DialogInterface dialogInterface, T t);

    protected int m8852b() {
        return R.drawable.context_menu_icon;
    }

    protected ListOptionDialogFragment(Class<T> cls) {
        Enum[] enumArr = (Enum[]) cls.getEnumConstants();
        this.f6218a = new ArrayList(enumArr.length);
        for (Object obj : enumArr) {
            if (((C1829a) obj).mo1070b()) {
                this.f6218a.add(obj);
            }
        }
    }

    private String[] m8849a(Context context) {
        String[] strArr = new String[this.f6218a.size()];
        for (int i = 0; i < this.f6218a.size(); i++) {
            strArr[i] = context.getString(((C1829a) ((Enum) this.f6218a.get(i))).mo1069a());
        }
        return strArr;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        mo1067a(dialogInterface, (Enum) this.f6218a.get(i));
    }

    public Dialog onCreateDialog(Bundle bundle) {
        CharSequence[] a = m8849a(getActivity());
        C0584a c0584a = new C0584a(getActivity());
        c0584a.m2659a(mo1066a()).m2678c(m8852b()).m2671a(a, (OnClickListener) this);
        Dialog b = c0584a.m2677b();
        b.setCanceledOnTouchOutside(false);
        return b;
    }
}
