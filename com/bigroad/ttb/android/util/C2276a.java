package com.bigroad.ttb.android.util;

import com.google.common.base.Objects;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class C2276a<FlagType> {
    private final Map<FlagType, Long> f7914a;
    private final Map<FlagType, Long> f7915b;

    public static class C2275a<FlagType> {
        private final C2276a<FlagType> f7912a;
        private Set<FlagType> f7913b;

        public C2275a() {
            this(null);
        }

        public C2275a(C2276a<FlagType> c2276a) {
            this.f7913b = new HashSet();
            this.f7912a = c2276a;
            if (c2276a != null) {
                for (Object next : c2276a.f7914a.keySet()) {
                    if (c2276a.m11163a(next)) {
                        this.f7913b.add(next);
                    }
                }
            }
        }

        public boolean m11156a(FlagType flagType) {
            return this.f7913b.contains(flagType);
        }

        public C2275a<FlagType> m11154a(FlagType flagType, boolean z) {
            if (z) {
                return m11157b(flagType);
            }
            return m11158c(flagType);
        }

        public C2275a<FlagType> m11157b(FlagType flagType) {
            this.f7913b.add(flagType);
            return this;
        }

        public C2275a<FlagType> m11158c(FlagType flagType) {
            this.f7913b.remove(flagType);
            return this;
        }

        public C2275a<FlagType> m11153a() {
            this.f7913b.clear();
            return this;
        }

        public C2276a<FlagType> m11155a(long j) {
            Map hashMap = new HashMap();
            Map hashMap2 = new HashMap();
            if (this.f7912a != null) {
                hashMap.putAll(this.f7912a.f7914a);
                hashMap2.putAll(this.f7912a.f7915b);
                for (Object next : this.f7913b) {
                    if (!this.f7912a.m11163a(next)) {
                        hashMap.put(next, Long.valueOf(j));
                    }
                }
                for (Object next2 : this.f7912a.f7914a.keySet()) {
                    if (!this.f7913b.contains(next2) && this.f7912a.m11163a(next2)) {
                        hashMap2.put(next2, Long.valueOf(j));
                    }
                }
            } else {
                for (Object next22 : this.f7913b) {
                    hashMap.put(next22, Long.valueOf(j));
                }
            }
            return new C2276a(hashMap, hashMap2);
        }
    }

    public C2276a() {
        this(Collections.EMPTY_MAP, Collections.EMPTY_MAP);
    }

    protected C2276a(Map<FlagType, Long> map, Map<FlagType, Long> map2) {
        this.f7914a = map;
        this.f7915b = map2;
    }

    public boolean m11163a(FlagType flagType) {
        if (!this.f7914a.containsKey(flagType)) {
            return false;
        }
        if (!this.f7915b.containsKey(flagType)) {
            return true;
        }
        return ((Long) this.f7914a.get(flagType)).longValue() > ((Long) this.f7915b.get(flagType)).longValue();
    }

    public Long m11164b(FlagType flagType) {
        if (m11163a((Object) flagType)) {
            return (Long) this.f7914a.get(flagType);
        }
        return null;
    }

    public <CollectionType extends Collection<FlagType>> CollectionType m11162a(CollectionType collectionType) {
        for (Object next : this.f7914a.keySet()) {
            if (m11163a(next)) {
                collectionType.add(next);
            }
        }
        return collectionType;
    }

    public C2275a<FlagType> m11161a() {
        return new C2275a(this);
    }

    public boolean equals(Object obj) {
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        C2276a c2276a = (C2276a) obj;
        if (Objects.equal(this.f7915b, c2276a.f7915b) && Objects.equal(this.f7914a, c2276a.f7914a)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return Objects.hashCode(this.f7914a, this.f7915b);
    }
}
