package com.sky.result;

import lombok.Data;

import java.io.Serializable;

/**
 * 后端统一返回结果
 * @param <T>
 */
/**
 *   Lombok 提供的注解
 *   简化代码，避免手动编写冗余的 Getter/Setter 等方法。
 */
/**
 * 为什么需要实现 Serializable 接口？
 * 在 Java 中，序列化的目的是将对象转换为字节流，这样可以进行存储（如写入磁盘、发送网络）或在不同 JVM 之间传输。
 * 当你需要将一个对象持久化（比如存储到文件中），或者将对象传输到远程系统时，该对象必须实现 Serializable 接口。
 */
@Data
public class Result<T> implements Serializable {

    private Integer code; //编码：1成功，0和其它数字为失败
    private String msg; //错误信息
    private T data; //数据

    //<T> Result<T> 是方法返回值类型
    public static <T> Result<T> success() {
        Result<T> result = new Result<T>();
        result.code = 1;
        return result;
    }

    public static <T> Result<T> success(T object) {
        Result<T> result = new Result<T>();
        result.data = object;
        result.code = 1;
        return result;
    }

    public static <T> Result<T> error(String msg) {
        Result result = new Result();
        result.msg = msg;
        result.code = 0;
        return result;
    }

}
