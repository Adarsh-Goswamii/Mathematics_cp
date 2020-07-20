/*  PROB 1
If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9.
The sum of these multiples is 23.
Find the sum of all the multiples of 3 or 5 below 1000.
 */

import java.util.*;
class Prob1 {
    public static void main(String args[]) {
        int sum = 0;
        for (int i = 3; i < 1000; i++) {
            if (i % 3 == 0 || i % 5 == 0)
                sum += i;
        }
        System.out.println(sum);
        System.out.println(efficient(3, 1000)+efficient(5, 1000)- efficient(15, 1000));
    }
//the above solution is quite a naive approach
// an EFFICIENT soln can be

    static int efficient(int divisor, int max_size)
    {
        int sum=0;
        for(int i=divisor; i<max_size; i+=divisor)
            sum+= i;
        return sum;
    }
}