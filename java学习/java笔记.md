# JAVA学习笔记
## 入门
```java
//java的快速入门,演示java的开发步骤
//对代码的相关说明
//1.public class Hello 表示Hello是一个类，是一个public公有的类
//2.Hello{ }表示一个类的开始和结束
//3.public static void main(String[] args)表示一个主方法，即我们程序的入口
//4.main(){}表示方法的开始和结束
//5.System.out.println("hello,world~!");表示输出"hello,world~"到屏幕
//;代表结束符
public class Hello{
    //编写一个main方法
    public static void main(String[] args){
        System.out.println("hello,world~!");
    }
}
```



## window操作系统 基本DOS命令
![alt text](image.png)

## 字面量 常见的数据
![alt text](image-1.png)
```java

system.out.println('a') //空格中只能有一个字符
//println 的 ln 表示\n  \t代表一个tab
system.out.println("肇庆学院")//""代表能输出多个字符

```

## 变量
数据类型 变量名称 = 数据;
```java
 //例：
int a = 18;//表示定义一个变量名称为a，数据类型为int 赋值a的值为18
```

## 关键字和标识符
java语言自己用到的一些词，有特殊作用的，我们称之为关键字，如：public，class，int，double
注意：关键字是java用了的，我们就不能用来作为：类名，变量名，否则会报错
![alt text](image-2.png)

![alt text](image-3.png)

## 数据类型的分类
![alt text](image-4.png)

## 类型转换
### 自动类型转换
![alt text](image-5.png)
类型范围小的变量，可以直接赋值给类型范围大的变量
例如 byte a = 12;
     int b = a;
     实行了自动类型转换byte（小）->int(大)

### 表达式的自动类型转换




