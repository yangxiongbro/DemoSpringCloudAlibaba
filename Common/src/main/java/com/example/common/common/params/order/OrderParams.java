package com.example.common.common.params.order;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * <b><code>OrderParams</code></b>
 * <p/>
 * 下订单参数
 * <p/>
 * <b>Creation Time:</b> 2023/8/8 22:38
 *
 * @author yang xiong
 * @since SpringCloudAlibaba 1.0
 */
@Data
public class OrderParams {

    @NotNull
    private Long uid;

    @NotNull
    private Long pid;

    @NotNull
    @Min(1)
    private Integer number;
}
