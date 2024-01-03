// Lab 3 Matrix class
// Name: Xianzhi Wang

import java.util.Random;

public class Matrix {
    // Largest random value in Matrix will be MAX_VALUE-1
    private static final int MAX_VALUE = 10;

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
        return (matrix.length == 0) ? 0 : matrix[0].length;
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

    // Get value at row r and column c
    public double getValue(int r, int c) {
        return matrix[r][c];
    }

    // Set value at row r and column c
    public void setValue(int r, int c, double value) {
        matrix[r][c] = value;
    }

    // Return product of this and other
    public Matrix multiply(Matrix other) {

        int newRow = this.numRows();
        int newCol = other.numCols();
        int innerDim = this.numCols();
        Matrix product = new Matrix(newRow, newCol);
        for (int r = 0; r < newRow; r++) {
            for (int c = 0; c < newCol; c++) {
                double m = 0.0;
                for (int k = 0; k < innerDim; k++) {
                    m += this.getValue(r, k) * other.getValue(k, c);

                }
                product.setValue(r, c, m);
                // product.matrix[r][c] = m;
            }
        }
        
        return product;
    }


    // main method to test Matrix class
    public static void main(String[] args) {
        Matrix a = new Matrix(2, 3);
        Matrix b = new Matrix(3, 2);
        a.fillMatrix();
        b.fillMatrix();
        Matrix product = a.multiply(b);
        System.out.println(a);
        System.out.println(b);
        System.out.println(product);
    }

}