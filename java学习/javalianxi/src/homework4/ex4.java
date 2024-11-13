package homework4;

import java.io.*;
import java.util.EnumSet;

enum WeekDay {
    Mon("Monday", "星期一"), Tue("Tuesday", "星期二"), Wed("Wednesday", "星期三"),
    Thu("Thursday", "星期四"), Fri("Friday", "星期五"), Sat("Saturday", "星期六"),
    Sun("Sunday", "星期日");

    private final String en;
    private final String cn;

    private WeekDay(String en, String cn) {
        this.en = en;
        this.cn = cn;
    }

    public String getEn() {
        return en;
    }

    public String getCn() {
        return cn;
    }
}

public class ex4 {
    public static void main(String[] args) {
        // 获取文件路径
        String fileName = "D:\\ideaprojects\\javalianxi\\src\\homework4\\ex2out.txt";

        StringBuilder output = new StringBuilder();

        WeekDay s1 = WeekDay.Fri;
        output.append(WeekDay.Tue.getCn()).append("\t");
        output.append(s1).append(":").append(s1.getCn()).append("\t");

        for (WeekDay s : WeekDay.values()) {
            output.append(s).append(":").append(s.getCn()).append("\t");
        }

        for (WeekDay s : EnumSet.range(WeekDay.Tue, WeekDay.Sat)) {
            output.append(s).append("-").append(s.getEn()).append("\t");
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write(output.toString());
            System.out.println("结果已经成功写入到文件: " + fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            System.out.println("从文件中读取的内容: ");
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
