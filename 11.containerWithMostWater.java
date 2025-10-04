class Solution {
    public int maxArea(int[] height) {
        // we need to think which two bar can hold most water.
        // assuming middle bars do not exists
        int best = 0;
        int n = height.length;
        int l = 0, r = n - 1;

        while (l <= r) {
            best = Math.max(best, Math.min(height[l], height[r]) * (r - l)); // calc water capacity
            if (height[l] < height[r]) {
                // since lth bar is small, we can move left pointer
                // maybe we will find bigger bar on left side by moving pointer
                l++;
            } else {
                   // since rth bar is small, we can move right pointer
                // maybe we will find bigger bar on right side by moving pointer
                r--;
            }

        }
        return best;
    }
}