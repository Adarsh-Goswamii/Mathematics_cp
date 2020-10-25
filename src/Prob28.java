/**
 * PROBLEM 28:
 * Starting with the number 1 and moving to the right in a clockwise direction a 5 by
 * 5 spiral is formed as follows:
 *
 *       43 44 45 46 47 48 49
 *       42 21 22 23 24 25 26
 *       41 20  7  8  9 10 27
 *       40 19  6  1  2 11 28
 *       39 18  5  4  3 12 29
 *       38 17 16 15 14 13 30
 *       37 36 35 34 33 32 31
 *
 * It can be verified that the sum of the numbers on the diagonals is 101.
 *
 * What is the sum of the numbers on the diagonals in a 1001 by 1001 spiral formed
 * in the same way?
 */

class Prob28
{
    public static void main(String[] args)
    {
        int ans=1, val=1;
        for(int i=2;i<=1000;i+=2)
        {
            for(int j=0;j<4;j++)
            {
                ans= ans+ (val+=i);
                //System.out.print(val+" ");
            }
        }

        System.out.println(ans);
    }
}

/**
 * SOLUTION:
 * No way i am going to create that matrix and then calc the sum
 * of diagonal there has to be some pattern
 *
 * 1, 3, 13, 31, 57, .................
 *
 * first_term= 1
 * last_term+ 0*3 + 2
 * last_term+ 2*3 + 4
 * last_term+ 4*3 + 6
 * and so on..................
 *
 * 1, 7, 21, 43
 * first_term= 1
 * last_term+ 2*3 +0
 * last_term+ 4*3 +2
 * last_term+ 6*3 +4
 * and so on.............
 * So this is the pattern for calculating the diagonal elements.
 *
 *
 * All this was so stupid.
 *
 * Question becomes lot easier when we write this series.
 * diagonal elements= 1, 3, 5, 7, 9, 13, 17, 21, 25, 31, 37......
 * difference between the elements: 2, 2, 2, 2, 4, 4, 4, 4, 6, 6...
 */
