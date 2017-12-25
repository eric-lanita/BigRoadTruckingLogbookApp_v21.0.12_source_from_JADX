package com.bigroad.ttb.android.activity;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.bigroad.shared.am;
import com.bigroad.ttb.android.C2098i;
import com.bigroad.ttb.android.C2098i.C1320a;
import com.bigroad.ttb.android.OurApplication;
import com.bigroad.ttb.android.R;
import com.bigroad.ttb.android.activity.OurActivity.Feature;
import com.bigroad.ttb.android.adapter.MessageListAdapter;
import com.bigroad.ttb.android.logging.C2134e;
import com.bigroad.ttb.android.p035d.C1790a;
import com.bigroad.ttb.android.p035d.p036a.C1769h;
import com.bigroad.ttb.android.util.C2285f;
import com.bigroad.ttb.android.util.C2293m;
import com.bigroad.ttb.android.util.ac;
import com.bigroad.ttb.protocol.TTProtocol.ConversationData;
import com.bigroad.ttb.protocol.TTProtocol.ConversationParticipant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.EnumSet;

public class ConversationActivity extends OurKeyboardActivity {
    private ListView f4482a;
    private ImageButton f4483b;
    private EditText f4484c;
    private Button f4485d;
    private TextView f4486e;
    private C1790a f4487f;
    private C2098i f4488g;
    private long f4489h;
    private long f4490i = 0;
    private ConversationData f4491j;
    private MessageListAdapter f4492k;
    private boolean f4493l = false;
    private final OnEditorActionListener f4494m = new C13191(this);
    private final C1320a f4495n = new C13212(this);

    class C13191 implements OnEditorActionListener {
        final /* synthetic */ ConversationActivity f4477a;

        C13191(ConversationActivity conversationActivity) {
            this.f4477a = conversationActivity;
        }

        public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
            if (i == 4) {
                this.f4477a.f4485d.performClick();
                return true;
            }
            C2134e.m10676b("TT-ConvAct", "actionId=" + i + "; event=" + keyEvent);
            return false;
        }
    }

    class C13212 implements C1320a {
        final /* synthetic */ ConversationActivity f4478a;

        C13212(ConversationActivity conversationActivity) {
            this.f4478a = conversationActivity;
        }

        public void mo952a(C2098i c2098i, long[] jArr) {
            if (Arrays.binarySearch(jArr, this.f4478a.f4489h) >= 0) {
                this.f4478a.m6855h();
                this.f4478a.m6859o();
            }
        }
    }

    class C13223 implements OnClickListener {
        final /* synthetic */ ConversationActivity f4479a;

        C13223(ConversationActivity conversationActivity) {
            this.f4479a = conversationActivity;
        }

        public void onClick(View view) {
            C1632a.m7981c(this.f4479a, this.f4479a.getString(R.string.conversation_voicePrompt));
        }
    }

    class C13234 implements OnClickListener {
        final /* synthetic */ ConversationActivity f4480a;

        C13234(ConversationActivity conversationActivity) {
            this.f4480a = conversationActivity;
        }

        public void onClick(View view) {
            this.f4480a.m6857j();
        }
    }

    class C13245 implements Runnable {
        final /* synthetic */ ConversationActivity f4481a;

        C13245(ConversationActivity conversationActivity) {
            this.f4481a = conversationActivity;
        }

        public void run() {
            this.f4481a.f4492k.m8149a();
        }
    }

    public ConversationActivity() {
        super(EnumSet.of(Feature.FINISH_ON_SIGN_OUT, Feature.FINISH_ON_FLEET_LOSS, Feature.DEFAULT_MENU));
    }

    protected TextView mo930f() {
        return this.f4484c;
    }

    private void m6855h() {
        C1769h c = this.f4487f.m8762c(this.f4489h);
        if (c == null) {
            C2134e.m10680d("TT-ConvAct", "Conversation with ID=" + this.f4489h + " is gone; finishing");
            finish();
            return;
        }
        this.f4491j = c.m8600f();
        this.f4492k.m8150a(this.f4491j);
        m6856i();
    }

    private void m6848a(String str) {
        this.f4484c.requestFocus();
        ac.m11179a(this.f4484c, (CharSequence) str);
    }

    private void m6856i() {
        int count = this.f4492k.getCount();
        if (count > 0) {
            this.f4482a.setSelection(count - 1);
        }
    }

    private void m6857j() {
        String trim = this.f4484c.getText().toString().trim();
        this.f4484c.setText("");
        if (trim.length() != 0) {
            this.f4488g.m10510a(this.f4489h, trim);
            if (mo933n().m11255a()) {
                mo933n().m11256b(this.f4484c);
            }
        }
    }

    private void m6858k() {
        String a = C2285f.m11202a().m5323a(this.f4491j);
        setTitle(a);
        m6850b(a);
    }

    private void m6850b(String str) {
        if (this.f4486e == null) {
            return;
        }
        if (am.m4188a((CharSequence) str)) {
            this.f4486e.setText(R.string.conversation_noMessages);
            return;
        }
        this.f4486e.setText(getResources().getString(R.string.conversation_noMessagesWithName, new Object[]{str}));
    }

    private void m6859o() {
        if (this.f4493l && hasWindowFocus()) {
            ConversationParticipant a = C2285f.m11203a(this.f4491j);
            if (a == null) {
                C2134e.m10682e("TT-ConvAct", "We're not a participant in conversation ID=" + this.f4489h);
                return;
            }
            long max = Math.max(this.f4490i, a.getReadSeq());
            long b = this.f4487f.m8749b(this.f4489h, a.getPersonId(), max);
            if (b > max) {
                this.f4490i = b;
                this.f4488g.m10509a(this.f4489h, this.f4490i);
            }
        }
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f4487f = OurApplication.m6287i();
        this.f4488g = OurApplication.m6299u();
        this.f4489h = getIntent().getLongExtra("com.bigroad.ttb.conversationId", -1);
        this.f4492k = new MessageListAdapter(this);
        setContentView((int) R.layout.conversation);
        this.f4482a = (ListView) findViewById(R.id.conversation_listView);
        this.f4482a.setEmptyView(findViewById(R.id.conversation_emptyView));
        this.f4483b = (ImageButton) findViewById(R.id.conversation_speakNow);
        this.f4484c = (EditText) findViewById(R.id.conversation_messageText);
        Configuration configuration = getResources().getConfiguration();
        if ((configuration.screenLayout & 15) == 2 && configuration.orientation == 2 && C2293m.m11241c(this) >= C2293m.f7933a) {
            this.f4484c.setImeOptions(268435456);
        }
        this.f4485d = (Button) findViewById(R.id.conversation_sendButton);
        this.f4486e = (TextView) findViewById(R.id.conversation_emptyView);
        this.f4482a.setDivider(null);
        this.f4482a.setItemsCanFocus(false);
        this.f4482a.setClickable(false);
        this.f4482a.setAdapter(this.f4492k);
        this.f4484c.setOnEditorActionListener(this.f4494m);
        if (OurApplication.ak()) {
            this.f4483b.setOnClickListener(new C13223(this));
        } else {
            this.f4483b.setVisibility(8);
        }
        this.f4485d.setOnClickListener(new C13234(this));
        this.f4488g.m10511a(this.f4495n);
        m6710a(this.f4492k.m8151b(), new C13245(this));
        m6855h();
        m6858k();
    }

    protected void onResume() {
        super.onResume();
        this.f4493l = true;
        m6859o();
    }

    protected void onPause() {
        this.f4493l = false;
        super.onPause();
    }

    protected void onDestroy() {
        this.f4488g.m10514b(this.f4495n);
        super.onDestroy();
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1 && intent != null) {
            switch (i) {
                case 8:
                    ArrayList stringArrayListExtra = intent.getStringArrayListExtra("android.speech.extra.RESULTS");
                    if (!stringArrayListExtra.isEmpty()) {
                        m6848a(((String) stringArrayListExtra.get(0)).trim());
                        return;
                    }
                    return;
                default:
                    C2134e.m10676b("TT-ConvAct", "Ignoring completion of activity with requestCode=" + i);
                    return;
            }
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        m6859o();
    }
}
