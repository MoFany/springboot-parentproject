package com.mofany.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Component;

/**
 * @author MoFany-J
 * @date 2023/2/22
 * @description WorkOrderManager 工单管理
 */
@Setter
@Getter
@ToString
@Component
@NoArgsConstructor
public class WorkOrderManager {
    /**
     * 序号id
     */
    private Integer id;
    /**
     * 工单号
     * */
    private String workOrderNum;
    /**
     * 事件名
     */
    private String workOrderName;
    /**
     * 事件地址
     */
    private String workOrderAddress;
    /**
     * 耗时
     */
    private Integer min;
    /**
     * 工单状态
     * 1为以处理
     * 0为处理中
     */
    private int workOrderStatus;
}
