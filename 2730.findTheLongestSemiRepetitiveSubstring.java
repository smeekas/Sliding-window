class Solution {
    public int longestSemiRepetitiveSubstring(String s) {

        int i = 0, j = 1, n = s.length();
        if (s.length() <= 2) {
            return s.length(); // <=2 char mean no duplication
        }
        int ans = 0;
        int count = 0;
        char curr = s.charAt(i);
        while (i < n && j < n) {
            char jth = s.charAt(j);
            if (jth == curr) {
                // same character, increase count
                count++;
            }

            while (count > 1) {
                // if count > 1 means multiple pair of 2 chars
                // start removing char from left
                char ith = s.charAt(i);
                char ithOne = s.charAt(i + 1);
                if (ith == ithOne) {
                    // if we find two char same, decrease pair count
                    count--;
                }
                i++; // increase left pointer
                // aaa => two pairs aa and aa
                // hence we move i by 1 only (i++)
            }
            ans = Math.max(ans, j - i + 1);
            j++;
            curr = jth; // new char will be jth
        }
        return ans;
    }
}