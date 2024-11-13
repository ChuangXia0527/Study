package com.itheima.medicinesystem.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.itheima.medicinesystem.Entity.Medicine;
import org.apache.ibatis.annotations.*;

import java.util.List;
@Mapper
public interface MedicineMapper extends BaseMapper<Medicine> {

    @Select("select * from `medicine` where mno = #{mno}")
    Medicine getByMno(Integer mno);
    @Select("select * from `medicine` where mname like concat('%',#{mname},'%')")
    Medicine getByMname(String mname);

}