/*RunTimesMatrixMulitplication.java
        Authors: Dohmen, RJH (i6250494)
        Schnabel, CT (i6255807)

        Write a program RunTimesMatrixMultiplication that can test the runtime
        of the matrix multiplication method that you implemented in week 3. Try to
        determine a relationship between the size of the matrices and the runtime. */

import java.util.Random;
import java.util.Scanner;
import java.util.Arrays;
public class RunTimesMatrixMultiplication {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        System.out.println("Enter the matrix size");
        int n = in.nextInt();  // matrix size is n
        int[][] matrixA = randomMatrix(n); //gets random matrix A
        int[][] matrixB = randomMatrix(n); //gets random matrix B

        System.out.println("Matrix A:" );
        printMatrix(matrixA);
        System.out.println("Matrix B:" );
        printMatrix(matrixB);
        double starttime = System.currentTimeMillis();
        System.out.println("Matrix A * B:" );
        printMatrix(multiply(matrixA, matrixB));
        double endtime = System.currentTimeMillis();
        System.out.println("The method took " + (endtime - starttime) + " milliseconds.");

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
