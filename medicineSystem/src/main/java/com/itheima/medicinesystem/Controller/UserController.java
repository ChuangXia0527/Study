package com.itheima.medicinesystem.Controller;

import com.itheima.medicinesystem.Entity.User;
import com.itheima.medicinesystem.Exception.serviceException;
import com.itheima.medicinesystem.common.Result;
import com.itheima.medicinesystem.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    // 注册接口
    @PostMapping("/register")
    public Result register(@RequestBody User user) {
        return userService.register(user);
    }

    // 登录接口
    @PostMapping("/login")
    public Result login(@RequestBody User user) {
        try {
            user = userService.login(user);
            if (user != null) {
                return Result.success(user);
            } else {
                return Result.error("用户名或密码错误");
            }
        } catch (serviceException e) {
            return Result.error(e.getMessage());
        }
    }

    // 添加用户
    @PostMapping("/add")
    public Result addUser(@RequestBody User user) {
        return userService.save(user);
    }

    // 更新用户
    @PutMapping("/update")
    public Result updateUser(@RequestBody User user) {
        return userService.updateById(user);
    }

    // 根据ID删除用户
    @DeleteMapping("/delete/{id}")
    public Result deleteUser(@PathVariable Integer id) {
        return userService.removeById(id);
    }

    // 根据ID获取用户
    @GetMapping("/{id}")
    public Result getUserById(@PathVariable Integer id) {
        return userService.getById(id);
    }
}