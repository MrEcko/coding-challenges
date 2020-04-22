package world.coding.challenges.leetcode.challenge30days;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class MinimumPathSum {

    Map<Position, Integer> memo = new HashMap<>();

    public int minPathSum(int[][] grid) {
        int rows = grid.length;
        if (rows == 0) return 0;
        int cols = grid[0].length;
        if (cols == 0) return 0;
        memo = new HashMap<>();
        return mp(new Position(0, 0), grid);
    }

    private int mp(Position position, int[][] grid) {
        if (memo.containsKey(position)) return memo.get(position);
        boolean canGoRight = true, canGoDown = true;
        if (position.row == grid.length - 1) canGoDown = false;
        if (position.col == grid[0].length - 1) canGoRight = false;
        int current = grid[position.row][position.col];
        int minPath;
        if (!canGoDown && !canGoRight) minPath = current;
        else if (!canGoRight) {
            minPath = current + mp(new Position(position.row + 1, position.col), grid);
        } else if (!canGoDown) {
            minPath = current + mp(new Position(position.row, position.col + 1), grid);
        } else {
            minPath = current + Math.min(
                mp(new Position(position.row + 1, position.col), grid),
                mp(new Position(position.row, position.col + 1), grid)
            );
        }
        memo.put(position, minPath);
        return minPath;

    }

    static class Position {
        int col;
        int row;

        public Position(int row, int col) {
            this.row = row;
            this.col = col;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Position position = (Position) o;
            return col == position.col &&
                row == position.row;
        }

        @Override
        public int hashCode() {
            return Objects.hash(col, row);
        }
    }

}
