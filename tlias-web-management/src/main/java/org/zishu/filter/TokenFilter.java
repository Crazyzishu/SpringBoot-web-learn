package org.zishu.filter;

import io.jsonwebtoken.Claims;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.zishu.utils.CurrentHolder;
import org.zishu.utils.JwtUtils;

import java.io.IOException;

@Slf4j
@WebFilter(urlPatterns = "/*")
public class TokenFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        //1.获取请求路径
        String requestURI = request.getRequestURI();// 相比于URL不包括协议,ip,端口,只包括:/employee/login

        //2.判断是否是登录请求,如果路径中包含 /login,说明是登陆操作->放行
        if(requestURI.contains("/login")){
            log.info("登录请求,放行");
            filterChain.doFilter(request,response);
            return;
        }

        //3.获取请求头中的token
        String token = request.getHeader("token");

        //4.判断token是否存在,如果不存在,说明用户没有登陆,返回错误信息(响应401状态码)
        if(token == null || token.isEmpty()){//isEmpty -> 用来判断是否为空字符串
            log.info("令牌为空,响应401状态码");
             response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
             return;
        }

        //5.如果token存在,校验令牌,如果校验失败 -> 返回错误信息(响应401状态码)
        try{
            // 解析 JWT 令牌，获取其中包含的声明信息
            Claims claims = JwtUtils.parseToken(token);
            // 从声明中提取用户 ID 并转换为 Integer 类型
            Integer empId = Integer.valueOf(claims.get("id").toString());

            CurrentHolder.setCurrentId(empId);//存入

            log.info("当前登录员工ID：{},将其存入TreadLocal",empId);

        } catch (Exception e){
            log.info("令牌非法,响应401状态码");
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return;
        }

        //6.校验通过,放行
        log.info("令牌合法,放行");
        filterChain.doFilter(request,response);

        //7.删除TreadLocal中的数据
        CurrentHolder.remove();
    }
}
