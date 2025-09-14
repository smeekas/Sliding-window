class Solution {
    public long countSubarrays(int[] nums, int k) {
        int max = 0;
        // find max element
        for (int i : nums)
            max = Math.max(max, i);

        int i = 0, j = 0, count = 0;
        long ans = 0;
        int n = nums.length;
        // now try typical sliding window
        while (j < n) {

            if (nums[j] == max)
                count++;
            while (count >= k) {
                // while condition is true, we can collect count of all subarrays

                ans++; // for current sub-array

                // same as 1358. if current substring is valid then all bigger substrings are
                // valid too
                ans += (long) (n - (j + 1));

                // we have processed subarrays starting from i
                // now move ith pointer and reduce the subarray size
                if (nums[i] == max)
                    count--;
                i++;
            }
            j++;
        }
        return ans;
    }
}