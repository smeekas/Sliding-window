import java.util.HashMap;
import java.util.HashSet;

class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        if (Math.random() > 0.5) {
            return processFirst(nums);
        }
        return processLater(nums);
    }

    int processLater(int[] nums) {

        int i = 0, j = 0, n = nums.length;
        HashSet<Integer> hs = new HashSet<>();
        int sum = 0;
        int max = 0;
        while (i < n && j < n) {
            // since we want distinct element, add we process current window before
            // processing current element, hashSet is enough
            // we will be easily able to detect duplicate element
            while (i < n && j < n && hs.contains(nums[j])) {
                // while condition is true, process left pointer
                hs.remove(nums[i]);
                sum -= nums[i];
                i++;
            }
            // now current window do not have nums[j]
            // hence we can easily add nums[j] to set and to sum
            hs.add(nums[j]);
            sum += nums[j];
            max = Math.max(max, sum);
            j++;
        }
        return max;
    }

    int processFirst(int[] nums) {
        int i = 0, j = 0, n = nums.length;
        HashMap<Integer, Integer> hm = new HashMap<>();
        int sum = 0;
        int max = 0;
        while (i < n && j < n) {
            // since we will process current element before current window, we are not sure
            // if current element already exists in window or not
            // hence, we need map to track frequency
            hm.put(nums[j], hm.getOrDefault(nums[j], 0) + 1);
            sum += nums[j];
            while (i < n && j < n && hm.containsKey(nums[j]) && hm.get(nums[j]) > 1) {
                // if freq of nums[j] get > 1 means we have duplicate element, to process left
                // pointer
                if (hm.containsKey(nums[i])) {
                    if (hm.get(nums[i]) == 1) {
                        hm.remove(nums[i]);
                    } else {
                        hm.put(nums[i], hm.get(nums[i]) - 1);
                    }
                    sum -= nums[i];
                }
                i++;
            }
            max = Math.max(max, sum);
            j++;
        }
        return max;
    }
}