package com.example.demo_spring_cloud_alibaba.order.controller;

import com.example.demo_apring_cloud_alibaba.common.params.order.OrderParams;
import com.example.demo_apring_cloud_alibaba.common.vo.PairValueVO;
import com.example.demo_apring_cloud_alibaba.common.vo.order.OrderVO;
import com.example.demo_apring_cloud_alibaba.common.vo.user.UserVO;
import com.example.demo_spring_cloud_alibaba.order.service.interfaces.IOrderService;
//import io.swagger.annotations.Api;
//import io.swagger.annotations.ApiImplicitParam;
//import io.swagger.annotations.ApiImplicitParams;
//import io.swagger.annotations.ApiOperation;
import io.seata.core.context.RootContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequestMapping("/")
@RestController
@RefreshScope
@Slf4j
//@Api(tags = "订单Controller")
public class OrderController {
    @Autowired
    private IOrderService orderService;

    @GetMapping("/{id}")
//    @ApiOperation(value = "根据id获取订单信息")
//    @ApiImplicitParams({
//            @ApiImplicitParam(name="id", value="订单id", dataType = "Long", paramType = "path")
//    })
    public OrderVO findById(@PathVariable("id") Long id) {
        log.info("seata xid ====================> {}", RootContext.getXID());
        return orderService.findById(id);
    }

    @PostMapping
    public OrderVO order(@Valid @RequestBody OrderParams params) throws Exception {
        log.info("seata xid ====================> {}", RootContext.getXID());
        return orderService.order(params);
    }

    @PostMapping("/pay/{oid}")
//    @ApiOperation(value = "购买商品")
//    @ApiImplicitParams({
//            @ApiImplicitParam(name="uid", value="用户id", dataType = "Long", paramType = "query"),
//            @ApiImplicitParam(name="pid", value="商品id", dataType = "Long", paramType = "query"),
//            @ApiImplicitParam(name="number", value="商品数量", dataType = "Integer", paramType = "query")
//    })
    public PairValueVO<UserVO, OrderVO> pay(@PathVariable("oid") Long oid) {
        log.info("seata xid ====================> {}", RootContext.getXID());
        return orderService.pay(oid);
    }
}