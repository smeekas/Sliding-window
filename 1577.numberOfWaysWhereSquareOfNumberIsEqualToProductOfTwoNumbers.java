import java.util.Arrays;

class Solution {
    public int numTriplets(int[] nums1, int[] nums2) {
        /**
         * nums[j]*nums[k] j<k
         * 
         * assume we sort the numbers and jth & kth number switch the place
         * 
         * then k<j but...
         * 
         * nums[k]*nums[j] => nums[k-jth]*nums[j-kth] => jth < kth
         * condition holds
         * 
         * in short... ORDER DO NOT MATTER
         * hence we can sort the array
         */
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        return find(nums1, nums2) + find(nums2, nums1);
    }

    int find(int[] src, int[] des) {
        int count = 0;
        int n = des.length;
        for (int num : src) {
            long sqrd = (long) num * (long) num;
            int l = 0, r = n - 1;
            // for number i in src, we use two pointer in des to find 2 numbers
            while (l < r) {
                long mul = (long) des[l] * (long) des[r];
                if (mul == sqrd) {
                    if (des[l] == des[r]) {
                        // if lth and rth number are same means all number between l & r are same
                        // assume total x numbers
                        // 1st number will form x-1 pairs, 2nd will form x-2 pairs, 3rd will form x-3
                        // pairs etc......
                        // (x-1)+(x-2)+(x-3)+....2+1
                        // (n*(n+1))/2 => (total-1)*total /2
                        int total = r - l + 1;
                        count += (total * (total - 1)) / 2;
                        break;
                    } else {
                        int lCount = 1;
                        int rCount = 1;
                        int lIs = des[l];
                        int rIs = des[r];
                        // here lth and rth can duplicate
                        // so we count all duplicates first
                        while (l + 1 < r && des[l + 1] == lIs) {
                            l++;
                            lCount++;
                        }
                        while (l < r - 1 && des[r - 1] == rIs) {
                            r--;
                            rCount++;
                        }
                        // each lth number will form pair with each rth number
                        // total lCount*rCount pairs
                        count += lCount * rCount;
                        r--; // we can either move left or move right pointer to move forward
                    }

                } else if (mul < sqrd) {
                    // ans is small, increase it by moving left pointer
                    l++;
                } else {
                    // ans is big, decrease it by moving right pointer
                    r--;
                }
            }

        }
        return count;
    }
}
/**
 * 2 5 8 9
 * 5 2 8 9
 * 
 */