class Solution {
    public int longestSubarray(int[] nums) {

        /**
         * slight different approach in template
         * in loop, first we do what we should be doing
         * after that we have while loop to increase left pointer
         */

        /**
         * Idea is to find longest subarray with maximum one 0.
         */
        int i = 0, j = 0, count = 0;
        int n = nums.length;
        int ans = 0;
        while (i < n && j < n) {
            if (nums[j] == 0)
                count++;

            while (count > 1) {
                // if 0s are more then 1, then we start checking left pointer
                if (nums[i] == 0) {
                    count--;
                }
                i++;
            }
            ans = Math.max(ans, j - i + 1);
            j++;
        }
        return ans - 1;
    }
}