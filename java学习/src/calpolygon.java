
abstract class CShape {
    public int number;  // 边数


    public int totalAngle() {
        return (number - 2) * 180;
    }


    public abstract double angle();
}


class CTriangle extends CShape {

    public CTriangle() {
        number = 3;
    }


    public double angle() {
        return totalAngle() / number;
    }


    public String toString() {
        return "正三边形每个内角为 " + angle() + " 度";
    }
}


class CRect extends CShape {

    public CRect() {
        number = 4;
    }


    public double angle() {
        return totalAngle() / number;
    }


    public String toString() {
        return "正四边形每个内角为 " + angle() + " 度";
    }
}


class CPentagon extends CShape {

    public CPentagon() {
        number = 5;
    }


    public double angle() {
        return totalAngle() / number;
    }


    public String toString() {
        return "正五边形每个内角为 " + angle() + " 度";
    }
}


public class calpolygon {
    public static void main(String[] args) {

        CShape[] objArr = new CShape[3];

        objArr[0] = new CTriangle();
        objArr[1] = new CRect();
        objArr[2] = new CPentagon();
        for (int i = 0; i < objArr.length; i++) {
            objArr[i].angle();
        }
        for (int i = 0; i < objArr.length; i++) {
            System.out.println(objArr[i].toString());
        }
    }
}
