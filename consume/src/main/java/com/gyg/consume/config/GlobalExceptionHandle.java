package com.gyg.consume.config;

import com.gyg.consume.base.R;
import com.gyg.consume.base.exception.GlobalException;
import com.gyg.consume.base.exception.SystemCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.net.SocketTimeoutException;

/**
 * @author 郭永钢
 */
@ControllerAdvice
public class GlobalExceptionHandle {

    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandle.class);
    @ExceptionHandler(value = GlobalException.class)
    @ResponseBody
    public R handle(HttpServletRequest request, GlobalException e) {
        logger.info("异常代码: {} , 异常信息: {}",e.getCode(),e.getMsg());
        R message = R.error().code(e.getCode()).message(e.getMsg());
        return message;
    }

    @ExceptionHandler(value = SocketTimeoutException.class)
    @ResponseBody
    public R handle(HttpServletRequest request, SocketTimeoutException e) {
        logger.info("异常代码: {} , 异常信息: {}", SystemCode.ServiceCall.getCode(), SystemCode.ServiceCall.getMessage());
        return R.error().fillSystemCode(SystemCode.ServiceCall);
    }
}

