/* PROB 4
A palindromic number reads the same both ways. The largest palindrome made
from the product of two 2-digit numbers is 9009 = 91 × 99.
Find the largest palindrome made from the product of two 3-digit numbers.
 */

import java.io.*;
class Prob4
{
    static PrintWriter w=new PrintWriter(System.out);
    public static void main(String args[])
    {
        int ans=0;
        for(int i=999;i>=100;i--)
            for(int j=999;j>=100;j--)
                if(palin(i*j))
                {
                    ans= Math.max(ans, i*j);
                    break;
                }
        w.println(ans);
        w.close();
    }

    static boolean palin(int n)
    {
        int temp=0, rev=n;
        while(n!=0)
        {
            temp= temp*10+ (n%10);
            n/=10;
        }
        return (rev== temp);
    }
}

// Approach 1: iterate from 100 to 999 O(n^2)
// Approach 2: Check for the first and last digit if they match || first+1(carry) = last.
//             Multiplication is costly operation this can reduce many multiplications.
// Approach 3: We already know our ans lies between 999*999 and 10000 so just iterate from back. This
// seems ok but its not necessary that if u find a palin there exits some 3 digits value for which
// it product is palindrome.