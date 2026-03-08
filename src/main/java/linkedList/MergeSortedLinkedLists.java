package linkedList;

/**
 * Input:  List1: 1 → 3 → 5 → 7
 *         List2: 2 → 4 → 6 → 8
 *
 * Output: 1 → 2 → 3 → 4 → 5 → 6 → 7 → 8
 *
 * Input:  List1: 1 → 2 → 4
 *         List2: 1 → 3 → 4
 *
 * Output: 1 → 1 → 2 → 3 → 4 → 4
 */
public class MergeSortedLinkedLists {

    public static void main(String[] args) {

    }

    private static ListNode mergeSortedLinkedList(ListNode l1, ListNode l2){

        // if either of them are null, return the other, this handles even if both of them are null
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        while (l1!= null && l2 != null){
            if (l1.val <= l2.val) {
                current.next = l1;
                l1 = l1.next;
            }
            else {
                current.next = l2;
                l2 = l2.next;
            }
            current = current.next;
        }

        // if lists are unequal, then attach them in this order
        if (l1 != null) current.next = l1;
        if (l2 != null) current.next = l2;

        // discard dummy (0 node) and return the actual head
        return dummy.next;
    }

    private static ListNode mergeSortedLinkedListRecursively(ListNode l1, ListNode l2){
        // base case
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        if (l1.val < l2.val){
            l1.next = mergeSortedLinkedListRecursively(l1.next, l2);
            return l1;
        }
        else {
            l2.next = mergeSortedLinkedListRecursively(l1, l2.next);
            return l2;
        }
    }
}
