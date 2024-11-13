package com.itheima.medicinesystem.common;

import cn.hutool.core.util.StrUtil;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.itheima.medicinesystem.Entity.User;
import com.itheima.medicinesystem.Exception.serviceException;
import com.itheima.medicinesystem.mapper.UserMapper;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

public class JwtInterceptor implements HandlerInterceptor {

    @Resource
    private UserMapper userMapper;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {//拦截器
        String token = request.getHeader("token");
        if (StrUtil.isBlank(token)) {
            token = request.getParameter("token");
        }
        if (handler instanceof HandlerMethod) {//判断是否是方法
            AuthAccess annotation = ((HandlerMethod) handler).getMethodAnnotation(AuthAccess.class);
            if (annotation != null) {//判断是否有权限
                return true;
            }
        }
        if (StrUtil.isBlank(token)) {//判断token是否为空
            throw new serviceException("401", "请登录");
        }
        try {
            String userId = JWT.decode(token).getAudience().get(0);//获取用户id
            User user = userMapper.selectById(Integer.parseInt(userId));//根据用户id查询用户
            if (user == null) {
                throw new serviceException("401", "请登录");
            }

            JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256(user.getPassword())).build();
            jwtVerifier.verify(token);//验证token
        } catch (JWTVerificationException e) {
            throw new serviceException("401", "请登录");
        }
        return true;//放行
    }
}
