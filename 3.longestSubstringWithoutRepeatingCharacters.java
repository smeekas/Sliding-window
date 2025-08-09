import java.util.HashSet;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        // bruteforce, O(n^2) two loops to check all substring
        // variable length sliding window
        /**
         * template
         * 
         * move right pointer,
         * check if window satisfies condition or not
         * if not, move left pointer
         * once condition satisfied, do operation and update ans
         */
        HashSet<Character> hs = new HashSet<>();
        /**
         * check condition.
         * if do not match, keep removing from left (decrease the size of window)
         * once condition matched, we can update our answer
         * 
         */
        int i = 0, j = 0;
        int n = s.length();
        int ans = 0;
        while (j < n) {
            // this while is mainly for j

            while (i < n && j < n && hs.contains(s.charAt(j))) {
                // if condition satisfies means we are at jth char and we already have j in set
                // means we need to update the window.
                // remove char from left, after that we will check again if now new window
                // satisfies our requirement or not (not containing jth char)
                //
                hs.remove(s.charAt(i));
                i++;
            }
            // here means new window now do not have jth char.
            char charJ = s.charAt(j);
            hs.add(charJ); // we will add it
            ans = Math.max(ans, j - i + 1); // update ans
            j++; // move right pointer
        }
        return ans;
    }
}