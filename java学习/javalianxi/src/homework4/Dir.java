package homework4;
//建立一个类别(Dir.java)，来模仿命令提示下Dir的指令来查询C:\下的档案与目录，请以下程序代码最基础，来完成其程序。
import java.io.File;
import java.io.FilenameFilter;
import java.text.SimpleDateFormat;
import java.util.Date;
public class Dir {
    public static void main(String[] args) {
        File f=new File("C:\\");

        File[] fa=f.listFiles( new FilenameFilter(){
            @Override
            public boolean accept(File dir, String name){

                //<<<<<<<<<<<<请加入程序代码，以完成相关的功能>>>>>>>>>>
                return true;
            }
        } );

        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");//格式化时间

                //<<<<<<<<<<<<请加入程序代码，以完成相关的功能>>>>>>>>>>
        if(fa!=null){
            for(File f1:fa){
                String name=f1.getName();
                String time=sdf.format(new Date(f1.lastModified()));
                String type=f1.isDirectory()?"<DIR>":"";
                long size=f1.length();
                System.out.println(name+"\t"+time+"\t"+type+"\t"+size);

            }
        }
        else {
            System.out.println("目录不存在");
        }


    }
}
