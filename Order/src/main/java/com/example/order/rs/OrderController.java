package com.example.order.rs;

import com.example.common.common.po.OrderPO;
import com.example.common.common.vo.OrderVO;
import com.example.common.common.vo.ProductVO;
import com.example.common.common.vo.UserVO;
import com.example.order.cs.interfaces.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/order")
@RestController
public class OrderController {
    @Autowired
    private IOrderService orderService;

    @GetMapping("/{id}")
    public OrderVO findById(@PathVariable("id") Long id) {
        return orderService.findById(id);
    }

    @GetMapping("/buy")
    public OrderVO buy(String uid,String pid,Integer number) {
        //通过restTemplate调用商品微服务
        ProductVO product=restTemplate.getForObject("http://127.0.0.1:8001/product/"+pid, ProductVO.class);
        UserVO user=restTemplate.getForObject("http://127.0.0.1:8002/user/"+uid, UserVO.class);
        OrderVO orderVO = null;
        if(null!=product&&null!=user&&null!=number) {
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