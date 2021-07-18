package ru.ilin.charactercounter.formater;

import java.util.Map;

public interface SymbolFormatter {

    String format(String text, Map<Character, Integer> symbolToCount);

}
