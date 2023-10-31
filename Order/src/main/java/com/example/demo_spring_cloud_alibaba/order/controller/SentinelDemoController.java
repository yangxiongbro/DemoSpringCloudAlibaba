package com.example.demo_spring_cloud_alibaba.order.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.example.demo_spring_cloud_alibaba.order.handle.block.SentinelResourceBlockHandlerClass;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RequestMapping("/sentinel")
@RestController
@Slf4j
public class SentinelDemoController {

    private Random random = new Random();

    @GetMapping("/flow/fast")
    public String flowFast(){
        return "快速失败-正常访问";
    }

    @GetMapping("/flow/warmUp")
    public String flowWarmUp(){
        return "Warm Up-正常访问";
    }

    @GetMapping("/flow/lineUp")
    public String flowLineUp() throws InterruptedException {
        Thread.sleep(500);
        return "排队等待-正常访问";
    }

    @GetMapping("/flow/association/target")
    public String associationTarget(){
        return "关联-被限流目标-正常访问";
    }

    @GetMapping("/flow/association/resource")
    public String associationResource(){
        return "关联-关联资源-正常访问";
    }

    @SentinelResource("flowLinkResource")
    public String resource(){
        return "访问资源-正常访问";
    }

    @GetMapping("/flow/link/entry1")
    public String linkEntry1(){
        return "链路-入口资源1-" + resource();
    }

    @GetMapping("/flow/link/entry2")
    public String linkEntry2(){
        return "链路-入口资源2-" + resource();
    }

    @GetMapping("/meltdown/rt")
    public String meltdownRt() throws InterruptedException {
        Thread.sleep(5000);
        return "熔断-rt-正常访问";
    }

    @GetMapping("/meltdown/ratio")
    public String meltdownRation(){
        if(3 < random.nextInt(10)){
            int a = 10 / 0;
        }
        return "熔断-异常比例-正常访问";
    }

    @GetMapping("/meltdown/count")
    public String meltdownCount(){
        if(3 < random.nextInt(10)){
            int a = 10 / 0;
        }
        return "熔断-异常数-正常访问";
    }

    @GetMapping("/hotKey")
    @SentinelResource(value = "sentinelHotKey")
    public Integer hotKey(Integer id){
        return id;
    }

    public Integer handleSentinelHotKey(Integer id, BlockException exception){
        return -1;
    }


    /**
     * 单机阈值：5
     */
    @GetMapping("/sentinelResource")
    @SentinelResource(value = "sentinelResource", blockHandler = "sentinelResourceBlockHandler")
    public String sentinelResource(Integer id){
        log.info("sentinelResource,快速失败，id：{}");
        return "sentinelResource,快速失败，id：" + id + "-正常访问";
    }
    public String sentinelResourceBlockHandler(Integer id, BlockException blockException){
        return "sentinelResource,被限流，id：" + id + "-BlockHandler";
    }


    /**
     * 单机阈值：5
     */
    @GetMapping("/sentinelResource2")
    @SentinelResource(value = "sentinelResource2", blockHandlerClass = SentinelResourceBlockHandlerClass.class,blockHandler = "sentinelResource2BlockHandler")
    public String sentinelResource2(Integer id){
        return "sentinelResource2,快速失败，id：" + id + "-正常访问";
    }

}
