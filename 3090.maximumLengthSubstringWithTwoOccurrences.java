import java.util.HashMap;

class Solution {
    public int maximumLengthSubstring(String s) {
        int i = 0, j = 0;
        int n = s.length();
        int ans = 0;
        HashMap<Character, Integer> hm = new HashMap<>();
        while (i < n && j < n) {
            // main while loop will take care of moving jth pointer

            while (i < n && j < n && hm.containsKey(s.charAt(j)) && hm.get(s.charAt(j)) == 2) {
                // move left pointer till we find jth character's freq 2
                // it should be < 2, as current jth character will add 1 to freq to make it 2
                char charI = s.charAt(i);
                if (hm.containsKey(charI)) {
                    if (hm.get(charI) == 1)
                        // freq 1? remove char
                        hm.remove(charI);
                    else {
                        // decrease freq
                        hm.put(charI, hm.get(charI) - 1);
                    }
                }
                i++;
            }
            char charJ = s.charAt(j);
            hm.put(charJ, hm.getOrDefault(charJ, 0) + 1); // now add current character
            ans = Math.max(ans, j - i + 1); // update window if required
            j++;

        }
        return ans;
    }
}