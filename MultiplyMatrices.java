/* MultiplyMatrices.java
Authors: Dohmen, RJH (i6250494)
         Schnabel, CT (i6255807)*/

/*Write a program MultiplyMatrices that can multiply square matrices
with integer entries. It should contain a method multiply with the following signature
to multiply two such matrices as well as a method to print a matrix on the screen:
public static int[][] multiply(int[][] matrixA, int[][] matrixB)
 */
import java.util.Scanner;
import java.io.*;

//questions for Arman : what about I/O? how do we get input? Use methods from AddMatrices?
public class MultiplyMatrices {

    public static void main(String[] args) {

        String filenameMatrix1 = args[0];
        String filenameMatrix2 = args[1];

        int[][] matrix1 = null;
        int[][] matrix2 = null;
        int[][] product = null;

        try{
            matrix1 = readMatrix(filenameMatrix1);
            matrix2 = readMatrix(filenameMatrix2);
            product = multiply(matrix1, matrix2);
        }
        catch (FileNotFoundException e){
            e.printStackTrace();
        }
        try{
            writeMatrix(product, "sumOfMatrices.txt");
        }
        catch (FileNotFoundException e){
            e.printStackTrace();
        }
    }

    public static int[][] multiply(int[][] matrixA, int[][] matrixB) {
        int[][] product;
        //get matrix dimensions
        int rowsA = matrixA.length;
        int colsA= matrixA[0].length;
        int rowsB = matrixB.length;
        int colsB = matrixB[0].length;

        if (colsA == rowsB){


            product = new int[rowsA][colsB];
            for (int i=0;i<rowsA;i++){
                for (int j=0;j<colsB;j++){
                    product[i][j] = matrixA[i][j] * matrixB[i][j];
                }
            }


        } else {
            product = null;
        }

       return product;

    } //close method

    public static int[][] readMatrix(String filename)
            throws java.io.FileNotFoundException{
        File file = new File(filename);
        Scanner input = new Scanner (file);

        int rows = input.nextInt();
        int columns = input.nextInt();

        int[][] matrix = new int[rows][columns];

        for (int i=0;i<rows;i++){
            for (int j=0;j<columns;j++){
                matrix [i] [j]= input.nextInt();

            }
        }

        input.close();
        return matrix;
    } //close method

    public static void writeMatrix(int[][] matrix, String filename)
            throws java.io.FileNotFoundException{
        File output = new File(filename);
        PrintWriter printer = new PrintWriter(output);
        // write dimensions of matrix at beginning of file
        printer.write(matrix.length +"\r\n");
        printer.write(matrix[0].length +"\r\n");

        for (int i=0;i<matrix.length;i++){
            for (int j=0;j<matrix[0].length;j++){
                printer.write(matrix[i][j]+" ");
            }
            printer.write("\r\n");
        }

        printer.close ();
    } // end of writeMatrix method

} //close class
