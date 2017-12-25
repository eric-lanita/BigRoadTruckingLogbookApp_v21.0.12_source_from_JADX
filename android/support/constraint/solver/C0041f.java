package android.support.constraint.solver;

final class C0041f {

    interface C0039a<T> {
        T mo34a();

        void mo35a(T[] tArr, int i);

        boolean mo36a(T t);
    }

    static class C0040b<T> implements C0039a<T> {
        private final Object[] f278a;
        private int f279b;

        C0040b(int i) {
            if (i <= 0) {
                throw new IllegalArgumentException("The max pool size must be > 0");
            }
            this.f278a = new Object[i];
        }

        public T mo34a() {
            if (this.f279b <= 0) {
                return null;
            }
            int i = this.f279b - 1;
            T t = this.f278a[i];
            this.f278a[i] = null;
            this.f279b--;
            return t;
        }

        public boolean mo36a(T t) {
            if (this.f279b >= this.f278a.length) {
                return false;
            }
            this.f278a[this.f279b] = t;
            this.f279b++;
            return true;
        }

        public void mo35a(T[] tArr, int i) {
            if (i > tArr.length) {
                i = tArr.length;
            }
            for (int i2 = 0; i2 < i; i2++) {
                T t = tArr[i2];
                if (this.f279b < this.f278a.length) {
                    this.f278a[this.f279b] = t;
                    this.f279b++;
                }
            }
        }
    }
}
