package com.bigroad.ttb.android.dialog;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.C0586c.C0584a;
import com.bigroad.ttb.android.R;
import com.bigroad.ttb.android.adapter.C1689n;
import com.bigroad.ttb.protocol.TTProtocol.Fleet;
import com.bigroad.ttb.protocol.TTProtocol.FleetList;
import com.google.protobuf.InvalidProtocolBufferException;
import java.util.List;

public class SelectFleetDialogFragment extends DialogFragment {
    private C1689n f6272a;
    private C1588a f6273b;

    public interface C1588a {
        void mo1026a(long j);

        void mo974h();
    }

    class C18361 implements OnCancelListener {
        final /* synthetic */ SelectFleetDialogFragment f6269a;

        C18361(SelectFleetDialogFragment selectFleetDialogFragment) {
            this.f6269a = selectFleetDialogFragment;
        }

        public void onCancel(DialogInterface dialogInterface) {
            if (this.f6269a.f6273b != null) {
                this.f6269a.f6273b.mo974h();
            }
        }
    }

    class C18372 implements OnClickListener {
        final /* synthetic */ SelectFleetDialogFragment f6270a;

        C18372(SelectFleetDialogFragment selectFleetDialogFragment) {
            this.f6270a = selectFleetDialogFragment;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            if (this.f6270a.f6273b != null) {
                this.f6270a.f6273b.mo1026a(this.f6270a.f6272a.m8248b());
            }
        }
    }

    class C18383 implements OnClickListener {
        final /* synthetic */ SelectFleetDialogFragment f6271a;

        C18383(SelectFleetDialogFragment selectFleetDialogFragment) {
            this.f6271a = selectFleetDialogFragment;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            this.f6271a.f6272a.m8246a(i);
        }
    }

    public static SelectFleetDialogFragment m8902a(List<Fleet> list, long j) {
        SelectFleetDialogFragment selectFleetDialogFragment = new SelectFleetDialogFragment();
        FleetList c = FleetList.newBuilder().mo1377a((Iterable) list).m14064c();
        Bundle bundle = new Bundle();
        bundle.putLong("ARG_LAST_FLEET", j);
        bundle.putByteArray("ARG_FLEET_LIST", c.toByteArray());
        selectFleetDialogFragment.setArguments(bundle);
        return selectFleetDialogFragment;
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            this.f6273b = (C1588a) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString() + " must implement " + getClass().getName() + ".Listener");
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f6272a = new C1689n(getActivity(), 17367058);
        Bundle arguments = getArguments();
        if (arguments != null) {
            FleetList parseFrom;
            try {
                parseFrom = FleetList.parseFrom(arguments.getByteArray("ARG_FLEET_LIST"));
            } catch (InvalidProtocolBufferException e) {
                e.printStackTrace();
                parseFrom = FleetList.newBuilder().m14064c();
            }
            this.f6272a.m8247a(parseFrom);
            this.f6272a.m8246a(this.f6272a.m8245a(arguments.getLong("ARG_LAST_FLEET")));
        }
    }

    public Dialog onCreateDialog(Bundle bundle) {
        return new C0584a(getActivity()).m2678c(R.drawable.ic_dialog_info_light).m2659a((int) R.string.signIn_selectFleet).m2666a(this.f6272a, this.f6272a.m8244a(), new C18383(this)).m2661a(17039370, new C18372(this)).m2673b(17039360, C1843a.f6286a).m2662a(new C18361(this)).m2677b();
    }
}
