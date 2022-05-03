package com.example.student.util;

import org.codehaus.plexus.util.CollectionUtils;

import java.util.Map;

/**
 * @description: TestUtil
 * @date: 2021/12/22 下午3:42
 * @author: zcy
 * @version: 1.0
 */
public class TestUtil {
    /**
     * 引用外部jar包时，防止maven报错
     */
    public static void test(){
        Map<Object, Object> objectObjectMap = CollectionUtils.mergeMaps(null);
    }
}
