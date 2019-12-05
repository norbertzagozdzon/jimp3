package test;

import main.Month;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import main.Month;

import java.util.ArrayList;

public class MonthTest {

    @Test
    public void countAvg() {
        ArrayList<Double> l = new ArrayList<>();
        ArrayList<Double> l2 = new ArrayList<>();
        l.add(1.0);
        l.add(2.0);
        l.add(3.0);
        l.add(4.0);
        l2.add(1.0);
        l2.add(2.0);
        l2.add(3.0);
        l2.add(4.0);
        Month m = new Month("Jan");
        m.addLine(l);
        m.addLine(l2);
        System.out.println(m.countAvg());
        Assert.assertEquals(m.countAvg(),2.5,1e-5);
    }
    @Test
    public void countMaxSub() {
    }
}