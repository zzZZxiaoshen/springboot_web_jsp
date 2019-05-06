package cn.pinghu.springboot_web_jsp;

import cn.pinghu.springboot_web_jsp.utils.Data.Array;
import cn.pinghu.springboot_web_jsp.utils.Data.ArrayStack;
import com.google.common.base.Splitter;
import org.junit.Test;
import java.util.List;

/**
 * 数组结构测试 类
 * @author shenkai
 * @date 2019/5/5
 */
public class DataTest {

    @Test
    public void test01(){
        Array array = new Array();
        for (int i = 0; i < 11; i++) {
         array.add(i,i);
        }
        System.out.println("array = " + array);
        array.add(1, 100);
        System.out.println("array = " + array);

        for (int i = 0; i < 8; i++) {
            array.removeFirst();
        }
        System.out.println("array = " + array);

        System.out.println(array.get(1));
        System.out.println(array.find(100));
        System.out.println(array.containElement(1000));
    }

    @Test
    public void test02(){
        ArrayStack<Integer> stack = new ArrayStack<>();
        for (int i = 0; i < 10; i++) {
            stack.push(i);
        }
        System.out.println("stack = " + stack);
        System.out.println("peek="+stack.peek());
        System.out.println(stack.getSize());
        System.out.println(stack.pop());
        System.out.println(stack.getSize());

    }

    /**
    * 括号匹配
    */
    @Test
    public void test03(){
//        System.out.println(match("{ [ ("));
        System.out.println(match1("{[]}"));
    }

    private boolean match(String param) {
        List<String> strings = Splitter.on(" ").splitToList(param);
        ArrayStack<String> stack = new ArrayStack<>();
        stack.push("{");
        stack.push("[");
        stack.push("(");
        if (!stack.pop().equals(strings.get(2))) {
            return false;
        } else if (!stack.pop().equals(strings.get(1))) {
            return false;
        } else  if (!stack.pop().equals(strings.get(0))){
            return false;
        }
        return stack.isEmpty();
    }

    private boolean match1(String str) {
        ArrayStack<Character> stack = new ArrayStack<>();
        char[] chars = str.toCharArray();
        for (char aChar : chars) {
            if (aChar == '{' || aChar == '[' || aChar == '(') {
                stack.push(aChar);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                Character topChar = stack.pop();
                if (aChar == ')' && topChar != '(') {
                    return false;
                }
                if (aChar == ']' && topChar != '[') {
                    return false;
                }
                if (aChar == '}' && topChar != '{') {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }


}
