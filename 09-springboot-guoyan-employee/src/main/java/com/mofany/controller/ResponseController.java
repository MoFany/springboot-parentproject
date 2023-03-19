package com.mofany.controller;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.mofany.entity.CommonResult;
import com.mofany.entity.Employee;
import com.mofany.mapper.EmployeeMapper;
import com.mofany.util.PagingUtil;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.*;

/**
 * @author MoFany-J
 * @date 2023/2/10
 * @description ResponseController 后端响应控制器
 */
@RestController
@RequestMapping("api")
public class ResponseController {

    /**
     * 进行数据访问的成员属性
     */
    @Resource
    private EmployeeMapper employeeMapper;

    /**
     * 假分页数据源
     */
    private static List<Employee> employees;

    /**
     * 多条件查询
     * 接口测试：http://localhost:8081/api/queryByCondition
     * {
     * 	"fullName":"蒋明辉"
     * }
     */
    @PostMapping("queryByCondition")
    @ResponseBody
    public CommonResult<List> queryData(@RequestBody Employee entity) {
        List<Employee> employees = employeeMapper.selectByEntity(entity);
        if (employees == null || employees.size()==0){
            return new CommonResult<>(3000,"查询失败");
        }
        return new CommonResult<>(2000,"查询成功",employees);
    }

    /**
     * 分页查询
     * 测试接口：http://localhost:8081/api/pagingQuery/1
     */
    @GetMapping("pagingQuery/{currentPages}")
    @ResponseBody
    public CommonResult<List> queryData(@PathVariable("currentPages") int currentPages) {
        if (employees == null || employees.size() == 0) {
            employees = employeeMapper.queryAll();
        }
        // 从当前页开始每页一条记录
        List<Object> paging = PagingUtil.paging(employees, currentPages, 1);
        if (paging==null || paging.size()==0){
            return new CommonResult<>(3000,"分页查询失败");
        }
        return new CommonResult<List>(2000,"分页查询成功",paging);
    }

    /**
     * 删除与批量删除
     * 测试接口：http://localhost:8081/api/batchDelete
     * {
     *  "ids":[4,5]
     * }
     *
     * 结果：
     * {
     * 	"code": 2000,
     * 	"message": "删除成功",
     * 	"data": 2
     * }
     */
    @DeleteMapping("batchDelete")
    @ResponseBody
    public CommonResult<Integer> batchDeleteData(@RequestBody Map<String, List> ids) {
        String key = "ids";
        int result = 0;
        UpdateWrapper<Employee> entity = new UpdateWrapper<>();
        entity.in("keyId", ids.get(key));
        result = employeeMapper.delete(entity);
        if (result == 0) {
            return new CommonResult<>(3000,"删除失败",result);
        }
        return new CommonResult<>(2000,"删除成功",result);
    }

    /**
     * 修改
     * 测试接口：http://localhost:8081/api/updateEmployee
     *
     *  {
     *  	"keyId":1,
     * 	    "createDate":"2023-02-14 09:59:00",
     *  	"sex":"男"
     * }
     */
    @PutMapping("updateEmployee")
    @ResponseBody
    public CommonResult<Integer> updateData(@RequestBody Employee employee) {
        UpdateWrapper<Employee> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("keyId", employee.getKeyId());
        int result = employeeMapper.update(employee, updateWrapper);
        if (result == 0) {
            return new CommonResult<>(3000,"修改失败",result);
        }
        return new CommonResult<>(2000,"修改成功",result);
    }

    /**
     * 插入
     * 测试接口：http://localhost:8081/api/insertEmployee
     *
     * {
     *     "year": 2023,
     *     "month": 2,
     *     "createDate": "2023-02-14 10:04:00",
     *     "fullName": "卡卡西",
     *    	"enCode": "2023003",
     *     "sex": "男",
     *    	"age": 20,
     *     "sfz": "622722199902200111",
     *     "phone": "17693373571",
     *     "grossPay": 10000.00,
     *     "taxRatio": 0.02
     * }
     */
    @PostMapping("insertEmployee")
    @ResponseBody
    public CommonResult<Integer> insertData(@RequestBody Employee employee) {
        employee.setNetPay(employee.getGrossPay().multiply(BigDecimal.valueOf(employee.getTaxRatio())));
        int result = employeeMapper.insert(employee);
        if (result == 0) {
            return new CommonResult<>(3000,"插入失败",result);
        }
        return new CommonResult<>(2000,"插入成功",result);
    }

}
