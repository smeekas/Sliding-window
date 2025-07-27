class Solution {
    public int minFlips(String s) {

        /**
         * for type-1 we can do circular array
         * only two possibility exists for alternating sequences
         * 0101010... OR 1010101...
         * we can compare our string with both the sequence and take minimum non-matches
         * those non-matches we can flip
         * 
         * we can either generate this both alternating sequence(gen function) or
         * calculate number on the fly
         * 
         * if we choose to generate sequence, should we generate for s.length() or
         * s.length()*2 ?
         * we need to generate for s.lenth()*2
         * reason being taking modulo index will not work as last element can be same as
         * first one(that depend of where our sequence ends for size of s.length() )
         * 
         * simplest and efficient way will be to generate number when needed
         */
        int odds = getAns(s, true); // flip to make it same as 01010101
        int evens = getAns(s, false); // flops to make it same as 10101010
        return Math.min(odds, evens);
    }

    int getAns(String s, boolean odd) {
        int k = s.length();
        int n = 2 * k;
        int nonMatches = 0;
        for (int i = 0; i < k; i++) {
            int num = s.charAt(i) - '0';
            if (num != getAltNum(i, odd))// if number do not match the sequence increase the count of nonMatches
                nonMatches++;
        }
        int min = nonMatches;
        for (int i = 1; i <= n - k; i++) {
            int pIndex = (i - 1) % k;
            int nIndex = (i + k - 1) % k;
            int prevNum = s.charAt(pIndex) - '0';
            int nextNum = s.charAt(nIndex) - '0';
            int prevAltNum = getAltNum(i - 1, odd); // for sequence we cannot use % as discussed above
            int nextAltNum = getAltNum(i + k - 1, odd);

            if (prevNum != prevAltNum) {
                // process number of previous window
                // if it is not same then decrease the nonMatches
                nonMatches--;
            }

            if (nextNum != nextAltNum) {
                // process the number of current window
                nonMatches++;
            }
            // keep taking min across all the window
            // remember we do sliding window to use type-1 operation (and it is free)
            min = Math.min(min, nonMatches);
        }
        return min;
    }

    /**
     * to generate alternating numbers of given size
     */
    int[] gen(int size, boolean odd) {
        int[] c = new int[size];
        for (int i = 0; i < size; i++) {
            if (odd) {
                c[i] = i % 2 == 1 ? 1 : 0;
            } else {
                c[i] = i % 2 == 0 ? 1 : 0;
            }
        }
        return c;
    }

    int getAltNum(int i, boolean odd) {
        if (odd) {
            // if odd is true means 1 should be at odd indexes
            return i % 2 == 1 ? 1 : 0;
        } else {
            // if odd is false means 1 should be at even indexes
            return i % 2 == 0 ? 1 : 0;
        }
    }
}