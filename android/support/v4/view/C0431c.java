package android.support.v4.view;

import android.os.Bundle;
import android.view.View;
import android.view.View.AccessibilityDelegate;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;

class C0431c {

    public interface C0345a {
        Object mo211a(View view);

        void mo212a(View view, int i);

        void mo213a(View view, Object obj);

        boolean mo214a(View view, int i, Bundle bundle);

        boolean mo215a(View view, AccessibilityEvent accessibilityEvent);

        boolean mo216a(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent);

        void mo217b(View view, AccessibilityEvent accessibilityEvent);

        void mo218c(View view, AccessibilityEvent accessibilityEvent);

        void mo219d(View view, AccessibilityEvent accessibilityEvent);
    }

    public static Object m2027a(final C0345a c0345a) {
        return new AccessibilityDelegate() {
            public boolean dispatchPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
                return c0345a.mo215a(view, accessibilityEvent);
            }

            public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
                c0345a.mo217b(view, accessibilityEvent);
            }

            public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
                c0345a.mo213a(view, (Object) accessibilityNodeInfo);
            }

            public void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
                c0345a.mo218c(view, accessibilityEvent);
            }

            public boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
                return c0345a.mo216a(viewGroup, view, accessibilityEvent);
            }

            public void sendAccessibilityEvent(View view, int i) {
                c0345a.mo212a(view, i);
            }

            public void sendAccessibilityEventUnchecked(View view, AccessibilityEvent accessibilityEvent) {
                c0345a.mo219d(view, accessibilityEvent);
            }

            public AccessibilityNodeProvider getAccessibilityNodeProvider(View view) {
                return (AccessibilityNodeProvider) c0345a.mo211a(view);
            }

            public boolean performAccessibilityAction(View view, int i, Bundle bundle) {
                return c0345a.mo214a(view, i, bundle);
            }
        };
    }

    public static Object m2028a(Object obj, View view) {
        return ((AccessibilityDelegate) obj).getAccessibilityNodeProvider(view);
    }

    public static boolean m2029a(Object obj, View view, int i, Bundle bundle) {
        return ((AccessibilityDelegate) obj).performAccessibilityAction(view, i, bundle);
    }
}
