package com.itheima.medicinesystem.Utils;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.StrUtil;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.itheima.medicinesystem.Entity.User;
import com.itheima.medicinesystem.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import jakarta.servlet.http.HttpServletRequest;
import java.util.Date;

@Component
public class TokenUtils {

    private final UserMapper userMapper;

    // 使用构造器注入UserMapper
    @Autowired
    public TokenUtils(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    /**
     * 生成token
     *
     * @param userId 用户ID
     * @param password 用户密码，用作JWT签名的密钥
     * @return 生成的JWT字符串
     */
    public static String createToken(Integer userId, String password) {
        return JWT.create()
                .withAudience(String.valueOf(userId)) // 将 user id 保存到 token 里面,作为载荷
                .withExpiresAt(DateUtil.offsetHour(new Date(), 24)) // 24小时后token过期
                .sign(Algorithm.HMAC256(password)); // 以 password 作为 token 的密钥
    }

    /**
     * 从请求中获取当前登录的用户信息
     *
     * @return User对象，如果token无效或过期则返回null
     */
    public User getCurrentUser() {
        try {
            HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
            String token = request.getHeader("token");
            if (StrUtil.isNotBlank(token)) {
                String userId = JWT.decode(token).getAudience().get(0);
                return userMapper.selectById(Integer.valueOf(userId));
            }
        } catch (Exception e) {
            // 这里可以根据需要记录日志
            return null;
        }
        return null;
    }
}