package cn.pinghu.springboot_web_jsp;

import com.google.common.base.Splitter;
import com.google.common.reflect.TypeToken;
import org.assertj.core.util.Strings;
import org.junit.Test;

import java.lang.reflect.Type;
import java.util.List;

public class GuavaTest {

    @Test
    public void strings01() {
        Iterable<String> split = Splitter.on(',')
                .trimResults()
                .omitEmptyStrings()
                .split("foo,bar,,   qux");
        System.out.println("split = " + split);

     /*   String[] split1 = ",a,,b, ".split(",");
        for (String s : split1) {
            System.out.println("s = " + s);
        }*/
    }

    @Test
    public void test03() {
        TypeToken<List<String>> typeToken = new TypeToken<List<String>>() {
        };
        Type type = new TypeToken<List<String>>() {
        }.getType();
        System.out.println("type = " + type);
        boolean array = new TypeToken<List<String>>() {
        }.isArray();
        System.out.println("array = " + array);
    }
}
