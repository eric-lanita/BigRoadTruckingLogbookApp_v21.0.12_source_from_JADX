package com.bigroad.ttb.android.activity;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.bigroad.shared.C1180y;
import com.bigroad.shared.duty.DutyStatus;
import com.bigroad.shared.eobr.C0972e;
import com.bigroad.shared.eobr.C0973f;
import com.bigroad.ttb.android.OurApplication;
import com.bigroad.ttb.android.R;
import com.bigroad.ttb.android.eobr.C1902e.C1206c;
import com.bigroad.ttb.android.eobr.EobrDevice;
import com.bigroad.ttb.android.event.EventManager;
import com.bigroad.ttb.android.event.EventManager.C1199e;
import com.bigroad.ttb.android.event.EventManager.ChangeListener;
import com.bigroad.ttb.android.logging.C2134e;
import com.bigroad.ttb.android.widget.C2468r;
import com.bigroad.ttb.android.widget.C2468r.C1303a;
import com.bigroad.ttb.protocol.TTProtocol.ContinueDrivingPromptResponse;
import com.bigroad.ttb.protocol.TTProtocol.Event;
import com.bigroad.ttb.protocol.TTProtocol.ExternalVarEntry;
import com.bigroad.ttb.protocol.TTProtocol.ExternalVarEntryType;

public class ContinueDrivingPromptActivity extends OurActivity {
    private final EventManager f4473a = OurApplication.m6295q();
    private C2468r f4474b;
    private Event f4475c;
    private final ChangeListener f4476d = new C13141(this);

    class C13141 extends C1199e {
        final /* synthetic */ ContinueDrivingPromptActivity f4468a;

        C13141(ContinueDrivingPromptActivity continueDrivingPromptActivity) {
            this.f4468a = continueDrivingPromptActivity;
        }

        public void mo884a(EventManager eventManager, boolean z) {
            this.f4468a.m6842f();
        }
    }

    class C13152 implements OnClickListener {
        final /* synthetic */ ContinueDrivingPromptActivity f4469a;

        C13152(ContinueDrivingPromptActivity continueDrivingPromptActivity) {
            this.f4469a = continueDrivingPromptActivity;
        }

        public void onClick(View view) {
            this.f4469a.m6843h();
        }
    }

    class C13163 implements OnClickListener {
        final /* synthetic */ ContinueDrivingPromptActivity f4470a;

        C13163(ContinueDrivingPromptActivity continueDrivingPromptActivity) {
            this.f4470a = continueDrivingPromptActivity;
        }

        public void onClick(View view) {
            this.f4470a.m6844i();
        }
    }

    class C13174 implements C1303a {
        final /* synthetic */ ContinueDrivingPromptActivity f4471a;

        C13174(ContinueDrivingPromptActivity continueDrivingPromptActivity) {
            this.f4471a = continueDrivingPromptActivity;
        }

        public void mo947a() {
            this.f4471a.finish();
        }
    }

    class C13185 implements C1206c {
        final /* synthetic */ ContinueDrivingPromptActivity f4472a;

        C13185(ContinueDrivingPromptActivity continueDrivingPromptActivity) {
            this.f4472a = continueDrivingPromptActivity;
        }

        public void mo897a(C0972e c0972e, C0973f c0973f) {
            if (c0973f == null || !c0973f.mo744f()) {
                C2134e.m10680d("TT-CDPrompt", "Failed to persist prompt response to the VAR");
            }
        }
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.continue_driving_prompt);
        int intExtra = getIntent().getIntExtra("com.bigroad.ttb.promptTimeout", 0);
        if (intExtra < 1) {
            C2134e.m10680d("TT-CDPrompt", "Couldn't show prompt, duration too short");
            finish();
        }
        byte[] byteArrayExtra = getIntent().getByteArrayExtra("com.bigroad.ttb.eventId");
        this.f4475c = this.f4473a.m10005a(byteArrayExtra);
        if (this.f4475c == null) {
            C2134e.m10680d("TT-CDPrompt", "Couldn't find event " + C1180y.m5990a(byteArrayExtra) + " to prompt about");
            finish();
        }
        m6842f();
        this.f4474b = new C2468r(findViewById(R.id.continueDrivingPrompt_contentWrapper), intExtra, 0);
        Button button = (Button) findViewById(R.id.continueDrivingPrompt_stopDrivingButton);
        ((Button) findViewById(R.id.continueDrivingPrompt_continueDrivingButton)).setOnClickListener(new C13152(this));
        button.setOnClickListener(new C13163(this));
        this.f4474b.m12130a(new C13174(this));
    }

    public void onBackPressed() {
        m6844i();
        super.onBackPressed();
    }

    protected void onStart() {
        super.onStart();
        this.f4473a.m10012a(this.f4476d);
        m6842f();
        this.f4474b.m12128a();
    }

    protected void onStop() {
        this.f4474b.m12131b();
        this.f4473a.m10029b(this.f4476d);
        super.onStop();
    }

    private void m6842f() {
        Event h = this.f4473a.m10056h();
        if (this.f4475c == null || h == null || !this.f4475c.getEventId().equals(h.getEventId()) || h.getEventType() != DutyStatus.DRIVING.m4394b()) {
            this.f4475c = null;
            finish();
            return;
        }
        this.f4475c = h;
    }

    private void m6843h() {
        m6839a(true);
    }

    private void m6844i() {
        m6839a(false);
    }

    private void m6839a(boolean z) {
        if (this.f4475c != null) {
            EobrDevice j = OurApplication.m6252I().m11412j();
            if (j != null) {
                j.m8990b(m6837a(this.f4475c.getOccurredAt(), z).toByteArray(), new C13185(this));
                finish();
            }
        }
    }

    private static ExternalVarEntry m6837a(long j, boolean z) {
        return ExternalVarEntry.newBuilder().m13994a(ExternalVarEntryType.CONTINUE_DRIVING_PROMPT_RESPONSE).m13987a(ContinueDrivingPromptResponse.newBuilder().m12728a(z).m12725a(j)).m14000c();
    }
}
