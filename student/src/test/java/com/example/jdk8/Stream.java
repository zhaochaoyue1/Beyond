package com.example.jdk8;

import com.alibaba.fastjson.JSON;
import com.example.student.Student;
import org.assertj.core.util.Lists;

import java.util.*;
import java.util.stream.Collectors;

/**
 * https://blog.csdn.net/kenzyq/article/details/88540663（简单实用示例）
 * https://www.cnblogs.com/renchengtianshao/p/9843648.html(深入学习示例)
 */
public class Stream {
    public static void main(String[] args) throws Exception {
        List<Student> students = Lists.newArrayList();
        for (int i = 0; i <= 10; i++) {
            Student student = Student.builder()
                    .id(i)
                    .age(i)
                    .name("zcy" + i)
                    .build();
            students.add(student);
        }
        //按年纪分组
        //Map<String, List<Student>> collect = students.stream().collect(Collectors.groupingBy(student -> get(student.getAge())));
        //按年纪分组
        //Map<String, List<Student>> collect = students.stream().collect(Collectors.groupingBy(student -> student.getAge()+""));
        //按年纪分组
        //Map<String, List<Student>> collect = students.stream().collect(Collectors.groupingBy(student -> student.getAge() > 0 ? "1" : "0"));

        //根据age排序
        //students.sort(Comparator.comparing(Student::getAge).reversed());

        //提取age并排序(升序)
        //List<Integer> collect = students.stream().map(Student::getAge).distinct().sorted().collect(Collectors.toList());

        //提取age并排序(降序)
        //List<Integer> collect = students.stream().map(Student::getAge).distinct().sorted(Comparator.reverseOrder()).collect(Collectors.toList());

        //提取年纪大于5，id大于7的学生
        //List<Student> collect = students.stream().filter(s -> s.getAge() > 5 && s.getId() > 7).collect(Collectors.toList());

        //提取年纪大于5，id大于7的学生
        //Predicate<Student> predicate = s -> s.getAge() > 5 && s.getId() > 7;
        //List<Student> collect = students.stream().filter(predicate).collect(Collectors.toList());

        //累加年纪
        //int sum = students.stream().mapToInt(Student::getAge).sum();

        //累加年纪
        //Integer reduce = students.stream().map(Student::getAge).reduce(0, (sum, item) -> sum + item);

        //累加年纪
        //Integer reduce = students.stream().map(Student::getAge).reduce((sum, item) -> sum + item).get();


        /*List<Integer> nums = Lists.newArrayList(1, 1, null, 2, 3, 4, null, 5, 6
        , 7, 8, 9, 10);
        List<Integer> numsWithoutNull = nums.stream().filter(num -> num != null).
                collect(() -> new ArrayList<Integer>(),
                        (list, item) -> list.add(item),
                        (list1, list2) -> list1.addAll(list2));*/

        //查找年纪大于3且ID大于4的第一个学生
        //Student student = students.stream().filter(s -> s.getAge() > 3 && s.getId() > 4).findFirst().orElse(null);

        //根据对象的某一个唯一属性做未key
        //Map<Integer, Student> collect = students.stream().filter(s -> s.getId() > 9).collect(Collectors.toMap(Student::getId, n -> n));

        //查询年纪最大的学生
        //Student student = students.stream().max(Comparator.comparing(Student::getAge)).orElse(null);
        long count = students.stream().filter(s -> s.getAge() == 1).count();

        /*boolean present = Optional.ofNullable(students)
                .map(s -> s.get(0))
                .map(Student::getName)
                .map(s -> s.toUpperCase())
                .isPresent();*/
        System.out.println(JSON.toJSONString(count));
    }

    public static String get(int a) {
        return a > 0 ? "1" : "0";
    }

}
