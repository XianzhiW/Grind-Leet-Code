// Lab 3 Matrix class
// Name: Xianzhi Wang

import java.util.Random;
/**
 * a Matrix class
 */

public class Matrix {
    // Largest random value in Matrix will be MAX_VALUE-1
    private static final int MAX_VALUE = 3;

    private double[][] matrix;

    // Constructor initializes an empty matrix
    public Matrix(int numRows, int numCols) {
        matrix = new double[numRows][numCols];
    }

    // Fill Matrix with random small integers for testing
    public void fillMatrix() {
        Random rand = new Random();
        for (int r = 0; r < numRows(); r++) {
            for (int c = 0; c < numCols(); c++) {
                matrix[r][c] = rand.nextInt(MAX_VALUE);
            }
        }
    }

    // Return number of rows in Matrix object
    public int numRows() {
        return matrix.length;
    }

    // Return number of columns in Matrix object
    public int numCols() {
        return matrix[0].length;
    }

    // Return String representation of Matrix object
    public String toString() {
        String m = "";
        for (int r = 0; r < numRows(); r++) {
            for (int c = 0; c < numCols(); c++) {
                m += matrix[r][c] + "  ";
            }
            m += "\n";
        }
        return m;
    }

    // Return product of this and other
    public Matrix multiply(Matrix other) {

        int newRow = this.numRows();
        int newCol = other.numCols();
        int innerDim = this.numCols();
        Matrix product = new Matrix(newRow, newCol);
        for (int r = 0; r < newRow; r++) {
            for (int c = 0; c < newCol; c++) {
                int m = 0;
                for (int k = 0; k < innerDim; k++) {
                    m += matrix[r][k] * other.matrix[k][c];

                }
                product.matrix[r][c] = m;
            }
        }





        return product;
    }


    // main method to test Matrix class
    public static void main(String[] args) {
        // Matrix a = new Matrix(2, 3);
        // Matrix b = new Matrix(3, 2);
        // a.fillMatrix();
        // b.fillMatrix();
        // Matrix product = a.multiply(b);
        // System.out.println(a);
        // System.out.println(b);
        // System.out.println(product);
        int[] numbers = new int[10];
        numbers[0] = 35;
        numbers[1] = 37;
        numbers[1] = numbers[0] + 4;
        numbers[2] = 0;
        numbers[3] = 0;
        numbers[4] = 0;
        numbers[5] = 0;
        numbers[6] = 0;
        numbers[7] = 0;
        numbers[8] = 0;
        numbers[9] = 0;
        System.out.println(numbers[1]);
    }

}