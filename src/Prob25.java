/**
 * PROBLEM 25:
 * The Fibonacci sequence is defined by the recurrence relation:
 *
 * Fn = Fn−1 + Fn−2, where F1 = 1 and F2 = 1.
 * Hence the first 12 terms will be:
 *
 * F1 = 1
 * F2 = 1
 * F3 = 2
 * F4 = 3
 * F5 = 5
 * F6 = 8
 * F7 = 13
 * F8 = 21
 * F9 = 34
 * F10 = 55
 * F11 = 89
 * F12 = 144
 * The 12th term, F12, is the first term to contain three digits.
 *
 * What is the index of the first term in the Fibonacci sequence to contain
 * 1000 digits?
 */

class Prob25
{
    public static void main(String[] args)
    {
        StringBuilder num1= new StringBuilder("1");
        StringBuilder num2= new StringBuilder("1");

        int i=3;
        while(true)
        {
            StringBuilder temp= new StringBuilder(num2);
            num2= add(num1, num2);
            num1= new StringBuilder(temp);

            //System.out.println(num2);
            if(num2.length()== 1000)
                break;

            i++;
        }

        System.out.print(i);
    }

    private static StringBuilder add(StringBuilder num1, StringBuilder num2)
    {
        int i, carry=0;
        StringBuilder ret= new StringBuilder("");
        for(i=0;i<num1.length();i++)
        {
            int val= (num1.charAt(i)-48)+ (num2.charAt(i)- 48)+ carry;
            carry= val/10;
            val= val%10;

            ret.append(val);
        }

        for(;i<num2.length();i++)
        {
            int val= (num2.charAt(i)- 48)+ carry;
            carry= val/10;
            val= val%10;

            ret.append(val);
        }

        if(carry!=0)
            ret.append(carry);

        return ret;
    }
}

/**
 * OBSERVATIONS:
 * Obviously we cant calculate fibonacci no till 1000 digits appear
 * due to limited space to store the number.
 *
 * APPROACH 1:
 * As we have seen earlier also we can use strings for big number and here
 * also we can do it without TLE.
 * * Just gonna need a func(String num1, String num2): that returns
 * the num1+ num2 in string format.
 *
 * But lets first check if there is any other efficient approach or not .
 *
 * HYPOTHESIS 1: There can be some pattern (WRONG)
 * 1:0, 1:1, 2:2, 3:3, 5:4, 8:5, 13:6, 21:7, 34:8, 55:9, 89:10, 144:11,
 * 233:12, 377:13, 610:14, 987:15, 1597:16, 2584:17, 4181:18, 6765:19, 10946:20,
 * 17711:21, 28657:22, 46368:23, 75025:24, 121393:25, 196418:26,
 * 317811:27, 514229:28, 832040:29, 1346269:30, 2178309:31, 3524578:32,
 * 5702887:33, 9227465:34, 14930352:35, 24157817:36, 39088169:37,
 * 63245986:38, 102334155:39, 165580141:40, 267914296:41, 433494437:42,
 * 701408733:43, 1134903170:44, 1836311903:45, 2971215073:46,
 * 4807526976:47, 7778742049:48, 12586269025:49.
 *
 * these  are the first 50 fibonacci number.
 *
 * 1 digit at = 1
 * 2 digit at = 7
 * 3 digit at = 12
 * 4 digit at = 17
 * 5 digit at = 21
 * 6 digit at = 26
 * 7 digit at = 31
 * 8 digit at = 36
 * 9 digit at = 40
 * 10 digit at = 45
 * 11 digit at = 50
 *
 * we have the series
 * 1, 7, 12, 17, 21, 26, 31, 36, 40, 45, 50, 55, 60, 64, 69............
 * difference between them makes a series
 * 6, 5, 5, 4, 5, 5, 5, 4, 5, 5, 5, 5, 4, 5, ..............
 *
 * I think there is a pattern neglecting the 1st term of difference series.
 *
 * Nevermind.
 *
 * HYPOTHESIS 2: Maybe we can use the Golden ratio to find the ans more
 * efficiently.
 *
 * TODO: Find some relation between the ans and the golden ratio.
 */

/**
 * GAINED:
 * Apparently if we divide any two consecutive numbers the ratio which we
 * get is very close to the GOLDEN RATIO= 1.618034....
 *
 * So whats is actually this golden ratio?
 * Basically we get this golden ratio when we divide a line
 * Such that a/b = c/a
 *      more formally: bigger part/ smaller part = original line/ bigger part
 *          c="--------------------------------------"
 *          a="-----------------------"  b="---------------"
 *
 * here line is c which is divided into two parts a, b.
 * a is the bigger one and b is the smaller one.
 *
 * How to use golden ratio to calculate the nth fibonacci number?
 *   FORMULA: fibonacci(n)= ((GR)^n - (1- GR)^n)/Math.sqrt(5).
 *
 *   fib(n)= (( 1.618034... )^n -( -0.618034... )^n)/Math.sqrt(5).
 */