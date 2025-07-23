class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int n = customers.length;

        int ans = 0;
        /**
         * owner can remain non-grumpy for {minutes} minutes
         * we can find biggest block where owner is grumpy(1)
         * but that approach will not work as we need to maximize customer satisfaction,
         * not the window
         * 
         * we can create combined array, where we have satisfaction rate of customer
         * where owner was grumpy
         * then we can maximize satisfaction in that window
         */

        int combined[] = new int[n];
        for (int i = 0; i < n; i++)
            combined[i] = grumpy[i] * customers[i];
        // 1 => actual satisfaction where owner was grumpy
        // 0 => 0

        for (int i = 0; i < minutes; i++) {
            ans += combined[i];
            // for initial window

        }
        int maxAns = ans;
        for (int i = 1; i <= n - minutes; i++) {

            ans -= combined[i - 1];
            ans += combined[i + minutes - 1];
            // sliding window to find maximum satisfaction where owner is grumpy
            if (ans >= maxAns) {
                maxAns = ans;
            }

        }
        int count = maxAns;
        // final answer includes usage of minutes window, to get all satisfied
        // customer(maxAns)

        // + other customer satisfaction rate where owner was not-grumpy
        for (int i = 0; i < n; i++) {
            if (combined[i] == 0) {
                // satisfaction rate of customer where owner was not-grumpy
                count += customers[i];
            }
        }
        return count;
    }
}