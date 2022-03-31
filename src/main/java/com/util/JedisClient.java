package com.util;

import java.util.List;
import java.util.Set;

public interface JedisClient {
    String get(String key);
    
    String set(String key, String value);

    String hget(String hkey, String key);

    long hset(String hkey, String key, String value);

    long incr(String key);

    long expire(String key, int second);

    long ttl(String key);

    long del(String key);

    long hdel(String hkey, String key);

    public void setList(String key, List<String> list);

    public List<String> getList(String key);

    public void addSet(String key, Set<String> set);

    public Set<String> getSet(String key);

	void delByKeywords(String keywords);
}

