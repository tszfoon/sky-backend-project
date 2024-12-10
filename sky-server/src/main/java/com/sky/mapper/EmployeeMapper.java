package com.sky.mapper;

import com.sky.entity.Employee;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/***
 * 这个 EmployeeMapper 接口是 MyBatis 的 Mapper 接口，主要用于定义与数据库操作相关的方法。
 * 这个注解告诉 Spring 容器，这个接口是一个 MyBatis 的映射器，Spring 会自动扫描这个接口并创建相应的代理对象（实现类）。
 */
@Mapper
public interface EmployeeMapper {

    /**
     * 根据用户名查询员工
     * @param username
     * @return
     */
    @Select("select * from employee where username = #{username}")
    Employee getByUsername(String username);

}
