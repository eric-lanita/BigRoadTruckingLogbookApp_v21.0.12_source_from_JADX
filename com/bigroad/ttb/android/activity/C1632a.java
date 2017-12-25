package com.bigroad.ttb.android.activity;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Parcelable;
import android.support.v4.app.Fragment;
import com.bigroad.shared.InspectionTerm;
import com.bigroad.shared.UserAuthenticationChangeBits.Reason;
import com.bigroad.shared.duty.DutyStatus;
import com.bigroad.ttb.android.OurApplication;
import com.bigroad.ttb.android.activity.DvirInspectionEditActivity.IntentExtras;
import com.bigroad.ttb.android.activity.SelectTruckActivity.Option;
import com.bigroad.ttb.android.activity.UpdateOdometerActivity.OdometerSetConfirmMode;
import com.bigroad.ttb.android.adapter.DailyLogListFilterAdapter.DailyLogListFilter;
import com.bigroad.ttb.android.logging.C2134e;
import com.bigroad.ttb.android.p030a.C1258c;
import com.bigroad.ttb.android.util.Permission;
import com.bigroad.ttb.android.util.Permission.C1464a;
import com.bigroad.ttb.protocol.TTProtocol.ActiveDrivingMode;
import com.bigroad.ttb.protocol.TTProtocol.DailyLogShareType;
import com.bigroad.ttb.protocol.TTProtocol.Dvir;
import com.bigroad.ttb.protocol.TTProtocol.DvirInspection;
import com.bigroad.ttb.protocol.TTProtocol.OdometerUnit;
import com.bigroad.ttb.protocol.TTProtocol.Person;
import com.bigroad.ttb.protocol.TTProtocol.TruckLogType;
import com.facebook.internal.NativeProtocol;
import com.google.protobuf.C3642c;
import java.util.ArrayList;
import java.util.EnumSet;

public abstract class C1632a {
    private static void m7974b(Context context, Class<? extends Activity> cls) {
        context.startActivity(new Intent(context, cls));
    }

    private static void m7938a(Activity activity, Class<? extends Activity> cls, int i, int i2) {
        Intent intent = new Intent(activity, cls);
        if (i2 >= 0) {
            intent.putExtra("com.bigroad.ttb.destinationActivity", i2);
        }
        activity.startActivityForResult(intent, i);
    }

    private static void m7937a(Activity activity, Class<? extends Activity> cls, int i) {
        C1632a.m7938a(activity, (Class) cls, i, -1);
    }

    private static void m7976b(Fragment fragment, Class<? extends Activity> cls, int i) {
        fragment.startActivityForResult(new Intent(fragment.getActivity(), cls), i);
    }

    public static void m7924a(Activity activity) {
        C1632a.m7937a(activity, WelcomeActivity.class, 1);
    }

    public static void m7934a(Activity activity, Person person) {
        Intent intent = new Intent(activity, WelcomeBackActivity.class);
        if (person != null) {
            intent.putExtra("com.bigroad.ttb.personRecord", person.toByteArray());
        }
        activity.startActivity(intent);
    }

    public static void m7966b(Activity activity) {
        Intent intent = new Intent(activity, DashboardActivity.class);
        intent.addFlags(67108864);
        intent.addFlags(536870912);
        activity.startActivity(intent);
    }

    public static void m7979c(Activity activity) {
        C1632a.m7937a(activity, DashboardActivity.class, 2);
    }

    public static void m7925a(Activity activity, int i) {
        C1632a.m7938a(activity, DashboardActivity.class, 2, i);
    }

    public static void m7984d(Activity activity) {
        C1632a.m7937a(activity, SignInActivity.class, 4);
    }

    public static void m7968b(Activity activity, Person person) {
        Intent intent = new Intent(activity, SignUpActivity.class);
        if (person != null) {
            intent.putExtra("com.bigroad.ttb.personRecord", person.toByteArray());
        }
        activity.startActivityForResult(intent, 31);
    }

    public static void m7939a(Activity activity, String str) {
        Intent intent = new Intent(activity, SignInActivity.class);
        intent.putExtra("com.bigroad.ttb.emailAddress", str);
        activity.startActivityForResult(intent, 4);
    }

    public static void m7954a(Context context, Reason reason) {
        Intent intent = new Intent(context, SignOutSignUpActivity.class);
        intent.putExtra("com.bigroad.ttb.signOutReason", reason);
        context.startActivity(intent);
    }

    public static void m7962a(OurActivity ourActivity, EnumSet<Option> enumSet) {
        Intent intent = new Intent(ourActivity, SelectTruckActivity.class);
        intent.putExtra("com.bigroad.ttb.loadTruckList", enumSet.contains(Option.LOAD_TRUCK_LIST));
        intent.putExtra("com.bigroad.ttb.allowUnknown", enumSet.contains(Option.ALLOW_UNKNOWN_TRUCK));
        intent.putExtra("com.bigroad.ttb.requireTitle", enumSet.contains(Option.REQUIRE_TITLE));
        intent.putExtra("com.bigroad.ttb.withoutEobrTrucks", enumSet.contains(Option.WITHOUT_EOBR_TRUCKS));
        ourActivity.startActivityForResult(intent, 13);
    }

    public static void m7977b(OurActivity ourActivity, EnumSet<Option> enumSet) {
        Intent intent = new Intent(ourActivity, SelectTruckActivity.class);
        intent.putExtra("com.bigroad.ttb.loadTruckList", enumSet.contains(Option.LOAD_TRUCK_LIST));
        intent.putExtra("com.bigroad.ttb.allowUnknown", enumSet.contains(Option.ALLOW_UNKNOWN_TRUCK));
        intent.putExtra("com.bigroad.ttb.requireTitle", enumSet.contains(Option.REQUIRE_TITLE));
        ourActivity.startActivityForResult(intent, 26);
    }

    public static void m7963a(OurActivity ourActivity, EnumSet<Option> enumSet, DutyStatus dutyStatus) {
        Intent intent = new Intent(ourActivity, SelectTruckActivity.class);
        intent.putExtra("com.bigroad.ttb.loadTruckList", enumSet.contains(Option.LOAD_TRUCK_LIST));
        intent.putExtra("com.bigroad.ttb.allowUnknown", enumSet.contains(Option.ALLOW_UNKNOWN_TRUCK));
        intent.putExtra("com.bigroad.ttb.requireTitle", enumSet.contains(Option.REQUIRE_TITLE));
        intent.putExtra("com.bigroad.ttb.pendingDutyStatus", dutyStatus.m4394b());
        ourActivity.startActivityForResult(intent, 26);
    }

    public static void m7969b(Activity activity, String str) {
        Intent intent = new Intent(activity, NewTruckActivity.class);
        intent.putExtra("com.bigroad.ttb.truckNumber", str);
        activity.startActivityForResult(intent, 25);
    }

    public static void m7940a(Activity activity, String str, OdometerUnit odometerUnit) {
        Intent intent = new Intent(activity, DashLinkDiscoveryActivity.class);
        intent.putExtra("com.bigroad.ttb.truckNumber", str);
        intent.putExtra("com.bigroad.ttb.odometerUnit", odometerUnit);
        activity.startActivityForResult(intent, 27);
    }

    public static void m7941a(Activity activity, String str, String str2, String str3, ArrayList<String> arrayList) {
        Intent intent = new Intent(activity, DashLinkDupActivity.class);
        intent.putExtra("com.bigroad.ttb.truckNumber", str);
        intent.putExtra("com.bigroad.ttb.vin", str2);
        intent.putExtra("com.bigroad.ttb.macAddress", str3);
        intent.putStringArrayListExtra("com.bigroad.ttb.truckNumberList", arrayList);
        activity.startActivityForResult(intent, 28);
    }

    public static void m7987e(Activity activity) {
        C1632a.m7937a(activity, EulaActivity.class, 15);
    }

    public static void m7944a(Context context) {
        C1632a.m7974b(context, DashLinkActivity.class);
    }

    public static void m7970b(Context context) {
        C1632a.m7974b(context, ClockSkewActivity.class);
    }

    public static void m7990f(Activity activity) {
        C1632a.m7937a(activity, SettingsActivity.class, 5);
    }

    public static void m7993g(Activity activity) {
        C1632a.m7937a(activity, ChangePasswordActivity.class, 12);
    }

    public static void m7995h(Activity activity) {
        C1632a.m7937a(activity, ChangeEmailActivity.class, 20);
    }

    public static void m7982c(Context context) {
        C1632a.m7974b(context, UpdateOdometerActivity.class);
    }

    public static void m7932a(Activity activity, OdometerSetConfirmMode odometerSetConfirmMode, String str, OdometerUnit odometerUnit, long j, int i) {
        Intent intent = new Intent(activity, UpdateOdometerActivity.class);
        intent.putExtra("com.bigroad.ttb.odometerToSet", odometerSetConfirmMode);
        intent.putExtra("com.bigroad.ttb.truckNumber", str);
        intent.putExtra("com.bigroad.ttb.odometerUnit", odometerUnit);
        intent.putExtra("com.bigroad.ttb.odometerValue", j);
        intent.putExtra("com.bigroad.ttb.noteResId", i);
        activity.startActivityForResult(intent, 32);
    }

    public static void m7997i(Activity activity) {
        Intent intent = new Intent(activity, EditPersonActivity.class);
        intent.putExtra("com.bigroad.ttb.showApprovalMessage", true);
        activity.startActivityForResult(intent, 22);
    }

    public static void m7999j(Activity activity) {
        C1632a.m7937a(activity, CreateAccountActivity.class, 30);
    }

    public static void m8001k(Activity activity) {
        C1632a.m7937a(activity, ChangeTimeZoneActivity.class, 0);
    }

    public static void m7967b(Activity activity, int i) {
        Intent intent = new Intent(activity, ChangeTimeZoneActivity.class);
        intent.putExtra("com.bigroad.ttb.logDay", i);
        activity.startActivityForResult(intent, 0);
    }

    public static void m8003l(Activity activity) {
        C1632a.m7937a(activity, ChangeSignatureActivity.class, 24);
    }

    public static void m7942a(Activity activity, byte[] bArr) {
        Intent intent = new Intent(activity, SelectDrivingDutyStatusActivity.class);
        intent.putExtra("com.bigroad.ttb.eventId", bArr);
        activity.startActivity(intent);
    }

    public static void m7943a(Activity activity, byte[] bArr, int i) {
        Intent intent = new Intent(activity, ContinueDrivingPromptActivity.class);
        intent.putExtra("com.bigroad.ttb.eventId", bArr);
        intent.putExtra("com.bigroad.ttb.promptTimeout", i);
        activity.startActivity(intent);
    }

    public static void m7933a(Activity activity, ActiveDrivingMode activeDrivingMode, int i) {
        Intent intent = new Intent(activity, ConfirmDrivingModeActivity.class);
        intent.putExtra("com.bigroad.ttb.drivingMode", activeDrivingMode.m12379a());
        intent.putExtra("com.bigroad.ttb.promptTimeout", i);
        activity.startActivity(intent);
    }

    public static void m8006m(Activity activity) {
        C1632a.m7937a(activity, HosChooserActivity.class, 21);
    }

    public static void m7980c(Activity activity, int i) {
        Intent intent = new Intent(activity, HosChooserActivity.class);
        intent.putExtra("com.bigroad.ttb.logDay", i);
        activity.startActivityForResult(intent, 21);
    }

    public static void m7985d(Activity activity, int i) {
        Intent intent = new Intent(activity, RecapChooserActivity.class);
        intent.putExtra("com.bigroad.ttb.logDay", i);
        activity.startActivity(intent);
    }

    public static void m7986d(Context context) {
        C1632a.m7974b(context, EditNoteActivity.class);
    }

    public static void m7989e(Context context) {
        C1632a.m7974b(context, CheckInActivity.class);
    }

    public static void m7992f(Context context) {
        C1632a.m7974b(context, HosSummaryActivity.class);
    }

    public static void m7956a(Context context, Class cls) {
        Intent intent = new Intent(context, cls);
        intent.addFlags(67108864);
        intent.addFlags(536870912);
        context.startActivity(intent);
    }

    public static void m7957a(Context context, int[] iArr) {
        Intent intent = new Intent(context, ClaimUnassignedDrivingActivity.class);
        intent.putExtra("com.bigroad.ttb.logDaysWithUnclaimedEvents", iArr);
        context.startActivity(intent);
    }

    public static void m7945a(Context context, int i) {
        Intent intent = new Intent(context, DailyLogEditActivity.class);
        intent.putExtra("com.bigroad.ttb.logDay", i);
        context.startActivity(intent);
    }

    public static void m7994g(Context context) {
        C1632a.m7955a(context, DailyLogListFilter.ALL);
    }

    public static void m7955a(Context context, DailyLogListFilter dailyLogListFilter) {
        Intent intent = new Intent(context, DailyLogListActivity.class);
        intent.putExtra("com.bigroad.ttb.dailyLogListFilter", dailyLogListFilter);
        context.startActivity(intent);
    }

    public static void m7947a(Context context, int i, int i2, DailyLogShareType dailyLogShareType) {
        Intent intent = new Intent(context, DailyLogSendActivity.class);
        intent.putExtra("com.bigroad.ttb.logDay", i);
        intent.putExtra("com.bigroad.ttb.logDayEnd", i2);
        intent.putExtra("com.bigroad.ttb.shareType", dailyLogShareType.m13309a());
        context.startActivity(intent);
    }

    public static void m7946a(Context context, int i, int i2) {
        Intent intent = new Intent(context, DailyLogFaxActivity.class);
        intent.putExtra("com.bigroad.ttb.logDay", i);
        intent.putExtra("com.bigroad.ttb.logDayEnd", i2);
        context.startActivity(intent);
    }

    public static void m7953a(Context context, InspectionTerm inspectionTerm, boolean z) {
        Intent intent = new Intent(context, DailyLogInspectFmcsaActivity.class);
        intent.putExtra("com.bigroad.ttb.inspectionTerm", inspectionTerm);
        intent.putExtra("com.bigroad.ttb.fmcsaErodsUseEmail", z);
        context.startActivity(intent);
    }

    public static void m7930a(Activity activity, InspectionTerm inspectionTerm, TruckLogType truckLogType) {
        Intent intent = new Intent(activity, DailyLogInspectSelectionActivity.class);
        intent.putExtra("com.bigroad.ttb.inspectionTerm", inspectionTerm.ordinal());
        intent.putExtra("com.bigroad.ttb.truckLogType", truckLogType.m15635a());
        activity.startActivityForResult(intent, 29);
    }

    public static void m7951a(Context context, InspectionTerm inspectionTerm, TruckLogType truckLogType) {
        Intent intent = new Intent(context, DailyLogInspectInstructionActivity.class);
        intent.putExtra("com.bigroad.ttb.inspectionTerm", inspectionTerm.ordinal());
        intent.putExtra("com.bigroad.ttb.truckLogType", truckLogType.m15635a());
        context.startActivity(intent);
    }

    public static void m7973b(Context context, InspectionTerm inspectionTerm, TruckLogType truckLogType) {
        Intent intent = new Intent(context, DailyLogInspectSummaryActivity.class);
        intent.putExtra("com.bigroad.ttb.inspectionTerm", inspectionTerm.ordinal());
        intent.putExtra("com.bigroad.ttb.truckLogType", truckLogType.m15635a());
        context.startActivity(intent);
    }

    public static void m7996h(Context context) {
        context.startActivity(new Intent(context, DailyLogInspectCurrentHeaderActivity.class));
    }

    public static void m7952a(Context context, InspectionTerm inspectionTerm, TruckLogType truckLogType, int i) {
        Intent intent = new Intent(context, DailyLogInspectActivity.class);
        intent.putExtra("com.bigroad.ttb.inspectionTerm", inspectionTerm.ordinal());
        intent.putExtra("com.bigroad.ttb.truckLogType", truckLogType.m15635a());
        intent.putExtra("com.bigroad.ttb.logDay", i);
        context.startActivity(intent);
    }

    public static void m7983c(Context context, InspectionTerm inspectionTerm, TruckLogType truckLogType) {
        Intent intent = new Intent(context, DailyLogListInspectActivity.class);
        intent.putExtra("com.bigroad.ttb.inspectionTerm", inspectionTerm);
        intent.putExtra("com.bigroad.ttb.truckLogType", truckLogType);
        context.startActivity(intent);
    }

    public static void m7971b(Context context, int i) {
        Intent intent = new Intent(context, UnassignedDrivingInspectActivity.class);
        intent.putExtra("com.bigroad.ttb.logDayWithUnclaimedEvents", i);
        context.startActivity(intent);
    }

    public static void m7950a(Context context, InspectionTerm inspectionTerm) {
        Intent intent = new Intent(context, MalfunctionInspectActivity.class);
        intent.putExtra("com.bigroad.ttb.inspectionTerm", inspectionTerm);
        context.startActivity(intent);
    }

    public static void m7972b(Context context, InspectionTerm inspectionTerm) {
        Intent intent = new Intent(context, DiagnosticInspectActivity.class);
        intent.putExtra("com.bigroad.ttb.inspectionTerm", inspectionTerm);
        context.startActivity(intent);
    }

    public static void m7998i(Context context) {
        C1632a.m7974b(context, ConversationListActivity.class);
    }

    public static void m7948a(Context context, long j) {
        Intent intent = new Intent(context, ConversationActivity.class);
        intent.putExtra("com.bigroad.ttb.conversationId", j);
        context.startActivity(intent);
    }

    public static void m8000j(Context context) {
        C1632a.m7974b(context, ShareActivity.class);
    }

    public static void m8007n(Activity activity) {
        C1632a.m7937a(activity, ContactPickerActivity.class, 9);
    }

    public static void m7958a(final Fragment fragment) {
        Permission.CAMERA.m11150a(new C1464a() {
            public void mo1003a() {
                C1632a.m7976b(fragment, PhotoCaptureActivity.class, 3);
            }

            public void mo1004b() {
                C2134e.m10676b("TT-Activities", "User denied camera request");
            }
        });
    }

    public static void m7961a(final Fragment fragment, final String[] strArr) {
        if (OurApplication.m6285g().m12177V()) {
            Permission.READ_CONTACTS.m11150a(new C1464a() {
                public void mo1003a() {
                    Intent intent = new Intent(fragment.getActivity(), EmailContactPickerActivity.class);
                    if (strArr != null) {
                        intent.putExtra("com.bigroad.ttb.stringArray", strArr);
                    }
                    fragment.startActivityForResult(intent, 14);
                }

                public void mo1004b() {
                    C2134e.m10676b("TT-Activities", "User denied contacts request");
                }
            });
        } else {
            C2134e.m10676b("TT-Activities", "User hasn't accepted the data collection agreement.");
        }
    }

    public static void m7975b(Fragment fragment) {
        Intent intent = new Intent("android.intent.action.GET_CONTENT");
        intent.setType("image/*");
        intent.addCategory("android.intent.category.OPENABLE");
        intent.putExtra("android.intent.extra.LOCAL_ONLY", true);
        fragment.startActivityForResult(intent, 6);
    }

    private static Intent m7922a(String str) {
        Intent intent = new Intent("android.speech.action.RECOGNIZE_SPEECH");
        intent.putExtra("android.speech.extra.LANGUAGE_MODEL", "free_form");
        if (str != null) {
            intent.putExtra("android.speech.extra.PROMPT", str);
        }
        return intent;
    }

    public static void m7981c(Activity activity, String str) {
        activity.startActivityForResult(C1632a.m7922a(str), 8);
    }

    public static void m7960a(Fragment fragment, String str) {
        fragment.startActivityForResult(C1632a.m7922a(str), 8);
    }

    public static void m8009o(Activity activity) {
        activity.startActivityForResult(new Intent("android.bluetooth.adapter.action.REQUEST_ENABLE"), 23);
    }

    public static void m8002k(Context context) {
        context.startActivity(new Intent("android.settings.DATE_SETTINGS"));
    }

    public static void m7929a(Activity activity, int i, byte[] bArr, boolean z) {
        Intent intent = new Intent(activity, DailyLogEditEventActivity.class);
        intent.putExtra("com.bigroad.ttb.logDay", i);
        intent.putExtra("com.bigroad.ttb.eventId", bArr);
        intent.putExtra("com.bigroad.ttb.isFixing", z);
        activity.startActivityForResult(intent, 11);
    }

    public static void m7927a(Activity activity, int i, ActiveDrivingMode activeDrivingMode) {
        Intent intent = new Intent(activity, DailyLogEditEventAnnotationActivity.class);
        intent.putExtra("com.bigroad.ttb.logDay", i);
        intent.putExtra("com.bigroad.ttb.drivingMode", activeDrivingMode.m12379a());
        activity.startActivityForResult(intent, 34);
    }

    public static void m7926a(Activity activity, int i, long j, boolean z, boolean z2) {
        Intent intent = new Intent(activity, DailyLogAddEventActivity.class);
        intent.putExtra("com.bigroad.ttb.logDay", i);
        intent.putExtra("com.bigroad.ttb.eventStart", j);
        intent.putExtra("com.bigroad.ttb.isRealTime", z);
        intent.putExtra("com.bigroad.ttb.addingEldEvent", z2);
        activity.startActivityForResult(intent, 10);
    }

    public static void m7935a(Activity activity, C3642c c3642c, int i) {
        Intent intent = new Intent(activity, NewInspectionActivity.class);
        if (c3642c != null) {
            intent.putExtra("com.bigroad.ttb.dvirId", c3642c.m19091d());
        }
        intent.putExtra("com.bigroad.ttb.logDay", i);
        activity.startActivityForResult(intent, 18);
    }

    public static void m7931a(Activity activity, IntentExtras intentExtras, boolean z) {
        Intent intent = new Intent(activity, DvirInspectionEditActivity.class);
        intent.putExtra("com.bigroad.ttb.dvirInspectionActivity", intentExtras);
        intent.putExtra("com.bigroad.ttb.useCurrentLoc", z);
        activity.startActivityForResult(intent, 17);
    }

    public static boolean m7965a(OurActivity ourActivity, DvirInspection dvirInspection, boolean z) {
        Dvir a = OurApplication.m6297s().m10970a(dvirInspection);
        if (a == null || dvirInspection == null) {
            String str = "null";
            if (!(dvirInspection == null || dvirInspection.getId() == null)) {
                str = dvirInspection.getId().toString();
            }
            C2134e.m10680d("TT-Activities", "Unable to start DVIR inspection edit activity; no DVIR found for inspection: " + str);
            return false;
        }
        Parcelable a2 = IntentExtras.m7491a(a, dvirInspection);
        Intent intent = new Intent(ourActivity, DvirInspectionEditActivity.class);
        intent.putExtra("com.bigroad.ttb.dvirInspectionActivity", a2);
        intent.putExtra("com.bigroad.ttb.isFixing", z);
        ourActivity.startActivityForResult(intent, 17);
        return true;
    }

    public static void m7936a(Activity activity, C3642c c3642c, boolean z) {
        Intent intent = new Intent(activity, DvirHeaderEditActivity.class);
        intent.putExtra("com.bigroad.ttb.dvirId", c3642c.m19091d());
        intent.putExtra("com.bigroad.ttb.isFixing", z);
        activity.startActivityForResult(intent, 19);
    }

    public static void m7928a(Activity activity, int i, boolean z) {
        Intent intent = new Intent(activity, DailyLogEditHeaderActivity.class);
        intent.putExtra("com.bigroad.ttb.logDay", i);
        intent.putExtra("com.bigroad.ttb.isFixing", z);
        activity.startActivityForResult(intent, 16);
    }

    public static void m7988e(Activity activity, int i) {
        Intent intent = new Intent(activity, RejectCarrierEditActivity.class);
        intent.putExtra("com.bigroad.ttb.logDay", i);
        activity.startActivity(intent);
    }

    public static void m7991f(Activity activity, int i) {
        Intent intent = new Intent(activity, CorrectionReviewActivity.class);
        intent.putExtra("com.bigroad.ttb.logDay", i);
        activity.startActivity(intent);
    }

    public static void m8004l(Context context) {
        C1632a.m7974b(context, UpdateVehicleActivity.class);
    }

    public static Intent m8005m(Context context) {
        return C1258c.m6616b(new ComponentName(context, MainActivity.class));
    }

    public static Intent m7978c(Context context, int i) {
        Intent m = C1632a.m8005m(context);
        m.putExtra("com.bigroad.ttb.destinationActivity", i);
        return m;
    }

    public static void m8011p(Activity activity) {
        int intExtra = activity.getIntent().getIntExtra("com.bigroad.ttb.destinationActivity", -1);
        switch (intExtra) {
            case -1:
                return;
            case 0:
                C1632a.m7998i((Context) activity);
                return;
            case 1:
                C1632a.m7944a((Context) activity);
                return;
            case 2:
                C1632a.m8002k((Context) activity);
                return;
            default:
                C2134e.m10682e("TT-Activities", "Unrecognized destination activity code: " + intExtra);
                return;
        }
    }

    public static ResolveInfo m7923a(PackageManager packageManager, Intent intent, ResolveInfo resolveInfo, ComponentName componentName) {
        if (resolveInfo == null || !C1632a.m7964a(resolveInfo)) {
            return resolveInfo;
        }
        ResolveInfo resolveActivity;
        if (componentName != null) {
            Intent intent2 = new Intent(intent);
            intent2.setComponent(componentName);
            resolveActivity = packageManager.resolveActivity(intent2, NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST);
            if (!(resolveActivity == null || C1632a.m7964a(resolveActivity))) {
                return resolveActivity;
            }
        }
        for (ResolveInfo resolveActivity2 : packageManager.queryIntentActivities(intent, NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST)) {
            if (!C1632a.m7964a(resolveActivity2)) {
                return resolveActivity2;
            }
        }
        return resolveInfo;
    }

    public static boolean m7964a(ResolveInfo resolveInfo) {
        return resolveInfo.activityInfo.packageName.equals("android");
    }

    public static void m7949a(Context context, Uri uri) {
        try {
            context.startActivity(new Intent("android.intent.action.VIEW", uri));
        } catch (ActivityNotFoundException e) {
            C2134e.m10682e("TT-Activities", e.getMessage());
        }
    }

    private static Intent m8014r(Context context) {
        return new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=" + context.getPackageName()));
    }

    public static void m8008n(Context context) {
        context.startActivity(C1632a.m8014r(context).addFlags(268435456));
        OurApplication.m6272a(context).show();
    }

    public static boolean m8010o(Context context) {
        return context.getPackageManager().queryIntentActivities(C1632a.m8014r(context), 0).size() > 0;
    }

    public static void m8012p(Context context) {
        context.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://discover.bigroad.com/dashlink-eld-upgrade")));
    }

    public static void m8013q(Context context) {
        context.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://www.bigroad.com/resources/user_manual?utm_campaign=BigRoad Admin&amp;utm_content=settings&amp;utm_medium=mobile&amp;utm_source=bigroad")));
    }
}
