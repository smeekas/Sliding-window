class Solution {
    public int[] getSubarrayBeauty(int[] nums, int k, int x) {
        int n = nums.length;
        int ans[] = new int[n - k + 1];
        int freq[] = new int[51]; // to store -1 to -50
        int negC = 0; // negative number count

        // we only want xth negative number
        // if numbers are < x then we will put 0
        for (int i = 0; i < k; i++) {
            if (nums[i] < 0) {
                // if number is -ve count freq
                freq[-nums[i]]++;
                negC++; // negative number count
            }
        }
        // if -ve count < x then put 0 else put xth smallest negative
        ans[0] = negC < x ? 0 : getXth(freq, x);
        for (int i = 1; i <= n - k; i++) {
            int prevNum = nums[i - 1];
            if (prevNum < 0) {
                freq[-prevNum]--;
                negC--;
            }
            int nextNum = nums[i + k - 1];
            if (nextNum < 0) {
                freq[-nextNum]++;
                negC++;
            }
            ans[i] = negC < x ? 0 : getXth(freq, x);
        }
        return ans;
    }

    int getXth(int arr[], int x) {
        int i = arr.length - 1;
        while (i >= 1) {
            // we want xth smallest,
            // subtract freq of every number from lower to higher, since we want smallest
            // if x become <0 means that number is xth smallest (number will have
            // duplicates, so once x<=0 we have our number)
            x -= arr[i];
            if (x <= 0) {
                // return negative number
                return -i;
            }
            i--;
        }
        return 0;
    }
}
