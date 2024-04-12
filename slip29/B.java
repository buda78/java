import java.util.LinkedList;
public class LinkedListOperations {
    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.addFirst(10);
        linkedList.addFirst(20);
        linkedList.addFirst(30);
        System.out.println("LinkedList after adding elements at first position:");
        displayLinkedList(linkedList);
        if (!linkedList.isEmpty()) {
            linkedList.removeLast();
        }
        System.out.println("\nLinkedList after deleting last element:");
        displayLinkedList(linkedList);
        System.out.println("\nSize of the LinkedList: " + linkedList.size());
    }
    private static void displayLinkedList(LinkedList<Integer> list) {
        for (Integer element : list) {
            System.out.print(element + " ");
        }
        System.out.println();
    }
}

