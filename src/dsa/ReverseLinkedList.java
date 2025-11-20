package dsa;

public class ReverseLinkedList {
    public static void main(String[] args) {

        // Reverse LinkedList
        // LeetCode- 206
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        printList(head);
        System.out.println();
        System.out.println("After Reversing the List");
      Node reverseListHead =   reverseLinkedList(head);

      printList(reverseListHead);
    }

    private static Node reverseLinkedList(Node head) {
        Node current=head;
        Node previous=null;
        Node next= null;

        while(current!=null){
            next= current.next;
            current.next=previous;
            previous= current;
            current=next;
        }
        return previous;
    }


    private static void printList(Node node) {
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
    }
}


class Node {
    int val;
    Node next;

    Node() {

    }

    Node(int val) {
        this.val = val;
    }

}