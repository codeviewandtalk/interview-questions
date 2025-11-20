package dsa;

public class LoopInLinkedList {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next = head;
      //  printList(head);
       boolean loop =   detectLoopInLinkedList(head);
       if(loop){
           System.out.println("Loop is present in List");
       }else{
           System.out.println("Loop is not present in List");
       }
    }
    private static void printList(ListNode node) {
        while (node != null) {
            System.out.print(node.getVal() + " ");
            node = node.next;
        }
    }
    private static boolean detectLoopInLinkedList(ListNode head) {
        ListNode slow= head;
        ListNode fast= head;
        while (slow!=null && fast!=null && fast.next!= null){
            slow=slow.next;
            fast= fast.next.next;

            if(slow==fast)
                return true;
        }
        return false;
    }
}
