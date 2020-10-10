/**
 * PROBLEM 21:
 * Let d(n) be defined as the sum of proper divisors of n (numbers less than n which divide
 * evenly into n).
 * If d(a) = b and d(b) = a, where a ≠ b, then a and b are an amicable pair and each
 * of a and b are called amicable numbers.
 *
 * For example, the proper divisors of 220 are 1, 2, 4, 5, 10, 11, 20, 22, 44, 55 and 110;
 * therefore d(220) = 284. The proper divisors of 284 are 1, 2, 4, 71 and 142;
 * so d(284) = 220.

 * Evaluate the sum of all the amicable numbers under 10000.
 */

class Prob21
{
    public static void main(String[] args)
    {
        int[] arr= new int[10001];
        for(int i=1;i<=10000;i++)
        {
            int sum=0;
            for(int j=1;j*j<= i;j++)
                if(i%j==0)
                    sum+= j + ((i/j)> Math.sqrt(i)?(i/j): 0);

            arr[i]= sum-i;
        }
        System.out.println(arr[220]);
        long ans=0;
        for(int i=1;i<=10000;i++)
        {
            int val= arr[i];
            if(val<=10000 && arr[val]== i && i!=val)
                ans+= val;
        }

        System.out.println(ans);
    }
}

/**
 * Intuition: We need to find all the factors of number and
 * as the no is 10,000 we can just find sum of factors for
 * every number. And then check for pairs
 *
 * But that will be of complexity O(10^8).
 * Well we can obviously do that without any problem.
 *
 * We can surely do some minor optimizations
 * (i). from O(n^2) to O(n* sqrt(n))
 */