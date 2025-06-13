package org.zishu;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JwtTest {

    /**
     * 生成Jwt令牌
     */
    @Test
    public void testGenerateJwt(){
        Map<String, Object> dataMap = new HashMap<>();
        dataMap.put("id",1);
        dataMap.put("username","admin");
        String jwt = Jwts.builder().signWith(SignatureAlgorithm.HS256,"emlzaHU=")//于base64在线编码转化获取密钥
                .addClaims(dataMap)//添加自定义信息
                .setExpiration(new Date(System.currentTimeMillis()+3600*1000))//long data类型是时间戳(毫秒值) 当前时间开始往后一个小时过期
                .compact();//生成令牌
        System.out.println(jwt);//生成到控制台中
    }


    /**
     * 解析JWT令牌
     */
    @Test
    public void testParseJWT(){
        String token = "eyJhbGciOiJIUzI1NiJ9.eyJpZCI6MSwidXNlcm5hbWUiOiJhZG1pbiIsImV4cCI6MTc0OTgwNzc5OH0.Bd19m9_5i5ixR0ryaJkvWCno1T3jiYaKmJ_Yy_q9Ses";
        Claims claims = Jwts.parser()
                .setSigningKey("emlzaHU=")//指定密钥--与生成时的密钥一致
                .parseClaimsJws(token)//解析密钥
                .getBody();//获取自定义信息
        System.out.println(claims);
    }
}

