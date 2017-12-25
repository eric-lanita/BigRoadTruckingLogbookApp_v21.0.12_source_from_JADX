package android.support.v4.app;

import android.app.Activity;
import android.app.SharedElementCallback;
import android.content.Context;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.media.session.MediaController;
import android.os.Parcelable;
import android.view.View;
import java.util.List;
import java.util.Map;

class C0180b {

    public static abstract class C0124a {
        public abstract Parcelable mo107a(View view, Matrix matrix, RectF rectF);

        public abstract View mo108a(Context context, Parcelable parcelable);

        public abstract void mo109a(List<View> list);

        public abstract void mo110a(List<String> list, List<View> list2, List<View> list3);

        public abstract void mo111a(List<String> list, Map<String, View> map);

        public abstract void mo112b(List<String> list, List<View> list2, List<View> list3);
    }

    private static class C0179b extends SharedElementCallback {
        private C0124a f604a;

        public C0179b(C0124a c0124a) {
            this.f604a = c0124a;
        }

        public void onSharedElementStart(List<String> list, List<View> list2, List<View> list3) {
            this.f604a.mo110a((List) list, (List) list2, (List) list3);
        }

        public void onSharedElementEnd(List<String> list, List<View> list2, List<View> list3) {
            this.f604a.mo112b(list, list2, list3);
        }

        public void onRejectSharedElements(List<View> list) {
            this.f604a.mo109a(list);
        }

        public void onMapSharedElements(List<String> list, Map<String, View> map) {
            this.f604a.mo111a((List) list, (Map) map);
        }

        public Parcelable onCaptureSharedElementSnapshot(View view, Matrix matrix, RectF rectF) {
            return this.f604a.mo107a(view, matrix, rectF);
        }

        public View onCreateSnapshotView(Context context, Parcelable parcelable) {
            return this.f604a.mo108a(context, parcelable);
        }
    }

    public static void m789a(Activity activity, Object obj) {
        activity.setMediaController((MediaController) obj);
    }

    public static void m787a(Activity activity) {
        activity.finishAfterTransition();
    }

    public static void m788a(Activity activity, C0124a c0124a) {
        activity.setEnterSharedElementCallback(C0180b.m786a(c0124a));
    }

    public static void m791b(Activity activity, C0124a c0124a) {
        activity.setExitSharedElementCallback(C0180b.m786a(c0124a));
    }

    public static void m790b(Activity activity) {
        activity.postponeEnterTransition();
    }

    public static void m792c(Activity activity) {
        activity.startPostponedEnterTransition();
    }

    private static SharedElementCallback m786a(C0124a c0124a) {
        if (c0124a != null) {
            return new C0179b(c0124a);
        }
        return null;
    }
}
