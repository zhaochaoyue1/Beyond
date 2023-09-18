package com.example.jdk8.file;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @description: PathToFile
 * @date: 2023/8/3 下午8:40
 * @author: zcy
 * @version: 1.0
 */
public class PathToFile {
    public static void main(String[] args) throws IOException {
        Path path = Paths.get("/Users/coohua/Documents/project/Beyond/student/src/test/java/com/example/jdk8/ArrayListT.java");
        byte[] bytes = Files.readAllBytes(path);
        System.out.println(new String(bytes, StandardCharsets.UTF_8));
    }
}
