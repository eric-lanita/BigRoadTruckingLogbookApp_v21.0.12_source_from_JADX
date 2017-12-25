package com.bigroad.shared;

import java.util.LinkedHashMap;
import java.util.Map.Entry;

public class LRUCache<K, V> extends LinkedHashMap<K, V> {
    private static final long serialVersionUID = 8282802200064928578L;
    private final int m_maxEntries;

    public LRUCache(int i) {
        super(i + 1, 1.0f, true);
        this.m_maxEntries = i;
    }

    protected boolean removeEldestEntry(Entry<K, V> entry) {
        return super.size() > this.m_maxEntries;
    }
}
