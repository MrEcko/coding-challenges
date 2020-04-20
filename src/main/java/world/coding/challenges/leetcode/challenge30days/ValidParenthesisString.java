package world.coding.challenges.leetcode.challenge30days;

public class ValidParenthesisString {

    //TODO iron it out
    public boolean checkValidStringMine(String s) {
        if (s.length() == 0) return true;
        int openParenthesis = 0;
        int stars = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                //consume stars
                //what about to close previous open parenthesis?
                if (stars>0){
                    if (stars > openParenthesis){
                        openParenthesis=0;
                    } else{
                        openParenthesis-= stars;
                    }
                }
                //reset star counter?
                stars=0;
                openParenthesis++;
            } else if (c == ')') {
                if (openParenthesis == 0) {
                    if (stars == 0) {
                        return false;
                    } else {
                        stars--;
                    }
                } else {
                    openParenthesis--;
                }
            } else {
                stars++;
            }
        }
        if (openParenthesis > 0) {
            openParenthesis -= stars;
        }

        return openParenthesis <= 0;
    }

    /**
     * https://leetcode.com/problems/valid-parenthesis-string/discuss/107577/Short-Java-O(n)-time-O(1)-space-one-pass
     */
    public boolean checkValidString2(String s) {

        int low = 0;
        int high = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                low++;
                high++;
            } else if (s.charAt(i) == ')') {
                if (low > 0) {
                    low--;
                }
                high--;
            } else {
                if (low > 0) {
                    low--;
                }
                high++;
            }
            if (high < 0) {
                return false;
            }
        }
        return low == 0;



    }

    /**
     * https://leetcode.com/problems/valid-parenthesis-string/discuss/587778/Java-O(n)-Solution
     */
    public boolean checkValidString(String s) {
        int min = 0; //least number of ')' to balance
        int max = 0; //largest number of ')' to balance
        for (int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if (c == '(') {
                ++min;
                ++max;
            } else if (c == ')') {
                --min;
                --max;
                if (max < 0) {
                    //more ')' than '(' + '*'
                    return false;
                }
            } else if (c == '*') {
                --min;
                ++max;
            }

            if (min < 0) {
                //in previous characters, a '*' is used to balance '(' while it should be empty
                min = 0;
            }
        }
        return min == 0;
    }


}
