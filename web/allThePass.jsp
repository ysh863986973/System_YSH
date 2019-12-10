<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/10/13 0013
  Time: 20:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>thePass</title>
</head>
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
<body>
<table width="auto" align="center" border="1px">
    <tr>
        <td colspan="20" align="center">简历已审阅完毕,以下是简历通过的人，打电话通知这些人让他们准备面试</td>
    </tr>
    <tr>
        <td>ID</td>
        <td>名字</td>
        <td>性别</td>
        <td>年龄</td>
        <td>身份证号</td>
        <td>想入职的部门</td>
        <td>想入职的职位</td>
        <td>电话</td>
        <td>email</td>
        <td>简历提交时间</td>
        <td>面试通过</td>
        <td>面试失败</td>
    </tr>
    <c:forEach begin="0" end="${applicants.size() - 1}" var="i">
        <tr>
            <td>${applicants[i].id}</td>
            <td>${applicants[i].name}</td>
            <td>
                <c:if test="${applicants[i].gender}">
                    女
                </c:if>
                <c:if test="${!applicants[i].gender}">
                    男
                </c:if>
            </td>
            <td>${applicants[i].age}</td>
            <td>${applicants[i].IDNumber}</td>
            <td>${applicants[i].department}</td>
            <td>${applicants[i].job}</td>
            <td>${applicants[i].tel}</td>
            <td>${applicants[i].email}</td>
            <td>${applicants[i].createTime}</td>
            <td><a href='user?method=modifyThePass&id=${applicants[i].id}'>面试通过点击入职</a></td>
            <td><a href='user?method=deleteThePass&id=${applicants[i].id}'>点击删除该成员的所有信息</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
