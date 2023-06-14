package com.example.order.service.interfaces;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.common.common.po.OrderPO;
import com.example.common.common.vo.OrderVO;

public interface IOrderService extends IService<OrderPO> {
    OrderVO findById(Long id);
}
