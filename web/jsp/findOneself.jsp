<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/10/15 0015
  Time: 17:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>findOneself</title>
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
<table width="auto" align="center" border="1px">
    <tr>
        <td>id</td>
        <td>账号</td>
        <td>密码</td>
        <td>姓名</td>
        <td>年龄</td>
        <td>性别</td>
        <td>身份证号</td>
        <td>基本工资</td>
        <td>部门</td>
        <td>职位</td>
        <td>入职时间</td>
        <td>留言</td>
    </tr>
    <c:forEach begin="0" end="${all.size() - 1}" var="i">
        <tr>
            <td>${all[i].id}</td>
            <td>${all[i].userName}</td>
            <td>${all[i].password}</td>
            <td>${all[i].name}</td>
            <td>${all[i].age}</td>
            <td>
                <c:if test="${all[i].gender}">
                    女
                </c:if>
                <c:if test="${!all[i].gender}">
                    男
                </c:if>
            </td>
            <td>${all[i].IDNumber}</td>
            <td>${all[i].basicSalary}</td>
            <td>${all[i].department}</td>
            <td>${all[i].job}</td>
            <td>${all[i].createTime}</td>
            <td>${all[i].content}</td>
<%--            <td><a href='user?method=delete&id=${all[i].id}'>删除</a></td>--%>
<%--            <td><a href='user?method=modify&id=${all[i].id}'>修改</a></td>--%>
<%--            <td><a href='user?method=addSalaryId&id=${all[i].id}&name=${all[i].name}'>增加工资</a></td>--%>
        </tr>
    </c:forEach>
</table>
</body>
</html>
