package ru.ilin.charactercounter;

import ru.ilin.charactercounter.cache.CacheProvider;
import ru.ilin.charactercounter.cache.CacheProviderImpl;
import ru.ilin.charactercounter.counter.CachedSymbolCounter;
import ru.ilin.charactercounter.counter.SimpleSymbolCounter;
import ru.ilin.charactercounter.counter.SymbolCounter;
import ru.ilin.charactercounter.formater.SymbolFormatter;
import ru.ilin.charactercounter.formater.SymbolFormatterImpl;
import ru.ilin.charactercounter.validator.Validator;
import ru.ilin.charactercounter.validator.ValidatorImpl;

import java.util.Map;

public class ConsoleApplication {
    public static void main(String[] args) {

        Validator validator = new ValidatorImpl();
        SymbolCounter symbolCounter = new SimpleSymbolCounter();
        SymbolFormatter symbolFormatter = new SymbolFormatterImpl();
        CacheProvider<String, Map<Character, Integer>> cacheProvider = new CacheProviderImpl<>(20);
        CachedSymbolCounter cachedSymbolCounter = new CachedSymbolCounter(cacheProvider,symbolCounter);

        SymbolStatisticsPrinter symbolStatisticsPrinter =
                new SymbolStatisticsPrinter(validator, cachedSymbolCounter, symbolFormatter);
        System.out.println(symbolStatisticsPrinter.printStatistics("AAAbbbCCCddd"));
    }
}
