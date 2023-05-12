/* There are n students in a class numbered from 0 to n - 1. The teacher will give each student a problem starting 
with the student number 0, then the student number 1, and so on until the teacher reaches the student number n - 1. 
After that, the teacher will restart the process, starting with the student number 0 again. You are given a 
0-indexed integer array chalk and an integer k. There are initially k pieces of chalk. When the student number i 
is given a problem to solve, they will use chalk[i] pieces of chalk to solve that problem. However, if the current 
number of chalk pieces is strictly less than chalk[i], then the student number i will be asked to replace the chalk.
Return the index of the student that will replace the chalk pieces. 
* Eg 1 : chalks = [5,1,5]            k = 22               Output = 0
* Eg 2 : chalks = [3,4,1,2]          k = 25               Output = 1
*/
import java.util.*;
public class Chalk
{
      public int ChalkReplace(int chalks[], int k)
      {
            int sum = 0;      // Variable for Sum...
            int index = 0;    // Variable to get student index...  //*  Variable -> O(1)
            while(sum < k)    //! Comparison -> O(N)
            {
                  if(index > chalks.length - 1)
                        index = 0;     // If last student is done, then move to first student again...
                  sum = sum + chalks[index];
                  index++;     // Incrementing student index...
            }
            if(index == chalks.length)
                  return 0;
            return index - 1;
      }
      public static void main(String args[])
      {
            Scanner sc = new Scanner(System.in);
            int x;
            System.out.print("Enter number of students : ");
            x = sc.nextInt();
            int student[] = new int[x];
            for(int i = 0; i < student.length; i++)
            {
                  System.out.print("Enter chalk value for "+(i+1)+" th student : ");
                  student[i] = sc.nextInt();
            }
            System.out.print("Enter number of chalks provided : ");
            x = sc.nextInt();
            Chalk chalk = new Chalk();       // Object creation...
            System.out.print("Index of Student : "+chalk.ChalkReplace(student, x));    // Function called...
            sc.close();
      }
}



//! Time Complexity - O(N)
//* Space Complexity - O(1)

/** //? DEDUCTIONS :-
 * ? We keep on iterating the array repeatedly unless and until the numberof chalks are exhausted...
 */