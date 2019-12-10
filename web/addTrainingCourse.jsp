<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/10/16 0016
  Time: 14:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>addTrainingCourse</title>
    <style type="text/css">
        table {
            border: none;
            border-collapse: collapse;
            border-spacing: 0;
            font-size: 18px;
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
<form action="train?method=addTrainingCourse" method="post">
    <table width="auto" align="center" border="1px">
        <tr>
            <td colspan="9" align="center">增加课程</td>
        </tr>
        <tr>
            <td>课程</td>
            <td>
                <input type="text" name="course">
            </td>
        </tr>
        <tr>
            <td>课程开始时间</td>
            <td>
                <input type="datetime-local" name="beginTime">
            </td>
        </tr>
        <tr>
            <td>课程结束时间</td>
            <td>
                <input type="datetime-local" name="endTime">
            </td>
        </tr>
        <tr>
            <td>讲师</td>
            <td>
                <input type="text" name="teacher">
            </td>
        </tr>
        <tr>
            <td colspan="2" align="right"><input type="submit"></td>
        </tr>
    </table>
</form>
</body>
</html>
