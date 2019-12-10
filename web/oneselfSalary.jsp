<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/10/13 0013
  Time: 11:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>oneselfSalary</title>
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
        <td colspan="10" align="center">员工的工资</td>
    </tr>
    <c:forEach begin="0" end="${salaries.size() - 1}" var="i">
        <tr>
            <td>${salaries[i].id}</td>
            <td>${salaries[i].userId}</td>
            <td>${salaries[i].basic}</td>
            <td>${salaries[i].eat}</td>
            <td>${salaries[i].house}</td>
            <td>${salaries[i].duty}</td>
            <td>${salaries[i].punishment}</td>
            <td>${salaries[i].other}</td>
            <td>${salaries[i].grantTime}</td>
            <td>${salaries[i].totalize}</td>
<%--            <td><a href='salary?method=deleteSalary&id=${salaries[i].id}'>后期来个判断，申请解雇自己 删除</a></td>--%>
        </tr>
    </c:forEach>
</table>
</body>
</html>
