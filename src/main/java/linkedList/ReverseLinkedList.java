package linkedList;

public class ReverseLinkedList {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    public static void main(String[] args) {

    }

    private static ListNode reverseIterative(ListNode head){
        ListNode curr = head;
        ListNode prev = null;
        ListNode next = null;

        while (curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    private static ListNode reverseRecursive(ListNode head){
        // base case
        if (head == null || head.next == null) return head;

        // trust recursion to reverse everything after head
        ListNode reversedRest = reverseRecursive(head.next);

        // attach current node at the end
        head.next.next = head;
        head.next = null;

        // return new head (doesn't change throughout recursion)
        return reversedRest;
    }

}
