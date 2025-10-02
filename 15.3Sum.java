import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums.length == 3) {
            // edge case
            if (nums[0] + nums[1] + nums[2] == 0) {
                List<Integer> dummy = new ArrayList<>();
                dummy.add(nums[0]);
                dummy.add(nums[1]);
                dummy.add(nums[2]);
                ans.add(dummy);
            }
            return ans;
        }
        Arrays.sort(nums); // order do not matter. so we can sort the numbers
        int temp = -1, req = -1;
        // i+j+k==0
        // j+k=== -i
        for (int i = 0; i < nums.length; i++) {
            temp = -nums[i];
            int front = i + 1, back = nums.length - 1;
            while (front < back) {
                req = nums[front] + nums[back];
                if (temp == req) {
                    // if they match, means we have a answer
                    List<Integer> dummy = new ArrayList<>();
                    dummy.add(nums[i]);
                    dummy.add(nums[front]);
                    dummy.add(nums[back]);
                    ans.add(dummy);
                    // now since duplicates are not allowed, we need to do clean-up
                    while (front < back && nums[front] == dummy.get(1)) // skip number on front pointer
                        front++;
                    while (front < back && nums[back] == dummy.get(2)) // skip number on back pointer
                        back--;

                } else if (temp < req) {
                    // if req is big then we need to reduce it
                    // reduce back pointer
                    back--;
                } else {
                    // if req is small then we need to increase it
                    // increase front pointer
                    front++;
                }
            }
            // we also need to skip duplicates of i
            while (i + 1 < nums.length && nums[i + 1] == nums[i])
                i++;
        }
        return ans;
    }
}
