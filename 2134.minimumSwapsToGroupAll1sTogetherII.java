class Solution {
    public int minSwaps(int[] nums) {

        int n = nums.length;
        int[] arr = new int[n * 2]; // to handle circular array
        for (int i = 0; i < n; i++) {
            arr[i] = nums[i];
            arr[i + n] = nums[i];
        }
        int ones = 0; // we want to group all 1s. so window size will be same as number of 1s.
        for (int i : nums)
            if (i == 1)
                ones++;

        // now our answer will be minimum zeros in any window
        int zero = 0;
        for (int i = 0; i < ones; i++) {
            if (arr[i] == 0)
                zero++;
        }
        int min = zero;
        int len = n * 2;
        for (int i = 1; i <= len - ones; i++) {
            if (arr[i + ones - 1] == 0)
                zero++;
            if (arr[i - 1] == 0)
                zero--;
            min = Math.min(zero, min);
        }

        return min;
    }
}
/**
 * n=5
 * 0 1 2 3 4 5 6 7 8 9
 * 1,1,0,0,1,1,1,0,0,1
 */