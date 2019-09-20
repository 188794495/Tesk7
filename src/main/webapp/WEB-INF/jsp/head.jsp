<%@ page contentType="text/html;charset=utf-8" language="java" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<header>
    <div class="container container-a">
        <div class="row">
            <div class="col d-flex justify-content-between col-z">
                <div class="service"><span>客服热线：010-595-78634</span></div>
                <div class="logo">
                    <img src="/statics/img/a.png">
                    <img src="/statics/img/b.png">
                    <img src="/statics/img/c.png">
                </div>
            </div>
            <div class="head-box">
                <span class="text-success">
                <c:if test="${user==null}">
                    <a href="/user" >登录</a>丨<a href="/register">注册</a></span></c:if>
                <c:if test="${user!=null}">
                    <img src=${user.picture} height="40" width="40" />欢迎${user.name}</a>丨<a href="/outLogin">退出</a></span></c:if>
            </div>
        </div>
    </div>
    <div class="container-wrap">
        <div class="container container-b">
            <div class="nav">
                <input type="checkbox" id="sidemenu">
                <img class="img-4" src="/statics/img/4.png">
                <label id="sideMenuControl" for="sidemenu">
                    <img class="img-aa" src="/statics/img/aa.png">
                </label>
                <ul>
                    <li><a class="active" href="/home">首页</a></li>
                    <li><a href="/u/profession">职业</a></li>
                    <li><a href="/user">登录</a></li>
                    <li><a href="/recommend">关于</a></li>
                </ul>
            </div>
        </div>
    </div>
</header>