package net.xdclass.test.demo.domain;

/**
 * 功能描述 自定义异常类
 */
public class MyException extends RuntimeException {

    public MyException(String code, String msg){
        this.code = code;
        this.msg = msg;
    }

    private String code;
    private String msg;

    public String getCode(){
        return code;
    }

    public String getMsg(){
        return msg;
    }

    public void setCode(String code){
        this.code = code;
    }

    public void setMsg(String msg){
        this.msg = msg;
    }
}
