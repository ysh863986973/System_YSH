<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/10/12 0012
  Time: 11:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>findAllTrainingCourse</title>
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
        <td>课程</td>
        <td>讲师</td>
        <td>课程开始时间</td>
        <td>课程结束时间</td>
    </tr>

    <c:forEach begin="0" end="${trains.size() - 1}" var="i">
        <tr>
            <td>${trains[i].course}</td>
            <td>${trains[i].teacher}</td>
            <td>${trains[i].beginTime}</td>
            <td>${trains[i].endTime}</td>
            <td>
                <c:choose>

                <c:when test="${trains[i].isTraining == 0}">
                培训未开始
                <c:if test="${userName.getRoleId() != 1}">
            <td><a href="train?method=getTrain&id=${trains[i].id}">选择</a></td>
            </c:if>
            </c:when>

            <c:when test="${trains[i].isTraining == 1}">
                正在培训中......
                <c:if test="${userName.getRoleId() != 1}">
                    <td><a href="train?method=getTrain&id=${trains[i].id}">选择</a></td>
                </c:if>
            </c:when>
            <c:when test="${trains[i].isTraining == 2}">
                培训已结束。
            </c:when>
            </c:choose>
            </td>
            <c:if test="${userName.getRoleId() == 1}">
                <td><a href="train?method=deleteTrainingCourse&id=${trains[i].id}">删除课程</a></td>
                <td><a href="train?method=findByCourse&course=${trains[i].course}">查询学习该课程的所有员工</a></td>
            </c:if>
        </tr>
    </c:forEach>
</table>
</body>
</html>
