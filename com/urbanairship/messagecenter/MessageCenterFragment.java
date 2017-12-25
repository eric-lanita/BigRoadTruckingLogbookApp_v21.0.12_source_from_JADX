package com.urbanairship.messagecenter;

import android.annotation.TargetApi;
import android.content.Intent;
import android.content.res.TypedArray;
import android.graphics.PorterDuff.Mode;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.p002a.p003a.C0085a;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.facebook.share.internal.ShareConstants;
import com.urbanairship.C3860o.C3849b;
import com.urbanairship.C3860o.C3852e;
import com.urbanairship.C3860o.C3853f;
import com.urbanairship.C3860o.C3857j;
import com.urbanairship.C3860o.C3858k;
import com.urbanairship.C3929q;
import com.urbanairship.richpush.C3941b.C3823b;
import com.urbanairship.richpush.C3941b.C3939c;
import com.urbanairship.richpush.C3942c;
import com.urbanairship.util.C3956k;
import java.util.List;

@TargetApi(14)
public class MessageCenterFragment extends Fragment {
    private C3939c f13658a;
    private MessageListFragment f13659b;
    private boolean f13660c;
    private String f13661d;
    private int f13662e;
    private final C3823b f13663f = new C38241(this);

    class C38241 implements C3823b {
        final /* synthetic */ MessageCenterFragment f13655a;

        C38241(MessageCenterFragment messageCenterFragment) {
            this.f13655a = messageCenterFragment;
        }

        public void mo2802a() {
            this.f13655a.m19930b();
        }
    }

    public static class NoMessageSelectedFragment extends Fragment {
        public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
            View inflate = layoutInflater.inflate(C3853f.ua_fragment_no_message_selected, viewGroup, false);
            View findViewById = inflate.findViewById(16908292);
            if (findViewById != null && (findViewById instanceof TextView)) {
                TypedArray obtainStyledAttributes = getContext().getTheme().obtainStyledAttributes(null, C3858k.MessageCenter, C3849b.messageCenterStyle, C3857j.MessageCenter);
                TextView textView = (TextView) findViewById;
                int resourceId = obtainStyledAttributes.getResourceId(C3858k.MessageCenter_messageNotSelectedTextAppearance, -1);
                C3956k.m20517a(getContext(), textView, resourceId, C3956k.m20516a(getContext(), resourceId));
                textView.setText(obtainStyledAttributes.getString(C3858k.MessageCenter_messageNotSelectedText));
                obtainStyledAttributes.recycle();
            }
            return inflate;
        }
    }

    static MessageCenterFragment m19926a(String str) {
        MessageCenterFragment messageCenterFragment = new MessageCenterFragment();
        Bundle bundle = new Bundle();
        bundle.putString("START_MESSAGE_ID", str);
        messageCenterFragment.setArguments(bundle);
        return messageCenterFragment;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            this.f13662e = bundle.getInt("STATE_CURRENT_MESSAGE_POSITION", -1);
            this.f13661d = bundle.getString("STATE_CURRENT_MESSAGE_ID", null);
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(C3853f.ua_fragment_mc, viewGroup, false);
        m19928a(inflate);
        return inflate;
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        m19928a(view);
        this.f13659b.m19969a(this.f13658a);
        if (bundle == null && getArguments() != null && getArguments().containsKey("START_MESSAGE_ID")) {
            m19933b(getArguments().getString("START_MESSAGE_ID"));
        }
        if (bundle != null && bundle.containsKey("STATE_ABS_LIST_VIEW") && this.f13659b.m19971b() != null) {
            this.f13659b.m19971b().onRestoreInstanceState(bundle.getParcelable("STATE_ABS_LIST_VIEW"));
        }
    }

    private void m19928a(View view) {
        if (this.f13659b == null) {
            this.f13659b = (MessageListFragment) getChildFragmentManager().mo148a(C3852e.message_list_fragment);
            if (this.f13659b == null) {
                throw new RuntimeException("Your content must have a MessageListFragment whose id attribute is 'R.id.message_list_fragment'");
            }
            if (view.findViewById(C3852e.message_container) != null) {
                this.f13660c = true;
                if (VERSION.SDK_INT >= 16) {
                    LinearLayout linearLayout = (LinearLayout) view.findViewById(C3852e.container);
                    TypedArray obtainStyledAttributes = getActivity().getTheme().obtainStyledAttributes(null, C3858k.MessageCenter, C3849b.messageCenterStyle, C3857j.MessageCenter);
                    int color = obtainStyledAttributes.getColor(C3858k.MessageCenter_messageCenterDividerColor, -1);
                    if (color != -1) {
                        C0085a.m452a(linearLayout.getDividerDrawable(), color);
                        C0085a.m457a(linearLayout.getDividerDrawable(), Mode.SRC);
                    }
                    obtainStyledAttributes.recycle();
                }
            } else {
                this.f13660c = false;
            }
            m19931a(this.f13659b);
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString("STATE_CURRENT_MESSAGE_ID", this.f13661d);
        bundle.putInt("STATE_CURRENT_MESSAGE_POSITION", this.f13662e);
        if (!(this.f13659b == null || this.f13659b.m19971b() == null)) {
            bundle.putParcelable("STATE_ABS_LIST_VIEW", this.f13659b.m19971b().onSaveInstanceState());
        }
        super.onSaveInstanceState(bundle);
    }

    protected void m19931a(final MessageListFragment messageListFragment) {
        messageListFragment.m19971b().setOnItemClickListener(new OnItemClickListener(this) {
            final /* synthetic */ MessageCenterFragment f13657b;

            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                C3942c a = messageListFragment.m19968a(i);
                if (a != null) {
                    this.f13657b.m19933b(a.m20446a());
                }
            }
        });
        messageListFragment.m19971b().setMultiChoiceModeListener(new C3840b(messageListFragment));
        messageListFragment.m19971b().setChoiceMode(3);
        messageListFragment.m19971b().setSaveEnabled(false);
    }

    public void onResume() {
        super.onResume();
        if (this.f13660c) {
            C3929q.m20372a().m20391o().m20434a(this.f13663f);
        }
        m19930b();
    }

    public void onPause() {
        super.onPause();
        C3929q.m20372a().m20391o().m20440b(this.f13663f);
    }

    private List<C3942c> m19927a() {
        return C3929q.m20372a().m20391o().m20432a(this.f13658a);
    }

    protected void m19933b(String str) {
        C3942c b = C3929q.m20372a().m20391o().m20438b(str);
        if (b != null) {
            this.f13661d = str;
            this.f13662e = m19927a().indexOf(b);
            if (this.f13660c) {
                String str2 = str == null ? "EMPTY_MESSAGE" : str;
                if (getChildFragmentManager().mo149a(str2) == null) {
                    getChildFragmentManager().mo150a().mo144b(C3852e.message_container, str == null ? new NoMessageSelectedFragment() : MessageFragment.m19934a(str), str2).mo138a();
                    this.f13659b.m19970a(str);
                    return;
                }
                return;
            }
            Intent data = new Intent().setPackage(getContext().getPackageName()).addFlags(805306368).setData(Uri.fromParts(ShareConstants.WEB_DIALOG_PARAM_MESSAGE, str, null));
            data.setAction("com.urbanairship.VIEW_RICH_PUSH_MESSAGE");
            if (data.resolveActivity(getContext().getPackageManager()) == null) {
                data.setClass(getContext(), MessageActivity.class);
            }
            getContext().startActivity(data);
        }
    }

    private void m19930b() {
        C3942c b = C3929q.m20372a().m20391o().m20438b(this.f13661d);
        List a = m19927a();
        if (!(this.f13661d == null || a.contains(b))) {
            if (a.size() == 0) {
                this.f13661d = null;
                this.f13662e = -1;
            } else {
                this.f13662e = Math.min(a.size() - 1, this.f13662e);
                this.f13661d = ((C3942c) a.get(this.f13662e)).m20446a();
            }
        }
        if (this.f13660c) {
            this.f13659b.m19970a(this.f13661d);
            m19933b(this.f13661d);
            return;
        }
        this.f13659b.m19970a(null);
    }

    public void m19932a(C3939c c3939c) {
        this.f13658a = c3939c;
    }
}
