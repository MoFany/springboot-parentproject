package com.mofany.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author MoFany-J
 * @date 2023/1/15
 * @description Teacher
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@Component
/**
 * 读取配置属性的方式3（使用这种方式必须为属性提供setter方法，故外部为setter方法）
 * */
@ConfigurationProperties(prefix = "teacher")
public class Teacher {
    private Integer jobNum;
    private String name;
    private String sex;
    private String subject;
}
