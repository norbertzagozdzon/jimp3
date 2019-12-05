package lab5;

import java.util.ArrayList;
import java.util.List;

public class Sum extends Node {

    List<Node> args = new ArrayList<>();

    Sum(){}

    Sum(Node n1, Node n2){
        args.add(n1);
        args.add(n2);
    }


    Sum add(Node n){
        args.add(n);
        return this;
    }

    Sum add(double c){
        args.add(new Constant(c));
        return this;
    }

    Sum add(double c, Node n) {
        Node mul = new Prod(c,n);
        args.add(mul);
        return this;
    }

    @Override
    double evaluate() {
        double result =0;
        for(Node i:args) result+=i.evaluate();
        return sign*result;
    }

    int getArgumentsCount(){return args.size();}

    public String toString(){
        StringBuilder b =  new StringBuilder();
        if(sign<0)b.append("-(");
        int sizeOfArgs = args.size();
        for(int i=0;i<args.size();i++) {
            b.append(args.get(i).toString());
            if(i<sizeOfArgs-1) b.append(" + ");
        }
        if(sign<0)b.append(")");
        return b.toString();
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
        Sum r = new Sum();
        for(Node n:args){
            Node temp = n.diff(var);
            r.add(temp);
        }
        return r;
    }
}