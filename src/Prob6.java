/*
PROB 6
The sum of the squares of the first ten natural numbers is,
1^2+2^2+...+10^2=385
The square of the sum of the first ten natural numbers is,
(1+2+...+10)^2=55^2=3025
Hence the difference between the sum of the squares of the first ten natural numbers
and the square of the sum is 3025−385=2640.
Find the difference between the sum of the squares of the first one hundred natural
numbers and the square of the sum.
 */

import java.io.*;
class Prob6
{
    public static void main(String[] args)throws IOException
    {
        long sum=0;
        int temp=0;
        for(int i=1;i<=200;i+=2)
        {
            temp+= i;
            sum+= temp;
        }
        //System.out.println(sum);

        long sum2= (long )Math.pow(50*101, 2);
        System.out.println(Math.abs(sum-sum2));
    }
}

// Approach 1: (i). We can notice that the difference between any two consecutive numbers square is an odd
//             not just odd but is in Arithmetic Progression 3, 5, 7, 9, 11, 13...... and so on.
//             so now when we can easily calculate the sum of first 100 natural numbers square.
//             (ii). Finding square of sum of first 100 natural no is also a piece of cake.