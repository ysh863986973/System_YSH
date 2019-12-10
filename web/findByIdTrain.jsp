<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/10/15 0015
  Time: 21:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>findByIdTrain</title>
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
        <td colspan="9" align="center">培训情况</td>
    </tr>
    <tr>
        <td>studentId</td>
        <td>姓名</td>
        <td>培训课程</td>
        <td>培训开始时间</td>
        <td>培训结束时间</td>
        <td>讲师</td>
        <td>目的</td>
        <td>影响</td>
        <td>培训状态</td>
    </tr>
    <c:forEach begin="0" end="${trains.size() - 1}" var="i">
        <tr>
            <td>${trains[i].studentId}</td>
            <td>${trains[i].name}</td>
            <td>${trains[i].course}</td>
            <td>${trains[i].beginTime}</td>
            <td>${trains[i].endTime}</td>
            <td>${trains[i].teacher}</td>
            <td>${trains[i].goal}</td>
            <td>${trains[i].effect}</td>
            <td>
                <c:if test="${trains[i].isTraining == 0}">
                    等待培训中......
                </c:if>
                <c:if test="${trains[i].isTraining == 1}">
                    正在培训中......
                </c:if>
                <c:if test="${trains[i].isTraining == 2}">
                    培训已完成。
                </c:if>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
