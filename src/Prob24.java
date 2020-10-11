import java.util.ArrayList;
import java.util.Arrays;

/**
 * PROBLEM 24:
 * A permutation is an ordered arrangement of objects. For example, 3124 is
 * one possible permutation of the digits 1, 2, 3 and 4. If all of the
 * permutations are listed numerically or alphabetically, we call it
 * lexicographic order. The lexicographic permutations of 0, 1 and 2 are:
 *
 * 012   021   102   120   201   210
 *
 * What is the millionth lexicographic permutation of the digits
 * 0, 1, 2, 3, 4, 5, 6, 7, 8 and 9?
 */

class Prob24
{
    public static void main(String[] args)
    {
        int[] fact= new int[10];
        fact[0]= 1;
        for(int i=1;i<=9;i++)
            fact[i]= fact[i-1]*i;

        int val= 1000000-1, i=9;
        StringBuilder br= new StringBuilder("");
        ArrayList<Integer> arr= new ArrayList<>(Arrays.asList(0,1,2,3,4,5,6,7,8,9));
        while(i!=-1)
        {
            int num= val/fact[i];
            br.append(arr.get(num));
            arr.remove(num);
            val= val% fact[i];
            System.out.println(fact[i]+" "+val);
            i--;
        }
        System.out.println(br);
    }
}
/**
 * 1 million= 1,000,000
 *
 * INTUITION:
 * We can actually start writing all the permutations lexicographically
 * till we get the 1 millionth permutation. It wont be out of time complexity
 *
 * But we can actually solve this using a little bit of maths lets see how:
 *  0                                                      = 1
 *  01    10                                               = 2*1
 *  012   021   102   120   201   210                      = 3*2
 *  0123  0132  0213  0231  0312  0321  1..........        = 6*4
 *
 *  1, 2, 6, 24, 120, 720,................... basically n!
 *
 *  coming back to the main problem which has 10 digits
 *  all that start with 0 are in total 9!= 362880
 *  all that start with <=1 are in total = 725760
 *  all that start with <=2 are in total = 1088640
 *
 *  which is greater than 1 million so our 1 millionth permutation
 *  starts with 2
 *
 *  Similarly for other digits...............................
 *  Can be done without a program but thats not flexible.
 *
 *  FOR SIMPLICITY:
 *  Basically what num has is the index of the number which will occur at
 *  particular position.
 *  like at 1st position 2 occurs
 *
 *  then its important to remove 2 from ArrayList<> of remaining number
 *  as its a permutation and if we don't remove the number that are occuring
 *  then we will repeat certain numbers.
 */