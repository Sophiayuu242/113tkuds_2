class Solution {
    public int removeElement(int[] nums, int val) {
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[k] = nums[i];
                k++;
            }
        }
        return k;
    }
}

/*
解題思路：
題目要求移除陣列中等於 val 的元素，並返回剩餘長度。
用雙指針：
- i 掃描陣列
- k 指向結果陣列的下一個位置
當 nums[i] ≠ val 時，將 nums[i] 放到 nums[k]，再增加 k。
最後 k 即為新長度。
時間複雜度 O(n)，空間 O(1)。
*/
