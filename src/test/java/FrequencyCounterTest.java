import org.junit.jupiter.api.Test;

import static java.util.Map.entry;
import static java.util.Map.ofEntries;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

class FrequencyCounterTest {

    @Test
    void countFrequencies_When_GivenArray() {
        FrequencyCounter frequencyCounter = new FrequencyCounter();
        List<Integer> numbers = List.of(1,1,2,2);

        frequencyCounter.countFrequencies(numbers);

        assertThat(frequencyCounter.getFrequencies()).isEqualTo(ofEntries(entry(1,2),entry(2,2)));
    }

    @Test
    void countFrequencies_When_NumberIsNotExistInArray() {
        FrequencyCounter frequencyCounter = new FrequencyCounter();
        List<Integer> numbers = List.of(1,1,3,3);

        frequencyCounter.countFrequencies(numbers);

        assertThat(frequencyCounter.getFrequencies()).contains(entry(2,0));
    }
}
