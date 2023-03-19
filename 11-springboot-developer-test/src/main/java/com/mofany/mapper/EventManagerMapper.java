package com.mofany.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mofany.entity.EventManager;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author MoFany-J
 * @date 2023/2/22
 * @description EventManagerMapper
 */
@Mapper
public interface EventManagerMapper extends BaseMapper<EventManager> {

    /**
     * 行状态字段:
     * 执行状态为：-1时表未执行，可编辑或删除
     * 执行状态为： 0时表正在执行，只可编辑
     * 执行状态为： 1时表以完成，只可查看
     * */
    List<EventManager> queryAllEvent();

    /**
     * 新增
     * */
    int insertOneEvent(EventManager eventManager);


    /**
     * 删除
     * */
    int deleteEvent(List ids);

    /**
     * 修改
     * */
    int updateEvent(EventManager eventManager);
}
