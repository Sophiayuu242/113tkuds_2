class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }
}

/*
解題思路：
題目要求移除排序陣列中的重複元素，並返回新陣列長度。
我們用雙指針解法：
- i 指向最後一個不重複元素的位置
- j 掃描陣列，如果 nums[j] ≠ nums[i]，就把 nums[j] 複製到下一個位置。
最後返回 i+1 即為新的長度。
時間複雜度 O(n)，空間 O(1)。
*/
