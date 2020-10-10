/**
 *  PROBLEM: 15
 *  Starting in the top left corner of a 2×2 grid, and only being able to move to the right
 *  and down, there are exactly 6 routes to the bottom right corner.
 *  How many such routes are there through a 20×20 grid?
 */

import java.util.*;
class Prob15
{
    static long[][] memo;
    static long DFSREC(int n, int m, int row, int col)
    {
        if(row<=n && col<=m && memo[row][col]!= 0)
            return memo[row][col];
        long right= row+1<=n? DFSREC(n, m, row+1, col): 0;
        long down= col+1<=m? DFSREC(n, m, row, col+1):0;

        memo[row][col]= right+ down;
        return memo[row][col];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();
        memo = new long[n+1][m+1];
        memo[n][m]=1;

        DFSREC(n, m, 0, 0);
        System.out.println(memo[0][0]);
    }
}

/**
 * OBSERVATIONS: I cant catch any mathematical formula relating size of matrix and route.
 *               Gonna use depth-first-search to calculate it. Not efficient but cant think of anything else right now.
 *
 * OPTIMIZATION: Ok so i will optimize the code using Dynamic programming and for simplicity i will
 *               use memoization over tabulation.
 */