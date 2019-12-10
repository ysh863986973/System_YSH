<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/10/16 0016
  Time: 20:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<frameset rows="50px, *" frameborder="no">
    <frame src="1-top.jsp" />
    <frameset cols="150px, *">
        <frame src="1-left.jsp"/>
        <frame src="1-right.jsp" name="show"/>
    </frameset>
</frameset>
</html>
