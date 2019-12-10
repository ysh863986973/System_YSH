<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/10/17 0017
  Time: 22:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>grade</title>
</head>
<body>

<form action="user?method=gradeTrain" method="post">
    <table width="600px" align="center" border="1px">
        <c:forEach begin="0" end="${trains.size() - 1}" var="i">
            <tr>
                <td>工号：</td>
                <td>
                    <input type="text" name="studentId" value="${trains[i].studentId}" readonly>
                </td>
            </tr>
            <tr>
                <td>姓名：</td>
                <td>
                    <input type="text" name="name" value="${trains[i].name}" readonly>
                </td>
            </tr>
            <tr>
                <td>评分：</td>
                <td><input type="text" name="grade"></td>
            </tr>

            //提交后在servite里改变评分的状态
                <tr>
                    <td colspan="30" align="right"><input type="submit"></td>
                </tr>

        </c:forEach>
    </table>
</form>
</body>
</html>
