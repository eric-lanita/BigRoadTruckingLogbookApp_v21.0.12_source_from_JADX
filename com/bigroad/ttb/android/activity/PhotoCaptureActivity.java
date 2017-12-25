package com.bigroad.ttb.android.activity;

import android.content.Intent;
import android.content.res.Configuration;
import android.hardware.Camera;
import android.hardware.Camera.AutoFocusCallback;
import android.hardware.Camera.CameraInfo;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.PictureCallback;
import android.hardware.Camera.Size;
import android.location.Location;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.OrientationEventListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import com.bigroad.ttb.android.OurApplication;
import com.bigroad.ttb.android.R;
import com.bigroad.ttb.android.activity.OurActivity.TitleStyle;
import com.bigroad.ttb.android.logging.C2134e;
import com.bigroad.ttb.android.p030a.C1256a;
import com.bigroad.ttb.android.widget.CameraView;
import java.io.File;
import java.util.List;
import java.util.Locale;

public class PhotoCaptureActivity extends OurActivity {
    private CameraView f5409a;
    private ImageButton f5410b;
    private C1256a f5411c;
    private boolean f5412d;
    private OrientationEventListener f5413e;
    private int f5414f = -1;
    private final AutoFocusCallback f5415g = new C15531(this);
    private final PictureCallback f5416h = new C15542(this);

    class C15531 implements AutoFocusCallback {
        final /* synthetic */ PhotoCaptureActivity f5405a;

        C15531(PhotoCaptureActivity photoCaptureActivity) {
            this.f5405a = photoCaptureActivity;
        }

        public void onAutoFocus(boolean z, Camera camera) {
            try {
                this.f5405a.m7760f().takePicture(null, null, this.f5405a.f5416h);
            } catch (Throwable e) {
                C2134e.m10681d("TT-PhotoActivity", "RuntimeException in takePicture()", e);
                this.f5405a.f5412d = false;
            }
        }
    }

    class C15542 implements PictureCallback {
        final /* synthetic */ PhotoCaptureActivity f5406a;

        C15542(PhotoCaptureActivity photoCaptureActivity) {
            this.f5406a = photoCaptureActivity;
        }

        public void onPictureTaken(byte[] bArr, Camera camera) {
            C2134e.m10676b("TT-PhotoActivity", "picture taken; " + bArr.length + " bytes");
            File a = OurApplication.m6276a(bArr);
            if (a == null) {
                this.f5406a.setResult(0);
            } else {
                Intent intent = new Intent();
                intent.putExtra("com.bigroad.ttb.fileName", a.getAbsolutePath());
                this.f5406a.setResult(-1, intent);
            }
            this.f5406a.finish();
            this.f5406a.f5412d = false;
        }
    }

    class C15553 implements OnClickListener {
        final /* synthetic */ PhotoCaptureActivity f5407a;

        C15553(PhotoCaptureActivity photoCaptureActivity) {
            this.f5407a = photoCaptureActivity;
        }

        public void onClick(View view) {
            this.f5407a.m7764k();
        }
    }

    private Camera m7760f() {
        return this.f5411c == null ? null : this.f5411c.f4287a;
    }

    private void m7761h() {
        this.f5411c = C1256a.m6603a();
    }

    private void m7762i() {
        this.f5409a.setCamera(null);
        if (this.f5411c != null) {
            m7760f().release();
            this.f5411c = null;
        }
    }

    private void m7753a(Parameters parameters, int i) {
        if (i != -1 && this.f5411c != null) {
            int i2;
            CameraInfo b = this.f5411c.m6605b();
            int i3 = ((i + 45) / 90) * 90;
            if (b.facing == 1) {
                i2 = ((b.orientation - i3) + 360) % 360;
            } else {
                i2 = (b.orientation + i3) % 360;
            }
            parameters.setRotation(i2);
        }
    }

    private void m7763j() {
        Camera f = m7760f();
        if (f != null) {
            int i = 0;
            switch (getWindowManager().getDefaultDisplay().getRotation()) {
                case 1:
                    i = 90;
                    break;
                case 2:
                    i = 180;
                    break;
                case 3:
                    i = 270;
                    break;
            }
            f.setDisplayOrientation(((this.f5411c.m6605b().orientation - i) + 360) % 360);
        }
    }

    private void m7754a(Parameters parameters, Location location) {
        if (location != null) {
            parameters.removeGpsData();
            if (location.hasAltitude()) {
                parameters.setGpsAltitude(location.getAltitude());
            } else {
                parameters.setGpsAltitude(0.0d);
            }
            parameters.setGpsLatitude(location.getLatitude());
            parameters.setGpsLongitude(location.getLongitude());
            parameters.setGpsTimestamp(location.getTime() / 1000);
            if (location.getProvider() != null) {
                parameters.setGpsProcessingMethod(location.getProvider().toUpperCase(Locale.US));
            }
        }
    }

    private void m7764k() {
        Camera f = m7760f();
        if (f != null && !this.f5412d) {
            Parameters parameters = f.getParameters();
            m7753a(parameters, this.f5414f);
            m7754a(parameters, OurApplication.m6302x().m10604d());
            f.setParameters(parameters);
            this.f5412d = true;
            try {
                f.autoFocus(this.f5415g);
            } catch (Throwable e) {
                C2134e.m10681d("TT-PhotoActivity", "RuntimeException in autoFocus()", e);
                this.f5412d = false;
            }
        }
    }

    private static String m7752a(List<String> list) {
        for (String equals : list) {
            if (equals.equals("on")) {
                return "on";
            }
        }
        for (String equals2 : list) {
            if (equals2.equals("auto")) {
                return "auto";
            }
        }
        return null;
    }

    private static boolean m7755a(Size size, Size size2) {
        if (size2 == null) {
            return true;
        }
        int i = size2.width * size2.height;
        int i2 = size.width * size.height;
        if (i >= 4114000) {
            if (i2 < 4114000 || i2 >= i) {
                return false;
            }
            return true;
        } else if (i2 <= i) {
            return false;
        } else {
            return true;
        }
    }

    private static Size m7757b(List<Size> list) {
        Size size = null;
        for (Size size2 : list) {
            Size size22;
            if (!m7755a(size22, size)) {
                size22 = size;
            }
            size = size22;
        }
        return size;
    }

    public PhotoCaptureActivity() {
        super(TitleStyle.NONE);
    }

    private void m7765l() {
        String a;
        Parameters parameters = m7760f().getParameters();
        List supportedFlashModes = parameters.getSupportedFlashModes();
        if (supportedFlashModes != null) {
            a = m7752a(supportedFlashModes);
            if (a != null) {
                parameters.setFlashMode(a);
            }
        }
        List<String> supportedFocusModes = parameters.getSupportedFocusModes();
        if (supportedFocusModes != null) {
            for (String a2 : supportedFocusModes) {
                if (a2.equals("auto")) {
                    parameters.setFocusMode("auto");
                    break;
                }
            }
        }
        supportedFocusModes = parameters.getSupportedWhiteBalance();
        if (supportedFocusModes != null) {
            for (String a22 : supportedFocusModes) {
                if (a22.equals("auto")) {
                    parameters.setWhiteBalance("auto");
                    break;
                }
            }
        }
        if (parameters.isZoomSupported()) {
            parameters.setZoom(0);
        }
        try {
            List<Integer> supportedPictureFormats = parameters.getSupportedPictureFormats();
            if (supportedPictureFormats != null) {
                for (Integer intValue : supportedPictureFormats) {
                    if (intValue.intValue() == 256) {
                        parameters.setPictureFormat(256);
                        break;
                    }
                }
            }
        } catch (NullPointerException e) {
            C2134e.m10680d("TT-PhotoActivity", "Ignoring NPE while calling getSupportedPictureFormats");
        }
        Size b = m7757b(parameters.getSupportedPictureSizes());
        C2134e.m10676b("TT-PhotoActivity", "Choosing picture size " + b.width + "x" + b.height + " (" + (b.width * b.height) + "px)");
        parameters.setPictureSize(b.width, b.height);
        parameters.setJpegQuality(90);
        m7760f().setParameters(parameters);
        m7763j();
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().addFlags(1024);
        setContentView((int) R.layout.photo_capture);
        this.f5409a = (CameraView) findViewById(R.id.photoCapture_cameraView);
        this.f5410b = (ImageButton) findViewById(R.id.photoCapture_shutterButton);
        this.f5410b.setOnClickListener(new C15553(this));
        this.f5410b.requestFocus();
        this.f5413e = new OrientationEventListener(this, this) {
            final /* synthetic */ PhotoCaptureActivity f5408a;

            public void onOrientationChanged(int i) {
                if (i != -1) {
                    this.f5408a.f5414f = i;
                }
            }
        };
    }

    protected void onResume() {
        super.onResume();
        m7762i();
        try {
            m7761h();
            m7765l();
            this.f5409a.setCamera(m7760f());
        } catch (Throwable e) {
            C2134e.m10681d("TT-PhotoActivity", "Exception setting up camera", e);
            m7762i();
            finish();
        }
        this.f5413e.enable();
    }

    protected void onPause() {
        super.onPause();
        m7762i();
        this.f5413e.disable();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        switch (i) {
            case 23:
                if (keyEvent.getRepeatCount() != 0) {
                    return true;
                }
                if (this.f5410b.isInTouchMode()) {
                    this.f5410b.requestFocusFromTouch();
                } else {
                    this.f5410b.requestFocus();
                }
                this.f5410b.setPressed(true);
                return true;
            case 27:
                if (keyEvent.getRepeatCount() != 0) {
                    return true;
                }
                m7764k();
                return true;
            default:
                return super.onKeyDown(i, keyEvent);
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        C2134e.m10676b("TT-PhotoActivity", "onConfigurationChanged: orientation=" + configuration.orientation);
    }
}
