package dsa;

public class MiddleElementInLinkedList {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        printList(head);
        System.out.println();
        int middleElement= middleelementInLinkedlist(head);
        System.out.println(middleElement);

    }

    private static int middleelementInLinkedlist(ListNode head) {
        ListNode slow= head;
        ListNode fast= head;
        while (fast!=null && fast.next!= null){
             slow=slow.next;
             fast= fast.next.next;
        }
        return slow.getVal();
    }

    private static void printList(ListNode node) {
        while (node != null) {
            System.out.print(node.getVal() + " ");
            node = node.next;
        }
    }
}
