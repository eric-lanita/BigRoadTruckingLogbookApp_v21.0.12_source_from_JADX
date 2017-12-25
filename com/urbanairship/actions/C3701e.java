package com.urbanairship.actions;

public final class C3701e {
    private final Exception f13338a;
    private final ActionValue f13339b;
    private final int f13340c;

    public static C3701e m19372a() {
        return new C3701e(null, null, 1);
    }

    public static C3701e m19374a(ActionValue actionValue) {
        return new C3701e(actionValue, null, 1);
    }

    public static C3701e m19375a(Exception exception) {
        return new C3701e(null, exception, 4);
    }

    static C3701e m19373a(int i) {
        return new C3701e(null, null, i);
    }

    C3701e(ActionValue actionValue, Exception exception, int i) {
        if (actionValue == null) {
            actionValue = new ActionValue();
        }
        this.f13339b = actionValue;
        this.f13338a = exception;
        this.f13340c = i;
    }

    public ActionValue m19376b() {
        return this.f13339b;
    }

    public Exception m19377c() {
        return this.f13338a;
    }

    public int m19378d() {
        return this.f13340c;
    }
}
