package com.itheima.medicinesystem.Controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.itheima.medicinesystem.Entity.Client;
import com.itheima.medicinesystem.common.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.itheima.medicinesystem.Service.ClientService;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("/client")
public class ClientController {
    @Autowired
    private ClientService clientService;
    @RequestMapping("/get/{cno}")
    public Result getByCno(@PathVariable Integer cno){
        return clientService.getByCno(cno);
    }
    @PostMapping("/add")
    public Result add(@RequestBody Client client){
        return clientService.save(client);
    }
    @DeleteMapping("/delete/{cno}")
    public Result delete(@PathVariable Integer cno){
        return clientService.delete(cno);
    }
    @PutMapping("/update")
    public Result update(@RequestBody Client client){
        return clientService.update(client);
    }
    @GetMapping("/list")
    public Result list(){
        return clientService.list();
    }
    @DeleteMapping("/deleteBatch")
    public ResponseEntity<?> deleteBatch(@RequestBody List<Integer> cnos) {
        // 批量删除逻辑
        for (Integer cno : cnos) {
            clientService.delete(cno);// 执行单个删除操作
        }
        // 创建响应的 JSON 对象
        Map<String, String> response = new HashMap<>();
        response.put("code", "200");
        response.put("message", "批量删除成功");

        return ResponseEntity.ok(response); // 返回标准的 JSON 响应
    }
    @PutMapping("/reorder")
    public Result reorderClients(@RequestBody List<Client> clients) throws SQLException {
        // 遍历药品列表并更新药品编号
        for (int i = 0; i < clients.size(); i++) {
            Client client = clients.get(i);
            // 设置新的药品编号，假设从 1 开始
            client.setCno(i + 1);
            // 更新药品信息
            clientService.update(client);
        }
        return Result.success("药品编号重新排序成功");
    }
    @GetMapping("/search")//根据条件查询
    public Result searchClients(
            @RequestParam(required = false) String cno,
            @RequestParam(required = false) String cname,
            @RequestParam(required = false) String csex,
            @RequestParam(required = false) String caddress,
            @RequestParam(required = false) String cphone,
            @RequestParam(required = false) String csymptom,
            @RequestParam(required = false) String mno,
            @RequestParam(required = false) String ano,
            @RequestParam(required = false) String cdate,
            @RequestParam(required = false) String cremark
    ) {
        return clientService.searchClients(cno, cname, csex, caddress, cphone, csymptom, mno, ano, cdate, cremark);
    }

}
