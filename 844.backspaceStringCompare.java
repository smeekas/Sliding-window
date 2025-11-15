class Solution {
    public boolean backspaceCompare(String s, String t) {
        int n = s.length();
        int m = t.length();
        int i = n - 1, j = m - 1;
        // we start from back it will be easy as be can skip char if we find #
        while (i >= 0 || j >= 0) { // go till both of them not finishes
            // loop even if one is over
            int sc = 0, tc = 0;
            while (i >= 0) {
                if (s.charAt(i) == '#') {
                    // if we have #, increase count, move to prev char
                    sc++;
                    i--;
                } else if (sc > 0) {
                    // if we do not have #, but hashCount >0 then decrease count, and move to prev
                    // char
                    sc--;
                    i--;
                } else {
                    break;
                }
            }
            // same logic for second string
            while (j >= 0) {
                if (t.charAt(j) == '#') {
                    tc++;
                    j--;
                } else if (tc > 0) {
                    tc--;
                    j--;
                } else {
                    break;
                }
            }

            if (i >= 0 && j >= 0 && s.charAt(i) != t.charAt(j)) // if both string are not ended, and char do not match
                                                                // then they will never match
                                                                // return false
                return false;
            if ((i < 0 && j >= 0) || (i >= 0 && j < 0))
                // if one string is over and other still have char, they will never match,
                // return false
                return false;
            // decrease both pointer
            i--;
            j--;

        }
        // return true if both string are ended <0 
        return i < 0 && j < 0;
    }
}