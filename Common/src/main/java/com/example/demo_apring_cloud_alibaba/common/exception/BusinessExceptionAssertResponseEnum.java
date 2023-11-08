package com.example.demo_apring_cloud_alibaba.common.exception;

/**
 * <b><code>BusinessExceptionAssertResponseEnum</code></b>
 * <p/>
 * BusinessExceptionAssertResponseEnum
 * <p/>
 * <b>Creation Time:</b> 2023/11/8 22:30
 *
 * @author yang xiong
 * @since DemoSpringCloudAlibaba 1.0
 */
public enum BusinessExceptionAssertResponseEnum implements IBusinessExceptionFactory {
    /**
     * 未找到产品
     */
    PRODUCT_NOT_FOUND(4041001, "未找到产品:{0}."),

    /**
     * 未找到用户
     */
    USER_NOT_FOUND(4042001, "未找到用户:{0}."),

    /**
     * 未找到订单
     */
    ORDER_NOT_FOUND(4043001, "未找到订单:{0}."),

    /**
     * 订单已支付
     */
    ORDER_STATUS_PAID(4043011, "订单已支付:{0}.");

    /**
     * 返回码
     */
    private int code;

    /**
     * 返回消息
     */
    private String message;

    BusinessExceptionAssertResponseEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public int getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
