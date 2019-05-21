package cn.pinghu.springboot_web_jsp;

import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import cn.afterturn.easypoi.util.PoiPublicUtil;
import cn.pinghu.springboot_web_jsp.entity.Student;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

public class RegexTestDemo {

    /**
     *  通过配置文件运行类中的方法
     * 反射：
     * 		需要有配置文件配合使用。
     * 		用class.txt代替。
     * 		并且你知道有两个键。
     * 			className
     * 			methodName
     */
     /**
     *  以硬编码的方式测试
     */
    @Test
    public void test() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class<?> clazz = Student.class;
        Constructor<?> constructor = clazz.getConstructor();
        Method method = clazz.getMethod("show");
        Object obj = constructor.newInstance();
        method.invoke(obj);
    }

    /**
    * 采用读取配置文件的方式进行解耦然后进行反射使用文件内部数据
    */
    @Test
    public void test02() throws IOException, ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        FileInputStream fin = new FileInputStream("C:\\Users\\lx\\Desktop\\student.txt");
        Properties properties = new Properties();
        properties.load(fin);
        String className = properties.getProperty("className");
        String methedName = properties.getProperty("methedName");
        regextMethed(className, methedName);
    }

    private void regextMethed(String className, String methedName) throws ClassNotFoundException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        Class<?> clazz = Class.forName(className);
        Constructor<?> constructor = clazz.getConstructor();
        Method method = clazz.getMethod(methedName);
        Object obj = constructor.newInstance();
        method.invoke(obj);
    }

}
