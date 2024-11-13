package homework4;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ex3 {
    public static void main(String[] args) throws IOException {
        String dir = "src/homework4/ex3.txt";
        File file = new File(dir);
//如果文件不存在，创建文件
        if (!file.exists())
            file.createNewFile();
//创建FileWriter对象
        FileWriter writer = new FileWriter(file);

        int[][] data = new int[9][9];
        System.out.println("九九乘法表：");
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                data[i][j] = (i + 1) * (j + 1);
                writer.write(i+ "+" + j+ "=" + data[i][j] + " ");
            }
            writer.write("\n");
        }
        writer.flush();
        writer.close();
    }
}
