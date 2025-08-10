class Solution {
    public int minOperations(int[] nums, int x) {

        long total = 0;
        for (int i : nums)
            total += i;
        long res = total - x; // find a longest subarray with this sum
        // longest subarray with {res} => rest numbers==x in min operation
        int i = 0, j = 0, n = nums.length;
        int ans = -1;
        long sum = 0;
        // below is typical variable length sliding window
        while (i < n && j < n) {
            sum += nums[j];
            while (i < n && sum > res) {
                sum -= nums[i];
                i++;
            }
            if (sum == res) {
                ans = Math.max(ans, j - i + 1);
            }
            j++;
        }
        // if we cannot find subarray with {res} sum, means we do not have enough
        // operation/numbers to make it same as {x}. return -1
        // if we have longest subarray with {res} sum, rest elements are {n-ans}.
        return ans == -1 ? -1 : n - ans;
    }
}