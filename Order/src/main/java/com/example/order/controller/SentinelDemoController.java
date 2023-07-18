package com.example.order.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RequestMapping("/sentinel")
@RestController
public class SentinelDemoController {

    private Random random = new Random();

    /**
     * 单机阈值：5
     */
    @GetMapping("/flow/fast")
    public String flowFast(){
        return "快速失败";
    }

    /**
     * 单机阈值：9
     * 预热时长：3
     */
    @GetMapping("/flow/warmUp")
    public String flowWarmUp(){
        return "Warm Up";
    }

    /**
     * 单机阈值：3
     * 超时时间：700
     */
    @GetMapping("/flow/lineUp")
    public String flowLineUp() throws InterruptedException {
        Thread.sleep(500);
        return "排队等待";
    }

    /**
     * 单机阈值：5
     */
    @GetMapping("/flow/association/target")
    public String associationTarget(){
        return "关联-被限流目标";
    }

    @GetMapping("/flow/association/resource")
    public String associationResource(){
        return "关联-关联资源";
    }

    /**
     * 单机阈值：5
     */
    @SentinelResource("flowLinkResource")
    public String resource(){
        return "访问资源";
    }

    @GetMapping("/flow/link/entry1")
    public String linkEntry1(){
        return "链路-入口资源1-" + resource();
    }

    @GetMapping("/flow/link/entry2")
    public String linkEntry2(){
        return "链路-入口资源2-" + resource();
    }

    /**
     * 最大 RT：500
     * 比例阈值：0.5
     * 熔断时长：6
     * 最小请求数：5
     * 统计时长：1000
     */
    @GetMapping("/meltdown/rt")
    public String meltdownRt() throws InterruptedException {
        Thread.sleep(600);
        return "熔断-rt";
    }

    /**
     * 比例阈值：0.5
     * 熔断时长：6
     * 最小请求数：5
     * 统计时长：1000
     */
    @GetMapping("/meltdown/ratio")
    public String meltdownRation(){
        if(3 < random.nextInt(10)){
            int a = 10 / 0;
        }
        return "熔断-异常比例";
    }

    /**
     * 异常数：5
     * 熔断时长：70
     * 最小请求数：5
     * 统计时长：1000
     */
    @GetMapping("/meltdown/count")
    public String meltdownCount(){
        if(3 < random.nextInt(10)){
            int a = 10 / 0;
        }
        return "熔断-异常数";
    }
}
