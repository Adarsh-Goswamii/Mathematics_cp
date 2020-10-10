/**
 * The following iterative sequence is defined for the set of positive longegers:
 *
 * n → n/2 (n is even)
 * n → 3n + 1 (n is odd)
 *
 * Using the rule above and starting with 13, we generate the following sequence:
 *
 * 13 → 40 → 20 → 10 → 5 → 16 → 8 → 4 → 2 → 1
 * It can be seen that this sequence (starting at 13 and finishing at 1) contains 10 terms.
 * Although it has not been proved yet (Collatz Problem), it is thought that all starting
 * numbers finish at 1.
 *
 * Which starting number, under one million (1,000,000), produces the longest chain?
 *
 * NOTE: Once the chain starts the terms are allowed to go above one million.
 *
 */

import java.util.*;
class Prob14
{
    static boolean power(long n)
    {
        if((n&(n-1))==0)
            return true;
        else
            return false;
    }

    static long next(long n)
    {
        if((n&1)==0)
            return n/2;
        else
            return 3*n+1;
    }

    static long logBase2(long n)
    {
        return (long)(Math.log(n) / Math.log(2));
    }

    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("STARTED....PLEASE! WAIT");

        long ans=0, max=0;
        long[] tabulation= new long[1000001];
        for(long i=1;i<=1000000;i++)
        {
            long n=i, terms=1;

            while(n!=1 && !power(n))
            {
                if(n<1000001 && tabulation[(int)n]!=0)
                {
                    terms+= tabulation[(int)n];
                    break;
                }
                else {
                    terms++;
                    n = next(n);
                }
            }

            terms+= logBase2(n);
            tabulation[(int)i]= terms;
            if(terms> max)
            {
                max= terms;
                ans= i;
            }
        }
        System.out.println(ans+"\n"+max);
    }
}

/**
 *  OBSERVATION: (i). As soon as we get a number that is a power of 2 the sequence goes on decreasing
 *                    and finally reaches 1.
 *
 *  ALGORITHM: (i). A number can be checked if its a power of two or no by O(1) time using brian
 *                  kernighan's algorithm.
 *             (ii). if it is a power of 2 we can find the log base 2 for the remaining no of terms.
 *             (iii). There will be a lot of numbers that's gonna repeat so we can use dynamic programming
 *                    as there are over lapping sup problems.
 *
 *
 *
 */