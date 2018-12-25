package cn.pinghu.springboot_web_jsp.entity.response;

import java.util.ArrayList;
import java.util.List;

/**
 * 控制层分页对象
 * @author zhuhongxin
 * @date 2018/09/26
 */
public class ResultList<E> {

    private long total = 0;
    private boolean hasNext;
    private List<E> result = new ArrayList<>();

    public ResultList() {

    }

    public ResultList(long total, boolean hasNext, List<E> result) {
        this.total = total;
        this.hasNext = hasNext;
        this.result = result;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public boolean isHasNext() {
        return hasNext;
    }

    public void setHasNext(boolean hasNext) {
        this.hasNext = hasNext;
    }

    public List<E> getResult() {
        return result;
    }

    public void setResult(List<E> result) {
        this.result = result;
    }

}
