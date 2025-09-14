class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        // NEW PATTERN
        // minimum subarray
        int i = 0, j = 0;
        int n = nums.length;
        int ans = 0;
        int pro = 1;
        if (k == 0)
            return 0;
        while (j < n) {
            pro *= nums[j];
            while (i < n && i <= j && pro >= k) {
                // if condition is not getting satisfied, we will contract the subarray size
                pro /= nums[i];
                i++;
            }
            // from i to j ( all subarray ending at j) all are valid subarrays
            // if product of 3 number <=100 then <3 numbers is also <=100
            ans += (j - i + 1);
            j++; // we have processed all subarray ending at j, now increase j(right) pointer
        }
        return ans;
    }
}