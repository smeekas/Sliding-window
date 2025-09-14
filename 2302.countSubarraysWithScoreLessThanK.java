class Solution {
    public long countSubarrays(int[] nums, long k) {
        // same as 713 minimum subarray
        int i = 0, j = 0, n = nums.length;
        long ans = 0;
        long sum = 0;
        long score = 0;
        while (j < n) {
            sum += nums[j];
            score = sum * (j - i + 1);
            while (i <= j && score >= k) {
                // if condition is failing we will contract the subarray
                sum -= nums[i];
                i++;
                score = sum * (j - i + 1);
            }
            // outside of loop means we contracted the subarray as much as were able to
            // now if subarray i to j is valid then all subarray from i,i+1,i+3 ending at j
            // are also valid
            // so we add j-i+1
            ans += (j - i + 1);
            // increase jth pointer
            j++;
        }
        return ans;
    }
}