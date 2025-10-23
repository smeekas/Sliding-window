class Solution {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int[][] ans = new int[n + m][2]; // max size can be n+m.
        int i = 0, j = 0;
        int k = 0;
        while (i < n && j < m) {
            if (nums1[i][0] == nums2[j][0]) {
                // if id matches, copy ids and sum the number
                ans[k][0] = nums1[i][0];
                ans[k][1] = nums1[i][1] + nums2[j][1];
                i++;
                j++;
                // inc both pointer as we have processed this two numbers
            } else if (nums1[i][0] < nums2[j][0]) {
                // if jth number is large, we will save ith id,number and increase ith pointer
                // since we want final ans in ascending order as well
                ans[k] = nums1[i];
                i++;
            } else {
                ans[k] = nums2[j];
                j++;
            }
            // for all cases, k pointer of ans will increase
            k++;
        }

        // copy remaining elements from both the arrays
        while (i < n) {
            ans[k++] = nums1[i++];
        }
        while (j < m) {
            ans[k++] = nums2[j++];
        }
        // final ans will be of size-K
        // so copy only first K elements
        int[][] finalAns = new int[k][2];
        for (int l = 0; l < k; l++) {
            finalAns[l] = ans[l];
        }
        return finalAns;
    }
}