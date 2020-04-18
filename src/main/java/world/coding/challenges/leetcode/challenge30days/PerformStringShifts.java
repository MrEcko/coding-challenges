package world.coding.challenges.leetcode.challenge30days;

public class PerformStringShifts {

    private static final int LEFT = 0;

    public String stringShift(String s, int[][] shifts) {
        int n = s.length();
        char[] chars = s.toCharArray();
        int start = 0;
        for (int[] shift : shifts) {
            int direction = shift[0], amount = shift[1];
            if (direction == LEFT) {
                start = leftShift(start, n, amount);
            } else {
                start = rightShift(start, n, amount);
            }
        }
        return readCircularlyFromIndex(chars, start);
    }

    protected int leftShift(int start, int length, int amount) {
        return (start + amount) % length;
    }

    protected int rightShift(int start, int length, int amount) {
        if (amount <= start) {
            return start - amount;
        } else {
            int normalisedAmount = amount % length;
            if (normalisedAmount==0) return start;
            int offsetFromEnd = normalisedAmount - start;
            return length - offsetFromEnd;
        }

    }

    protected String readCircularlyFromIndex(char[] chars, int start) {
        int n = chars.length;
        StringBuilder output = new StringBuilder();
        for (int i = start; i < n; i++) {
            output.append(chars[i]);
        }
        for (int i = 0; i < Math.min(start, n); i++) {
            output.append(chars[i]);
        }
        return output.toString();
    }
}
