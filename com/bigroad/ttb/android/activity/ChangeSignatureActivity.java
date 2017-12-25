package com.bigroad.ttb.android.activity;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.bigroad.shared.C1181z;
import com.bigroad.ttb.android.R;
import com.bigroad.ttb.android.SignatureManager;
import com.bigroad.ttb.android.logging.C2134e;
import com.bigroad.ttb.android.widget.SignatureInputView;
import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ChangeSignatureActivity extends OurActivity {
    private SignatureInputView f4394a;
    private Button f4395b;
    private Button f4396c;

    class C12821 implements OnClickListener {
        final /* synthetic */ ChangeSignatureActivity f4392a;

        C12821(ChangeSignatureActivity changeSignatureActivity) {
            this.f4392a = changeSignatureActivity;
        }

        public void onClick(View view) {
            this.f4392a.f4394a.m12034a();
        }
    }

    class C12832 implements OnClickListener {
        final /* synthetic */ ChangeSignatureActivity f4393a;

        C12832(ChangeSignatureActivity changeSignatureActivity) {
            this.f4393a = changeSignatureActivity;
        }

        public void onClick(View view) {
            if (this.f4393a.f4394a.m12035b()) {
                this.f4393a.m6754f();
            } else {
                SignatureManager.m6345f();
            }
            this.f4393a.finish();
        }
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.change_signature);
        this.f4394a = (SignatureInputView) findViewById(R.id.changeSignature_inputView);
        this.f4395b = (Button) findViewById(R.id.changeSignature_clearButton);
        this.f4396c = (Button) findViewById(R.id.changeSignature_saveButton);
        this.f4395b.setOnClickListener(new C12821(this));
        this.f4396c.setOnClickListener(new C12832(this));
        this.f4394a.requestFocus();
    }

    private void m6754f() {
        Throwable e;
        File file;
        Closeable closeable = null;
        Bitmap c = this.f4394a.m12036c();
        File createTempFile;
        Closeable fileOutputStream;
        try {
            createTempFile = File.createTempFile("signature", ".png", SignatureManager.m6338b());
            try {
                fileOutputStream = new FileOutputStream(createTempFile, false);
            } catch (FileNotFoundException e2) {
                e = e2;
                fileOutputStream = null;
                file = createTempFile;
                try {
                    C2134e.m10681d("TT-ChangeSignature", "File not found when creating signature.", e);
                    C1181z.m5999a(fileOutputStream);
                    if (file == null) {
                        file.delete();
                    }
                } catch (Throwable th) {
                    e = th;
                    createTempFile = file;
                    closeable = fileOutputStream;
                    C1181z.m5999a(closeable);
                    if (createTempFile != null) {
                        createTempFile.delete();
                    }
                    throw e;
                }
            } catch (IOException e3) {
                e = e3;
                try {
                    C2134e.m10681d("TT-ChangeSignature", "Error occured while creating signature image.", e);
                    C1181z.m5999a(closeable);
                    if (createTempFile == null) {
                        createTempFile.delete();
                    }
                } catch (Throwable th2) {
                    e = th2;
                    C1181z.m5999a(closeable);
                    if (createTempFile != null) {
                        createTempFile.delete();
                    }
                    throw e;
                }
            }
            try {
                c.compress(CompressFormat.PNG, 100, fileOutputStream);
                C1181z.m5999a(fileOutputStream);
                boolean a = SignatureManager.m6335a(createTempFile);
                C1181z.m5999a(fileOutputStream);
                if (createTempFile != null && !a) {
                    createTempFile.delete();
                }
            } catch (FileNotFoundException e4) {
                e = e4;
                file = createTempFile;
                C2134e.m10681d("TT-ChangeSignature", "File not found when creating signature.", e);
                C1181z.m5999a(fileOutputStream);
                if (file == null) {
                    file.delete();
                }
            } catch (IOException e5) {
                e = e5;
                closeable = fileOutputStream;
                C2134e.m10681d("TT-ChangeSignature", "Error occured while creating signature image.", e);
                C1181z.m5999a(closeable);
                if (createTempFile == null) {
                    createTempFile.delete();
                }
            } catch (Throwable th3) {
                e = th3;
                closeable = fileOutputStream;
                C1181z.m5999a(closeable);
                if (createTempFile != null) {
                    createTempFile.delete();
                }
                throw e;
            }
        } catch (FileNotFoundException e6) {
            e = e6;
            fileOutputStream = null;
            C2134e.m10681d("TT-ChangeSignature", "File not found when creating signature.", e);
            C1181z.m5999a(fileOutputStream);
            if (file == null) {
                file.delete();
            }
        } catch (IOException e7) {
            e = e7;
            createTempFile = null;
            C2134e.m10681d("TT-ChangeSignature", "Error occured while creating signature image.", e);
            C1181z.m5999a(closeable);
            if (createTempFile == null) {
                createTempFile.delete();
            }
        } catch (Throwable th4) {
            e = th4;
            createTempFile = null;
            C1181z.m5999a(closeable);
            if (createTempFile != null) {
                createTempFile.delete();
            }
            throw e;
        }
    }
}
