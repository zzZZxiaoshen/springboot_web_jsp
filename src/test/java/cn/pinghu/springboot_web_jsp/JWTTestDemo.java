package cn.pinghu.springboot_web_jsp;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JWTTestDemo {

    @Test
    public void test01() throws UnsupportedEncodingException {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("alg", "HS256");
        map.put("typ", "JWT");
        String token = JWT.create()
                .withHeader(map)//header
                .withClaim("name", "zwz")//payload
                .withClaim("age", "18")
                .sign(Algorithm.HMAC256("secret"));//加密
        System.out.println("token = " + token);
    }

    @Test
    public void test() throws UnsupportedEncodingException {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("alg", "HS256");
        map.put("typ", "JWT");
        String token = JWT.create()
                .withHeader(map)//header
                .withClaim("name", "zwz")//payload
                .withClaim("age", "18")
                .sign(Algorithm.HMAC256("ec261428fda86c02d5dbb0a748e92e0b"));//加密

        JWTVerifier verifier = JWT.require(Algorithm.HMAC256("ec261428fda86c02d5dbb0a748e92e0b"))
                .build();
        DecodedJWT jwt = verifier.verify(token);
        Map<String, Claim> claims = jwt.getClaims();
        System.out.println(claims.get("name").asString());
    }

    @Test
    public void test02() {
        Date date = new Date(System.currentTimeMillis() + 30);
        System.out.println("date = " + date);
    }


}
