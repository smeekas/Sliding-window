class Solution {
    public int[] sortArrayByParity(int[] nums) {
        return clean(nums);
    }

    // VERY much similar to 283: move zeroes
    int[] clean(int[] nums) {
        int i = 0, j = 0, n = nums.length;
        while (j < n) {
            if (nums[j] % 2 == 1) {
                // skip all zeros and copy non-zero values
            } else {
                // if value is non-zero
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i++;
            }
            j++;
        }
        return nums;

    }
}