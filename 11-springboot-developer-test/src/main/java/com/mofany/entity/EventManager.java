package com.mofany.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

/**
 * @author MoFany-J
 * @date 2023/2/22
 * @description EventManager 事件管理
 */
@Setter
@Getter
@ToString
@Component
@NoArgsConstructor
public class EventManager {
    /**
     * 序号id
     */
    private Integer id;
    /**
     * 事件名
     */
    private String eventName;
    /**
     * 事件地址
     */
    private String eventAddress;
    /**
     * 创建日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate createDate;
    /**
     * 执行状态
     * -1 表示未执行
     * 0 表示正在执行
     * 1 表示执行完成
     */
    private int startStatus;
}
