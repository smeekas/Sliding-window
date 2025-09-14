class Solution {
    public int numberOfSubstrings(String s, int k) {
        int alpha[] = new int[26]; // to count freq of alphabets
        int ans = 0;
        int i = 0, j = 0;
        int n = s.length();
        while (j < n) {
            char jth = s.charAt(j);
            alpha[jth - 'a']++;
            while (i < n && alpha[jth - 'a'] >= k) {
                // since we added jth char, we will count sub-arrays till condition is satisfied
                char ith = s.charAt(i);
                alpha[ith - 'a']--;
                // just like 1358 & 2962
                ans++;
                ans += (n - (j + 1));
                i++;
            }
            j++;
        }
        return ans;
    }
}