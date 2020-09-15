package com.example.student.project.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ContributeRecordEntity implements Serializable {
    private Long id;
    //用户ID
    private Long userId;
    //所有徒弟贡献总金币
    private Long prenticeMoney;
    //所有徒孙贡献总金币
    private Long discipleMoney;
    //创建时间
    private Date createTime;
    //总收入
    private Long total;
    //时间标记
    private int dateMark;
    //徒弟昨日之前的所有金币
    private Long prenticeCountMoneyYesterday;
    //徒孙昨日之前的所有金币数
    private Long discipleCountMoneyYesterday;
    public Long getTotal(){
        return prenticeMoney+discipleMoney;
    }
}
