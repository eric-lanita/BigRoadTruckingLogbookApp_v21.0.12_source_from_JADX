package com.google.android.gms.tasks;

public class TaskCompletionSource<TResult> {
    private final zzh<TResult> f12850a = new zzh();

    public Task<TResult> getTask() {
        return this.f12850a;
    }

    public void setException(Exception exception) {
        this.f12850a.setException(exception);
    }

    public void setResult(TResult tResult) {
        this.f12850a.setResult(tResult);
    }
}
