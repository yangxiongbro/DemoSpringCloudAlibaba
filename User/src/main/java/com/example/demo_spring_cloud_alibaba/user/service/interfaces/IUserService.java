package com.example.demo_spring_cloud_alibaba.user.service.interfaces;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.demo_apring_cloud_alibaba.common.po.user.UserPO;
import com.example.demo_apring_cloud_alibaba.common.vo.user.UserVO;

public interface IUserService extends IService<UserPO> {

    /**
     * @description: 支付
     * @param: uid - [Long]
     * @param: amount - [Double]
     * @return: com.example.common.common.vo.user.UserVO
     * @throws
     * @author yang xiong
     * @date 2023/8/8 23:48
     **/
    UserVO pay(Long uid, Double amount);
}
