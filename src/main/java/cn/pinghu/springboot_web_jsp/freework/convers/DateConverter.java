package cn.pinghu.springboot_web_jsp.freework.convers;

import org.apache.commons.lang3.StringUtils;
import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DateConverter implements Converter<String, Date> {
    private static final List<String> FORMATS = new ArrayList<>();

    static {
        FORMATS.add("yyyy");
        FORMATS.add("yyyy-MM");
        FORMATS.add("yyyy-MM-dd");
        FORMATS.add("yyyy-MM-dd HH:mm");
        FORMATS.add("yyyy-MM-dd HH:mm:ss");
    }

    @Override
    public Date convert(String source) {
        SimpleDateFormat simpleDateFormat;
        if (source.matches("^\\d{4}$")) {
             return    paraseDate(source, FORMATS.get(0));
        }
        if (source.matches("^\\d{4}-\\d{1,2} $")) {
            return    paraseDate(source, FORMATS.get(1));
        }
        if (source.matches("^\\d{4}-\\d{1,2}-\\d{1,2} $")) {
            return    paraseDate(source, FORMATS.get(2));
        }
        if (source.matches("^\\d{4}-\\d{1,2}-\\d{1,2} {1}\\d{1,2}$")) {
            return    paraseDate(source, FORMATS.get(3));
        }
        if (source.matches("^\\d{4}-\\d{1,2}-\\d{1,2} {1}\\d{1,2}:\\d{1,2}:\\d{1,2}$")) {
            return    paraseDate(source, FORMATS.get(4));
        }
        return null;
    }

    /**
     * 将指定类型的字符传格式化成指定类型的时间类型
     * @param str string 字符型日期
     * @param framte  需要被格式化的格式
     * @return Date
     */
    public Date paraseDate(String str,String framte){
        if (StringUtils.isBlank(str) || StringUtils.isBlank(framte)) {
            return null;
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str);
        try {
            simpleDateFormat.parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
}
