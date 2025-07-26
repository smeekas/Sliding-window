class Solution {
    public boolean checkInclusion(String s1, String s2) {

        // well.........
        /**
         * we can check if s1's anagram is present in the s2 or not
         */
        int k = s1.length();
        int n = s2.length();
        int freq1[] = new int[26];
        int freq2[] = new int[26];

        if (k > n)
            // if s1's length is > s2's length then s1 cannot be substring of s2
            return false;
        for (int i = 0; i < k; i++) {
            freq2[s2.charAt(i) - 'a']++;
            freq1[s1.charAt(i) - 'a']++;
        }
        // if for the first window, s1 is part of s2 return true
        if (areEqual(freq1, freq2))
            return true;

        for (int i = 1; i <= n - k; i++) {
            char prevChar = s2.charAt(i - 1);
            char nextChar = s2.charAt(i + k - 1);
            freq2[prevChar - 'a']--;
            freq2[nextChar - 'a']++;
            // for every window, if s1 become part of s2 (all char in s1 are in s2's current
            // window), we can return true
            if (areEqual(freq1, freq2))
                return true;
        }
        return false;
    }

    boolean areEqual(int[] f1, int[] f2) {
        for (int i = 0; i < f1.length; i++) {
            if (f1[i] != f2[i])
                return false;
        }
        return true;
    }
}