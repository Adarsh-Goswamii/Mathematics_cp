import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * PROBLEM 18
 * By starting at the top of the triangle below and moving to adjacent numbers on the
 * row below, the maximum total from top to bottom is 23.
 *
 * 3
 * 7 4
 * 2 4 6
 * 8 5 9 3
 *
 * That is, 3 + 7 + 4 + 9 = 23.
 *
 * Find the maximum total from top to bottom of the triangle below:
 *
 *                             75
 *                           95 64
 *                         17 47 82
 *                       18 35 87 10
 *                     20 04 82 47 65
 *                   19 01 23 75 03 34
 *                 88 02 77 73 07 63 67
 *               99 65 04 28 06 16 70 92
 *             41 41 26 56 83 40 80 70 33
 *           41 48 72 33 47 32 37 16 94 29
 *         53 71 44 65 25 43 91 52 97 51 14
 *       70 11 33 28 77 73 17 78 39 68 17 57
 *     91 71 52 38 17 14 91 43 58 50 27 29 48
 *   63 66 04 68 89 53 67 30 73 16 69 87 40 31
 * 04 62 98 27 23 09 70 98 73 93 38 53 60 04 23
 *
 * NOTE: As there are only 16384 routes, it is possible to solve this problem by trying
 * every route. However, Problem 67, is the same challenge with a triangle containing
 * one-hundred rows; it cannot be solved by brute force, and requires a clever method! ;o)
 */

class Prob18
{
    static int[][] memo;
    static int max;
    static void call(ArrayList<ArrayList<Integer>> arr, int row, int col, int curr_sum)
    {
        if(row>= arr.size())
            max= Math.max(curr_sum, max);

        if(row>= arr.size() || curr_sum< memo[row][col])
            return;
        else
            memo[row][col]= curr_sum;

        call(arr, row+1, col, curr_sum+ arr.get(row).get(col));
        call(arr, row+1, col+1, curr_sum+ arr.get(row).get(col));
    }

    public static void main(String[] args)throws IOException
    {
        BufferedReader  br= new BufferedReader(new InputStreamReader(System.in));
        ArrayList<ArrayList<Integer>> arr= new ArrayList<>();

        for(int i=0;i<15;i++)
        {
            StringTokenizer st= new StringTokenizer(br.readLine());
            ArrayList<Integer> temp= new ArrayList<>();

            while(st.hasMoreTokens())
                temp.add(Integer.parseInt(st.nextToken()));
            arr.add(temp);
        }

        memo= new int[15][15];
        max= 0;
        call(arr, 0, 0, 0);
        System.out.println(max);
    }
}

/**
 * So, obviously i wont go for the brute force as that would
 * be too easy.
 *
 * Its quite easy to see that there are many repeating sub
 * problems which tells that it is a dynamic programming
 * based question.
 *
 * Its pretty transparent now how to solve it.
 * OBSERVATIONS:
 * (i). If we consider every number as a node then they have
 * two childs.
 * (ii). As we cant tell tha max sum route until we traverse
 * through all the possible routes.
 * So at first it looks like O(2^ level of pyramid).
 * But after applying dynamic programming it will be reduced
 * to polynomial for sure.
 *
 * ALGORITHM:
 * (i). Make a recursive function and a memo[][] that stores
 * max value till that point.
 * (ii). now check the curr sum with max sum if smaller break
 * else carry on and update the value.
 *
 */
