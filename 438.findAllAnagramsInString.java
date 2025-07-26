import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> findAnagrams(String s, String p) {

        // very much similar to 567
        List<Integer> list = new ArrayList<>();
        int slen = s.length();
        int plen = p.length();
        int freq1[] = new int[26];
        int freq2[] = new int[26];
        if (plen > slen)
            return list;
        for (char c : p.toCharArray())
            freq2[c - 'a']++;
        for (int i = 0; i < plen; i++) {
            freq1[s.charAt(i) - 'a']++;
        }
        int k = plen;
        if (areEqual(freq1, freq2))
            list.add(0);
        for (int i = 1; i <= slen - k; i++) {
            int prevChar = s.charAt(i - 1) - 'a';
            int nextChar = s.charAt(i + k - 1) - 'a';
            freq1[prevChar]--;
            freq1[nextChar]++;
            if (areEqual(freq1, freq2)) {
                list.add(i);
            }
        }
        return list;
    }

    boolean areEqual(int[] f1, int[] f2) {
        for (int i = 0; i < f1.length; i++) {
            if (f1[i] != f2[i]) {
                return false;
            }
        }
        return true;
    }
}