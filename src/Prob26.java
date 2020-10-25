import java.util.ArrayList;

/**
 * PROBLEM 26:
 * A unit fraction contains 1 in the numerator. The decimal representation of the unit
 * fractions with denominators 2 to 10 are given:
 *
 * 1/2	= 	0.5
 * 1/3	= 	0.(3)
 * 1/4	= 	0.25
 * 1/5	= 	0.2
 * 1/6	= 	0.1(6)
 * 1/7	= 	0.(142857)
 * 1/8	= 	0.125
 * 1/9	= 	0.(1)
 * 1/10	= 	0.1
 * Where 0.1(6) means 0.166666..., and has a 1-digit recurring cycle. It can be seen
 * that 1/7 has a 6-digit recurring cycle.
 *
 * Find the value of d < 1000 for which 1/d contains the longest recurring cycle in
 * its decimal fraction part.
 */

class Prob26
{
    static int length(int n)
    {
        int[] remainder= new int[n];
        int rem= 1, iter=1;

        while(remainder[rem]==0 && rem!=0)
        {
            remainder[rem]= iter;
            rem*=10;
            rem= rem%n;
            iter++;
        }

        return iter- remainder[rem];
    }

    public static void main(String[] args)
    {
        int max=0, ans=0;
        for(int i=2;i<=1000;i++)
        {
            int len= length(i);
            if(len>max)
            {
                max= len;
                ans= i;
            }
        }

        System.out.println(ans);
    }
}

/**
 * SOLUTION:
 *
 * So how we can calculate this repeating recurring cycle.
 * 10/3= { quotient: 3, remainder: 1 }
 * add a zero to the remainder and start again.
 * { quotient: 3, remainder: 1 }
 * and so on.
 *
 * By this we can find the quotient to as much decimal places as we want.
 * And check for the recurring cycles and its length.
 *
 * As we only need to to the division for d<1000 it will run in time no sweat.
 *
 * But the question is if we came across a recurring cycle then the division
 * will go on forever so when to stop?
 *     So as soon as we get a remainder that we have already seen then that's
 * the hint that the values are going to get repeated now.
 *
 * And as we know that the remainder value will never exceed the denominator
 * value we can keep an array of size denominator and save the iteration
 * at which we saw that remainder, that will help us to calculate the length of
 * the repeating decimal places.
 */