package com.example.student.Test;


import org.apache.commons.lang3.time.DateUtils;

public class SignModel {
    //最后一次签到的时间
    private Integer fromDate = SignManager.getSimpleDay(System.currentTimeMillis() - 64 * DateUtils.MILLIS_PER_DAY);   // 从 50 天前开始
    private Long status = 0L;        // 存储最多最近 64 天的签到详情
    private Integer count = 0;      // fromDate 之前的签到天数

    public Integer getFromDate() {
        return fromDate;
    }

    public void setFromDate(Integer fromDate) {
        this.fromDate = fromDate;
    }

    public Long getStatus() {
        return status;
    }

    public void setStatus(Long status) {
        this.status = status;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
