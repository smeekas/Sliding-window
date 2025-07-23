import java.util.HashSet;

class Solution {
    public boolean hasAllCodes(String s, int k) {
        int count = (int) Math.pow(2, k);
        // total 2^k different, unique code should exists
        // if yes that string contains 2^k means we have all codes!
        int n = s.length();
        HashSet<String> hs = new HashSet<>();
        for (int i = 0; i <= n - k; i++) {
            // substring of i, i+k (size-k)
            hs.add(s.substring(i, i + k));
        }
        // if set contains all count means we have all codes!
        return hs.size() >= count;
    }
}