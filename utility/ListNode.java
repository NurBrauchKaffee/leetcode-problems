package utility;

public class ListNode {
    public int val;
    public ListNode next;
    public ListNode() {}
    public ListNode(int x) {
        val = x;
        next = null;
    }
    public ListNode(int val, ListNode next) {
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
