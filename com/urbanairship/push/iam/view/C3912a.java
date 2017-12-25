package com.urbanairship.push.iam.view;

import com.urbanairship.push.p033a.C3869c;
import com.urbanairship.push.p033a.C3872d;

public interface C3912a {

    public interface C3893b {
        void mo2824a();
    }

    public interface C3895a {
        void mo2825a(C3869c c3869c);
    }

    void setNotificationActionButtonGroup(C3872d c3872d);

    void setOnActionClickListener(C3895a c3895a);

    void setOnDismissClickListener(C3893b c3893b);

    void setPrimaryColor(int i);

    void setSecondaryColor(int i);

    void setText(CharSequence charSequence);
}
