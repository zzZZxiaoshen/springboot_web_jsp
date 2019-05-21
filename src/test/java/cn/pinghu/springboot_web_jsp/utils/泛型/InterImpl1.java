package cn.pinghu.springboot_web_jsp.utils.泛型;

/**
 * 个人认为起约束作用
 * @author shenkai
 * @date 2019/5/16
 */
public class InterImpl1 implements Inter<String> {

	@Override
	public void show(String t) {
		System.out.println(t);
	}
 }
