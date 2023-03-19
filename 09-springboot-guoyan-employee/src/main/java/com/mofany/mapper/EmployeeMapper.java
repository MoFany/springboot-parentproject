package com.mofany.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mofany.entity.Employee;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author MoFany-J
 * @date 2023/2/10
 * @description EmployeeMapper
 */
@Service
public interface EmployeeMapper extends BaseMapper<Employee> {
    /**
     * 自定义多条件查询
     * */
    List<Employee> selectByEntity(Employee employee);

    /**
     * 一次性查询全部数据
     * */
    List<Employee> queryAll();
}
