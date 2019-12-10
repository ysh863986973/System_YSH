<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/10/16 0016
  Time: 20:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>TEST</title>

    <link href="css/bootstrap.min.css" rel="stylesheet">
    <script src="js/jquery-3.3.1.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <style type="text/css">
        * {
            padding: 0;
            margin: 0;
            list-style: none;
        }

        a {
            text-decoration: none;
        }
        .navigation{
            width: 150px;
            height: 100%;
            position: relative;
            background-color: white;
            border: 3px solid white;
            color: #ffffff;
            font-size: 20px;
        }
        button {
            width: 100%;
            height: 34px;
            border: 2px solid white ;
            background-color: #6a91cc;
            outline: none;
        }
        .left li{
            margin-bottom: 2px;
        }

    </style>
</head>
<body>
<div class="navigation">
    <ul class="left">
        <c:if test="${userName.getRoleId() == 1}">
            <li>
                <button type="button"
                        data-toggle="collapse"
                        data-target="#collapseExample01"
                        aria-controls="collapseExample01">
                    员工模块
                </button>
                <div class="collapse" id="collapseExample01">
                    <ul>
                        <li><a href="user?method=list" target="show">所有员工信息</a></li>
                        <li><a href="findById.jsp" target="show">指定员工信息</a></li>
                        <li><a href="user?method=filterAll" target="show">条件过滤查询</a></li>
                    </ul>
                </div>
            </li>
            <li>
                <button type="button" data-toggle="collapse"
                        data-target="#collapseExample02"
                        aria-controls="collapseExample02">
                    培训模块
                </button>
                <div class="collapse" id="collapseExample02">
                    <ul>
                        <li><a href="addTrainingCourse.jsp" target="show">增加培训课程</a></li>
                        <li><a href="train?method=allTrainingCourse" target="show">查看培训课程</a></li>
                        <li><a href="train?method=allTrain" target="show">员工培训情况</a></li>
                    </ul>
                </div>
            </li>
            <li>
                <button type="button"
                        data-toggle="collapse"
                        data-target="#collapseExample03"
                        aria-controls="collapseExample03">
                    招聘模块
                </button>
                <div class="collapse" id="collapseExample03">
                    <ul>
                        <li><a href="user?method=allApplicant" target="show">所有招聘信息</a></li>
                        <li><a href="user?method=thePass" target="show">简历通过人员</a></li>
                    </ul>
                </div>
            </li>
            <li>
                <button type="button"
                        data-toggle="collapse"
                        data-target="#collapseExample04"
                        aria-controls="collapseExample04">
                    工资模块
                </button>
                <div class="collapse" id="collapseExample04">

                    <ul>
                        <li><a href="salary?method=allSalary" target="show">所有员工工资</a></li>
                    </ul>

                </div>
            </li>
        </c:if>
        <%--        普通员工的权限--%>
        <c:if test="${userName.getRoleId() != 1}">
            <li>
                <button type="button" data-toggle="collapse"
                        data-target="#collapseExample05"
                        aria-controls="collapseExample05">
                    员工模块
                </button>
                <div class="collapse" id="collapseExample05">
                    <ul>
                        <li><a href="user?method=findOneself&id=${userName.getId()}" target="show">查看自己信息</a></li>
                        <li><a href="user?method=modifyOneself&id=${userName.getId()}" target="show">修改账号密码</a></li>
                    </ul>
                </div>
            </li>

            <li>
                <button type="button" data-toggle="collapse"
                        data-target="#collapseExample06"
                        aria-controls="collapseExample06">
                    培训模块
                </button>
                <div class="collapse" id="collapseExample06">
                    <ul>
                        <li><a href="train?method=findByIdTrain&id=${userName.id}" target="show">当前所学课程</a></li>
                        <li><a href="train?method=allTrainingCourse" target="show">选择学习课程</a></li>
                    </ul>
                </div>
            </li>

            <li>
                <button type="button" data-toggle="collapse"
                        data-target="#collapseExample07"
                        aria-controls="collapseExample07">
                    工资模块
                </button>
                <div class="collapse" id="collapseExample07">
                    <ul>
                        <li><a href="salary?method=findOneselfSalary&id=${userName.getId()}" target="show">查看自己工资</a></li>
                    </ul>
                </div>
            </li>
        </c:if>



    </ul>
</div>
</body>
</html>
