package world.coding.challenges.geeksforgeeks;

/**
 * https://www.geeksforgeeks.org/min-cost-path-dp-6/
 */
public class MinCostPathDP6 {

    public static final int COL1 = 0;
    public static final int ROW1 = 0;

    /**
     * Dynamic Programming(DP) problems, recomputations of same subproblems
     * can be avoided by constructing a temporary array tc[][] in bottom up manner.
     * Time Complexity of the DP implementation is O(mn)
     */
    public int minCostDP(int[][] cost, int m, int n) {
        int[][] tc = new int[m + 1][n + 1];

        /* Initialise starting point */
        tc[ROW1][COL1] = cost[ROW1][COL1];

        /* Initialize first column of total cost(tc) array */
        for (int i = 1; i <= m; i++)
            tc[i][COL1] = tc[i - 1][COL1] + cost[i][COL1];

        /* Initialize first row of tc array */
        for (int j = 1; j <= n; j++)
            tc[ROW1][j] = tc[ROW1][j - 1] + cost[ROW1][j];

        /* Construct rest of the tc array - skip row 1 (i=0) and col 1 (j=0) */
        for (int i = 1; i <= m; i++)
            for (int j = 1; j <= n; j++)
                tc[i][j] = cost[i][j]
                        + min(tc[i - 1][j - 1],
                              tc[i - 1][j],
                              tc[i][j - 1]);

        return tc[m][n];
    }

    /**
     * Naive Recursive implementation - exponential time complexity
     */
    public int minCost(int[][] cost, int m, int n) {
        if (m < 0 || n < 0) return Integer.MAX_VALUE;
        else if (m == 0 && n == 0) return cost[m][n];
        else return cost[m][n] + min(
                minCost(cost, m - 1, n - 1),
                minCost(cost, m - 1, n),
                minCost(cost, m, n - 1)
            );

    }

    private int min(int a, int b, int c) {
        return Math.min(Math.min(a, b), c);
    }
}
