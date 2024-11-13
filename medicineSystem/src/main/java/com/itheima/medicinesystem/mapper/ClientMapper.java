package com.itheima.medicinesystem.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.itheima.medicinesystem.Entity.Client;
import org.apache.ibatis.annotations.Select;

public interface ClientMapper extends BaseMapper<Client> {

    @Select("select * from `client` where cno = #{cno}")
    Client getByCno(Integer cno);
}
