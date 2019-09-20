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


    <form method="post" action="/addUser" enctype="multipart/form-data">

        上传头像：<input type="file"     name = "file" /><br>
        <input type="submit" value="确定">

    </form>


</div>