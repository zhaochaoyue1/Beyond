package com.example.algorithm.dfa;

import com.alibaba.fastjson.JSONObject;
import lombok.Data;
import org.springframework.util.StopWatch;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @description: DFAWordFilter
 * @date: 2023/4/9 下午4:07
 * @author: zcy
 * @version: 1.0
 */
public class DFAWordFilter {
    // DFA节点类
    private static class Node {
        boolean isEnd;
        // 是否是词汇的结
        Map<Character, Node> next;

        // 下一个节点
        Node() {
            isEnd = false;
            next = new HashMap<>();
        }
    }

    private Node root;

    // DFA根节点
    // 构造函数，初始化DFA根节点
    public DFAWordFilter() {
        root = new Node();
    }

    // 添加词汇到DFA中
    public void addWord(String word) {
        Node node = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (!node.next.containsKey(c)) {
                node.next.put(c, new Node());
            }
            node = node.next.get(c);
        }
        node.isEnd = true;
    }

    // 判断文本中是否包含敏感词汇
    public Detail containsWord(String text) {
        Node node = root;
        int start = -1;
        int end = -1;
        Detail detail = new Detail();
        detail.setHave(false);
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (!node.next.containsKey(c)) {
                node = root;
                start = i + 1;
            } else {
                end++;
                node = node.next.get(c);
                if (node.isEnd) {
                    detail.setStart(start);
                    detail.setEnd(end);
                    detail.setHave(true);
                    return detail;
                }
            }
        }
        return detail;
    }

    // 判断文本中是否包含敏感词汇
    public String replace(String text) {
        Node node = root;
        int start = -1;
        int end = -1;
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (!node.next.containsKey(c)) {
                node = root;
                start = i + 1;
            } else {
                end++;
                node = node.next.get(c);
                if (node.isEnd) {
                    for (int j = start; j <= start+end; j++) {
                        text = text.replace(text.charAt(j),'*');
                    }
                    start = -1;
                    end = -1;
                }
            }
        }
        return text;
    }

    public static void main(String[] args) {
        //读取词文件并添加到DFA中
        DFAWordFilter filter = new DFAWordFilter();
        try (Scanner scanner = new Scanner(new File("/Users/coohua/Documents/project/Beyond/student/src/test/java/com/example/algorithm/dfa/words.txt"), "UTF-8")) {
            while (scanner.hasNextLine()) {
                String word = scanner.nextLine().trim();
                if (!word.isEmpty()) {
                    filter.addWord(word);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        StopWatch stopWatch = new StopWatch();
        stopWatch.start("测试");
        // 测试文本
        String text = "这是一段包含敏感词汇的文本，比如习近平、共产党、法轮功等。";
        System.out.println(text.indexOf("习近平"));
        // 判断文本中是否包含敏感词汇
        String replace = filter.replace(text);
        System.out.println(replace);
        /*System.out.println(JSONObject.toJSON(detail));
        if (detail.isHave()) {
            System.out.println("文本中包含敏感词汇");
        } else {
            System.out.println("文本中不包含敏感词汇");
        }*/
        stopWatch.stop();
        System.out.println(stopWatch.prettyPrint());
    }
}

@Data
class Detail {
    private boolean have;
    private int start;
    private int end;
}
