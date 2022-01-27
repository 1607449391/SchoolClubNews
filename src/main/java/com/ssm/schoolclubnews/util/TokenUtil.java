package com.ssm.schoolclubnews.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Map;
import java.util.Set;

/*
 *@author：徐家庆
 *@time：2021-07-20 13:55
 *@description：
 *          jwt封装token相关方法
 *
 */
public class TokenUtil {


    /**
     * 获取token
     *
     * @param playloads 负载因子
     * @return 生成的token
     */
    public static String getToken(Map<String, String> playloads) {
        JWTCreator.Builder builder = JWT.create();
        if (!playloads.isEmpty()) {
            Set<String> keys = playloads.keySet();
            for (String key : keys) {
                builder.withClaim(key, playloads.get(key));

            }
        }
        String token = builder.sign(Algorithm.HMAC256(Dicts.TOKEN_SECRET_KEY));
        return token;
    }

    /**
     * token校验
     *
     * @param token token
     */
    public static DecodedJWT validate(String token) {
        JWTVerifier build = JWT.require(Algorithm.HMAC256(Dicts.TOKEN_SECRET_KEY)).build();
        return build.verify(token);
    }

    /**
     * 获取token payload数据
     *
     * @param token
     * @param key
     * @return
     */
    public static String getPayload(String token, String key) {
        DecodedJWT decode = JWT.decode(token);
        return decode.getClaim(key).asString();
    }
}
