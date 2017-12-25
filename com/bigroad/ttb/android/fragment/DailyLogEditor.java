package com.bigroad.ttb.android.fragment;

import android.content.Intent;
import android.database.DataSetObserver;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.bigroad.shared.C1130o;
import com.bigroad.shared.am;
import com.bigroad.shared.ap;
import com.bigroad.shared.dailylog.DailyLogUtils;
import com.bigroad.shared.duty.C0889h;
import com.bigroad.shared.duty.C0890f.C0886a;
import com.bigroad.shared.duty.C0907o;
import com.bigroad.shared.duty.C0956v;
import com.bigroad.shared.model.C1116d.C1114a;
import com.bigroad.shared.validation.C0887n;
import com.bigroad.shared.validation.C1178r;
import com.bigroad.shared.validation.ValidationError;
import com.bigroad.shared.validation.ValidationError.Category;
import com.bigroad.shared.validation.ValidationError.ErrorCode;
import com.bigroad.shared.validation.ValidationError.Severity;
import com.bigroad.shared.validation.model.DailyLogHeader;
import com.bigroad.ttb.android.C2047k;
import com.bigroad.ttb.android.C2103j;
import com.bigroad.ttb.android.C2103j.C1337a;
import com.bigroad.ttb.android.C2226q;
import com.bigroad.ttb.android.C2226q.C1221a;
import com.bigroad.ttb.android.C2230r;
import com.bigroad.ttb.android.C2230r.C1332b;
import com.bigroad.ttb.android.OurApplication;
import com.bigroad.ttb.android.R;
import com.bigroad.ttb.android.SignatureManager;
import com.bigroad.ttb.android.SignatureManager.C1224a;
import com.bigroad.ttb.android.TruckManager;
import com.bigroad.ttb.android.TruckManager.C1203b;
import com.bigroad.ttb.android.TruckManager.ChangeListener.Priority;
import com.bigroad.ttb.android.activity.C1632a;
import com.bigroad.ttb.android.activity.DailyLogEditActivity;
import com.bigroad.ttb.android.activity.OurActivity;
import com.bigroad.ttb.android.adapter.C1402k;
import com.bigroad.ttb.android.adapter.C1402k.C1679c;
import com.bigroad.ttb.android.adapter.C1404e;
import com.bigroad.ttb.android.adapter.C1664d;
import com.bigroad.ttb.android.adapter.C1675i;
import com.bigroad.ttb.android.adapter.EventListAdapter.DisplayedRow;
import com.bigroad.ttb.android.dialog.DailyLogDetailsDialogs;
import com.bigroad.ttb.android.dialog.DailyLogDetailsDialogs.ActionWithWarningsDialogFragment;
import com.bigroad.ttb.android.dialog.DailyLogDetailsDialogs.CantEditDutyStatusDialogFragment;
import com.bigroad.ttb.android.dialog.DailyLogDetailsDialogs.ConfirmNoHeaderApprovalDialogFragment;
import com.bigroad.ttb.android.dialog.DailyLogDetailsDialogs.ConfirmNoHeaderSendDialogFragment;
import com.bigroad.ttb.android.dialog.DailyLogDetailsDialogs.ConfirmNoSignatureApprovalDialogFragment;
import com.bigroad.ttb.android.dialog.DailyLogDetailsDialogs.ConfirmNotApprovedNoHeaderSendDialogFragment;
import com.bigroad.ttb.android.dialog.DailyLogDetailsDialogs.ConfirmNotApprovedWithHeaderSendDialogFragment;
import com.bigroad.ttb.android.dialog.DailyLogDetailsDialogs.DoApprovalLogDialogFragment;
import com.bigroad.ttb.android.dialog.DailyLogDetailsDialogs.EditApprovedDvirDialogFragment;
import com.bigroad.ttb.android.dialog.DailyLogDetailsDialogs.EditApprovedNewDvirDialogFragment;
import com.bigroad.ttb.android.dialog.DailyLogDetailsDialogs.FixAllWarningsDialogFragment;
import com.bigroad.ttb.android.dialog.DailyLogDetailsDialogs.SendLogDialogFragment;
import com.bigroad.ttb.android.dialog.ErrorDialogFragment;
import com.bigroad.ttb.android.fragment.DailyLogFragment.C1295b;
import com.bigroad.ttb.android.logging.C2134e;
import com.bigroad.ttb.android.p029c.C1738c;
import com.bigroad.ttb.android.p039h.C2091e;
import com.bigroad.ttb.android.util.C2292l;
import com.bigroad.ttb.android.util.ac;
import com.bigroad.ttb.android.vehicle.C2338a;
import com.bigroad.ttb.android.vehicle.ProcessingState;
import com.bigroad.ttb.android.vehicle.VehicleConnectionManager;
import com.bigroad.ttb.android.vehicle.VehicleConnectionManager.C1201a;
import com.bigroad.ttb.android.vehicle.VehicleConnectionManager.ChangeListener;
import com.bigroad.ttb.android.widget.C1343n;
import com.bigroad.ttb.android.widget.C1643q;
import com.bigroad.ttb.android.widget.C2452b;
import com.bigroad.ttb.android.widget.C2464m;
import com.bigroad.ttb.android.widget.DailyLogHeaderView;
import com.bigroad.ttb.android.widget.DailyLogHeaderView.C2036a;
import com.bigroad.ttb.android.widget.DailyLogHeaderView.MissingHeader;
import com.bigroad.ttb.protocol.TTProtocol.DailyLog;
import com.bigroad.ttb.protocol.TTProtocol.DailyLogShareType;
import com.bigroad.ttb.protocol.TTProtocol.Dvir;
import com.bigroad.ttb.protocol.TTProtocol.DvirInspection;
import com.bigroad.ttb.protocol.TTProtocol.Event;
import com.bigroad.ttb.protocol.TTProtocol.Person;
import com.bigroad.ttb.protocol.TTProtocol.Truck;
import com.bigroad.ttb.protocol.TTProtocol.al;
import com.google.common.primitives.Ints;
import com.google.protobuf.C3642c;
import com.google.protobuf.InvalidProtocolBufferException;
import com.p017a.p018a.p019a.C0816a;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.TimeZone;

public class DailyLogEditor extends DailyLogFragment implements C2047k {
    public static final String f7109a = DailyLogEditor.class.getName();
    private static final String f7110u = (DailyLogEditor.class.getName() + ".workflow");
    private static final String f7111v = (DailyLogEditor.class.getName() + ".tab");
    private final C2230r f7112A = OurApplication.m6292n();
    private final ap f7113B = OurApplication.m6269Z();
    private final C2103j f7114C = OurApplication.ae();
    private View f7115D;
    private View f7116E;
    private View f7117F;
    private View f7118G;
    private View f7119H;
    private TextView f7120I;
    private TextView f7121J;
    private ImageView f7122K;
    private TextView f7123L;
    private View f7124M;
    private View[] f7125N;
    private Button f7126O;
    private Bundle f7127P;
    private C1404e f7128Q;
    private C1402k f7129R;
    private C2452b f7130S;
    private View f7131T;
    private View f7132U;
    private Workflow f7133V;
    private Tab f7134W;
    private final ChangeListener f7135X = new C20351(this);
    private final TruckManager.ChangeListener f7136Y = new C1203b(this) {
        final /* synthetic */ DailyLogEditor f7017a;

        {
            this.f7017a = r1;
        }

        public void mo894a(Truck truck) {
            this.f7017a.m10260B();
        }
    };
    private final C1332b f7137Z = new C1332b(this) {
        final /* synthetic */ DailyLogEditor f7023a;

        {
            this.f7023a = r1;
        }

        public void mo954a(C2230r c2230r) {
            this.f7023a.m10260B();
        }
    };
    private final C1221a aa = new C1221a(this) {
        final /* synthetic */ DailyLogEditor f7024a;

        {
            this.f7024a = r1;
        }

        public void mo905a(C2226q c2226q) {
            this.f7024a.m10266H();
        }
    };
    private final C1224a ab = new C1224a(this) {
        final /* synthetic */ DailyLogEditor f7025a;

        {
            this.f7025a = r1;
        }

        public void mo1007a(SignatureManager signatureManager) {
            this.f7025a.mo1207s();
        }
    };
    private final C1337a ac = new C1337a(this) {
        final /* synthetic */ DailyLogEditor f7026a;

        {
            this.f7026a = r1;
        }

        public void mo956a(C2103j c2103j) {
            this.f7026a.mo1207s();
            this.f7026a.m10261C();
        }
    };
    private final Runnable ad = new Runnable(this) {
        final /* synthetic */ DailyLogEditor f7028a;

        {
            this.f7028a = r1;
        }

        public void run() {
            int y = this.f7028a.m10244y();
            if (y != -1) {
                this.f7028a.j.smoothScrollToPosition(y);
            }
        }
    };
    private final C2036a ae = new C2036a(this) {
        final /* synthetic */ DailyLogEditor f7029a;

        {
            this.f7029a = r1;
        }

        public void mo1188a() {
            this.f7029a.mo1194a(false);
        }
    };
    private final C2226q f7138w = OurApplication.m6297s();
    private final SignatureManager f7139x = OurApplication.m6255L();
    private final VehicleConnectionManager f7140y = OurApplication.m6252I();
    private final TruckManager f7141z = OurApplication.m6294p();

    class C20351 extends C1201a {
        final /* synthetic */ DailyLogEditor f7027a;

        C20351(DailyLogEditor dailyLogEditor) {
            this.f7027a = dailyLogEditor;
        }

        public void mo888a(C2338a c2338a) {
            this.f7027a.m10260B();
        }

        public void mo887a(ProcessingState processingState) {
            this.f7027a.m10260B();
        }
    }

    class C20372 implements OnClickListener {
        final /* synthetic */ DailyLogEditor f7031a;

        C20372(DailyLogEditor dailyLogEditor) {
            this.f7031a = dailyLogEditor;
        }

        public void onClick(View view) {
            this.f7031a.m10279a(Tab.HEADER);
        }
    }

    class C20383 implements OnClickListener {
        final /* synthetic */ DailyLogEditor f7032a;

        C20383(DailyLogEditor dailyLogEditor) {
            this.f7032a = dailyLogEditor;
        }

        public void onClick(View view) {
            this.f7032a.m10263E();
        }
    }

    class C20394 implements OnClickListener {
        final /* synthetic */ DailyLogEditor f7033a;

        C20394(DailyLogEditor dailyLogEditor) {
            this.f7033a = dailyLogEditor;
        }

        public void onClick(View view) {
            this.f7033a.m10315o();
        }
    }

    class C20405 implements OnClickListener {
        final /* synthetic */ DailyLogEditor f7034a;

        C20405(DailyLogEditor dailyLogEditor) {
            this.f7034a = dailyLogEditor;
        }

        public void onClick(View view) {
            this.f7034a.m10317q();
        }
    }

    class C20416 implements OnClickListener {
        final /* synthetic */ DailyLogEditor f7035a;

        C20416(DailyLogEditor dailyLogEditor) {
            this.f7035a = dailyLogEditor;
        }

        public void onClick(View view) {
            C1632a.m7935a(this.f7035a.getActivity(), null, this.f7035a.m10243x());
        }
    }

    class C20427 implements OnClickListener {
        final /* synthetic */ DailyLogEditor f7036a;

        C20427(DailyLogEditor dailyLogEditor) {
            this.f7036a = dailyLogEditor;
        }

        public void onClick(View view) {
            List o = this.f7036a.b.m10065o();
            if (o.contains(Integer.valueOf(this.f7036a.m10243x()))) {
                C1632a.m7957a(this.f7036a.getActivity(), Ints.m18832a(o.subList(o.indexOf(Integer.valueOf(this.f7036a.m10243x())), o.size())));
            }
        }
    }

    class C20438 implements OnClickListener {
        final /* synthetic */ DailyLogEditor f7037a;

        C20438(DailyLogEditor dailyLogEditor) {
            this.f7037a = dailyLogEditor;
        }

        public void onClick(View view) {
            C1632a.m7991f(this.f7037a.getActivity(), this.f7037a.m10243x());
        }
    }

    class C20449 extends DataSetObserver {
        final /* synthetic */ DailyLogEditor f7038a;

        C20449(DailyLogEditor dailyLogEditor) {
            this.f7038a = dailyLogEditor;
        }

        public void onChanged() {
            if (this.f7038a.f7128Q.m7243k()) {
                this.f7038a.o.setText(R.string.dailyLogList_collapseAll);
            } else {
                this.f7038a.o.setText(R.string.dailyLogList_expandAll);
            }
        }
    }

    private enum Tab {
        LOG,
        HEADER
    }

    public static class Workflow implements Parcelable {
        public static final Creator<Workflow> CREATOR = new C20451();
        private ValidationState f7081a;
        private Action f7082b;
        private ValidationState f7083c;
        private boolean f7084d;
        private LinkedList<Reference> f7085e;
        private Reference f7086f;
        private boolean f7087g;

        static class C20451 implements Creator<Workflow> {
            C20451() {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r0 = this;
                r0.<init>();
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.bigroad.ttb.android.fragment.DailyLogEditor.Workflow.1.<init>():void");
            }

            public /* synthetic */ java.lang.Object createFromParcel(android.os.Parcel r2) {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r1 = this;
                r0 = r1.m10200a(r2);
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.bigroad.ttb.android.fragment.DailyLogEditor.Workflow.1.createFromParcel(android.os.Parcel):java.lang.Object");
            }

            public /* synthetic */ java.lang.Object[] newArray(int r2) {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r1 = this;
                r0 = r1.m10201a(r2);
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.bigroad.ttb.android.fragment.DailyLogEditor.Workflow.1.newArray(int):java.lang.Object[]");
            }

            public com.bigroad.ttb.android.fragment.DailyLogEditor.Workflow m10200a(android.os.Parcel r3) {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r2 = this;
                r0 = new com.bigroad.ttb.android.fragment.DailyLogEditor$Workflow;
                r1 = 0;
                r0.<init>(r3, r1);
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.bigroad.ttb.android.fragment.DailyLogEditor.Workflow.1.a(android.os.Parcel):com.bigroad.ttb.android.fragment.DailyLogEditor$Workflow");
            }

            public com.bigroad.ttb.android.fragment.DailyLogEditor.Workflow[] m10201a(int r2) {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r1 = this;
                r0 = new com.bigroad.ttb.android.fragment.DailyLogEditor.Workflow[r2];
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.bigroad.ttb.android.fragment.DailyLogEditor.Workflow.1.a(int):com.bigroad.ttb.android.fragment.DailyLogEditor$Workflow[]");
            }
        }

        public enum Action {
            ;

            public boolean m10202a() {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r1 = this;
                r0 = SIGN_ALL;
                if (r1 == r0) goto L_0x000c;
            L_0x0004:
                r0 = SIGN_LOG;
                if (r1 == r0) goto L_0x000c;
            L_0x0008:
                r0 = SEND_ALL;
                if (r1 != r0) goto L_0x000e;
            L_0x000c:
                r0 = 1;
            L_0x000d:
                return r0;
            L_0x000e:
                r0 = 0;
                goto L_0x000d;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.bigroad.ttb.android.fragment.DailyLogEditor.Workflow.Action.a():boolean");
            }

            public boolean m10203b() {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r1 = this;
                r0 = SIGN_ALL;
                if (r1 == r0) goto L_0x000c;
            L_0x0004:
                r0 = SIGN_DVIR;
                if (r1 == r0) goto L_0x000c;
            L_0x0008:
                r0 = SEND_ALL;
                if (r1 != r0) goto L_0x000e;
            L_0x000c:
                r0 = 1;
            L_0x000d:
                return r0;
            L_0x000e:
                r0 = 0;
                goto L_0x000d;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.bigroad.ttb.android.fragment.DailyLogEditor.Workflow.Action.b():boolean");
            }

            public boolean m10204c() {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r1 = this;
                r0 = SIGN_ALL;
                if (r1 == r0) goto L_0x000c;
            L_0x0004:
                r0 = SIGN_LOG;
                if (r1 == r0) goto L_0x000c;
            L_0x0008:
                r0 = SIGN_DVIR;
                if (r1 != r0) goto L_0x000e;
            L_0x000c:
                r0 = 1;
            L_0x000d:
                return r0;
            L_0x000e:
                r0 = 0;
                goto L_0x000d;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.bigroad.ttb.android.fragment.DailyLogEditor.Workflow.Action.c():boolean");
            }

            public boolean m10205d() {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r1 = this;
                r0 = SEND_ALL;
                if (r1 != r0) goto L_0x0006;
            L_0x0004:
                r0 = 1;
            L_0x0005:
                return r0;
            L_0x0006:
                r0 = 0;
                goto L_0x0005;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.bigroad.ttb.android.fragment.DailyLogEditor.Workflow.Action.d():boolean");
            }
        }

        public static class Reference implements Parcelable {
            public static final Creator<Reference> CREATOR = new C20461();
            private final Type f7052a;
            private final byte[] f7053b;

            static class C20461 implements Creator<Reference> {
                C20461() {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r0 = this;
                    r0.<init>();
                    return;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.bigroad.ttb.android.fragment.DailyLogEditor.Workflow.Reference.1.<init>():void");
                }

                public /* synthetic */ java.lang.Object createFromParcel(android.os.Parcel r2) {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r1 = this;
                    r0 = r1.m10206a(r2);
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.bigroad.ttb.android.fragment.DailyLogEditor.Workflow.Reference.1.createFromParcel(android.os.Parcel):java.lang.Object");
                }

                public /* synthetic */ java.lang.Object[] newArray(int r2) {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r1 = this;
                    r0 = r1.m10207a(r2);
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.bigroad.ttb.android.fragment.DailyLogEditor.Workflow.Reference.1.newArray(int):java.lang.Object[]");
                }

                public com.bigroad.ttb.android.fragment.DailyLogEditor.Workflow.Reference m10206a(android.os.Parcel r3) {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r2 = this;
                    r0 = new com.bigroad.ttb.android.fragment.DailyLogEditor$Workflow$Reference;
                    r1 = 0;
                    r0.<init>(r3, r1);
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.bigroad.ttb.android.fragment.DailyLogEditor.Workflow.Reference.1.a(android.os.Parcel):com.bigroad.ttb.android.fragment.DailyLogEditor$Workflow$Reference");
                }

                public com.bigroad.ttb.android.fragment.DailyLogEditor.Workflow.Reference[] m10207a(int r2) {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r1 = this;
                    r0 = new com.bigroad.ttb.android.fragment.DailyLogEditor.Workflow.Reference[r2];
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.bigroad.ttb.android.fragment.DailyLogEditor.Workflow.Reference.1.a(int):com.bigroad.ttb.android.fragment.DailyLogEditor$Workflow$Reference[]");
                }
            }

            public enum Type {
            }

            public Reference(com.bigroad.ttb.android.fragment.DailyLogEditor.Workflow.Reference.Type r1, byte[] r2) {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r0 = this;
                r0.<init>();
                r0.f7052a = r1;
                r0.f7053b = r2;
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.bigroad.ttb.android.fragment.DailyLogEditor.Workflow.Reference.<init>(com.bigroad.ttb.android.fragment.DailyLogEditor$Workflow$Reference$Type, byte[]):void");
            }

            public byte[] m10210a() {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r1 = this;
                r0 = r1.f7053b;
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.bigroad.ttb.android.fragment.DailyLogEditor.Workflow.Reference.a():byte[]");
            }

            public int describeContents() {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r1 = this;
                r0 = 0;
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.bigroad.ttb.android.fragment.DailyLogEditor.Workflow.Reference.describeContents():int");
            }

            private Reference(android.os.Parcel r3) {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r2 = this;
                r2.<init>();
                r0 = com.bigroad.ttb.android.fragment.DailyLogEditor.Workflow.Reference.class;
                r1 = r0.getClassLoader();
                r0 = r3.readValue(r1);
                r0 = (com.bigroad.ttb.android.fragment.DailyLogEditor.Workflow.Reference.Type) r0;
                r2.f7052a = r0;
                r0 = r3.readValue(r1);
                r0 = (byte[]) r0;
                r0 = (byte[]) r0;
                r2.f7053b = r0;
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.bigroad.ttb.android.fragment.DailyLogEditor.Workflow.Reference.<init>(android.os.Parcel):void");
            }

            public void writeToParcel(android.os.Parcel r2, int r3) {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r1 = this;
                r0 = r1.f7052a;
                r2.writeValue(r0);
                r0 = r1.f7053b;
                r2.writeValue(r0);
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.bigroad.ttb.android.fragment.DailyLogEditor.Workflow.Reference.writeToParcel(android.os.Parcel, int):void");
            }
        }

        public enum ValidationState {
        }

        public int describeContents() {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r1 = this;
            r0 = 0;
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bigroad.ttb.android.fragment.DailyLogEditor.Workflow.describeContents():int");
        }

        Workflow() {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r1 = this;
            r1.<init>();
            r0 = new java.util.LinkedList;
            r0.<init>();
            r1.f7085e = r0;
            r1.m10211a();
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bigroad.ttb.android.fragment.DailyLogEditor.Workflow.<init>():void");
        }

        private Workflow(android.os.Parcel r4) {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r3 = this;
            r3.<init>();
            r0 = new java.util.LinkedList;
            r0.<init>();
            r3.f7085e = r0;
            r0 = com.bigroad.ttb.android.fragment.DailyLogEditor.Workflow.class;
            r1 = r0.getClassLoader();
            r0 = r4.readValue(r1);
            r0 = (com.bigroad.ttb.android.fragment.DailyLogEditor.Workflow.ValidationState) r0;
            r3.f7081a = r0;
            r0 = r4.readValue(r1);
            r0 = (com.bigroad.ttb.android.fragment.DailyLogEditor.Workflow.Action) r0;
            r3.f7082b = r0;
            r0 = r4.readValue(r1);
            r0 = (com.bigroad.ttb.android.fragment.DailyLogEditor.Workflow.ValidationState) r0;
            r3.f7083c = r0;
            r0 = r4.readValue(r1);
            r0 = (java.lang.Boolean) r0;
            r0 = r0.booleanValue();
            r3.f7084d = r0;
            r0 = r3.f7085e;
            r2 = com.bigroad.ttb.android.fragment.DailyLogEditor.Workflow.Reference.class;
            r2 = r2.getClassLoader();
            r4.readList(r0, r2);
            r0 = com.bigroad.ttb.android.fragment.DailyLogEditor.Workflow.Reference.class;
            r0 = r0.getClassLoader();
            r0 = r4.readValue(r0);
            r0 = (com.bigroad.ttb.android.fragment.DailyLogEditor.Workflow.Reference) r0;
            r3.f7086f = r0;
            r0 = r4.readValue(r1);
            r0 = (java.lang.Boolean) r0;
            r0 = r0.booleanValue();
            r3.f7087g = r0;
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bigroad.ttb.android.fragment.DailyLogEditor.Workflow.<init>(android.os.Parcel):void");
        }

        public void writeToParcel(android.os.Parcel r2, int r3) {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r1 = this;
            r0 = r1.f7081a;
            r2.writeValue(r0);
            r0 = r1.f7082b;
            r2.writeValue(r0);
            r0 = r1.f7083c;
            r2.writeValue(r0);
            r0 = r1.f7084d;
            r0 = java.lang.Boolean.valueOf(r0);
            r2.writeValue(r0);
            r0 = r1.f7085e;
            r2.writeList(r0);
            r0 = r1.f7086f;
            r2.writeValue(r0);
            r0 = r1.f7087g;
            r0 = java.lang.Boolean.valueOf(r0);
            r2.writeValue(r0);
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bigroad.ttb.android.fragment.DailyLogEditor.Workflow.writeToParcel(android.os.Parcel, int):void");
        }

        public void m10211a() {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r3 = this;
            r2 = 0;
            r1 = 0;
            r0 = com.bigroad.ttb.android.fragment.DailyLogEditor.Workflow.ValidationState.NONE;
            r3.f7081a = r0;
            r0 = com.bigroad.ttb.android.fragment.DailyLogEditor.Workflow.Action.NONE;
            r3.f7082b = r0;
            r3.f7083c = r2;
            r3.f7084d = r1;
            r0 = r3.f7085e;
            r0.clear();
            r3.f7086f = r2;
            r3.f7087g = r1;
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bigroad.ttb.android.fragment.DailyLogEditor.Workflow.a():void");
        }

        public com.bigroad.ttb.android.fragment.DailyLogEditor.Workflow.ValidationState m10216b() {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r1 = this;
            r0 = r1.f7081a;
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bigroad.ttb.android.fragment.DailyLogEditor.Workflow.b():com.bigroad.ttb.android.fragment.DailyLogEditor$Workflow$ValidationState");
        }

        public void m10214a(com.bigroad.ttb.android.fragment.DailyLogEditor.Workflow.ValidationState r2) {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r1 = this;
            r1.f7081a = r2;
            r0 = 0;
            r1.f7084d = r0;
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bigroad.ttb.android.fragment.DailyLogEditor.Workflow.a(com.bigroad.ttb.android.fragment.DailyLogEditor$Workflow$ValidationState):void");
        }

        public void m10212a(com.bigroad.ttb.android.fragment.DailyLogEditor.Workflow.Action r1) {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r0 = this;
            r0.f7082b = r1;
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bigroad.ttb.android.fragment.DailyLogEditor.Workflow.a(com.bigroad.ttb.android.fragment.DailyLogEditor$Workflow$Action):void");
        }

        public com.bigroad.ttb.android.fragment.DailyLogEditor.Workflow.Action m10218c() {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r1 = this;
            r0 = r1.f7082b;
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bigroad.ttb.android.fragment.DailyLogEditor.Workflow.c():com.bigroad.ttb.android.fragment.DailyLogEditor$Workflow$Action");
        }

        public void m10217b(com.bigroad.ttb.android.fragment.DailyLogEditor.Workflow.ValidationState r1) {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r0 = this;
            r0.f7083c = r1;
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bigroad.ttb.android.fragment.DailyLogEditor.Workflow.b(com.bigroad.ttb.android.fragment.DailyLogEditor$Workflow$ValidationState):void");
        }

        public boolean m10219d() {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r2 = this;
            r0 = 0;
            r2.f7084d = r0;
            r1 = r2.f7083c;
            if (r1 == 0) goto L_0x0010;
        L_0x0007:
            r0 = r2.f7083c;
            r2.m10214a(r0);
            r0 = 0;
            r2.f7083c = r0;
            r0 = 1;
        L_0x0010:
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bigroad.ttb.android.fragment.DailyLogEditor.Workflow.d():boolean");
        }

        public boolean m10220e() {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r1 = this;
            r0 = r1.f7084d;
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bigroad.ttb.android.fragment.DailyLogEditor.Workflow.e():boolean");
        }

        public void m10221f() {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r1 = this;
            r0 = 1;
            r1.f7084d = r0;
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bigroad.ttb.android.fragment.DailyLogEditor.Workflow.f():void");
        }

        public java.util.LinkedList<com.bigroad.ttb.android.fragment.DailyLogEditor.Workflow.Reference> m10222g() {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r1 = this;
            r0 = r1.f7085e;
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bigroad.ttb.android.fragment.DailyLogEditor.Workflow.g():java.util.LinkedList<com.bigroad.ttb.android.fragment.DailyLogEditor$Workflow$Reference>");
        }

        public com.bigroad.ttb.android.fragment.DailyLogEditor.Workflow.Reference m10223h() {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r1 = this;
            r0 = r1.f7086f;
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bigroad.ttb.android.fragment.DailyLogEditor.Workflow.h():com.bigroad.ttb.android.fragment.DailyLogEditor$Workflow$Reference");
        }

        public void m10213a(com.bigroad.ttb.android.fragment.DailyLogEditor.Workflow.Reference r1) {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r0 = this;
            r0.f7086f = r1;
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bigroad.ttb.android.fragment.DailyLogEditor.Workflow.a(com.bigroad.ttb.android.fragment.DailyLogEditor$Workflow$Reference):void");
        }

        public boolean m10224i() {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r1 = this;
            r0 = r1.f7087g;
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bigroad.ttb.android.fragment.DailyLogEditor.Workflow.i():boolean");
        }

        public void m10215a(boolean r1) {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r0 = this;
            r0.f7087g = r1;
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bigroad.ttb.android.fragment.DailyLogEditor.Workflow.a(boolean):void");
        }
    }

    public static <T extends FragmentActivity & C1295b> DailyLogEditor m10278a(T t) {
        DailyLogEditor dailyLogEditor = (DailyLogEditor) t.getSupportFragmentManager().mo149a(f7109a);
        if (dailyLogEditor == null) {
            return new DailyLogEditor();
        }
        return dailyLogEditor;
    }

    protected Runnable mo1204g() {
        return this.ad;
    }

    public void onStart() {
        super.onStart();
        this.f7140y.m11399a(this.f7135X);
        this.f7138w.m10974a(this.aa);
        this.f7139x.m6353a(this.ab);
        this.f7141z.m6560a(this.f7136Y, Priority.DEFAULT);
        this.f7112A.m11009a(this.f7137Z);
        this.f7114C.m10534a(this.ac);
        m10260B();
        m10261C();
    }

    public void onStop() {
        super.onStop();
        this.f7140y.m11404b(this.f7135X);
        this.f7138w.m10982b(this.aa);
        this.f7139x.m6354b(this.ab);
        this.f7141z.m6568b(this.f7136Y);
        this.f7112A.m11015b(this.f7137Z);
        this.f7114C.m10539b(this.ac);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        super.onCreateView(layoutInflater, viewGroup, bundle);
        View inflate = layoutInflater.inflate(R.layout.daily_log_editor, null);
        if (bundle == null || !bundle.containsKey(f7110u)) {
            this.f7133V = new Workflow();
        } else {
            this.f7133V = (Workflow) bundle.getParcelable(f7110u);
        }
        if (bundle == null || !bundle.containsKey(f7111v)) {
            this.f7134W = Tab.LOG;
        } else {
            this.f7134W = (Tab) bundle.getSerializable(f7111v);
        }
        this.f7115D = inflate.findViewById(R.id.headerTabs_logTab);
        this.f7116E = this.f7115D.findViewById(R.id.headerTabs_logSelected);
        this.f7117F = inflate.findViewById(R.id.headerTabs_headerTab);
        this.f7118G = this.f7117F.findViewById(R.id.headerTabs_headerSelected);
        this.f7115D.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ DailyLogEditor f7030a;

            {
                this.f7030a = r1;
            }

            public void onClick(View view) {
                this.f7030a.m10279a(Tab.LOG);
            }
        });
        this.f7117F.setOnClickListener(new C20372(this));
        this.e.setOnEditClickedListener(this.ae);
        this.f7128Q = new C1675i((DailyLogEditActivity) getActivity(), this);
        this.f7128Q.m7227a((C1343n) this);
        this.f7129R = new C1664d((DailyLogEditActivity) getActivity(), this);
        this.q.m4027a(this.f7128Q);
        this.f7131T = C2464m.m12117a(getActivity(), R.string.dailyLogHeader_addPastDutyStatus, new C20383(this));
        this.q.m4026a(this.f7131T, true);
        this.f7119H = layoutInflater.inflate(R.layout.daily_log_approved_footer, null);
        this.f7121J = (TextView) this.f7119H.findViewById(R.id.dailyLogApprovedFooter_signatureNotAvailableIndicator);
        this.f7120I = (TextView) this.f7119H.findViewById(R.id.dailyLogApprovedFooter_approvalIndicator);
        if (C1738c.m8512a(this.f7128Q.m7203m())) {
            this.f7120I.setText(getString(R.string.dailyLogApprove_eldMessage, OurApplication.m6285g().m12223m()));
        } else {
            this.f7120I.setText(getString(R.string.dailyLogApprove_aobrdMessage, OurApplication.m6285g().m12223m()));
        }
        ac.m11176a(getActivity(), this.f7120I);
        this.f7122K = (ImageView) this.f7119H.findViewById(R.id.dailyLogApprovedFooter_signatureImageView);
        this.f7122K.setColorFilter(SignatureManager.f4157a);
        ac.m11177a(this.f7119H, this.q);
        this.f7123L = (TextView) C2464m.m12117a(getActivity(), R.string.dailyLog_approveLog, new C20394(this));
        this.f7123L.setCompoundDrawablePadding(Math.round(getResources().getDimension(R.dimen.widget_spacing)));
        this.q.m4026a(this.f7123L, true);
        this.f7124M = C2464m.m12117a(getActivity(), R.string.dailyLog_editLog, new C20405(this));
        this.q.m4026a(this.f7124M, true);
        this.q.m4025a(C2464m.m12116a(getActivity(), R.string.certificationList_title));
        this.f7130S = new C2452b(getContext());
        ac.m11177a(this.f7130S, this.q);
        this.q.m4027a(this.f7129R);
        View a = C2464m.m12116a(getActivity(), R.string.dvirItem_title);
        this.f7132U = C2464m.m12117a(getActivity(), R.string.dailyLogHeader_newInspection, new C20416(this));
        this.f7125N = new View[]{a, this.f7132U};
        this.q.m4025a(a);
        this.q.m4026a(this.f7132U, true);
        a = m10277a(layoutInflater);
        this.q.m4025a(a);
        this.r.m4025a(a);
        m10227a(inflate, this.f7128Q);
        m10279a(this.f7134W);
        ((Button) this.k.findViewById(R.id.unassigned_driving_header_review_button)).setOnClickListener(new C20427(this));
        ((Button) this.l.findViewById(R.id.carrier_edits_header_review_button)).setOnClickListener(new C20438(this));
        this.f7128Q.registerDataSetObserver(new C20449(this));
        this.o.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ DailyLogEditor f7015a;

            {
                this.f7015a = r1;
            }

            public void onClick(View view) {
                this.f7015a.f7128Q.m7242j();
            }
        });
        if (bundle != null) {
            this.f7127P = bundle;
            this.f7128Q.m7232b(bundle);
        } else {
            this.f7127P = null;
        }
        m10260B();
        m10261C();
        m10262D();
        m10265G();
        m10264F();
        return inflate;
    }

    protected void mo1205h() {
        m10260B();
    }

    protected void mo1206i() {
        m10260B();
    }

    private void m10279a(Tab tab) {
        if (tab == Tab.LOG) {
            this.f7115D.setSelected(true);
            this.f7117F.setSelected(false);
            this.f7116E.setVisibility(0);
            this.f7118G.setVisibility(8);
            this.g.setVisibility(0);
            this.j.setAdapter(this.q);
        } else {
            this.f7115D.setSelected(false);
            this.f7117F.setSelected(true);
            this.f7116E.setVisibility(8);
            this.f7118G.setVisibility(0);
            this.g.setVisibility(8);
            this.j.setAdapter(this.r);
        }
        this.f7134W = tab;
    }

    private void m10260B() {
        boolean z = this.b.m10065o().contains(Integer.valueOf(m10243x())) && this.f7140y.m11411i() && this.f7140y.m11407e() != null && this.b.m10064n();
        this.q.m4030b(this.k, z);
        this.r.m4030b(this.k, z);
        if (z) {
            CharSequence string;
            Button button = (Button) this.k.findViewById(R.id.unassigned_driving_header_review_button);
            if (this.b.m10042d(m10242w().getLogDay()) == 1) {
                string = getResources().getString(R.string.unassignedDrivingHeader_singleEventButtonText);
            } else {
                string = getResources().getString(R.string.unassignedDrivingHeader_multipleEventButtonText, new Object[]{Integer.valueOf(this.b.m10042d(m10242w().getLogDay()))});
            }
            button.setText(string);
        }
    }

    private void m10261C() {
        boolean m = m10313m();
        this.q.m4030b(this.l, m);
        this.r.m4030b(this.l, m);
        if (m) {
            Button button = (Button) this.l.findViewById(R.id.carrier_edits_header_review_button);
            String d = this.f7114C.m10541d(m10243x());
            button.setText(getResources().getString(R.string.correctionsHeader_singleEventButtonText, new Object[]{d}));
        }
    }

    public void b_() {
        C1632a.m7947a(getActivity(), m10243x(), m10243x(), DailyLogShareType.MARKETING_SHARE);
    }

    public void mo1194a(boolean z) {
        C1632a.m7928a(getActivity(), m10243x(), z);
    }

    public void mo1202e() {
        C1632a.m8003l(getActivity());
    }

    public void mo1203e(byte[] bArr) {
        C1632a.m7935a(getActivity(), C3642c.m19078a(bArr), m10243x());
    }

    private View m10277a(LayoutInflater layoutInflater) {
        View inflate = layoutInflater.inflate(R.layout.daily_log_footer, null);
        this.f7126O = (Button) inflate.findViewById(R.id.dailyLogFooter_approveAllButton);
        this.f7126O.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ DailyLogEditor f7016a;

            {
                this.f7016a = r1;
            }

            public void onClick(View view) {
                this.f7016a.m10314n();
            }
        });
        ((Button) inflate.findViewById(R.id.dailyLogFooter_emailPrintButton)).setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ DailyLogEditor f7018a;

            {
                this.f7018a = r1;
            }

            public void onClick(View view) {
                this.f7018a.m10316p();
            }
        });
        return inflate;
    }

    public boolean m10310j() {
        return this.e.m11865a();
    }

    public boolean m10311k() {
        switch (this.f7133V.m10218c()) {
            case SIGN_ALL:
            case SEND_ALL:
                return m10318r();
            case SIGN_LOG:
                return C2292l.m11231a(m10242w());
            case SIGN_DVIR:
                return C2292l.m11232a(this.f7138w.m10971a(C3642c.m19078a(this.f7133V.m10223h().m10210a())));
            default:
                return false;
        }
    }

    public void mo1189a() {
        Action c = this.f7133V.m10218c();
        Reference h = this.f7133V.m10223h();
        if (c.m10202a() && !C2292l.m11231a(m10242w())) {
            C2292l.m11227a(m10242w(), true, OurApplication.ac());
        }
        if (c.m10203b()) {
            for (Dvir dvir : this.f7138w.m10973a(m10243x())) {
                boolean z = c == Action.SIGN_ALL || c == Action.SEND_ALL || Arrays.equals(dvir.getId().m19091d(), h.m10210a());
                if (z && !C2292l.m11232a(dvir)) {
                    C2292l.m11229a(dvir, true);
                }
            }
        }
        mo1207s();
    }

    private void m10280a(Action action) {
        m10281a(action, null);
    }

    private void m10281a(Action action, Reference reference) {
        this.f7133V.m10211a();
        this.f7133V.m10212a(action);
        this.f7133V.m10213a(reference);
        this.f7133V.m10214a(ValidationState.START_VALIDATION);
        m10267I();
    }

    private void m10262D() {
        boolean z;
        int i = 0;
        if (this.f7129R.getCount() == 0) {
            z = true;
        } else {
            z = false;
        }
        View[] viewArr = this.f7125N;
        int length = viewArr.length;
        while (i < length) {
            this.q.m4030b(viewArr[i], z);
            i++;
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (this.f7133V != null) {
            bundle.putParcelable(f7110u, this.f7133V);
        }
        bundle.putSerializable(f7111v, this.f7134W);
        this.f7128Q.m7225a(bundle);
    }

    protected void m10293a(Bundle bundle) {
        if (bundle != null) {
            C1643q c = this.f7128Q.m7201c(bundle);
            if (c == null) {
                c = this.f7129R.m7186a(bundle);
            }
            if (c != null) {
                mo957a(c);
            }
        }
    }

    private void m10286b(final ValidationState validationState) {
        this.t.add(new Runnable(this) {
            final /* synthetic */ DailyLogEditor f7020b;

            public void run() {
                this.f7020b.mo1192a(validationState);
            }
        });
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        switch (i) {
            case 10:
                if (i2 == -1 && intent != null && intent.hasExtra("com.bigroad.ttb.eventId")) {
                    mo1208t();
                    mo957a(this.f7128Q.m7198a(intent.getByteArrayExtra("com.bigroad.ttb.eventId")));
                    return;
                } else if (i2 == 6) {
                    ErrorDialogFragment.m8860a((OurActivity) getActivity(), (int) R.string.dutyStatusDialog_noFreeSpaceDutyStatusTitle, (int) R.string.dutyStatusDialog_noFreeSpaceDutyStatusMessage);
                    mo957a(null);
                    return;
                } else {
                    return;
                }
            case 11:
                if (i2 != 3 && intent != null && intent.hasExtra("com.bigroad.ttb.eventId")) {
                    mo957a(this.f7128Q.m7198a(intent.getByteArrayExtra("com.bigroad.ttb.eventId")));
                } else if (i2 == 3) {
                    mo957a(null);
                }
                if (this.f7133V.m10216b() != ValidationState.FIX_EVENT_WARNING || i2 == 0) {
                    this.f7133V.m10211a();
                    return;
                } else {
                    m10286b(ValidationState.FIX_EVENT_WARNING);
                    return;
                }
            case 16:
                if (i2 == 0) {
                    this.f7133V.m10211a();
                    return;
                } else if (this.f7133V.m10216b() == ValidationState.CREATE_HEADER) {
                    m10286b(ValidationState.CREATE_HEADER_COMPLETE);
                    return;
                } else if (this.f7133V.m10216b() == ValidationState.FIX_HEADER_WARNINGS) {
                    m10286b(ValidationState.FIX_HEADER_WARNINGS_COMPLETE);
                    return;
                } else {
                    this.f7133V.m10211a();
                    return;
                }
            case 17:
            case 18:
                DvirInspection parseFrom;
                if (intent != null && intent.hasExtra("com.bigroad.ttb.dvirInspection")) {
                    try {
                        parseFrom = DvirInspection.parseFrom(intent.getByteArrayExtra("com.bigroad.ttb.dvirInspection"));
                    } catch (InvalidProtocolBufferException e) {
                        C2134e.m10680d("TT-DailyLogEditor", "Could not unpack DVIR inspection result: " + e);
                    }
                    if (i2 != -1 && parseFrom != null) {
                        C1643q a = this.f7129R.m7187a(parseFrom.getId());
                        if (a != null) {
                            mo957a(a);
                        }
                    } else if (i2 == 3) {
                        mo957a(null);
                    }
                    if (this.f7133V.m10216b() == ValidationState.FIX_DVIR_WARNING || i2 == 0) {
                        this.f7133V.m10211a();
                        return;
                    } else {
                        m10286b(ValidationState.FIX_DVIR_WARNING);
                        return;
                    }
                }
                parseFrom = null;
                if (i2 != -1) {
                }
                if (i2 == 3) {
                    mo957a(null);
                }
                if (this.f7133V.m10216b() == ValidationState.FIX_DVIR_WARNING) {
                }
                this.f7133V.m10211a();
                return;
            case 19:
                if (this.f7133V.m10216b() != ValidationState.FIX_DVIR_WARNING || i2 == 0) {
                    this.f7133V.m10211a();
                    return;
                } else {
                    m10286b(ValidationState.FIX_DVIR_WARNING);
                    return;
                }
            case 22:
                if (this.f7133V.m10216b() == ValidationState.UPDATE_PROFILE) {
                    m10286b(ValidationState.UPDATE_PROFILE_COMPLETE);
                    return;
                } else {
                    this.f7133V.m10211a();
                    return;
                }
            case 24:
                if (this.f7133V.m10216b() == ValidationState.CREATE_SIGNATURE || this.f7133V.m10216b() == ValidationState.ACTUALLY_SIGN_ITEM) {
                    m10286b(ValidationState.CREATE_SIGNATURE);
                    return;
                } else {
                    this.f7133V.m10211a();
                    return;
                }
            default:
                return;
        }
    }

    protected boolean m10312l() {
        return !this.f7140y.m11413k();
    }

    protected boolean m10313m() {
        return this.f7114C.m10540c(m10243x());
    }

    private void m10263E() {
        if (m10312l()) {
            long b = OurApplication.m6269Z().mo914b();
            if (m10243x() < DailyLogUtils.m4285a(m10232b())) {
                C0889h c0889h = null;
                if (!this.f7128Q.isEmpty()) {
                    for (int count = this.f7128Q.getCount() - 1; count >= 0; count--) {
                        DisplayedRow a = this.f7128Q.m7196a(count);
                        if (a.m8090a()) {
                            c0889h = a.m8092b();
                        }
                    }
                }
                b = DailyLogUtils.m4287a(new C0907o(m10232b(), m10243x()), c0889h);
            }
            C1632a.m7926a(getActivity(), m10243x(), b, false, false);
            return;
        }
        ErrorDialogFragment.m8860a((OurActivity) getActivity(), (int) R.string.dutyStatusDialog_cantEditDutyStatusTitle, (int) R.string.dutyStatusDialog_cantEditDutyStatusMessage);
    }

    public void mo1190a(DisplayedRow displayedRow) {
        if (m10312l()) {
            Event g = displayedRow.m8097g();
            if (g == null || g.getEventId().mo2752b() == 0) {
                C2134e.m10682e("TT-DailyLogEditor", "Unexpected attempt to edit pseudo-event");
                return;
            } else {
                C1632a.m7929a(getActivity(), m10243x(), g.getEventId().m19091d(), false);
                return;
            }
        }
        ErrorDialogFragment.m8860a((OurActivity) getActivity(), (int) R.string.dutyStatusDialog_cantEditDutyStatusTitle, (int) R.string.dutyStatusDialog_cantEditDutyStatusMessage);
    }

    private boolean m10291f(byte[] bArr) {
        if (bArr.length > 0) {
            C1632a.m7929a(getActivity(), m10243x(), bArr, true);
            return true;
        }
        C2134e.m10682e("TT-DailyLogEditor", "Unexpected attempt to edit pseudo-event");
        return false;
    }

    public void mo1191a(C1679c c1679c) {
        C1632a.m7965a((OurActivity) getActivity(), c1679c.m8218e(), false);
    }

    public void m10314n() {
        m10280a(Action.SIGN_ALL);
    }

    public void m10315o() {
        m10280a(Action.SIGN_LOG);
    }

    public void mo1195a(byte[] bArr) {
        m10281a(Action.SIGN_DVIR, new Reference(Type.DVIR, bArr));
    }

    public void m10316p() {
        m10280a(Action.SEND_ALL);
    }

    public void m10317q() {
        C2292l.m11227a(m10242w(), false, OurApplication.ac());
    }

    public void mo1196b(byte[] bArr) {
        DialogFragment editApprovedDvirDialogFragment = new EditApprovedDvirDialogFragment();
        editApprovedDvirDialogFragment.m8847a(bArr);
        DailyLogDetailsDialogs.m8856a(getActivity(), editApprovedDvirDialogFragment);
    }

    public void mo1199c(byte[] bArr) {
        DialogFragment editApprovedNewDvirDialogFragment = new EditApprovedNewDvirDialogFragment();
        editApprovedNewDvirDialogFragment.m8847a(bArr);
        DailyLogDetailsDialogs.m8856a(getActivity(), editApprovedNewDvirDialogFragment);
    }

    public void mo1201d(byte[] bArr) {
        for (Dvir dvir : this.f7138w.m10973a(m10243x())) {
            if (Arrays.equals(dvir.getId().m19091d(), bArr)) {
                C2292l.m11229a(dvir, false);
                return;
            }
        }
    }

    private void m10264F() {
        boolean z = true;
        this.f7123L.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        this.f7120I.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        this.f7121J.setVisibility(8);
        this.f7122K.setVisibility(8);
        boolean a = C1738c.m8511a(m10242w(), this.f7128Q.m7203m());
        boolean a2 = C1738c.m8512a(this.f7128Q.m7203m());
        boolean a3 = C2292l.m11231a(m10242w());
        if (a3) {
            CharSequence string;
            if (a2) {
                string = getString(R.string.dailyLogApprove_eldMessage, OurApplication.m6285g().m12223m());
            } else if (a) {
                string = getString(R.string.dailyLogApprove_aobrdMessage, OurApplication.m6285g().m12223m());
            } else {
                string = getString(R.string.dailyLogApprove_message, OurApplication.m6285g().m12223m());
            }
            this.f7120I.setText(string);
            if (C2292l.m11233b(m10242w())) {
                Bitmap b = SignatureManager.m6336b(C2292l.m11235c(m10242w()));
                if (b != null) {
                    this.f7122K.setImageBitmap(b);
                    this.f7122K.setVisibility(0);
                } else {
                    this.f7121J.setVisibility(0);
                }
            } else {
                this.f7120I.setCompoundDrawablesWithIntrinsicBounds(((OurActivity) getActivity()).m6714c(5), 0, 0, 0);
            }
        }
        this.q.m4030b(this.f7119H, a3);
        C0816a c0816a = this.q;
        View view = this.f7123L;
        if (a3 || m10313m()) {
            a = false;
        } else {
            a = true;
        }
        c0816a.m4030b(view, a);
        C0816a c0816a2 = this.q;
        View view2 = this.f7124M;
        if (m10313m() || !a3) {
            z = false;
        }
        c0816a2.m4030b(view2, z);
    }

    public void mo1193a(DailyLog dailyLog, boolean z) {
        if (m10233b(dailyLog, z)) {
            C0956v c0956v = new C0956v((al) dailyLog);
            this.e.m11860a(dailyLog.getLogDay(), dailyLog, C1114a.m5598a(dailyLog, OurApplication.af(), this.f7113B.mo914b()).m5635a(), z, true, MissingHeader.SHOW);
            this.g.setHosSettings(c0956v);
            mo1207s();
            m10260B();
            m10261C();
            m10293a(this.f7127P);
            this.f7127P = null;
        }
    }

    private void m10265G() {
        this.f7126O.setVisibility(m10318r() ? 8 : 0);
    }

    public boolean m10318r() {
        if (!C2292l.m11231a(m10242w())) {
            return false;
        }
        for (Dvir a : this.f7138w.m10973a(m10243x())) {
            if (!C2292l.m11232a(a)) {
                return false;
            }
        }
        return true;
    }

    public void mo1207s() {
        DailyLogHeaderView dailyLogHeaderView = this.e;
        boolean z = (m10241v() || m10313m()) ? false : true;
        dailyLogHeaderView.setIsEditable(z);
        mo1208t();
        m10266H();
        m10264F();
        m10265G();
        mo1209u();
    }

    protected void mo1208t() {
        boolean z;
        boolean z2 = true;
        int x = m10243x();
        TimeZone b = m10232b();
        boolean v = m10241v();
        List a = new C0886a(this.b.m10061k(), x, b).m4478a(v).m4479a(this.f7113B.mo914b());
        List a2 = C1130o.m5709a(this.b.m10025b(), m10243x(), m10232b());
        List d = this.c.m11305d(x);
        List e = this.c.m11306e(x);
        C1404e c1404e = this.f7128Q;
        boolean z3 = v || m10313m();
        c1404e.m7230a(a, a2, d, e, z3);
        this.f7130S.m12083a(b, this.f7128Q.m7202l(), this.b.m10007a(x));
        C0816a c0816a = this.q;
        ListAdapter listAdapter = this.f7128Q;
        if (this.f7128Q.isEmpty()) {
            z = false;
        } else {
            z = true;
        }
        c0816a.m4028a(listAdapter, z);
        m10245z();
        this.g.m11849a(a, d);
        c0816a = this.q;
        View view = this.f7131T;
        if (v || m10313m()) {
            z = false;
        } else {
            z = true;
        }
        c0816a.m4030b(view, z);
        if (!e.isEmpty()) {
            this.h.setText(getResources().getQuantityString(R.plurals.dailyLog_canadianMalfunctionCount, e.size(), new Object[]{Integer.valueOf(e.size())}));
        }
        c0816a = this.q;
        view = this.h;
        if (e.isEmpty()) {
            z = false;
        } else {
            z = true;
        }
        c0816a.m4030b(view, z);
        C0816a c0816a2 = this.q;
        View view2 = this.n;
        if (this.f7128Q.m7239g() <= 0) {
            z2 = false;
        }
        c0816a2.m4030b(view2, z2);
        m10231a(a);
        m10226A();
    }

    private void m10266H() {
        this.f7129R.m7189a(this.f7138w.m10973a(m10243x()), false, true);
        m10245z();
        m10265G();
        m10262D();
    }

    protected void mo1209u() {
        super.mo1209u();
        this.f7123L.setCompoundDrawablesWithIntrinsicBounds(C2091e.m10475a(C1178r.m5973a(this.c.m11307f(m10243x()), ValidationError.f3855c)), 0, 0, 0);
    }

    private void m10267I() {
        if (this.f7133V.m10216b() != ValidationState.NONE && !this.f7133V.m10220e()) {
            do {
                m10276R();
                if (this.f7133V.m10220e()) {
                    return;
                }
            } while (this.f7133V.m10219d());
        }
    }

    public void mo1192a(ValidationState validationState) {
        if (this.f7133V.m10220e()) {
            this.f7133V.m10214a(validationState);
            m10267I();
            return;
        }
        this.f7133V.m10211a();
    }

    public void mo1200d() {
        if (this.f7133V.m10219d()) {
            m10267I();
        }
    }

    public void mo1198c() {
        this.f7133V.m10211a();
    }

    private boolean m10268J() {
        Person l = OurApplication.m6285g().m12222l();
        return (l == null || am.m4188a(l.getEmailAddress()) || (am.m4188a(l.getFirstName()) && am.m4188a(l.getLastName()))) ? false : true;
    }

    private boolean m10269K() {
        switch (this.f7133V.m10218c()) {
            case SIGN_ALL:
            case SEND_ALL:
                if (m10270L() || m10271M() || m10272N() || m10274P()) {
                    return true;
                }
                return false;
            case SIGN_LOG:
                if (m10270L() || m10271M() || m10274P()) {
                    return true;
                }
                return false;
            case SIGN_DVIR:
                return m10272N();
            default:
                return false;
        }
    }

    private boolean m10270L() {
        if (!m10310j()) {
            return false;
        }
        com.bigroad.shared.validation.model.DailyLog c = this.c.m11304c(m10243x());
        if (c == null || c.mo861e()) {
            return false;
        }
        DailyLogHeader b = c.mo858b();
        if (b == null || !b.mo718a(Severity.f3853d)) {
            return false;
        }
        return true;
    }

    private boolean m10271M() {
        com.bigroad.shared.validation.model.DailyLog c = this.c.m11304c(m10243x());
        if (c == null || c.mo861e()) {
            return false;
        }
        for (com.bigroad.shared.validation.model.Event a : c.mo859c()) {
            if (a.mo718a(Severity.f3853d)) {
                return true;
            }
        }
        return false;
    }

    private void m10284a(LinkedList<Reference> linkedList) {
        linkedList.clear();
        com.bigroad.shared.validation.model.DailyLog c = this.c.m11304c(m10243x());
        if (c != null) {
            for (com.bigroad.shared.validation.model.Event event : c.mo859c()) {
                if (event.mo718a(Severity.f3853d)) {
                    linkedList.add(new Reference(Type.EVENT, event.mo719s()));
                }
            }
        }
    }

    private boolean m10272N() {
        Action c = this.f7133V.m10218c();
        Reference h = this.f7133V.m10223h();
        com.bigroad.shared.validation.model.DailyLog c2 = this.c.m11304c(m10243x());
        if (c2 == null) {
            return false;
        }
        for (com.bigroad.shared.validation.model.Dvir dvir : c2.mo860d()) {
            if ((c != Action.SIGN_DVIR || Arrays.equals(h.m10210a(), dvir.mo851a())) && !dvir.mo856f() && m10285a(dvir)) {
                return true;
            }
        }
        return false;
    }

    private boolean m10285a(com.bigroad.shared.validation.model.Dvir dvir) {
        if (C1178r.m5977a((C0887n) dvir, new ErrorCode[]{ErrorCode.DVIR_NOT_SIGNED})) {
            return true;
        }
        for (com.bigroad.shared.validation.model.DvirInspection a : dvir.mo855e()) {
            if (a.mo718a(Severity.f3853d)) {
                return true;
            }
        }
        return false;
    }

    private void m10273O() {
        LinkedList g = this.f7133V.m10222g();
        Action c = this.f7133V.m10218c();
        Reference h = this.f7133V.m10223h();
        g.clear();
        com.bigroad.shared.validation.model.DailyLog c2 = this.c.m11304c(m10243x());
        if (c2 != null) {
            for (com.bigroad.shared.validation.model.Dvir dvir : c2.mo860d()) {
                if ((c != Action.SIGN_DVIR || Arrays.equals(h.m10210a(), dvir.mo851a())) && !dvir.mo856f()) {
                    if (C1178r.m5977a((C0887n) dvir, new ErrorCode[]{ErrorCode.DVIR_NOT_SIGNED})) {
                        g.add(new Reference(Type.DVIR, dvir.mo851a()));
                    }
                    for (com.bigroad.shared.validation.model.DvirInspection dvirInspection : dvir.mo855e()) {
                        if (dvirInspection.mo718a(Severity.f3853d)) {
                            g.add(new Reference(Type.INSPECTION, dvirInspection.mo844a()));
                        }
                    }
                }
            }
        }
    }

    private boolean m10274P() {
        com.bigroad.shared.validation.model.DailyLog c = this.c.m11304c(m10243x());
        if (c == null || c.mo861e()) {
            return false;
        }
        return c.mo716A().m5958a(Category.DRIVE_TIME);
    }

    private void m10275Q() {
        for (int i = 0; i < this.q.getCount(); i++) {
            Object item = this.q.getItem(i);
            if (item instanceof DisplayedRow) {
                DisplayedRow displayedRow = (DisplayedRow) item;
                if (displayedRow.m8090a() && displayedRow.m8092b().m8117D()) {
                    mo957a((C1643q) displayedRow);
                    return;
                }
            }
        }
    }

    private void m10276R() {
        boolean z = false;
        Action c = this.f7133V.m10218c();
        boolean c2 = c.m10204c();
        boolean d = c.m10205d();
        boolean a = C1738c.m8511a(m10242w(), this.f7128Q.m7203m());
        boolean a2 = C1738c.m8512a(this.f7128Q.m7203m());
        DialogFragment fixAllWarningsDialogFragment;
        switch (this.f7133V.m10216b()) {
            case START_VALIDATION:
                if (!c2 || m10268J()) {
                    this.f7133V.m10217b(ValidationState.CREATE_HEADER);
                    return;
                } else {
                    this.f7133V.m10217b(ValidationState.UPDATE_PROFILE);
                    return;
                }
            case UPDATE_PROFILE:
                C1632a.m7997i(getActivity());
                this.f7133V.m10221f();
                return;
            case UPDATE_PROFILE_COMPLETE:
                if (!c2 || m10268J()) {
                    this.f7133V.m10217b(ValidationState.CREATE_HEADER);
                    return;
                }
                ErrorDialogFragment.m8860a((OurActivity) getActivity(), (int) R.string.dailyLogApprove_noNameTitle, (int) R.string.dailyLogApprove_noNameMessage);
                this.f7133V.m10211a();
                return;
            case CREATE_HEADER:
                this.f7133V.m10217b(ValidationState.CREATE_HEADER_COMPLETE);
                if (c.m10202a() && !m10310j()) {
                    if (c2) {
                        DailyLogDetailsDialogs.m8856a(getActivity(), new ConfirmNoHeaderApprovalDialogFragment());
                    } else {
                        DailyLogDetailsDialogs.m8856a(getActivity(), new ConfirmNoHeaderSendDialogFragment());
                    }
                    this.f7133V.m10221f();
                    return;
                }
                return;
            case CREATE_HEADER_COMPLETE:
                if (!c2 || m10310j()) {
                    this.f7133V.m10217b(ValidationState.PROMPT_FIX_WARNINGS);
                    return;
                } else {
                    this.f7133V.m10211a();
                    return;
                }
            case PROMPT_FIX_WARNINGS:
                this.f7133V.m10217b(ValidationState.AFTER_FIX_WARNINGS);
                if (!m10311k() && m10269K()) {
                    fixAllWarningsDialogFragment = new FixAllWarningsDialogFragment();
                    fixAllWarningsDialogFragment.m8837a(this.f7133V);
                    DailyLogDetailsDialogs.m8856a(getActivity(), fixAllWarningsDialogFragment);
                    this.f7133V.m10221f();
                    return;
                }
                return;
            case START_FIX_WARNINGS:
                this.f7133V.m10215a(true);
                this.f7133V.m10217b(ValidationState.FIX_HEADER_WARNINGS);
                return;
            case FIX_HEADER_WARNINGS:
                if (c.m10202a() && m10270L()) {
                    mo1194a(true);
                    this.f7133V.m10221f();
                    return;
                }
                this.f7133V.m10217b(ValidationState.FIX_HEADER_WARNINGS_COMPLETE);
                return;
            case FIX_HEADER_WARNINGS_COMPLETE:
                this.f7133V.m10217b(ValidationState.START_FIX_EVENT_WARNINGS);
                return;
            case START_FIX_EVENT_WARNINGS:
                if (c.m10202a() && m10271M()) {
                    m10284a(this.f7133V.m10222g());
                    this.f7133V.m10217b(ValidationState.FIX_EVENT_WARNING);
                    return;
                }
                this.f7133V.m10217b(ValidationState.FIX_EVENT_WARNINGS_COMPLETE);
                return;
            case FIX_EVENT_WARNING:
                LinkedList g = this.f7133V.m10222g();
                if (!m10312l()) {
                    fixAllWarningsDialogFragment = new CantEditDutyStatusDialogFragment();
                    fixAllWarningsDialogFragment.m8837a(this.f7133V);
                    DailyLogDetailsDialogs.m8856a(getActivity(), fixAllWarningsDialogFragment);
                    this.f7133V.m10221f();
                    return;
                } else if (g.isEmpty()) {
                    this.f7133V.m10217b(ValidationState.FIX_EVENT_WARNINGS_COMPLETE);
                    return;
                } else if (m10291f(((Reference) g.removeFirst()).f7053b)) {
                    this.f7133V.m10221f();
                    return;
                } else {
                    this.f7133V.m10217b(ValidationState.FIX_EVENT_WARNING);
                    return;
                }
            case FIX_EVENT_WARNINGS_COMPLETE:
                this.f7133V.m10222g().clear();
                this.f7133V.m10217b(ValidationState.START_FIX_DVIR_WARNINGS);
                return;
            case START_FIX_DVIR_WARNINGS:
                if (c.m10203b() && m10272N()) {
                    m10273O();
                    this.f7133V.m10217b(ValidationState.FIX_DVIR_WARNING);
                    return;
                }
                this.f7133V.m10217b(ValidationState.FIX_DVIR_WARNINGS_COMPLETE);
                return;
            case FIX_DVIR_WARNING:
                LinkedList g2 = this.f7133V.m10222g();
                if (!g2.isEmpty()) {
                    Reference reference = (Reference) g2.removeFirst();
                    if (reference.f7052a == Type.DVIR) {
                        C1632a.m7936a(getActivity(), C3642c.m19078a(reference.f7053b), true);
                    } else {
                        DvirInspection c3 = this.f7138w.m10986c(C3642c.m19078a(reference.f7053b));
                        if (c3 != null) {
                            z = C1632a.m7965a((OurActivity) getActivity(), c3, true);
                        }
                        if (!z) {
                            this.f7133V.m10217b(ValidationState.FIX_DVIR_WARNING);
                            return;
                        }
                    }
                    this.f7133V.m10221f();
                    return;
                } else if (d || ((c == Action.SIGN_ALL && !m10318r()) || (c == Action.SIGN_DVIR && this.f7138w.m10979a(this.f7133V.m10223h().m10210a())))) {
                    this.f7133V.m10217b(ValidationState.FIX_DVIR_WARNINGS_COMPLETE);
                    return;
                } else {
                    this.f7133V.m10211a();
                    return;
                }
            case FIX_DVIR_WARNINGS_COMPLETE:
                this.f7133V.m10222g().clear();
                this.f7133V.m10217b(ValidationState.FIX_DRIVE_TIME_VIOLATION_WARNINGS);
                return;
            case FIX_DRIVE_TIME_VIOLATION_WARNINGS:
                if (c.m10202a() && m10274P()) {
                    m10275Q();
                    this.f7133V.m10211a();
                    return;
                }
                this.f7133V.m10217b(ValidationState.AFTER_FIX_WARNINGS);
                return;
            case AFTER_FIX_WARNINGS:
                this.f7133V.m10217b(ValidationState.IS_SIGNED_CHECK);
                return;
            case IS_SIGNED_CHECK:
                if (m10318r() && d) {
                    this.f7133V.m10217b(ValidationState.SEND_LOG);
                    return;
                } else if (m10318r()) {
                    this.f7133V.m10211a();
                    return;
                } else if (c2) {
                    this.f7133V.m10217b(ValidationState.CREATE_SIGNATURE);
                    return;
                } else {
                    this.f7133V.m10217b(ValidationState.IS_SIGNED_CHECK);
                    if (m10310j() && m10268J()) {
                        fixAllWarningsDialogFragment = new ConfirmNotApprovedWithHeaderSendDialogFragment();
                    } else {
                        fixAllWarningsDialogFragment = new ConfirmNotApprovedNoHeaderSendDialogFragment();
                    }
                    fixAllWarningsDialogFragment.m8837a(this.f7133V);
                    DailyLogDetailsDialogs.m8856a(getActivity(), fixAllWarningsDialogFragment);
                    this.f7133V.m10221f();
                    return;
                }
            case CREATE_SIGNATURE:
                if (SignatureManager.m6342d()) {
                    this.f7133V.m10217b(ValidationState.CREATE_SIGNATURE_COMPLETE);
                    return;
                }
                this.f7133V.m10217b(ValidationState.CREATE_SIGNATURE_COMPLETE);
                fixAllWarningsDialogFragment = new ConfirmNoSignatureApprovalDialogFragment();
                fixAllWarningsDialogFragment.m8837a(this.f7133V);
                DailyLogDetailsDialogs.m8856a(getActivity(), fixAllWarningsDialogFragment);
                this.f7133V.m10221f();
                return;
            case CREATE_SIGNATURE_COMPLETE:
                if (SignatureManager.m6342d()) {
                    this.f7133V.m10217b(ValidationState.SIGN_ITEM);
                    return;
                } else if (d) {
                    this.f7133V.m10217b(ValidationState.IS_SIGNED_CHECK);
                    return;
                } else {
                    this.f7133V.m10211a();
                    return;
                }
            case SIGN_ITEM:
                this.f7133V.m10217b(ValidationState.ACTUALLY_SIGN_ITEM);
                if (this.f7133V.m10224i() && m10269K()) {
                    fixAllWarningsDialogFragment = new ActionWithWarningsDialogFragment();
                    fixAllWarningsDialogFragment.m8837a(this.f7133V);
                    DailyLogDetailsDialogs.m8856a(getActivity(), fixAllWarningsDialogFragment);
                    this.f7133V.m10221f();
                    return;
                }
                return;
            case ACTUALLY_SIGN_ITEM:
                boolean z2;
                this.f7133V.m10217b(ValidationState.SIGN_ITEM_COMPLETE);
                DialogFragment doApprovalLogDialogFragment = new DoApprovalLogDialogFragment();
                doApprovalLogDialogFragment.m8837a(this.f7133V);
                if (this.f7129R.isEmpty()) {
                    z2 = false;
                } else {
                    z2 = true;
                }
                doApprovalLogDialogFragment.m8844a(z2);
                doApprovalLogDialogFragment.m8846c(a2);
                doApprovalLogDialogFragment.m8845b(a);
                DailyLogDetailsDialogs.m8856a(getActivity(), doApprovalLogDialogFragment);
                this.f7133V.m10221f();
                return;
            case SIGN_ITEM_COMPLETE:
                if (d && m10318r()) {
                    this.f7133V.m10217b(ValidationState.SEND_LOG);
                    return;
                } else {
                    this.f7133V.m10211a();
                    return;
                }
            case SEND_LOG:
                this.f7133V.m10217b(ValidationState.ACTUALLY_SEND_LOG);
                if (this.f7133V.m10224i() && !m10318r() && m10269K()) {
                    fixAllWarningsDialogFragment = new ActionWithWarningsDialogFragment();
                    fixAllWarningsDialogFragment.m8837a(this.f7133V);
                    DailyLogDetailsDialogs.m8856a(getActivity(), fixAllWarningsDialogFragment);
                    this.f7133V.m10221f();
                    return;
                }
                return;
            case ACTUALLY_SEND_LOG:
                DailyLogDetailsDialogs.m8856a(getActivity(), new SendLogDialogFragment());
                this.f7133V.m10211a();
                return;
            case NONE:
                this.f7133V.m10211a();
                return;
            default:
                C2134e.m10682e("TT-DailyLogEditor", "Unexpected validation state: " + this.f7133V.m10216b());
                this.f7133V.m10211a();
                return;
        }
    }
}
