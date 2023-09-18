package com.example.dezhou.dto;

import com.example.dezhou.enumDto.ClassEnum;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @description: Gamer
 * @date: 2023/9/8 下午4:24
 * @author: zcy
 * @version: 1.0
 */
@Data
public class Gamer implements Serializable {
    private Integer id;
    private List<Poker> handle;
    private List<Poker> allHandle;
    private List<Poker> finalHandle;
    private ClassEnum classEnum;
    private Integer ThreeNum;
    private Integer TwoNum;

    public  int compare(Gamer gamer){
        if(this.classEnum.getType()>gamer.classEnum.getType()){
            return 1;
        }
        if(this.classEnum.getType()==gamer.classEnum.getType()){
            for (int i = 0; i < 5; i++) {
                if(this.getFinalHandle().get(i).getSortNum() == gamer.getFinalHandle().get(i).getSortNum()){
                    continue;
                }
                if(this.getFinalHandle().get(i).getSortNum() > gamer.getFinalHandle().get(i).getSortNum()){
                    return 1;
                }
                return -1;
            }
            return 0;
        }
        return -1;
    }
}
