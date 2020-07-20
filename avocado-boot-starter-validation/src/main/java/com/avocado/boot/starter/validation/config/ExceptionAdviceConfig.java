package com.avocado.boot.starter.validation.config;

import com.avocado.boot.starter.core.exception.BusinessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.ConstraintViolationException;

/**
 * 全局异常处理类
 *
 * @author ：qiaoliang
 * @date ：2020-06-29
 */
@ControllerAdvice
@ResponseBody
public class ExceptionAdviceConfig {
    /**
     * 处理Get请求中 使用@Valid 验证路径中请求实体校验失败后抛出的异常，详情继续往下看代码
     *
     * @author qiaoliang
     * @date 2019/8/23 16:49
     */
    @ExceptionHandler(BindException.class)
    public ResponseEntity<?> bindExceptionHandler(BindException e) {
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(e.getAllErrors().get(0).getDefaultMessage());
    }

    /**
     * 处理请求参数格式错误 @RequestParam上validate失败后抛出的异常是javax.validation.ConstraintViolationException
     *
     * @return org.springframework.http.ResponseEntity<?>
     * @author qiaoliang
     * @date 2019/8/23 16:49
     */
    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<?> constraintViolationExceptionHandler(ConstraintViolationException e) {
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(e.getConstraintViolations().iterator().next().getMessage());
    }

    /**
     * 处理请求参数格式错误 @RequestBody上validate失败后抛出的异常是MethodArgumentNotValidException异常。
     *
     * @return org.springframework.http.ResponseEntity<?>
     * @author qiaoliang
     * @date 2019/8/23 16:49
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> methodArgumentNotValidExceptionHandler(
            MethodArgumentNotValidException e) {
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(e.getBindingResult().getAllErrors().get(0).getDefaultMessage());
    }

    /***
     * 自定义异常捕捉
     * @author qiaoliang
     * @return org.springframework.http.ResponseEntity<?>
     * @date 2019/8/23 16:49
     */
    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<?> baseException(BusinessException e) {
        return ResponseEntity.status(e.getErrorType().getCode()).body(e.getErrorType().getMessage());
    }

}
