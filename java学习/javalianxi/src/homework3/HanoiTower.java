package homework3;
import java.util.Scanner;
public class HanoiTower {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入：");
        int n = sc.nextInt();
        System.out.println("输出：");
        hanoiTower(n,'A','B','C');
    }
    public static void hanoiTower(int n, char src, char dest, char aux){
        if(n == 1){
            System.out.println("磁盘1从"+src+"移动到"+aux);
        }
        else{
            hanoiTower(n-1, src, aux,dest);
            System.out.println("磁盘"+n+"从"+src+"移动到"+aux);
            hanoiTower(n-1, aux,src,dest);

        }
    }
}
