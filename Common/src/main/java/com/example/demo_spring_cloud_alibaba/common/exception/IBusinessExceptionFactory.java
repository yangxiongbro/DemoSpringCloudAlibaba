package com.example.demo_spring_cloud_alibaba.common.exception;

import com.common.java.exception.base.BaseException;
import com.common.java.exception.base.IBaseAssert;
import com.common.java.exception.base.IExceptionAssertResponseEnum;

import java.text.MessageFormat;

/**
 * <b><code>IBusinessExceptionFactory</code></b>
 * <p/>
 * IBusinessExceptionFactory
 * <p/>
 * <b>Creation Time:</b> 2023/11/8 22:30
 *
 * @author yang xiong
 * @since DemoSpringCloudAlibaba 1.0
 */
public interface IBusinessExceptionFactory extends IExceptionAssertResponseEnum, IBaseAssert {
    @Override
    default BaseException newException(Object... args) {
        String msg = MessageFormat.format(this.getMessage(), args);

        return new BusinessException(this, args, msg);
    }

    @Override
    default BaseException newException(Throwable t, Object... args) {
        String msg = MessageFormat.format(this.getMessage(), args);

        return new BusinessException(this, args, msg, t);
    }
}