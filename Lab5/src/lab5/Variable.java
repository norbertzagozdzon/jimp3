package lab5;

public class Variable extends Node {
    String name;
    Double value;
    Variable(String name){
        this.name = name;
    }
    void setValue(double d){
        value = d;
    }


    @Override
    double evaluate() {
        return sign*value;
    }


    @Override
    public String toString() {
        String sgn=sign<0?"-":"";
        return sgn+name;
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
        if(var.name.equals(name))return new Constant(sign);
        else return new Constant(0);
    }
}