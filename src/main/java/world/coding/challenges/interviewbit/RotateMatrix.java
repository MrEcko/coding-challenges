package world.coding.challenges.interviewbit;

import java.util.ArrayList;

/**
 * https://www.interviewbit.com/problems/rotate-matrix/
 * You are given an n x n 2D matrix representing an image.
 *
 * Rotate the image by 90 degrees (clockwise).
 *
 * You need to do this in place.
 *
 * Note that if you end up using an additional array, you will only receive partial score.
 *
 * Example:
 *
 * If the array is
 *
 * [
 *     [1, 2],
 *     [3, 4]
 * ]
 * Then the rotated array becomes:
 *
 * [
 *     [3, 1],
 *     [4, 2]
 * ]
 */
public class RotateMatrix {
    public void rotate(ArrayList<ArrayList<Integer>> a) {
        int n = a.size();
        if (n > 0) {
            if (n == 1) return;
            int numberOfSquares = n / 2;
            //shifting square edge items
            for (int row = 0; row < numberOfSquares; row++) {
                for (int col = row; col < n - (row + 1); col++) {
                    MatrixItem nextItem = new MatrixItem(row, col, a.get(row).get(col));
                    nextItem = rotateItem(nextItem, a);
                    nextItem = rotateItem(nextItem, a);
                    nextItem = rotateItem(nextItem, a);
                    rotateItem(nextItem, a);
                }

            }
        }
    }

    private MatrixItem rotateItem(MatrixItem item, ArrayList<ArrayList<Integer>> a) {
        int nextRow = item.col, nextCol = a.size() - 1 - item.row;
        int nextValue = a.get(nextRow).get(nextCol);
        a.get(nextRow).set(nextCol, item.val);
        return new MatrixItem(nextRow, nextCol, nextValue);
    }

    class MatrixItem {
        int col;
        int row;
        int val;

        public MatrixItem(int row, int col, int val) {
            this.row = row;
            this.col = col;
            this.val = val;
        }
    }
}
