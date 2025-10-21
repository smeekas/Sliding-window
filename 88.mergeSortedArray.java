class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1, j = n - 1;
        int k = m + n - 1;
        // since we need to modify nums1, what we can do is we can start comparison from
        // back of m & n and start filling nums1 from end of nums1
        while (i >= 0 && j >= 0) {
            if (nums1[i] <= nums2[j]) {
                nums1[k] = nums2[j];
                k--;
                j--;
            } else {
                nums1[k] = nums1[i];
                k--;
                i--;
            }
        }

        // copying remaining elements
        // although it is fine if we do not do for nums1 as they will be there by-default
        while (i >= 0) {
            nums1[k] = nums1[i];
            k--;
            i--;
        }
        while (j >= 0) {
            nums1[k] = nums2[j];
            k--;
            j--;
        }
    }
}