package com.itheima.medicinesystem.Entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.Setter;

@Data
@TableName("user")
public class User {
    @Setter
    @TableId(type = IdType.AUTO)//主键自增
    private Integer id;//用户id

    private String username;
    private String password;
    private String phone;
    private String email;
    private String address;//地址
    private String role;//角色
    @TableField(exist = false)//数据库中没有这个字段
    private String token;
}
