package cn.pinghu.springboot_web_jsp;

import com.google.common.base.Objects;
import com.google.common.collect.*;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * 谷歌工具类测试类
 * @author shenkai
 * @date 2019/4/12
 */
public class GuawaTest {

    /**
     *1、基本工具 [Basic utilities]
     *    Obejects.equals方法可以简化判空的操作。
     *   Objects.toStringHelper 可以加快自己测试速度
     */
    @Test
    public void test01() {
        String str1 = "1";
        String str2 = "2";
        Objects.equal(str1,str2);
    }

    /**
    *  2. 集合[Collections]
     *    a.不可变结合 ImmutableMap 等等
     *   b.新集合类型 Multiset Multimap Multimap的子类
    */
    @Test
    public void test02() {
        // 不可变list
        ImmutableList<String> list = ImmutableList.of("1", "2", "3", "4");
        //不可变map
        ImmutableMap<String, String> map = ImmutableMap.of("key1", "value", "key2", "value2");

        // 新集合 Multiset
        HashMultiset<Object> multiset = HashMultiset.create();
        // 新集合 listMultimap
        ArrayListMultimap<Object, Object> listMultimap = ArrayListMultimap.create();
    }

    /**
     *  2. 集合[Collections]
     *    强大的集合工具类：java.util.Collections中未包含的集合工具
     *    Lists、Sets、Maps Multisets Multimaps
     */
    @Test
    public void test03() {
        ArrayList<Object> objects = Lists.newArrayList("1","2","3","4");
        HashMap<Object, Object> map = Maps.newHashMap();
    }
}
