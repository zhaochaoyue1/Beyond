package com.example.dezhou.judgment;

import com.alibaba.fastjson.JSONObject;
import com.example.dezhou.dto.Gamer;
import com.example.dezhou.dto.Poker;
import com.example.dezhou.enumDto.ClassEnum;
import org.springframework.beans.BeanUtils;
import weixin.popular.bean.poi.Business;

import java.util.*;

/**
 * @description: JudgmentClass
 * @date: 2023/9/8 下午4:39
 * @author: zcy
 * @version: 1.0
 */
public class JudgmentClass {

    public static void matchPoker(Gamer gamer) {
        List<Poker> allHandle = gamer.getAllHandle();
        if (allHandle.size() != 7) {
            /*System.out.println(JSONObject.toJSONString(allHandle));*/
            throw new RuntimeException("非法参数");
        }
        allHandle.sort(Comparator.comparing(Poker::getSortNum).reversed());
        //是不是同花顺
        if (isTongHuaShun(gamer)) {
            return;
        }
        //是不是四条
        if(isFour(gamer)){
            return;
        }
        //葫芦
        if(hulu(gamer)){
            return;
        }
        //同花
        if(tonghua(gamer)){
            return;
        }
        //顺子
        if(isShunZi(gamer)){
            return;
        }
        //三条
        if(isThree(gamer)){
            return;
        }
        //两对
        if(isTwo(gamer)){
            return;
        }
        //一对
        if(isOne(gamer)){
            return;
        }
        isHigh(gamer);
    }

    private static boolean isHigh(Gamer gamer) {

        List<Poker> list = gamer.getAllHandle();

        List<Poker> finalPoker = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            finalPoker.add(list.get(i));
        }
        gamer.setFinalHandle(finalPoker);
        gamer.setClassEnum(ClassEnum.HIGN);
        return true;
    }

    private static boolean isOne(Gamer gamer) {
        if(gamer.getTwoNum() == null){
            return false;
        }
        List<Poker> list = gamer.getAllHandle();

        List<Poker> oneList = new ArrayList<>();
        List<Poker> TwoList = new ArrayList<>();
        for (Poker poker : list) {
            if (gamer.getTwoNum().intValue() == poker.getSortNum()) {
                TwoList.add(poker);
            } else {
                oneList.add(poker);
            }
        }
        for (int i = 0; i < 3; i++) {
            TwoList.add(oneList.get(i));
        }
        gamer.setFinalHandle(TwoList);
        gamer.setClassEnum(ClassEnum.ONE);
        return true;
    }

    private static boolean isTwo(Gamer gamer) {
        List<Poker> list = gamer.getAllHandle();
        Map<Integer,List<Poker>> map = new HashMap<>();
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i = 0; i < list.size(); i++) {
            Poker poker = list.get(i);
            if(map.containsKey(poker.getSortNum())){
                List<Poker> pokers = map.get(poker.getSortNum());
                pokers.add(poker);
                if(pokers.size()==2){
                    queue.add(poker.getSortNum());
                    gamer.setTwoNum(poker.getSortNum());
                }
            }else{
                List<Poker> pokers = new ArrayList<>();
                pokers.add(poker);
                map.put(poker.getSortNum(),pokers);
            }
        }
        if(queue.size() < 2){
            return false;
        }
        List<Poker> finalQueue = new ArrayList<>();
        Set<Integer> sets = new HashSet<>();
        for (int i = 0; i < 2; i++) {
            Integer poll = queue.poll();
            finalQueue.addAll(map.get(poll));
            sets.add(poll);
        }
        for (int i = 0; i < 5; i++) {
            if(!sets.contains(list.get(i).getSortNum())&&finalQueue.size()<5){
                finalQueue.add(list.get(i));
            }
        }
        gamer.setFinalHandle(finalQueue);
        gamer.setClassEnum(ClassEnum.TWO);
        return true;
    }

    private static boolean isThree(Gamer gamer) {
        if(gamer.getThreeNum() == null){
            return false;
        }
        List<Poker> list = gamer.getAllHandle();

        List<Poker> oneList = new ArrayList<>();
        List<Poker> threeList = new ArrayList<>();
        for (Poker poker : list) {
            if (gamer.getThreeNum().intValue() == poker.getSortNum()) {
                threeList.add(poker);
            } else {
                oneList.add(poker);
            }
        }
        for (int i = 0; i < 2; i++) {
            threeList.add(oneList.get(i));
        }
        gamer.setFinalHandle(threeList);
        gamer.setClassEnum(ClassEnum.THREE);
        return true;
    }

    private static boolean isShunZi(Gamer gamer) {
        List<Poker> list = gamer.getAllHandle();
        List<Poker> list2 = new ArrayList<>(list);
        list2.sort(Comparator.comparing(Poker::getNum));
        for (int i = 0; i < 3; i++) {
            Poker poker = list.get(i);
            List<Poker> newList = new ArrayList<>();
            int num = poker.getSortNum() - 1;
            newList.add(poker);
            List<Poker> minList = new ArrayList<>();
            Poker poker2 = list2.get(i);
            int minNum = poker2.getNum();
            minList.add(poker2);
            for (int j = i + 1; j < list.size(); j++) {
                Poker poker1 = list.get(j);
                Poker poker3 = list2.get(j);
                if(poker3.getNum()-1 == minNum){
                    minList.add(poker3);
                    minNum++;
                }
                if (poker1.getSortNum() != num) {
                    continue;
                }
                newList.add(poker1);
                if (newList.size() == 5) {
                    break;
                }
                num--;
            }
            if (minList.size() == 5) {
                gamer.setClassEnum(ClassEnum.SHUNZI);
                minList.sort(Comparator.comparing(Poker::getNum).reversed());
                gamer.setFinalHandle(minList);
                return true;
            }
            if (newList.size() == 5) {
                gamer.setClassEnum(ClassEnum.SHUNZI);
                gamer.setFinalHandle(newList);
                return true;
            }
        }
        return false;
    }

    private static boolean tonghua(Gamer gamer){
        List<Poker> list = gamer.getAllHandle();
        for (int i = 0; i < 3; i++) {
            Poker poker = list.get(i);
            List<Poker> newList = new ArrayList<>();
            newList.add(poker);
            for (int j = i + 1; j < list.size(); j++) {
                Poker poker1 = list.get(j);
                if (poker1.getType() != poker.getType()) {
                    continue;
                }
                newList.add(poker1);
                if (newList.size() == 5) {
                    break;
                }
            }
            if (newList.size() == 5) {
                gamer.setClassEnum(ClassEnum.TONGHUA);
                gamer.setFinalHandle(newList);
                return true;
            }
        }
        return false;
    }


    private static boolean hulu(Gamer gamer){
        List<Poker> allHandle = gamer.getAllHandle();
        SortedMap<Integer,List<Poker>> map = new TreeMap<>(Comparator.reverseOrder()) ;
        for (int i = 0; i < allHandle.size(); i++) {
            Poker poker = allHandle.get(i);
            if(map.containsKey(poker.getSortNum())){
                List<Poker> pokers = map.get(poker.getSortNum());
                pokers.add(poker);
                if(pokers.size()==3){
                    gamer.setThreeNum(poker.getSortNum());
                }
            }else{
                List<Poker> pokers = new ArrayList<>();
                pokers.add(poker);
                map.put(poker.getSortNum(),pokers);
            }
        }
        if(map.size()>4){
            return false;
        }
        List<Poker> finalPoker = new ArrayList<>();
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
        for (Map.Entry<Integer,List<Poker>> entry:map.entrySet()) {
            if(finalPoker.size() == 0){
                if(entry.getValue().size() == 3){
                    finalPoker.addAll(entry.getValue());
                }
                if(entry.getValue().size() == 2){
                    queue.offer(entry.getValue().get(0).getSortNum());
                }
            }else {
                if(entry.getValue().size() > 1){
                    queue.offer(entry.getValue().get(0).getSortNum());
                }
            }
        }
        if(finalPoker.size() == 3 && queue.size()>0){
            List<Poker> pokers = map.get(queue.poll());
            for (int i = 0; i < 2; i++) {
                finalPoker.add(pokers.get(i));
            }
            gamer.setClassEnum(ClassEnum.HULU);
            gamer.setFinalHandle(finalPoker);
            return true;
        }
        return false;
    }

    private static boolean isFour(Gamer gamer) {

        List<Poker> list = gamer.getAllHandle();

        for (int i = 0; i < 4; i++) {
            int j = i+1;
            while (j < list.size() && list.get(i).getNum() == list.get(j).getNum()&&j - i < 3) {
                    j++;
            }
            if (j - i == 3) {
                List<Poker> finalList = new ArrayList<>();
                if (i == 0) {
                    for (int k = 0; k < 4; k++) {
                        finalList.add(list.get(i));
                    }
                    finalList.add(list.get(j+1));
                }else {
                    for (int k = i; k <= j; k++) {
                        finalList.add(list.get(i));
                    }
                    finalList.add(list.get(0));
                }
                gamer.setFinalHandle(finalList);
                gamer.setClassEnum(ClassEnum.FOUR);
                return true;
            }
        }
        return false;
    }


    private static boolean isTongHuaShun(Gamer gamer) {
        List<Poker> list = gamer.getAllHandle();
        List<Poker> list2 = new ArrayList<>(list);
        list2.sort(Comparator.comparing(Poker::getNum));
        for (int i = 0; i < 3; i++) {
            Poker poker = list.get(i);
            List<Poker> newList = new ArrayList<>();
            int num = poker.getSortNum() - 1;
            newList.add(poker);
            List<Poker> minList = new ArrayList<>();
            Poker poker2 = list2.get(i);
            int minNum = poker2.getNum();
            minList.add(poker2);
            for (int j = i + 1; j < list.size(); j++) {
                Poker poker1 = list.get(j);
                Poker poker3 = list2.get(j);
                if(poker3.getNum()-1 == minNum && poker3.getType() == poker2.getType()){
                    minList.add(poker1);
                    minNum++;
                }
                if (poker1.getSortNum() != num || poker1.getType() != poker.getType()) {
                    continue;
                }
                newList.add(poker1);
                if (newList.size() == 5) {
                    break;
                }
                num--;
            }
            if(minList.size() == 5){
                gamer.setClassEnum(ClassEnum.tonghuaShun);
                minList.sort(Comparator.comparing(Poker::getNum).reversed());
                gamer.setFinalHandle(minList);
                return true;
            }
            if (newList.size() == 5) {
                gamer.setClassEnum(ClassEnum.tonghuaShun);
                gamer.setFinalHandle(newList);
                return true;
            }
        }
        return false;
    }
}
