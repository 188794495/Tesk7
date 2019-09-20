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
<%--<script>--%>
    <%--// 获取验证码--%>
    <%--function getCode() {--%>
        <%--var phone = document.getElementById('phone').value;--%>
        <%--$.ajax({--%>
            <%--type: "POST",--%>
            <%--/*返回类型*/--%>
            <%--contentType: "application/json;charset=utf-8",--%>
            <%--url: "/getYzm",--%>
            <%--data: {"phone": phone},--%>
            <%--success: function (result) {--%>
                <%--alert(result.message);--%>
            <%--},--%>
            <%--error: function (result) {--%>
                <%--alert(result.message);--%>
            <%--}--%>
        <%--});--%>
    <%--}--%>
<%--</script>--%>
<div style="margin-top:40px">

    <a href="/email">我要用邮箱注册</a>

    <form method="post" action="/getYzm"><input type="submit" value="发送验证码"></form>

    <form method="post" action="/regist" enctype="multipart/form-data">
        账户：
        <input name="name" value="" type="text" placeholder="请输入用户名">
        <div id="b0"><font size='2' color='#888888'></font></div>

        密码：
        <input name="pwd" value="" type="password" placeholder="请输入密码">
        <div id="b1"><font size='2' color='#888888'></font></div>

        确认密码：
        <input name="pwd1" value="" type="password" placeholder="再次输入密码">
        <div id="b2"><font size='2' color='#888888'></font></div>

        手机：
        <input name="phone" value="" type="text" placeholder="请输入手机号">
        <div id="b3"><font size='2' color='#888888'></font></div>

        验证：
        <input name="yzm" value="" type="text" placeholder="请输入验证码">
        <div id="b4"><font size='2' color='#888888'></font></div>
        <%--<input type="button" value="发送验证码" onclick="getCode()">--%>
        头像：
        <input type="file" name="file"/><br>

        <input type="submit" value="注册">


        ${error}

    </form>

</div>