package cn.pinghu.springboot_web_jsp.entity;

import java.util.Date;

public class MsgClient {
    private Date birthday;
    private String clientname;
    private String clientphone;
    private String createby;
    private String Id;
    private String remark;

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getClientname() {
        return clientname;
    }

    public void setClientname(String clientname) {
        this.clientname = clientname;
    }

    public String getClientphone() {
        return clientphone;
    }

    public void setClientphone(String clientphone) {
        this.clientphone = clientphone;
    }

    public String getCreateby() {
        return createby;
    }

    public void setCreateby(String createby) {
        this.createby = createby;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

}
