package com.bigroad.ttb.android.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.CharacterStyle;
import android.text.style.LeadingMarginSpan;
import android.text.style.LeadingMarginSpan.Standard;
import android.text.style.StyleSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.bigroad.shared.ah;
import com.bigroad.ttb.android.OurApplication;
import com.bigroad.ttb.android.R;
import com.bigroad.ttb.android.logging.C2134e;
import com.bigroad.ttb.android.p035d.C1790a;
import com.bigroad.ttb.android.p035d.p036a.C1779q;
import com.bigroad.ttb.android.util.C2285f;
import com.bigroad.ttb.protocol.TTProtocol.ConversationData;
import com.bigroad.ttb.protocol.TTProtocol.ConversationParticipant;
import com.bigroad.ttb.protocol.TTProtocol.Message;
import com.bigroad.ttb.protocol.TTProtocol.ct;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public final class MessageListAdapter extends BaseAdapter {
    private final Handler f5737a;
    private final LayoutInflater f5738b;
    private final C1790a f5739c;
    private final long f5740d;
    private final LeadingMarginSpan f5741e;
    private final LeadingMarginSpan f5742f;
    private final CharacterStyle f5743g;
    private final DateFormat f5744h;
    private final DateFormat f5745i;
    private final DateFormat f5746j;
    private ConversationData f5747k = null;
    private long f5748l = -1;
    private int f5749m = 0;
    private ArrayList<C1648a> f5750n = new ArrayList();
    private Context f5751o;
    private final Runnable f5752p = new C16471(this);

    class C16471 implements Runnable {
        final /* synthetic */ MessageListAdapter f5726a;

        C16471(MessageListAdapter messageListAdapter) {
            this.f5726a = messageListAdapter;
        }

        public void run() {
            this.f5726a.notifyDataSetChanged();
        }
    }

    public enum MarkState {
        NONE(-1),
        SENDING(R.string.messageStatusItem_sending),
        SENT(R.string.messageStatusItem_sent),
        DELIVERED(R.string.messageStatusItem_delivered),
        READ(R.string.messageStatusItem_read);
        
        private final int m_statusResId;

        private MarkState(int i) {
            this.m_statusResId = i;
        }

        private int m8130a() {
            return this.m_statusResId;
        }

        public boolean m8132a(MarkState markState) {
            return ordinal() < markState.ordinal();
        }
    }

    public static final class C1648a {
        private final Message f5733a;
        private boolean f5734b;
        private boolean f5735c;
        private MarkState f5736d;

        public C1648a(Message message) {
            this(message, true, false);
        }

        public C1648a(Message message, boolean z, boolean z2) {
            this.f5733a = message;
            this.f5734b = z;
            this.f5735c = z2;
            this.f5736d = MarkState.NONE;
        }

        public Message m8133a() {
            return this.f5733a;
        }

        public boolean m8137b() {
            return this.f5734b;
        }

        public void m8135a(boolean z) {
            this.f5734b = z;
        }

        public boolean m8138c() {
            return this.f5735c;
        }

        public void m8136b(boolean z) {
            this.f5735c = z;
        }

        public void m8134a(MarkState markState) {
            this.f5736d = markState;
        }

        public int m8139d() {
            if (this.f5736d == MarkState.SENT && this.f5735c) {
                return MarkState.NONE.m8130a();
            }
            return this.f5736d.m8130a();
        }
    }

    private CharSequence m8141a(C1648a c1648a) {
        Message a = c1648a.m8133a();
        Object body = a.getBody();
        if (c1648a.m8137b()) {
            String string;
            long senderPersonId = a.getSenderPersonId();
            if (senderPersonId == this.f5740d) {
                string = this.f5751o.getResources().getString(R.string.conversation_senderMe);
            } else {
                ct b = this.f5739c.m8750b(senderPersonId);
                if (b == null) {
                    string = this.f5751o.getResources().getString(R.string.conversation_senderUnknown);
                } else {
                    string = ah.m4162b(b);
                }
            }
            CharSequence spannableString = new SpannableString(this.f5751o.getResources().getString(R.string.conversation_senderPlaceholder, new Object[]{string}));
            spannableString.setSpan(this.f5743g, 0, spannableString.length(), 33);
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(spannableString);
            spannableStringBuilder.append(' ');
            int length = spannableStringBuilder.length();
            spannableStringBuilder.append(body);
            int indexOf = body.indexOf(10);
            if (indexOf < 0) {
                length = spannableStringBuilder.length();
            } else {
                length = (length + indexOf) + 1;
                if (length < spannableStringBuilder.length()) {
                    spannableStringBuilder.setSpan(this.f5742f, length, spannableStringBuilder.length(), 33);
                }
            }
            spannableStringBuilder.setSpan(this.f5741e, 0, length, 33);
            return spannableStringBuilder;
        }
        CharSequence spannableString2 = new SpannableString(body);
        spannableString2.setSpan(this.f5742f, 0, spannableString2.length(), 33);
        return spannableString2;
    }

    public MessageListAdapter(Context context) {
        this.f5751o = context;
        this.f5737a = new Handler();
        this.f5738b = LayoutInflater.from(context);
        this.f5739c = OurApplication.m6287i();
        this.f5740d = OurApplication.m6285g().m12202d();
        int dimensionPixelOffset = context.getResources().getDimensionPixelOffset(R.dimen.chat_indent);
        this.f5741e = new Standard(0, dimensionPixelOffset);
        this.f5742f = new Standard(dimensionPixelOffset);
        this.f5743g = new StyleSpan(1);
        this.f5744h = android.text.format.DateFormat.getTimeFormat(context);
        this.f5745i = new SimpleDateFormat("EEE MMMM d");
        this.f5746j = new SimpleDateFormat("EEE MMMM d, yyyy");
    }

    private void m8144c() {
        long j = -1;
        int size = this.f5750n.size() - 1;
        while (size >= 0) {
            C1648a c1648a = (C1648a) this.f5750n.get(size);
            long senderPersonId = c1648a.m8133a().getSenderPersonId();
            c1648a.m8135a(senderPersonId != j);
            size--;
            j = senderPersonId;
        }
    }

    private void m8145d() {
        if (this.f5747k != null) {
            long readSeq;
            long deliveredSeq;
            if (this.f5747k.getParticipantCount() == 2) {
                ConversationParticipant b = C2285f.m11205b(this.f5747k);
                readSeq = b == null ? 0 : b.getReadSeq();
                deliveredSeq = b == null ? 0 : b.getDeliveredSeq();
            } else {
                deliveredSeq = 0;
                readSeq = 0;
            }
            MarkState markState = MarkState.NONE;
            Iterator it = this.f5750n.iterator();
            MarkState markState2 = markState;
            while (it.hasNext()) {
                C1648a c1648a = (C1648a) it.next();
                Message a = c1648a.m8133a();
                long messageSeq = a.getMessageSeq();
                if (a.getSenderPersonId() == this.f5740d) {
                    if (markState2.m8132a(MarkState.READ) && r4 >= messageSeq) {
                        markState2 = MarkState.READ;
                    } else if (markState2.m8132a(MarkState.DELIVERED) && r2 >= messageSeq) {
                        markState2 = MarkState.DELIVERED;
                    } else if (markState2.m8132a(MarkState.SENT) && a.getSentAt() > 0) {
                        markState2 = MarkState.SENT;
                    } else if (markState2.m8132a(MarkState.SENDING) && a.getSentAt() == 0) {
                        markState2 = MarkState.SENDING;
                    } else {
                        c1648a.m8134a(MarkState.NONE);
                    }
                    c1648a.m8134a(markState2);
                }
            }
        }
    }

    private void m8146e() {
        int size = this.f5750n.size();
        for (int i = 0; i < size - 1; i++) {
            boolean z;
            C1648a c1648a = (C1648a) this.f5750n.get(i + 1);
            if (((C1648a) this.f5750n.get(i)).m8133a().getSentAt() - c1648a.m8133a().getSentAt() > 300000) {
                z = true;
            } else {
                z = false;
            }
            c1648a.m8136b(z);
        }
        m8147f();
    }

    private boolean m8147f() {
        if (this.f5750n.isEmpty()) {
            return false;
        }
        C1648a c1648a = (C1648a) this.f5750n.get(0);
        long sentAt = c1648a.m8133a().getSentAt();
        boolean z = sentAt > 0 ? OurApplication.m6269Z().mo913a() - sentAt > 300000 : false;
        if (z == c1648a.m8138c()) {
            return false;
        }
        c1648a.m8136b(z);
        return true;
    }

    private int m8140a(int i) {
        return (this.f5749m - 1) - i;
    }

    private void m8148g() {
        int size = this.f5750n.size();
        if (size < this.f5749m) {
            List a;
            if (this.f5750n.isEmpty()) {
                a = this.f5739c.m8719a(this.f5748l, 50);
            } else {
                a = this.f5739c.m8720a(this.f5748l, ((C1648a) this.f5750n.get(size - 1)).m8133a().getMessageSeq(), 50);
            }
            Collections.sort(r1, C1779q.f6116c);
            this.f5750n.ensureCapacity(r1.size() + size);
            for (C1779q e : r1) {
                this.f5750n.add(new C1648a(e.m8633e()));
            }
            m8144c();
            m8145d();
            m8146e();
            C2134e.m10676b("TT-MsgListAdapt", "Loaded " + r1.size() + " more messages");
        }
    }

    public void m8150a(ConversationData conversationData) {
        this.f5747k = conversationData;
        this.f5748l = conversationData.getConversation().getConversationId();
        this.f5749m = this.f5739c.m8767d(this.f5748l);
        this.f5750n.clear();
        m8148g();
        notifyDataSetChanged();
    }

    private C1648a m8143b(int i) {
        if (i < 0 || i >= this.f5749m) {
            return null;
        }
        Object obj = null;
        int a = m8140a(i);
        while (a >= this.f5750n.size()) {
            m8148g();
            obj = 1;
        }
        if (obj != null) {
            this.f5737a.removeCallbacks(this.f5752p);
            this.f5737a.postAtFrontOfQueue(this.f5752p);
        }
        return (C1648a) this.f5750n.get(a);
    }

    public int getCount() {
        return this.f5749m;
    }

    public Object getItem(int i) {
        return m8143b(i);
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        Resources resources = viewGroup.getResources();
        C1648a b = m8143b(i);
        if (view == null) {
            view = this.f5738b.inflate(R.layout.message_item, viewGroup, false);
        }
        if (b.m8137b()) {
            view.setPadding(0, resources.getDimensionPixelSize(R.dimen.widget_spacing), 0, 0);
        } else {
            view.setPadding(0, 0, 0, 0);
        }
        ((TextView) view.findViewById(R.id.messageItem_body)).setText(m8141a(b));
        TextView textView = (TextView) view.findViewById(R.id.messageItem_timestamp);
        if (b.m8138c()) {
            textView.setText(m8142a(resources, b));
            textView.setVisibility(0);
        } else {
            textView.setVisibility(8);
        }
        textView = (TextView) view.findViewById(R.id.messageItem_status);
        int d = b.m8139d();
        if (d == -1) {
            textView.setVisibility(8);
        } else {
            textView.setText(d);
            textView.setVisibility(0);
        }
        return view;
    }

    private String m8142a(Resources resources, C1648a c1648a) {
        DateFormat dateFormat;
        if (new Date(c1648a.m8133a().getSentAt()).getYear() == new Date().getYear()) {
            dateFormat = this.f5745i;
        } else {
            dateFormat = this.f5746j;
        }
        return resources.getString(R.string.messageStatusItem_sentAt, new Object[]{this.f5744h.format(r1), dateFormat.format(r1)});
    }

    public void m8149a() {
        if (m8147f()) {
            notifyDataSetChanged();
        }
    }

    public long m8151b() {
        return 60000;
    }
}
