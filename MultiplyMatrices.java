/* MultiplyMatrices.java
Authors: Dohmen, RJH (i6250494)
         Schnabel, CT (i6255807)*/

/*Write a program MultiplyMatrices that can multiply square matrices
with integer entries. It should contain a method multiply with the following signature
to multiply two such matrices as well as a method to print a matrix on the screen:
public static int[][] multiply(int[][] matrixA, int[][] matrixB)
 */
import java.util.Random;
import java.util.Scanner;
// import java.io.*;
import java.util.Arrays;

//questions for Arman : what about I/O? how do we get input? Use methods from AddMatrices?
public class MultiplyMatrices {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        System.out.println("Enter the matrix size");
        int n = in.nextInt();  // matrix size is n
        int[][] matrixA = randomMatrix(n); //gets random matrix 1
        int[][] matrixB = randomMatrix(n); //gets random matrix 2

        //test matrices
//        int[][] matrixA = {{4,9,2},{0,0,7},{1,3,2}};
//        int[][] matrixB = {{5,6,0},{2,1,2},{9,6,1}};
//        int n = 3;
        //


        System.out.println("Matrix A:" );
        printMatrix(matrixA);
        System.out.println("Matrix B:" );
        printMatrix(matrixB);
        System.out.println("Matrix A * B:" );
        printMatrix(multiply(matrixA, matrixB));

//    int[][] resultMatrix = multiply(matrixA, matrixB)
//            printMatrix(resultMatrix);

        } //close main

    public static void printMatrix(int[][] matrix){
        for (int[] ints : matrix) System.out.println(Arrays.toString(ints));
    } //close print matrix method

    // returns an array of length n containing random double values
    public static int[][] randomMatrix(int n){
        Random random = new Random();
        int[][] matrix = new int[n][n];
        for (int[] row: matrix) {
            Arrays.fill(row, random.nextInt());
        }
        return matrix;
    } //close method

    public static int[][] multiply(int[][] matrixA, int[][] matrixB) {
        int[][] product;
        //get matrix dimensions
        int rowsA = matrixA.length;
        int colsA = matrixA[0].length;
        int rowsB = matrixB.length;
        int colsB = matrixB[0].length;

        if (colsA == rowsB) {
            product = new int[rowsA][colsB];
//            for (int i = 0; i < rowsA; i++) {
//                for (int j = 0; j < colsB; j++) {
//                    product[i][j] = matrixA[i][j] * matrixB[i][j];
//                }
//            }
            //multiplying and printing multiplication of 2 matrices
            for(int i=0 ;i < colsA; i++){ //row loop
                for(int j=0; j < rowsB; j++){ //col loop
                    product[i][j]=0; //initialize
                    for(int k=0 ; k < rowsA ; k++) { //running index given specific row and col position
                        product[i][j]+=matrixA[i][k] * matrixB[k][j];
                    }//end of k loop
                }//end of col loop
            } //end of row loop


        } else {
            product = null;
        }

        return product;

    } //close method



} //close class
