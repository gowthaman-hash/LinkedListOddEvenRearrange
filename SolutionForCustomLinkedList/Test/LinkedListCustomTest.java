import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


/**
 * To test the sorting algorithm on ascending order from odd to even for the given input.
 */
public class LinkedListCustomTest {

    LinkedListCustom linkedListCustom = new LinkedListCustom();
    Node node;
    LinkedListCustom linkedListCustomExpected = new LinkedListCustom();

    /**
     * Intialize for each test and expected output post sort is 1 3 5 9 11 2 6 10
     */
    @BeforeEach
    void initialize() {
        linkedListCustom.insert(2);
        linkedListCustom.insert(5);
        linkedListCustom.insert(1);
        linkedListCustom.insert(6);
        linkedListCustom.insert(11);
        node = linkedListCustom.arrangeOddEven(linkedListCustom.head);

        linkedListCustomExpected.insert(5);
        linkedListCustomExpected.insert(1);
        linkedListCustomExpected.insert(11);
        linkedListCustomExpected.insert(2);
        linkedListCustomExpected.insert(6);
    }

    /**
     * As per the input(2,5,1,6,11),first value should 5 and it should be odd. Can be tested it by modulo function.
     */

    @Test
    void checkFirstValueAsOdd() {

        assertNotNull(linkedListCustomExpected.head);
        assertEquals(linkedListCustomExpected.head.id % 2 != 0, node.id % 2 != 0);
    }

    /**
     * As per the input(2,5,1,6,11),last value should 6 and it should be even. Can be tested it by modulo function.
     */

    @Test
    void checkLastValueAsEven() {
        while (node.next != null) {//iterating till last.
            node = node.next;
        }
        Node expectedNode = linkedListCustomExpected.head;
        while (expectedNode.next != null) {//iterating till last.
            expectedNode = expectedNode.next;
        }
        assertNotNull(linkedListCustomExpected.head);
        assertEquals(expectedNode.id % 2 == 0, node.id % 2 == 0);
    }
}