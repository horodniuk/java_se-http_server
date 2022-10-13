package lecture1_oop_classes_encapsulation.hometask.matrix;

public class Matrix {
    private final int rows;
    private final int cols;
    private double[][] tableCell;

    public Matrix(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.tableCell = new double[rows][cols];
    }

    public double[][] getTableCell() {
        return tableCell;
    }

    public int getRows() {
        return rows;
    }

    public int getCols() {
        return cols;
    }

    public void fill(double value) {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                tableCell[i][j] = value;
            }
        }
    }


    public void print() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(tableCell[i][j] + " ");
            }
            System.out.println();
        }
    }


    public Matrix transpose() {
        Matrix m = new Matrix(cols, rows);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                m.tableCell[j][i] = this.tableCell[i][j];
            }
        }
        return m;
    }
}
