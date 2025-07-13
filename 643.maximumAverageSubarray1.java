class Solution {
    public double findMaxAverage(int[] nums, int k) {
        // bruteforce will be O(n*k)
        int sum = 0; // window sum 0 to k-1
        for (int i = 0; i < k; i++)
            sum += nums[i];
        int n = nums.length;

        double max = (double) sum / (double) k; // avg of current window
        for (int i = 1; i <= n - k; i++) {
            sum = sum - nums[i - 1] + nums[i + k - 1];
            // add number of new current window and remove number of prev window
            max = Math.max(max, (double) sum / (double) k); // track max avg
        }
        return max;

    }
}