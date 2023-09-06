package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.DecimalFormat;

@WebServlet("/CalculatorServlet")
public class CalculatorServlet extends HttpServlet {
    private static DecimalFormat df = new DecimalFormat("0.000");

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String function = request.getParameter("function");
        String value1 = request.getParameter("value1");
        String value2 = request.getParameter("value2");

        double result = 0.0;

        if (function != null && value1 != null && value2 != null) {
            double num1 = Double.parseDouble(value1);
            double num2 = Double.parseDouble(value2);

            if (function.equals("add")) {
                result = num1 + num2;
            } else if (function.equals("subtract")) {
                result = num1 - num2;
            } else if (function.equals("multiply")) {
                result = num1 * num2;
            } else if (function.equals("divide")) {
                if (num2 != 0) {
                    result = num1 / num2;
                } else {
                    out.println("Error: Division by zero");
                    return;
                }
            }
        }

        out.println("<html>");
        out.println("<head><title>Calculator Result</title></head>");
        out.println("<body>");
        out.println("<h1>Calculator Result</h1>");
        out.println("Function: " + function + "<br>");
        out.println("Value 1: " + value1 + "<br>");
        out.println("Value 2: " + value2 + "<br>");
        out.println("Result: " + df.format(result) + "<br>");
        out.println("</body></html>");
    }

    
}
