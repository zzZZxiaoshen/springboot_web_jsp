package cn.pinghu.springboot_web_jsp;

/*
 * 泛型方法：把泛型定义在方法上
 */
public class ObjectTool1 {
	public <T> void show(T t) {
		System.out.println(t);
	}

	public  void show(boolean t) {
		System.out.println(t);
	}

	public static void main(String[] args) {
		ObjectTool1 tool = new ObjectTool1();
		String s = "s";
		tool.show(s);

		Integer num =1;
		tool.show(num);
	}

}
