package com.mofany.service.impl;

import com.mofany.entity.EventManager;
import com.mofany.mapper.EventManagerMapper;
import com.mofany.service.EventManagerService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author MoFany-J
 * @date 2023/2/22
 * @description EventManagerServiceImpl
 */
@Service
public class EventManagerServiceImpl implements EventManagerService {
    @Resource
    private EventManagerMapper mapper;

    /**
     * 行状态字段:
     * 执行状态为：-1时表未执行，可编辑或删除
     * 执行状态为： 0时表正在执行，只可编辑
     * 执行状态为： 1时表以完成，只可查看
     */
    @Override
    public List<EventManager> queryAllEvent() {
        return mapper.queryAllEvent();
    }

    /**
     * 新增
     *
     * @param eventManager
     */
    @Override
    public int insertOneEvent(EventManager eventManager) {
        return mapper.insertOneEvent(eventManager);
    }

    /**
     * 删除
     *
     * @param ids
     */
    @Override
    public int deleteEvent(List ids) {
        return mapper.deleteEvent(ids);
    }

    /**
     * 修改
     *
     * @param eventManager
     */
    @Override
    public int updateEvent(EventManager eventManager) {
        return mapper.updateEvent(eventManager);
    }
}
