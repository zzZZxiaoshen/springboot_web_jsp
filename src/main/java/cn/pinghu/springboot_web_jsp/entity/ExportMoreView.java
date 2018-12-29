package cn.pinghu.springboot_web_jsp.entity;

import com.google.common.collect.Lists;

import java.util.List;

public class ExportMoreView {
    private List<ExportView> moreViewList= Lists.newArrayList();

    public List<ExportView> getMoreViewList() {
        return moreViewList;
    }

    public void setMoreViewList(List<ExportView> moreViewList) {
        this.moreViewList = moreViewList;
    }
}