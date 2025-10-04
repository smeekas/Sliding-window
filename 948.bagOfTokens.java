import java.util.Arrays;

class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        Arrays.sort(tokens);
        int l = 0, r = tokens.length - 1;
        int score = 0;
        while (l <= r) {
            if (l == r) {
                if (power >= tokens[l])
                    return score + 1;
                else
                    return score; // no point of sacrificing score to gain power, as there is no more token so our
                                  // loop ends and we can just return score
            }
            if (power >= tokens[l]) {
                // we think greedy
                // we try to compare power with lth token (< rth token) to gain score

                score++;
                power -= tokens[l];
                l++;
            } else {
                // if power is < token[l]

                if (score > 0) {
                    // SCORE CAN NEVER GO NEGATIVE
                    // we can sacrifice one score to gain rth token's power
                    score--;
                    power += tokens[r];
                }
                // and move right pointer
                r--;
            }
        }
        return score;
    }
}