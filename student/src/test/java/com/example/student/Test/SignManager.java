package com.example.student.Test;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.stereotype.Component;


@Slf4j
@Component
public class SignManager {

    private static final int INTERVAL = 59;

    /**
     * 根据毫秒数获取 从计算机 日历到今天的 天数
     *
     * @param mill
     * @return
     */
    public static Integer getSimpleDay(Long mill) {
        return ((Long) ((mill + 1000 * 60 * 60 * 8) / DateUtils.MILLIS_PER_DAY)).intValue();
    }
}
