class Solution {
    public int longestOnes(int[] nums, int k) {
        // longest subarray with at most K 0
        int i = 0, j = 0;
        int n = nums.length;
        int count = 0; // 0 count
        int ans = 0;
        // typical variable length sliding window
        while (i < n && j < n) {
            int jth = nums[j];
            if (jth == 0)
                count++;

            while (i < n && count > k) {
                if (nums[i] == 0)
                    count--;
                i++;
            }
            ans = Math.max(ans, j - i + 1);
            j++;
        }
        return ans;
    }
}