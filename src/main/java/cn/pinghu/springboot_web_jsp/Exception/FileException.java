package cn.pinghu.springboot_web_jsp.Exception;

public class FileException extends  RuntimeException {

    private Integer code;

    public FileException(String msg) {
        super(msg);
    }


}
