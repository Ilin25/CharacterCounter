package ru.ilin.charactercounter.counter;

import java.util.Map;

public interface SymbolCounter {

    Map<Character, Integer> countSymbols(String text);

}
