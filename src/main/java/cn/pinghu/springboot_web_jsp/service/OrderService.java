package cn.pinghu.springboot_web_jsp.service;

import cn.pinghu.springboot_web_jsp.dto.response.ListResponse;
import cn.pinghu.springboot_web_jsp.dto.OrderDto;
import cn.pinghu.springboot_web_jsp.dto.OrderQueryDto;
import cn.pinghu.springboot_web_jsp.dto.response.Response;
import cn.pinghu.springboot_web_jsp.entity.OrderConversionEntity;

import java.util.List;

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

    /**
    * 批量更新线路
    * @param collect 线路封装的数据
    * @return 影响的行数
    */
    Response<Integer> bathUpDateRoute(List<OrderConversionEntity> collect);
}
