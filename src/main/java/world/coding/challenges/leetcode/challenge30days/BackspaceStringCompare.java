package world.coding.challenges.leetcode.challenge30days;

/**
 * https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/529/week-2/3291/
 */
public class BackspaceStringCompare {

    public static final char BACKSPACE = '#';
    private static final int START = -1;


    public boolean backspaceCompare(String S, String T) {
        int s = S.length() - 1;
        int t = T.length() - 1;

        //compare strings 1 char at a time (post-backspace)
        while (s >= 0 || t >= 0) {
            s = executeBackspace(S, s);
            t = executeBackspace(T, t);


            if (reachedEnd(s) && reachedEnd(t)) break; // empty at the same time => same sequence

            //the other string might still have some backspace to reach the end at the same time
            if (!reachedEnd(t) && T.charAt(t) == BACKSPACE) continue;
            if (!reachedEnd(s) && S.charAt(s) == BACKSPACE) continue;

            if (reachedEnd(s)) return false; // S is empty but T has something typed
            if (reachedEnd(t)) return false; // T is empty but S has something typed

            if ((S.charAt(s) != T.charAt(t))) return false;

            s--;
            t--;
        }
        return true;
    }

    private boolean reachedEnd(int sCursor) {
        return sCursor == START;
    }

    private int executeBackspace(String str, int idx) {
        int deletions = 0;
        // look for consecutive backspaces
        while (idx >= 0 && str.charAt(idx) == BACKSPACE) {
            deletions += 1;
            idx -= 1;
        }

        // execute backspace and any subsequent ones in the current backspace window
        while (deletions > 0 && idx >= 0) {
            if (str.charAt(idx) == BACKSPACE) {
                deletions += 2;
            }
            idx--;
            deletions--;
        }
        return idx;
    }

}
