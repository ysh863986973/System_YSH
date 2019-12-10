<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/10/15 0015
  Time: 9:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>addSalaryAndTrain</title>
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
    <c:forEach begin="0" end="${byIDNumberService.size() - 1}" var="i">
        <tr>
            <td>${byIDNumberService[i].id}</td>
            <td>${byIDNumberService[i].userName}</td>
            <td>${byIDNumberService[i].password}</td>
            <td>${byIDNumberService[i].name}</td>
            <td>${byIDNumberService[i].age}</td>
            <td>
                <c:if test="${byIDNumberService[i].gender}">
                    女
                </c:if>
                <c:if test="${!byIDNumberService[i].gender}">
                    男
                </c:if>
            </td>
            <td>${byIDNumberService[i].IDNumber}</td>
            <td>${byIDNumberService[i].basicSalary}</td>
            <td>${byIDNumberService[i].department}</td>
            <td>${byIDNumberService[i].job}</td>
            <td>${byIDNumberService[i].createTime}</td>
            <td>${byIDNumberService[i].content}</td>
            <td><a href='salary?method=addSalaryId&id=${byIDNumberService[i].id}&name=${byIDNumberService[i].name}&basicSalary=${byIDNumberService[i].basicSalary}'>增加该员工的工资</a></td>
<%--            <td><a href='user?method=modify&id=${byIDNumberService[i].id}'>增加培训</a></td>--%>
        </tr>
    </c:forEach>
</table>
</body>
</html>
