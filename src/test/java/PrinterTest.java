import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class PrinterTest {

    private static ByteArrayOutputStream outContent;
    private static Map<Integer, Integer> frequencies;
    private static Printer printer;

    @BeforeAll
    static void beforeAll() {
        frequencies = new HashMap<>();
        printer = new Printer();
        outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    public void afterEach() throws IOException {
        outContent.reset();
        frequencies.clear();
    }

    @Test
    void printNumbers() {
        frequencies.put(1, 3);
        frequencies.put(2, 1);

        printer.printNumbers(frequencies);

        assertThat(outContent.toString()).isEqualTo("Number: 1, 2\r\n");
    }

    @Test
    void printFrequencies() {
        frequencies.put(1, 3);
        frequencies.put(2, 1);

        printer.printFrequencies(frequencies);

        assertThat(outContent.toString()).isEqualTo("Frequency: 3, 1\r\n");
    }

    @Test
    void printGraph() {
        frequencies.put(1,1);
        frequencies.put(2,2);

        printer.printGraph(frequencies);

        assertThat(outContent.toString()).isEqualTo("  * \r\n* * \r\n1 2\r\n");
    }
}
