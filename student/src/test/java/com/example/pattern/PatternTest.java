package com.example.pattern;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Pattern与Matcher一起合作.Matcher类提供了对正则表达式的分组支持,以及对正则表达式的多次匹配支持.
 * 单独用Pattern只能使用Pattern.matches(String regex,CharSequence input)一种最基础最简单的匹配
 *
 * @description: Parttern
 * @date: 2021/7/16 下午11:29
 * @author: zcy
 * @version: 1.0
 *
 * 参考：https://www.cnblogs.com/gdwkong/articles/7782331.html
 * 正则表达式：https://blog.csdn.net/demon7552003/article/details/94884761
 */
public class PatternTest {

    public static void main(String[] args) {
        matchingNum();
        matchingNumAndString();
        testAppend();
    }


    private static Pattern MATCHING_NUM = Pattern.compile("\\d+");

    /**
     * 匹配数值(通过数字匹配，发散到字符匹配，都是一样的原理)
     * Matcher.matches()/ Matcher.lookingAt()/ Matcher.find()
     * Matcher类提供三个匹配操作方法,三个方法均返回boolean类型,当匹配到时返回true,没匹配到则返回false
     * matches()对整个字符串进行匹配，只有整个字符串都匹配了才返回true
     * lookingAt()对前面的字符串进行匹配，只有匹配到的字符串在最前面才返回true
     * find() 对字符串进行匹配，匹配的字符串可以在任何位置
     * <p>
     * Mathcer.start()/ Matcher.end()/ Matcher.group()
     * 当使用matches(),lookingAt(),find()执行匹配操作后,就可以利用以上三个方法得到更详细的信息.
     * start()返回匹配到的子字符串在字符串中的索引位置.
     * end()返回匹配到的子字符串的最后一个字符在字符串中的索引位置.
     * group()返回匹配到的子字符串
     */
    private static void matchingNum() {
        //matches()对整个字符串进行匹配，只有整个字符串都匹配了才返回true
        Matcher matcher = MATCHING_NUM.matcher("22bb22");
        System.out.println(matcher.matches());//false
        Matcher matcher1 = MATCHING_NUM.matcher("3344444");
        System.out.println(matcher1.matches());//true
        System.out.println(Pattern.matches("\\d+", "33bb"));//false

        //lookingAt()对前面的字符串进行匹配，只有匹配到的字符串在最前面才返回true
        Matcher matcher2 = MATCHING_NUM.matcher("a331a");
        System.out.println(matcher2.lookingAt());//false
        Matcher matcher3 = MATCHING_NUM.matcher("3a3");
        System.out.println(matcher3.lookingAt());//true

        //find() 对字符串进行匹配，匹配的字符串可以在任何位置
        Matcher matcher4 = MATCHING_NUM.matcher("aa3a");
        System.out.println(matcher4.find());//true
        Matcher matcher5 = MATCHING_NUM.matcher("3a");
        System.out.println(matcher5.find());//true
        Matcher matcher6 = MATCHING_NUM.matcher("abd");
        System.out.println(matcher6.find());//false;


        //测试 Mathcer.start()/ Matcher.end()/ Matcher.group()这 三个方法
        Matcher matcher7 = MATCHING_NUM.matcher("jfkjdkj133");
        //如果为true,也可以是matches、lookingAt,这三个方法必须调用
        if (matcher7.find()) {
            //输出匹配到字符串的起始索引下标
            int start = matcher7.start();
            System.out.println(start);//7
            //输出匹配到字符串的133的下一个字符的索引下包
            System.out.println(matcher7.end());//10
            //放回匹配到的字符串
            System.out.println(matcher7.group());//133
        }

    }

    private static final Pattern MATCHING_STRING_NUM = Pattern.compile("([a-z]+)(\\d+)");

    /**
     * start(),end(),group()均有一个重载方法它们
     * 是start(int i),end(int i),group(int i)专用于分组操作,Mathcer类还有一个groupCount()用于返回有多少组.
     */
    public static void matchingNumAndString() {
        System.out.println("-------------matchingNumAndString---------------");
        Matcher matcher = MATCHING_STRING_NUM.matcher("aaa2332aa");
        if (matcher.find()) {
            System.out.println(matcher.groupCount());//2
            System.out.println(matcher.start(1));//0
            System.out.println(matcher.end(1));//3
            System.out.println(matcher.start(2));//3
            System.out.println(matcher.end(2));//7
            System.out.println(matcher.group(1));//aaa
            System.out.println(matcher.group(2));//2332
        }

        //例如有一段文本,里面有很多数字,而且这些数字是分开的,
        // 我们现在要将文本中所有数字都取出来,利用java的正则操作是那么的简单.
        Matcher matcher1 = MATCHING_NUM.matcher("我的QQ是:456456 我的电话是:0532214 我的邮箱是:aaa123@aaa.com");
        while (matcher1.find()) {
            System.out.println(matcher1.group());
            //456456
            //0532214
            //123
        }
    }


    public static final Pattern APPEND_RE = Pattern.compile("java");

    public static void testAppend(){
        Matcher matcher = APPEND_RE.matcher("this is java ,java is NO.1,hahaha");
        StringBuffer sb = new StringBuffer();
        while (matcher.find()){
            matcher.appendReplacement(sb,"C++");
        }
        matcher.appendTail(sb);
        System.out.println(sb.toString());
    }
}
