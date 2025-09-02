import java.util.HashMap;

class Solution {
    public int romanToInt(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('I', 1); map.put('V', 5); map.put('X', 10);
        map.put('L', 50); map.put('C', 100); map.put('D', 500); map.put('M', 1000);

        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            int val = map.get(s.charAt(i));
            if (i < s.length() - 1 && val < map.get(s.charAt(i + 1))) {
                sum -= val; // 特殊情況：IV = 4, IX = 9 等
            } else {
                sum += val;
            }
        }
        return sum;
    }
}

/*
解題思路：
把字串逐一轉換成數字。
若當前值 < 下一個值，代表是特殊情況 (IV, IX, XL, XC, CD, CM)，要減去。
否則就加上。
*/
