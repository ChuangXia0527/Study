package com.itheima.medicinesystem.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.itheima.medicinesystem.Entity.Medicine;
import com.itheima.medicinesystem.common.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.itheima.medicinesystem.mapper.MedicineMapper;

import java.util.List;

@Service
public class MedicineService {
    //业务逻辑
    @Autowired
    private MedicineMapper medicineMapper;
    public Result save(Medicine medicine){//添加药品信息
        boolean saved = medicineMapper.insert(medicine) > 0;
        if(saved){
            return Result.success("添加成功");
        }
        else{
            return Result.error("添加失败");
        }
    }
    public Result getByMno(Integer mno){//根据药品编号查询药品信息
        Medicine medicine = medicineMapper.getByMno(mno);
        if(medicine != null){
            return Result.success(medicine);
        }
        else{
            return Result.error("查询失败");
        }
    }
    public Result update(Medicine medicine){//修改药品信息
        boolean updated = medicineMapper.updateById(medicine) > 0;
        if(updated){
            return Result.success("修改成功");
        }
        else{
            return Result.error("修改失败");
        }
    }
    public Result delete(Integer mno){//删除药品信息
        boolean deleted = medicineMapper.deleteById(mno) > 0;
        if(deleted){
            return Result.success("删除成功");
        }
        else{
            return Result.error("删除失败");
        }
    }
    public Result listAll(){//查询所有药品信息
        return Result.success(medicineMapper.selectList(null));
    }

    public List<Medicine> list(QueryWrapper<Medicine> queryWrapper) {
        return medicineMapper.selectList(queryWrapper);
    }

    // 新增动态条件搜索功能
    public Result searchMedicines(String mno, String mname, String mmode, String mefficacy) {
        QueryWrapper<Medicine> queryWrapper = new QueryWrapper<>();

        // 动态构建查询条件
        if (mno != null && !mno.isEmpty()) {
            queryWrapper.eq("mno", mno);
        }
        if (mname != null && !mname.isEmpty()) {
            queryWrapper.like("mname", mname); // 模糊查询药品名称
        }
        if (mmode != null && !mmode.isEmpty()) {
            queryWrapper.eq("mmode", mmode); // 精确查询药品类型
        }
        if (mefficacy != null && !mefficacy.isEmpty()) {
            queryWrapper.like("mefficacy", mefficacy); // 模糊查询药品功效
        }

        // 执行查询
        List<Medicine> medicines = medicineMapper.selectList(queryWrapper);

        // 返回结果
        if (medicines != null && !medicines.isEmpty()) {
            return Result.success(medicines);
        } else {
            return Result.error("未找到符合条件的药品信息");
        }
    }

}