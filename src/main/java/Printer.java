import java.util.*;
import java.util.stream.Collectors;

public class Printer {

    public void printNumbers(Map<Integer, Integer> frequencies) {
        String s = "Number: " + frequencies.keySet()
                .stream()
                .map(Object::toString)
                .collect(Collectors.joining(", "));
        System.out.println(s);
    }

    public void printFrequencies(Map<Integer, Integer> frequencies) {
        String s = "Frequency: " +
                frequencies.values()
                        .stream()
                        .map(Object::toString)
                        .collect(Collectors.joining(", "));
        System.out.println(s);
    }

    public void printGraph(Map<Integer, Integer> frequencies) {
        int numberOfLines = getMax(frequencies);
        for (int i = numberOfLines; i > 0; i--) {
            StringBuilder s = new StringBuilder();
            for (int number : frequencies.values()) {
                if (number >= i) {
                    s.append("* ");
                } else {
                    s.append("  ");
                }
            }
            System.out.println(s);
        }
        System.out.println(frequencies.keySet()
                .stream()
                .map(Object::toString)
                .collect(Collectors.joining(" ")));
    }

    private int getMax(Map<Integer, Integer> frequencies) {
        return frequencies.values()
                .stream()
                .mapToInt(number -> number)
                .max().orElseThrow(NoSuchElementException::new);
    }
}
