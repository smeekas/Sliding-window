class Solution {
    public boolean judgeSquareSum(int c) {
        long l = 0, r = (long) Math.sqrt(c);
        // a2+b2=c;
        // max will be sqrt(c), because sqrt(c)*sqrt(c)=c;
        while (l <= r) {

            long sqrs = (long) l * l + r * r;
            if (sqrs > c) {
                // if ans is more,
                // reduce r, to decrease sqrs
                r--;
            } else if (sqrs < c) {
                // if ans is less,
                // increase l, to increase sqrs
                l++;
            } else {
                // if it matches, return true
                return true;
            }
        }
        return false;
    }
}