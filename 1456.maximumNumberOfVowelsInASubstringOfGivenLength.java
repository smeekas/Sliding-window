class Solution {
    public int maxVowels(String s, int k) {
        /**
         * bruteforce will be of N*k loop
         */
        int vowelCount = 0;
        for (int i = 0; i < k; i++) {
            // 0 to k-1 => k lengthed window
            char c = s.charAt(i);
            if (isVowel(c))
                vowelCount++;
        }
        int n = s.length();
        int ans = vowelCount;
        // 0 to k-1 is already considered.
        // so we start from 1

        /**
         * 0 1 2 3 4 5 6 7 8 9 => n=10
         * k=3
         * go till 10-3 => 7
         * we consider window 7 8 9 => (i+k)=10-1 (we have count 7 as well so subtract
         * 1)
         */
        for (int i = 1; i <= n - k; i++) {
            if (isVowel(s.charAt(i + k - 1))) {
                // add new count for current window
                vowelCount++;
            }
            if (isVowel(s.charAt(i - 1)))
                // remove count for previous window
                vowelCount--;

            // for every window take the max count
            ans = Math.max(ans, vowelCount);
        }

        return ans;
    }

    boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}