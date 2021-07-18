package ru.ilin.charactercounter.cache;

public interface CacheProvider<K, V> {

    V putInCache(K key, V value);

    V getFromCache(K key);

    boolean isPresent(K key);

}
