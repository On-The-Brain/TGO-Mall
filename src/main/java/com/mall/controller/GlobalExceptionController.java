package com.mall.controller;

import org.apache.shiro.authc.AuthenticationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : Mr.Zhang
 * @version : 1.0
 * @package : com.softeem.controller
 * @ClassName : GlobalExceptionController
 * @projectName : Springmvc-Projct
 * @date : 2023/3/2 15:21
 */
@RestControllerAdvice
public class GlobalExceptionController {

    /**
     * 用于处理当前控制器类中的LoginException
     *
     * @param e
     * @return
     */
    @ExceptionHandler({AuthenticationException.class})
    public ResponseEntity<Object> AuthenticationException(Exception e) {
        Map<String, Object> data = new HashMap<>();
        data.put("code", "918");
        data.put("msg", e.getMessage());
        return ResponseEntity.ok(data);
    }
}
