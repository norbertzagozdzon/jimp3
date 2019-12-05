package matrix;

import org.junit.Test;

import static org.junit.Assert.*;

public class MatrixTest {

    @Test
    public void Matrix() {
        Matrix m = new Matrix(2,3);
        assertEquals(m.rows,2);
        assertEquals(m.cols,3);
        try {
            Matrix m1 = new Matrix(0,2);
            fail("no exception thrown");
        } catch (IllegalArgumentException e) {
            System.out.println("expcetion catched");;
        }
    }
    @Test
    public void MatrixDoubleArray() {
        Matrix m = new Matrix(new double[][]{{1,2},{3,4,5}});
        double[][] t = m.asArray();
        assertEquals(m.cols,3);
        assertEquals(t[0][2],0,1e-5);
    }
    @Test
    public void get() {
        Matrix m  = new Matrix(new double[][]{{1,2,3},{4,5,6}});
        assertEquals(m.get(0,0),1,1e-5);
        assertEquals(m.get(0,2),3,1e-5);
        assertEquals(m.get(1,1),5,1e-5);
    }

    @Test
    public void set() {
        Matrix m  = new Matrix(2,2);
        m.set(1,1,5);
        assertEquals(m.get(1,1),5,1e-5);
    }

    @Test
    public void testToString() {
        String s= "[[1.0,2.3,4.56], [12.3,  45, 21.8]]";
        s= s.replaceAll("(\\[|\\]|\\s)+","");
        String[] t = s.split("(,)+");
        for(String x:t){
            System.out.println(String.format("\'%s\'",x ));
        }

        double[]d=new double[t.length];
        for(int i=0;i<t.length;i++) {
            d[i] = Double.parseDouble(t[i]);
        }

        double arr[][]=new double[1][];
        arr[0]=d;

        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[i].length;j++){
                System.out.println(arr[i][j]);
            }
        }
    }

    @Test
    public void reshape() {
        Matrix m = new Matrix(2,3);
        try {
            m.reshape(5, 4);
            fail("no exception thrown");
        }
        catch(RuntimeException e) {
            System.out.println("exception catched");
        }
    }

    @Test
    public void asArray() {
        double[][] d = new double[][]{{1,2,3},{4,5,6}};
        Matrix m = new Matrix(d);
        double[][] maA = m.asArray();
        assertEquals(d[0][0],maA[0][0],1e-5);
        assertEquals(d[0][2],maA[0][2],1e-5);
        assertEquals(d[1][1],maA[1][1],1e-5);
    }

    @Test
    public void shape() {
    }

    @Test
    public void add() {
        Matrix m = new Matrix(new double[][]{{1,2},{3,4}});
        assertEquals(m.add(m).mul(-1).add(m.add(m)).frobenius(),0,1e-5);
    }

    @Test
    public void sub() {
        Matrix m = new Matrix(new double[][]{{1,2},{3,4}});
        assertEquals(m.sub(m).frobenius(),0,1e-5);
    }

    @Test
    public void mul() {
        Matrix m = new Matrix(new double[][]{{1,2},{3,4}});
        assertEquals(m.mul(m).mul(-1).add(m.mul(m)).frobenius(),0,1e-5);
    }

    @Test
    public void div() {
        Matrix m = new Matrix(new double[][]{{1,2},{3,4}});
        assertEquals(m.div(m).frobenius(),m.rows*m.cols,1e-5);
    }

    @Test
    public void sub1() {
    }

    @Test
    public void mul1() {
    }

    @Test
    public void div1() {
    }

    @Test
    public void add1() {
    }

    @Test
    public void dot() {
    }

    @Test
    public void frobenius() {
    }

    @Test
    public void main() {
    }
    @Test
    public void eye() {
        Matrix m = Matrix.eye(3);
        assertEquals(m.frobenius(),3,1e-5);
    }
}