class Solution {
    public int minSubArrayLen(int target, int[] nums) {

        // finding the MINIMUM
        int i = 0, j = 0;
        int sum = 0;
        int n = nums.length;
        int ans = Integer.MAX_VALUE;

        while (i < n && j < n) {
            // process first
            sum += nums[j];
            while (sum >= target) {
                // we want min
                // while condition matches we will keep keep contracting our window (minimize)
                // and since condition holds we will keep updating our ans
                ans = Math.min(ans, j - i + 1);
                sum -= nums[i];
                i++;
            }
            j++;
        }
        /**
         * template
         * while(condition matches for correct subarray){
         * update ans
         * contract the window
         * }
         */
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
}