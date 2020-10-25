import java.util.HashSet;

/**
 *  PROBLEM 27:
 *  https://projecteuler.net/problem=27
 */

class Prob27
{
    static HashSet<Integer> primes= new HashSet<>();
    static HashSet<Integer> composite= new HashSet<>();
    public static void main(String[] args)
    {
        int ans=-1, max=-1;
        for(int a= -999;a<1000;a++)
        {
            for(int b= (a<0? Math.abs(a)+1 : 2);b<=1000;b++)
            {
                int count=0;
                for(int n=0;n<b;n++)
                {
                    int val= n*n + a*n + b;
                    if(val>0 && prime(val))
                    {
                        count++;
                    }
                    else
                        break;
                }

                if(max< count)
                {
                    max= count;
                    ans= a*b;
                }
            }
        }
        System.out.println(ans+" "+max);
    }

    static boolean prime(int n)
    {
        if(primes.contains(n))
            return true;
        if(composite.contains(n))
            return false;

        if(n%2==0)
        { composite.add(n); return false; }
        else
        {
            for(int i=3;i*i<= n;i+=2)
                if(n%i==0)
                { composite.add(n); return false; }

            primes.add(n);
            return true;
        }
    }
}

/**
 * SOLUTION:
 *
 * So we have 2000 possible values for a and b.
 * a,b belongs (-1000, 1000)
 *
 * Quadratic equation: n^2+ a*n+ b.
 *
 * If we go for all possible combinations of a and b (brute force)
 * we will get some TLE as there are 2000*2000 quadratic eq for which
 * we give values of n and then check for prime.
 *
 * So we have to generate all the possible quadratic equations and then
 * just keep on putting value of n until we get a value which is not
 * prime.
 *
 * OBSERVATIONS:
 *
 * 1. for any particular equation the max value of n can be b-1.why?
 * n^2: if divisible by n
 * a*n: is divisible by n
 * b: so if b is also divisible by n then obviously the result will
 * not be a prime number.
 *
 * 2. As the value of n will start from 0.
 * n^2: 0
 * a*n: 0
 * b so we need to take b as prime number or else the quadratic
 * equation will fail in generating a prime number for the very first
 * value for n.
 *
 * 3. By the definition of prime numbers -ive no are not considered as
 * prime numbers
 * So for value of -ive a, b obviously can't be negative and moreover
 * b has to be greater than abs(a).
 *
 * * we can also use sieve for finding the primes before hand
 * as max value will be 2*10^6.
 */