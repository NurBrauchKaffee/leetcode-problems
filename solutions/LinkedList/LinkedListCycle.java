package solutions.LinkedList;

import java.util.HashSet;

public class LinkedListCycle {
    public static boolean hasCycle(ListNode head) {
        HashSet<ListNode> set = new HashSet<>();
        if (head == null || head.next == null) return false;

        ListNode next = head.next;

        while (!set.contains(next)) {
            set.add(next);
            if (next.next == null) {
                return false;
            } else {
                next = next.next;
            }
        }

        return true;
    }

    private static void showcase(ListNode[] testcases) {
        for (ListNode node : testcases) {
            System.out.printf("has cycle?: %s, string: %s%n", hasCycle(node), node);
        }
    }

    public static void main(String[] args) {
        ListNode[] testcases = {

        };

        showcase(testcases);
    }
}
