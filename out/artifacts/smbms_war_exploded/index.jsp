<%--
  Created by IntelliJ IDEA.
  User: liumq
  Date: 2021/6/14
  Time: 下午 3:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>


  <h1>当前有<span><%= this.getServletConfig().getServletContext().getAttribute("onlineCount")%></span></h1>

  </body>
</html>
