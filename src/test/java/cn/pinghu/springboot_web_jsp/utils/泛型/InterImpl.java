package cn.pinghu.springboot_web_jsp.utils.泛型;

/**
 * 抽取共用代码 ，减少冗余作用。
 * @author shenkai
 * @date 2019/5/16
 */
public class InterImpl<T> implements Inter<T> {

	@Override
	public void show(T t) {
		System.out.println(t);
	}

}
