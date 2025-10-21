class Solution {
    public int getCommon(int[] nums1, int[] nums2) {
        // NEW PATTERN
        // DOUBLE SEQUENCE, DOUBLE POINTER

        /**
         * bruteforce two for loops
         * better binary search nlogM
         * best two pointer O(n)
         */
        int n = nums1.length;
        int m = nums2.length;
        int i = 0, j = 0;
        while (i < n && j < m) {
            if (nums1[i] == nums2[j])
                // if we find number then return it
                return nums1[i];
            else if (nums1[i] < nums2[j]) {
                // we want to find min number
                // nums1[i] is smaller.
                // we need to find big number in nums1 so that it can get matched with nums2[j]
                // so increase ith pointer
                i++;
            } else {
                // vice-versa logic of else-if
                j++;
            }
        }
        return -1;
    }
}