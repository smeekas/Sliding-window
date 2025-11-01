class Solution {
    public int maxDistance(int[] nums1, int[] nums2) {
        return twoPointer(nums1, nums2);
    }

    int twoPointer(int[] n1, int[] n2) {
        int best = 0;
        int n = n1.length;
        int m = n2.length;
        // both arrays are in decreasing order
        // we will follow standard template
        // run inner while till condition is true to maximize the result
        int i = 0, j = 0;
        while (i < n) {
            while (j < m && n1[i] <= n2[j]) {
                /*
                 * why no condition like i<=j as stated in the question?
                 * i may go beyond j
                 * this will stop us from finding best answer
                 * so w
                 * *
                 * this brings TLE for some reason
                 * 
                 * well even if i goes beyond j,
                 * 
                 * at some point in our current condition, when n1[i] < n2[j], (ith value
                 * decreased as it kept going), j will keep increasing and it may go beyond i to
                 * give us some result
                 */
                j++;
            }
            best = Math.max(best, j - i - 1);
            i++;
        }

        return best;
    }

}