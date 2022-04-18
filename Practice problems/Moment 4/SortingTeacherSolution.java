/* PSEUDO CODE
 * len = the length of the array a
 * goes from 0 to len - 1
 *     max = i
 *     k goes from i + 1 to len
 *         om a [k]> a [max]
 *             max = k
 *     temp = a [i]
 *     a [i] = a [max]
 *     a [max] = temp
 */

public class SortingTeacherSolution 
{
    public static void main (String [] args)
    {
        // Variable declaration
    
        int [] a = new int [30];
        int len = a.length;
        int max = 0;
        int temp = 0;
    
        // Random
        for (int i = 0; i <len; i ++)
        {
            a [i] = (int) (Math.random () * 100) +1;
        }
    
        // Print unsorted
        for (int i = 0; i <len; i ++)
        {
            System.out.print (a [i] + " ");
        }
        System.out.println ();
    
        // Sorting
        for (int i = 0; i <len-1; i ++)
        {
            max = i;
            for (int k = i + 1; k <len; k ++)
            {
                if (a [k]> a [max])
                {
                     max = k;
                }
            }
            // Switches places in two places in the array
            temp = a [i];
            a [i] = a [max];
            a [max] = temp;
        }
    
        // Print sorted
        for (int i = 0; i <len; i ++)
        {
            System.out.print (a [i] + " ");
        }
    }
}
