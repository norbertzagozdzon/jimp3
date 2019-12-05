package lab5;

import org.junit.Test;

import static org.junit.Assert.*;

public class TestLab5 {

    @Test
    public void sumToString1() {
        Node sum = new Sum(new Constant(5),new Constant(-2)).add(new Variable("x"));
        System.out.println(sum.toString());
        assertEquals(sum.toString(),"5 + (-2) + x");

    }
    @Test
    public void prodToString1() {
        Node sum = new Prod(new Constant(5),new Constant(-2)).mul(new Variable("x"));
        System.out.println(sum.toString());
        assertEquals(sum.toString(),"5*(-2)*x");

    }
    @Test
    public void Test1(){
        Variable x = new Variable("x");
        Node exp = new Sum()
                .add(2.1,new Power(x,3))
                .add(new Power(x,2))
                .add(-2,x)
                .add(7);
        System.out.println(exp.toString());
        assertEquals("2.1*x^3 + x^2 + (-2)*x + 7",exp.toString());

    }
    @Test
    public void Test2() {
        Variable x = new Variable("x");
        Node exp = new Sum()
                .add(new Power(x, 3))
                .add(-2, new Power(x, 2))
                .add(-1, x)
                .add(2);
        for (double v = -5; v < 5; v += 0.1) {
            x.setValue(v);
            //System.out.printf(Locale.US, "f(%f)=%f\n", v, exp.evaluate());
        }
    }
    @Test
    public void defineCircle() {
        Variable x = new Variable("x");
        Variable y = new Variable("y");
        Node circle = new Sum()
                .add(new Power(x, 2))
                .add(new Power(y, 2))
                .add(8, x)
                .add(4, y)
                .add(16);
        System.out.println(circle.toString());

        double xv = 100 * (Math.random() - .5);
        double yv = 100 * (Math.random() - .5);
        x.setValue(xv);
        y.setValue(yv);
        double fv = circle.evaluate();
        //System.out.print(String.format("Punkt (%f,%f) leży %s koła %s", xv, yv, (fv < 0 ? "wewnątrz" : "na zewnątrz"), circle.toString()));
    }
    @Test
    public void diffPoly() {
        Variable x = new Variable("x");
        Node exp = new Sum()
                .add(2,new Power(x,3))
                .add(new Power(x,2))
                .add(-2,x)
                .add(7);
        System.out.print("exp=");
        System.out.println(exp.toString());

        Node d = exp.diff(x);
        System.out.print("d(exp)/dx=");
        System.out.println(d.toString());
        assertEquals(exp.toString(),"2*x^3 + x^2 + (-2)*x + 7");
        assertEquals(d.toString(),"0*x^3 + 2*3*x^2*1 + 2*x^1*1 + 0*x + (-2)*1 + 0");
    }
    @Test
    public void diffCircle() {
        Variable x = new Variable("x");
        Variable y = new Variable("y");
        Node circle = new Sum()
                .add(new Power(x, 2))
                .add(new Power(y, 2))
                .add(8, x)
                .add(4, y)
                .add(16);
        System.out.print("f(x,y)=");
        System.out.println(circle.toString());

        Node dx = circle.diff(x);
        System.out.print("d f(x,y)/dx=");
        System.out.println(dx.toString());
        System.out.print("d f(x,y)/dy=");
        Node dy = circle.diff(y);
        System.out.println(dy.toString());
        assertEquals("x^2 + y^2 + 8*x + 4*y + 16",circle.toString());
        assertEquals("2*x^1*1 + 2*y^1*0 + 0*x + 8*1 + 0*y + 4*0 + 0",dx.toString());
        assertEquals("2*x^1*0 + 2*y^1*1 + 0*x + 8*0 + 0*y + 4*1 + 0",dy.toString());
    }
}