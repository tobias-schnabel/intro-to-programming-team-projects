import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class PercentEven {
    public static void main(String[] args) throws Exception {

        System.out.print("Enter the length of the array: ");
        Scanner in = new Scanner(System.in);
            int n = in.nextInt();

        //assigns a name to the returned array of randomIntArray
        //as different iterations yield different arrays
        int[] randomArray;
            randomArray = randomIntArray(n);
        
        System.out.println("The array is: " + Arrays.toString(randomArray));
        System.out.println(percentEven(randomArray, n) + "% of its numbers are even");
    }

    public static int[] randomIntArray(int n){
        //produces an array of length n containing random integers
        Random random = new Random();
        int[] array = new int[n];
        for(int i=0; i < n; i++){
           array[i] = random.nextInt();
        }
        return array;
     }

     public static double percentEven(int[] values, int n){
        //loop checks for each element in the array whether it is an even number
        int counter = 0;
        for (int value : values){
            if (value % 2 == 0){
                counter++;
            }
        }
        double percentEven = 100 * counter / n;
        return percentEven;
     }
}
