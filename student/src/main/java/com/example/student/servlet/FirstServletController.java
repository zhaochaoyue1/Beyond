package com.example.student.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *
 * springboot整合servlet方式一
 * @author java
 *<servlet>
 *    <servlet-name>FirstServletController</servlet-name>
 *    <servlet-class>com.zzp.controller.FirstServletController</servlet-class>
 *</servlet>
 *<servlet-mapping>
 *    <servlet-name>FirstServletController</servlet-name>
 *    <url-pattern>/firstServlet</url-pattern>
 *</servlet-mapping>
 */
@WebServlet(name="FirstServletController",urlPatterns="/firstServlet")
public class FirstServletController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("FirstServlet。。。。。。。。。。。。。");
    }

}