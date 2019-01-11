package cn.pinghu.springboot_web_jsp.entity;

/**
 * 订单查询条件
 * @author shenkai
 * @date 2018/12/25
 */
public class OrderQueryEntity {

    /**
     * 开始索引
     */
    protected Integer start = 0;
    /**
     * 页大小
     */
    protected Integer limit = 10;

    public Integer getStart() {
        return start;
    }

    public void setStart(Integer start) {
        if (start != null && start > 0) {
            this.start = start;
        }
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        if (limit != null && limit > 0) {
            this.limit = limit;
        }
    }
}
