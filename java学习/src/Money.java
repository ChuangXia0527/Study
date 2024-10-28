import java.util.Scanner;
public class Money {
    public static final char[] ca = {'零', '壹', '贰', '叁', '肆', '伍', '陆', '柒', '捌', '玖'};
    public static final String[] ma = {"分", "角", "元", "拾", "佰", "仟", "万", "拾万", "佰万", "仟万", "亿", "拾亿", "佰亿", "仟亿"};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入金额:");
        double money = sc.nextDouble();
        System.out.println("金额"+money+"的大写为："+changebig(money));
    }
    public static String changebig(double money) {
        long moneyLong = Math.round(money * 100);
        StringBuilder result = new StringBuilder();
        int unitPos = 0;
        boolean needZero = false;

        while (moneyLong > 0) {
            int num = (int) (moneyLong % 10);
            if (num == 0) {
                if ((unitPos == 2 || unitPos == 6 || unitPos == 10) && result.length() > 0) {
                    result.insert(0, ma[unitPos]);
                }
                needZero = true;
            } else {
                if (needZero) {
                    result.insert(0, "零");
                    needZero = false;
                }
                result.insert(0, ca[num] + ma[unitPos]);
            }
            moneyLong /= 10;
            unitPos++;
        }

        return result.toString();
    }
}
