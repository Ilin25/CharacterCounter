package ru.ilin.charactercounter;
import ru.ilin.charactercounter.counter.SymbolCounter;
import ru.ilin.charactercounter.formater.SymbolFormatter;
import ru.ilin.charactercounter.validator.Validator;
import java.util.Map;

public class SymbolStatisticsPrinter {
    private final Validator validator;
    private final SymbolCounter symbolCounter;
    private final SymbolFormatter symbolFormatter;

    public SymbolStatisticsPrinter(Validator validator, SymbolCounter symbolCounter,
                                   SymbolFormatter symbolFormatter) {
        this.validator = validator;
        this.symbolCounter = symbolCounter;
        this.symbolFormatter = symbolFormatter;
    }

    public String printStatistics(String text) {
        validator.validate(text);
        Map<Character, Integer> symbolToCounter = symbolCounter.countSymbols(text);
        return symbolFormatter.format(text, symbolToCounter);
    }
}
