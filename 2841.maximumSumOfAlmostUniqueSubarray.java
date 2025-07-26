import java.util.HashMap;
import java.util.List;

class Solution {
    public long maxSum(List<Integer> nums, int m, int k) {

        // bruteforce O(n*k)
        HashMap<Long, Long> hm = new HashMap<>();
        long sum = 0;
        int n = nums.size();

        for (int i = 0; i < k; i++) {
            long num = nums.get(i);
            hm.put(num, hm.getOrDefault(num, 0l) + 1);
            sum += num;
            // sum and freq count in initial window
        }

        long maxSum = 0;
        if (hm.size() >= m) {
            maxSum = sum;
            // if initial window matches the criteria, take is as maximum sum
        }

        for (int i = 1; i <= n - k; i++) {
            long prev = nums.get(i - 1);
            long next = nums.get(i + k - 1);
            sum -= prev;
            sum += next;

            if (hm.containsKey(prev)) {
                if (hm.get(prev) > 1) {
                    // > 1 freq, decrease the freq
                    hm.put(prev, hm.get(prev) - 1);
                } else {
                    // freq=1 ? remove it
                    hm.remove(prev);
                }
            }

            hm.put(next, (long) hm.getOrDefault(next, 0l) + 1); // add new value in current window
            if (hm.size() >= m) {
                // if current window matches the criteria, take max sum
                maxSum = Math.max(maxSum, sum);
            }
        }
        return maxSum;
    }
}