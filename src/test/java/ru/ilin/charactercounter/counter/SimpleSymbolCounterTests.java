package ru.ilin.charactercounter.counter;
import org.junit.jupiter.api.Test;
import java.util.LinkedHashMap;
import java.util.Map;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class SimpleSymbolCounterTests {

    @Test
    void countSymbolsShouldMapWhenString(){
        SimpleSymbolCounter simpleSymbolCounter = new SimpleSymbolCounter();
        String text = "AAAbbbCCCddd";
        Map<Character, Integer> results = new LinkedHashMap<>();
        results.put('A',3);
        results.put('b',3);
        results.put('C',3);
        results.put('d',3);
        assertThat(simpleSymbolCounter.countSymbols(text), equalTo(results));
    }
}
