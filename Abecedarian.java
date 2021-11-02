import java.util.Scanner;
import java.util.Arrays;

public class Abecedarian {
    public static void main(String[] args) throws Exception {

        Scanner in = new Scanner(System.in);

        System.out.println("Please enter a word.");
        String word = in.nextLine();

        if (isAlphabaticOrder(word))
            System.out.println(word + " is an abecedarian word.");
        else
            System.out.println(word + " is not an abecedarian word.");

    }

    /*
   // Function that checks whether
   // the string is in alphabetical
   // order or not*/
    static boolean isAlphabaticOrder(String s) {
        //length of the string
        int n = s.length();

        //create a character array
        //of the length of the string
        char c[] = new char[n];

        // assign the string
        // to character array
        for (int i = 0; i < n; i++) {
            c[i] = s.charAt(i);
        }

        // sort the character array
        Arrays.sort(c);

        // check if the character array
        // is equal to the string or not
        for (int i = 0; i < n; i++)
            if (c[i] != s.charAt(i))
                return false;

        return true;
    }
}
