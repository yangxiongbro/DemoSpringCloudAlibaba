package com.example.order.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.example.common.common.po.OrderPO;
import com.example.common.common.vo.OrderVO;
import com.example.common.common.vo.ProductVO;
import com.example.common.common.vo.UserVO;
import com.example.order.ms.ProductFeignService;
import com.example.order.ms.UserFeignService;
import com.example.order.service.interfaces.IOrderService;
//import io.swagger.annotations.Api;
//import io.swagger.annotations.ApiImplicitParam;
//import io.swagger.annotations.ApiImplicitParams;
//import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/order")
@RestController
@RefreshScope
//@Api(tags = "订单Controller")
public class OrderController {
    @Autowired
    private IOrderService orderService;
    @Autowired
    private ProductFeignService productFeignService;
    @Autowired
    private UserFeignService userFeignService;

    @GetMapping("/{id}")
//    @ApiOperation(value = "根据id获取订单信息")
//    @ApiImplicitParams({
//            @ApiImplicitParam(name="id", value="订单id", dataType = "Long", paramType = "path")
//    })
    @SentinelResource("show")
    public OrderVO findById(@PathVariable("id") Long id) {
        return orderService.findById(id);
    }

    @GetMapping("/buy")
//    @ApiOperation(value = "购买商品")
//    @ApiImplicitParams({
//            @ApiImplicitParam(name="uid", value="用户id", dataType = "Long", paramType = "query"),
//            @ApiImplicitParam(name="pid", value="商品id", dataType = "Long", paramType = "query"),
//            @ApiImplicitParam(name="number", value="商品数量", dataType = "Integer", paramType = "query")
//    })
    public OrderVO buy(Long uid,Long pid,Integer number) {
        ProductVO product=productFeignService.findById(pid);
        UserVO user=userFeignService.findById(uid);
        OrderVO orderVO = null;
        if(null!=product&&null!=product.getId()&&null!=user&&null!=user.getId()&&null!=number) {
            OrderPO orderPO =new OrderPO();
            orderPO.setAmount(number*product.getPrice());
            orderPO.setNumber(number);
            orderPO.setPrice(product.getPrice());
            orderPO.setProductId(product.getId());
            orderPO.setUserId(user.getId());
            orderService.save(orderPO);
            orderVO = orderService.findById(orderPO.getId());
        }
        System.out.println(orderVO);
        return orderVO;
    }
}