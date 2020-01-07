<%--
  Created by IntelliJ IDEA.
  User: GHT
  Date: 2020/1/6
  Time: 15:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>do login page</title>
</head>
<body>
<%--<%--%>
<%--    String username = request.getParameter("username");--%>
<%--    String password = request.getParameter("password");--%>
<%--    if ("admin".equals(username) && "admin".equals(password)) {--%>
<%--        request.getRequestDispatcher("login_success.jsp").forward(request, response);--%>
<%--    } else {--%>
<%--        response.sendRedirect("login_failure.jsp");--%>
<%--    }--%>
<%--%>--%>
<jsp:useBean id="user" class="com.servlet.user.User" scope="page" />
<jsp:useBean id="userDao" class="com.servlet.dao.UserDao" scope="page" />
<jsp:setProperty name="user" property="*" />
<%
    if (userDao.userLogin(user)) {
        request.getRequestDispatcher("login_success.jsp").forward(request, response);
    } else {
        response.sendRedirect("login_failure.jsp");
    }
%>
</body>
</html>
