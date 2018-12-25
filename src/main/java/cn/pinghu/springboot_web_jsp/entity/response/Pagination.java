package cn.pinghu.springboot_web_jsp.entity.response;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * 分页参数
 * @author zhuhongxin
 * @date 2018/09/06
 */
public class Pagination<E> implements Serializable {

    /**
     * 数据总条数
     */
    private long total;
    /**
     * 数据列表
     */
    private List<E> rows;
    /**
     * 额外信息
     */
    private Map<String, Object> extInfo;

    public Pagination() {
    }

    public Pagination(long total, List<E> rows) {
        this.total = total;
        this.rows = rows;
    }

    public Pagination(long total, List<E> rows, Map<String, Object> extInfo) {
        this.total = total;
        this.rows = rows;
        this.extInfo = extInfo;
    }

    public Pagination(List<E> rows) {
        this.rows = rows;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public List<E> getRows() {
        return rows;
    }

    public void setRows(List<E> rows) {
        this.rows = rows;
    }

    public Map<String, Object> getExtInfo() {
        return extInfo;
    }

    public void setExtInfo(Map<String, Object> extInfo) {
        this.extInfo = extInfo;
    }

}
