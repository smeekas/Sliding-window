class Solution {
    public int[] getAverages(int[] nums, int k) {
        if (k == 0)
            // 0 radius means same array
            return nums;

        long div = 2 * k + 1; // k radius =>2*k diameter + 1 for current element
        long sum = 0;
        int n = nums.length;
        int[] ans = new int[n];

        for (int i = 0; i < k && i < n; i++) {
            ans[i] = -1;
            ans[n - 1 - i] = -1;
            // -1 for first 0 to k-1 element, as there won't be k element on left
            // -1 for last (n-1)-k to n-1 element as there won't be k element on right
        }
        for (int i = 0; i < div - 1 && i < n; i++) {
            // for first window add all element except last one
            // hence i<div-1
            sum += nums[i];
        }

        for (int i = k; i < n - k; i++) {
            // add current window's number
            sum += nums[i + k]; // i+k-1 X => we have k element on right (not including current element)
            // same reason we have i<n-k instead of i<=n-k
            ans[i] = (int) (sum / div);
            // store in ans
            sum = sum - nums[i - k];
            // remove last number of current window
        }
        return ans;

    }
}