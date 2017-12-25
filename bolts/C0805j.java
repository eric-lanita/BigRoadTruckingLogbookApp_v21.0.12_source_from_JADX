package bolts;

public class C0805j<TResult> {
    private final C0808i<TResult> f2419a = new C0808i();

    public C0808i<TResult> m3984a() {
        return this.f2419a;
    }

    public boolean m3989b() {
        return this.f2419a.m4015i();
    }

    public boolean m3986a(TResult tResult) {
        return this.f2419a.m4008b((Object) tResult);
    }

    public boolean m3985a(Exception exception) {
        return this.f2419a.m4007b(exception);
    }

    public void m3990c() {
        if (!m3989b()) {
            throw new IllegalStateException("Cannot cancel a completed task.");
        }
    }

    public void m3988b(TResult tResult) {
        if (!m3986a((Object) tResult)) {
            throw new IllegalStateException("Cannot set the result of a completed task.");
        }
    }

    public void m3987b(Exception exception) {
        if (!m3985a(exception)) {
            throw new IllegalStateException("Cannot set the error on a completed task.");
        }
    }
}
