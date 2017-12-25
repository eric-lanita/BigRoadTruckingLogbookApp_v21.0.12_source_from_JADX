package com.bigroad.ttb.android.dialog;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.C0586c.C0584a;
import com.bigroad.ttb.android.C2047k;
import com.bigroad.ttb.android.OurApplication;
import com.bigroad.ttb.android.R;
import com.bigroad.ttb.android.activity.DailyLogEditActivity;
import com.bigroad.ttb.android.dialog.LogDownloadTask.SendLogOptions;
import com.bigroad.ttb.android.fragment.DailyLogEditor;
import com.bigroad.ttb.android.fragment.DailyLogEditor.Workflow;
import com.bigroad.ttb.android.fragment.DailyLogEditor.Workflow.Action;
import com.bigroad.ttb.android.fragment.DailyLogEditor.Workflow.ValidationState;

public class DailyLogDetailsDialogs {

    public static abstract class WorkflowDialogFragment extends DialogFragment {
        public void m8837a(Workflow workflow) {
            Bundle bundle = getArguments() == null ? new Bundle() : getArguments();
            bundle.putParcelable("workflow", workflow);
            setArguments(bundle);
        }

        protected Workflow m8838b() {
            if (getArguments() != null) {
                return (Workflow) getArguments().getParcelable("workflow");
            }
            return null;
        }

        public void onCancel(DialogInterface dialogInterface) {
            super.onCancel(dialogInterface);
            if (getActivity() instanceof DailyLogEditActivity) {
                ((C2047k) getFragmentManager().mo149a(DailyLogEditor.f7109a)).mo1198c();
            }
        }

        protected int m8839c() {
            Workflow b = m8838b();
            switch (b != null ? b.m10218c() : Action.NONE) {
                case SEND_ALL:
                    return R.string.dailyLog_actionSend;
                case SIGN_ALL:
                case SIGN_LOG:
                    return R.string.dailyLog_actionSignLog;
                case SIGN_DVIR:
                    return R.string.dailyLog_actionSignDvir;
                default:
                    return R.string.dailyLog_actionContinue;
            }
        }

        protected void m8836a(DialogInterface dialogInterface) {
            if (getActivity() instanceof DailyLogEditActivity) {
                ((C2047k) getFragmentManager().mo149a(DailyLogEditor.f7109a)).mo1200d();
            }
            dialogInterface.dismiss();
        }
    }

    public static class ActionWithWarningsDialogFragment extends WorkflowDialogFragment {

        class C18011 implements OnClickListener {
            final /* synthetic */ ActionWithWarningsDialogFragment f6197a;

            C18011(ActionWithWarningsDialogFragment actionWithWarningsDialogFragment) {
                this.f6197a = actionWithWarningsDialogFragment;
            }

            public void onClick(DialogInterface dialogInterface, int i) {
                if (this.f6197a.getActivity() instanceof DailyLogEditActivity) {
                    ((C2047k) this.f6197a.getFragmentManager().mo149a(DailyLogEditor.f7109a)).mo1192a(ValidationState.START_FIX_WARNINGS);
                }
                dialogInterface.dismiss();
            }
        }

        class C18022 implements OnClickListener {
            final /* synthetic */ ActionWithWarningsDialogFragment f6198a;

            C18022(ActionWithWarningsDialogFragment actionWithWarningsDialogFragment) {
                this.f6198a = actionWithWarningsDialogFragment;
            }

            public void onClick(DialogInterface dialogInterface, int i) {
                this.f6198a.m8836a(dialogInterface);
            }
        }

        protected int m8840a() {
            Workflow b = m8838b();
            switch (b != null ? b.m10218c() : Action.NONE) {
                case SEND_ALL:
                    return R.string.dailyLogSend_withWarningsMessage;
                case SIGN_ALL:
                case SIGN_LOG:
                    return R.string.dailyLogApprove_withLogWarningsMessage;
                case SIGN_DVIR:
                    return R.string.dailyLogApprove_withDvirWarningsMessage;
                default:
                    return R.string.dailyLog_actionContinue;
            }
        }

        public Dialog onCreateDialog(Bundle bundle) {
            return new C0584a(getActivity()).m2678c(R.drawable.ic_dialog_alert_light).m2659a((int) R.string.dailyLog_fixAllWarningsTitle).m2672b(m8840a()).m2670a(true).m2661a(m8839c(), new C18022(this)).m2673b((int) R.string.dailyLog_fixWarnings, new C18011(this)).m2677b();
        }
    }

    public static class CantEditDutyStatusDialogFragment extends WorkflowDialogFragment {

        class C18031 implements OnClickListener {
            final /* synthetic */ CantEditDutyStatusDialogFragment f6199a;

            C18031(CantEditDutyStatusDialogFragment cantEditDutyStatusDialogFragment) {
                this.f6199a = cantEditDutyStatusDialogFragment;
            }

            public void onClick(DialogInterface dialogInterface, int i) {
                if (this.f6199a.getActivity() instanceof DailyLogEditActivity) {
                    ((C2047k) this.f6199a.getFragmentManager().mo149a(DailyLogEditor.f7109a)).mo1192a(ValidationState.FIX_EVENT_WARNINGS_COMPLETE);
                }
                dialogInterface.dismiss();
            }
        }

        public Dialog onCreateDialog(Bundle bundle) {
            return new C0584a(getActivity()).m2678c(R.drawable.ic_dialog_alert_light).m2659a((int) R.string.dutyStatusDialog_cantEditDutyStatusTitle).m2672b((int) R.string.dutyStatusDialog_cantEditDutyStatusMessage).m2670a(true).m2679c(17039360, new C18031(this)).m2677b();
        }
    }

    public static class ConfirmNoHeaderApprovalDialogFragment extends WorkflowDialogFragment {

        class C18041 implements OnClickListener {
            final /* synthetic */ ConfirmNoHeaderApprovalDialogFragment f6200a;

            C18041(ConfirmNoHeaderApprovalDialogFragment confirmNoHeaderApprovalDialogFragment) {
                this.f6200a = confirmNoHeaderApprovalDialogFragment;
            }

            public void onClick(DialogInterface dialogInterface, int i) {
                this.f6200a.m8836a(dialogInterface);
            }
        }

        class C18052 implements OnClickListener {
            final /* synthetic */ ConfirmNoHeaderApprovalDialogFragment f6201a;

            C18052(ConfirmNoHeaderApprovalDialogFragment confirmNoHeaderApprovalDialogFragment) {
                this.f6201a = confirmNoHeaderApprovalDialogFragment;
            }

            public void onClick(DialogInterface dialogInterface, int i) {
                if (this.f6201a.getActivity() instanceof DailyLogEditActivity) {
                    ((C2047k) this.f6201a.getFragmentManager().mo149a(DailyLogEditor.f7109a)).mo1194a(true);
                }
                dialogInterface.dismiss();
            }
        }

        public Dialog onCreateDialog(Bundle bundle) {
            return new C0584a(getActivity()).m2678c(R.drawable.ic_dialog_alert_light).m2659a((int) R.string.dailyLogApprove_noHeaderTitle).m2672b((int) R.string.dailyLogApprove_noHeaderMessage).m2670a(true).m2661a((int) R.string.dailyLogApprove_noHeaderAccept, new C18052(this)).m2673b((int) R.string.dailyLogApprove_noHeaderCancel, new C18041(this)).m2677b();
        }
    }

    public static class ConfirmNoHeaderSendDialogFragment extends WorkflowDialogFragment {

        class C18061 implements OnClickListener {
            final /* synthetic */ ConfirmNoHeaderSendDialogFragment f6202a;

            C18061(ConfirmNoHeaderSendDialogFragment confirmNoHeaderSendDialogFragment) {
                this.f6202a = confirmNoHeaderSendDialogFragment;
            }

            public void onClick(DialogInterface dialogInterface, int i) {
                if (this.f6202a.getActivity() instanceof DailyLogEditActivity) {
                    ((C2047k) this.f6202a.getFragmentManager().mo149a(DailyLogEditor.f7109a)).mo1194a(true);
                }
                dialogInterface.dismiss();
            }
        }

        class C18072 implements OnClickListener {
            final /* synthetic */ ConfirmNoHeaderSendDialogFragment f6203a;

            C18072(ConfirmNoHeaderSendDialogFragment confirmNoHeaderSendDialogFragment) {
                this.f6203a = confirmNoHeaderSendDialogFragment;
            }

            public void onClick(DialogInterface dialogInterface, int i) {
                this.f6203a.m8836a(dialogInterface);
            }
        }

        public Dialog onCreateDialog(Bundle bundle) {
            return new C0584a(getActivity()).m2678c(R.drawable.ic_dialog_alert_light).m2659a((int) R.string.dailyLogSend_noHeaderTitle).m2672b((int) R.string.dailyLogSend_noHeaderSendMessage).m2670a(true).m2661a((int) R.string.dailyLog_emailPrintButton, new C18072(this)).m2673b((int) R.string.dailyLogSend_noHeaderAddMissingInformation, new C18061(this)).m2677b();
        }
    }

    public static class ConfirmNoSignatureApprovalDialogFragment extends WorkflowDialogFragment {

        class C18081 implements OnClickListener {
            final /* synthetic */ ConfirmNoSignatureApprovalDialogFragment f6204a;

            C18081(ConfirmNoSignatureApprovalDialogFragment confirmNoSignatureApprovalDialogFragment) {
                this.f6204a = confirmNoSignatureApprovalDialogFragment;
            }

            public void onClick(DialogInterface dialogInterface, int i) {
                this.f6204a.m8836a(dialogInterface);
            }
        }

        class C18092 implements OnClickListener {
            final /* synthetic */ ConfirmNoSignatureApprovalDialogFragment f6205a;

            C18092(ConfirmNoSignatureApprovalDialogFragment confirmNoSignatureApprovalDialogFragment) {
                this.f6205a = confirmNoSignatureApprovalDialogFragment;
            }

            public void onClick(DialogInterface dialogInterface, int i) {
                if (this.f6205a.getActivity() instanceof DailyLogEditActivity) {
                    ((C2047k) this.f6205a.getFragmentManager().mo149a(DailyLogEditor.f7109a)).mo1202e();
                }
                dialogInterface.dismiss();
            }
        }

        public Dialog onCreateDialog(Bundle bundle) {
            return new C0584a(getActivity()).m2678c(R.drawable.ic_dialog_alert_light).m2659a((int) R.string.dailyLogApprove_noSignatureTitle).m2672b((int) R.string.dailyLogApprove_noSignatureMessage).m2670a(true).m2661a((int) R.string.dailyLogApprove_noSignatureAccept, new C18092(this)).m2673b((int) R.string.dailyLogApprove_noSignatureCancel, new C18081(this)).m2677b();
        }
    }

    public static class ConfirmNotApprovedNoHeaderSendDialogFragment extends WorkflowDialogFragment {

        class C18101 implements OnClickListener {
            final /* synthetic */ ConfirmNotApprovedNoHeaderSendDialogFragment f6206a;

            C18101(ConfirmNotApprovedNoHeaderSendDialogFragment confirmNotApprovedNoHeaderSendDialogFragment) {
                this.f6206a = confirmNotApprovedNoHeaderSendDialogFragment;
            }

            public void onClick(DialogInterface dialogInterface, int i) {
                if (this.f6206a.getActivity() instanceof DailyLogEditActivity) {
                    ((C2047k) this.f6206a.getFragmentManager().mo149a(DailyLogEditor.f7109a)).mo1198c();
                }
                dialogInterface.dismiss();
            }
        }

        class C18112 implements OnClickListener {
            final /* synthetic */ ConfirmNotApprovedNoHeaderSendDialogFragment f6207a;

            C18112(ConfirmNotApprovedNoHeaderSendDialogFragment confirmNotApprovedNoHeaderSendDialogFragment) {
                this.f6207a = confirmNotApprovedNoHeaderSendDialogFragment;
            }

            public void onClick(DialogInterface dialogInterface, int i) {
                if (this.f6207a.getActivity() instanceof DailyLogEditActivity) {
                    ((C2047k) this.f6207a.getFragmentManager().mo149a(DailyLogEditor.f7109a)).mo1192a(ValidationState.SEND_LOG);
                }
                dialogInterface.dismiss();
            }
        }

        public Dialog onCreateDialog(Bundle bundle) {
            return new C0584a(getActivity()).m2678c(R.drawable.ic_dialog_alert_light).m2659a((int) R.string.dailyLogSend_notApprovedTitle).m2672b((int) R.string.dailyLogSend_notApprovedNoHeaderMessage).m2670a(true).m2661a((int) R.string.dailyLog_emailPrintButton, new C18112(this)).m2673b((int) R.string.dailyLogApprove_noHeaderCancel, new C18101(this)).m2677b();
        }
    }

    public static class ConfirmNotApprovedWithHeaderSendDialogFragment extends WorkflowDialogFragment {

        class C18121 implements OnClickListener {
            final /* synthetic */ ConfirmNotApprovedWithHeaderSendDialogFragment f6208a;

            C18121(ConfirmNotApprovedWithHeaderSendDialogFragment confirmNotApprovedWithHeaderSendDialogFragment) {
                this.f6208a = confirmNotApprovedWithHeaderSendDialogFragment;
            }

            public void onClick(DialogInterface dialogInterface, int i) {
                if (this.f6208a.getActivity() instanceof DailyLogEditActivity) {
                    ((C2047k) this.f6208a.getFragmentManager().mo149a(DailyLogEditor.f7109a)).mo1192a(ValidationState.CREATE_SIGNATURE);
                }
                dialogInterface.dismiss();
            }
        }

        class C18132 implements OnClickListener {
            final /* synthetic */ ConfirmNotApprovedWithHeaderSendDialogFragment f6209a;

            C18132(ConfirmNotApprovedWithHeaderSendDialogFragment confirmNotApprovedWithHeaderSendDialogFragment) {
                this.f6209a = confirmNotApprovedWithHeaderSendDialogFragment;
            }

            public void onClick(DialogInterface dialogInterface, int i) {
                if (this.f6209a.getActivity() instanceof DailyLogEditActivity) {
                    ((C2047k) this.f6209a.getFragmentManager().mo149a(DailyLogEditor.f7109a)).mo1192a(ValidationState.SEND_LOG);
                }
                dialogInterface.dismiss();
            }
        }

        public Dialog onCreateDialog(Bundle bundle) {
            return new C0584a(getActivity()).m2678c(R.drawable.ic_dialog_alert_light).m2659a((int) R.string.dailyLogSend_notApprovedTitle).m2672b((int) R.string.dailyLogSend_notApprovedMessage).m2670a(true).m2661a((int) R.string.dailyLog_emailPrintButton, new C18132(this)).m2673b((int) R.string.dailyLog_approveAllButton, new C18121(this)).m2677b();
        }
    }

    public static class DoApprovalLogDialogFragment extends WorkflowDialogFragment {

        class C18141 implements OnClickListener {
            final /* synthetic */ DoApprovalLogDialogFragment f6210a;

            C18141(DoApprovalLogDialogFragment doApprovalLogDialogFragment) {
                this.f6210a = doApprovalLogDialogFragment;
            }

            public void onClick(DialogInterface dialogInterface, int i) {
                if (this.f6210a.getActivity() instanceof DailyLogEditActivity) {
                    ((C2047k) this.f6210a.getFragmentManager().mo149a(DailyLogEditor.f7109a)).mo1198c();
                }
                dialogInterface.dismiss();
            }
        }

        class C18152 implements OnClickListener {
            final /* synthetic */ DoApprovalLogDialogFragment f6211a;

            C18152(DoApprovalLogDialogFragment doApprovalLogDialogFragment) {
                this.f6211a = doApprovalLogDialogFragment;
            }

            public void onClick(DialogInterface dialogInterface, int i) {
                if (this.f6211a.getActivity() instanceof DailyLogEditActivity) {
                    ((C2047k) this.f6211a.getFragmentManager().mo149a(DailyLogEditor.f7109a)).mo1202e();
                }
                dialogInterface.dismiss();
            }
        }

        class C18163 implements OnClickListener {
            final /* synthetic */ DoApprovalLogDialogFragment f6212a;

            C18163(DoApprovalLogDialogFragment doApprovalLogDialogFragment) {
                this.f6212a = doApprovalLogDialogFragment;
            }

            public void onClick(DialogInterface dialogInterface, int i) {
                if (this.f6212a.getActivity() instanceof DailyLogEditActivity) {
                    ((C2047k) this.f6212a.getFragmentManager().mo149a(DailyLogEditor.f7109a)).mo1189a();
                }
                this.f6212a.m8836a(dialogInterface);
            }
        }

        private boolean m8841a() {
            if (getArguments() != null) {
                return getArguments().getBoolean("hasDvir");
            }
            return false;
        }

        public void m8844a(boolean z) {
            Bundle bundle = getArguments() == null ? new Bundle() : getArguments();
            bundle.putBoolean("hasDvir", z);
            setArguments(bundle);
        }

        private boolean m8842d() {
            if (getArguments() != null) {
                return getArguments().getBoolean("isAobrd");
            }
            return false;
        }

        private boolean m8843e() {
            if (getArguments() != null) {
                return getArguments().getBoolean("isEld");
            }
            return false;
        }

        public void m8845b(boolean z) {
            Bundle bundle = getArguments() == null ? new Bundle() : getArguments();
            bundle.putBoolean("isAobrd", z);
            setArguments(bundle);
        }

        public void m8846c(boolean z) {
            Bundle bundle = getArguments() == null ? new Bundle() : getArguments();
            bundle.putBoolean("isEld", z);
            setArguments(bundle);
        }

        public Dialog onCreateDialog(Bundle bundle) {
            boolean z;
            CharSequence charSequence;
            int i;
            StringBuilder stringBuilder = new StringBuilder();
            Workflow b = m8838b();
            if (b.m10218c().m10202a()) {
                String string = getString(R.string.dailyLogApprove_doApprovalLogTitle);
                if (m8843e()) {
                    stringBuilder.append(getString(R.string.dailyLogApprove_doApprovalLogEldMessage, OurApplication.m6285g().m12223m()));
                } else {
                    stringBuilder.append(getString(m8842d() ? R.string.dailyLogApprove_doApprovalLogAobrdMessage : R.string.dailyLogApprove_doApprovalLogMessage, OurApplication.m6285g().m12223m()));
                }
                z = true;
                charSequence = string;
            } else {
                Object string2 = getString(R.string.dailyLogApprove_doApprovalDvirTitle);
                z = false;
            }
            if (m8841a() && b.m10218c().m10203b()) {
                if (z) {
                    charSequence = getString(R.string.dailyLogApprove_doApprovalSignAllTitle);
                    stringBuilder.append(" ");
                }
                stringBuilder.append(getString(R.string.dailyLogApprove_doApprovalDvirMessage));
            }
            C0584a b2 = new C0584a(getActivity()).m2678c(R.drawable.ic_dialog_info_light).m2668a(charSequence).m2675b(stringBuilder.toString());
            if (m8843e() && z) {
                charSequence = getString(R.string.dailyLogApprove_doApprovalEldAccept);
            }
            C0584a c = b2.m2669a(charSequence, new C18163(this)).m2679c(R.string.dailyLogApprove_doEditSignature, new C18152(this));
            if (m8843e() && z) {
                i = R.string.dailyLogApprove_doApprovalEldCancel;
            } else {
                i = R.string.dailyLogApprove_doApprovalCancel;
            }
            return c.m2673b(i, new C18141(this)).m2670a(true).m2677b();
        }
    }

    public static class DownloadFinishedDialogFragment extends DialogFragment {

        class C18171 implements OnClickListener {
            final /* synthetic */ DownloadFinishedDialogFragment f6213a;

            C18171(DownloadFinishedDialogFragment downloadFinishedDialogFragment) {
                this.f6213a = downloadFinishedDialogFragment;
            }

            public void onClick(DialogInterface dialogInterface, int i) {
                Activity activity = this.f6213a.getActivity();
                if (activity != null) {
                    activity.startActivity(new Intent("android.intent.action.VIEW_DOWNLOADS"));
                    this.f6213a.dismiss();
                }
            }
        }

        public Dialog onCreateDialog(Bundle bundle) {
            return new C0584a(getActivity()).m2678c(R.drawable.ic_dialog_info_light).m2659a((int) R.string.dailyLog_downloadTitle).m2672b((int) R.string.dailyLog_downloadFinished).m2679c(17039370, C1843a.f6286a).m2661a((int) R.string.dailyLog_openDownloads, new C18171(this)).m2677b();
        }
    }

    public static abstract class DvirDialogFragment extends DialogFragment {
        protected byte[] m8848a() {
            if (getArguments() != null) {
                return getArguments().getByteArray("dvirId");
            }
            return null;
        }

        public void m8847a(byte[] bArr) {
            Bundle bundle = getArguments() == null ? new Bundle() : getArguments();
            bundle.putByteArray("dvirId", bArr);
            setArguments(bundle);
        }
    }

    public static class EditApprovedDvirDialogFragment extends DvirDialogFragment {

        class C18181 implements OnClickListener {
            final /* synthetic */ EditApprovedDvirDialogFragment f6214a;

            C18181(EditApprovedDvirDialogFragment editApprovedDvirDialogFragment) {
                this.f6214a = editApprovedDvirDialogFragment;
            }

            public void onClick(DialogInterface dialogInterface, int i) {
                if (this.f6214a.getActivity() instanceof DailyLogEditActivity) {
                    ((C2047k) this.f6214a.getFragmentManager().mo149a(DailyLogEditor.f7109a)).mo1201d(this.f6214a.m8848a());
                }
                dialogInterface.dismiss();
            }
        }

        public Dialog onCreateDialog(Bundle bundle) {
            return new C0584a(getActivity()).m2678c(R.drawable.ic_dialog_alert_light).m2659a((int) R.string.dailyLogApprove_editApprovedDvirTitle).m2672b((int) R.string.dailyLogApprove_editApprovedDvirMessage).m2661a((int) R.string.dailyLogApprove_editApprovedDvirAccept, new C18181(this)).m2673b((int) R.string.dailyLogApprove_editApprovedCancel, C1843a.f6286a).m2670a(true).m2677b();
        }
    }

    public static class EditApprovedNewDvirDialogFragment extends DvirDialogFragment {

        class C18191 implements OnClickListener {
            final /* synthetic */ EditApprovedNewDvirDialogFragment f6215a;

            C18191(EditApprovedNewDvirDialogFragment editApprovedNewDvirDialogFragment) {
                this.f6215a = editApprovedNewDvirDialogFragment;
            }

            public void onClick(DialogInterface dialogInterface, int i) {
                if (this.f6215a.getActivity() instanceof DailyLogEditActivity) {
                    C2047k c2047k = (C2047k) this.f6215a.getFragmentManager().mo149a(DailyLogEditor.f7109a);
                    byte[] a = this.f6215a.m8848a();
                    c2047k.mo1201d(a);
                    c2047k.mo1203e(a);
                }
                dialogInterface.dismiss();
            }
        }

        public Dialog onCreateDialog(Bundle bundle) {
            return new C0584a(getActivity()).m2678c(R.drawable.ic_dialog_alert_light).m2659a((int) R.string.dailyLogApprove_editApprovedNewDvirTitle).m2672b((int) R.string.dailyLogApprove_editApprovedNewDvirMessage).m2661a((int) R.string.dailyLogApprove_editApprovedNewDvirAccept, new C18191(this)).m2673b((int) R.string.dailyLogApprove_editApprovedCancel, C1843a.f6286a).m2670a(true).m2677b();
        }
    }

    public static class FixAllWarningsDialogFragment extends WorkflowDialogFragment {

        class C18201 implements OnClickListener {
            final /* synthetic */ FixAllWarningsDialogFragment f6216a;

            C18201(FixAllWarningsDialogFragment fixAllWarningsDialogFragment) {
                this.f6216a = fixAllWarningsDialogFragment;
            }

            public void onClick(DialogInterface dialogInterface, int i) {
                if (this.f6216a.getActivity() instanceof DailyLogEditActivity) {
                    ((C2047k) this.f6216a.getFragmentManager().mo149a(DailyLogEditor.f7109a)).mo1192a(ValidationState.START_FIX_WARNINGS);
                }
                dialogInterface.dismiss();
            }
        }

        class C18212 implements OnClickListener {
            final /* synthetic */ FixAllWarningsDialogFragment f6217a;

            C18212(FixAllWarningsDialogFragment fixAllWarningsDialogFragment) {
                this.f6217a = fixAllWarningsDialogFragment;
            }

            public void onClick(DialogInterface dialogInterface, int i) {
                this.f6217a.m8836a(dialogInterface);
            }
        }

        public Dialog onCreateDialog(Bundle bundle) {
            return new C0584a(getActivity()).m2678c(R.drawable.ic_dialog_alert_light).m2659a((int) R.string.dailyLog_fixAllWarningsTitle).m2672b(m8838b().m10218c().m10202a() ? R.string.dailyLog_fixAllLogWarningsMessage : R.string.dailyLog_fixAllDvirWarningsMessage).m2670a(true).m2661a(m8839c(), new C18212(this)).m2673b((int) R.string.dailyLog_fixWarnings, new C18201(this)).m2677b();
        }
    }

    public static class SendLogDialogFragment extends ListOptionDialogFragment<SendLogOptions> {
        public SendLogDialogFragment() {
            super(SendLogOptions.class);
        }

        protected int mo1066a() {
            return R.string.dailyLog_emailPrintMenuTitle;
        }

        protected void m8854a(DialogInterface dialogInterface, SendLogOptions sendLogOptions) {
            if (getActivity() instanceof DailyLogEditActivity) {
                C2047k c2047k = (C2047k) getFragmentManager().mo149a(DailyLogEditor.f7109a);
                DailyLogEditActivity dailyLogEditActivity = (DailyLogEditActivity) getActivity();
                switch (sendLogOptions) {
                    case EMAIL:
                        c2047k.b_();
                        break;
                    default:
                        dailyLogEditActivity.m6780a(dailyLogEditActivity.a_(), sendLogOptions);
                        break;
                }
            }
            dialogInterface.dismiss();
        }
    }

    public static void m8856a(FragmentActivity fragmentActivity, DialogFragment dialogFragment) {
        dialogFragment.show(fragmentActivity.getSupportFragmentManager(), "dialog");
    }
}
