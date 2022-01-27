package com.ssm.schoolclubnews.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/*
 *@author：徐家庆
 *@time：2021-07-22 15:21
 *@description：
 *
 */
@Component
public class RedisUtil<T> {
    @Autowired
    private RedisTemplate<String, T> redisTemplate;

    /**
     * 为key设置过期时间
     *
     * @param key  key
     * @param time 过期时间 单位：秒
     * @return
     */
    public boolean expire(String key, long time) {
        try {
            if (time > 0) {
                return redisTemplate.expire(key, time, TimeUnit.SECONDS);
            }
        } catch (Exception e) {
            return false;
        }
        return false;
    }

    /**
     * 根据key获取过期时间
     *
     * @param key key
     * @return 过期时间 单位：秒
     */
    public long getExpire(String key) {
        return redisTemplate.getExpire(key, TimeUnit.SECONDS);
    }

    /**
     * 判断某个key是否存在
     *
     * @param key
     * @return
     */
    public boolean hasKey(String key) {
        try {
            return redisTemplate.hasKey(key);
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * 删除多个key
     *
     * @param key
     */
    public void deleteKey(String... key) {
        if (key != null && key.length > 0) {
            if (key.length == 1) {
                redisTemplate.delete(key[0]);
            } else {
                for (String str : key) {
                    Set<String> keys = redisTemplate.keys(str);
                    if (keys != null && keys.size() > 0) {
                        redisTemplate.delete(keys);
                    }

                }
            }
        }
    }

    /**
     * 根据key 获取value
     *
     * @param key
     * @return
     */
    public Object get(String key) {
        return key == null ? null : redisTemplate.opsForValue().get(key);
    }

    /**
     * value为object时
     *
     * @param key
     * @param val
     * @return
     */
    public boolean set(String key, T val) {
        try {
            redisTemplate.opsForValue().set(key, val);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 带有过期时间的设置值
     *
     * @param key
     * @param val
     * @param time 过期时间 单位：秒
     * @return
     */
    public boolean setWithExpire(String key, T val, long time) {
        try {
            redisTemplate.opsForValue().set(key, val, time, TimeUnit.SECONDS);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * 递增
     *
     * @param key
     * @param delta
     * @return
     */
    public long incr(String key, long delta) {
        if (delta < 0) {
            throw new RuntimeException("递增因子必须大于零");
        }
        return redisTemplate.opsForValue().increment(key, delta);
    }

    public long decr(String key, long delta) {
        if (delta < 0) {
            throw new RuntimeException("递增因子必须大于零");
        }
        return redisTemplate.opsForValue().decrement(key, delta);
    }

    /**************************************List*************************************************/
    /**
     * 获取指定范围内的list数据
     *
     * @param key
     * @param start
     * @param end
     * @return
     */
    public List<T> lGet(String key, long start, long end) {

        try {
            return redisTemplate.opsForList().range(key, start, end);
        } catch (Exception e) {
            return null;
        }
    }


    /**
     * 获取list的长度
     *
     * @param key
     * @return
     */
    public long lGetListSize(String key) {
        try {
            return redisTemplate.opsForList().size(key);
        } catch (Exception e) {
            return 0;
        }
    }

    /**
     * 获取指定元素
     *
     * @param key
     * @param index
     * @return
     */
    public Object lGetIndex(String key, long index) {
        try {
            return redisTemplate.opsForList().index(key, index);
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 把list放入redis
     *
     * @param key
     * @param val
     * @return
     */
    public boolean lSet(String key, T val) {
        try {
            redisTemplate.opsForList().rightPush(key, val);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean lSetWithExpire(String key, T val, long time) {
        try {
            redisTemplate.opsForList().rightPush(key, val);
            if (time > 0) {
                expire(key, time);
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * 把list 放入redis
     *
     * @param key
     * @param val
     * @return
     */
    public boolean lSet(String key, List<T> val) {
        try {
            Long aLong = redisTemplate.opsForList().rightPushAll(key, val);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean lSetString(String key, List<T> val) {
        try {
            redisTemplate.opsForList().rightPushAll(key, val);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean lSetMenuTree(String key, List<T> val) {
        try {
            redisTemplate.opsForList().rightPushAll(key, val);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean lSetWithExpire(String key, List<T> val, long time) {
        try {
            Long aLong = redisTemplate.opsForList().rightPushAll(key, val);
            expire(key, time);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean lSetMenu(String key, List<T> val) {
        try {
            Long aLong = redisTemplate.opsForList().rightPushAll(key, val);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean lSetMenuWithExpire(String key, List<T> val, long time) {
        try {
            redisTemplate.opsForList().rightPushAll(key, val);
            expire(key, time);
            return true;
        } catch (Exception e) {
            return false;
        }
    }


}
