package ru.ilin.charactercounter.cache;

import java.util.LinkedHashMap;
import java.util.Map;

public class CacheProviderImpl <K,V> extends LinkedHashMap implements CacheProvider <K,V> {

    private static int maxSize;

    public CacheProviderImpl(int maxSize) {
        super(1, 0.75f, true);
        this.maxSize = maxSize;
    }

    @Override
    protected boolean removeEldestEntry(final Map.Entry eldest) {
        return size() > maxSize;
    }

    @Override
    public boolean isPresent(Object key) {
        return containsKey(key);
    }

    @Override
    public V putInCache(K key, V value) {
        put(key,value);
        return value;
    }

    @Override
    public V getFromCache(K key) {
        return (V) get(key);
    }
}
