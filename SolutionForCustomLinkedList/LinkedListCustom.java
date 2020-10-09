import java.util.Scanner;

/**
 * Custom linked list.
 * Implementation to push,rearrange and display the values from the list.
 */


public class LinkedListCustom {
    public Node head;

    /**
     * Iterate till last of the node and insert the value.
     *
     * @param val
     */
    public void insert(int val) {
        Node newNode = new Node(val);
        if (head == null) {
            head = newNode;
            return;
        } else {
            Node curNode = head;
            while (curNode.next != null) {

                curNode = curNode.next;
            }
            curNode.next = newNode;
        }

    }


    /**
     * Iterate from head till last node.
     * Inserting the value in 2 separate node(odd and even) respectively.
     * Then add EVEN node at the end of  ODD.
     * It preserves insertion order though rearrange.
     *
     * @param head * @return head
     */
    public Node arrangeOddEven(Node head) {
        Node evenBegin = null, evenEnd = null;
        Node oddBegin = null, oddEnd = null;
        Node curNode = head;
        while (curNode != null) {//Iterate till last node.
            if (curNode.id % 2 == 0) {//Check for even
                if (evenBegin == null) {//Intializing first value for even
                    evenBegin = curNode;
                    evenEnd = evenBegin;
                } else {
                    evenEnd.next = curNode;//Setting the entire node in the end
                    evenEnd = evenEnd.next;
                }
            } else {//Check for odd
                if (oddBegin == null) {//Intializing first value for odd
                    oddBegin = curNode;
                    oddEnd = oddBegin;
                } else {
                    oddEnd.next = curNode;//Setting the entire node in the end
                    oddEnd = oddEnd.next;
                }
            }
            curNode = curNode.next;//Iteration one by one from begining.
        }
        oddEnd.next = evenBegin;//Setting the even at the end followed by odd.
        evenEnd.next = null;
        head = oddBegin;
        return head;
    }

    /**
     * Swapping just current node(address) with previous node.
     * Before swapping, will store node in temp so that, can iterate till last.
     * @param head
     * @return
     */
    public static Node reverse(Node head){
        Node currentNode=head;//Making it as current Node.
        Node prev=null;//Initally prev should be null as it is head of singly linked list.
        while(currentNode!=null){//iterate till last
            Node temp=currentNode.next;//Storing it in temp for iteration purpose
            currentNode.next=prev;//Making node value as prev node...Yes it is a swap.
            prev=currentNode;//Holding it for next iteration, as current node would be previous for next node.
            currentNode=temp;// Help of temp :-), can iterate to next node or will get null pointer exception :-(.
        }

        return prev;
    }

    /**
     * Iterating till last and diplaying the list of values horizontally.
     *
     * @param node
     */
    public void display(Node node) {
        while (node != null) {
            System.out.print(node.id + " ");
            node = node.next;
        }
    }

    /**
     * Optional main method to verify without JUnit.
     * @param args
     */
    public static void main(String[] args) {
        LinkedListCustom list = new LinkedListCustom();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the length of the list ");
        int input = scanner.nextInt();
        int[] count = new int[input];
        System.out.println("Please enter the values for " + input+ " times ");
        for (int i = 0; i < count.length; i++) {
            list.insert(scanner.nextInt());

        }
        scanner.close();
        Node sortedNode = list.arrangeOddEven(list.head);//rearrange
        list.display(sortedNode);
        System.out.println();
        System.out.println("Hurray rearranged, cheers!!!");
        Node reversedNode = list.reverse(list.head);//reverse
        list.display(reversedNode);
        System.out.println();
        System.out.println("Hurray reversed, cheers!!!");
    }


}
