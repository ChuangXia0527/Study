package com.itheima.medicinesystem.Entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.Setter;

@Data
@TableName("medicine")//指定表名
public class Medicine {
    @Setter
    @TableId(type = IdType.AUTO)//指定主键
    public Integer mno;
    public String mname;
    public String mmode;
    public String mefficacy;

}
