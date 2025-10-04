import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> fourSum(int[] arr, int target) {
        // bruteforce-> 4 loops

        // optimal
        Arrays.sort(arr); // have to sort, so that we can use two pointers
        List<List<Integer>> ls = new ArrayList<>();

        int i = 0, j = 1, a, b;
        long mid = 0;
        /**
         * template is from 3 sum
         * this applies to 3 sum, 4 sum, 5 sum...
         * here we use two loops for to find 2 numbers and two pointer to find remaining
         * two numbers
         */
        for (i = 0; i < arr.length - 3; i++) {
            for (j = i + 1; j < arr.length - 2; j++) {
                /**
                 * a+b+c+d=target
                 */
                long actualTarget = (long) target - (long) arr[i] - (long) arr[j];
                a = j + 1;
                b = arr.length - 1;

                while (a < b) { // no <= because we cannot use same element again arr[a]==arr[b]
                    mid = (long) arr[a] + (long) arr[b];
                    if (mid < actualTarget) {
                        // what we found is small,
                        // increase mid by moving left pointer
                        a++;
                    } else if (mid > actualTarget) {
                        // what we found is larger,
                        // decrease mid by moving right pointer
                        b--;
                    } else {
                        // mid===actual target
                        List<Integer> ans = new ArrayList<>();
                        ans.add(arr[i]);
                        ans.add(arr[j]);
                        ans.add(arr[a]);
                        ans.add(arr[b]);
                        ls.add(ans);
                        int temp_a = arr[a];
                        int temp_b = arr[b];

                        // for uniqueness
                        while (a < b && arr[a] == temp_a) // same as 3 sum. skip duplicates
                            a++;
                        while (a < b && arr[b] == temp_b) // same as 3 sum. skip duplicates
                            b--;
                        // we don't use a==a+1 or b==b-1 because we cannot move from current a if we use
                        // a==a+1.
                        // in-case of temp_a 1(a) 2 4. we will move to 1 2(a) 4. which is not possible
                        // with a==a+1 ;)

                        // we cannot use break because we want all quadruplets.
                    }
                }
                while (j + 1 < arr.length - 2 && arr[j + 1] == arr[j])
                    j++; // for uniqueness
                // for 2(curr) 2 2 2 4 we will move to 2 2 2 2(curr) 4. for loop will increment
                // 2 to 4.
            }
            while (i + 1 < arr.length - 3 && arr[i + 1] == arr[i])
                i++; // for uniqueness
        }

        return ls;

    }
}