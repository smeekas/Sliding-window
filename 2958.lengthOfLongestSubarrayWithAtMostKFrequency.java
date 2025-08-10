import java.util.HashMap;

class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        int i = 0, j = 0, n = nums.length;
        int ans = 0;
        HashMap<Integer, Integer> hm = new HashMap<>();
        while (i < n && j < n) {
            // process first
            int jth = nums[j];
            hm.put(jth, hm.getOrDefault(jth, 0) + 1);

            while (i < n && hm.containsKey(jth) && hm.get(jth) > k) {
                // if jth element's frequency exceed, move left pointer
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
            ans = Math.max(ans, j - i + 1);
            j++;
        }
        return ans;
    }
}