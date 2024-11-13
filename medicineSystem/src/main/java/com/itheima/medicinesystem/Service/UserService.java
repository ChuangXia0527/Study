package com.itheima.medicinesystem.Service;

import com.itheima.medicinesystem.Entity.User;
import com.itheima.medicinesystem.Utils.TokenUtils;
import com.itheima.medicinesystem.common.Result;
import com.itheima.medicinesystem.Exception.serviceException;
import com.itheima.medicinesystem.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService{

    @Autowired
    private UserMapper userMapper;

    public User getUser(String username) {
        return userMapper.findByUsername(username);
    }

    public User login(User user) {
        User user1 = getUser(user.getUsername());
        if (user1 == null) {
            throw new serviceException("用户名不存在");
        }
        if (!user1.getPassword().equals(user.getPassword())) {
            throw new serviceException("密码错误");
        }
        //TokenUtils.createToken 是一个用于生成令牌的工具类方法
        String token = TokenUtils.createToken(user1.getId(), user1.getPassword());
        user1.setToken(token);
        return user1;
    }

    public Result register(User user) {
        User existingUser = getUser(user.getUsername());
        if (existingUser != null) {
            return Result.error("用户名已存在");
        }
        userMapper.insert(user);
        return Result.success("用户注册成功");
    }

    public Result save(User user) {
        boolean saved = userMapper.insert(user) > 0;
        if (saved) {
            return Result.success("用户添加成功");
        } else {
            return Result.error("添加用户失败");
        }
    }

    public Result updateById(User user) {
        boolean updated = userMapper.updateById(user) > 0;
        if (updated) {
            return Result.success("用户更新成功");
        } else {
            return Result.error("更新用户失败");
        }
    }

    public Result removeById(Integer id) {
        boolean removed = userMapper.deleteById(id) > 0;
        if (removed) {
            return Result.success("用户删除成功");
        } else {
            return Result.error("删除用户失败");
        }
    }

    public Result getById(Integer id) {
        User user = userMapper.selectById(id);
        if (user != null) {
            return Result.success(user);
        } else {
            return Result.error("用户不存在");
        }
    }
}