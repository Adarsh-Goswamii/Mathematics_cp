/**
 *  PROBLEM 20:
 *  n! means n × (n − 1) × ... × 3 × 2 × 1
 *
 * For example, 10! = 10 × 9 × ... × 3 × 2 × 1 = 3628800,
 * and the sum of the digits in the number 10! is 3 + 6 + 2 + 8 + 8 + 0 + 0 = 27.
 *
 * Find the sum of the digits in the number 100!
 */

class Prob20
{
    static StringBuilder multiply(StringBuilder br, int n)
    {
        int carry=0;
        StringBuilder ans= new StringBuilder("");

        for(char c: br.toString().toCharArray())
        {
            int val= (c- 48)* n+ carry;
            carry= val/10;
            val= val%10;

            ans.append(val+"");
        }

        StringBuilder temp= new StringBuilder(carry+"");
        ans.append(temp.reverse().toString());

        return ans;
    }

    public static void main(String[] args)
    {
        StringBuilder br= new StringBuilder("1");
        for(int i=1;i<=100;i++)
            br= multiply(br, i);

        System.out.println(sum(br));
    }

    private static int sum(StringBuilder br)
    {
        int sum=0;

        for(char c: br.toString().toCharArray())
            sum+= (c-48);

        return sum;
    }
}