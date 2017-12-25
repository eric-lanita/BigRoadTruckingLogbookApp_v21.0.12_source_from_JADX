package com.bigroad.ttb.android.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import com.bigroad.ttb.android.C2098i;
import com.bigroad.ttb.android.C2098i.C1320a;
import com.bigroad.ttb.android.C2230r;
import com.bigroad.ttb.android.C2230r.C1332b;
import com.bigroad.ttb.android.C2232s;
import com.bigroad.ttb.android.C2232s.C1329a;
import com.bigroad.ttb.android.C2472x;
import com.bigroad.ttb.android.C2472x.C1306a;
import com.bigroad.ttb.android.OurApplication;
import com.bigroad.ttb.android.R;
import com.bigroad.ttb.android.activity.OurActivity.Feature;
import com.bigroad.ttb.android.activity.OurActivity.TitleStyle;
import com.bigroad.ttb.android.adapter.C1655b;
import com.bigroad.ttb.android.adapter.C1655b.C1654a;
import com.bigroad.ttb.android.logging.C2134e;
import com.bigroad.ttb.android.p035d.p036a.C1769h;
import com.bigroad.ttb.android.util.C2293m;
import com.bigroad.ttb.android.util.aa;
import com.bigroad.ttb.android.widget.OurLinearLayout;
import com.bigroad.ttb.protocol.TTProtocol.ConversationData;
import com.bigroad.ttb.protocol.TTProtocol.ConversationParticipant;
import com.bigroad.ttb.protocol.TTProtocol.Person;
import com.bigroad.ttb.protocol.TTProtocol.PersonGroup;
import java.util.Collections;
import java.util.Date;
import java.util.EnumSet;
import java.util.List;
import java.util.TimeZone;

public class ConversationListActivity extends OurActivity {
    private Button f4507a;
    private Button f4508b;
    private Button f4509c;
    private ListView f4510d;
    private TextView f4511e;
    private OurLinearLayout f4512f;
    private OurLinearLayout f4513g;
    private OurLinearLayout f4514h;
    private C2098i f4515i;
    private C2472x f4516j;
    private C2232s f4517k;
    private C2230r f4518l;
    private List<C1769h> f4519m = Collections.emptyList();
    private C1655b f4520n;
    private long f4521o = -1;
    private final C1320a f4522p = new C13251(this);
    private final C1306a f4523q = new C13284(this);
    private final C1329a f4524r = new C13305(this);
    private final C1332b f4525s = new C13336(this);
    private final Runnable f4526t = new C13347(this);

    class C13251 implements C1320a {
        final /* synthetic */ ConversationListActivity f4498a;

        C13251(ConversationListActivity conversationListActivity) {
            this.f4498a = conversationListActivity;
        }

        public void mo952a(C2098i c2098i, long[] jArr) {
            OurApplication.m6289k().m6502g();
        }
    }

    class C13262 implements OnClickListener {
        final /* synthetic */ ConversationListActivity f4499a;

        C13262(ConversationListActivity conversationListActivity) {
            this.f4499a = conversationListActivity;
        }

        public void onClick(View view) {
            C1632a.m7999j(this.f4499a);
        }
    }

    class C13273 implements OnClickListener {
        final /* synthetic */ ConversationListActivity f4500a;

        C13273(ConversationListActivity conversationListActivity) {
            this.f4500a = conversationListActivity;
        }

        public void onClick(View view) {
            C1632a.m7949a(this.f4500a, this.f4500a.m6881h());
        }
    }

    class C13284 implements C1306a {
        final /* synthetic */ ConversationListActivity f4501a;

        C13284(ConversationListActivity conversationListActivity) {
            this.f4501a = conversationListActivity;
        }

        public void mo948a(C2472x c2472x, List<Person> list) {
            this.f4501a.m6882i();
        }
    }

    class C13305 implements C1329a {
        final /* synthetic */ ConversationListActivity f4502a;

        C13305(ConversationListActivity conversationListActivity) {
            this.f4502a = conversationListActivity;
        }

        public void mo953a(List<PersonGroup> list) {
            this.f4502a.f4520n.m8171a();
        }
    }

    class C13336 extends C1332b {
        final /* synthetic */ ConversationListActivity f4503a;

        C13336(ConversationListActivity conversationListActivity) {
            this.f4503a = conversationListActivity;
        }

        public void mo954a(C2230r c2230r) {
            this.f4503a.m6882i();
            this.f4503a.m6884k();
        }
    }

    class C13347 implements Runnable {
        final /* synthetic */ ConversationListActivity f4504a;

        C13347(ConversationListActivity conversationListActivity) {
            this.f4504a = conversationListActivity;
        }

        public void run() {
            this.f4504a.f4520n.notifyDataSetChanged();
            this.f4504a.m6701T().postDelayed(this.f4504a.f4526t, 300000);
        }
    }

    class C13358 implements OnClickListener {
        final /* synthetic */ ConversationListActivity f4505a;

        C13358(ConversationListActivity conversationListActivity) {
            this.f4505a = conversationListActivity;
        }

        public void onClick(View view) {
            this.f4505a.m6883j();
        }
    }

    class C13369 implements OnClickListener {
        final /* synthetic */ ConversationListActivity f4506a;

        C13369(ConversationListActivity conversationListActivity) {
            this.f4506a = conversationListActivity;
        }

        public void onClick(View view) {
            C1632a.m7989e(this.f4506a);
        }
    }

    public static class ConversationListMenu extends Fragment {
        public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
            View inflate = layoutInflater.inflate(C2293m.m11240b(getActivity()) < C2293m.f7934b ? R.layout.conversation_list_menu_small : R.layout.conversation_list_menu, viewGroup, false);
            if (inflate == null) {
                C2134e.m10682e("TT-CListActivity", "ConversationListMenu.onCreateView failed to create a menu view.");
            }
            return inflate;
        }
    }

    public ConversationListActivity() {
        super(EnumSet.of(Feature.FINISH_ON_SIGN_OUT, Feature.DEFAULT_MENU, Feature.DASH_LINK_STATE), TitleStyle.IDENTITY);
    }

    private boolean m6880f() {
        return m6699R().m12213g() > -1;
    }

    private Uri m6881h() {
        long d = OurApplication.m6285g().m12202d();
        return Uri.parse("https://" + OurApplication.m6245B().m10547b() + "/sign-up/create-fleet?personId=" + d + "&timezoneOffset=" + TimeZone.getDefault().getOffset(new Date().getTime()) + aa.m11165a() + "&hasDevice=true" + aa.m11166a("InAppMarketing", "messaging", "mobile", "bigroad"));
    }

    private void m6882i() {
        this.f4519m = OurApplication.m6287i().m8797l();
        this.f4520n.m8172a(this.f4519m);
        if (this.f4521o > 0) {
            C1769h b = m6874b(this.f4521o);
            if (b != null) {
                m6870a(b.m8597b());
            }
        }
        if (this.f4511e != null) {
            this.f4511e.setVisibility(this.f4520n.getCount() > 0 ? 0 : 8);
        }
    }

    private void m6883j() {
        this.f4521o = -1;
        C1632a.m8007n((Activity) this);
    }

    private void m6877d(int i) {
        this.f4521o = -1;
        C1654a a = this.f4520n.m8170a(i);
        if (a != null) {
            m6870a(a.m8162a());
        }
    }

    private void m6870a(long j) {
        this.f4521o = -1;
        C1632a.m7948a((Context) this, j);
    }

    private void m6884k() {
        if (!OurApplication.m6285g().m12226p()) {
            this.f4514h.setVisibility(8);
            this.f4512f.setVisibility(0);
            this.f4513g.setVisibility(8);
            this.f4507a.setVisibility(8);
        } else if (m6880f()) {
            this.f4510d.setEmptyView(this.f4514h);
            this.f4514h.setVisibility(0);
            this.f4512f.setVisibility(8);
            this.f4513g.setVisibility(8);
            this.f4507a.setVisibility(0);
        } else {
            this.f4514h.setVisibility(8);
            this.f4512f.setVisibility(8);
            this.f4513g.setVisibility(0);
            this.f4507a.setVisibility(8);
        }
    }

    private C1769h m6874b(long j) {
        long d = m6699R().m12202d();
        for (C1769h c1769h : this.f4519m) {
            ConversationData f = c1769h.m8600f();
            if (f != null) {
                List<ConversationParticipant> participantList = f.getParticipantList();
                if (participantList.size() == 2) {
                    Object obj = null;
                    Object obj2 = null;
                    for (ConversationParticipant personId : participantList) {
                        Object obj3;
                        long personId2 = personId.getPersonId();
                        if (personId2 == j) {
                            obj3 = 1;
                        } else {
                            obj3 = obj;
                        }
                        if (personId2 == d) {
                            obj = 1;
                        } else {
                            obj = obj2;
                        }
                        obj2 = obj;
                        obj = obj3;
                    }
                    if (!(obj2 == null || obj == null)) {
                        return c1769h;
                    }
                }
                continue;
            }
        }
        return null;
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.conversation_list);
        this.f4510d = (ListView) findViewById(R.id.conversationList_listView);
        this.f4511e = (TextView) findViewById(R.id.conversationList_titleBar);
        this.f4515i = OurApplication.m6299u();
        this.f4516j = OurApplication.m6293o();
        this.f4517k = OurApplication.m6257N();
        this.f4518l = OurApplication.m6292n();
        this.f4520n = new C1655b(this);
        this.f4507a = (Button) findViewById(R.id.conversationList_composeButton);
        this.f4507a.setOnClickListener(new C13358(this));
        this.f4508b = (Button) findViewById(R.id.conversationList_checkInButton);
        this.f4508b.setOnClickListener(new C13369(this));
        this.f4509c = (Button) findViewById(R.id.conversationList_sendNoteButton);
        this.f4509c.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ ConversationListActivity f4496a;

            {
                this.f4496a = r1;
            }

            public void onClick(View view) {
                C1632a.m7986d(this.f4496a);
            }
        });
        this.f4514h = (OurLinearLayout) findViewById(R.id.conversationList_emptyView);
        this.f4510d.setAdapter(this.f4520n);
        this.f4510d.setOnItemClickListener(new OnItemClickListener(this) {
            final /* synthetic */ ConversationListActivity f4497a;

            {
                this.f4497a = r1;
            }

            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                this.f4497a.m6877d(i);
            }
        });
        this.f4512f = (OurLinearLayout) findViewById(R.id.conversationList_noAccountView);
        this.f4513g = (OurLinearLayout) findViewById(R.id.conversationList_noFleetView);
        Button button = (Button) findViewById(R.id.conversationList_createFleetButton);
        ((Button) findViewById(R.id.conversationList_createAccountButton)).setOnClickListener(new C13262(this));
        button.setOnClickListener(new C13273(this));
        m6884k();
        this.f4515i.m10511a(this.f4522p);
        this.f4516j.m12140a(this.f4523q);
        this.f4517k.m11027a(this.f4524r);
        this.f4518l.m11009a(this.f4525s);
        m6882i();
        if (bundle == null) {
            OurApplication.m6289k().m6502g();
        }
    }

    protected void onStart() {
        super.onStart();
        this.f4526t.run();
    }

    protected void onStop() {
        m6701T().removeCallbacks(this.f4526t);
        super.onStop();
    }

    protected void onDestroy() {
        this.f4515i.m10514b(this.f4522p);
        this.f4516j.m12142b(this.f4523q);
        this.f4517k.m11030b(this.f4524r);
        this.f4518l.m11015b(this.f4525s);
        super.onDestroy();
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        switch (i) {
            case 9:
                if (i2 == -1 && intent != null) {
                    long longExtra = intent.getLongExtra("com.bigroad.ttb.personId", -1);
                    if (longExtra > 0) {
                        C1769h b = m6874b(longExtra);
                        if (b != null) {
                            m6870a(b.m8597b());
                            break;
                        }
                        OurApplication.m6289k().m6454a(longExtra);
                        this.f4521o = longExtra;
                        break;
                    }
                }
                return;
                break;
            default:
                C2134e.m10676b("TT-CListActivity", "Ignoring completion of activity with requestCode=" + i);
                break;
        }
        m6884k();
    }
}
