package cn.pinghu.springboot_web_jsp.entity;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;

import java.math.BigDecimal;
import java.util.Date;

public class OrderEntity extends BaseRowModel {
    /**
	* 主键Id
	*/
    @ExcelProperty(value = "ID" ,index = 0)
    private Integer id;

    /**
	* 订单号
	*/
    @ExcelProperty(value = "订单号" ,index = 1)
    private String orderno;

    /**
	* 订单日期
	*/
    @ExcelProperty(value = "订单日期" ,index = 2)
    private Date orderdate;

    /**
	* 配送时间
	*/
    @ExcelProperty(value = "配送时间" ,index = 3)
    private String deliverytime;

    /**
	* 订单总额
	*/
    @ExcelProperty(value = "订单总额" ,index = 4)
    private BigDecimal totalprice;

    /**
	* 折扣
	*/
    @ExcelProperty(value = "折扣" ,index = 5)
    private BigDecimal discount;

    /**
	* 支付金额
	*/
    @ExcelProperty(value = "支付金额" ,index =6)
    private BigDecimal paid;

    /**
	* 客户名称
	*/
    @ExcelProperty(value = "客户名称" ,index = 6)
    private String customername;

    /**
	* 收货人
	*/
    @ExcelProperty(value = "收货人" ,index = 7)
    private String receiver;

    /**
	* 手机号
	*/
    @ExcelProperty(value = "手机号" ,index = 8)
    private String mobile;

    /**
	* 省份
	*/
    @ExcelProperty(value = "省份" ,index = 9)
    private String province;

    /**
	* 城市
	*/
    @ExcelProperty(value = "城市" ,index = 10)
    private String city;

    /**
	* 区域
	*/
    @ExcelProperty(value = "区域" ,index = 11)
    private String area;

    /**
	* 详细地址
	*/
    @ExcelProperty(value = "详细地址" ,index = 12)
    private String address;

    /**
	* 购买人备注
	*/
    @ExcelProperty(value = "购买人备注" ,index = 13)
    private String buyermark;

    /**
	* 订单备注
	*/
    @ExcelProperty(value = "订单备注" ,index = 13)
    private String remark;

    /**
	* ‘http://xxxx’, ‘http://xxxx’
	*/
    private String voucher;

    /**
	* 线路号
	*/
    @ExcelProperty(value = "线路号" ,index = 14)
    private Byte routeno;

    /**
	* 状态 1-待支付 2-已付款
	*/
    @ExcelProperty(value = "支付状态" ,index = 15)
    private String status;

    /**
	* 创建时间
	*/
    @ExcelProperty(value = "创建时间" ,index = 16)
    private Date gmtcreated;

    /**
	* 最后修改时间
	*/
    @ExcelProperty(value = "最后修改时间" ,index = 17)
    private Date gmtmodified;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrderno() {
        return orderno;
    }

    public void setOrderno(String orderno) {
        this.orderno = orderno;
    }

    public Date getOrderdate() {
        return orderdate;
    }

    public void setOrderdate(Date orderdate) {
        this.orderdate = orderdate;
    }

    public String getDeliverytime() {
        return deliverytime;
    }

    public void setDeliverytime(String deliverytime) {
        this.deliverytime = deliverytime;
    }

    public BigDecimal getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(BigDecimal totalprice) {
        this.totalprice = totalprice;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    public BigDecimal getPaid() {
        return paid;
    }

    public void setPaid(BigDecimal paid) {
        this.paid = paid;
    }

    public String getCustomername() {
        return customername;
    }

    public void setCustomername(String customername) {
        this.customername = customername;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBuyermark() {
        return buyermark;
    }

    public void setBuyermark(String buyermark) {
        this.buyermark = buyermark;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getVoucher() {
        return voucher;
    }

    public void setVoucher(String voucher) {
        this.voucher = voucher;
    }

    public Byte getRouteno() {
        return routeno;
    }

    public void setRouteno(Byte routeno) {
        this.routeno = routeno;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        if (status == true) {
            this.status = "已经支付";
            return;
        }
        this.status = "未支付";
    }

    public Date getGmtcreated() {
        return gmtcreated;
    }

    public void setGmtcreated(Date gmtcreated) {
        this.gmtcreated = gmtcreated;
    }

    public Date getGmtmodified() {
        return gmtmodified;
    }

    @Override
    public String toString() {
        return "OrderEntity{" +
                "id=" + id +
                ", orderno='" + orderno + '\'' +
                ", orderdate=" + orderdate +
                ", deliverytime='" + deliverytime + '\'' +
                ", totalprice=" + totalprice +
                ", discount=" + discount +
                ", paid=" + paid +
                ", customername='" + customername + '\'' +
                ", receiver='" + receiver + '\'' +
                ", mobile='" + mobile + '\'' +
                ", province='" + province + '\'' +
                ", city='" + city + '\'' +
                ", area='" + area + '\'' +
                ", address='" + address + '\'' +
                ", buyermark='" + buyermark + '\'' +
                ", remark='" + remark + '\'' +
                ", voucher='" + voucher + '\'' +
                ", routeno=" + routeno +
                ", status=" + status +
                ", gmtcreated=" + gmtcreated +
                ", gmtmodified=" + gmtmodified +
                '}';
    }

    public void setGmtmodified(Date gmtmodified) {


        this.gmtmodified = gmtmodified;
    }
}