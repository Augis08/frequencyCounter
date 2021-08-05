import java.util.Arrays;
import java.util.Scanner;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter numbers array (e.g. 1,2,3...): ");
        String input = scanner.nextLine();

        List<Integer> numbersList = Arrays
                .stream(input.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

//        List<Integer> numbersList = List.of(1, 4, 1, 5, 8, 1, 3, 5, 1, 4, 1, 3, 7, 2);

        FrequencyCounter frequencyCounter = new FrequencyCounter();
        Printer printer = new Printer();

        frequencyCounter.countFrequencies(numbersList);

        printer.printFrequencies(frequencyCounter.getFrequencies());
        printer.printNumbers(frequencyCounter.getFrequencies());
        System.out.println("Graph: ");
        printer.printGraph(frequencyCounter.getFrequencies());
    }
}
