package homework2;

import java.lang.*;
import java.lang.Math;

interface isbasiccompute{
    double Add(double a,double b);
    double Sub(double a,double b);
    double Mul(double a,double b);
    double Div(double a,double b);
}
class CCalculator implements isbasiccompute{
    public double Add(double a, double b) {
        return a+b;
    }
    public double Sub(double a, double b) {
        return a-b;
    }

    public double Mul(double a, double b) {
        return a*b;
    }

    public double Div(double a, double b) {
        return a/b;
    }
}
public class calmachine {
    public static void main(String[] args) {
        CCalculator obj1 = new CCalculator();
        double a,b;
        a = Math.random()*20;
        b = Math.random()*10;
        System.out.println(a+" Add "+b+" = "+obj1.Add(a,b));
        System.out.println(a+" Sub "+b+" = "+obj1.Sub(a,b));
        System.out.println(a+" Mul "+b+" = "+obj1.Mul(a,b));
        System.out.println(a+" Div "+b+" = "+obj1.Div(a,b));
    }
}
