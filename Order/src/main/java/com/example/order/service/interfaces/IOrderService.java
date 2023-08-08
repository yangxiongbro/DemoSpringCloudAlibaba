package com.example.order.service.interfaces;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.common.common.params.order.OrderParams;
import com.example.common.common.po.order.OrderPO;
import com.example.common.common.vo.order.OrderVO;
import com.example.common.common.vo.PairValueVO;
import com.example.common.common.vo.user.UserVO;

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
    OrderVO order(OrderParams params);

    /**
     * @description: 减余额，改状态
     * @param: oid - [Long]
     * @return: com.example.common.common.vo.PairValueVO<com.example.common.common.vo.user.UserVO,com.example.common.common.vo.order.OrderVO>
     * @throws
     * @author yang xiong
     * @date 2023/8/8 22:32
     **/
    PairValueVO<UserVO, OrderVO> pay(Long oid);
}
