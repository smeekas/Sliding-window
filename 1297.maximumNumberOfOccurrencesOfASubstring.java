import java.util.HashMap;

class Solution {
    public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        /**
         * Observation
         * if substring exists of size maxSize, then substring also exists of size
         * minSize (that follows the condition of maxLetters)
         * 
         * since we want to maximize the the number of occurrences, we can check for
         * minSize only
         * 
         * so question now becomes, maximum number of substring of size k that have
         * maximum {maxLetters} letters.
         */
        HashMap<String, Integer> hm = new HashMap<>(); // to store substring and their occurrences
        int n = s.length();
        HashMap<Character, Integer> freq = new HashMap<>();

        for (int i = 0; i < minSize; i++) {
            int newSize = freq.getOrDefault(s.charAt(i), 0) + 1;
            freq.put(s.charAt(i), newSize);
            // initial window
        }
        if (freq.size() <= maxLetters) {
            // if initial window satisfy the condition then add into map
            hm.put(s.substring(0, minSize), 1);
        }
        for (int i = 1; i <= n - minSize; i++) {

            String subString = s.substring(i, i + minSize);
            char prev = s.charAt(i - 1);
            char next = s.charAt(i + minSize - 1);
            if (freq.containsKey(prev)) {
                // remove prev window's character
                if (freq.get(prev) > 1) {
                    freq.put(prev, freq.get(prev) - 1);
                } else {
                    freq.remove(prev);
                }
            }
            // add current window's character
            freq.put(next, freq.getOrDefault(next, 0) + 1);
            if (freq.size() <= maxLetters) {
                hm.put(subString, hm.getOrDefault(subString, 0) + 1);
            }
        }

        int max = 0;
        for (String ss : hm.keySet()) {
            // get max from map
            max = Math.max(max, hm.get(ss));
        }
        return max;
    }
}