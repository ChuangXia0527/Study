package com.itheima.medicinesystem.Controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.itheima.medicinesystem.Entity.Medicine;
import com.itheima.medicinesystem.common.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.itheima.medicinesystem.Service.MedicineService;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@CrossOrigin
@RestController
@RequestMapping("/medicine")
public class MedicineController {
    @Autowired
    private MedicineService medicineService;


    @PostMapping("/add")//添加药品
    public Result add(@RequestBody Medicine medicine){
        return medicineService.save(medicine);
    }

    @DeleteMapping("/delete/{mno}")//删除药品
    public Result delete(@PathVariable Integer mno){
        return medicineService.delete(mno);
    }
    @PutMapping("/update")//修改药品
    public Result update(@RequestBody Medicine medicine){
        return medicineService.update(medicine);
    }
    @GetMapping("/get/{mno}")//根据id查询药品
    public Result get(@PathVariable Integer mno){
        return medicineService.getByMno(mno);
    }
    @GetMapping("/list")//查询所有药品
    public Result list(){
        return medicineService.listAll();
    }

    @DeleteMapping("/deleteBatch")//批量删除药品
    public ResponseEntity<?> deleteBatch(@RequestBody List<Integer> mnos) {
        // 批量删除逻辑
        for (Integer mno : mnos) {
            medicineService.delete(mno);// 执行单个删除操作
        }
        // 创建响应的 JSON 对象
        Map<String, String> response = new HashMap<>();
        response.put("code", "200");
        response.put("message", "批量删除成功");

        return ResponseEntity.ok(response); // 返回标准的 JSON 响应
    }
    // 新增搜索药品接口
    @GetMapping("/search") // 搜索药品
    public Result searchMedicines(
            @RequestParam(required = false) String mno,
            @RequestParam(required = false) String mname,
            @RequestParam(required = false) String mmode,
            @RequestParam(required = false) String mefficacy
    ) {
        return medicineService.searchMedicines(mno, mname, mmode, mefficacy);
    }
}
