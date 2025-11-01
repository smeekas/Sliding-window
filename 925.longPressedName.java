class Solution {
    public boolean isLongPressedName(String name, String typed) {
        int n = name.length();
        int m = typed.length();

        int i = 0, j = 0;
        while (i < n && j < m) {
            char ith = name.charAt(i);
            char jth = typed.charAt(j);
            // if we find any other char means we have mismatch of chars
            if (ith != jth)
                return false;
            int ic = 0;
            int jc = 0;
            // what we do now is we skips all duplicate in both strings
            while (i < n && name.charAt(i) == ith) {
                i++;
                ic++;
            }
            while (j < m && typed.charAt(j) == jth) {
                j++;
                jc++;
            }
                // duplicate in name > duplicate in typed
                // for ex. abbc in name & abbbc in typed
                // b=> bb & b=>b
                // so ic must be > jc
            if (ic > jc)
                return false;
        }
        // after loop is over, both pointer must be at end else we conclude that either of string have extra characters
        return j == m && i == n;
    }
}