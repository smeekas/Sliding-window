class Solution {
    public String shortestBeautifulSubstring(String s, int k) {

        // we want minimum
        int i = 0, j = 0;
        int n = s.length();
        int count = 0;
        String ans = "";
        while (i < n && j < n) {
            char c = s.charAt(j);
            if (c == '1')
                count++;
            while (count == k) {
                // while condition holds we will update the answer if applicable and contract
                // the window
                String sub = s.substring(i, j + 1);
                if (ans.length() == 0) {
                    // ans do not have any ans stored. sub can be taken as answer
                    ans = sub;
                } else if (ans.length() > sub.length()) {
                    // sub is smaller, so update then ans
                    ans = sub;
                } else if (ans.length() == sub.length()) {
                    if (ans.compareTo(sub) == 1) {
                        // ans and sub are of equal length
                        // ans.compareTo(sub) == 1 means ans is bigger
                        // sub is smaller.
                        ans = sub;
                    }
                }
                char ith = s.charAt(i);
                if (ith == '1') {
                    count--;
                }
                i++;
            }
            j++;
        }
        return ans;
    }
}