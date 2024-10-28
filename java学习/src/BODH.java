import java.util.Scanner;
public class BODH {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入一个整数:");
        int number = scanner.nextInt();
        System.out.println("转化为二进制:"+Integer.toBinaryString(number));
        System.out.println("转化为八进制:"+Integer.toOctalString(number));
        System.out.println("转化为十进制:"+number);
        System.out.println("转化为十六进制:"+Integer.toHexString(number));
    }
}
