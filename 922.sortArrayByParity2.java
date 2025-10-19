class Solution {
    public int[] sortArrayByParityII(int[] nums) {
        int slow = 0, fast = 1;
        int n = nums.length;
        // slow even, fast odd
        while (slow < n && fast < n) {
            if (nums[slow] % 2 == 0)
                // if even number on even index, go to next even index
                slow += 2;
            else if (nums[fast] % 2 == 1)
                // if odd number on odd index, go to next odd index
                fast += 2;
            else {
                // if neither above it true, means we can swap so that we can satisfy our
                // condition
                int temp = nums[slow];
                nums[slow] = nums[fast];
                nums[fast] = temp;
            }
        }
        return nums;
    }
}