package cn.pinghu.springboot_web_jsp;

public class ObjectTool2<T> {

    public void show(T s) {
        System.out.println(s);
    }

    public static void main(String[] args) {
        ObjectTool2<Integer> tool = new ObjectTool2<>();
        tool.show(2);
    }
}
