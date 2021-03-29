import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.ParameterizedTest;

import java.util.PriorityQueue;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class PriorityQueueTest {

    public static Stream<Arguments> getParameters(){
        return Stream.of(
                arguments(new int[]{1,5,2,3}, new int[]{1,2,3,5}),
                arguments(new int[]{1,43,2,3}, new int[]{1,2,3,43}),
                arguments(new int[]{1,0,2,3}, new int[]{0,1,2,3}),
                arguments(new int[]{1,9,7,6}, new int[]{1,6,7,9}),
                arguments(new int[]{1,2,3,4}, new int[]{1,2,3,4})
        );


    }
    @ParameterizedTest
    @MethodSource("getParameters")
    public void parameterizedTest(int[] input, int[] expected){
        PriorityQueue pqInput = new PriorityQueue();
        for (int e : input) {
            pqInput.offer(e);
        }
        for (int e : expected) {
            assertEquals(e, pqInput.poll());
        }

    }

    @Test
    public void InitialCapacityTest(){
        Exception exception = assertThrows(IllegalArgumentException.class, () ->{
            new PriorityQueue(-1,null);
        });
    }
    @Test
    public void offerTest(){
        Exception exception = assertThrows(NullPointerException.class, ()->{
            new PriorityQueue().offer(null);
        });
    }
    @Test
    public void ForEachRemainingTest(){
        Exception exception = assertThrows(NullPointerException.class, ()->{
            new PriorityQueue().forEach(null);
        });
    }
}
