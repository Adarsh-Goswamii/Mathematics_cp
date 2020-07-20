/*
The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.
Find the sum of all the primes below two million.
 */


// 2 Million= 2,000,000
import java.util.*;
class Prob10
{
    public static void main(String args[])
    {
        boolean[] composite=new boolean[2000000+1];
        for(int i=2;i*i<=2000000;i++)
        {
            if(composite[i])
                continue;
            else
                for(int j=i*i;j<=2000000;j+=i)
                    composite[j]= true;
        }

        long ans=0;
        for(int i=2;i<=2000000;i++)
        {
            if(!composite[i]) ans+=i;
        }

        System.out.println(ans);
    }
}

// Approach 1: This is a straight forward problem based on sieve of eratosthenes. O( N log N log N).