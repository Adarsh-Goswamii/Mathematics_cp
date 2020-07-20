/*
PROB 7
By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see that the 6th prime is 13.
What is the 10001st prime number?
 */

import java.io.*;
import java.util.*;

class Prob7
{
    public static void main(String[] args)throws IOException
    {
        boolean[] arr= new boolean[15*10001];
        int i=2;
        while(i*i<arr.length)
        {
            if (arr[i])
            {
                i++;
                continue;
            }
            else
            {
                for(int j= i*i;j<arr.length;j+=i)
                    arr[j]= true;
            }
            i++;
        }

        i=0;
        int j=2;
        int ans=0;
        while(j<arr.length && i!=10001)
        {
            if(!arr[j++]) {
                i++;
                ans=j-1;
            }
        }
        System.out.println(ans);
    }
}

// Approach 1: Traverse from index 2 and find all the primes till we reach 10001st prime number.(INEFFICIENT)
// Approach 2: cant use sieve of eratosthenes directly as that would require an upper bound as in find all
//             prime numbers in range [lower_bound, upper_bound].
//
//             So, there is a relation that f(x): no of primes within [2, x]
//                      f(x) ~ x / ( log x ). This can for sure give us an idea of upperbound.
//             O(N log(log N)). Where N is the upper bound

