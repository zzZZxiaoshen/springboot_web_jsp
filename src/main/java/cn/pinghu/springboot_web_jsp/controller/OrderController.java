package cn.pinghu.springboot_web_jsp.controller;

import cn.pinghu.springboot_web_jsp.dto.response.ListResponse;
import cn.pinghu.springboot_web_jsp.dto.response.OrderDto;
import cn.pinghu.springboot_web_jsp.dto.response.OrderQueryDto;
import cn.pinghu.springboot_web_jsp.dto.response.Response;
import cn.pinghu.springboot_web_jsp.entity.OrderEntity;
import cn.pinghu.springboot_web_jsp.entity.OrderQueryEntity;
import cn.pinghu.springboot_web_jsp.entity.response.HttpBizCode;
import cn.pinghu.springboot_web_jsp.entity.response.Pagination;
import cn.pinghu.springboot_web_jsp.entity.response.ResponseEntity;
import cn.pinghu.springboot_web_jsp.service.OrderService;
import cn.pinghu.springboot_web_jsp.utils.BeanHelper;
import cn.pinghu.springboot_web_jsp.utils.ExcelUtils;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 订单控制器
 *
 * @author shenkai
 * @date 2018/12/24
 */
@Controller
public class OrderController extends BaseController {

    @Autowired
    private OrderService orderService;

    /**
     * 显示订单列表
     */
    @ResponseBody
    @RequestMapping("/order")
    public Pagination findOrderList(@ModelAttribute OrderQueryEntity orderQueryEntity) {
        ListResponse<OrderDto> orderResponse = orderService.findOrderList(BeanHelper.convertBean(orderQueryEntity, OrderQueryDto::new));
        if (CollectionUtils.isEmpty(orderResponse.getResult())) {
            new Pagination<>();
        }
        return new Pagination<>(orderResponse.getTotal(), orderResponse.getResult());
    }

    /**
     * 输出订单的excel
     */
    @ResponseBody
    @RequestMapping("/order/excel")
    public void findOrderListExcel(@ModelAttribute OrderQueryEntity orderQueryEntity, HttpServletResponse response) {
        ListResponse<OrderDto> orderResponse = orderService.findOrderList(BeanHelper.convertBean(orderQueryEntity, OrderQueryDto::new));
        // 订单数据的封装
        List<OrderDto> result = orderResponse.getResult();
        List<OrderEntity> orderEntities = BeanHelper.convertBeans(result, OrderEntity::new);
        try {
            writeFile(response, ExcelUtils.createExcel(orderEntities,OrderEntity.class),System.currentTimeMillis() + ".xlsx");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
