<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/10/10 0010
  Time: 17:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style type="text/css">
        table {
            border: none;
            border-collapse: collapse;
            border-spacing: 0;
            font-size: 16px;
            color: #091F53;
            font-family: Arial;
        }

        table th {
            background: #86B9E4;
            height: 26px;
            line-height: 26px;
            border: solid #C6D5E1;
            border-width: 1px 1px 0px 1px;
            padding-left: 1px;
            padding-right: 1px;
        }

        table td, table tr {
            border: 1px solid #C6D5E1;
            height: 20px;
            line-height: 20px;
            padding-left: 5px;
            padding-right: 5px;
        }

        /*input { width:100%; height:100%;border-width:0px;text-align:right;}*/
    </style>
</head>
<body>
<form action='user?method=update' method='post'>
    <table width="600px" align="center" border="1px">
        <c:forEach begin="0" end="${user.size() - 1}" var="i">
            <tr>
                <td>ID</td>
                <td><input type="text" name="id" value="${user[i].id}" readonly></td>
            </tr>
            <tr>
                <td>账号</td>
                <td><input type="text" name="userName" value="${user[i].userName}"></td>
            </tr>
            <tr>
                <td>密码</td>
                <td><input type="password" name="password" value="${user[i].password}"></td>
            </tr>
            <tr>
                <td>姓名</td>
                <td><input type="text" name="name" value="${user[i].name}"></td>
            </tr>
            <tr>
                <td>年龄：</td>
                <td>
                    <input type="text" name="age" value="${user[i].age}">
                </td>
            </tr>
            <tr>
                <td>性别</td>
                <td>
                    <c:choose>
                        <c:when test="${!user[i].gender}">
                            <input type="radio" name="gender" checked="checked" value="0"/>男
                            <input type="radio" name="gender" value="1"/>女
                        </c:when>
                        <c:when test="${user[i].gender}">
                            <input type="radio" name="gender" value="0"/>男
                            <input type="radio" name="gender" checked="checked" value="1"/>女
                        </c:when>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td>身份证号：</td>
                <td>
                    <input type="text" name="IDNumber" value="${user[i].IDNumber}">
                </td>
            </tr>
            <tr>
                <td>基本工资：</td>
                <td>
                    <input type="text" name="basicSalary" value="${user[i].basicSalary}">
                </td>
            </tr>
            <tr>
                <td>部门：</td>
                <td>
                    <input type="text" name="department" value="${user[i].department}">
                </td>
            </tr>
            <tr>
                <td>职位：</td>
                <td>
                    <input type="text" name="job" value="${user[i].job}">
                </td>
            </tr>
            <tr>
                <td>入职时间</td>
                <td><input type="datetime-local" name="createTime" value="${user[i].createTime}"></td>
            </tr>
            <tr>
                <td>content</td>
                <td><input type="text" name="content" value="${user[i].content}"></td>
            </tr>

            <tr>
                <td colspan="30" align="right"><input type='submit' value='提交'></td>
            </tr>
        </c:forEach>
    </table>
</form>
</body>
</html>
