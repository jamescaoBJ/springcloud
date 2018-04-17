package com.wjw.service.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SetOperations;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.stereotype.Service;

import com.wjw.service.RedisService;

@Service
public class RedisServiceImpl implements RedisService {

	@Autowired
	private RedisTemplate redisTemplate;
	@Override
	public boolean set(String key, Object value) {
		boolean result = false;
        try {
            ValueOperations<Serializable, Object> operations = redisTemplate.opsForValue();
            operations.set(key, value);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
	}

	@Override
	public boolean set(String key, Object value, Long expireTime) {
		boolean result = false;
        try {
            ValueOperations<Serializable, Object> operations = redisTemplate.opsForValue();
            operations.set(key, value);
            redisTemplate.expire(key, expireTime, TimeUnit.SECONDS);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
	}

	@Override
	public void remove(String... keys) {

		for (String key : keys) {
            remove(key);
        }
	}

	@Override
	public void removePattern(String pattern) {

		Set<Serializable> keys = redisTemplate.keys(pattern);
        if (keys.size() > 0) {
            redisTemplate.delete(keys);
        }
	}

	@Override
	public void remove(String key) {
		if (exists(key)) {
            redisTemplate.delete(key);
        }
	}

	@Override
	public boolean exists(String key) {
		 return redisTemplate.hasKey(key);
	}

	@Override
	public Object get(String key) {
		Object result = null;
        ValueOperations<Serializable, Object> operations = redisTemplate.opsForValue();
        result = operations.get(key);
        return result;
	}

	@Override
	public void hmSet(String key, Object hashKey, Object value) {
		 HashOperations<String, Object, Object>  hash = redisTemplate.opsForHash();
	     hash.put(key,hashKey,value);
	}

	@Override
	public Object hmGet(String key, Object hashKey) {
		HashOperations<String, Object, Object>  hash = redisTemplate.opsForHash();
        return hash.get(key,hashKey);
	}

	@Override
	public void lPush(String k, Object v) {
		ListOperations<String, Object> list = redisTemplate.opsForList();
        list.rightPush(k,v);
	}

	@Override
	public List<Object> lRange(String k, long l, long l1) {
		ListOperations<String, Object> list = redisTemplate.opsForList();
        return list.range(k,l,l1);
	}

	@Override
	public void add(String key, Object value) {
		SetOperations<String, Object> set = redisTemplate.opsForSet();
        set.add(key,value);
	}

	@Override
	public Set<Object> setMembers(String key) {
		SetOperations<String, Object> set = redisTemplate.opsForSet();
        return set.members(key);
	}

	@Override
	public void zAdd(String key, Object value, double scoure) {
		 ZSetOperations<String, Object> zset = redisTemplate.opsForZSet();
	     zset.add(key,value,scoure);
	}

	@Override
	public Set<Object> rangeByScore(String key, double scoure, double scoure1) {
		ZSetOperations<String, Object> zset = redisTemplate.opsForZSet();
        return zset.rangeByScore(key, scoure, scoure1);
	}

}
