package android.support.v4.view.p009a;

import android.os.Bundle;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import java.util.List;

class C0375f {

    interface C0366a {
        Object mo241a(int i);

        List<Object> mo242a(String str, int i);

        boolean mo243a(int i, int i2, Bundle bundle);
    }

    public static Object m1556a(final C0366a c0366a) {
        return new AccessibilityNodeProvider() {
            public AccessibilityNodeInfo createAccessibilityNodeInfo(int i) {
                return (AccessibilityNodeInfo) c0366a.mo241a(i);
            }

            public List<AccessibilityNodeInfo> findAccessibilityNodeInfosByText(String str, int i) {
                return c0366a.mo242a(str, i);
            }

            public boolean performAction(int i, int i2, Bundle bundle) {
                return c0366a.mo243a(i, i2, bundle);
            }
        };
    }
}
