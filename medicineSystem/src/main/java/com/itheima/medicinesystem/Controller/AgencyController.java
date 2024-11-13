package com.itheima.medicinesystem.Controller;

import com.itheima.medicinesystem.Entity.Agency;
import com.itheima.medicinesystem.Service.AgencyService;
import com.itheima.medicinesystem.common.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/agency")
public class AgencyController {
    @Autowired
    private AgencyService agencyService;
    @RequestMapping("/get/{ano}")
    public Result getByAno(@PathVariable Integer ano){
        return agencyService.getByAno(ano);
    }
    @PostMapping("/add")
    public Result addAgency(@RequestBody Agency agency){
        return agencyService.save(agency);
    }
    @PutMapping("/update")
    public Result updateAgency(@RequestBody Agency agency){
        return agencyService.update(agency);
    }
    @DeleteMapping("/delete/{ano}")
    public Result deleteAgency(@PathVariable Integer ano){
        return agencyService.delete(ano);
    }
    @GetMapping("/list")
    public Result finAll(){
        return (Result) agencyService.findAll();
    }
    //根据ano重新排序
    @PutMapping("/reorder")
    public Result reorderagencys(@RequestBody List<Agency> agencys) throws SQLException {
        // 遍历药品列表并更新药品编号
        for (int i = 0; i < agencys.size(); i++) {
            Agency agency = agencys.get(i);
            // 设置新的药品编号，假设从 1 开始
            agency.setAno(String.valueOf(i + 1));
            // 更新药品信息
            agencyService.update(agency);
        }
        return Result.success("经办人编号重新排序成功");
    }
    // 批量删除
    @DeleteMapping("/deleteBatch")
    public ResponseEntity<?> deleteBatch(@RequestBody List<Integer> anos) {
        // 批量删除逻辑
        for (Integer ano : anos) {
            agencyService.delete(ano);// 执行单个删除操作
        }
        // 创建响应的 JSON 对象
        Map<String, String> response = new HashMap<>();
        response.put("code", "200");
        response.put("message", "批量删除成功");

        return ResponseEntity.ok(response); // 返回标准的 JSON 响应
    }

    // 新增搜索代理接口
    @GetMapping("/search") // 搜索代理
    public Result searchAgencies(
            @RequestParam(required = false) String ano,
            @RequestParam(required = false) String aname,
            @RequestParam(required = false) String asex,
            @RequestParam(required = false) String aphone,
            @RequestParam(required = false) String aremark
    ) {
        return agencyService.searchAgencies(ano, aname, asex, aphone, aremark);
    }
}
