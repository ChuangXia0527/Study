package com.itheima.medicinesystem.Service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.itheima.medicinesystem.Entity.Agency;
import com.itheima.medicinesystem.common.Result;
import com.itheima.medicinesystem.mapper.AgencyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AgencyService {
    @Autowired
    private AgencyMapper agencyMapper;
    public Result save(Agency agency){
        boolean saved = agencyMapper.insert(agency) > 0;
        if (saved){
            return Result.success("保存成功");
        }
        else{
            return Result.error("保存失败");
        }
    }
    public Result delete(Integer ano){
        boolean deleted = agencyMapper.deleteById(ano) > 0;
        if (deleted){
            return Result.success("删除成功");
        }
        else{
            return Result.error("删除失败");
        }
    }
    public Result update(Agency agency){
        boolean updated = agencyMapper.updateById(agency) > 0;
        if (updated){
            return Result.success("更新成功");
        }
        else{
            return Result.error("更新失败");
        }
    }
    public Result getByAno(Integer ano){//根据ano查询
        Agency agency = agencyMapper.getByAno(ano);
        if(agency!=null){
            return Result.success(agency);
        }
        else{
            return Result.error("查询失败");
        }
    }
    public List<Agency> findAll(){//查询所有
        return agencyMapper.selectList(null);
    }

    // 新增动态条件搜索功能
    public Result searchAgencies(String ano, String aname, String asex, String aphone, String aremark) {
        QueryWrapper<Agency> queryWrapper = new QueryWrapper<>();

        // 动态构建查询条件
        if (ano != null && !ano.isEmpty()) {
            queryWrapper.eq("ano", ano); // 精确查询代理编号
        }
        if (aname != null && !aname.isEmpty()) {
            queryWrapper.like("aname", aname); // 模糊查询代理名称
        }
        if (asex != null && !asex.isEmpty()) {
            queryWrapper.eq("asex", asex); // 精确查询代理性别
        }
        if (aphone != null && !aphone.isEmpty()) {
            queryWrapper.like("aphone", aphone); // 模糊查询代理电话
        }
        if (aremark != null && !aremark.isEmpty()) {
            queryWrapper.like("aremark", aremark); // 模糊查询备注
        }

        // 执行查询
        List<Agency> agencies = agencyMapper.selectList(queryWrapper);

        // 返回结果
        if (agencies != null && !agencies.isEmpty()) {
            return Result.success(agencies);
        } else {
            return Result.error("未找到符合条件的代理信息");
        }
    }

}
