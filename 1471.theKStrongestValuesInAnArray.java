import java.util.Arrays;

class Solution {
    public int[] getStrongest(int[] arr, int k) {
        // we need median element as per the definition
        Arrays.sort(arr);
        int median = 0;
        int n = arr.length;
        if (arr.length % 2 == 0) {
            median = (arr[n / 2 - 1]);
        } else {
            median = arr[n / 2];
        }

        int i = 0, j = n - 1;
        int ans[] = new int[k]; // to store ans
        int in = 0;
        while (in < k && i < n && j >= 0) {
            // we need exact K element so in<K
            // i & j conditions are for safety purpose
            if (Math.abs(arr[i] - median) <= Math.abs(arr[j] - median)) {
                // if jth element is strongest, we will add it in ans
                ans[in++] = arr[j];
                j--;
            } else {
                // if ith element is strongest, we will add it in ans
                ans[in++] = arr[i];
                i++;
            }
            // this question is very much similar to 658. find K closest elements
            // but in that question, we needed continuous elements. here we need K
            // strongest, so while shrinking an array we need to collect answers
            // in 658, element where closer to element
            // in this question element will be on outer side of array
        }

        return ans;
    }
}