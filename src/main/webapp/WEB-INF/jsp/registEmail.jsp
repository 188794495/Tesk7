<%@ page contentType="text/html;charset=utf-8" language="java" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<head>
    <meta charset="UTF-8">
    <title>技能树首页</title>
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="/statics/css/task house.css">
    <link rel="stylesheet" href="/statics/css/task15-3.css">

</head>

<div style="margin-top:40px">

    <%--<form method="post" action="/regist">--%>
    <%--账户：--%>
    <%--<input name="name" value="" type="text" placeholder="请输入用户名">--%>
    <%--<div id="b1"><font size='2' color='#888888'></font></div>--%>


    <%--密码：--%>
    <%--<input name="pwd" value="" type="password" placeholder="请输入密码">--%>
    <%--<div id="b2"><font size='2' color='#888888'></font></div>--%>
    <%--<input type="submit" value="注册">--%>
    <%--</form>--%>
    <form method="post" action="/registEmail">
        账户：
        <input name="name" value="" type="text" placeholder="请输入用户名">
        <div id="b0"><font size='2' color='#888888'></font></div>

        密码：
        <input name="pwd" value="" type="password" placeholder="请输入密码">
        <div id="b1"><font size='2' color='#888888'></font></div>

        确认密码：
        <input name="pwd1" value="" type="password" placeholder="再次输入密码">
        <div id="b2"><font size='2' color='#888888'></font></div>

        邮箱：
        <input name="email" value="" type="text" placeholder="请输入邮箱">
        <div id="b3"><font size='2' color='#888888'></font></div>

        验证：
        <input name="emailCode" value="" type="text" placeholder="请输入验证码">
        <div id="b4"><font size='2' color='#888888'></font></div>
        <input type="submit" value="注册">
        ${error}

    </form>

</div>