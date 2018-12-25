package cn.pinghu.springboot_web_jsp.entity.response;

/**
 * 请求接口状态码
 * @author zhuhongxin
 * @date 2018/08/22
 */
public enum HttpBizCode {

	/**
	 * 成功
	 */
	SUCCESS(200, "成功"),
	/**
	 * 未登录
	 */
	NOT_LOGIN(201, "未登录"),
	/**
	 * 参数不合法
	 */
	ILLEGAL(202, "参数不合法"),
	/**
	 * 用户提示
	 */
	NOTICE(203, "用户提示"),
	/**
	 * 业务异常
	 */
	BIZ_ERROR(204, "业务异常"),
	/**
	 * 系统异常
	 */
	SYS_ERROR(205, "系统异常"),
	/**
	 * 请重置密码
	 */
	RESET_PW(206, "请重置密码"),
	/**
	 * 账号不存在
	 */
	ACCOUNT_NOT_EXIST(209, "账号不存在"),
	/**
	 * 密码错误
	 */
	PWD_ERROR(210, "密码错误"),
	/**
	 * 不存在
	 */
	NOT_EXISTS(211, "不存在"),
	/**
	 * 已过期
	 */
	EXPIRED(215, "已过期"),
	/**
	 * 无权限访问
	 */
	NOT_AUTH(403, "无权限访问"),
	/**
	 * 不存在
	 */
	EXISTS(216, "已存在");

	private int code;
	private String message;

	HttpBizCode(int code, String message) {
		this.code = code;
		this.message = message;
	}

	public int getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}

}
