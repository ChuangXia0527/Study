package com.itheima.medicinesystem.Service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.itheima.medicinesystem.Entity.Agency;
import com.itheima.medicinesystem.Entity.Client;
import com.itheima.medicinesystem.common.Result;
import com.itheima.medicinesystem.mapper.ClientMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class ClientService{
    @Autowired
    private ClientMapper clientMapper;
    public Result getByCno(Integer cno){
        Client client = clientMapper.getByCno(cno);
        if(client!=null){
            return Result.success(client);
        }
        else{
            return Result.error("查询失败");
        }
    }
    public Result save(Client client){
        boolean saved = clientMapper.insert(client) > 0;
        if(saved){
            return Result.success("保存成功");
        }
        else{
            return Result.error("保存失败");
        }
    }
    public Result update(Client client){
        boolean updated = clientMapper.updateById(client) > 0;
        if(updated){
            return Result.success("更新成功");
        }
        else{
            return Result.error("更新失败");
        }
    }
    public Result delete(Integer cno){
        boolean deleted = clientMapper.deleteById(cno) > 0;
        if(deleted){
            return Result.success("删除成功");
        }
        else{
            return Result.error("删除失败");
        }
    }
    public Result list(){//查询所有
        List<Client> clients = clientMapper.selectList(null);
        return Result.success(clients);
    }
    public Result searchClients(String cno, String cname, String csex, String caddress, String cphone, String csymptom, String mno, String ano, String cdate, String cremark) {
        QueryWrapper<Client> queryWrapper = new QueryWrapper<>();

        // 根据传入的参数动态构建查询条件
        if (cno != null && !cno.isEmpty()) {
            queryWrapper.eq("cno", cno);
        }
        if (cname != null && !cname.isEmpty()) {
            queryWrapper.like("cname", cname); // 模糊查询客户名称
        }
        if (csex != null && !csex.isEmpty()) {
            queryWrapper.eq("csex", csex);
        }
        if (caddress != null && !caddress.isEmpty()) {
            queryWrapper.like("caddress", caddress);
        }
        if (cphone != null && !cphone.isEmpty()) {
            queryWrapper.like("cphone", cphone);
        }
        if (csymptom != null && !csymptom.isEmpty()) {
            queryWrapper.like("csymptom", csymptom);
        }
        if (mno != null && !mno.isEmpty()) {
            queryWrapper.eq("mno", mno);
        }
        if (ano != null && !ano.isEmpty()) {
            queryWrapper.eq("ano", ano);
        }
        if (cdate != null && !cdate.isEmpty()) {
            queryWrapper.like("cdate", cdate);
        }
        if (cremark != null && !cremark.isEmpty()) {
            queryWrapper.like("cremark", cremark);
        }

        // 执行查询
        List<Client> clients = clientMapper.selectList(queryWrapper);

        // 返回结果
        if (clients != null && !clients.isEmpty()) {
            return Result.success(clients);
        } else {
            return Result.error("未找到符合条件的记录");
        }
    }

}
