package com.mofany.repository;

import com.mofany.entity.Student;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author MoFany-J
 * @date 2023/2/22
 * @description StudentRepository 数据访问层
 */
@Repository
public class StudentRepository {

    /**
     * redis模版
     */
    @Resource
    private StringRedisTemplate stringRedisTemplate;
    @Resource
    private RedisTemplate<Object, Object> redisTemplate;

    /**
     * 用于存字符串
     */
//    private ValueOperations<String, String> valueOpsStr = stringRedisTemplate.opsForValue();

    /**
     * 用于存对象
     */
//    private ValueOperations<Object, Object> valueOpsObject = redisTemplate.opsForValue();

    /**
     * 保存字符串到redis
     */
    public void saveString(String key, String value) {
        stringRedisTemplate.opsForValue().set(key, value);
    }

    /**
     * 保存对象到redis
     */
    public void saveStudent(Student stu) {
        redisTemplate.opsForValue().set(stu.getId(), stu);
    }

    /**
     * 保存List到redis
     */
    public void saveMultiStudents(Object key, List<String> stus) {
        redisTemplate.opsForValue().set(key, stus);
    }

    /**
     * 从redis中获得字符串数据
     */
    public String getString(String key) {
        return stringRedisTemplate.opsForValue().get(key);
    }

    /**
     * 从redis中获得对象数据
     */
    public Object getObject(Object key) {
        return redisTemplate.opsForValue().get(key);
    }
}
