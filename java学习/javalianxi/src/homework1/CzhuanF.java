package homework1;

import java.util.Scanner;
public class CzhuanF {
    public static void main(String[] args) {
        System.out.println("请输入摄氏温度：");
        Scanner sc = new Scanner(System.in);
        int c = sc.nextInt();
        int f = (9*c)/5+32;
        System.out.println("华氏度为：");
        System.out.println(f);
    }
}
