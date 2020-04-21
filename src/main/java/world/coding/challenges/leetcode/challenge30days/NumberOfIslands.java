package world.coding.challenges.leetcode.challenge30days;

import java.util.Optional;
import java.util.Stack;

public class NumberOfIslands {

    public int numIslands(char[][] grid) {
        int islandsCount = 0;
        if (grid.length == 0 || grid[0].length == 0) return islandsCount;

        int[][] visited = new int[grid.length][grid[0].length];
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[row].length; col++) {
                //any new land we haven't visited means it isn't part of any island we've been to
                if (isLand(row, col, grid) && visited[row][col] == 0) {
                    islandsCount++;
                    visitIsland(new Position(row, col), visited, grid);
                }
            }
        }

        return islandsCount;
    }

    /**
     * from this starting position branch out everywhere (up and down)
     * as long as grid allows and we haven't already been tehre
     */
    private void visitIsland(Position startingPosition, int[][] visited, char[][] grid) {
        Stack<Position> islandSquares = new Stack<>();
        islandSquares.add(startingPosition);
        int rows = grid.length, cols = grid[0].length;
        while (!islandSquares.isEmpty()) {
            Position currentPosition = islandSquares.pop();
            int col = currentPosition.col, row = currentPosition.row;
            visited[row][col] = 1;
            getIslandSquare(row - 1, col, grid, visited, rows, cols).ifPresent(islandSquares::add);
            getIslandSquare(row + 1, col, grid, visited, rows, cols).ifPresent(islandSquares::add);
            getIslandSquare(row, col - 1, grid, visited, rows, cols).ifPresent(islandSquares::add);
            getIslandSquare(row, col + 1, grid, visited, rows, cols).ifPresent(islandSquares::add);
        }
    }

    private Optional<Position> getIslandSquare(int row, int col, char[][] grid, int[][] visited, int rows, int cols) {
        Position nextPosition = new Position(row, col);
        if (row >= 0 && row < rows && col >= 0 && col < cols && visited[row][col] == 0) {
            if (isLand(nextPosition.row, nextPosition.col, grid)) {
                return Optional.of(nextPosition);
            } else {
                visited[row][col] = 1;
            }
        }
        return Optional.empty();
    }

    boolean isLand(int row, int col, char[][] grid) {
        return grid[row][col] == '1';
    }

    static class Position {
        int col;
        int row;

        public Position(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

}
