/*
PROB 5
2520 is the smallest number that can be divided by each of the numbers from 1 to 10 without any remainder.
What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?
 */

import java.io.*;
class Prob5
{
    public static void main(String[] args)throws IOException
    {
        int[] prime={2, 3, 5, 7, 11, 13, 17, 19};
        int[] freq_max=new int[8];

        for(int i=2;i<=20;i++)
        {
            int[] freq=new int[8];
            int n= i, j=0;

            // Prime Decomposition
            while(n!=1)
            {
                if(n%prime[j]!=0)
                    j++;
                else
                {
                    n= n/prime[j];
                    freq[j]++;
                }
            }

            // Max of all primes
            for(j=0;j<8;j++)
                freq_max[j]= Math.max(freq_max[j], freq[j]);
        }
        long ans=1;
        for(int i=0;i<8;i++)
            ans= ans* (long )Math.pow(prime[i], freq_max[i]);

        System.out.println(ans);
    }
}

//  Approach 1: Naive Approach just iterate till we find a no divisible by all. Run the code to see why
// that's not a great idea.

//  Approach 2: (i) Write all the numbers from 1 to 20 in their prime decomposition.
//              (ii) store the max of every prime and then multiply it.
//              (iii) Here i am using explicitly provided prime as range is already known but we can always use
// sieve of eratosthenes algorithm to do so.