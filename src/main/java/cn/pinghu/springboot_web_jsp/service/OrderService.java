package cn.pinghu.springboot_web_jsp.service;

import cn.pinghu.springboot_web_jsp.dto.response.ListResponse;
import cn.pinghu.springboot_web_jsp.dto.response.OrderDto;
import cn.pinghu.springboot_web_jsp.dto.response.OrderQueryDto;
import cn.pinghu.springboot_web_jsp.entity.OrderQueryEntity;

/**
 * 订单服务层
 * @author shenkai
 * @date 2018/12/25
 */

public interface OrderService {

    /**
    * 查询订单列表分页
    * @return 订单信息
     * @param orderQuery
    */
    ListResponse<OrderDto> findOrderList(OrderQueryDto orderQuery);
}
