package homework1;

public class Loan {
    public static void main(String[] args) {
        double money = 10000;
        int year = 365;
        double pay1 = money*(1+0.001*year);
        System.out.println("单利的一年为："+pay1);
        double pay2 = money*(1+0.001*2*year);
        System.out.println("单利的二年为："+pay2);
        double pay3 = money*(1+0.001*3*year);
        System.out.printf("单利的三年为：%.1f\n",pay3);
        double pay4 = money*(1+0.001*4*year);
        System.out.println("单利的四年为："+pay4);
        double pay5 = money*(1+0.001*5*year);
        System.out.println("单利的五年为："+pay5);
        System.out.println("=================");
        double dailyRate = 0.001;
        for (int i = 1; i <= 5; i++) {
            double moneys = cal(money,dailyRate,i*year);
            System.out.printf("第%d年需要还款金额：%.2f 元%n", i, moneys);
        }
    }
    public static double cal(double principal, double dailyRate, int days){
        double money = principal * Math.pow(1 + dailyRate, days);
        return money;
    }
}
