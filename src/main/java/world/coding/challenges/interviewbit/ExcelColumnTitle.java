package world.coding.challenges.interviewbit;

/**
 *
 * https://www.interviewbit.com/problems/excel-column-title/
 * Given a positive integer, return its corresponding column title as appear in an Excel sheet.
 *
 * For example:
 *
 *     1 -> A
 *     2 -> B
 *     3 -> C
 *     ...
 *     26 -> Z
 *     27 -> AA
 *     28 -> AB
 */
public class ExcelColumnTitle {
    public String convertToTitle(int A) {
        StringBuilder output = new StringBuilder();
        while (A != 0 ) {
            int digit = (A-1) % 26;
            output.append(toLetter(digit));
            A = (A - 1) / 26;
        }
        return output.reverse().toString();
    }

    /**
     * @param letterIndex in base 26
     * @return the corresponding letter
     */
    private char toLetter(int letterIndex){
        return (char)('A'+letterIndex);
    }
}
