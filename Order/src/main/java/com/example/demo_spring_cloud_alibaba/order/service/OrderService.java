package com.example.demo_spring_cloud_alibaba.order.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.common.java.exception.base.BaseException;
import com.common.java.response.R;
import com.example.demo_spring_cloud_alibaba.common.enums.order.OrderStatusEnum;
import com.example.demo_spring_cloud_alibaba.common.exception.BusinessExceptionAssertResponseEnum;
import com.example.demo_spring_cloud_alibaba.common.params.order.OrderParams;
import com.example.demo_spring_cloud_alibaba.common.po.order.OrderPO;
import com.example.demo_spring_cloud_alibaba.common.vo.order.OrderVO;
import com.example.demo_spring_cloud_alibaba.common.vo.PairValueVO;
import com.example.demo_spring_cloud_alibaba.common.vo.product.ProductVO;
import com.example.demo_spring_cloud_alibaba.common.vo.user.UserVO;
import com.example.demo_spring_cloud_alibaba.order.mapper.IOrderMapper;
import com.example.demo_spring_cloud_alibaba.order.ms.ProductFeignService;
import com.example.demo_spring_cloud_alibaba.order.ms.UserFeignService;
import com.example.demo_spring_cloud_alibaba.order.service.interfaces.IOrderService;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
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
    public OrderVO order(OrderParams params) throws BaseException {
        Long pid = params.getPid();
        Long uid = params.getUid();
        Integer number = params.getNumber();
        R<ProductVO> productR=productFeignService.checkout(pid, number);
        BusinessExceptionAssertResponseEnum.PRODUCT_NOT_FOUND.assertNotNull(productR, pid);
        ProductVO product = productR.getData();
        BusinessExceptionAssertResponseEnum.PRODUCT_NOT_FOUND.assertNotNull(product, pid);
        R<UserVO> userR=userFeignService.findById(uid);
        BusinessExceptionAssertResponseEnum.USER_NOT_FOUND.assertNotNull(userR, uid);
        UserVO user = userR.getData();
        BusinessExceptionAssertResponseEnum.USER_NOT_FOUND.assertNotNull(user, uid);
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
        log.info("{}",orderVO);
        return orderVO;
    }

    @GlobalTransactional(name = "demo_spring_cloud_alibaba_order_pay_trans_name", rollbackFor = Exception.class)
    public PairValueVO<UserVO, OrderVO> pay(Long oid) throws BaseException {
        OrderPO order = getById(oid);
        BusinessExceptionAssertResponseEnum.ORDER_NOT_FOUND.assertNotNull(order, oid);
        BusinessExceptionAssertResponseEnum.ORDER_STATUS_PAID.assertTrue(OrderStatusEnum.CREATED.toString().equals(order.getStatus().toString()), oid);
        order.setStatus(OrderStatusEnum.PAID);
        updateById(order);
        R<UserVO> userVO=userFeignService.pay(order.getUserId(), order.getAmount());
        OrderVO orderVO = new OrderVO();
        BeanUtils.copyProperties(order, orderVO);
        return new PairValueVO(userVO, orderVO);
    }
}
