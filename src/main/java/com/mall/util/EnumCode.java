package com.mall.util;

public enum EnumCode {
    // 定义成功的枚举常量，状态码，和描述
    SUCCESS(200,"ok"),// 这里的代码相当于：public static  final DataEnumCode SUCCESS = new DataEnumCode(0,“ok”)调用类有参构造传值
    // 定义系统异常的枚举常量，状态码，和描述
    SYSTEM_ERROR(5001,"服务器系统异常，请稍后..."),
    // 定义参数异常的枚举常量，状态码，和描述
    PARAMETER_ERROR(5002,"参数异常，认证失败..."),
    // 定义用户名存在异常的枚举常量，状态码，和描述
    USER_HAS_ERROR(5003,"用户名已存在....");// 注意上面的是逗号分隔，这里结束是分号

    // 定义的枚举常量属性。
    private final int code;// 状态码
    private final String message;// 描述

    /**
     * 私有构造,防止被外部调用
     */
    private EnumCode(int code, String message) {
        this.code = code;
        this.message = message;
    }
     /**
     * 定义方法,返回描述,跟常规类的定义get没区别
     * @return
     */
    public int getCode() {
        return code;
    }
    public String getMessage() {
        return message;
    }
}
