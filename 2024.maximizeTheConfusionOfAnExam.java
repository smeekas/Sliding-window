class Solution {
    public int maxConsecutiveAnswers(String answerKey, int k) {
        // we can either maximize consecutive T or F
        // we try both
        return Math.max(find(answerKey, k, 'T'), find(answerKey, k, 'F'));

    }

    int find(String answerKey, int k, char c) {
        // find longest subarray with k {c} characters
        int count = 0;
        int i = 0, j = 0, n = answerKey.length();
        int ans = 0;
        char cs[] = answerKey.toCharArray();

        // below is typical sliding window
        while (i < n && j < n) {
            if (cs[j] == c)
                count++;
            while (i < n && count > k) {
                if (cs[i] == c)
                    count--;
                i++;
            }
            ans = Math.max(ans, j - i + 1);
            j++;
        }
        return ans;
    }
}