package com.tzyy.tools;

import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BeanCopyUtils {
    private BeanCopyUtils(){}
    public static <V> V copyBean(Object source, Class<V> target) {
        V o;
        try {
            o = target.newInstance();
            BeanUtils.copyProperties(source, o);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
        return o;
    }
    public static <V> List<V>  copyBeanList(List<?> source, Class<V> target) {
        return source.stream().map(o -> copyBean(o, target)).collect(Collectors.toList());
    }
}
