class Solution {
    public int divisorSubstrings(int num, int k) {

        String s = String.valueOf(num);
        int n = s.length();
        StringBuilder divs = new StringBuilder(s.substring(0, k)); // initial window

        int ans = 0;
        int local = Integer.parseInt(divs.toString());
        if (local != 0 && num % local == 0)
            // if current window satisfies then update the count
            ans++;

        for (int i = 1; i <= n - k; i++) {
            divs.append(s.charAt(i + k - 1));
            divs = new StringBuilder(divs.substring(1, divs.length()));
            // update the window
            local = Integer.parseInt(divs.toString());
            if (local != 0 && num % local == 0)
                // if window matches the criteria, then update the answer
                ans++;
        }
        return ans;

    }

}