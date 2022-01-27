package com.ssm.schoolclubnews.services.impl;

import com.ssm.schoolclubnews.dao.IUserDao;
import com.ssm.schoolclubnews.exception.GlobalException;
import com.ssm.schoolclubnews.services.ILoginService;
import com.ssm.schoolclubnews.util.*;
import com.ssm.schoolclubnews.vo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/*
 *@author：
 *@time：2022-01-27 17:17
 *@description：
 *
 */
@Service
public class LogInService implements ILoginService {

    @Autowired
    private IUserDao userDao;

    @Autowired
    private RedisUtil<String> redisUtil;

    @Override
    public String login(String userName, String password) throws GlobalException {
        User user = userDao.getUserByUserName(userName);
        if (user == null) {
            throw new GlobalException(StatusCode.USERNAME_OR_PASSWORD_IS_ERROR);
        }
        String salt = user.getSalt();
        String encryption = MD5Util.getEncryption(password, salt, Dicts.MD5_ITERATIONS);
        if (encryption.equals(user.getPassword())) {
            String key = "token#" + user.getName();
            boolean haveKey = redisUtil.hasKey(key);
            String token = "";
            if (haveKey) {
                token = (String) redisUtil.get(key);
                redisUtil.expire(key, Dicts.TOKEN_EXPIRE_TIME);
            } else {
                Map<String, String> playload = new HashMap<>();
                playload.put("id", user.getId());
                playload.put("name", user.getName());
                playload.put("number", user.getNumber());
                token = TokenUtil.getToken(playload);
                redisUtil.lSetWithExpire(key, token, Dicts.TOKEN_EXPIRE_TIME);
            }
            return token;
        } else {
            throw new GlobalException(StatusCode.USERNAME_OR_PASSWORD_IS_ERROR);
        }
    }
}
