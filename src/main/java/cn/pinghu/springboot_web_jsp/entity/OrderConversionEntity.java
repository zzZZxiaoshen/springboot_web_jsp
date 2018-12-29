package cn.pinghu.springboot_web_jsp.entity;

import com.xuxueli.poi.excel.annotation.ExcelField;
import com.xuxueli.poi.excel.annotation.ExcelSheet;
import org.apache.poi.hssf.util.HSSFColor;
/**
 * 线路批量导入数据转换
 * @author zhuhongxin
 * @date 2018/12/19
 * http://www.xuxueli.com/xxl-excel/
 */

public class OrderConversionEntity {

    @ExcelField(name = "orderNo")
    private String orderNo;

    @ExcelField(name = "routeNo")
    private String routeNo;

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getRouteNo() {
        return routeNo;
    }

    public void setRouteNo(String routeNo) {
        this.routeNo = routeNo;
    }

}