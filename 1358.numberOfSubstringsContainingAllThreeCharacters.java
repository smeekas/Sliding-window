import java.util.HashMap;

class Solution {
    public int numberOfSubstrings(String s) {
        HashMap<Character, Integer> hm = new HashMap<>();
        // NEW PATTERN count the subarrays
        int i = 0, j = 0;
        int n = s.length();
        int ans = 0;
        while (j < n) {
            char jth = s.charAt(j);
            hm.put(jth, hm.getOrDefault(jth, 0) + 1);
            while (i < n && hm.size() == 3) {
                // while condition is true, we can accumulate number of possible subarrays
                ans++; // for current subarray i to j
                ans += (n - (j + 1)); // if substring i-j is valid means i-(j+1), i-(j+2), i-n are valid too.
                // 1 2 3 4 5 6 7 8 9
                // ------i-----j----
                // 4-7 is valid then 4-8 & 4-9 are valid as well
                // so we do n-(j+1) to get count of remaining element in right side of j
                // (in our case 8,9)

                // so all other string bigger then current substring (containing current string
                // as substring) will also be in ans.
                char ith = s.charAt(i);

                // we have proceed all substrings start from i.
                // now we need to move further so we move left pointer and minimize the
                // substring length
                if (hm.containsKey(ith)) {
                    // process ith character and try to minimize the substring from left
                    int ss = hm.get(ith);
                    if (ss == 1)
                        hm.remove(ith);
                    else
                        hm.put(ith, ss - 1);
                }
                i++;
            }
            j++;
        }
        return ans;
    }
}