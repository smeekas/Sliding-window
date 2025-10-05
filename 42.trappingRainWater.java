class Solution {
    public int trap(int[] height) {
        // brute-force TC:O(n^2) SC:O(1)
        // for every element, we will try to find maximum on left and maximum on right

        return twoPointers(height);

    }

    int twoPointers(int h[]) {

        int n = h.length;
        int lMax = h[0], rMax = h[n - 1];
        int l = 0, r = n - 1;
        int ans = 0;
        /*
         * what we will check is, whether current bar is submerged or not. if yes then
         * how much
         * 
         * from both the sides we will maintain max bar we have seen.
         * if ith bar have seen larger bar on left means ith bar will be definitely
         * submerged.
         * if ith bar is bigger than all on left, then when we update lMax, we count 0
         * water from ith bar
         */
        while (l <= r) {
            lMax = Math.max(lMax, h[l]);
            rMax = Math.max(rMax, h[r]);

            /**
             * from two bar, we take smallest bar as water can reach that level only
             */

            if (lMax <= rMax) {
                // if left max is smaller then we update lth bar
                /**
                 * reason
                 * 
                 * in future we may have bigger bar between l and r
                 * in that case, if in current case if we update r, then it will be wrong answer
                 * in case of bigger bar between l & r, rth ans will depend on which bar is
                 * smaller rMax or this new big bar
                 * 
                 * so if lMax is small, then we should update and consider lth bar for ans and
                 * move l pointer
                 * 
                 * EXACT same logic for else condition
                 */
                ans += lMax - h[l];
                l++;
            } else {
                ans += rMax - h[r];
                r--;
            }
        }
        return ans;
    }
}