package com.bigroad.ttb.android.dialog;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.C0586c.C0584a;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import com.bigroad.ttb.android.R;
import com.bigroad.ttb.android.activity.OurActivity;
import com.bigroad.ttb.android.adapter.C1691o;
import com.facebook.share.internal.ShareConstants;

public class PrintAppChooserDialogFragment extends DialogFragment {

    class C18332 implements OnClickListener {
        final /* synthetic */ PrintAppChooserDialogFragment f6264a;

        C18332(PrintAppChooserDialogFragment printAppChooserDialogFragment) {
            this.f6264a = printAppChooserDialogFragment;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            this.f6264a.dismiss();
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(Uri.parse("http://www.bigroad.com/faq#can-i-print-my-logs"));
            this.f6264a.startActivity(intent);
        }
    }

    public static void m8895a(OurActivity ourActivity, Uri uri) {
        PrintAppChooserDialogFragment printAppChooserDialogFragment = new PrintAppChooserDialogFragment();
        Bundle bundle = new Bundle();
        bundle.putString(ShareConstants.MEDIA_URI, uri.toString());
        printAppChooserDialogFragment.setArguments(bundle);
        printAppChooserDialogFragment.show(ourActivity.getSupportFragmentManager(), "choose");
    }

    public Dialog onCreateDialog(Bundle bundle) {
        Uri parse = Uri.parse(getArguments().getString(ShareConstants.MEDIA_URI));
        Dialog b = new C0584a(getActivity()).m2678c(R.drawable.ic_dialog_info_light).m2659a((int) R.string.dailyLog_printSelect).m2677b();
        final Object c1691o = new C1691o(getActivity(), parse, "application/pdf");
        if (c1691o.getCount() > 0) {
            b.m2691a(-2, getString(17039360), C1843a.f6286a);
            View inflate = getActivity().getLayoutInflater().inflate(R.layout.app_chooser_grid, null);
            GridView gridView = (GridView) inflate.findViewById(R.id.app_chooser_grid);
            gridView.setAdapter(c1691o);
            gridView.setOnItemClickListener(new OnItemClickListener(this) {
                final /* synthetic */ PrintAppChooserDialogFragment f6263b;

                public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                    this.f6263b.startActivity(c1691o.m8258a(i));
                    this.f6263b.dismiss();
                }
            });
            b.m2692a(inflate);
        } else {
            b.m2693a(getString(R.string.dailyLog_noPrintApp));
            b.m2691a(-2, getString(17039360), C1843a.f6286a);
            b.m2691a(-1, getString(R.string.dailyLog_help), new C18332(this));
        }
        return b;
    }
}
