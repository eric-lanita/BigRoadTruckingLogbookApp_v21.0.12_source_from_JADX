package android.support.v4.view.p009a;

import android.os.Bundle;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import java.util.List;

class C0377g {

    interface C0370a {
        Object mo245a(int i);

        List<Object> mo246a(String str, int i);

        boolean mo247a(int i, int i2, Bundle bundle);

        Object mo248b(int i);
    }

    public static Object m1557a(final C0370a c0370a) {
        return new AccessibilityNodeProvider() {
            public AccessibilityNodeInfo createAccessibilityNodeInfo(int i) {
                return (AccessibilityNodeInfo) c0370a.mo245a(i);
            }

            public List<AccessibilityNodeInfo> findAccessibilityNodeInfosByText(String str, int i) {
                return c0370a.mo246a(str, i);
            }

            public boolean performAction(int i, int i2, Bundle bundle) {
                return c0370a.mo247a(i, i2, bundle);
            }

            public AccessibilityNodeInfo findFocus(int i) {
                return (AccessibilityNodeInfo) c0370a.mo248b(i);
            }
        };
    }
}
