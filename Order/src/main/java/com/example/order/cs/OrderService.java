package com.example.order.cs;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.common.common.po.OrderPO;
import com.example.common.common.vo.OrderVO;
import com.example.order.cs.interfaces.IOrderService;
import com.example.order.mapper.IOrderMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class OrderService extends ServiceImpl<IOrderMapper, OrderPO> implements IOrderService {
    public OrderVO findById(Long id) {
        OrderVO orderVO = new OrderVO();
        OrderPO orderPO = getById(id);
        if(null != orderPO){
            BeanUtils.copyProperties(orderPO, orderVO);
        }
        return orderVO;
    }
}
