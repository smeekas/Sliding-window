import java.util.HashMap;
import java.util.HashSet;

class Solution {
    public int countCompleteSubarrays(int[] nums) {
        HashSet<Integer> all = new HashSet<>();
        for (int i : nums)
            all.add(i);
        int K = all.size(); // total distinct element

        HashMap<Integer, Integer> hm = new HashMap<>();
        int i = 0, j = 0, n = nums.length;
        int ans = 0;
        while (j < n) {
            hm.put(nums[j], hm.getOrDefault(nums[j], 0) + 1);

            while (i < n && hm.size() == K) {
                // while our condition is true, we can count all subarrays
                ans++; // current subarray

                // all subarray starting from i. (j+1 to n)
                // but what if from j+1 to n there is one more unique element?
                // well that cannot happen as entire array have maximum K distinct element
                // so total distinct element cannot go more than K

                ans += (n - (j + 1));
                int ith = nums[i];
                if (hm.containsKey(ith)) {
                    int count = hm.get(ith);
                    if (count == 1)
                        hm.remove(ith);
                    else
                        hm.put(ith, count - 1);
                }
                i++;
            }
            j++;
        }
        return ans;
    }
}