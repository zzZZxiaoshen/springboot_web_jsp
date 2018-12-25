package cn.pinghu.springboot_web_jsp.service;

import cn.pinghu.springboot_web_jsp.domain.OrderDo;
import cn.pinghu.springboot_web_jsp.dto.response.ListResponse;
import cn.pinghu.springboot_web_jsp.dto.response.OrderDto;
import cn.pinghu.springboot_web_jsp.dto.response.OrderQueryDto;
import cn.pinghu.springboot_web_jsp.dto.response.ResponseCode;
import cn.pinghu.springboot_web_jsp.entity.OrderQueryEntity;
import cn.pinghu.springboot_web_jsp.mapper.OrderMapper;
import cn.pinghu.springboot_web_jsp.utils.BeanHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;
/**
 * 订单服务
 * @author shenkai
 * @date 2018/12/25
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper orderMapper;

    /**
    * 查询所有订单
     */
    @Override
    public ListResponse<OrderDto> findOrderList(OrderQueryDto orderQuery) {
        ListResponse<OrderDto> response = ListResponse.newInstance();
        Integer total = orderMapper.selectCountOrder();
        if ( total< 0) {
            return response.fill(ResponseCode.BIZ_ERROR, ResponseCode.BIZ_ERROR.getMessage(),  Collections.emptyList(),0,false);
        }
        List<OrderDo> orderDos = orderMapper.selectOrderList(orderQuery);
        if (CollectionUtils.isEmpty(orderDos)) {
            return response.fill(ResponseCode.BIZ_ERROR, ResponseCode.BIZ_ERROR.getMessage(),  Collections.emptyList(),0,false);
        }
        return response.fill(ResponseCode.SUCCESS, ResponseCode.SUCCESS.getMessage(), BeanHelper.convertBeans(orderDos,OrderDto::new),total,true);
    }

}
