package android.support.v4.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Parcelable;
import android.support.v4.app.C0127a.C0117a;
import android.support.v4.app.C0181c.C0118a;
import android.support.v4.media.session.C0310a;
import android.support.v4.p008d.C0269h;
import android.support.v4.p008d.C0281i;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.List;

public class FragmentActivity extends C0116k implements C0117a, C0118a {
    static final String ALLOCATED_REQUEST_INDICIES_TAG = "android:support:request_indicies";
    static final String FRAGMENTS_TAG = "android:support:fragments";
    private static final int HONEYCOMB = 11;
    static final int MAX_NUM_PENDING_FRAGMENT_ACTIVITY_RESULTS = 65534;
    static final int MSG_REALLY_STOPPED = 1;
    static final int MSG_RESUME_PENDING = 2;
    static final String NEXT_CANDIDATE_REQUEST_INDEX_TAG = "android:support:next_request_index";
    static final String REQUEST_FRAGMENT_WHO_TAG = "android:support:request_fragment_who";
    private static final String TAG = "FragmentActivity";
    boolean mCreated;
    final C0200p mFragments = C0200p.m865a(new C0112a(this));
    final Handler mHandler = new C01101(this);
    C0310a mMediaController;
    int mNextCandidateRequestIndex;
    boolean mOptionsMenuInvalidated;
    C0281i<String> mPendingFragmentActivityResults;
    boolean mReallyStopped;
    boolean mRequestedPermissionsFromFragment;
    boolean mResumed;
    boolean mRetaining;
    boolean mStartedActivityFromFragment;
    boolean mStopped;

    class C01101 extends Handler {
        final /* synthetic */ FragmentActivity f436a;

        C01101(FragmentActivity fragmentActivity) {
            this.f436a = fragmentActivity;
        }

        public void handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    if (this.f436a.mStopped) {
                        this.f436a.doReallyStop(false);
                        return;
                    }
                    return;
                case 2:
                    this.f436a.onResumeFragments();
                    this.f436a.mFragments.m893o();
                    return;
                default:
                    super.handleMessage(message);
                    return;
            }
        }
    }

    class C0112a extends C0111q<FragmentActivity> {
        final /* synthetic */ FragmentActivity f447a;

        public /* synthetic */ Object mo97g() {
            return m555c();
        }

        public C0112a(FragmentActivity fragmentActivity) {
            this.f447a = fragmentActivity;
            super(fragmentActivity);
        }

        public void mo89a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
            this.f447a.dump(str, fileDescriptor, printWriter, strArr);
        }

        public boolean mo90a(Fragment fragment) {
            return !this.f447a.isFinishing();
        }

        public LayoutInflater mo92b() {
            return this.f447a.getLayoutInflater().cloneInContext(this.f447a);
        }

        public FragmentActivity m555c() {
            return this.f447a;
        }

        public void mo94d() {
            this.f447a.supportInvalidateOptionsMenu();
        }

        public void mo87a(Fragment fragment, Intent intent, int i, Bundle bundle) {
            this.f447a.startActivityFromFragment(fragment, intent, i, bundle);
        }

        public void mo88a(Fragment fragment, String[] strArr, int i) {
            this.f447a.requestPermissionsFromFragment(fragment, strArr, i);
        }

        public boolean mo91a(String str) {
            return C0127a.m591a(this.f447a, str);
        }

        public boolean mo95e() {
            return this.f447a.getWindow() != null;
        }

        public int mo96f() {
            Window window = this.f447a.getWindow();
            return window == null ? 0 : window.getAttributes().windowAnimations;
        }

        public void mo93b(Fragment fragment) {
            this.f447a.onAttachFragment(fragment);
        }

        public View mo85a(int i) {
            return this.f447a.findViewById(i);
        }

        public boolean mo86a() {
            Window window = this.f447a.getWindow();
            return (window == null || window.peekDecorView() == null) ? false : true;
        }
    }

    static final class C0113b {
        Object f448a;
        List<Fragment> f449b;
        C0269h<String, C0222w> f450c;

        C0113b() {
        }
    }

    public /* bridge */ /* synthetic */ View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        return super.onCreateView(view, str, context, attributeSet);
    }

    public /* bridge */ /* synthetic */ View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return super.onCreateView(str, context, attributeSet);
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        this.mFragments.m881c();
        int i3 = i >> 16;
        if (i3 != 0) {
            int i4 = i3 - 1;
            String str = (String) this.mPendingFragmentActivityResults.m1179a(i4);
            this.mPendingFragmentActivityResults.m1185c(i4);
            if (str == null) {
                Log.w(TAG, "Activity result delivered for unknown Fragment.");
                return;
            }
            Fragment a = this.mFragments.m866a(str);
            if (a == null) {
                Log.w(TAG, "Activity result no fragment exists for who: " + str);
                return;
            } else {
                a.onActivityResult(65535 & i, i2, intent);
                return;
            }
        }
        super.onActivityResult(i, i2, intent);
    }

    public void onBackPressed() {
        if (!this.mFragments.m867a().mo155c()) {
            onBackPressedNotHandled();
        }
    }

    public final void setSupportMediaController(C0310a c0310a) {
        this.mMediaController = c0310a;
        if (VERSION.SDK_INT >= 21) {
            C0180b.m789a((Activity) this, c0310a.m1271a());
        }
    }

    public final C0310a getSupportMediaController() {
        return this.mMediaController;
    }

    public void supportFinishAfterTransition() {
        C0127a.m592b(this);
    }

    public void setEnterSharedElementCallback(as asVar) {
        C0127a.m589a((Activity) this, asVar);
    }

    public void setExitSharedElementCallback(as asVar) {
        C0127a.m593b(this, asVar);
    }

    public void supportPostponeEnterTransition() {
        C0127a.m594c(this);
    }

    public void supportStartPostponedEnterTransition() {
        C0127a.m595d(this);
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.mFragments.m869a(configuration);
    }

    protected void onCreate(Bundle bundle) {
        this.mFragments.m871a(null);
        super.onCreate(bundle);
        C0113b c0113b = (C0113b) getLastNonConfigurationInstance();
        if (c0113b != null) {
            this.mFragments.m872a(c0113b.f450c);
        }
        if (bundle != null) {
            this.mFragments.m870a(bundle.getParcelable(FRAGMENTS_TAG), c0113b != null ? c0113b.f449b : null);
            if (bundle.containsKey(NEXT_CANDIDATE_REQUEST_INDEX_TAG)) {
                this.mNextCandidateRequestIndex = bundle.getInt(NEXT_CANDIDATE_REQUEST_INDEX_TAG);
                int[] intArray = bundle.getIntArray(ALLOCATED_REQUEST_INDICIES_TAG);
                String[] stringArray = bundle.getStringArray(REQUEST_FRAGMENT_WHO_TAG);
                if (intArray == null || stringArray == null || intArray.length != stringArray.length) {
                    Log.w(TAG, "Invalid requestCode mapping in savedInstanceState.");
                } else {
                    this.mPendingFragmentActivityResults = new C0281i(intArray.length);
                    for (int i = 0; i < intArray.length; i++) {
                        this.mPendingFragmentActivityResults.m1183b(intArray[i], stringArray[i]);
                    }
                }
            }
        }
        if (this.mPendingFragmentActivityResults == null) {
            this.mPendingFragmentActivityResults = new C0281i();
            this.mNextCandidateRequestIndex = 0;
        }
        this.mFragments.m884f();
    }

    public boolean onCreatePanelMenu(int i, Menu menu) {
        if (i != 0) {
            return super.onCreatePanelMenu(i, menu);
        }
        boolean onCreatePanelMenu = super.onCreatePanelMenu(i, menu) | this.mFragments.m876a(menu, getMenuInflater());
        if (VERSION.SDK_INT >= 11) {
            return onCreatePanelMenu;
        }
        return true;
    }

    final View dispatchFragmentsOnCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        return this.mFragments.m868a(view, str, context, attributeSet);
    }

    protected void onDestroy() {
        super.onDestroy();
        doReallyStop(false);
        this.mFragments.m891m();
        this.mFragments.m895q();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (VERSION.SDK_INT >= 5 || i != 4 || keyEvent.getRepeatCount() != 0) {
            return super.onKeyDown(i, keyEvent);
        }
        onBackPressed();
        return true;
    }

    public void onLowMemory() {
        super.onLowMemory();
        this.mFragments.m892n();
    }

    public boolean onMenuItemSelected(int i, MenuItem menuItem) {
        if (super.onMenuItemSelected(i, menuItem)) {
            return true;
        }
        switch (i) {
            case 0:
                return this.mFragments.m877a(menuItem);
            case 6:
                return this.mFragments.m880b(menuItem);
            default:
                return false;
        }
    }

    public void onPanelClosed(int i, Menu menu) {
        switch (i) {
            case 0:
                this.mFragments.m879b(menu);
                break;
        }
        super.onPanelClosed(i, menu);
    }

    protected void onPause() {
        super.onPause();
        this.mResumed = false;
        if (this.mHandler.hasMessages(2)) {
            this.mHandler.removeMessages(2);
            onResumeFragments();
        }
        this.mFragments.m888j();
    }

    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        this.mFragments.m881c();
    }

    public void onStateNotSaved() {
        this.mFragments.m881c();
    }

    protected void onResume() {
        super.onResume();
        this.mHandler.sendEmptyMessage(2);
        this.mResumed = true;
        this.mFragments.m893o();
    }

    protected void onPostResume() {
        super.onPostResume();
        this.mHandler.removeMessages(2);
        onResumeFragments();
        this.mFragments.m893o();
    }

    protected void onResumeFragments() {
        this.mFragments.m887i();
    }

    public boolean onPreparePanel(int i, View view, Menu menu) {
        if (i != 0 || menu == null) {
            return super.onPreparePanel(i, view, menu);
        }
        if (this.mOptionsMenuInvalidated) {
            this.mOptionsMenuInvalidated = false;
            menu.clear();
            onCreatePanelMenu(i, menu);
        }
        return onPrepareOptionsPanel(view, menu) | this.mFragments.m875a(menu);
    }

    protected boolean onPrepareOptionsPanel(View view, Menu menu) {
        return super.onPreparePanel(0, view, menu);
    }

    public final Object onRetainNonConfigurationInstance() {
        if (this.mStopped) {
            doReallyStop(true);
        }
        Object onRetainCustomNonConfigurationInstance = onRetainCustomNonConfigurationInstance();
        List e = this.mFragments.m883e();
        C0269h s = this.mFragments.m897s();
        if (e == null && s == null && onRetainCustomNonConfigurationInstance == null) {
            return null;
        }
        Object c0113b = new C0113b();
        c0113b.f448a = onRetainCustomNonConfigurationInstance;
        c0113b.f449b = e;
        c0113b.f450c = s;
        return c0113b;
    }

    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        Parcelable d = this.mFragments.m882d();
        if (d != null) {
            bundle.putParcelable(FRAGMENTS_TAG, d);
        }
        if (this.mPendingFragmentActivityResults.m1181b() > 0) {
            bundle.putInt(NEXT_CANDIDATE_REQUEST_INDEX_TAG, this.mNextCandidateRequestIndex);
            int[] iArr = new int[this.mPendingFragmentActivityResults.m1181b()];
            String[] strArr = new String[this.mPendingFragmentActivityResults.m1181b()];
            for (int i = 0; i < this.mPendingFragmentActivityResults.m1181b(); i++) {
                iArr[i] = this.mPendingFragmentActivityResults.m1186d(i);
                strArr[i] = (String) this.mPendingFragmentActivityResults.m1187e(i);
            }
            bundle.putIntArray(ALLOCATED_REQUEST_INDICIES_TAG, iArr);
            bundle.putStringArray(REQUEST_FRAGMENT_WHO_TAG, strArr);
        }
    }

    protected void onStart() {
        super.onStart();
        this.mStopped = false;
        this.mReallyStopped = false;
        this.mHandler.removeMessages(1);
        if (!this.mCreated) {
            this.mCreated = true;
            this.mFragments.m885g();
        }
        this.mFragments.m881c();
        this.mFragments.m893o();
        this.mFragments.m894p();
        this.mFragments.m886h();
        this.mFragments.m896r();
    }

    protected void onStop() {
        super.onStop();
        this.mStopped = true;
        this.mHandler.sendEmptyMessage(1);
        this.mFragments.m889k();
    }

    public Object onRetainCustomNonConfigurationInstance() {
        return null;
    }

    public Object getLastCustomNonConfigurationInstance() {
        C0113b c0113b = (C0113b) getLastNonConfigurationInstance();
        return c0113b != null ? c0113b.f448a : null;
    }

    public void supportInvalidateOptionsMenu() {
        if (VERSION.SDK_INT >= 11) {
            C0182d.m795a(this);
        } else {
            this.mOptionsMenuInvalidated = true;
        }
    }

    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        String str2;
        if (VERSION.SDK_INT >= 11) {
            printWriter.print(str);
            printWriter.print("Local FragmentActivity ");
            printWriter.print(Integer.toHexString(System.identityHashCode(this)));
            printWriter.println(" State:");
            str2 = str + "  ";
            printWriter.print(str2);
            printWriter.print("mCreated=");
            printWriter.print(this.mCreated);
            printWriter.print("mResumed=");
            printWriter.print(this.mResumed);
            printWriter.print(" mStopped=");
            printWriter.print(this.mStopped);
            printWriter.print(" mReallyStopped=");
            printWriter.println(this.mReallyStopped);
            this.mFragments.m873a(str2, fileDescriptor, printWriter, strArr);
            this.mFragments.m867a().mo153a(str, fileDescriptor, printWriter, strArr);
            printWriter.print(str);
            printWriter.println("View Hierarchy:");
            dumpViewHierarchy(str + "  ", printWriter, getWindow().getDecorView());
        } else {
            printWriter.print(str);
            printWriter.print("Local FragmentActivity ");
            printWriter.print(Integer.toHexString(System.identityHashCode(this)));
            printWriter.println(" State:");
            str2 = str + "  ";
            printWriter.print(str2);
            printWriter.print("mCreated=");
            printWriter.print(this.mCreated);
            printWriter.print("mResumed=");
            printWriter.print(this.mResumed);
            printWriter.print(" mStopped=");
            printWriter.print(this.mStopped);
            printWriter.print(" mReallyStopped=");
            printWriter.println(this.mReallyStopped);
            this.mFragments.m873a(str2, fileDescriptor, printWriter, strArr);
            this.mFragments.m867a().mo153a(str, fileDescriptor, printWriter, strArr);
            printWriter.print(str);
            printWriter.println("View Hierarchy:");
            dumpViewHierarchy(str + "  ", printWriter, getWindow().getDecorView());
        }
    }

    private static String viewToString(View view) {
        char c;
        char c2 = 'F';
        char c3 = '.';
        StringBuilder stringBuilder = new StringBuilder(128);
        stringBuilder.append(view.getClass().getName());
        stringBuilder.append('{');
        stringBuilder.append(Integer.toHexString(System.identityHashCode(view)));
        stringBuilder.append(' ');
        switch (view.getVisibility()) {
            case 0:
                stringBuilder.append('V');
                break;
            case 4:
                stringBuilder.append('I');
                break;
            case 8:
                stringBuilder.append('G');
                break;
            default:
                stringBuilder.append('.');
                break;
        }
        if (view.isFocusable()) {
            c = 'F';
        } else {
            c = '.';
        }
        stringBuilder.append(c);
        if (view.isEnabled()) {
            c = 'E';
        } else {
            c = '.';
        }
        stringBuilder.append(c);
        stringBuilder.append(view.willNotDraw() ? '.' : 'D');
        if (view.isHorizontalScrollBarEnabled()) {
            c = 'H';
        } else {
            c = '.';
        }
        stringBuilder.append(c);
        if (view.isVerticalScrollBarEnabled()) {
            c = 'V';
        } else {
            c = '.';
        }
        stringBuilder.append(c);
        if (view.isClickable()) {
            c = 'C';
        } else {
            c = '.';
        }
        stringBuilder.append(c);
        if (view.isLongClickable()) {
            c = 'L';
        } else {
            c = '.';
        }
        stringBuilder.append(c);
        stringBuilder.append(' ');
        if (!view.isFocused()) {
            c2 = '.';
        }
        stringBuilder.append(c2);
        if (view.isSelected()) {
            c = 'S';
        } else {
            c = '.';
        }
        stringBuilder.append(c);
        if (view.isPressed()) {
            c3 = 'P';
        }
        stringBuilder.append(c3);
        stringBuilder.append(' ');
        stringBuilder.append(view.getLeft());
        stringBuilder.append(',');
        stringBuilder.append(view.getTop());
        stringBuilder.append('-');
        stringBuilder.append(view.getRight());
        stringBuilder.append(',');
        stringBuilder.append(view.getBottom());
        int id = view.getId();
        if (id != -1) {
            stringBuilder.append(" #");
            stringBuilder.append(Integer.toHexString(id));
            Resources resources = view.getResources();
            if (!(id == 0 || resources == null)) {
                String str;
                switch (-16777216 & id) {
                    case 16777216:
                        str = "android";
                        break;
                    case 2130706432:
                        str = "app";
                        break;
                    default:
                        try {
                            str = resources.getResourcePackageName(id);
                            break;
                        } catch (NotFoundException e) {
                            break;
                        }
                }
                String resourceTypeName = resources.getResourceTypeName(id);
                String resourceEntryName = resources.getResourceEntryName(id);
                stringBuilder.append(" ");
                stringBuilder.append(str);
                stringBuilder.append(":");
                stringBuilder.append(resourceTypeName);
                stringBuilder.append("/");
                stringBuilder.append(resourceEntryName);
            }
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    private void dumpViewHierarchy(String str, PrintWriter printWriter, View view) {
        printWriter.print(str);
        if (view == null) {
            printWriter.println("null");
            return;
        }
        printWriter.println(viewToString(view));
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            if (childCount > 0) {
                String str2 = str + "  ";
                for (int i = 0; i < childCount; i++) {
                    dumpViewHierarchy(str2, printWriter, viewGroup.getChildAt(i));
                }
            }
        }
    }

    void doReallyStop(boolean z) {
        if (!this.mReallyStopped) {
            this.mReallyStopped = true;
            this.mRetaining = z;
            this.mHandler.removeMessages(1);
            onReallyStop();
        }
    }

    void onReallyStop() {
        this.mFragments.m874a(this.mRetaining);
        this.mFragments.m890l();
    }

    public void onAttachFragment(Fragment fragment) {
    }

    public C0202r getSupportFragmentManager() {
        return this.mFragments.m867a();
    }

    public C0222w getSupportLoaderManager() {
        return this.mFragments.m878b();
    }

    public void startActivityForResult(Intent intent, int i) {
        if (this.mStartedActivityFromFragment || i == -1 || (-65536 & i) == 0) {
            super.startActivityForResult(intent, i);
            return;
        }
        throw new IllegalArgumentException("Can only use lower 16 bits for requestCode");
    }

    public final void validateRequestPermissionsRequestCode(int i) {
        if (!this.mRequestedPermissionsFromFragment && i != -1 && (-65536 & i) != 0) {
            throw new IllegalArgumentException("Can only use lower 16 bits for requestCode");
        }
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        int i2 = (i >> 16) & 65535;
        if (i2 != 0) {
            int i3 = i2 - 1;
            String str = (String) this.mPendingFragmentActivityResults.m1179a(i3);
            this.mPendingFragmentActivityResults.m1185c(i3);
            if (str == null) {
                Log.w(TAG, "Activity result delivered for unknown Fragment.");
                return;
            }
            Fragment a = this.mFragments.m866a(str);
            if (a == null) {
                Log.w(TAG, "Activity result no fragment exists for who: " + str);
            } else {
                a.onRequestPermissionsResult(i & 65535, strArr, iArr);
            }
        }
    }

    public void startActivityFromFragment(Fragment fragment, Intent intent, int i) {
        startActivityFromFragment(fragment, intent, i, null);
    }

    public void startActivityFromFragment(Fragment fragment, Intent intent, int i, Bundle bundle) {
        this.mStartedActivityFromFragment = true;
        if (i == -1) {
            try {
                C0127a.m587a(this, intent, -1, bundle);
            } finally {
                this.mStartedActivityFromFragment = false;
            }
        } else if ((-65536 & i) != 0) {
            throw new IllegalArgumentException("Can only use lower 16 bits for requestCode");
        } else {
            C0127a.m587a(this, intent, ((allocateRequestIndex(fragment) + 1) << 16) + (65535 & i), bundle);
            this.mStartedActivityFromFragment = false;
        }
    }

    private int allocateRequestIndex(Fragment fragment) {
        if (this.mPendingFragmentActivityResults.m1181b() >= MAX_NUM_PENDING_FRAGMENT_ACTIVITY_RESULTS) {
            throw new IllegalStateException("Too many pending Fragment activity results.");
        }
        while (this.mPendingFragmentActivityResults.m1188f(this.mNextCandidateRequestIndex) >= 0) {
            this.mNextCandidateRequestIndex = (this.mNextCandidateRequestIndex + 1) % MAX_NUM_PENDING_FRAGMENT_ACTIVITY_RESULTS;
        }
        int i = this.mNextCandidateRequestIndex;
        this.mPendingFragmentActivityResults.m1183b(i, fragment.mWho);
        this.mNextCandidateRequestIndex = (this.mNextCandidateRequestIndex + 1) % MAX_NUM_PENDING_FRAGMENT_ACTIVITY_RESULTS;
        return i;
    }

    private void requestPermissionsFromFragment(Fragment fragment, String[] strArr, int i) {
        if (i == -1) {
            C0127a.m590a((Activity) this, strArr, i);
        } else if ((-65536 & i) != 0) {
            throw new IllegalArgumentException("Can only use lower 16 bits for requestCode");
        } else {
            try {
                this.mRequestedPermissionsFromFragment = true;
                C0127a.m590a((Activity) this, strArr, ((allocateRequestIndex(fragment) + 1) << 16) + (65535 & i));
            } finally {
                this.mRequestedPermissionsFromFragment = false;
            }
        }
    }
}
