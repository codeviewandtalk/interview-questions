package dsa;

public class MergeTwoLinkedList {

    //Merged Two LinkedLit
    // LeetCode- 21
    public static void main(String[] args) {
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(3);
        head1.next.next = new ListNode(5);

        // 1->3->5 LinkedList created
        ListNode head2 = new ListNode(0);
        head2.next = new ListNode(2);
        head2.next.next = new ListNode(2);
        head2.next.next.next = new ListNode(4);
        printList(head1);
        System.out.println();
        printList(head2);
        System.out.println();
        // 0->2->4 LinkedList created
        ListNode mergedhead = mergeTwoLists(head1, head2);
        printList(mergedhead);
    }

    private static void printList(ListNode node) {
        while (node != null) {
            System.out.print(node.getVal() + " ");
            node = node.next;
        }
    }

    private static ListNode mergeTwoLists(ListNode head1, ListNode head2) {
        ListNode result = new ListNode(-1);

        ListNode temp = result;
        while (head1 != null && head2 != null) {

            if (head1.getVal() <= head2.getVal()) {
                temp.next = head1;
                head1 = head1.next;
            } else {
                temp.next = head2;
                head2 = head2.next;

            }
            temp = temp.next;
        }

        while (head1 != null) {
            temp.next = head1;
            head1 = head1.next;
            temp = temp.next;
        }

        while (head2 != null) {
            temp.next = head2;
            head2 = head2.next;
            temp = temp.next;
        }
        return result.next;
    }
}

class ListNode {
    private int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public ListNode getNext() {
        return next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }
}