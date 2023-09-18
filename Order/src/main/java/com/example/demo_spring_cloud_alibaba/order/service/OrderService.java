package com.example.demo_spring_cloud_alibaba.order.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo_apring_cloud_alibaba.common.enums.order.OrderStatusEnum;
import com.example.demo_apring_cloud_alibaba.common.params.order.OrderParams;
import com.example.demo_apring_cloud_alibaba.common.po.order.OrderPO;
import com.example.demo_apring_cloud_alibaba.common.vo.order.OrderVO;
import com.example.demo_apring_cloud_alibaba.common.vo.PairValueVO;
import com.example.demo_apring_cloud_alibaba.common.vo.product.ProductVO;
import com.example.demo_apring_cloud_alibaba.common.vo.user.UserVO;
import com.example.demo_spring_cloud_alibaba.order.mapper.IOrderMapper;
import com.example.demo_spring_cloud_alibaba.order.ms.ProductFeignService;
import com.example.demo_spring_cloud_alibaba.order.ms.UserFeignService;
import com.example.demo_spring_cloud_alibaba.order.service.interfaces.IOrderService;
import io.seata.spring.annotation.GlobalTransactional;
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

    @GlobalTransactional(name = "demo_spring_cloud_alibaba_order_trans_name", rollbackFor = Exception.class)
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

    @GlobalTransactional(name = "demo_spring_cloud_alibaba_order_pay_trans_name", rollbackFor = Exception.class)
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
