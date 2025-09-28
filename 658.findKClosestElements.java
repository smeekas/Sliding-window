import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        return twoPointers(arr, k, x);

    }

    List<Integer> twoPointers(int[] arr, int k, int x) {
        int l = 0, r = arr.length - 1;
        while (r - l >= k) {
            // we want total k elements
            if (Math.abs(arr[l] - x) <= Math.abs(arr[r] - x)) {
                // if rth number's difference is higher than lth number's difference,
                // we move reduce size from rth side, as we want element to be closes to x
                r--;
            } else {
                l++;
            }
        }
        ArrayList<Integer> ans = new ArrayList<>();
        // once done, we iterate from l to r (total K element) and add them in ans
        for (int i = l; i <= r; i++)
            ans.add(arr[i]);
        return ans;
    }

}
