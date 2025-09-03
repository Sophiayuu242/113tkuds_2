class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // dummy 幫助處理刪除頭節點的情況
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        // fast 從 head 開始，slow 從 dummy 開始
        ListNode fast = head;
        ListNode slow = dummy;

        // 先把 fast 向前推 n 步（保證 fast 與 slow 差 n 個節點）
        for (int i = 0; i < n; i++) {
            if (fast != null) fast = fast.next;
            else return head; // 合法輸入下不會發生，這裡作保險處理
        }

        // 同時移動直到 fast 到尾端（null）
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        // slow.next 是要刪除的節點
        slow.next = slow.next.next;

        return dummy.next;
    }
}

/*
解題思路與重點：
1. 使用 dummy 節點處理刪除頭節點的情況（例如刪除第 n = length 的節點）。
2. 讓 fast 指標先走 n 步（從 head 開始），slow 從 dummy 開始，兩者保持距離 n。
3. 同時移動 fast 與 slow，當 fast 到達 null 時，slow 停在要刪除節點的前一個節點。
4. 透過 slow.next = slow.next.next 刪除節點。
時間複雜度：O(L)，空間複雜度：O(1)。
*/
