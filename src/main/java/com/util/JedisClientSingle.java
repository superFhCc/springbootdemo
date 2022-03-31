package com.util;

import com.config.JedisConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import java.util.*;

@Service
public class JedisClientSingle implements JedisClient {
    // @Autowired
    // private Jedis jedis;
    @Autowired
    private JedisConfig jedisConfig;

    public Jedis getJedis() {
        return jedisConfig.jedis();
    }

    public void returnJedis(Jedis jedis) {
        if(jedis != null) {
            jedis.close();
        }
    }

    @Override
    public String get(String key) {
        Jedis jedis = getJedis();
        String str = "";
        try {
            str = jedis.get(key);
            jedis.close();
        }catch (Exception e) {
            returnJedis(jedis);
            return null;
        }
        return str;
    }

    @Override
    public String set(String key, String value) {
        Jedis jedis = getJedis();
        String str = "";
        try {
            str = jedis.set(key, value);
            jedis.close();
        }catch (Exception e) {
            returnJedis(jedis);
            return null;
        }
        return str;
    }

    @Override
    public String hget(String hkey, String key) {
        Jedis jedis = getJedis();
        String str = "";
        try {
            str = jedis.hget(hkey, key);
            jedis.close();
        }catch (Exception e) {
            returnJedis(jedis);
            return null;
        }
        return str;
    }

    @Override
    public long hset(String hkey, String key, String value) {
        Jedis jedis = getJedis();
        long result = 0L;
        try {
            result = jedis.hset(hkey, key, value);
            jedis.close();
        }catch (Exception e) {
            returnJedis(jedis);
            return 0;
        }
        return result;
    }

    @Override
    public long incr(String key) {
        Jedis jedis = getJedis();
        long result = 0L;
        try {
            result = jedis.incr(key);
            jedis.close();
        }catch (Exception e) {
            returnJedis(jedis);
            return 0;
        }
        return result;
    }

    @Override
    public long expire(String key, int second) {
        Jedis jedis = getJedis();
        long result = 0L;
        try {
            result = jedis.expire(key, second);
            jedis.close();
        }catch (Exception e) {
            returnJedis(jedis);
            return 0;
        }
        return result;
    }

    @Override
    public long ttl(String key) {
        Jedis jedis = getJedis();
        long result = 0L;
        try {
            result = jedis.ttl(key);
            jedis.close();
        }catch (Exception e) {
            returnJedis(jedis);
            return 0;
        }
        return result;
    }

    @Override
    public long del(String key) {
        Jedis jedis = getJedis();
        long result = 0L;
        try {
            result = jedis.del(key);
            jedis.close();
        }catch (Exception e) {
            returnJedis(jedis);
            return 0;
        }
        return result;
    }

    @Override
    public long hdel(String hkey, String key) {
        Jedis jedis = getJedis();
        long result = 0L;
        try {
            result = jedis.hdel(hkey, key);
            jedis.close();
        }catch (Exception e) {
            returnJedis(jedis);
            return 0;
        }
        return result;
    }

    /**
     * 设置List集合
     *
     * @param key
     * @param list
     */
    @Override
    public void setList(String key, List<String> list) {
        Jedis jedis = getJedis();
        try {
            jedis.del(key);
            if(list.size() > 0) {
                // for(String s:list) {
                //// jedis.lpush(key, list.toArray(new String[list.size()]));
                // jedis.lpush(key,s);
                // }
                jedis.lpush(key, list.toArray(new String[list.size()]));
            }
            jedis.close();
        }catch (Exception e) {
            returnJedis(jedis);
            throw e;
        }finally {
            returnJedis(jedis);
        }
    }

    /**
     * 获取List集合
     *
     * @param key
     * @return
     */
    @Override
    public List<String> getList(String key) {
        Jedis jedis = getJedis();
        List<String> list = new ArrayList<String>();
        try {
            Long length = jedis.llen(key);
            list = jedis.lrange(key, 0, length - 1);
            jedis.close();
        }catch (Exception e) {
            returnJedis(jedis);
            // throw e;
            return null;
        }
        return list;
    }

    @Override
    public void addSet(String key, Set<String> set) {
        Jedis jedis = getJedis();
        try {
            jedis.del(key);
            if(set.size() > 0) {
                jedis.sadd(key, set.toArray(new String[set.size()]));
            }
            jedis.close();
        }catch (Exception e) {
            returnJedis(jedis);
            // throw e;
        }
    }

    @Override
    public Set<String> getSet(String key) {
        Jedis jedis = getJedis();
        Set<String> set = new HashSet<String>();
        try {
            set = jedis.smembers(key);
            jedis.close();
        }catch (Exception e) {
            returnJedis(jedis);
            return null;
        }
        return set;
    }

    @Override
    public void delByKeywords(String keywords) {
        Jedis jedis = getJedis();
        try {
            Set<String> keys = jedis.keys("*" + keywords + "*");
            Iterator<String> it = keys.iterator();
            while (it.hasNext()) {
                String key = it.next();
                System.out.println(key);
                jedis.del(key);
            }
            jedis.close();
        }catch (Exception e) {
            returnJedis(jedis);
            // throw e;
        }
    }
}
