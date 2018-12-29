package cn.pinghu.springboot_web_jsp.controller;

import cn.pinghu.springboot_web_jsp.dto.response.ListResponse;
import cn.pinghu.springboot_web_jsp.dto.OrderDto;
import cn.pinghu.springboot_web_jsp.dto.OrderQueryDto;
import cn.pinghu.springboot_web_jsp.entity.OrderEntity;
import cn.pinghu.springboot_web_jsp.entity.OrderQueryEntity;
import cn.pinghu.springboot_web_jsp.entity.response.Pagination;
import cn.pinghu.springboot_web_jsp.service.OrderService;
import cn.pinghu.springboot_web_jsp.utils.BeanHelper;
import cn.pinghu.springboot_web_jsp.utils.ExcelPoiUtil;
import cn.pinghu.springboot_web_jsp.utils.ExcelUtils;
import org.apache.logging.log4j.core.util.datetime.FastDateFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 订单控制器
 *
 * @author shenkai
 * @date 2018/12/24
 */
@Controller
public class OrderController extends BaseController {

    private static final FastDateFormat FORMAT = FastDateFormat.getInstance("yyyy-MM-dd");


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
     * 输出订单的excel easyExcel
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

    /**
     * 输出订单的excel easyPoI
     */
    @ResponseBody
    @RequestMapping("/order/excel02")
    public void findOrderListExcel01(@ModelAttribute OrderQueryEntity orderQueryEntity, HttpServletResponse response) {
        ListResponse<OrderDto> orderResponse = orderService.findOrderList(BeanHelper.convertBean(orderQueryEntity, OrderQueryDto::new));
        // 订单数据的封装
        List<OrderDto> result = orderResponse.getResult();
        List<OrderEntity> orderEntities = BeanHelper.convertBeans(result, OrderEntity::new);
         // 封装输出poi的参数
        Map<String, Object> map = new HashMap<>();
        map.put("title", "标题行");
        // 创建毎一行导出数据容器list
        List<Map<String, String>> listMap = new ArrayList<Map<String, String>>();
        for (int i = 0; i < orderEntities.size(); i++) {
            HashMap<String, String> lm = new HashMap<>();
            lm.put("id", orderEntities.get(i).getId()+"");
            lm.put("orderNo", orderEntities.get(i).getOrderno());
            lm.put("orderDate", orderEntities.get(i).getOrderdate()+"");
            lm.put("pai", orderEntities.get(i).getPaid()+"11111111");
            listMap.add(lm);
        }
        map.put("maplist", listMap);
        try {
            writeFile(response,ExcelPoiUtil.exportExcel(map),System.currentTimeMillis() + ".xls");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
