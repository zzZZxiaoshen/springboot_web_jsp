package cn.pinghu.springboot_web_jsp.service;

import cn.pinghu.springboot_web_jsp.controller.HolleWorldController;
import cn.pinghu.springboot_web_jsp.domain.OrderDo;
import cn.pinghu.springboot_web_jsp.dto.response.ListResponse;
import cn.pinghu.springboot_web_jsp.dto.OrderDto;
import cn.pinghu.springboot_web_jsp.dto.OrderQueryDto;
import cn.pinghu.springboot_web_jsp.dto.response.Response;
import cn.pinghu.springboot_web_jsp.dto.response.ResponseCode;
import cn.pinghu.springboot_web_jsp.entity.OrderConversionEntity;
import cn.pinghu.springboot_web_jsp.mapper.OrderMapper;
import cn.pinghu.springboot_web_jsp.utils.BeanHelper;
import com.alibaba.fastjson.JSONObject;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 订单服务
 * @author shenkai
 * @date 2018/12/25
 */
@Service
public class OrderServiceImpl implements OrderService {

    private static final org.apache.logging.log4j.Logger LOGGER = LogManager.getLogger(HolleWorldController.class);


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

    /**
    * 批量更新线路
    */
    @Override
    public Response<Integer> bathUpDateRoute(List<OrderConversionEntity> orderConversionList) {
        Response<Integer> response = Response.newInstance();
        int start = 0;
        int limit = 15;
        int size = orderConversionList.size();
        Integer i = null;
        while (start<size) {
            List<OrderConversionEntity> collect = orderConversionList.stream().skip(start).limit(limit).collect(Collectors.toList());
            if (( i = orderMapper.updateOrderByOrderNo(collect))<1) {
                LOGGER.error("cuowu"+ JSONObject.toJSONString(collect));
                return response.fill(ResponseCode.BIZ_ERROR, ResponseCode.BIZ_ERROR.getMessage(), null);
            }
            start += limit;
        }
        return response.fill(ResponseCode.SUCCESS, ResponseCode.SUCCESS.getMessage(), i);
    }

}
