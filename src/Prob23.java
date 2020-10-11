import java.util.HashSet;

/**
 * PROBLEM 23:
 * A perfect number is a number for which the sum of its proper divisors is
 * exactly equal to the number. For example, the sum of the proper divisors
 * of 28 would be 1 + 2 + 4 + 7 + 14 = 28, which means that 28 is a perfect
 * number.
 *
 * A number n is called deficient if the sum of its proper divisors is less
 * than n and it is called abundant if this sum exceeds n.
 *
 * As 12 is the smallest abundant number, 1 + 2 + 3 + 4 + 6 = 16, the smallest
 * number that can be written as the sum of two abundant numbers is 24.
 * By mathematical analysis, it can be shown that all integers greater than
 * 28123 can be written as the sum of two abundant numbers. However,
 * this upper limit cannot be reduced any further by analysis even though
 * it is known that the greatest number that cannot be expressed as the sum
 * of two abundant numbers is less than this limit.
 *
 * Find the sum of all the positive integers which cannot be written as the
 * sum of two abundant numbers.
 */

class Prob23
{
    public static void main(String[] args)
    {
        HashSet<Integer> set= new HashSet<>();
        for(int i=1;i<=28123;i++)
        {
            int factors_sum= factor(i);
            if(factors_sum> i)
                set.add(i);
        }

        int sum=0;
        for(int i=1;i<=28123;i++)
        {
            boolean possible = false;
            for(Integer j: set)
                if(set.contains(i-j))
                    possible= true;

            sum+= possible?0: i;
        }

        System.out.println(sum);
    }

    private static int factor(int n)
    {
        int sum=0;
        int sqrt= (int)Math.sqrt(n);
        for(int i=2;i*i<=n;i++)
            if(n%i==0)
                sum+= i+ ((n/i)> sqrt? (n/i): 0);

        return sum+1;
    }
}
/**
 * OBSERVATIONS:
 * (i). For sure no greater than 28123 can be represented as sum of two
 * abundant numbers.
 * (ii). But its not sure that all the numbers smaller than that can be
 * represented as abundant numbers as well.
 *
 * APPROACH:
 * * we will traverse till 28123 find the abundant numbers
 * * then we will check which no cant be represented as sum of two numbers.
 *
 * OPTIMIZATIONS:
 * (i). We can either use sorting which will help us find whether we
 * can represent or not in O(n) time for any no. (Two pointer approach)
 * (ii). We can use hashing that will also cost O(n) time for each number
 * but there is no overhead of sorting.
 */
