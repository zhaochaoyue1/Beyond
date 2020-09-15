package com.example.student.project.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ContributeCountEntity implements Serializable {
    private Long userId;
    private Long prenticeCount;
    private Long discipleCount;
    private Long total;
    public Long getTotal(){
        return prenticeCount+discipleCount;
    }
}
