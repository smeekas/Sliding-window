import java.util.Arrays;

class Solution {
    public int threeSumClosest(int[] nums, int target) {
        // very similar to 3 sum
        Arrays.sort(nums); // sort first because order do not matter
        int n = nums.length;
        int best = nums[0] + nums[1] + nums[2]; // our best guess

        for (int i = 0; i < n - 2; i++) {
            int l = i + 1;
            int r = n - 1;
            while (l < r) {
                int currSum = nums[i] + nums[l] + nums[r]; // mew sum
                int bestDiff = Math.abs(best - target); // our so far closest sum ( best difference)
                int currDiff = Math.abs(currSum - target); // curr best diff
                if (currDiff < bestDiff) {
                    // if new diff is even smaller (even closer sum)
                    best = currSum;
                    // store new sum
                }

                if (currSum <= target) {
                    // if new sum is smaller, means we need to increase left pointer to increase the
                    // sum
                    l++;
                } else {
                    // if new sum is big, means we need to decrement right pointer to decrease the
                    // sum
                    r--;
                }
            }
        }
        return best;
    }
}
/**
 * -5 -5 -4 0 0 9 9 3 3 4 5
 */