package easy.list;

/**
 * @author csieflyman
 */
public class ListNode {

    int val;
    ListNode next;
    ListNode(int x) { val = x; }

    public static ListNode swap(ListNode head) {
        ListNode temp = head.next;
        head.next = null;
        temp.next = head;
        return temp;
    }

    public static ListNode concat(ListNode head1, ListNode head2) {
        getLast(head1).next = head2;
        return head1;
    }

    public static int size(ListNode head) {
        if(head == null)
            return 0;

        int size = 1;
        while(head.next != null) {
            head = head.next;
            size++;
        }
        return size;
    }

    public static ListNode getNode(ListNode head, int index) {
        if(index == 0)
            return head;

        int incrementIndex = 0;
        while(head.next != null) {
            if(incrementIndex == index)
                return head;
            head = head.next;
            incrementIndex++;
        }
        return head;
    }

    public static ListNode getLast(ListNode head) {
        while(head.next != null) {
            head = head.next;
        }
        return head;
    }

    public static ListNode getFirst(ListNode head){
        return head;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ListNode listNode = (ListNode) o;

        return val == listNode.val;

    }

    @Override
    public int hashCode() {
        return val;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}
