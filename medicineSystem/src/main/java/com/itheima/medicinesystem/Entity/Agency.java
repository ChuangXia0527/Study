package com.itheima.medicinesystem.Entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.Setter;

import java.lang.reflect.Type;

@Data
@TableName("agency")//指定数据库表名
public class Agency {//代理

    @Setter//自动生成get和set方法
    @TableId(type = IdType.AUTO)
    private  String ano;//编号
    private  String aname;//名称
    private  String asex;//性别
    private  String aphone;//电话
    private  String aremark;//备注

}
