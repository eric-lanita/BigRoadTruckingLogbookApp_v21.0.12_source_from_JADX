package com.bigroad.ttb.android.adapter;

import android.content.Context;
import android.text.format.DateUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.bigroad.shared.C1069g;
import com.bigroad.shared.ah;
import com.bigroad.shared.am;
import com.bigroad.ttb.android.OurApplication;
import com.bigroad.ttb.android.R;
import com.bigroad.ttb.android.p035d.C1790a;
import com.bigroad.ttb.android.p035d.p036a.C1769h;
import com.bigroad.ttb.android.p035d.p036a.C1779q;
import com.bigroad.ttb.android.util.C2285f;
import com.bigroad.ttb.protocol.TTProtocol.ConversationData;
import com.bigroad.ttb.protocol.TTProtocol.Message;
import com.bigroad.ttb.protocol.TTProtocol.ct;
import java.text.DateFormat;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public final class C1655b extends BaseAdapter {
    private final C1790a f5769a;
    private final LayoutInflater f5770b;
    private final DateFormat f5771c;
    private final DateFormat f5772d;
    private C1654a[] f5773e;
    private C1069g f5774f;

    public final class C1654a implements Comparable<C1654a> {
        final /* synthetic */ C1655b f5764a;
        private final ConversationData f5765b;
        private final Message f5766c;
        private final boolean f5767d;
        private String f5768e;

        public /* synthetic */ int compareTo(Object obj) {
            return m8161a((C1654a) obj);
        }

        public C1654a(C1655b c1655b, ConversationData conversationData) {
            Message message;
            this.f5764a = c1655b;
            this.f5765b = conversationData;
            C1779q e = OurApplication.m6287i().m8774e(m8162a());
            if (e == null) {
                message = null;
            } else {
                message = e.m8633e();
            }
            this.f5766c = message;
            this.f5767d = OurApplication.m6299u().m10508a(m8162a()) > 0;
        }

        public long m8162a() {
            return this.f5765b.getConversation().getConversationId();
        }

        public boolean m8163b() {
            return this.f5767d;
        }

        public int m8164c() {
            return this.f5765b.getParticipantCount();
        }

        public String m8165d() {
            if (this.f5768e == null) {
                this.f5768e = this.f5764a.f5774f.m5323a(this.f5765b);
            }
            return this.f5768e;
        }

        public void m8166e() {
            this.f5768e = null;
        }

        public Message m8167f() {
            return this.f5766c;
        }

        public long m8168g() {
            if (this.f5766c == null) {
                return 0;
            }
            return Math.max(this.f5766c.getSentAt(), this.f5766c.getCreatedAt());
        }

        public int m8161a(C1654a c1654a) {
            boolean b = m8163b();
            if (b != c1654a.m8163b()) {
                return b ? -1 : 1;
            } else {
                return Long.signum(c1654a.m8168g() - m8168g());
            }
        }
    }

    public C1655b(Context context) {
        this(context, Collections.emptyList());
    }

    public C1655b(Context context, List<C1769h> list) {
        this.f5769a = OurApplication.m6287i();
        this.f5770b = LayoutInflater.from(context);
        this.f5771c = android.text.format.DateFormat.getTimeFormat(context);
        this.f5772d = android.text.format.DateFormat.getDateFormat(context);
        this.f5774f = C2285f.m11202a();
        m8172a((List) list);
    }

    public void m8172a(List<C1769h> list) {
        int size = list.size();
        if (this.f5773e == null || this.f5773e.length != size) {
            this.f5773e = new C1654a[size];
        }
        int i = 0;
        for (C1769h f : list) {
            this.f5773e[i] = new C1654a(this, f.m8600f());
            i++;
        }
        Arrays.sort(this.f5773e);
        notifyDataSetChanged();
    }

    public void m8171a() {
        this.f5774f = C2285f.m11202a();
        for (C1654a e : this.f5773e) {
            e.m8166e();
        }
        notifyDataSetChanged();
    }

    public C1654a m8170a(int i) {
        return (i < 0 || i >= this.f5773e.length) ? null : this.f5773e[i];
    }

    public int getCount() {
        return this.f5773e.length;
    }

    public Object getItem(int i) {
        return this.f5773e[i];
    }

    public long getItemId(int i) {
        return this.f5773e[i].m8162a();
    }

    public boolean hasStableIds() {
        return true;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        CharSequence charSequence;
        String str = null;
        int i2 = 0;
        C1654a c1654a = this.f5773e[i];
        Message f = c1654a.m8167f();
        if (view == null) {
            view = this.f5770b.inflate(R.layout.conversation_item, viewGroup, false);
        }
        ImageView imageView = (ImageView) view.findViewById(R.id.conversationItem_unread);
        if (!c1654a.m8163b()) {
            i2 = 4;
        }
        imageView.setVisibility(i2);
        ((TextView) view.findViewById(R.id.conversationItem_title)).setText(c1654a.m8165d());
        TextView textView = (TextView) view.findViewById(R.id.conversationItem_timestamp);
        if (f == null) {
            charSequence = "";
        } else {
            long max = Math.max(f.getCreatedAt(), f.getSentAt());
            Date date = new Date(max);
            if (DateUtils.isToday(max)) {
                charSequence = this.f5771c.format(date);
            } else {
                charSequence = this.f5772d.format(date);
            }
        }
        textView.setText(charSequence);
        textView = (TextView) view.findViewById(R.id.conversationItem_latestMessage);
        if (f != null) {
            charSequence = f.getBody().trim();
            if (c1654a.m8164c() > 2) {
                long senderPersonId = f.getSenderPersonId();
                if (senderPersonId == OurApplication.m6285g().m12202d()) {
                    str = "me: ";
                } else {
                    ct b = this.f5769a.m8750b(senderPersonId);
                    if (b != null) {
                        str = ah.m4162b(b) + ": ";
                    }
                }
                if (str != null) {
                    charSequence = str + charSequence;
                }
            }
        } else {
            charSequence = null;
        }
        if (am.m4188a(charSequence)) {
            charSequence = " ";
        }
        textView.setText(charSequence);
        return view;
    }
}
