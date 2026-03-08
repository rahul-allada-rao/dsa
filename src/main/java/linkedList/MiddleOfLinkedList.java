package linkedList;

public class MiddleOfLinkedList {

    public static void main(String[] args) {

    }

    private static ListNode findMiddleNode(ListNode listNode){
        if (listNode == null || listNode.next == null){
            return listNode;
        }
        ListNode slowPtr = listNode;
        ListNode fastPtr = listNode;

        while (fastPtr != null && fastPtr.next != null){
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
        }
        return slowPtr;
    }
}
