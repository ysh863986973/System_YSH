<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/10/12 0012
  Time: 15:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>allApplicant</title>
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
</head>
<body>
<script language="javascript">
    function a() {
        if (!confirm("是否同意所有勾选的简历并删除所有其他简历")) {
            window.event.returnValue = false;
        }
    }
</script>
<form action="user?method=modifyApplicant" method="post">
    <table width="auto" align="center" border="1px">
        <tr>
            <td colspan="15" align="center">简历</td>
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
            <td>简历通过</td>
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
                <td>
                    同意<input type="checkbox" name="isHiring" value="${applicants[i].id}" size="5">
                </td>
            </tr>
        </c:forEach>
        <tr>
            <td colspan="30" align="right"><input type="submit" onclick="a()"></td>
        </tr>
    </table>
</form>
</body>
</html>
