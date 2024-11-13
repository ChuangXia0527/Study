package homework3;
public class CmyExceptionTest {
    static class CmyException extends RuntimeException {
        public CmyException(String message) {
            super(message);
        }
    }

    public static void main(String args[])  //勿修改 main内容
    {
        try {
            System.out.println("2的 5次方=" + powerXY(2, 5));
        } catch (CmyException e) {
            System.out.println(e.getMessage());
        }
        try {
            System.out.println("2的 0次方=" + powerXY(2, 0));
        } catch (CmyException e) {
            System.out.println(e.getMessage());
        }
        try {
            System.out.println("0的 0次方=" + powerXY(0, 0));
        } catch (CmyException e) {
            System.out.println(e.getMessage()+"    0的0次方=-1");
        }
        try {
            System.out.println("2的 -2次方=" + powerXY(2, -2));
        } catch (CmyException e) {
            System.out.println(e.getMessage()+"    2的 -2次方=-1");
        }
    }

    static int powerXY(int x, int y) throws CmyException  //可修改powerXY内容
    {
        if(x==0 && y==0){
            throw new CmyException("0的0次方无定义,回传值将错误");
        }
        if(x!=1 && y<0){
            throw new CmyException("次方为负值,结果不为整数,回传值将错误");
        }
        return (int) Math.pow(x,y);
    }
}
