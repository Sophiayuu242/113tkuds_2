class Solution {
    public int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) return mid;
            if (nums[mid] < target) left = mid + 1;
            else right = mid - 1;
        }
        return left;
    }
}

/*
解題思路：
二分搜尋找插入位置：
- 若找到 target，回傳索引。
- 若沒找到，left 會停在應插入的位置。
時間複雜度：O(log n)，空間 O(1)。
*/
