class Solution {
    public int[] decrypt(int[] code, int k) {
        int n = code.length;
        if (k == 0) {
            for (int i = 0; i < n; i++) {
                code[i] = 0;
            }
            return code;
        }
        if (k > 0) {
            return getResult(code, k);
        }
        // in- case of negative k, we can reverse both array and k ( k to -k)
        // and it become same as array and +ve K
        reverse(code);
        int[] result = getResult(code, -k);
        reverse(result);
        return result;
    }

    int[] getResult(int[] code, int k) {
        int n = code.length;

        int sum = 0;
        int ans[] = new int[n];
        for (int i = 1; i <= k; i++) {
            sum += code[i];
        }
        ans[0] = sum; // initial window sum
        for (int i = 1; i < n; i++) {
            // for current index, update window sum count
            sum -= code[i];
            sum += code[(i + k) % n];
            ans[i] = sum; // update it
        }
        return ans;
    }

    void reverse(int[] code) {
        int n = code.length;
        int i = 0, j = n - 1;
        while (i < j) {
            int temp = code[i];
            code[i] = code[j];
            code[j] = temp;
            i++;
            j--;
        }
    }
}