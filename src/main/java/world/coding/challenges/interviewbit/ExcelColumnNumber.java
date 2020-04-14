package world.coding.challenges.interviewbit;

/**
 *
 * https://www.interviewbit.com/problems/excel-column-number/
 * Given a column title as appears in an Excel sheet, return its corresponding column number.
 *
 * Example:
 *
 *     A -> 1
 *
 *     B -> 2
 *
 *     C -> 3
 *
 *     ...
 *
 *     Z -> 26
 *
 *     AA -> 27
 *
 *     AB -> 28
 */
public class ExcelColumnNumber {
    private static final char COLUMN_1 = 'A';

    public int titleToNumber(String A) {
        int output = 0;
        for (int i=0; i<A.length(); i++){
            output = output * 26 + (A.charAt(i) - COLUMN_1 + 1);
        }
        return output;
    }
}
