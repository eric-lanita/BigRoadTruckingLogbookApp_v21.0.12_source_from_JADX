package com.urbanairship.messagecenter;

import android.annotation.TargetApi;
import android.content.res.TypedArray;
import android.graphics.PorterDuff.Mode;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.p002a.p003a.C0085a;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v4.widget.SwipeRefreshLayout.C0493a;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;
import com.urbanairship.C3767e;
import com.urbanairship.C3860o.C3849b;
import com.urbanairship.C3860o.C3851d;
import com.urbanairship.C3860o.C3852e;
import com.urbanairship.C3860o.C3853f;
import com.urbanairship.C3860o.C3857j;
import com.urbanairship.C3860o.C3858k;
import com.urbanairship.C3929q;
import com.urbanairship.richpush.C3941b;
import com.urbanairship.richpush.C3941b.C3823b;
import com.urbanairship.richpush.C3941b.C3837a;
import com.urbanairship.richpush.C3941b.C3939c;
import com.urbanairship.richpush.C3942c;
import com.urbanairship.util.C3956k;
import java.util.List;

@TargetApi(14)
public class MessageListFragment extends Fragment {
    private SwipeRefreshLayout f13695a;
    private AbsListView f13696b;
    private C3941b f13697c;
    private C3835e f13698d;
    private C3767e f13699e;
    private C3845c f13700f;
    private String f13701g;
    private C3939c f13702h;
    private int f13703i = C3851d.ua_ic_image_placeholder;
    private final C3823b f13704j = new C38311(this);

    class C38311 implements C3823b {
        final /* synthetic */ MessageListFragment f13685a;

        C38311(MessageListFragment messageListFragment) {
            this.f13685a = messageListFragment;
        }

        public void mo2802a() {
            this.f13685a.m19964e();
        }
    }

    class C38322 implements OnItemClickListener {
        final /* synthetic */ MessageListFragment f13686a;

        C38322(MessageListFragment messageListFragment) {
            this.f13686a = messageListFragment;
        }

        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            C3942c a = this.f13686a.m19968a(i);
            if (a != null) {
                C3929q.m20372a().m20391o().m20435a(a.m20446a());
            }
        }
    }

    class C38333 implements C0493a {
        final /* synthetic */ MessageListFragment f13687a;

        C38333(MessageListFragment messageListFragment) {
            this.f13687a = messageListFragment;
        }

        public void mo2803a() {
            this.f13687a.m19966f();
        }
    }

    class C38385 implements C3837a {
        final /* synthetic */ MessageListFragment f13694a;

        C38385(MessageListFragment messageListFragment) {
            this.f13694a = messageListFragment;
        }

        public void mo2805a(boolean z) {
            if (this.f13694a.f13695a != null) {
                this.f13694a.f13695a.setRefreshing(false);
            }
        }
    }

    private List<C3942c> m19962d() {
        return this.f13697c.m20432a(this.f13702h);
    }

    private void m19964e() {
        this.f13698d.m19953a(m19962d());
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f13697c = C3929q.m20372a().m20391o();
        this.f13698d = m19967a();
        m19964e();
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(C3853f.ua_fragment_message_list, viewGroup, false);
        m19957a(inflate);
        m19971b().setOnItemClickListener(new C38322(this));
        View findViewById = inflate.findViewById(16908292);
        if (findViewById != null) {
            this.f13696b.setEmptyView(findViewById);
        }
        return inflate;
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        m19957a(view);
    }

    private void m19957a(View view) {
        if (this.f13696b == null) {
            if (view instanceof AbsListView) {
                this.f13696b = (AbsListView) view;
            } else {
                this.f13696b = (AbsListView) view.findViewById(16908298);
            }
            if (this.f13696b == null) {
                throw new RuntimeException("Your content must have a ListView whose id attribute is 'android.R.id.list'");
            }
            int resourceId;
            this.f13696b.setAdapter(this.f13698d);
            this.f13695a = (SwipeRefreshLayout) view.findViewById(C3852e.swipe_container);
            if (this.f13695a != null) {
                this.f13695a.setOnRefreshListener(new C38333(this));
            }
            View findViewById = view.findViewById(16908292);
            TypedArray obtainStyledAttributes = getContext().getTheme().obtainStyledAttributes(null, C3858k.MessageCenter, C3849b.messageCenterStyle, C3857j.MessageCenter);
            if (findViewById != null && (findViewById instanceof TextView)) {
                TextView textView = (TextView) findViewById;
                resourceId = obtainStyledAttributes.getResourceId(C3858k.MessageCenter_messageCenterEmptyMessageTextAppearance, -1);
                C3956k.m20517a(getContext(), textView, resourceId, C3956k.m20516a(getContext(), resourceId));
                textView.setText(obtainStyledAttributes.getString(C3858k.MessageCenter_messageCenterEmptyMessageText));
            }
            if (this.f13696b instanceof ListView) {
                ListView listView = (ListView) this.f13696b;
                resourceId = obtainStyledAttributes.getColor(C3858k.MessageCenter_messageCenterDividerColor, -1);
                if (resourceId != -1) {
                    C0085a.m452a(listView.getDivider(), resourceId);
                    C0085a.m457a(listView.getDivider(), Mode.SRC);
                }
            }
            this.f13703i = obtainStyledAttributes.getResourceId(C3858k.MessageCenter_messageCenterItemIconPlaceholder, this.f13703i);
            obtainStyledAttributes.recycle();
        }
    }

    protected C3835e m19967a() {
        this.f13700f = new C3845c(getContext());
        return new C3835e(this, getContext(), C3853f.ua_item_mc) {
            final /* synthetic */ MessageListFragment f13693a;

            protected void mo2804a(View view, C3942c c3942c, final int i) {
                if (view instanceof MessageItemView) {
                    MessageItemView messageItemView = (MessageItemView) view;
                    messageItemView.m19948a(c3942c, this.f13693a.f13703i, this.f13693a.f13700f);
                    messageItemView.m19949a(c3942c.m20446a().equals(this.f13693a.f13701g));
                    messageItemView.m19947a(new OnClickListener(this) {
                        final /* synthetic */ C38364 f13689b;

                        public void onClick(View view) {
                            this.f13689b.f13693a.m19971b().setItemChecked(i, !this.f13689b.f13693a.m19971b().isItemChecked(i));
                        }
                    });
                }
            }
        };
    }

    public void onResume() {
        super.onResume();
        this.f13697c.m20434a(this.f13704j);
        m19964e();
        m19971b().invalidate();
    }

    public void onPause() {
        super.onPause();
        this.f13697c.m20440b(this.f13704j);
        if (this.f13699e != null) {
            this.f13699e.mo2787a();
        }
    }

    private void m19966f() {
        if (this.f13699e != null) {
            this.f13699e.mo2787a();
        }
        this.f13699e = this.f13697c.m20430a(new C38385(this));
        if (this.f13695a != null) {
            this.f13695a.setRefreshing(true);
        }
    }

    public AbsListView m19971b() {
        return this.f13696b;
    }

    public C3942c m19968a(int i) {
        if (this.f13698d.getCount() > i) {
            return (C3942c) this.f13698d.getItem(i);
        }
        return null;
    }

    public void onDestroyView() {
        super.onDestroyView();
        this.f13696b.setChoiceMode(0);
    }

    public C3835e m19972c() {
        return this.f13698d;
    }

    void m19970a(String str) {
        if (this.f13701g != null || str != null) {
            if (this.f13701g == null || !this.f13701g.equals(str)) {
                this.f13701g = str;
                if (m19972c() != null) {
                    m19972c().notifyDataSetChanged();
                }
            }
        }
    }

    void m19969a(C3939c c3939c) {
        this.f13702h = c3939c;
        if (this.f13698d != null) {
            m19964e();
        }
    }
}
