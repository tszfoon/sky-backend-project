package com.sky.controller.admin;

import com.sky.constant.JwtClaimsConstant;
import com.sky.dto.EmployeeLoginDTO;
import com.sky.entity.Employee;
import com.sky.properties.JwtProperties;
import com.sky.result.Result;
import com.sky.service.EmployeeService;
import com.sky.utils.JwtUtil;
import com.sky.vo.EmployeeLoginVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * 员工管理
 */
//等同于 @Controller 和 @ResponseBody 的组合
//用来处理 RESTful 风格的 Web 服务，返回 JSON 或其他数据格式。
@RestController
//用于指定类或方法的请求 URL 路径。在类上使用时，它指定了所有方法请求的基础路径
//通常与 @GetMapping、@PostMapping 等方法请求映射注解一起使用，来处理具体的请求。
@RequestMapping("/admin/employee")
//这是 Lombok 提供的注解，用于自动生成一个名为 log 的日志对象（基于 SLF4J），简化日志记录的代码。
@Slf4j
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private JwtProperties jwtProperties;

    /**
     * 登录
     *
     * @param employeeLoginDTO
     * @return
     */
    //@PostMapping 是 @RequestMapping 的快捷方式，专门用于处理 HTTP POST 请求。
    @PostMapping("/login")
    //这里的 EmployeeLoginDTO 就是请求体的对象。
    // @RequestBody 会把 POST 请求的 JSON 数据自动转换成 EmployeeLoginDTO 类型的对象，传递给方法。
    public Result<EmployeeLoginVO> login(@RequestBody EmployeeLoginDTO employeeLoginDTO) {
        log.info("员工登录：{}", employeeLoginDTO);

        Employee employee = employeeService.login(employeeLoginDTO);

        //登录成功后，生成jwt令牌
        Map<String, Object> claims = new HashMap<>();
        claims.put(JwtClaimsConstant.EMP_ID, employee.getId());
        String token = JwtUtil.createJWT(
                jwtProperties.getAdminSecretKey(),
                jwtProperties.getAdminTtl(),
                claims);

        EmployeeLoginVO employeeLoginVO = EmployeeLoginVO.builder()
                .id(employee.getId())
                .userName(employee.getUsername())
                .name(employee.getName())
                .token(token)
                .build();

        return Result.success(employeeLoginVO);
    }

    /**
     * 退出
     *
     * @return
     */
    @PostMapping("/logout")
    public Result<String> logout() {
        return Result.success();
    }

}
