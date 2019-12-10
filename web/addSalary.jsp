<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/10/15 0015
  Time: 11:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>addSalary</title>
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
<%--增加工资错误--%>
<form action="salary?method=addSalary" method="post">
    <table width="auto" align="center" border="1px">
        <tr>
            <td>userId</td>
            <td><input type="text" name="userId" value="${id}" readonly></td>
        </tr>
        <tr>
            <td>姓名</td>
            <td><input type="text" name="name" value="${name}" readonly></td>
        </tr>
        <tr>
            <td>基本工资</td>
            <td><input type="text" name="basicSalary" value="${basicSalary}" readonly></td>
        </tr>
        <tr>
            <td>吃补</td>
            <td><input type="text" name="eat"></td>
        </tr>
        <tr>
            <td>房补</td>
            <td><input type="text" name="house"></td>
        </tr>
        <tr>
            <td>税</td>
            <td><input type="text" name="duty"></td>
        </tr>
        <tr>
            <td>惩罚</td>
            <td><input type="text" name="punishment"></td>
        </tr>
        <tr>
            <td>其他收入</td>
            <td><input type="text" name="other"></td>
        </tr>
        <tr>
            <td>发工资时间</td>
            <td><input type="datetime-local" name="grantTime"></td>
        </tr>
        <tr>
            <td>总计</td>
            <td><input type="text" name="totalize"></td>
        </tr>
        <tr>
            <td colspan="2" align="right"><input type='submit' value='提交'></td>
        </tr>
    </table>
</form>
</body>
</html>
