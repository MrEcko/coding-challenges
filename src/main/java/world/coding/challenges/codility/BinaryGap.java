package world.coding.challenges.codility;

/**
 * https://app.codility.com/programmers/lessons/1-iterations/binary_gap/
 */
public class BinaryGap {

    /**
     * @param N positive integer within the range [1..2,147,483,647].
     * @return length of longest binary gap of {@param N}.
     */
    public int solution(int N) {
        int output = 0;
        if (N > 0) {
            int quotient = N;
            int binaryGap = 0;

            boolean hasOne = false;
            while (quotient > 0) {
                int remainder = quotient % 2;

                if (remainder == 0) {
                    if (hasOne) {
                        binaryGap++;
                    }
                } else {
                    if (hasOne) {//means we found a subsequent one, gap measured, resetting count
                        if (binaryGap > output) {
                            output = binaryGap;
                        }
                        binaryGap = 0;
                    }
                    hasOne = true;
                }

                quotient /= 2;
            }
        }
        return output;
    }
}
