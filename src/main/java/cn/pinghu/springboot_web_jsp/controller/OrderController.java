package cn.pinghu.springboot_web_jsp.controller;

import cn.pinghu.springboot_web_jsp.dto.response.ListResponse;
import cn.pinghu.springboot_web_jsp.dto.response.OrderDto;
import cn.pinghu.springboot_web_jsp.dto.response.OrderQueryDto;
import cn.pinghu.springboot_web_jsp.entity.OrderQueryEntity;
import cn.pinghu.springboot_web_jsp.entity.response.Pagination;
import cn.pinghu.springboot_web_jsp.service.OrderService;
import cn.pinghu.springboot_web_jsp.utils.BeanHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 订单控制器
 * @author shenkai
 * @date 2018/12/24
 */
@Controller
public class OrderController {

    @Autowired
    private OrderService orderService;

    @ResponseBody
    @RequestMapping("/order")
    public Pagination findOrderList(@ModelAttribute OrderQueryEntity orderQueryEntity){
        ListResponse<OrderDto> orderResponse=orderService.findOrderList(BeanHelper.convertBean(orderQueryEntity, OrderQueryDto::new));
        if (CollectionUtils.isEmpty(orderResponse.getResult())) {
            new Pagination<>();
        }
        return new Pagination<>(orderResponse.getTotal(),orderResponse.getResult());
    }

}
