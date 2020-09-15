package com.example.test;

import com.example.student.util.AppVersionUtils;
import com.example.student.util.DateTimeUtils;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;
import java.util.Date;

@Data
public class TaskDailyPlanEntity implements Serializable {
    private static final long serialVersionUID = -3783642119393263228L;

    private Integer id;
    private String title;
    private String description;
    private Integer credit;
    private Integer gold;
    private Integer creditType;
    private Integer creditSubType;
    private String extra;
    private int state;
    private String position;
    private int timesType;
    private int times;
    private int mark;
    private int priority;
    private String h5Jump;
    private String h5ActionText;
    private String h5Hint;
    private String h5Icon;
    //0表示幸运星 1 表示dec
    private int h5IconSmall;
    private String tailNum;
    private String androidVersion;
    private int upVersion;
    private String iosVersion;
    private Integer bounded;
    private Integer showValidDays;
    private Integer minIncome;
    private Integer maxIncome;
    private Date startDate;
    private Date endDate;
    private String startTime;
    private String endTime;
    private Date createTime;
    private Date updateTime;

    private String startDateStr;
    private String endDateStr;
    private Integer autoGain;

    public boolean isEffect(Long userId, String appVersion, boolean isIOS, boolean bounded, Date userCreateTime/*, int userIncome*/) {
        //尾号限制
        if (StringUtils.isNotBlank(this.tailNum) && !this.tailNum.contains(String.valueOf(userId % 10))) {
            return false;
        }

        //是否受限 0：受限：任务只针对受限区用户展示
        //  1：非受限：任务只针对非受限区用户展示
        //  null：不限：受限和非受限区用户都展示
        if (this.bounded != null) {
            if ((this.bounded == 0 && !bounded) || (this.bounded == 1 && bounded)) {
                return false;
            }
        }

        //版本限制
        if (upVersion == 0) {
            if (StringUtils.isNotBlank(this.androidVersion) && !isIOS
                    && AppVersionUtils.compareVersion(appVersion, this.androidVersion) < 0) {
                return false;
            }
            if (StringUtils.isNotBlank(this.iosVersion) && isIOS
                    && AppVersionUtils.compareVersion(appVersion, this.iosVersion) < 0) {
                return false;
            }
        } else {
            if (StringUtils.isNotBlank(this.androidVersion) && !isIOS
                    && !androidVersion.equals(appVersion)) {
                return false;
            }
            if (StringUtils.isNotBlank(this.iosVersion) && isIOS
                    && !iosVersion.equals(appVersion)) {
                return false;
            }
        }

/*        //限制总收入
        if (minIncome != null && maxIncome != null) {
            if (minIncome <= userIncome && userIncome <= maxIncome) {
                return false;
            }
        } else if (minIncome != null && userIncome >= minIncome) {
            return false;
        } else if (maxIncome != null && userIncome <= maxIncome) {
            return false;
        }*/

        if (userCreateTime != null) {
            //注册N天内有效
            if (this.showValidDays != null && this.showValidDays > 0) {
                if (DateTimeUtils.daysBetween(userCreateTime, new Date())+1 > this.showValidDays) {
                    return false;
                }
            }

            //注册时间在限制范围内
            if (startDate != null && endDate != null) {
                if (startDate.before(userCreateTime) && endDate.after(userCreateTime)) {
                    return false;
                }
            } else if (startDate != null && startDate.before(userCreateTime)) {
                return false;
            } else if (endDate != null && endDate.after(userCreateTime)) {
                return false;
            }
        }

        //时间段限制
        if (StringUtils.isNotBlank(startTime) && StringUtils.isNotBlank(endTime)) {
            Date now = DateTimeUtils.parseHHMMSS(DateTimeUtils.formatHHMMSS(new Date()));
            Date startTimeHMS = DateTimeUtils.parseHHMMSS(startTime);
            if (now != null && startTimeHMS != null && now.before(startTimeHMS)) {
                return false;
            }
            Date endTimeHMS = DateTimeUtils.parseHHMMSS(endTime);
            if (now != null && endTimeHMS != null && now.after(endTimeHMS)) {
                return false;
            }
        }

        return true;
    }
}

