package com.urbanairship.messagecenter;

import android.annotation.TargetApi;
import android.util.SparseBooleanArray;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AbsListView.MultiChoiceModeListener;
import com.urbanairship.C3860o.C3852e;
import com.urbanairship.C3860o.C3854g;
import com.urbanairship.C3860o.C3855h;
import com.urbanairship.C3929q;
import com.urbanairship.richpush.C3942c;
import java.util.HashSet;
import java.util.Set;

@TargetApi(14)
public class C3840b implements MultiChoiceModeListener {
    private final MessageListFragment f13706a;

    public C3840b(MessageListFragment messageListFragment) {
        this.f13706a = messageListFragment;
    }

    public void onItemCheckedStateChanged(ActionMode actionMode, int i, long j, boolean z) {
        int checkedItemCount = this.f13706a.m19971b().getCheckedItemCount();
        actionMode.setTitle(this.f13706a.getResources().getQuantityString(C3855h.ua_selected_count, checkedItemCount, new Object[]{Integer.valueOf(checkedItemCount)}));
        this.f13706a.m19972c().notifyDataSetChanged();
        actionMode.invalidate();
    }

    public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
        boolean z = false;
        actionMode.getMenuInflater().inflate(C3854g.ua_mc_action_mode, menu);
        int checkedItemCount = this.f13706a.m19971b().getCheckedItemCount();
        actionMode.setTitle(this.f13706a.getResources().getQuantityString(C3855h.ua_selected_count, checkedItemCount, new Object[]{Integer.valueOf(checkedItemCount)}));
        SparseBooleanArray checkedItemPositions = this.f13706a.m19971b().getCheckedItemPositions();
        for (checkedItemCount = 0; checkedItemCount < checkedItemPositions.size(); checkedItemCount++) {
            if (checkedItemPositions.valueAt(checkedItemCount)) {
                C3942c a = this.f13706a.m19968a(checkedItemPositions.keyAt(checkedItemCount));
                if (!(a == null || a.m20449d())) {
                    z = true;
                    break;
                }
            }
        }
        menu.findItem(C3852e.mark_read).setVisible(z);
        return true;
    }

    public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
        boolean z = false;
        SparseBooleanArray checkedItemPositions = this.f13706a.m19971b().getCheckedItemPositions();
        for (int i = 0; i < checkedItemPositions.size(); i++) {
            if (checkedItemPositions.valueAt(i)) {
                C3942c a = this.f13706a.m19968a(checkedItemPositions.keyAt(i));
                if (!(a == null || a.m20449d())) {
                    z = true;
                    break;
                }
            }
        }
        menu.findItem(C3852e.mark_read).setVisible(z);
        return true;
    }

    public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
        if (menuItem.getItemId() == C3852e.mark_read) {
            C3929q.m20372a().m20391o().m20436a(m19988a());
            actionMode.finish();
        } else if (menuItem.getItemId() == C3852e.delete) {
            C3929q.m20372a().m20391o().m20441b(m19988a());
            actionMode.finish();
        } else if (menuItem.getItemId() == C3852e.select_all) {
            int count = this.f13706a.m19971b().getCount();
            for (int i = 0; i < count; i++) {
                this.f13706a.m19971b().setItemChecked(i, true);
            }
        }
        return true;
    }

    public void onDestroyActionMode(ActionMode actionMode) {
    }

    private Set<String> m19988a() {
        SparseBooleanArray checkedItemPositions = this.f13706a.m19971b().getCheckedItemPositions();
        Set<String> hashSet = new HashSet();
        for (int i = 0; i < checkedItemPositions.size(); i++) {
            if (checkedItemPositions.valueAt(i)) {
                C3942c a = this.f13706a.m19968a(checkedItemPositions.keyAt(i));
                if (a != null) {
                    hashSet.add(a.m20446a());
                }
            }
        }
        return hashSet;
    }
}
