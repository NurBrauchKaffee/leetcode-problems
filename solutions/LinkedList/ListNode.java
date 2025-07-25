package solutions.LinkedList;

public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int x) {
        val = x;
        next = null;
    }
    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public void show() {
        ListNode show = this;
        System.out.print("[");
        while (true) {
            if (show.next == null) {
                System.out.printf("%d", show.val);
                break;
            }
            System.out.printf("%d, ", show.val);
            show = show.next;
        }
        System.out.println("]");
    }
}
