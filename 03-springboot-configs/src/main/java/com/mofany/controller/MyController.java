package com.mofany.controller;

import com.mofany.entity.Student;
import com.mofany.entity.Teacher;
import lombok.AccessLevel;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * @author MoFany-J
 * @date 2023/1/15
 * @description MyController
 */
@RestController
@RequestMapping(value = "api")
/**
 * 一次性加载多个非全局配置文件
 * */
@PropertySource(
        /**
         * 一次性加载两个非全局配置文件
         * */
        value = {"application-dev.properties","application-pro.properties"},
        /**
         * 指定配置文件中的编码（同时解决了配置文件中中文参数乱码问题）
         * */
        encoding = "UTF-8")
/**
 * 读取前缀位production为前缀的属性值由setter方法进行JavaBean的映射
 * */
@ConfigurationProperties(prefix = "production")
//@ConfigurationProperties(prefix = "development")
public class MyController {
    @Resource
    private Student student;
    @Resource
    private Teacher teacher;

    /**
     * 读取配置属性值的方式1(需要Environment类实例来读取application配置文件的属性值)
     * */
    @Resource
    private Environment environment;

    @Value("${development.content}")
    private String developmentContent;
    @Value("${development.context}")
    private String developmentContext;

    @Value("${production.content}")
    private String productionContent;
    @Value("${production.context}")
    private String productionContext;

    /**
     * 限制setter方法的访问权限
     * */
    @Setter(AccessLevel.MODULE)
    private String content;
    @Setter(AccessLevel.MODULE)
    private String context;


    @GetMapping("student/{key}")
    @ResponseBody
    public Map<String, Map<String, Object>> studentRequestHandler(@PathVariable(name = "key")String key){
        Map<String,Map<String,Object>> supMap=new HashMap<>();
        Map<String,Object> subMap=new HashMap<>();
        subMap.put("id",student.getId());
        subMap.put("name",student.getName());
        subMap.put("sex",student.getSex());
        subMap.put("age",student.getAge());
        supMap.put(key,subMap);
        return supMap;
    }

    @GetMapping("teacher/{key}")
    @ResponseBody
    public Map<String, Map<String, Object>> teacherRequestHandler(@PathVariable(name = "key")String key){
        Map<String,Map<String,Object>> supMap=new HashMap<>();
        Map<String,Object> subMap=new HashMap<>();
        subMap.put("jobName",teacher.getJobNum());
        subMap.put("name",teacher.getName());
        subMap.put("sex",teacher.getSex());
        subMap.put("subject",teacher.getSubject());
        supMap.put(key,subMap);
        return supMap;
    }

    @GetMapping("animals/{key}")
    @ResponseBody
    public Map<String, Map<String, Object>> animalsRequestHandler(@PathVariable(name = "key")String key){
        Map<String,Map<String,Object>> supMap=new HashMap<>();
        Map<String,Object> subMap=new HashMap<>();
        subMap.put("classes", environment.getProperty("animals.classes"));
        subMap.put("name", environment.getProperty("animals.name"));
        subMap.put("color", environment.getProperty("animals.color"));
        subMap.put("age", environment.getProperty("animals.age"));
        supMap.put(key,subMap);
        return supMap;
    }

    @GetMapping("development/{key}")
    @ResponseBody
    public Map<String,Map<String,Object>> dev(@PathVariable(name = "key")String key){
        Map<String,Map<String,Object>> supMap=new HashMap<>();
        Map<String,Object> subMap=new HashMap<>();
        subMap.put("Development-Content",developmentContent );
        subMap.put("Development-Context",developmentContext );
        supMap.put(key,subMap);
        return supMap;
    }

    @GetMapping("production/{key}")
    @ResponseBody
    public Map<String,Map<String,Object>> pro(@PathVariable(name = "key")String key){
        Map<String,Map<String,Object>> supMap=new HashMap<>();
        Map<String,Object> subMap=new HashMap<>();
        subMap.put("Production-Content",productionContent );
        subMap.put("Production-Context",productionContext );
        supMap.put(key,subMap);
        return supMap;
    }

    @GetMapping("attribute/{key}")
    @ResponseBody
    public Map<String,Map<String,Object>> attr(@PathVariable(name = "key")String key){
        Map<String,Map<String,Object>> supMap=new HashMap<>();
        Map<String,Object> subMap=new HashMap<>();
        subMap.put("Content",content );
        subMap.put("Context",context );
        supMap.put(key,subMap);
        return supMap;
    }

    @GetMapping("test/{key}")
    public Map<String,Map<String,Object>> test(@PathVariable(name = "key")String key){
        /**
         * 通过当前类的类加载器去获取指定资源的字节输入流实例
         * */
        InputStream resourceAsStream = MyController.class.getClassLoader().getResourceAsStream("application.properties");
        /**
         * 创建Properties属性类实例
         * */
        Properties properties=new Properties();
        try {
            /**
             * 将资源对应的字节流实例装载到Properties实例中
             * */
            properties.load(resourceAsStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Map<String,Map<String,Object>> supMap=new HashMap<>();
        Map<String,Object> subMap=new HashMap<>();
        /**
         * 通过getProperties()方法获取配置文件指定键的对应值
         * */
        subMap.put("Class",properties.getProperty("animals.classes") );
        subMap.put("Name",properties.getProperty("animals.name"));
        subMap.put("Color",properties.getProperty("animals.color"));
        subMap.put("Age",properties.getProperty("animals.age"));
        supMap.put(key,subMap);
        return supMap;
    }
}
