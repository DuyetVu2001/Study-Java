package ex2;

import java.util.Arrays;

public class B11 {
    static void toSpiral(int a[][], int sort[], int m, int n) {

        // k - starting row index
        // m - ending row index
        // l - starting column index
        // n - ending column index
        int k = 0, l = 0;
        int index = 0;

        while (k < m && l < n) {
            for (int i = l; i < n; ++i) {
                a[k][i] = sort[index];
                index++;
            }
            k++;

            for (int i = k; i < m; ++i) {
                a[i][n - 1] = sort[index];
                index++;
            }
            n--;

            if (k < m) {
                for (int i = n - 1; i >= 0; --i) {
                    a[m - 1][i] = sort[index];
                    index++;
                }
                m--;
            }

            if (l < n) {
                for (int i = m - 1; i >= 0 ; --i) {
                    a[i][l] = sort[index];
                    index++;
                }
                l++;
            }
        }
    }

    public static void printMatrix(int a[][], int m, int n) {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(a[i][j]);
                System.out.print("  ");
            }
            System.out.println();
        }
    }

    public static int[] convert2Dto1D(int a[][], int m, int n) {
        int index = 0;
        int x[] = new int[m * n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                x[index] = a[i][j];
                index++;
            }
        }
        return x;
    }

    public static int[] sortArray(int x[]) {
        Arrays.sort(x);
        return x;
    }
    public static void convertMatrixToSortedSpiral(int a[][], int m, int n) {
        int[][] b = new int[100][100];
        int[] x = new int[m * n];

        x = convert2Dto1D(a, m, n);
        x = sortArray(x);
        toSpiral(b, x, m, n);
        printMatrix(b, m, n);
    }

    public static void main(String[] args) {
        int[][] a = {
                {2, 5, 3},
                {1, 8, 4},
                {6, 7, 9},

        };
        int m = a.length, n = a[0].length;

        System.out.println("Original Matrix: ");
        printMatrix(a, m, n);

        System.out.println("Matrix After Spiral Arrangement: ");
        convertMatrixToSortedSpiral(a, m, n);

    }
}
