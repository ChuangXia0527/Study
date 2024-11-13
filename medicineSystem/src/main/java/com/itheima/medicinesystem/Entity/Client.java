package com.itheima.medicinesystem.Entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.Setter;
@Data
@TableName("client")
public class Client {
    @Setter
    @TableId(type= IdType.AUTO)//主键自增
    private Integer cno;
    private String cname;
    private String csex;
    private String cage;
    private String caddress;
    private String cphone;
    private String csymptom;//症状

    @TableField(fill = FieldFill.INSERT)//插入时自动填充
    private Integer mno;

    @TableField(fill = FieldFill.INSERT)//插入时自动填充
    private Integer ano;

    private String cdate;
    private String cremark;//备注

}
