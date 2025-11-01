class Solution {
    public int expressiveWords(String s, String[] words) {
        int ans = 0;
        // somewhat similar to 925. long pressed names
        for (String src : words) {
            if (make(s, src)) {
                ans++;
            }
        }
        return ans;
    }

    boolean make(String s, String src) {

        int n = s.length();
        int m = src.length();
        int i = 0, j = 0;
        // we try to make s ==src
        while (j < m && i < n) {
            char jth = src.charAt(j);
            char ith = s.charAt(i);
            if (ith != jth) {
                return false;
            }
            int ic = 0, jc = 0;
            while (i < n && s.charAt(i) == ith) {
                i++;
                ic++;
            }
            while (j < m && src.charAt(j) == jth) {
                j++;
                jc++;
            }
            // ic is for S (main big str)
            // jc is for query (small)
            /*
             * question requires us to have at-least 3 char when we expand char of src
             * 
             * here we have shrinking logic
             * 
             * if main string's char c's count is < 3 that means query string's char will
             * not expand upto 3 char so they should be equal
             * if ic < 3 and char count not equal means query's char cannot expand and we cannot make query string as main string
             * 
             * above is first condition
             * 
             * if main string's char count is >=3 means query string can expand it's char to try to match main string
             * it means query string should be < main string's char count because we cannot decrease count we can only increase
             * 
             * so if main string's char count >=3 & if query string have more char means query string cannot be equated to main string as we cannot expand query string
             */
            if ((ic < 3 && ic != jc) || (ic >= 3) && ic < jc)
                return false;
        }
        // this condition is same as 925. long pressed name
        return i == n && j == m;
    }
}