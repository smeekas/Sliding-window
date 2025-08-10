import java.util.HashMap;

class Solution {
    public int totalFruit(int[] fruits) {
        // max subarray with two different fruits kind of fruits
        int i = 0, j = 0, n = fruits.length;
        int ans = 0;
        HashMap<Integer, Integer> hm = new HashMap<>(); // map to count, detect distinct fruits
        while (i < n && j < n) {
            // here we are processing early
            int jth = fruits[j];
            hm.put(jth, hm.getOrDefault(jth, 0) + 1);
            while (hm.size() > 2) {
                // after processing, we check given condition
                // here if map size > 2, means we need to remove fruits from left pointer, we
                // are allowing max 2 kind of fruits
                int ith = fruits[i];
                if (hm.containsKey(ith)) {
                    int count = hm.get(ith);
                    if (count == 1) {
                        hm.remove(ith);
                    } else {
                        hm.put(ith, hm.getOrDefault(ith, 0) - 1);
                    }
                }

                i++;
            }
            // after condition check, update ans based on current window if required
            ans = Math.max(ans, j - i + 1);
            j++;
        }
        return ans;
    }
}