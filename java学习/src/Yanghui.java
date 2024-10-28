public class Yanghui {
    public static void main(String[] args) {
        second();
        int n = 6;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print(gongshi(i, j) + " ");
            }
            System.out.println();
        }
    }
    public static void second(){
        int n = 6;
        int trangle[][] = new int[n][n];
        for (int i = 0; i < n; i++) {
            trangle[i][0] = 1;
            trangle[i][i] = 1;
        }
        for (int i = 2; i < n; i++) {
            for (int j = 1; j < i; j++) {
                trangle[i][j] = trangle[i-1][j-1]+trangle[i-1][j];
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print(trangle[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static int gongshi(int n,int m){
        int result = jiecheng(n)/(jiecheng(m)*jiecheng((n-m)));
        return result;

    }
    public static int jiecheng(int num) {
        if (num == 0 || num == 1) {
            return 1;
        }
        int result = 1;
        for (int i = 2; i <= num; i++) {
            result *= i;
        }
        return result;
    }
}
