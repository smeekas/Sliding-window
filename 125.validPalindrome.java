class Solution {
    public boolean isPalindrome(String s) {
        // new pattern
        // two pointers (shrinking window) => 0,n-1
        int i = 0, j = s.length() - 1;
        while (i <= j) {
            char c1 = s.charAt(i);
            char c2 = s.charAt(j);
            if (c1 >= 65 && c1 <= 90) {
                // convert to lowercase
                c1 = (char) (c1 + 32);
            }
            if (c2 >= 65 && c2 <= 90) {
                // convert to lowercase
                c2 = (char) (c2 + 32);
            }
            if (!isValid(c1) || c1 == ' ') {
                // skip char if it is not valid or it is whitespace
                i++;
                continue;
            }
            if (!isValid(c2) || c2 == ' ') {
                // skip char if it is not valid or it is whitespace
                j--;
                continue;
            }
            // if chars are valid and do not match means not palindromic, so return false
            if (c1 != c2)
                return false;
            // else shrink window
            i++;
            j--;

        }

        return true;
    }

    boolean isValid(char c) {
        // c must be alphanumeric
        return (c - '0' >= 0 && c - '0' <= 9) || c >= 97 && c <= 122;
    }
}