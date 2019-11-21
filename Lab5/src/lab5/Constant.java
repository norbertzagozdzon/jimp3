package lab5;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public class Constant extends Node {
    double value;
    Constant(double value){
        this.sign = value<0?-1:1;
        this.value = value<0?-value:value;
    }


    @Override
    double evaluate() {
        return sign*value;
    }

    @Override
    public String toString() {
        String sgn1,sgn2;
        if(sign<0) {
            sgn1="(-";
            sgn2=")";
        }
        else {
            sgn1 = "";
            sgn2 = "";
        }
        DecimalFormat format = new DecimalFormat("0.#####",new DecimalFormatSymbols(Locale.US));
        return sgn1+format.format(value)+sgn2;
    }

    @Override
    boolean isZero() {
        try {
            this.evaluate();
        }
        catch(NullPointerException e) {return false;}
        return this.evaluate()==0;
    }

    @Override
    Node diff(Variable var) {
        return new Constant(0);
    }

}
