package com.example.demo_spring_cloud_alibaba.common.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <b><code>PaireValueVO</code></b>
 * <p/>
 * 两个对象
 * <p/>
 * <b>Creation Time:</b> 2023/8/8 22:28
 *
 * @author yang xiong
 * @since DemoSpringCloudAlibaba 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PairValueVO<V1,V2>{
    private V1 value1;

    private V2 value2;
}
