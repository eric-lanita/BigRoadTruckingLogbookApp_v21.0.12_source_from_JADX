package android.support.v4.app;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Parcelable;
import android.support.v4.p008d.C0269h;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.List;

public class C0200p {
    private final C0111q<?> f659a;

    public static final C0200p m865a(C0111q<?> c0111q) {
        return new C0200p(c0111q);
    }

    private C0200p(C0111q<?> c0111q) {
        this.f659a = c0111q;
    }

    public C0202r m867a() {
        return this.f659a.m539k();
    }

    public C0222w m878b() {
        return this.f659a.m540l();
    }

    Fragment m866a(String str) {
        return this.f659a.f440d.m942b(str);
    }

    public void m871a(Fragment fragment) {
        this.f659a.f440d.m935a(this.f659a, this.f659a, fragment);
    }

    public View m868a(View view, String str, Context context, AttributeSet attributeSet) {
        return this.f659a.f440d.mo151a(view, str, context, attributeSet);
    }

    public void m881c() {
        this.f659a.f440d.m963i();
    }

    public Parcelable m882d() {
        return this.f659a.f440d.m962h();
    }

    public void m870a(Parcelable parcelable, List<Fragment> list) {
        this.f659a.f440d.m930a(parcelable, (List) list);
    }

    public List<Fragment> m883e() {
        return this.f659a.f440d.m961g();
    }

    public void m884f() {
        this.f659a.f440d.m964j();
    }

    public void m885g() {
        this.f659a.f440d.m965k();
    }

    public void m886h() {
        this.f659a.f440d.m966l();
    }

    public void m887i() {
        this.f659a.f440d.m967m();
    }

    public void m888j() {
        this.f659a.f440d.m968n();
    }

    public void m889k() {
        this.f659a.f440d.m969o();
    }

    public void m890l() {
        this.f659a.f440d.m970p();
    }

    public void m891m() {
        this.f659a.f440d.m972r();
    }

    public void m869a(Configuration configuration) {
        this.f659a.f440d.m928a(configuration);
    }

    public void m892n() {
        this.f659a.f440d.m973s();
    }

    public boolean m876a(Menu menu, MenuInflater menuInflater) {
        return this.f659a.f440d.m940a(menu, menuInflater);
    }

    public boolean m875a(Menu menu) {
        return this.f659a.f440d.m939a(menu);
    }

    public boolean m877a(MenuItem menuItem) {
        return this.f659a.f440d.m941a(menuItem);
    }

    public boolean m880b(MenuItem menuItem) {
        return this.f659a.f440d.m949b(menuItem);
    }

    public void m879b(Menu menu) {
        this.f659a.f440d.m947b(menu);
    }

    public boolean m893o() {
        return this.f659a.f440d.m958e();
    }

    public void m894p() {
        this.f659a.m542n();
    }

    public void m874a(boolean z) {
        this.f659a.m524a(z);
    }

    public void m895q() {
        this.f659a.m543o();
    }

    public void m896r() {
        this.f659a.m544p();
    }

    public C0269h<String, C0222w> m897s() {
        return this.f659a.m545q();
    }

    public void m872a(C0269h<String, C0222w> c0269h) {
        this.f659a.m522a((C0269h) c0269h);
    }

    public void m873a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        this.f659a.m531b(str, fileDescriptor, printWriter, strArr);
    }
}
