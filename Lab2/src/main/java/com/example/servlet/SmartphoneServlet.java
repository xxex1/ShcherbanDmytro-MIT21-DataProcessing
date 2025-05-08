package com.example.servlet;

import com.example.model.Smartphone;
import com.google.gson.Gson;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class SmartphoneServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Smartphone phone = new Smartphone(
                "Samsung",
                "Galaxy S24",
                "https://example.com/s24.jpg",
                "Флагманський смартфон із потужним процесором та камерою.",
                "8 ГБ RAM, 256 ГБ ROM, Snapdragon 8 Gen 2, 5000 мА·год"
        );

        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        resp.setHeader("Access-Control-Allow-Origin", "*");

        Gson gson = new Gson();
        String json = gson.toJson(phone);

        PrintWriter out = resp.getWriter();
        out.print(json);
        out.flush();
    }
}
