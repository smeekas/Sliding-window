import java.util.HashMap;

class Solution {
    public long maximumSubarraySum(int[] nums, int k) {

        // Bruteforce O(n*k)
        int n = nums.length;
        long sum = 0;
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i < k; i++) {
            // put all element in map with their frequency to identify uniqueness
            hm.put(nums[i], hm.getOrDefault(nums[i], 0) + 1);
            sum += nums[i]; // take sum of current window
        }

        long maxSum = 0;
        if (hm.size() == k) {
            // if all characters are unique means size if k means we have possible answer
            maxSum = sum;
        }
        for (int i = 1; i <= n - k; i++) {
            int prev = nums[i - 1];
            int next = nums[i + k - 1];
            if (hm.containsKey(prev)) {
                // if prev element exists and size is 1, then remove it or else decrease the
                // frequency
                int size = hm.get(prev);
                if (size == 1)
                    hm.remove(prev);
                else
                    hm.put(prev, size - 1);
            }
            // put next element
            hm.put(next, hm.getOrDefault(next, 0) + 1);
            sum -= prev;
            sum += next;
            if (hm.size() == k) {
                // if in window all element are unique means, map size is K then update answer
                // if applicable
                maxSum = Math.max(maxSum, sum);
            }
        }
        return maxSum;
    }
}