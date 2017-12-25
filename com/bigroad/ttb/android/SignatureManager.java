package com.bigroad.ttb.android;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.ColorMatrixColorFilter;
import android.os.AsyncTask;
import com.bigroad.shared.C1097i;
import com.bigroad.shared.C1180y;
import com.bigroad.shared.C1181z;
import com.bigroad.ttb.android.C2226q.C1221a;
import com.bigroad.ttb.android.C2474y.C1183b;
import com.bigroad.ttb.android.logging.C2134e;
import com.bigroad.ttb.android.p029c.C1736b;
import com.bigroad.ttb.android.p029c.C1736b.C1219a;
import com.bigroad.ttb.android.util.C2279b;
import com.bigroad.ttb.android.util.C2283e;
import com.bigroad.ttb.protocol.TTProtocol.DailyLog;
import com.bigroad.ttb.protocol.TTProtocol.Dvir;
import com.bigroad.ttb.protocol.TTProtocol.Person;
import com.google.android.gms.maps.model.GroundOverlayOptions;
import com.google.protobuf.C3642c;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SignatureManager {
    public static final ColorMatrixColorFilter f4157a = new ColorMatrixColorFilter(new float[]{GroundOverlayOptions.NO_DIMENSION, 0.0f, 0.0f, 0.0f, 255.0f, 0.0f, GroundOverlayOptions.NO_DIMENSION, 0.0f, 0.0f, 255.0f, 0.0f, 0.0f, GroundOverlayOptions.NO_DIMENSION, 0.0f, 255.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f});
    private static SignatureManager f4158b;
    private final Runnable f4159c = new C12171(this);
    private final C2474y f4160d = OurApplication.m6285g();
    private final C1736b f4161e = OurApplication.m6296r();
    private final C2226q f4162f = OurApplication.m6297s();
    private final C2279b f4163g = new C2279b(this.f4159c, 1000, 60000, 2.0f);
    private final Set<C1224a> f4164h = new HashSet();
    private HashSet<C3642c> f4165i = new HashSet();
    private C1225b f4166j = null;
    private final C1183b f4167k = new C12182(this);
    private final C1219a f4168l = new C12203(this);
    private final C1221a f4169m = new C12224(this);

    class C12171 implements Runnable {
        final /* synthetic */ SignatureManager f4149a;

        C12171(SignatureManager signatureManager) {
            this.f4149a = signatureManager;
        }

        public void run() {
            this.f4149a.m6349h();
        }
    }

    class C12182 extends C1183b {
        final /* synthetic */ SignatureManager f4150a;

        C12182(SignatureManager signatureManager) {
            this.f4150a = signatureManager;
        }

        public void mo868e(C2474y c2474y) {
            if (this.f4150a.m6333a(c2474y)) {
                this.f4150a.m6349h();
            }
        }
    }

    class C12203 implements C1219a {
        final /* synthetic */ SignatureManager f4151a;

        C12203(SignatureManager signatureManager) {
            this.f4151a = signatureManager;
        }

        public void mo904a(C1736b c1736b) {
            if (this.f4151a.m6331a(c1736b)) {
                this.f4151a.m6349h();
            }
        }
    }

    class C12224 implements C1221a {
        final /* synthetic */ SignatureManager f4152a;

        C12224(SignatureManager signatureManager) {
            this.f4152a = signatureManager;
        }

        public void mo905a(C2226q c2226q) {
            if (this.f4152a.m6332a(c2226q)) {
                this.f4152a.m6349h();
            }
        }
    }

    private enum DownloadStatus {
        OK,
        ERROR
    }

    public interface C1224a {
        void mo1007a(SignatureManager signatureManager);
    }

    private static class C1225b extends AsyncTask<C3642c[], Void, DownloadStatus> {
        private C1225b() {
        }

        protected /* synthetic */ Object doInBackground(Object[] objArr) {
            return m6322a((C3642c[][]) objArr);
        }

        protected /* synthetic */ void onPostExecute(Object obj) {
            m6323a((DownloadStatus) obj);
        }

        protected DownloadStatus m6322a(C3642c[]... c3642cArr) {
            Closeable closeable;
            DownloadStatus downloadStatus;
            Closeable closeable2;
            HttpURLConnection httpURLConnection;
            Throwable th;
            Throwable th2;
            HttpURLConnection httpURLConnection2;
            DownloadStatus downloadStatus2 = DownloadStatus.OK;
            C3642c[] c3642cArr2 = c3642cArr[0];
            int length = c3642cArr2.length;
            int i = 0;
            while (i < length) {
                C3642c c3642c = c3642cArr2[i];
                Closeable closeable3 = null;
                Closeable closeable4 = null;
                HttpURLConnection httpURLConnection3 = null;
                try {
                    String c = SignatureManager.m6344e(c3642c);
                    if (c != null) {
                        httpURLConnection3 = C2283e.m11197a(new URL(c));
                        try {
                            httpURLConnection3.setUseCaches(true);
                            DownloadStatus downloadStatus3;
                            switch (httpURLConnection3.getResponseCode()) {
                                case 200:
                                    File file = new File(SignatureManager.m6338b(), "tempDownload");
                                    File d = SignatureManager.m6347g(c3642c);
                                    if (d == null) {
                                        C2134e.m10680d("TT-SignatureManager", "Invalid signature file for signature " + C1180y.m5989a(c3642c));
                                        closeable = null;
                                        closeable4 = null;
                                        downloadStatus = downloadStatus2;
                                        break;
                                    }
                                    closeable = new FileOutputStream(file);
                                    try {
                                        closeable4 = httpURLConnection3.getInputStream();
                                        try {
                                            C1181z.m5998a(closeable4, closeable);
                                            if (!file.renameTo(d)) {
                                                downloadStatus = DownloadStatus.ERROR;
                                                C2134e.m10680d("TT-SignatureManager", "Could not rename completed signature download.\nFrom: " + file.getAbsolutePath() + "\nTo: " + d.getAbsolutePath());
                                                break;
                                            }
                                            C2134e.m10678c("TT-SignatureManager", "Downloaded signature from " + c);
                                            downloadStatus = downloadStatus2;
                                            break;
                                        } catch (Throwable e) {
                                            closeable2 = closeable4;
                                            closeable4 = closeable;
                                            httpURLConnection = httpURLConnection3;
                                            th = e;
                                            try {
                                                downloadStatus = DownloadStatus.ERROR;
                                                C2134e.m10681d("TT-SignatureManager", "Error downloading signature: " + C1180y.m5989a(c3642c), th);
                                                C1181z.m5999a(closeable4);
                                                C1181z.m5999a(closeable2);
                                                if (httpURLConnection == null) {
                                                    httpURLConnection.disconnect();
                                                }
                                                i++;
                                                downloadStatus2 = downloadStatus;
                                            } catch (Throwable th3) {
                                                th = th3;
                                                closeable3 = closeable2;
                                                break;
                                            }
                                        } catch (Throwable e2) {
                                            th2 = e2;
                                            closeable3 = closeable4;
                                            closeable4 = closeable;
                                            httpURLConnection = httpURLConnection3;
                                            th = th2;
                                            break;
                                        }
                                    } catch (Throwable e3) {
                                        closeable2 = null;
                                        httpURLConnection2 = httpURLConnection3;
                                        th = e3;
                                        closeable4 = closeable;
                                        httpURLConnection = httpURLConnection2;
                                        downloadStatus = DownloadStatus.ERROR;
                                        C2134e.m10681d("TT-SignatureManager", "Error downloading signature: " + C1180y.m5989a(c3642c), th);
                                        C1181z.m5999a(closeable4);
                                        C1181z.m5999a(closeable2);
                                        if (httpURLConnection == null) {
                                            httpURLConnection.disconnect();
                                        }
                                        i++;
                                        downloadStatus2 = downloadStatus;
                                    } catch (Throwable e32) {
                                        th2 = e32;
                                        closeable4 = closeable;
                                        httpURLConnection = httpURLConnection3;
                                        th = th2;
                                        break;
                                    }
                                case 404:
                                    downloadStatus3 = DownloadStatus.ERROR;
                                    C2134e.m10682e("TT-SignatureManager", "Signature not found at " + c);
                                    closeable4 = null;
                                    downloadStatus = downloadStatus3;
                                    closeable = null;
                                    break;
                                default:
                                    downloadStatus3 = DownloadStatus.ERROR;
                                    C2134e.m10682e("TT-SignatureManager", "Could not download signature from " + c + " -- Response code: " + httpURLConnection3.getResponseCode() + ": " + httpURLConnection3.getResponseMessage());
                                    closeable4 = null;
                                    downloadStatus = downloadStatus3;
                                    closeable = null;
                                    break;
                            }
                        } catch (Throwable e4) {
                            closeable2 = null;
                            httpURLConnection2 = httpURLConnection3;
                            th = e4;
                            httpURLConnection = httpURLConnection2;
                            downloadStatus = DownloadStatus.ERROR;
                            C2134e.m10681d("TT-SignatureManager", "Error downloading signature: " + C1180y.m5989a(c3642c), th);
                            C1181z.m5999a(closeable4);
                            C1181z.m5999a(closeable2);
                            if (httpURLConnection == null) {
                                httpURLConnection.disconnect();
                            }
                            i++;
                            downloadStatus2 = downloadStatus;
                        } catch (Throwable e42) {
                            th2 = e42;
                            httpURLConnection = httpURLConnection3;
                            th = th2;
                        }
                    } else {
                        closeable = null;
                        closeable4 = null;
                        downloadStatus = downloadStatus2;
                    }
                    C1181z.m5999a(closeable);
                    C1181z.m5999a(closeable4);
                    if (httpURLConnection3 != null) {
                        httpURLConnection3.disconnect();
                    }
                } catch (Throwable e422) {
                    closeable2 = null;
                    th = e422;
                    httpURLConnection = null;
                    downloadStatus = DownloadStatus.ERROR;
                    C2134e.m10681d("TT-SignatureManager", "Error downloading signature: " + C1180y.m5989a(c3642c), th);
                    C1181z.m5999a(closeable4);
                    C1181z.m5999a(closeable2);
                    if (httpURLConnection == null) {
                        httpURLConnection.disconnect();
                    }
                    i++;
                    downloadStatus2 = downloadStatus;
                } catch (Throwable e4222) {
                    th2 = e4222;
                    httpURLConnection = null;
                    th = th2;
                }
                i++;
                downloadStatus2 = downloadStatus;
            }
            return downloadStatus2;
            C1181z.m5999a(closeable4);
            C1181z.m5999a(closeable3);
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
            throw th;
        }

        protected void m6323a(DownloadStatus downloadStatus) {
            SignatureManager.m6324a().m6325a(downloadStatus);
        }
    }

    public static SignatureManager m6324a() {
        if (f4158b == null) {
            f4158b = new SignatureManager();
        }
        return f4158b;
    }

    public void m6353a(C1224a c1224a) {
        this.f4164h.add(c1224a);
    }

    public void m6354b(C1224a c1224a) {
        this.f4164h.remove(c1224a);
    }

    private void m6348g() {
        if (!this.f4164h.isEmpty()) {
            for (C1224a a : (C1224a[]) this.f4164h.toArray(new C1224a[this.f4164h.size()])) {
                a.mo1007a(this);
            }
        }
    }

    private SignatureManager() {
        this.f4160d.m12184a(this.f4167k);
        this.f4161e.m8474a(this.f4168l);
        this.f4162f.m10974a(this.f4169m);
        m6349h();
    }

    private void m6349h() {
        if (this.f4160d.m12202d() >= 0 && !this.f4163g.m11189c() && this.f4166j == null) {
            this.f4165i.clear();
            m6333a(this.f4160d);
            m6331a(this.f4161e);
            m6332a(this.f4162f);
            m6351i();
            ArrayList arrayList = new ArrayList(this.f4165i.size());
            Iterator it = this.f4165i.iterator();
            while (it.hasNext()) {
                C3642c c3642c = (C3642c) it.next();
                if (!m6350h(c3642c)) {
                    arrayList.add(c3642c);
                }
            }
            if (!arrayList.isEmpty()) {
                this.f4166j = new C1225b();
                C3642c[] c3642cArr = new C3642c[arrayList.size()];
                this.f4166j.execute(new C3642c[][]{(C3642c[]) arrayList.toArray(c3642cArr)});
            }
        }
    }

    private void m6351i() {
        File[] listFiles = m6338b().listFiles();
        if (listFiles != null) {
            for (File file : listFiles) {
                C3642c b = m6337b(file);
                if (!m6334a(b) || !this.f4165i.contains(b)) {
                    C2134e.m10678c("TT-SignatureManager", "Deleting unreferenced signature: " + file.getName());
                    file.delete();
                }
            }
        }
    }

    private void m6325a(DownloadStatus downloadStatus) {
        switch (downloadStatus) {
            case OK:
                this.f4163g.m11190d();
                m6348g();
                break;
            case ERROR:
                this.f4163g.m11188b();
                break;
        }
        this.f4166j = null;
        m6349h();
    }

    private static String m6344e(C3642c c3642c) {
        if (!m6334a(c3642c)) {
            return null;
        }
        return ("https://" + OurApplication.m6245B().m10547b() + "/binobj/") + C1180y.m5989a(c3642c) + "?cid=" + C1180y.m5990a(OurApplication.m6285g().m12191a());
    }

    private boolean m6346f(C3642c c3642c) {
        if (m6334a(c3642c)) {
            return this.f4165i.add(c3642c);
        }
        return false;
    }

    private boolean m6333a(C2474y c2474y) {
        if (c2474y.m12222l() == null) {
            return false;
        }
        return m6346f(c2474y.m12222l().getSignatureId());
    }

    private boolean m6331a(C1736b c1736b) {
        boolean z = false;
        for (DailyLog signatureId : c1736b.m8492f()) {
            z = m6346f(signatureId.getSignatureId()) | z;
        }
        return z;
    }

    private boolean m6332a(C2226q c2226q) {
        boolean z = false;
        for (Dvir signatureId : c2226q.m10987c()) {
            z = m6346f(signatureId.getSignatureId()) | z;
        }
        return z;
    }

    public static File m6338b() {
        File file = new File(OurApplication.m6279b().getFilesDir(), "Signatures");
        file.mkdirs();
        return file;
    }

    public static boolean m6334a(C3642c c3642c) {
        return (c3642c == null || c3642c.m19090c()) ? false : true;
    }

    private static File m6347g(C3642c c3642c) {
        if (m6334a(c3642c)) {
            return new File(m6338b(), C1180y.m5989a(c3642c));
        }
        return null;
    }

    private static C3642c m6337b(File file) {
        byte[] a = C1180y.m5992a(file.getName());
        if (a == null) {
            return null;
        }
        return C3642c.m19078a(a);
    }

    public static C3642c m6339c() {
        Person l = OurApplication.m6285g().m12222l();
        if (l == null) {
            return null;
        }
        return l.getSignatureId();
    }

    public static boolean m6342d() {
        return m6350h(m6339c());
    }

    private static boolean m6350h(C3642c c3642c) {
        if (m6334a(c3642c)) {
            return m6347g(c3642c).exists();
        }
        return false;
    }

    public static Bitmap m6343e() {
        return m6336b(m6339c());
    }

    public static Bitmap m6336b(C3642c c3642c) {
        Closeable fileInputStream;
        Throwable e;
        Throwable th;
        Bitmap bitmap = null;
        File g = m6347g(c3642c);
        if (g != null && g.exists()) {
            try {
                fileInputStream = new FileInputStream(g);
                try {
                    bitmap = BitmapFactory.decodeStream(fileInputStream);
                    C1181z.m5999a(fileInputStream);
                } catch (FileNotFoundException e2) {
                    e = e2;
                    try {
                        C2134e.m10681d("TT-SignatureManager", "Error loading current signature.", e);
                        C1181z.m5999a(fileInputStream);
                        return bitmap;
                    } catch (Throwable th2) {
                        th = th2;
                        C1181z.m5999a(fileInputStream);
                        throw th;
                    }
                }
            } catch (FileNotFoundException e3) {
                e = e3;
                fileInputStream = bitmap;
                C2134e.m10681d("TT-SignatureManager", "Error loading current signature.", e);
                C1181z.m5999a(fileInputStream);
                return bitmap;
            } catch (Throwable e4) {
                fileInputStream = bitmap;
                th = e4;
                C1181z.m5999a(fileInputStream);
                throw th;
            }
        }
        return bitmap;
    }

    private static void m6352i(C3642c c3642c) {
        Person l = OurApplication.m6285g().m12222l();
        if (l != null) {
            OurApplication.m6289k().m6473a(Person.newBuilder().m14718a(l.getPersonId()).m14731c("").m14721a(c3642c).m14733c());
        }
    }

    public static boolean m6335a(File file) {
        try {
            byte[] a = C1097i.m5441a(file);
            String a2 = C1180y.m5990a(a);
            C3642c a3 = C3642c.m19078a(a);
            File file2 = new File(m6338b(), a2);
            if (file.renameTo(file2)) {
                m6352i(a3);
                OurApplication.m6288j().m8937b(file2, a2);
                return true;
            }
            C2134e.m10682e("TT-SignatureManager", "Could not move signature file.");
            return false;
        } catch (Throwable e) {
            C2134e.m10681d("TT-SignatureManager", "Could not create MD5 for file " + file.getAbsolutePath(), e);
            return false;
        }
    }

    public static void m6345f() {
        m6352i(C3642c.f13210a);
    }
}
