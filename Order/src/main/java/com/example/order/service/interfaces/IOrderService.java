package com.example.order.service.interfaces;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.common.common.po.OrderPO;
import com.example.common.common.vo.OrderVO;

public interface IOrderService extends IService<OrderPO> {
    OrderVO findById(Long id);

    /**
     * @description: 下订单，减库存
     * @param: uid - [Long]
     * @param: pid - [Long]
     * @param: number - [Integer]
     * @return: com.example.common.common.vo.OrderVO
     * @throws
     * @author yang xiong
     * @date 2023/7/31 23:08
     **/
    OrderVO order(Long uid,Long pid,Integer number);

    /**
     * @description: 减余额，改状态
     * @param: oid - [Long]
     * @return: com.example.common.common.vo.OrderVO
     * @throws
     * @author yang xiong
     * @date 2023/7/31 23:08
     **/
    OrderVO pay(Long oid);
}
