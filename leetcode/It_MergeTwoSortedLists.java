/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                current.next = list1;
                list1 = list1.next;
            } else {
                current.next = list2;
                list2 = list2.next;
            }
            current = current.next;
        }

        if (list1 != null) current.next = list1;
        else current.next = list2;

        return dummy.next;
    }
}

/*
解題思路：
1. 建立 dummy 節點簡化頭節點處理。
2. 同時遍歷兩個鏈表，將較小值接到結果鏈表。
3. 若一條鏈表遍歷結束，將另一條剩餘部分接上。
時間複雜度：O(m+n)，空間複雜度：O(1)。
*/
