package cn.pinghu.springboot_web_jsp.dto;

/**
 * 订单查询条件
 * @author shenkai
 * @date 2018/12/25
 */
public class OrderQueryDto {

    private Integer start;
    private Integer end;

    public Integer getStart() {
        return start;
    }

    public void setStart(Integer start) {
        this.start = start;
    }

    public Integer getEnd() {
        return end;
    }

    public void setEnd(Integer end) {
        this.end = end;
    }
}
