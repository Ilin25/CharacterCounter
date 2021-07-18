package ru.ilin.charactercounter.counter;

import ru.ilin.charactercounter.cache.CacheProvider;
import java.util.Map;

public class CachedSymbolCounter implements SymbolCounter {

    private final CacheProvider<String, Map<Character, Integer>> cacheProvider;
    private final SymbolCounter symbolCounter;

    public CachedSymbolCounter(CacheProvider<String, Map<Character, Integer>> cacheProvider, SymbolCounter symbolCounter) {
        this.cacheProvider = cacheProvider;
        this.symbolCounter = symbolCounter;
    }

    @Override
    public Map<Character, Integer> countSymbols(String inputLine) {
        if (cacheProvider.isPresent(inputLine)) {
            return cacheProvider.getFromCache(inputLine);

        } else {
            Map<Character, Integer> symbolToCount = symbolCounter.countSymbols(inputLine);
            cacheProvider.putInCache(inputLine, symbolToCount);
            return symbolToCount;
        }
    }
}
