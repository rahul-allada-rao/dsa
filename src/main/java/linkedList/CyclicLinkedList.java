package linkedList;

public class CyclicLinkedList {

    public static void main(String[] args) {

    }

    private static boolean detectCycle(ListNode listNode){
        // assuming that a null node or a single node, then a cycle doesn't exist
        if (listNode == null || listNode.next == null){
            return false;
        }

        // initialise slow and fast pointers
        ListNode slow = listNode;
        ListNode fast = listNode;

        // exit condition for the while loop
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            // if there is any instance when slow == fast, then that means that fast has actually lapped the linkedList
            // cycle exists and return true.
            if (slow == fast){
                return true;
            }
        }
        // if slow != fast ever, then cycle doesn't exist
        return false;
    }
}
