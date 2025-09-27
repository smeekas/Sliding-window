class Solution {
    public int minimumLength(String s) {

        int i = 0, j = s.length() - 1;
        while (i <= j) {

            // if i & j are both at same index means there is nothing to delete anymore
            // so return 1
            if (i == j)
                return 1;
            if (s.charAt(i) == s.charAt(j)) {
                // if characters are same, then we take entire string from left and right
                int newI = i + 1;
                int newJ = j - 1;
                while (newI <= j && s.charAt(i) == s.charAt(newI))
                    newI++;
                while (newI <= newJ && s.charAt(j) == s.charAt(newJ))
                    newJ--;
                // our new i & j
                i = newI;
                j = newJ;

            } else {
                // if character are not same then from string from i to j is our answer, (j-i+1)
                return j - i + 1;
            }
        }
        return 0;
    }

}