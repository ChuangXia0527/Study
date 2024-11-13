package com.itheima.medicinesystem.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.itheima.medicinesystem.Entity.Agency;
import com.itheima.medicinesystem.Entity.Medicine;
import org.apache.ibatis.annotations.Select;

public interface AgencyMapper extends BaseMapper<Agency> {

    @Select("select * from `agency` where ano = #{ano}")
    Agency getByAno(Integer ano);


}
