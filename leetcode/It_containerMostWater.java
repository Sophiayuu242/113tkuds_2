class Solution {
    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1, maxArea = 0;
        while (left < right) {
            int h = Math.min(height[left], height[right]);
            int area = h * (right - left);
            maxArea = Math.max(maxArea, area);
            if (height[left] < height[right]) left++;
            else right--;
        }
        return maxArea;
    }
}

/*
解題思路：
這題用雙指針，從最左和最右開始。
每次計算當前容器的面積，並更新最大值。
然後移動較矮的一邊，因為只有換掉矮的一邊才可能增加容量。
時間複雜度 O(n)，空間 O(1)。
*/
