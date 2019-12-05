package matrix;

import java.util.Random;

public class Matrix {
    double[]data;
    int rows;
    int cols;
    boolean isEmpty=true;
    double[][] mat;
    public Matrix(int rows, int cols) throws IllegalArgumentException{
        if(rows<=0 || cols<=0) throw new IllegalArgumentException();
        this.rows = rows;
        this.cols = cols;
        data = new double[rows*cols];
        isEmpty =false;
    }
    public Matrix(double tab[][]) {
        cols = tab[0].length;
        rows = tab.length;
        for (int i=1;i<tab.length;i++) {
            int tempCols = tab[i].length;
            if(cols<tempCols) cols = tempCols;
        }
        data = new double[rows*cols];
        int g=0;
        for(int i=0;i<tab.length;i++) {
            int tempCols=0;
            for (int j=0;j<tab[i].length;j++) {
                tempCols= tab[i].length;
                data[g] = tab[i][j];
                g++;
            }
            for (int j=0;j<(cols - tempCols);j++) {
                data[g] = 0;
                g++;
            }
        }
        isEmpty= false;
    }
    double get(int r,int c) {
        return data[cols*r+c];
    }
    void set (int r,int c, double value) {
        data[cols*r+c] = value;
    }
    public String toString(){
        StringBuilder buf = new StringBuilder();
        buf.append("[");
        for(int i=0;i<rows;i++){
            buf.append("[");
            for (int j=0;j<cols;j++) {
                buf.append(data[cols*i+j]);
                if(j<cols-1)buf.append(", ");
            }
            buf.append("]");
            if(i<rows-1) buf.append(","+"\n");
        }
        buf.append("]");
        return buf.toString();
    }
    void reshape(int newRows,int newCols){
        if(rows*cols != newRows*newCols)
            throw new RuntimeException(String.format("%d x %d matrix can't be reshaped to %d x %d",rows,cols,newRows,newCols));

    }
    double[][] asArray() {
        double[][] matrix = new double[rows][cols];
        int g=0;
        for(int i=0;i<rows;i++) {
            for(int j=0;j<cols;j++) {
                matrix[i][j] = data[g];
                g++;
            }
        }
        mat = matrix;
        return matrix;
    }
    int[] shape() {
        return new int[]{rows,cols};
    }
    Matrix add(Matrix m){
        Matrix res = new Matrix(rows,cols);
        for (int i=0;i<rows*cols;i++) {
            res.data[i] = data[i]+m.data[i];
        }
        return res;
    }
    Matrix sub(Matrix m){
        Matrix res = new Matrix(rows,cols);
        for (int i=0;i<rows*cols;i++) {
            res.data[i] = data[i]-m.data[i];
        }
        return res;
    }
    Matrix mul(Matrix m){
        Matrix res = new Matrix(rows,cols);
        for (int i=0;i<rows*cols;i++) {
            res.data[i] = data[i]*m.data[i];
        }
        return res;
    }
    Matrix div(Matrix m){
        Matrix res = new Matrix(rows,cols);
        for (int i=0;i<rows*cols;i++) {
            res.data[i] = data[i]/m.data[i];
        }
        return res;
    }
    Matrix sub(double w){
        Matrix res = new Matrix(rows,cols);
        for (int i=0;i<rows*cols;i++) {
            res.data[i] = data[i]-w;
        }
        return res;
    }
    Matrix mul(double w){
        Matrix res = new Matrix(rows,cols);
        for (int i=0;i<rows*cols;i++) {
            res.data[i] = data[i]*w;
        }
        return res;
    }
    Matrix div(double w){
        Matrix res = new Matrix(rows,cols);
        for (int i=0;i<rows*cols;i++) {
            res.data[i] = data[i]/w;
        }
        return res;
    }
    Matrix add(double w){
        Matrix res = new Matrix(rows,cols);
        for (int i=0;i<rows*cols;i++) {
            res.data[i] = data[i]+w;
        }
        return res;
    }
    Matrix dot(Matrix m) {
        if(this.cols!=m.rows) throw new RuntimeException("error");
        else {
            Matrix res = new Matrix(this.rows,m.cols);
            int g=0;
            for (int i=0;i<res.rows;i++) {
                for (int j=0;j<res.cols;j++) {
                    for (int k=0;k<this.cols;k++) {
                        res.data[g] += this.data[this.cols*i+k]*m.data[j+2*k];
                    }
                    g++;
                }
            }
            return res;
        }
    }
    double frobenius() {
        double res=0;
        for(double i:data) {
            res+=i*i;
        }
        return res;
    }
    public static Matrix random(int rows, int cols){
        Matrix m = new Matrix(rows,cols);
        Random r = new Random();
        for(int i=0;i<rows;i++) {
            for(int j=0;j<cols;j++) {
                m.set(i,j,r.nextDouble());
            }
        }
        return m;
    }
    public static Matrix eye(int n){
        Matrix m = new Matrix(n,n);
        int i=0;
        while(i<n*n) {
            m.data[i]=1;
            i+=n+1;
        }
        return m;
    }

    public static void main(String[] args) throws RuntimeException
    {
        Matrix m = new Matrix(new double[][]{{1,2,3},{4,5,6}});
        Matrix m1 = new Matrix(new double[][]{{1,2},{3,4},{5,6}});
        System.out.println(m.div(m).frobenius());

    }
}