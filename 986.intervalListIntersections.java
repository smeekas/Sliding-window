import java.util.ArrayList;

class Solution {
    public int[][] intervalIntersection(int[][] fl, int[][] sl) {
        if (fl.length == 0)
            return new int[0][0]; // no overlap is possible as one array is empty
        if (sl.length == 0)
            return new int[0][0]; // no overlap is possible as one array is empty
        int i = 0, j = 0, n = fl.length, m = sl.length;
        ArrayList<int[]> ans = new ArrayList<>();
        while (i < n && j < m) {
            int fs = fl[i][0]; // first start
            int fe = fl[i][1]; // first end

            int ss = sl[j][0]; // second start
            int se = sl[j][1]; // second end
            if (fe < ss) {
                // if front end is lower then second start,
                // we need to move front's pointer
                // second bar is ahead of first bar
                i++;
                continue;
            } else if (se < fs) {
                // same above condition for second bar
                j++;
                continue;
            }
            int si = 0; // start index
            int ei = 0; // end index
            // since we want start index,
            // two possibilities, either start of second bar is in first bar,
            // or start of first bar is in second bar
            // in both the cases we want further left number so we use max
            si = Math.max(fs, ss);

            // same logic can be applied to obtain end
            ei = Math.min(fe, se);
            if (fe > se)
                // now if first bar's end is further left, we move second's pointer (j) or else
                // first's pointer(i)
                j++;
            else
                i++;

            ans.add(new int[] { si, ei });
        }
        int ansArr[][] = new int[ans.size()][2];
        for (int k = 0; k < ansArr.length; k++) {
            ansArr[k] = ans.get(k);
        }
        return ansArr;
    }
}