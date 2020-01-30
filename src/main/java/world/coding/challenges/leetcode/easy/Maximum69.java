package world.coding.challenges.leetcode.easy;

/**
 * https://leetcode.com/problems/maximum-69-number/
 */
public class Maximum69 {
    public int maximum69Number(int num) {
        StringBuilder digits = new StringBuilder(Integer.toString(num));
        for (int i = 0; i < digits.length(); i++) {
            if (digits.charAt(i) == '6') {
                digits.setCharAt(i, '9');
                break;
            }
        }
        return Integer.parseInt(digits.toString());
    }
}
