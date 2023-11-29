package com.example.demo_spring_cloud_alibaba.order.controller;

import com.common.java.exception.base.BaseException;
import com.common.java.response.BaseResponse;
import com.common.java.response.R;
import com.example.demo_spring_cloud_alibaba.common.params.order.OrderParams;
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
    public BaseResponse findById(@PathVariable("id") Long id) {
        log.info("seata xid ====================> {}", RootContext.getXID());
        return new R<>(orderService.findById(id));
    }

    @PostMapping
    public BaseResponse order(@Valid @RequestBody OrderParams params) throws BaseException {
        log.info("seata xid ====================> {}", RootContext.getXID());
        return new R<>(orderService.order(params));
    }

    @PostMapping("/pay/{oid}")
//    @ApiOperation(value = "购买商品")
//    @ApiImplicitParams({
//            @ApiImplicitParam(name="uid", value="用户id", dataType = "Long", paramType = "query"),
//            @ApiImplicitParam(name="pid", value="商品id", dataType = "Long", paramType = "query"),
//            @ApiImplicitParam(name="number", value="商品数量", dataType = "Integer", paramType = "query")
//    })
    public BaseResponse pay(@PathVariable("oid") Long oid) throws BaseException {
        log.info("seata xid ====================> {}", RootContext.getXID());
        return new R<>(orderService.pay(oid));
    }
}