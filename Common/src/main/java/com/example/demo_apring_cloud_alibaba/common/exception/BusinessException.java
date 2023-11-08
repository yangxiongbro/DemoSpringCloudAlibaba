package com.example.demo_apring_cloud_alibaba.common.exception;

import com.common.java.exception.base.BaseException;
import com.common.java.exception.base.IExceptionAssertResponseEnum;

/**
 * <b><code>BusinessException</code></b>
 * <p/>
 * BusinessException
 * <p/>
 * <b>Creation Time:</b> 2023/11/8 22:29
 *
 * @author yang xiong
 * @since DemoSpringCloudAlibaba 1.0
 */
public class BusinessException extends BaseException {

    private static final long serialVersionUID = 1L;

    public BusinessException(IExceptionAssertResponseEnum exceptionAssertResponseEnum, Object[] args, String message) {
        super(exceptionAssertResponseEnum, args, message);
    }

    public BusinessException(IExceptionAssertResponseEnum exceptionAssertResponseEnum, Object[] args, String message, Throwable cause) {
        super(exceptionAssertResponseEnum, args, message, cause);
    }
}
