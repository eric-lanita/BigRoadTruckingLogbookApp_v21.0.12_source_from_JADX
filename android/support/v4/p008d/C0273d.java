package android.support.v4.p008d;

import android.util.Log;
import java.io.Writer;

public class C0273d extends Writer {
    private final String f801a;
    private StringBuilder f802b = new StringBuilder(128);

    public C0273d(String str) {
        this.f801a = str;
    }

    public void close() {
        m1161a();
    }

    public void flush() {
        m1161a();
    }

    public void write(char[] cArr, int i, int i2) {
        for (int i3 = 0; i3 < i2; i3++) {
            char c = cArr[i + i3];
            if (c == '\n') {
                m1161a();
            } else {
                this.f802b.append(c);
            }
        }
    }

    private void m1161a() {
        if (this.f802b.length() > 0) {
            Log.d(this.f801a, this.f802b.toString());
            this.f802b.delete(0, this.f802b.length());
        }
    }
}
