package io.fabric.sdk.android.services.concurrency;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class DependencyPriorityBlockingQueue<E extends C2927a & C2929i & C2928f> extends PriorityBlockingQueue<E> {
    final Queue<E> blockedQueue = new LinkedList();
    private final ReentrantLock lock = new ReentrantLock();

    public /* synthetic */ Object peek() {
        return m20827b();
    }

    public /* synthetic */ Object poll() {
        return m20829c();
    }

    public /* synthetic */ Object poll(long j, TimeUnit timeUnit) {
        return m20823a(j, timeUnit);
    }

    public /* synthetic */ Object take() {
        return m20821a();
    }

    public E m20821a() {
        return m20828b(0, null, null);
    }

    public E m20827b() {
        E e = null;
        try {
            e = m20828b(1, null, null);
        } catch (InterruptedException e2) {
        }
        return e;
    }

    public E m20823a(long j, TimeUnit timeUnit) {
        return m20828b(3, Long.valueOf(j), timeUnit);
    }

    public E m20829c() {
        E e = null;
        try {
            e = m20828b(2, null, null);
        } catch (InterruptedException e2) {
        }
        return e;
    }

    public int size() {
        try {
            this.lock.lock();
            int size = this.blockedQueue.size() + super.size();
            return size;
        } finally {
            this.lock.unlock();
        }
    }

    public <T> T[] toArray(T[] tArr) {
        try {
            this.lock.lock();
            T[] a = m20826a(super.toArray(tArr), this.blockedQueue.toArray(tArr));
            return a;
        } finally {
            this.lock.unlock();
        }
    }

    public Object[] toArray() {
        try {
            this.lock.lock();
            Object[] a = m20826a(super.toArray(), this.blockedQueue.toArray());
            return a;
        } finally {
            this.lock.unlock();
        }
    }

    public int drainTo(Collection<? super E> collection) {
        try {
            this.lock.lock();
            int drainTo = super.drainTo(collection) + this.blockedQueue.size();
            while (!this.blockedQueue.isEmpty()) {
                collection.add(this.blockedQueue.poll());
            }
            return drainTo;
        } finally {
            this.lock.unlock();
        }
    }

    public int drainTo(Collection<? super E> collection, int i) {
        try {
            this.lock.lock();
            int drainTo = super.drainTo(collection, i);
            while (!this.blockedQueue.isEmpty() && drainTo <= i) {
                collection.add(this.blockedQueue.poll());
                drainTo++;
            }
            this.lock.unlock();
            return drainTo;
        } catch (Throwable th) {
            this.lock.unlock();
        }
    }

    public boolean contains(Object obj) {
        try {
            this.lock.lock();
            boolean z = super.contains(obj) || this.blockedQueue.contains(obj);
            this.lock.unlock();
            return z;
        } catch (Throwable th) {
            this.lock.unlock();
        }
    }

    public void clear() {
        try {
            this.lock.lock();
            this.blockedQueue.clear();
            super.clear();
        } finally {
            this.lock.unlock();
        }
    }

    public boolean remove(Object obj) {
        try {
            this.lock.lock();
            boolean z = super.remove(obj) || this.blockedQueue.remove(obj);
            this.lock.unlock();
            return z;
        } catch (Throwable th) {
            this.lock.unlock();
        }
    }

    public boolean removeAll(Collection<?> collection) {
        try {
            this.lock.lock();
            boolean removeAll = super.removeAll(collection) | this.blockedQueue.removeAll(collection);
            return removeAll;
        } finally {
            this.lock.unlock();
        }
    }

    E m20822a(int i, Long l, TimeUnit timeUnit) {
        switch (i) {
            case 0:
                return (C2927a) super.take();
            case 1:
                return (C2927a) super.peek();
            case 2:
                return (C2927a) super.poll();
            case 3:
                return (C2927a) super.poll(l.longValue(), timeUnit);
            default:
                return null;
        }
    }

    boolean m20824a(int i, E e) {
        try {
            this.lock.lock();
            if (i == 1) {
                super.remove(e);
            }
            boolean offer = this.blockedQueue.offer(e);
            return offer;
        } finally {
            this.lock.unlock();
        }
    }

    E m20828b(int i, Long l, TimeUnit timeUnit) {
        C2927a a;
        while (true) {
            a = m20822a(i, l, timeUnit);
            if (a == null || m20825a(a)) {
                return a;
            }
            m20824a(i, a);
        }
        return a;
    }

    boolean m20825a(E e) {
        return e.mo1479d();
    }

    public void m20830d() {
        try {
            this.lock.lock();
            Iterator it = this.blockedQueue.iterator();
            while (it.hasNext()) {
                C2927a c2927a = (C2927a) it.next();
                if (m20825a(c2927a)) {
                    super.offer(c2927a);
                    it.remove();
                }
            }
        } finally {
            this.lock.unlock();
        }
    }

    <T> T[] m20826a(T[] tArr, T[] tArr2) {
        int length = tArr.length;
        int length2 = tArr2.length;
        Object[] objArr = (Object[]) Array.newInstance(tArr.getClass().getComponentType(), length + length2);
        System.arraycopy(tArr, 0, objArr, 0, length);
        System.arraycopy(tArr2, 0, objArr, length, length2);
        return objArr;
    }
}
