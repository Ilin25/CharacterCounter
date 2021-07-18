package ru.ilin.charactercounter.counter;

import java.util.LinkedHashMap;
import java.util.Map;

public class SimpleSymbolCounter implements SymbolCounter{

    @Override
    public Map<Character, Integer> countSymbols(String inputLine) {

        char[] chars = inputLine.toCharArray();
        Map<Character, Integer> symbolToCounter = new LinkedHashMap<>();

        for (int i = 0; i < chars.length; i++) {
            symbolToCounter.merge(chars[i], 1, (oldValue, newValue) -> oldValue + newValue);
        }
        return symbolToCounter;
    }
}
