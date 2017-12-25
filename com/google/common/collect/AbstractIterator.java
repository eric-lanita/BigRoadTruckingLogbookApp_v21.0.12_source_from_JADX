package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.NoSuchElementException;

public abstract class AbstractIterator<T> extends ab<T> {
    private State f12923a = State.NOT_READY;
    private T f12924b;

    private enum State {
        READY,
        NOT_READY,
        DONE,
        FAILED
    }

    protected abstract T mo2702a();

    protected AbstractIterator() {
    }

    @CanIgnoreReturnValue
    protected final T m18317b() {
        this.f12923a = State.DONE;
        return null;
    }

    @CanIgnoreReturnValue
    public final boolean hasNext() {
        Preconditions.checkState(this.f12923a != State.FAILED);
        switch (this.f12923a) {
            case DONE:
                return false;
            case READY:
                return true;
            default:
                return m18315c();
        }
    }

    private boolean m18315c() {
        this.f12923a = State.FAILED;
        this.f12924b = mo2702a();
        if (this.f12923a == State.DONE) {
            return false;
        }
        this.f12923a = State.READY;
        return true;
    }

    @CanIgnoreReturnValue
    public final T next() {
        if (hasNext()) {
            this.f12923a = State.NOT_READY;
            T t = this.f12924b;
            this.f12924b = null;
            return t;
        }
        throw new NoSuchElementException();
    }
}
