class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        // bruteforce will be O(n*k)
        int sum = 0;
        for (int i = 0; i < k; i++)
            sum += arr[i]; // window sum
        int count = 0;
        double avg = (double) sum / (double) k;
        if (avg >= threshold) // if initial window is greater than threshold then increase the count
            count++;
        int n = arr.length;
        for (int i = 1; i <= n - k; i++) {
            sum = sum - arr[i - 1] + arr[i + k - 1];
            if ((double) sum / (double) k >= threshold) // if new window satisfies threshold
                // increase the count
                count++;
        }
        return count;
    }
}