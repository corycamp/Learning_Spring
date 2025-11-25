package org.example;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/hello")
public class HelloServlet extends HttpServlet {


    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
        System.out.println("IN SERVICE");
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        out.println("<h2><b>Hello World</b></h2>");


    }
}
