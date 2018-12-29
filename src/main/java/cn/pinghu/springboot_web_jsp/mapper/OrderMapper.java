package cn.pinghu.springboot_web_jsp.mapper;

import cn.pinghu.springboot_web_jsp.domain.OrderDo;
import cn.pinghu.springboot_web_jsp.dto.OrderQueryDto;
import cn.pinghu.springboot_web_jsp.entity.OrderConversionEntity;
import cn.pinghu.springboot_web_jsp.entity.OrderEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OrderMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(OrderEntity record);

    int insertSelective(OrderEntity record);

    OrderEntity selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(OrderEntity record);

    int updateByPrimaryKey(OrderEntity record);

    /**
    * 查询订单总数
    * @return 订单数量
    */
    Integer selectCountOrder();

    /**
    *  查询订单信息
    * @return 订单信息
     * @param orderQuery
    */
    List<OrderDo> selectOrderList(OrderQueryDto orderQuery);

    /**
    * 批量更新线路
    * @param collect 线路信息
    * @return 用户信息
    */
    Integer updateOrderByOrderNo(List<OrderConversionEntity> collect);
}