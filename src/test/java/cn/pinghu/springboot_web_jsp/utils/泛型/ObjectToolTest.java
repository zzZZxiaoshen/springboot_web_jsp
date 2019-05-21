package cn.pinghu.springboot_web_jsp.utils.泛型;

import org.junit.Test;

import static org.junit.Assert.*;

public class ObjectToolTest {

    @Test
    public void show() {
        ObjectTool objectTool = new ObjectTool();
        objectTool.show("NIHAO");
        objectTool.show(123);

    }
}

