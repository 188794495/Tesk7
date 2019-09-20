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

<div style="text-align:center;margin-top:40px">

    <form method="post" action="/login">
        账户：
        <input name="name" value="" type="text" placeholder="请输入用户名">
        <div id="b1"><font size='2' color='#888888'></font></div>

        密码：
        <input name="pwd" value="" type="password" placeholder="请输入密码">

        <div id="b2"><font size='2' color='#888888'></font></div>
        ${error}

        <input type="submit" value="登录">
    </form>

</div>