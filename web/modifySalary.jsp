<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/10/12 0012
  Time: 17:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>modifySalary</title>
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
<form action='salary?method=updateSalary' method='post'>
    <table width="auto" align="center" border="1px">
        <c:forEach begin="0" end="${salary.size() - 1}" var="i">
            <tr>
                <td>ID</td>
                <td><input type="text" name="id" value="${salary[i].id}" readonly></td>
            </tr>
            <tr>
                <td>userId</td>
                <td><input type="text" name="userId" value="${salary[i].userId}" readonly></td>
            </tr>
            <tr>
                <td>name</td>
                <td><input type="text" name="name" value="${salary[i].name}" readonly></td>
            </tr>
            <tr>
                <td>基本工资</td>
                <td><input type="text" name="basic" value="${salary[i].basic}"></td>
            </tr>
            <tr>
                <td>吃补</td>
                <td><input type="text" name="eat" value="${salary[i].eat}"></td>
            </tr>
            <tr>
                <td>房补</td>
                <td><input type="text" name="house" value="${salary[i].house}"></td>
            </tr>
            <tr>
                <td>税</td>
                <td><input type="text" name="duty" value="${salary[i].duty}"></td>
            </tr>
            <tr>
                <td>惩罚</td>
                <td><input type="text" name="punishment" value="${salary[i].punishment}"></td>
            </tr>
            <tr>
                <td>其他收入</td>
                <td><input type="text" name="other" value="${salary[i].other}"></td>
            </tr>
            <tr>
                <td>发工资时间</td>
                <td><input type="datetime-local" name="grantTime" value="${salary[i].grantTime}"></td>
            </tr>
            <tr>
                <td>总计</td>
                <td><input type="text" name="totalize" value="${salary[i].totalize}"></td>
            </tr>
            <tr>
                <td colspan="30" align="right"><input type='submit' value='提交'></td>
            </tr>
        </c:forEach>
    </table>
</form>
</body>
</html>
