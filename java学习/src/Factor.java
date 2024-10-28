import java.util.Scanner;
public class Factor {
    public static void main(String[] args) {
        int a = 0;
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个整数：");
        int number = sc.nextInt();
        System.out.print(number + "=");
        boolean isFirst = true;
        for (int i = 1; i <= number; i++) {
            if (number % i == 0) {
                if (!isFirst) {
                    System.out.print("X");
                    number = number/i;
                }
                System.out.print(i);
                i = 1;
                isFirst = false;
            }
        }
        }
    }

