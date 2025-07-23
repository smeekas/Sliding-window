class Solution {
    public int minimumRecolors(String blocks, int k) {
        char c[] = blocks.toCharArray();
        // in-short we need least amount of white blocks in k consecutive block
        // that will result in minimum recolor of white to black

        // bruteforce will be O(n*k)
        int wCount = 0;
        int ans = 0;
        int n = c.length;
        for (int i = 0; i < k; i++)
            if (c[i] == 'W')
                wCount++; // white count for first window
        ans = wCount;

        for (int i = 1; i <= n - k; i++) {

            if (c[i - 1] == 'W') // delete from last window
                wCount--;
            if (c[i + k - 1] == 'W') // add for current window
                wCount++;
            ans = Math.min(ans, wCount); // take count
        }
        return ans;
    }
}