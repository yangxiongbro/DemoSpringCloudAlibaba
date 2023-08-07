package com.example.order.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.common.common.po.OrderPO;
import com.example.common.common.vo.OrderVO;
import com.example.common.common.vo.ProductVO;
import com.example.common.common.vo.UserVO;
import com.example.order.ms.ProductFeignService;
import com.example.order.ms.UserFeignService;
import com.example.order.service.interfaces.IOrderService;
import com.example.order.mapper.IOrderMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService extends ServiceImpl<IOrderMapper, OrderPO> implements IOrderService {

    @Autowired
    private ProductFeignService productFeignService;
    @Autowired
    private UserFeignService userFeignService;

    public OrderVO findById(Long id) {
        OrderVO orderVO = new OrderVO();
        OrderPO orderPO = getById(id);
        if(null != orderPO){
            BeanUtils.copyProperties(orderPO, orderVO);
        }
        return orderVO;
    }

    public OrderVO order(Long uid,Long pid,Integer number){
        ProductVO product=productFeignService.checkout(pid, number);
        UserVO user=userFeignService.findById(uid);
        OrderVO orderVO = null;
        if(null!=product&&null!=product.getId()&&null!=user&&null!=user.getId()&&null!=number) {
            OrderPO orderPO =new OrderPO();
            orderPO.setAmount(number*product.getPrice());
            orderPO.setNumber(number);
            orderPO.setPrice(product.getPrice());
            orderPO.setProductId(product.getId());
            orderPO.setUserId(user.getId());
            save(orderPO);
            orderVO = findById(orderPO.getId());
        }
        System.out.println(orderVO);
        return orderVO;
    }

    public OrderVO pay(Long oid){
        OrderPO orderPO = getById(oid);
        UserVO user=userFeignService.pay(orderPO.getUserId(), orderPO.getAmount());
        // 更新订单状态
        updateById(orderPO);
        OrderVO orderVO = new OrderVO();
        BeanUtils.copyProperties(orderPO, orderVO);
        return orderVO;
    }
}
