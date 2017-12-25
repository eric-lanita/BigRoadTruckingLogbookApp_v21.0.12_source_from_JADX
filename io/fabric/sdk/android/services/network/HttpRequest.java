package io.fabric.sdk.android.services.network;

import com.facebook.internal.Utility;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.Flushable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Proxy.Type;
import java.net.URI;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.Callable;
import java.util.zip.GZIPInputStream;

public class HttpRequest {
    private static final String[] f14240b = new String[0];
    private static C4040b f14241c = C4040b.f14238a;
    public final URL f14242a;
    private HttpURLConnection f14243d = null;
    private final String f14244e;
    private C4042d f14245f;
    private boolean f14246g;
    private boolean f14247h = true;
    private boolean f14248i = false;
    private int f14249j = Utility.DEFAULT_STREAM_BUFFER_SIZE;
    private String f14250k;
    private int f14251l;

    protected static abstract class C4037c<V> implements Callable<V> {
        protected abstract V mo2885b();

        protected abstract void mo2884c();

        protected C4037c() {
        }

        public V call() {
            Throwable th;
            Object obj = 1;
            try {
                V b = mo2885b();
                try {
                    mo2884c();
                    return b;
                } catch (IOException e) {
                    throw new HttpRequestException(e);
                }
            } catch (HttpRequestException e2) {
                throw e2;
            } catch (IOException e3) {
                throw new HttpRequestException(e3);
            } catch (Throwable th2) {
                th = th2;
            }
            try {
                mo2884c();
            } catch (IOException e4) {
                if (obj == null) {
                    throw new HttpRequestException(e4);
                }
            }
            throw th;
        }
    }

    protected static abstract class C4038a<V> extends C4037c<V> {
        private final Closeable f14233a;
        private final boolean f14234b;

        protected C4038a(Closeable closeable, boolean z) {
            this.f14233a = closeable;
            this.f14234b = z;
        }

        protected void mo2884c() {
            if (this.f14233a instanceof Flushable) {
                ((Flushable) this.f14233a).flush();
            }
            if (this.f14234b) {
                try {
                    this.f14233a.close();
                    return;
                } catch (IOException e) {
                    return;
                }
            }
            this.f14233a.close();
        }
    }

    public static class HttpRequestException extends RuntimeException {
        private static final long serialVersionUID = -1170466989781746231L;

        public /* synthetic */ Throwable getCause() {
            return m20857a();
        }

        protected HttpRequestException(IOException iOException) {
            super(iOException);
        }

        public IOException m20857a() {
            return (IOException) super.getCause();
        }
    }

    public interface C4040b {
        public static final C4040b f14238a = new C40411();

        static class C40411 implements C4040b {
            C40411() {
            }

            public HttpURLConnection mo2886a(URL url) {
                return (HttpURLConnection) url.openConnection();
            }

            public HttpURLConnection mo2887a(URL url, Proxy proxy) {
                return (HttpURLConnection) url.openConnection(proxy);
            }
        }

        HttpURLConnection mo2886a(URL url);

        HttpURLConnection mo2887a(URL url, Proxy proxy);
    }

    public static class C4042d extends BufferedOutputStream {
        private final CharsetEncoder f14239a;

        public C4042d(OutputStream outputStream, String str, int i) {
            super(outputStream, i);
            this.f14239a = Charset.forName(HttpRequest.m20875f(str)).newEncoder();
        }

        public C4042d m20862a(String str) {
            ByteBuffer encode = this.f14239a.encode(CharBuffer.wrap(str));
            super.write(encode.array(), 0, encode.limit());
            return this;
        }
    }

    private static String m20875f(String str) {
        return (str == null || str.length() <= 0) ? "UTF-8" : str;
    }

    private static StringBuilder m20867a(String str, StringBuilder stringBuilder) {
        if (str.indexOf(58) + 2 == str.lastIndexOf(47)) {
            stringBuilder.append('/');
        }
        return stringBuilder;
    }

    private static StringBuilder m20870b(String str, StringBuilder stringBuilder) {
        int indexOf = str.indexOf(63);
        int length = stringBuilder.length() - 1;
        if (indexOf == -1) {
            stringBuilder.append('?');
        } else if (indexOf < length && str.charAt(length) != '&') {
            stringBuilder.append('&');
        }
        return stringBuilder;
    }

    public static String m20865a(CharSequence charSequence) {
        try {
            URL url = new URL(charSequence.toString());
            String host = url.getHost();
            int port = url.getPort();
            if (port != -1) {
                host = host + ':' + Integer.toString(port);
            }
            try {
                String toASCIIString = new URI(url.getProtocol(), host, url.getPath(), url.getQuery(), null).toASCIIString();
                int indexOf = toASCIIString.indexOf(63);
                if (indexOf > 0 && indexOf + 1 < toASCIIString.length()) {
                    toASCIIString = toASCIIString.substring(0, indexOf + 1) + toASCIIString.substring(indexOf + 1).replace("+", "%2B");
                }
                return toASCIIString;
            } catch (Throwable e) {
                IOException iOException = new IOException("Parsing URI failed");
                iOException.initCause(e);
                throw new HttpRequestException(iOException);
            }
        } catch (IOException e2) {
            throw new HttpRequestException(e2);
        }
    }

    public static String m20866a(CharSequence charSequence, Map<?, ?> map) {
        String charSequence2 = charSequence.toString();
        if (map == null || map.isEmpty()) {
            return charSequence2;
        }
        StringBuilder stringBuilder = new StringBuilder(charSequence2);
        m20867a(charSequence2, stringBuilder);
        m20870b(charSequence2, stringBuilder);
        Iterator it = map.entrySet().iterator();
        Entry entry = (Entry) it.next();
        stringBuilder.append(entry.getKey().toString());
        stringBuilder.append('=');
        Object value = entry.getValue();
        if (value != null) {
            stringBuilder.append(value);
        }
        while (it.hasNext()) {
            stringBuilder.append('&');
            entry = (Entry) it.next();
            stringBuilder.append(entry.getKey().toString());
            stringBuilder.append('=');
            value = entry.getValue();
            if (value != null) {
                stringBuilder.append(value);
            }
        }
        return stringBuilder.toString();
    }

    public static HttpRequest m20868b(CharSequence charSequence) {
        return new HttpRequest(charSequence, "GET");
    }

    public static HttpRequest m20864a(CharSequence charSequence, Map<?, ?> map, boolean z) {
        CharSequence a = m20866a(charSequence, (Map) map);
        if (z) {
            a = m20865a(a);
        }
        return m20868b(a);
    }

    public static HttpRequest m20871c(CharSequence charSequence) {
        return new HttpRequest(charSequence, "POST");
    }

    public static HttpRequest m20869b(CharSequence charSequence, Map<?, ?> map, boolean z) {
        CharSequence a = m20866a(charSequence, (Map) map);
        if (z) {
            a = m20865a(a);
        }
        return m20871c(a);
    }

    public static HttpRequest m20872d(CharSequence charSequence) {
        return new HttpRequest(charSequence, "PUT");
    }

    public static HttpRequest m20873e(CharSequence charSequence) {
        return new HttpRequest(charSequence, "DELETE");
    }

    public HttpRequest(CharSequence charSequence, String str) {
        try {
            this.f14242a = new URL(charSequence.toString());
            this.f14244e = str;
        } catch (IOException e) {
            throw new HttpRequestException(e);
        }
    }

    private Proxy m20876q() {
        return new Proxy(Type.HTTP, new InetSocketAddress(this.f14250k, this.f14251l));
    }

    private HttpURLConnection m20877r() {
        try {
            HttpURLConnection a;
            if (this.f14250k != null) {
                a = f14241c.mo2887a(this.f14242a, m20876q());
            } else {
                a = f14241c.mo2886a(this.f14242a);
            }
            a.setRequestMethod(this.f14244e);
            return a;
        } catch (IOException e) {
            throw new HttpRequestException(e);
        }
    }

    public String toString() {
        return m20916p() + ' ' + m20915o();
    }

    public HttpURLConnection m20891a() {
        if (this.f14243d == null) {
            this.f14243d = m20877r();
        }
        return this.f14243d;
    }

    public int m20892b() {
        try {
            m20911k();
            return m20891a().getResponseCode();
        } catch (IOException e) {
            throw new HttpRequestException(e);
        }
    }

    public boolean m20898c() {
        return 200 == m20892b();
    }

    protected ByteArrayOutputStream m20901d() {
        int j = m20910j();
        if (j > 0) {
            return new ByteArrayOutputStream(j);
        }
        return new ByteArrayOutputStream();
    }

    public String m20890a(String str) {
        OutputStream d = m20901d();
        try {
            m20880a(m20906f(), d);
            return d.toString(m20875f(str));
        } catch (IOException e) {
            throw new HttpRequestException(e);
        }
    }

    public String m20903e() {
        return m20890a(m20908h());
    }

    public BufferedInputStream m20906f() {
        return new BufferedInputStream(m20907g(), this.f14249j);
    }

    public InputStream m20907g() {
        if (m20892b() < 400) {
            try {
                InputStream inputStream = m20891a().getInputStream();
            } catch (IOException e) {
                throw new HttpRequestException(e);
            }
        }
        inputStream = m20891a().getErrorStream();
        if (inputStream == null) {
            try {
                inputStream = m20891a().getInputStream();
            } catch (IOException e2) {
                throw new HttpRequestException(e2);
            }
        }
        if (!this.f14248i || !"gzip".equals(m20909i())) {
            return inputStream;
        }
        try {
            return new GZIPInputStream(inputStream);
        } catch (IOException e22) {
            throw new HttpRequestException(e22);
        }
    }

    public HttpRequest m20879a(int i) {
        m20891a().setConnectTimeout(i);
        return this;
    }

    public HttpRequest m20882a(String str, String str2) {
        m20891a().setRequestProperty(str, str2);
        return this;
    }

    public HttpRequest m20888a(Entry<String, String> entry) {
        return m20882a((String) entry.getKey(), (String) entry.getValue());
    }

    public String m20894b(String str) {
        m20912l();
        return m20891a().getHeaderField(str);
    }

    public int m20896c(String str) {
        return m20878a(str, -1);
    }

    public int m20878a(String str, int i) {
        m20912l();
        return m20891a().getHeaderFieldInt(str, i);
    }

    public String m20895b(String str, String str2) {
        return m20897c(m20894b(str), str2);
    }

    protected String m20897c(String str, String str2) {
        if (str == null || str.length() == 0) {
            return null;
        }
        int length = str.length();
        int indexOf = str.indexOf(59) + 1;
        if (indexOf == 0 || indexOf == length) {
            return null;
        }
        int indexOf2 = str.indexOf(59, indexOf);
        if (indexOf2 == -1) {
            indexOf2 = indexOf;
            indexOf = length;
        } else {
            int i = indexOf2;
            indexOf2 = indexOf;
            indexOf = i;
        }
        while (indexOf2 < indexOf) {
            int indexOf3 = str.indexOf(61, indexOf2);
            if (indexOf3 != -1 && indexOf3 < indexOf && str2.equals(str.substring(indexOf2, indexOf3).trim())) {
                String trim = str.substring(indexOf3 + 1, indexOf).trim();
                indexOf3 = trim.length();
                if (indexOf3 != 0) {
                    if (indexOf3 > 2 && '\"' == trim.charAt(0) && '\"' == trim.charAt(indexOf3 - 1)) {
                        return trim.substring(1, indexOf3 - 1);
                    }
                    return trim;
                }
            }
            indexOf++;
            indexOf2 = str.indexOf(59, indexOf);
            if (indexOf2 == -1) {
                indexOf2 = length;
            }
            i = indexOf2;
            indexOf2 = indexOf;
            indexOf = i;
        }
        return null;
    }

    public String m20908h() {
        return m20895b("Content-Type", "charset");
    }

    public HttpRequest m20889a(boolean z) {
        m20891a().setUseCaches(z);
        return this;
    }

    public String m20909i() {
        return m20894b("Content-Encoding");
    }

    public HttpRequest m20899d(String str) {
        return m20900d(str, null);
    }

    public HttpRequest m20900d(String str, String str2) {
        if (str2 == null || str2.length() <= 0) {
            return m20882a("Content-Type", str);
        }
        String str3 = "; charset=";
        return m20882a("Content-Type", str + "; charset=" + str2);
    }

    public int m20910j() {
        return m20896c("Content-Length");
    }

    protected HttpRequest m20880a(InputStream inputStream, OutputStream outputStream) {
        final InputStream inputStream2 = inputStream;
        final OutputStream outputStream2 = outputStream;
        return (HttpRequest) new C4038a<HttpRequest>(this, inputStream, this.f14247h) {
            final /* synthetic */ HttpRequest f14237c;

            public /* synthetic */ Object mo2885b() {
                return m20855a();
            }

            public HttpRequest m20855a() {
                byte[] bArr = new byte[this.f14237c.f14249j];
                while (true) {
                    int read = inputStream2.read(bArr);
                    if (read == -1) {
                        return this.f14237c;
                    }
                    outputStream2.write(bArr, 0, read);
                }
            }
        }.call();
    }

    protected HttpRequest m20911k() {
        if (this.f14245f != null) {
            if (this.f14246g) {
                this.f14245f.m20862a("\r\n--00content0boundary00--\r\n");
            }
            if (this.f14247h) {
                try {
                    this.f14245f.close();
                } catch (IOException e) {
                }
            } else {
                this.f14245f.close();
            }
            this.f14245f = null;
        }
        return this;
    }

    protected HttpRequest m20912l() {
        try {
            return m20911k();
        } catch (IOException e) {
            throw new HttpRequestException(e);
        }
    }

    protected HttpRequest m20913m() {
        if (this.f14245f == null) {
            m20891a().setDoOutput(true);
            this.f14245f = new C4042d(m20891a().getOutputStream(), m20897c(m20891a().getRequestProperty("Content-Type"), "charset"), this.f14249j);
        }
        return this;
    }

    protected HttpRequest m20914n() {
        if (this.f14246g) {
            this.f14245f.m20862a("\r\n--00content0boundary00\r\n");
        } else {
            this.f14246g = true;
            m20899d("multipart/form-data; boundary=00content0boundary00").m20913m();
            this.f14245f.m20862a("--00content0boundary00\r\n");
        }
        return this;
    }

    protected HttpRequest m20884a(String str, String str2, String str3) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("form-data; name=\"").append(str);
        if (str2 != null) {
            stringBuilder.append("\"; filename=\"").append(str2);
        }
        stringBuilder.append('\"');
        m20905f("Content-Disposition", stringBuilder.toString());
        if (str3 != null) {
            m20905f("Content-Type", str3);
        }
        return m20904f((CharSequence) "\r\n");
    }

    public HttpRequest m20902e(String str, String str2) {
        return m20893b(str, null, str2);
    }

    public HttpRequest m20893b(String str, String str2, String str3) {
        return m20887a(str, str2, null, str3);
    }

    public HttpRequest m20887a(String str, String str2, String str3, String str4) {
        try {
            m20914n();
            m20884a(str, str2, str3);
            this.f14245f.m20862a(str4);
            return this;
        } catch (IOException e) {
            throw new HttpRequestException(e);
        }
    }

    public HttpRequest m20881a(String str, Number number) {
        return m20883a(str, null, number);
    }

    public HttpRequest m20883a(String str, String str2, Number number) {
        return m20893b(str, str2, number != null ? number.toString() : null);
    }

    public HttpRequest m20885a(String str, String str2, String str3, File file) {
        InputStream bufferedInputStream;
        IOException e;
        Throwable th;
        try {
            bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
            try {
                HttpRequest a = m20886a(str, str2, str3, bufferedInputStream);
                if (bufferedInputStream != null) {
                    try {
                        bufferedInputStream.close();
                    } catch (IOException e2) {
                    }
                }
                return a;
            } catch (IOException e3) {
                e = e3;
                try {
                    throw new HttpRequestException(e);
                } catch (Throwable th2) {
                    th = th2;
                    if (bufferedInputStream != null) {
                        try {
                            bufferedInputStream.close();
                        } catch (IOException e4) {
                        }
                    }
                    throw th;
                }
            }
        } catch (IOException e5) {
            e = e5;
            bufferedInputStream = null;
            throw new HttpRequestException(e);
        } catch (Throwable th3) {
            th = th3;
            bufferedInputStream = null;
            if (bufferedInputStream != null) {
                bufferedInputStream.close();
            }
            throw th;
        }
    }

    public HttpRequest m20886a(String str, String str2, String str3, InputStream inputStream) {
        try {
            m20914n();
            m20884a(str, str2, str3);
            m20880a(inputStream, this.f14245f);
            return this;
        } catch (IOException e) {
            throw new HttpRequestException(e);
        }
    }

    public HttpRequest m20905f(String str, String str2) {
        return m20904f((CharSequence) str).m20904f((CharSequence) ": ").m20904f((CharSequence) str2).m20904f((CharSequence) "\r\n");
    }

    public HttpRequest m20904f(CharSequence charSequence) {
        try {
            m20913m();
            this.f14245f.m20862a(charSequence.toString());
            return this;
        } catch (IOException e) {
            throw new HttpRequestException(e);
        }
    }

    public URL m20915o() {
        return m20891a().getURL();
    }

    public String m20916p() {
        return m20891a().getRequestMethod();
    }
}
