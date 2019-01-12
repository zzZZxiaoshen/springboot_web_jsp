package cn.pinghu.springboot_web_jsp.entity;

import cn.afterturn.easypoi.excel.entity.ExportParams;

import java.util.List;

public class ExportView {

    public ExportView(){

    }


    private ExportParams exportParams;
    private List<?> dataList;
    private Class<?> cls;

    public ExportParams getExportParams() {
        return exportParams;
    }
    public void setExportParams(ExportParams exportParams) {
        this.exportParams = exportParams;
    }

    public Class<?> getCls() {
        return cls;
    }
    public void setCls(Class<?> cls) {
        this.cls = cls;
    }
    public List<?> getDataList() {
        return dataList;
    }
    public void setDataList(List<?> dataList) {
        this.dataList = dataList;
    }


    public ExportView(Builder builder) {
        this.exportParams = builder.exportParams;
        this.dataList = builder.dataList;
        this.cls = builder.cls;
    }

    public static class Builder {
        private ExportParams exportParams=null;
        private List<?> dataList=null;
        private Class<?> cls=null;

        public Builder() {

        }
        public Builder exportParams(ExportParams exportParams) {
            this.exportParams = exportParams;
            return this;
        }

        public Builder dataList(List<?> dataList) {
            this.dataList = dataList;
            return this;
        }
        public Builder cls(Class<?> cls) {
            this.cls = cls;
            return this;
        }

        public ExportView create() {
            return new ExportView(this);
        }
    }


}