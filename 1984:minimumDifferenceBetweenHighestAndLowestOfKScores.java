class Solution {
    public int minimumDifference(int[] nums, int k) {
        Arrays.sort(nums);
        int low = nums[0];
        int high = nums[k - 1];
        int n = nums.length;
        int min = high - low; // current window's diff
        for (int i = 1; i <= n - k; i++) {
            // new window's difference, update min if required
            min = Math.min(min, nums[i + k - 1] - nums[i]);
        }
        return min;
    }
}