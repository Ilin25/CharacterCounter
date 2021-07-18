package ru.ilin.charactercounter.formatter;

import org.junit.jupiter.api.Test;
import ru.ilin.charactercounter.formater.SymbolFormatter;
import ru.ilin.charactercounter.formater.SymbolFormatterImpl;
import java.util.LinkedHashMap;
import java.util.Map;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class SymbolFormatterImplTests {

    @Test
    void formatShouldStringWhenStringMap(){
        SymbolFormatter symbolFormatter = new SymbolFormatterImpl();
        Map<Character, Integer> symbolToCounter = new LinkedHashMap<>();

        symbolToCounter.put('A',3);
        symbolToCounter.put('b',3);
        symbolToCounter.put('C',3);
        symbolToCounter.put('d',3);
        String inputText = "AAAbbbCCCddd";
        assertThat(symbolFormatter.format(inputText, symbolToCounter),
                equalTo("AAAbbbCCCddd\r\n\"A\" - 3\r\n\"b\" - 3\r\n\"C\" - 3\r\n\"d\" - 3\r\n"));
    }
}
