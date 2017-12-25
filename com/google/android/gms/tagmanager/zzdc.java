package com.google.android.gms.tagmanager;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;

class zzdc {

    class C34441 implements Runnable {
        final /* synthetic */ Editor f12712a;

        C34441(Editor editor) {
            this.f12712a = editor;
        }

        public void run() {
            this.f12712a.commit();
        }
    }

    @SuppressLint({"CommitPrefEdits"})
    static void m18186a(Context context, String str, String str2, String str3) {
        Editor edit = context.getSharedPreferences(str, 0).edit();
        edit.putString(str2, str3);
        m18187a(edit);
    }

    static void m18187a(Editor editor) {
        if (VERSION.SDK_INT >= 9) {
            editor.apply();
        } else {
            new Thread(new C34441(editor)).start();
        }
    }
}
