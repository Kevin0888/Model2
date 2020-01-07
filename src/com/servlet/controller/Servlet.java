package com.servlet.controller;

import com.servlet.service.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Servlet extends HttpServlet {

    private String cashierPage = "/index.jsp";
    private String managerPage = "/login_success.jsp";
    private String commodityPage = "/page/commodity.jsp";
    private String receiptPage = "/page/receipt.jsp";
    private String loginPage = "/login.jsp";
    private String errorPage = "/login_failure.jsp";
    private UserService userService;
    @Override
    public void init() throws ServletException {
        super.init();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
        String currentUri = request.getRequestURI();
        System.out.println(currentUri + " this request method is GET method");

        if ("/Servlet/login".equals(currentUri)) {
            login(request, response);
        }

    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String currentUri = req.getRequestURI();
        System.out.println(currentUri + " this request method is POST method");

        if ("/Servlet/login".equals(currentUri)) {
            login(req, resp);
        }
    }
    private void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String role = req.getParameter("role");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
//        User user = userService.getUser(username, password);
        String forwardPage = errorPage;
        if ("admin".equals(username) && "admin".equals(password)) {
            forwardPage = managerPage;
        }else{
            forwardPage = errorPage;
        }
        RequestDispatcher view = req.getRequestDispatcher(forwardPage);
        view.forward(req, resp);

    }
}
