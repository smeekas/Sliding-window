class Solution {
    public void moveZeroes(int[] nums) {
        clean(nums);
    }

    void clean(int[] nums) {

        int i = 0, j = 0, n = nums.length;
        while (j < n) {
            if (nums[j] == 0) {
                // skip all zeros and copy non-zero values
                // j will keep increasing
            } else {
                // if value is non-zero
                // swap values
                // [1,0,0,13]
                // when j is at 13, i will be...
                // ---i----j
                // [1,0,0,13]
                // i & j can be at same index as well
                // -ij-------
                // [1,0,0,12]
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i++;
            }
            j++;
        }
    }
}