package cn.pinghu.springboot_web_jsp.entity.response;

import java.io.Serializable;

/**
 * 接口返回结果类
 * @author zhuhongxin
 * @date 2018/08/22
 */
public class ResponseEntity implements Serializable {

    private static final long serialVersionUID = -8912267628340132131L;

    /**
     * 状态码
     * @see HttpBizCode
     */
    private int code = HttpBizCode.SUCCESS.getCode();
    private String message = "成功";
    private Object data;

    public ResponseEntity() {

    }

    public ResponseEntity(HttpBizCode code, String message, Object data) {
        this.fill(code, message, data);
    }

    public static ResponseEntity newInstance() {
        return new ResponseEntity();
    }

    public ResponseEntity fill(HttpBizCode code, String message, Object data) {
        this.code = code == null ? HttpBizCode.SUCCESS.getCode() : code.getCode();
        this.message = message;
        this.data = data;
        return this;
    }


    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public Object getData() {
        return data;
    }

}
