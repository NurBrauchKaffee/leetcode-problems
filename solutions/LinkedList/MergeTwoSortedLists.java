package solutions.LinkedList;

import utility.Pair;

import java.util.List;

public class MergeTwoSortedLists {
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }

        if (list2 == null) {
            return list1;
        }

        if (list1.val <= list2.val) {
            return new ListNode(list1.val, mergeTwoLists(list1.next, list2));
        } else {
            return new ListNode(list2.val, mergeTwoLists(list1, list2.next));
        }
    }

    private static void showcase(List<Pair<ListNode, ListNode>> testcases) {
        for (Pair<ListNode, ListNode> lists : testcases) {
            mergeTwoLists(lists.first(), lists.second()).show();
            lists.first().show();
            lists.second().show();
        }
    }

    public static void main(String[] args) {
        List<Pair<ListNode, ListNode>> testcases = List.of(
            new Pair<>(
                    new ListNode(1, new ListNode(2, new ListNode(4))),
                    new ListNode(1, new ListNode(3, new ListNode(4)))
                    )
        );

        showcase(testcases);
    }
}
