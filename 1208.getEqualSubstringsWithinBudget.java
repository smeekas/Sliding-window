class Solution {
    public int equalSubstring(String s, String t, int maxCost) {
        int i = 0, j = 0, n = s.length();
        int ans = 0;
        int cost = 0;
        while (i < n && j < n) {
            // process, current element and do operation
            char a = s.charAt(j);
            char b = t.charAt(j);
            int c = Math.abs(a - b);
            cost += c;
            while (cost > maxCost) {
                // if condition do not satisfies, remove from left pointer
                char ai = s.charAt(i);
                char bi = t.charAt(i);
                cost -= Math.abs(ai - bi);
                i++;
            }
            // update ans
            ans = Math.max(ans, j - i + 1);
            j++;
        }
        return ans;
    }
}