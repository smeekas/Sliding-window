class Solution {
    public int maxScore(int[] cardPoints, int k) {

        int n = cardPoints.length;
        int sum = 0;

        for (int i = 0; i < k; i++) {
            // assume that all points are taken from front
            sum += cardPoints[i];
        }
        int max = sum;
        int j = n - 1;
        // now start from back
        for (int i = k - 1; i >= 0; i--) {
            // remove from front and add from back
            sum -= cardPoints[i]; // remove from front
            sum += cardPoints[j]; //add from back
            j--;
            max = Math.max(max, sum); // take max
        }
        return max;

    }
}