class Solution {
    public int removeDuplicates(int[] nums) {
        return clean(nums);
    }

    int clean(int[] nums) {
        int slow = 0, fast = 0, n = nums.length;
        // -i---j
        // [1,1,2,2,3]
        while (fast < n) {
            if (nums[slow] == nums[fast]) {
                // it means from slow to fast we have same numbers
                // better to skip all of them. (slow & fast can be at same position too)
                // hence fast pointer keep moving
            } else {
                // slow and fast are not same
                // we assume slow and fast-1 were same
                // will keep nums[slow].
                // increment slow ptr, and copy new value nums[fast] to nums[slow+1]
                // again fast will keep moving
                slow++;
                nums[slow] = nums[fast];
            }
            fast++;
        }
        // from 0 to slow we have our answer
        return slow + 1;
    }
}