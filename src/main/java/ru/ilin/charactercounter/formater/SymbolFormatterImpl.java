package ru.ilin.charactercounter.formater;

import java.util.Map;

public class SymbolFormatterImpl implements SymbolFormatter{

    @Override
    public String format(String text, Map<Character, Integer> symbolToCounter) {

        StringBuilder viewResultLine = new StringBuilder();
        viewResultLine.append(text).append(System.lineSeparator());

        for (Map.Entry entry : symbolToCounter.entrySet()) {
            viewResultLine
                    .append('"')
                    .append(entry.getKey())
                    .append('"').append(" ")
                    .append('-').append(" ")
                    .append(entry.getValue())
                    .append(System.lineSeparator());
        }
        return viewResultLine.toString();
    }
}
