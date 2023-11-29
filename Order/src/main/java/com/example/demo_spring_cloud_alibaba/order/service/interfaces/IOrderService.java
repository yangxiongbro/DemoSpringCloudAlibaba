package com.example.demo_spring_cloud_alibaba.order.service.interfaces;

import com.baomidou.mybatisplus.extension.service.IService;
import com.common.java.exception.base.BaseException;
import com.example.demo_spring_cloud_alibaba.common.params.order.OrderParams;
import com.example.demo_spring_cloud_alibaba.common.po.order.OrderPO;
import com.example.demo_spring_cloud_alibaba.common.vo.order.OrderVO;
import com.example.demo_spring_cloud_alibaba.common.vo.PairValueVO;
import com.example.demo_spring_cloud_alibaba.common.vo.user.UserVO;

public interface IOrderService extends IService<OrderPO> {
    OrderVO findById(Long id);

    /**
     * @description: 下订单，减库存
     * @param: params - [OrderParams]
     * @return: com.example.common.common.vo.order.OrderVO
     * @throws
     * @author yang xiong
     * @date 2023/8/8 22:43
     **/
    OrderVO order(OrderParams params) throws BaseException;

    /**
     * @description: 减余额，改状态
     * @param: oid - [Long]
     * @return: com.example.common.common.vo.PairValueVO<com.example.common.common.vo.user.UserVO,com.example.common.common.vo.order.OrderVO>
     * @throws
     * @author yang xiong
     * @date 2023/8/8 22:32
     **/
    PairValueVO<UserVO, OrderVO> pay(Long oid) throws BaseException;
}
