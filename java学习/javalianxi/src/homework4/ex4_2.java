package homework4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.TreeMap;

public class ex4_2 {
    public static void main(String[] args) {
        try {
            // TreeMap 用于统计字符和单词出现的频率
            TreeMap<String, Integer> tm = new TreeMap<>(); // 单词统计
            TreeMap<Character, Integer> tm1 = new TreeMap<>(); // 字符统计

            // 读取文件
            Scanner sc = new Scanner(new File("D:\\ideaprojects\\javalianxi\\src\\homework4\\EndOfTheWorld.txt"));
            String s;
            String[] sa;

            System.out.println("*****The original content:*****");

            // 遍历文件的每一行
            while (sc.hasNextLine()) {
                s = sc.nextLine();
                System.out.println(s); // 输出原始内容


/*                //字符统计
                 <<<<<<<<<<<<请加入程序代码，以完成相关的功能>>>>>>>>>>
                提示: 可用TreeMap的containsKey,put,get方法来协助*/


                // *** 字符统计 ***
                for (char c : s.toCharArray()) {
                    if (Character.isLetterOrDigit(c)) { // 只统计字母和数字
                        c = Character.toLowerCase(c); // 统一转换为小写
                        tm1.put(c, tm1.getOrDefault(c, 0) + 1);
                    }
                }

                //单词统计
/*                 <<<<<<<<<<<<请加入程序代码，以完成相关的功能>>>>>>>>>>
                提示: 可用TreeMap的containsKey,put,get方法来协助*/


                // *** 单词统计 ***
                sa = s.split("\\s|,|[?]|\\.|\"|“|”|\\(|\\)"); // 分解单词
                for (String word : sa) {
                    if (!word.isEmpty()) { // 跳过空字符串
                        word = word.toLowerCase(); // 统一转换为小写
                        tm.put(word, tm.getOrDefault(word, 0) + 1);
                    }
                }
            }

            // 输出统计结果
            System.out.println("*****Statistical results of each character：*****");
            System.out.println(tm1);

            System.out.println("*****Statistical results of each word：*****");
            System.out.println(tm);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
