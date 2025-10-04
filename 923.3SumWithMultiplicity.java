import java.util.Arrays;

class Solution {
    public int threeSumMulti(int[] arr, int target) {
        Arrays.sort(arr);
        long count = 0;
        int n = arr.length;
        long MOD = (long) 1e9 + 7;
        // very similar to 3 sum
        // that required unique sol
        // here we need to count all possible sol
        for (int i = 0; i < n; i++) {

            int curr = arr[i];
            int tar = target - curr;
            int l = i + 1, r = n - 1;

            while (l < r) {
                int sum = arr[l] + arr[r];
                // below logic is similar to 1577
                if (sum == tar) {
                    if (arr[l] == arr[r]) {
                        long len = r - l + 1;
                        count += (len * (len - 1)) / 2;
                        count = count % MOD;
                        break;
                    } else {
                        int lIs = arr[l];
                        int rIs = arr[r];

                        int lCount = 1;
                        int rCount = 1;

                        while (l + 1 < r && arr[l + 1] == lIs) {
                            lCount++;
                            l++;
                        }
                        while (l < r - 1 && arr[r - 1] == rIs) {
                            rCount++;
                            r--;
                        }
                        count += (lCount * rCount);
                        r--;
                    }
                } else if (sum < tar) {
                    l++;
                } else {
                    r--;
                }
                count = count % MOD;
            }
        }
        return (int) count;
    }
}