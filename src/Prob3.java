/* PROB 3
The prime factors of 13195 are 5, 7, 13 and 29.
What is the largest prime factor of the number 600851475143 ?
 */

import java.util.*;
class Prob3
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        long val= sc.nextLong();
        int ans=2;
        int prime= 2;
        while(val!=1)
        {
            if(val%prime==0)
                val= val/prime;
            else
            {
                boolean bool= true;
                while(bool)
                {
                    bool= false;
                    prime++;
                    for(int i=2;i*i<=prime;i++)
                        if(prime%i==0)
                            bool= true;
                }
                ans= Math.max(ans, prime);
            }
        }
        System.out.println(ans);
    }
}
// Approach 1: Naive just traverse each no from 2 to sqrt(600851475143)(Never gonna work)
// Approach 2: use sieve of eratosthenes O(n loglogn ): good but we dont need to calculate all the
//             prime numbers between 1 to 600851....
// Approach 3: just factorize it, as we do in lcm. O(sqrt(n)).
