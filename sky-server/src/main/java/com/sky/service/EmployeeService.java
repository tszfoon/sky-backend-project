package com.sky.service;

import com.sky.dto.EmployeeLoginDTO;
import com.sky.entity.Employee;

public interface EmployeeService {

    /**
     * 员工登录
     * @param employeeLoginDTO
     * @return
     * 返回一个 Employee 对象,11个参数和数据库的employee对应上。
     * EmployeeLoginDTO就username和password。
     */
    Employee login(EmployeeLoginDTO employeeLoginDTO);

}
