import java.util.Arrays;

class Solution {
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int count = 0;
        int n = nums.length;
        /**
         * valid triangle if we add length of any two side it will be greater than 3rd
         * side.
         */
        /**
         * think Greedy
         * we take largest side (right most)
         * and we try to find two side from left and sum then to see if it is greater
         * than right-most (currently selected side)
         * 
         * if we find such i & j index, then i+1,i+2,i+3....(j-1) all combined with j
         * will sum greater than right most. (SINCE ARRAY WILL BE SORTED)
         * that means we have (j-i) pairs (total j-i+1 numbers & j-i pairs)
         * 
         */
        for (int i = n - 1; i >= 0; i--) {
            int l = 0;
            int r = i - 1;
            while (l < r) {
                if (nums[l] + nums[r] > nums[i]) {
                    count += (r - l);
                    r--;
                } else {
                    l++;
                }
            }
        }
        return count;
    }
}