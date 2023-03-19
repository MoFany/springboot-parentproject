package com.mofany.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @author MoFany-J
 * @date 2023/2/10
 * @description Employee 员工表实体
 */
@Component
@Setter
@Getter
@ToString
@NoArgsConstructor
public class Employee implements Serializable {
    private Integer keyId;
    private Integer year;
    private Integer month;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") //前传后日期时间格式转换
    @JsonFormat(shape = JsonFormat.Shape.STRING, timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss") // 后传前日期时间格式转换
    private LocalDateTime createDate;
    private String fullName;
    private String enCode;
    private String sex;
    private Integer age;
    private String sfz;
    private String phone;
    private BigDecimal grossPay;
    private Float taxRatio;
    private BigDecimal netPay;
}