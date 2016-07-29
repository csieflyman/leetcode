package easy.list;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

/**
 * @author csieflyman
 */
@RunWith(Parameterized.class)
public class ReverseLinkedList {

    private ListNode head;
    private ListNode expected;

    public ReverseLinkedList(ListNode head, ListNode expected) {
        this.head = head;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {buildList(), buildExpectedList()}
        });

    }

    @Test
    public void testReverseList() throws Exception {
        Assert.assertEquals(expected, reverseList(head));
        //Assert.assertEquals(expected, reverseList2(head));
    }

    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null)
            return head;
        ListNode newHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    public ListNode reverseList2(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while(curr != null) {
            // put next to temp
            ListNode nextTemp = curr.next;
            // reverse
            curr.next = prev;
            // for next step
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }

    public static ListNode buildList() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        return head;
    }

    public static ListNode buildExpectedList() {
        ListNode head = new ListNode(4);
        head.next = new ListNode(3);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(1);
        return head;
    }
}
