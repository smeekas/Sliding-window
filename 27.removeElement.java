class Solution {
    public int removeElement(int[] nums, int val) {
        return clean(nums, val);
    }

    int clean(int[] nums, int val) {
        int n = nums.length;
        int l = 0, r = n - 1;
        // NEW PATTERN
        // in-place modification
        // l------r
        // [3,2,2,3]
        while (l <= r) {
            // till both pointer do not cross each other...
            if (nums[l] == val) {
                // if value is which we need to remove, replace will value on right (since right
                // part is useless to us)
                // decrement r point as no nums[r] contain value which we do not want
                // nums[l] still can be val. so we will not move l pointer
                nums[l] = nums[r];
                r--;
            } else {
                // l point is safe, we can move forward
                l++;
            }

        }
        // after while loop is over, l is a limit, means 0 to l-1 contains non-val
        // values. so we return l
        return l;
    }
}