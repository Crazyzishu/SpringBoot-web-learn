package org.zishu.utils;

import io.jsonwebtoken.*;
import java.util.Date;
import java.util.Map;

/**
 * JWT 工具类，用于生成和解析 JWT 令牌
 */
public class JwtUtils {

    // 使用与测试类中一致的密钥
    private static final String SECRET_KEY = "emlzaHU=";

    // 12小时毫秒数
    private static final long EXPIRATION = 12 * 60 * 60 * 1000;

    /**
     * 生成 JWT 令牌
     *
     * @param claims 自定义声明信息（如用户ID、用户名等）
     * @return 返回生成的 JWT 字符串
     */
    public static String generateToken(Map<String, Object> claims) {
        return Jwts.builder()
                .addClaims(claims)
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION)) // 设置过期时间为12小时后
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY) // 使用指定密钥签名
                .compact(); // 生成最终的JWT字符串
    }

    /**
     * 解析 JWT 令牌
     *
     * @param token 需要解析的 JWT 字符串
     * @return 返回解析后的 Claims 对象，包含自定义声明信息
     * @throws JwtException 如果令牌无效或签名不匹配
     */
    public static Claims parseToken(String token) throws JwtException {
        return Jwts.parser()
                .setSigningKey(SECRET_KEY) // 使用相同密钥进行验证
                .parseClaimsJws(token) // 解析并验证签名
                .getBody(); // 获取负载中的声明信息
    }
}
