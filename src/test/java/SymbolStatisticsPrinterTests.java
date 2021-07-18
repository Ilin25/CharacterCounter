
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.ilin.charactercounter.SymbolStatisticsPrinter;
import ru.ilin.charactercounter.counter.SymbolCounter;
import ru.ilin.charactercounter.formater.SymbolFormatter;
import ru.ilin.charactercounter.validator.Validator;
import java.util.Map;
import java.util.TreeMap;
import static org.mockito.Mockito.lenient;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class SymbolStatisticsPrinterTests {

    @Mock
    private Validator validator;

    @Mock
    private SymbolCounter symbolCounter;

    @Mock
    private  SymbolFormatter symbolFormatter;

    @InjectMocks
    private SymbolStatisticsPrinter symbolStatisticsPrinter;

    @Test
    void printStatistics(){
        Map<Character, Integer> symbolToCount = new TreeMap<>();
        symbolToCount.put('A',3);
        symbolToCount.put('b',3);
        symbolToCount.put('C',3);
        symbolToCount.put('d',3);

        symbolStatisticsPrinter.printStatistics("AAAbbbCCCddd");

        verify(validator).validate("AAAbbbCCCddd");

        lenient().when(symbolCounter.countSymbols("AAAbbbCCCddd")).thenReturn(symbolToCount);

        lenient().when(symbolFormatter.format("AAAbbbCCCddd", symbolToCount)).
                thenReturn("AAAbbbCCCddd\n" +
                "\"A\" - 3\n" +
                "\"b\" - 3\n" +
                "\"C\" - 3\n" +
                "\"d\" - 3\n");
    }
}
