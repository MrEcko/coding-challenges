package world.coding.challenges.leetcode.challenge30days;

import java.util.ArrayList;
import java.util.List;

public class LeftmostColumnWithAtLeastAOne {
    public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
        List<Integer> dimensions = binaryMatrix.dimensions();
        int rows = dimensions.get(0);
        int columns = dimensions.get(1);


        //top right corner
        int i = 0, j = columns - 1, leftMostOne = -1;

        while (i < rows && j >= 0) {
            int result = binaryMatrix.get(i, j);
            if (result == 0)
                i++;//down
            else {
                leftMostOne = j;
                j--;//left
            }
        }
        return leftMostOne;
    }

    static class BinaryMatrix {
        private int[][] matrix;

        BinaryMatrix(int[][] matrix) {
            this.matrix = matrix;
        }

        public int get(int row, int col) {
            return matrix[row][col];
        }

        /**
         * @return [rows, cols]
         */
        public List<Integer> dimensions() {
            List<Integer> dimensions = new ArrayList<>();
            dimensions.add(matrix.length);
            dimensions.add(matrix.length > 0 ? matrix[0].length : 0);
            return dimensions;
        }
    }

}
