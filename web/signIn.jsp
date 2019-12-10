<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/10/10 0010
  Time: 17:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>signIn注册</title>
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
<form action="user?method=updateThePass" method="post">
    <table width="auto" align="center" border="1px">
        <tr>
            <td colspan="20" align="center">欢迎加入易水寒有限公司！</td>
        </tr>
        <tr>
            <td>账号：</td>
            <td>
                <input type="text" name="userName">
            </td>
        </tr>

        <tr>
            <td>密码：</td>
            <td>
                <input type="password" name="password">
            </td>
        </tr>
        <tr>
            <td>姓名：</td>
            <td><input type="text" name="name"></td>
        </tr>
        <tr>
            <td>年龄：</td>
            <td>
                <input type="text" name="age">
            </td>
        </tr>
        <tr>
            <td>性别:</td>
            <td>
                <input type="radio" name="gender" value="0">男
                <input type="radio" name="gender" value="1">女
            </td>
        </tr>
        <tr>
            <td>身份证号：</td>
            <td>
                <input type="text" name="IDNumber">
            </td>
        </tr>
        <tr>
            <td>基本工资：</td>
            <td>
                <input type="text" name="basicSalary">
            </td>
        </tr>
        <tr>
            <td>部门：</td>
            <td>
                <input type="text" name="department">
            </td>
        </tr>
        <tr>
            <td>职位：</td>
            <td>
                <input type="text" name="job">
            </td>
        </tr>
        <tr>
            <td>入职时间：</td>
            <td>
                <input type="datetime-local" name="createTime">
            </td>
        </tr>
        
        <tr>
            <td>简介:</td>
            <td>
                <input type="text" name="content">
            </td>
        </tr>

        <tr>
            <td colspan="30" align="right"><input type="submit" value="提交"></td>
        </tr>
    </table>
</form>
</body>
</html>
