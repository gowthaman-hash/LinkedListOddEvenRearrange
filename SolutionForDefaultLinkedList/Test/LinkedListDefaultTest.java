import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

public class LinkedListDefaultTest {
    @Test
    void checkReaarrangeValue(){
		List<Integer> list = Arrays.asList(9,6,2,8,7,11);
		List<Integer> expectedlist =Arrays.asList(9,7,11,6,2,8);

        assertEquals(expectedlist, LinkedListDefault.rearrangeOddEven(list));

    }

}
