package com.example.order.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.common.common.enums.order.OrderStatusEnum;
import com.example.common.common.params.order.OrderParams;
import com.example.common.common.po.order.OrderPO;
import com.example.common.common.vo.order.OrderVO;
import com.example.common.common.vo.PairValueVO;
import com.example.common.common.vo.product.ProductVO;
import com.example.common.common.vo.user.UserVO;
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

    public OrderVO order(OrderParams params){
        Integer number = params.getNumber();
        ProductVO product=productFeignService.checkout(params.getPid(), number);
        UserVO user=userFeignService.findById(params.getUid());
        OrderVO orderVO = null;
        if(null!=product&&null!=user) {
            OrderPO orderPO =new OrderPO();
            orderPO.setAmount(number*product.getPrice());
            orderPO.setNumber(number);
            orderPO.setPrice(product.getPrice());
            orderPO.setProductId(product.getId());
            orderPO.setUserId(user.getId());
            orderPO.setStatus(OrderStatusEnum.CREATED);
            save(orderPO);
            orderVO = findById(orderPO.getId());
        }
        System.out.println(orderVO);
        return orderVO;
    }

    public PairValueVO<UserVO, OrderVO> pay(Long oid){
        OrderPO orderPO = getById(oid);
        orderPO.setStatus(OrderStatusEnum.PAID);
        updateById(orderPO);
        UserVO userVO=userFeignService.pay(orderPO.getUserId(), orderPO.getAmount());
        OrderVO orderVO = new OrderVO();
        BeanUtils.copyProperties(orderPO, orderVO);
        return new PairValueVO(userVO, orderVO);
    }
}
