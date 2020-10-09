import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 *  Uses inbulit linkedlist from java.util class.
 *  Rearranged using comparator.
 */
public class LinkedListDefault {
    /**
     * Just used comparator to rearrange where EVEN arranged followed by ODD
     * @param list
     * @return list
     */
    public static List rearrangeOddEven(List list) {
        Collections.sort(list, new Comparator<Integer>
                () {
            public int compare(Integer a, Integer b) {
                return b % 2 - a % 2;
            }

        });
        return list;
    }
    /**
     * Optional main method to verify without JUnit.
     *
     * @param args
     */
    public static void main(String[] args) {
        List<Integer> list=null;
        list = new LinkedList();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the length of the list ");
        int input = scanner.nextInt();
        int[] count = new int[input];
        System.out.println("Please enter the values for " + input+ " times ");
        for (int i = 0; i < count.length; i++) {
            list.add(scanner.nextInt());

        }
        scanner.close();
        list = rearrangeOddEven(list);
        for (Integer val : list) {
            System.out.print(val + " ");
        }
        System.out.println();
        System.out.println("Hurray rearranged, cheers!!!");
    }

}
