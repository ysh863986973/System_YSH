<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/10/11 0011
  Time: 20:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>根据指定id查找员工</title>
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
<form action="user?method=findById" method="post">
<table width="600px" align="center" border="1px">
    <tr>
        <td>输入id查找员工：</td>
        <td>
            <input type="text" name="id">
        </td>
        <td colspan="30" align="right"><input type="submit" name="查询"></td>
    </tr>
</table>
</form>
</body>
</html>
