package homework3;

public class MathCalc {
    public static void main(String[] args) {
        CCalculator obj1 = new CCalculator();
        CTriFunc obj2 = new CTriFunc();
        double a,b;
        a = Math.random()*20;
        b = Math.random()*10;
        System.out.println(a + " Add " + b + " = " +obj1.Add(a,b)); //加
        System.out.println(a + " Sub " + b + " = " +obj1.Sub(a,b)); //减
        System.out.println(a + " Mul " + b + " = " +obj1.Mul(a,b)); //乘
        System.out.println(a + " Div " + b + " = " +obj1.Div(a,b)); //除
        System.out.println("log(" + a + ") = "   +obj1.LOG(a));  //log以10为底数
        System.out.println("ln(" + a + ") = "    +obj1.LN(a));   //log以e为底数
        System.out.println("sin(" + b + ") = "   +obj1.SIN(b*10));  //三角函数Sin
        System.out.println("cos(" + b + ") = "   +obj1.COS(b*10)); //三角函数Cos
        System.out.println("tan(" + b + ") = "   +obj1.TAN(b*10));  //三角函数Tan
        System.out.println("sin(" + b + ") = "   +obj2.SIN(b*10) + "by run CTriFunc method");
        System.out.println("cos(" + b + ") = "   +obj2.COS(b*10) + "by run CTriFunc method");
        System.out.println("tan(" + b + ") = "   +obj2.TAN(b*10) + "by run CTriFunc method");
    }
}
class CCalculator extends CTriFunc implements IFullCompute {
    public double result;
    public CCalculator()  {
  }
    public double LOG(double x)  {
        return Math.log(x);
  }
    public double LN(double x)  {
        return Math.log(x);
  }
    public double Add(double a,double b)  {
        return a+b;
  }
    public double Sub(double a,double b)  {
        return a-b;
  }
    public double Mul(double a,double b)  {
        return a*b;
  }
    public double Div(double a,double b)  {
        return a/b;
  }
    public double SIN(double x) {
        return Math.sin(x);
 }
    public double COS(double x) {
        return Math.cos(x);
  }
    public double TAN(double x) {
        return Math.tan(x);
 }
}

class CTriFunc
{
    double trans(double x) {
        return x * (Math.PI / 180);
    }//Math.PI/180 表示弧度1度为多少π（1π=180°）}
        public double SIN(double x){
        return Math.sin(x);
    }

        public double COS(double x)
        {  	 return Math.cos(x);}
        public double TAN(double x)
        {  	return Math.tan(x);}
    }

    interface IAdvCompute
    {
        double e = 2.71828182845905;
        double LOG(double x);
        double LN(double x);
    }

    interface IBasicCompute
    {
        double Add(double a,double b);
        double Sub(double a,double b);
        double Mul(double a,double b);
        double Div(double a,double b);
    }

    interface IFullCompute extends IBasicCompute,IAdvCompute
    {   }

