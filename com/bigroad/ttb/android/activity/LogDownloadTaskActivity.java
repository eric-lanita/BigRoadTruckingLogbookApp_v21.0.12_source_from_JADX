package com.bigroad.ttb.android.activity;

import android.app.DownloadManager;
import android.os.Bundle;
import com.bigroad.ttb.android.ConnectivityTracker.Connectivity;
import com.bigroad.ttb.android.OurApplication;
import com.bigroad.ttb.android.R;
import com.bigroad.ttb.android.activity.OurActivity.Feature;
import com.bigroad.ttb.android.activity.OurActivity.TitleStyle;
import com.bigroad.ttb.android.dialog.AsyncTaskDialogFragment;
import com.bigroad.ttb.android.dialog.C1830c;
import com.bigroad.ttb.android.dialog.DailyLogDetailsDialogs;
import com.bigroad.ttb.android.dialog.DailyLogDetailsDialogs.DownloadFinishedDialogFragment;
import com.bigroad.ttb.android.dialog.ErrorDialogFragment;
import com.bigroad.ttb.android.dialog.LogDownloadTask;
import com.bigroad.ttb.android.dialog.LogDownloadTask.SendLogOptions;
import com.bigroad.ttb.android.dialog.PrintAppChooserDialogFragment;
import com.bigroad.ttb.android.dialog.ProminentDisclosureDialogFragment;
import com.bigroad.ttb.android.dialog.ProminentDisclosureDialogFragment.C1293a;
import com.bigroad.ttb.android.logging.C2134e;
import java.io.File;
import java.util.EnumSet;

public abstract class LogDownloadTaskActivity extends PersistentTaskActivity implements C1293a {
    private PrintMode f4418a = PrintMode.UNKNOWN;
    private int f4419b = -1;
    private int f4420c = -1;

    private enum PrintMode {
        UNKNOWN,
        PRINT,
        DOWNLOAD_PRINT
    }

    public LogDownloadTaskActivity(Feature feature) {
        super(feature);
    }

    public LogDownloadTaskActivity(EnumSet<Feature> enumSet) {
        super((EnumSet) enumSet);
    }

    public LogDownloadTaskActivity(EnumSet<Feature> enumSet, TitleStyle titleStyle) {
        super(enumSet, titleStyle);
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            this.f4418a = (PrintMode) bundle.getSerializable("printMode");
        }
    }

    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putSerializable("printMode", this.f4418a);
    }

    public void m6779a(int i, int i2) {
        if (OurApplication.m6285g().m12177V()) {
            m6702U().m8300c();
            if (OurApplication.m6244A().m6111b() != Connectivity.CONNECTED) {
                ErrorDialogFragment.m8860a((OurActivity) this, (int) R.string.dailyLog_noConnectionTitle, (int) R.string.dailyLog_noConnection);
                return;
            }
            AsyncTaskDialogFragment.m8825a(new LogDownloadTask(i, i2, SendLogOptions.PRINT), getString(R.string.dailyLog_printTitle), getString(R.string.dailyLog_downloadingMessage), true).show(getSupportFragmentManager(), "dialog");
            return;
        }
        this.f4418a = PrintMode.PRINT;
        this.f4419b = i;
        this.f4420c = i2;
        new ProminentDisclosureDialogFragment().m8900a(getSupportFragmentManager());
    }

    public void m6780a(int i, SendLogOptions sendLogOptions) {
        m6702U().m8300c();
        if (sendLogOptions == SendLogOptions.PRINT && !OurApplication.m6285g().m12177V()) {
            this.f4418a = PrintMode.DOWNLOAD_PRINT;
            this.f4419b = i;
            this.f4420c = -1;
            new ProminentDisclosureDialogFragment().m8900a(getSupportFragmentManager());
        } else if (OurApplication.m6244A().m6111b() != Connectivity.CONNECTED) {
            ErrorDialogFragment.m8860a((OurActivity) this, (int) R.string.dailyLog_noConnectionTitle, (int) R.string.dailyLog_noConnection);
        } else {
            String string;
            switch (sendLogOptions) {
                case PRINT:
                    string = getString(R.string.dailyLog_printTitle);
                    break;
                case SAVE:
                    string = getString(R.string.dailyLog_downloadTitle);
                    break;
                default:
                    C2134e.m10682e("TT-LogDownloadTaskActivity", "Invalid type for dealing with a PDF download");
                    return;
            }
            AsyncTaskDialogFragment.m8825a(new LogDownloadTask(i, sendLogOptions), string, getString(R.string.dailyLog_downloadingMessage), true).show(getSupportFragmentManager(), "dialog");
        }
    }

    protected void mo941a(C1830c c1830c) {
        if (c1830c instanceof LogDownloadTask) {
            LogDownloadTask logDownloadTask = (LogDownloadTask) c1830c;
            if (logDownloadTask.m8892b() == null) {
                ErrorDialogFragment.m8860a((OurActivity) this, (int) R.string.dailyLog_downloadErrorTitle, (int) R.string.dailyLog_downloadError);
                return;
            }
            File b = logDownloadTask.m8892b();
            if (logDownloadTask.m8890a() == SendLogOptions.SAVE) {
                DailyLogDetailsDialogs.m8856a(this, new DownloadFinishedDialogFragment());
                ((DownloadManager) getSystemService("download")).addCompletedDownload(b.getName(), getString(R.string.dailyLog_downloadManagerMessage), false, "application/pdf", b.getAbsolutePath(), b.length(), false);
                return;
            }
            PrintAppChooserDialogFragment.m8895a(this, OurApplication.m6271a(b));
            return;
        }
        C2134e.m10682e("TT-LogDownloadTaskActivity", "Task must be an instance of LogDownloadTask.");
    }

    protected void mo943b(C1830c c1830c) {
        if (!(c1830c instanceof LogDownloadTask)) {
            C2134e.m10682e("TT-LogDownloadTaskActivity", "Task must be an instance of LogDownloadTask.");
        } else if (c1830c.m8888c()) {
            ErrorDialogFragment.m8860a((OurActivity) this, (int) R.string.dailyLog_connectionLostTitle, (int) R.string.dailyLog_connectionLost);
        }
    }

    public void mo942a(boolean z) {
        if (!z) {
            return;
        }
        if (this.f4418a == PrintMode.PRINT) {
            m6779a(this.f4419b, this.f4420c);
        } else {
            m6780a(this.f4419b, SendLogOptions.PRINT);
        }
    }
}
