import java.util.Arrays;

class Solution {
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        // refer BINARY SEARCH sol as well in repo
        // to understand core logic
        int i = 0, j = 0, ans = 0;
        long sum = 0;
        while (j < n) {
            sum += nums[j]; // add curr num to sum
            // this sum variable is dynamic prefix sum kind of a thing
            while (i < n && sum + k < ((j - i + 1) * (long) nums[j])) {
                // if for current window, k addition is not sufficient, decrease the size of
                // window from left
                int ith = nums[i];
                sum -= ith;
                i++;

            }
            // outside loop means condition satisfied and loop broke
            int size = j - i + 1;
            // update the ans if applicable
            ans = Math.max(ans, size);
            j++;
        }
        return ans;
    }
}