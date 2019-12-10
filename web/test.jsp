<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/10/16 0016
  Time: 16:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        /* 让页面所有元素的padding和margin都设置为0 */
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
        }

        /* 设置背景图，字体设置为微软雅黑 */
        body {
            background: url('img/bg.jpg') no-repeat 0px 0px;
            background-size: cover;
            font-family: 'Open Sans', sans-serif;
            background-attachment: fixed;
            background-position: center;
        }

        /*!* 引用图片高度设置为28px，就是页面最上方像屋檐一样的黑色图 *!*/
        /*.headtop {*/
        /*    background: url(topbg.jpg);*/
        /*    height: 28px;*/
        /*}*/

        /* 整个登录框的css，并使用绝对定位居中 */
        .login {
            position: absolute;
            top: 50%;
            left: 50%;
            margin: -150px 0 0 -150px;
            width: 300px;
            height: 300px;
        }

        /* 前面分析过的h1标签的css，text-shadow设置阴影使文字更好看，letter-spacing设置字符间距 */
        .login h1 {
            color: #000000;
            text-shadow: 0px 10px 8px #000000;
            letter-spacing: 2px;
            text-align: center;
            margin-bottom: 20px;
        }

        /* 两个输入框的css，border属性设置边框线粗细以及颜色，border-radius设置边框的圆角角度 */
        input {
            padding: 10px;
            width: 100%;
            color: #000000;
            margin-bottom: 10px;
            background-color: #fffffd;
            border: 1px solid black;
            border-radius: 4px;
            letter-spacing: 2px;
        }

        /* 登录按钮的css，cursor:pointer当鼠标移到按钮上面时变成小手形状 */
        form button {
            width: 100%;
            padding: 10px;
            background-color: #fffffd;
            border: 1px solid black;
            border-radius: 4px;
            cursor: pointer;
        }
    </style>
</head>
<body background="img/bg.jpg">
<div class="login">
    <h1>Login</h1>
    <form action="user?method=userLogin" method="post">
        <c:if test="${not empty msg}">
            <th colspan="2">${msg}</th>
        </c:if>
        <input type="text" name="userName" placeholder="用户名">
        <input type="password" name="password" placeholder="密  码">
        <a href="signIn.jsp">
            <input type="button" value="注册">
        </a>
        <button type="submit">登录</button>
    </form>
</div>
</body>
</html>
