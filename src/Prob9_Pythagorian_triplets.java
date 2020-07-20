/*
A Pythagorean triplet is a set of three natural numbers, a < b < c, for which,

a2 + b2 = c2
For example, 32 + 42 = 9 + 16 = 25 = 52.

There exists exactly one Pythagorean triplet for which a + b + c = 1000.
Find the product abc.
 */

import java.util.*;
class Prob9
{
    public static void main(String[] args)
    {
        int m=1;
        while(true)
        {
            int n= ( 500- m*m )/ m;
            if(m*m + m*n == 500 && m>=n)
            {
                int a= m*m -n*n;
                int b= 2*m*n;
                int c= m*m +n*n;
                System.out.println(a*b*c);
                break;
            }
            m++;
        }
    }
}

// Approach 1: Find all the squares till 1000. If i find the triplets first it will be O(n^2) after using hashing
//             then we could just check for their sum==1000.
//             Gonna make slight improvements while implementation, nothing drastic though so, main idea is this only.

// Lets just learn about pythagorean triplets a little more
// 1. 3, 4, 5 are the first pythagorean triplet
// 2. the triplet consists of all even numbers or two odd and one even. As square of odd is odd
// 3. creating pythagorean triplets: say a, b, c
//      (i). a= m^2 - n^2
//      (ii). b= 2mn
//      (iii). c= m^2 + n^2
//  where m and n are any natural numbers.

// Approach 2: Based on above observations we can certainly optimize aur previous approach.
//             given, a+ b+ c= 1000 => m^2 - n^2 + 2mn + m^2 + n^2= 1000
//             1000= 2m^2 + 2mn => 500= m^2 + mn => 500= m( m+ n) => (500- m^2)/m =n
//             Now, all we have to do is just iterate from m= [1, infinty)
//             and find the value of n. If it satisfies break the loop.


