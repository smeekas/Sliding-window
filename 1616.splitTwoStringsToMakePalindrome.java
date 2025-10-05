class Solution {
    public boolean checkPalindromeFormation(String a, String b) {
        // we try to partition in a and in b
        return check(a, b) || check(b, a);
    }

    boolean check(String a, String b) {
        int n = a.length();
        int l = 0, r = n - 1;
        /**
         * ABC|DEF
         * UVW|XYZ
         * 
         * here if ABCXYZ is palindrome, then A-Z B-Y C-X should match
         */
        while (l <= r) {
            char ac = a.charAt(l);
            char bc = b.charAt(r);
            if (ac == bc) {
                // if they match, then we continue our pointers
                l++;
                r--;
            } else {
                // if they do not match
                /**
                 * from 0 to l is palindrome
                 * from r to n-1 is palindrome
                 * since now condition is false we check for l to rs
                 * if in a, l to r is palindrome then a(0 to r= 0 to l + l to r)+ b(r+1 to n-1)
                 * our ans
                 * if in b, l to r is palindrome then a (0 to l-1)+ b(l to n-1= l to r + (r+1)
                 * to n-1) our ans
                 * 
                 * 
                 * ELSE it is not possible to divide the pair
                 */
                if (pali(a, l, r) || pali(b, l, r))
                    return true;
                return false;
            }
        }
        // if loop is over means we constantly were able to move l & r pointer, in short
        // string a & b is palindrome. so if we split in between and merge them, they
        // will remain palindrome
        return true;
    }

    /**
     * check if string is palindrome between l to r or not
     */
    boolean pali(String a, int l, int r) {
        while (l <= r && a.charAt(l) == a.charAt(r)) {
            l++;
            r--;
        }
        return r < l;
    }
}