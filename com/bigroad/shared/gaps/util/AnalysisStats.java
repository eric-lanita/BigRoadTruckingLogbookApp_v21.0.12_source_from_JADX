package com.bigroad.shared.gaps.util;

import java.util.Map;

public class AnalysisStats {
    private C1092a f3562a;
    private C1092a f3563b;

    private enum Bucket {
        MS_1(1),
        MS_5(5),
        MS_10(10),
        MS_50(50),
        MS_100(100),
        MS_500(500),
        MS_1000(1000),
        MS_5000(5000),
        MS_10000(10000),
        MS_MAX(Long.MAX_VALUE);
        
        private final long m_maxMillis;

        private Bucket(long j) {
            this.m_maxMillis = j;
        }

        public String toString() {
            return Long.toString(this.m_maxMillis) + "ms";
        }
    }

    private static class C1092a {
        private Map<Bucket, Integer> f3560a;
        private long f3561b;

        public long m5427a() {
            return this.f3561b / 1000000;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            for (Bucket bucket : Bucket.values()) {
                Integer num = (Integer) this.f3560a.get(bucket);
                if (!(num == null || num.intValue() == 0)) {
                    stringBuilder.append(bucket == Bucket.values()[0] ? "" : " ").append(num).append("@").append(bucket.toString());
                }
            }
            return stringBuilder.toString();
        }
    }

    public String toString() {
        long a = this.f3563b.m5427a() + this.f3562a.m5427a();
        long j = a / 1000;
        return "graph construction(" + this.f3562a + ") analysis(" + this.f3563b + ")  total: " + j + "." + (((int) (a % 1000)) / 100) + "s";
    }
}
