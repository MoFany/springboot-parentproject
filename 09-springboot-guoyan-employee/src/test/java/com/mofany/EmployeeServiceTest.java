package com.mofany;

import com.mofany.entity.Employee;
import com.mofany.mapper.EmployeeMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @author MoFany-J
 * @date 2023/2/10
 * @description EmployeeServiceTest
 */
@SpringBootTest
public class EmployeeServiceTest {
    @Autowired
    private EmployeeMapper employee;
    @Autowired
    private Employee employeeEntity;


    @Test
    public void test() {
        employeeEntity.setKeyId(null);
        employeeEntity.setYear(LocalDate.now().getYear());
        employeeEntity.setMonth(LocalDate.now().getMonth().getValue());
        employeeEntity.setCreateDate(LocalDateTime.now());
        employeeEntity.setFullName("蒋明辉");
        employeeEntity.setEnCode("2023001");
        employeeEntity.setSex("男");
        employeeEntity.setAge(23);
        employeeEntity.setSfz("622722199902200111");
        employeeEntity.setPhone("17693373571");
        BigDecimal before = new BigDecimal(8500.00);
        BigDecimal a = new BigDecimal(0.9);
        BigDecimal after = a.multiply(before);
        employeeEntity.setGrossPay(before); // 应发工资
        employeeEntity.setTaxRatio(a.floatValue()); // 税扣比例
        employeeEntity.setNetPay(after); // 实发工资
        System.out.println(employee.insert(employeeEntity));
    }
}
