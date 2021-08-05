import lombok.Data;

import java.util.*;

@Data
public class FrequencyCounter {
    private Map<Integer, Integer> frequencies;

    public FrequencyCounter() {
        this.frequencies = new HashMap<>();
    }

    public void countFrequencies(List<Integer> numbers) {
        int min = getMin(numbers);
        int max = getMax(numbers);

        for (int i = min; i <= max; i++){
            frequencies.put(i, Collections.frequency(numbers, i));
        }
    }

    private int getMin(List<Integer> numbers) {
        return numbers
                .stream()
                .mapToInt(number -> number)
                .min().orElseThrow(NoSuchElementException::new);
    }

    private int getMax(List<Integer> numbers) {
        return numbers
                .stream()
                .mapToInt(number -> number)
                .max().orElseThrow(NoSuchElementException::new);
    }

}
