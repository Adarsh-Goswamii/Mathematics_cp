/**
 * PROBLEM 16:
 * 2^15 = 32768 and the sum of its digits is 3 + 2 + 7 + 6 + 8 = 26.
 *
 * What is the sum of the digits of the number 2^1000?
 */

class Prob16
{
    // This function takes flipped word as input i.e hundred= 001.
    static StringBuilder multiply(StringBuilder br)
    {
        int carry=0;
        StringBuilder ans= new StringBuilder("");
        for(char c: br.toString().toCharArray())
        {
            int n= (c- 48) *2 + carry;
            if(n>=10)
            { carry=1; n-= 10; }
            else
                carry=0;

            ans.append(n+"");
        }
        if(carry==1)
            ans.append('1');

        return ans;
    }

    static int sum(StringBuilder br)
    {
        int ans=0;
        for(char c: br.toString().toCharArray())
            ans+= (c- 48);

        return ans;
    }

    public static void main(String[] args)
    {
        StringBuilder br= new StringBuilder("1");
        for(int i=1;i<=1000;i++)
            br= multiply(br);

        System.out.println(sum(br));
    }
}

/**
 * 1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024, 2048........
 * there has to be some relation:
 * (i). we cant possibly compute 2^1000
 *
 * So the only possibility left is that there is
 * some sort of trick behind this. Just need to figure it out
 * (i). Hypothesis: maybe there is a pattern that repeats after some
 * numbers.
 *     1, 2, 4, 8, 7, 5, 10, 11, 13, 8, 7, 14...........
 *   there seems to be no relation or pattern in sum of digits.
 *
 *   ones place: (pattern found)
 *     1, 2, 4, 8, 6, 2, 4, 8, 6, 2, 4, 8, .............
 *   Tens place: ()
 *     1, 3, 6, 2, 5, 1, 2, 4,
 *   nah how would we know how long 2^1000 is.
 *
 * (ii). Hypothesis: Come to think of it we can actually store 2^1000
 * all we need is
 *     * a function that take a string(number) and multiplies it with 2.
 *     * a function to calculate the sum of string(number) char wise.
 * Complexity wont we that high as we will just call the function 1000 times
 * and 2^64 is just of length 18. I think this should work.
 */