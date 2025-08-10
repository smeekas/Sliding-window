class Solution {
    public int takeCharacters(String s, int k) {

        // find longest subarray with each character's frequency freq[char]-k
        // that is same as min element from left and right with each char's frequency K
        int ans = 0;
        int n = s.length();
        int freq[] = new int[3];
        for (int i = 0; i < n; i++) {
            // count all freq
            freq[s.charAt(i) - 'a']++;
        }
        int i = 0, j = 0;
        if (Math.min(freq[0], Math.min(freq[1], freq[2])) < k)
            // if any char's freq is < K means we cannot have our answer
            return -1;
        int count[] = new int[3]; // to track window's char frequency

        while (i < n && j < n) {
            char jth = s.charAt(j);
            count[jth - 'a']++;
            while (i < n && count[jth - 'a'] > freq[jth - 'a'] - k) {
                // if window is violating the rule, move left pointer appropriately
                int ith = s.charAt(i) - 'a';
                count[ith]--;
                i++;
            }

            ans = Math.max(ans, j - i + 1); // update the window size if necessary
            j++;
        }
        // since we found opposite answer, return n-ans
        return n - ans;
    }
}