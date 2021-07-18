package ru.ilin.charactercounter.counter;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.ilin.charactercounter.cache.CacheProvider;
import java.util.Map;
import java.util.TreeMap;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.lenient;

@ExtendWith(MockitoExtension.class)
public class CachedSymbolCounterTests {

    @Mock
    private CacheProvider<String, Map<Character, Integer>> cacheProvider;

    @Mock
    private SymbolCounter symbolCounter;

    @InjectMocks
    private CachedSymbolCounter cachedSymbolCounter;

    @Test
    void countSymbolsShouldMapWhenString(){
        String inputLinePart1 = "AAAbbbCCCddd";
        String inputLinePart2 = "AAAbbbCCC";

        Map<Character,Integer> results = new TreeMap<>();
        results.put('A',3);
        results.put('b',3);
        results.put('C',3);
        results.put('d',3);
        cacheProvider.putInCache(inputLinePart1, results);

        cachedSymbolCounter.countSymbols(inputLinePart1);

        lenient().when(cacheProvider.isPresent(inputLinePart1)).thenReturn(true);

        lenient().when(cacheProvider.isPresent(inputLinePart2)).thenReturn(false);

        lenient().when(cacheProvider.getFromCache(inputLinePart1)).thenReturn(results);

        lenient().when(symbolCounter.countSymbols(inputLinePart1)).thenReturn(results);

        lenient().when(cacheProvider.putInCache(inputLinePart1,results)).thenReturn(results);

        lenient().when(cachedSymbolCounter.countSymbols(inputLinePart1)).thenReturn(results);

        assertThat(cachedSymbolCounter.countSymbols(inputLinePart1), equalTo(results));

    }
}
