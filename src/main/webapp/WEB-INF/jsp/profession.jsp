<%@ page contentType="text/html;charset=utf-8" language="java" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="/tags" prefix="date"%>

<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <title>职业</title>
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="/statics/css/task house.css">
    <link rel="stylesheet" href="/statics/css/task15-2.css">
</head>
<body>
<main>
    <div class="container">
        <div class="row row-a">
            <div class="col">
                <span>首页</span>&gt;<span class="profession">职业</span>
            </div>
        </div>
        <div class="row row-a">
            <div class="col col-f">
                <span class="text">方向：</span>&nbsp;&nbsp;
                <span class="text">全部</span>&nbsp;&nbsp;
                <a href="#front"><span class="text">前端开发</span></a>&nbsp;&nbsp;
                <a href="#after"><span class="text">后端开发</span></a>&nbsp;&nbsp;
                <span class="text">移动开发</span>&nbsp;&nbsp;
                <span class="text">整站开发</span>&nbsp;&nbsp;
                <a href="#operation"><span class="text">运营维护</span></a>
            </div>
        </div>

        <div class="row row-a">
            <div class="col">
                <span id="front"><span class="size">前端开发选项</span></span>
            </div>
        </div>
    </div>
    <!-- main第一部分 -->
    <div class="container">
        <div class="row row-x">
            <c:forEach items="${profession}" var="profession">
                <c:if test="${profession.direction=='前端攻城狮'}">
                    <div class="col-md-6 col-sm-12 col-lg-4  distance v-distance">
                        <div class="container-c">
                            <div class="item-a"></div>
                            <div class="item-b">
                                <h6>${profession.profession}</h6>
                                <p>${profession.description}</p>
                            </div>
                            <div class="item-c">
                                <span class="door">门槛</span>
                                <c:forEach begin="1" end="${profession.threshold}">
                                    <img  class="img" src="/statics/img/u.png">
                                </c:forEach>
                            </div>
                            <div class="item-d">
                                <span class="door">难易程度</span>
                                <c:forEach begin="1" end="${profession.difficulty}">
                                    <img  class="img" src="/statics/img/u.png">
                                </c:forEach>

                            </div>
                            <div class="item-e">
                                <span class="door">成长周期</span>
                                <span class="num">${profession.period}</span>
                                <span class="year">年</span>
                            </div>
                            <div class="item-f">
                                <span class="door">稀缺程度</span>
                                <span class="num">${profession.company}</span>
                                <span class="year">家公司需要</span>
                            </div>
                            <div class="item-g">
                                <span class="door">薪资待遇</span>
                            </div>
                            <div class="item-h">
                                <span class="num-1">0-1年</span>
                                <span class="num-2">${profession.salaryOne}</span>
                            </div>
                            <div class="item-i">
                                <span class="num-1">2-5年</span>
                                <span class="num-2">${profession.salaryTwo}</span>
                            </div>
                            <div class="item-j">
                                <span class="num-1">5-10年</span>
                                <span class="num-2">${profession.salaryThree}</span>
                            </div>
                            <div class="item-k">
                                <span>有</span>
                                <span style="color: red">286</span>
                                <span>人正在学</span>
                            </div>
                            <div class="item-l">
                                <span>提示:在你学习之前你应该已经掌握XXXXX、XXXXX、XX等语言基础</span>
                            </div>
                            <div class="item-m">
                                <p>${profession.profession}</p>
                                <p>iOS是由苹果公司开发的移动操作系统，iOS与苹果的Mac OS
                                    X操作系统一样，也是以Darwin为基础的，因此同样属于类Unix的商业操作系统。国内iOS开发起步相对较晚，人才培养机制更是远远跟不上市场发展速度。有限的iOS开发人才成了国内企业必争的资源。国内iOS开发起步相对较晚，人才培养机制更是远远跟不上市场发展速度。有限的iOS开发人才成了国内企业必争的资源。</p>
                            </div>
                            <div class="item-l">
                                <span>更新时间：<date:date value="${profession.updateAt}"/></span>
                            </div>
                        </div>
                    </div>
                </c:if>
            </c:forEach>
        </div>
    </div>
    <div class="container">
        <div class="row row-a">
            <div class="col">
                <span id="after"><span class="size">后端开发选项</span></span>
            </div>
        </div>
        <div class="row row-x">
            <c:forEach items="${profession}" var="profession">
                <c:if test="${profession.direction=='后端攻城狮'}">
                    <div class="col-md-6 col-sm-12 col-lg-4  distance v-distance">
                        <div class="container-c">
                            <div class="item-a"></div>
                            <div class="item-b">
                                <h6>${profession.profession}</h6>
                                <p>${profession.description}</p>
                            </div>
                            <div class="item-c">
                                <span class="door">门槛</span>
                                <c:forEach begin="1" end="${profession.threshold}">
                                    <img  class="img" src="/statics/img/u.png">
                                </c:forEach>

                            </div>
                            <div class="item-d">
                                <span class="door">难易程度</span>
                                <c:forEach begin="1" end="${profession.difficulty}">
                                    <img  class="img" src="/statics/img/u.png">
                                </c:forEach>
                            </div>
                            <div class="item-e">
                                <span class="door">成长周期</span>
                                <span class="num">${profession.period}</span>
                                <span class="year">年</span>
                            </div>
                            <div class="item-f">
                                <span class="door">稀缺程度</span>
                                <span class="num">${profession.company}</span>
                                <span class="year">家公司需要</span>
                            </div>
                            <div class="item-g">
                                <span class="door">薪资待遇</span>
                            </div>
                            <div class="item-h">
                                <span class="num-1">0-1年</span>
                                <span class="num-2">${profession.salaryOne}</span>
                            </div>
                            <div class="item-i">
                                <span class="num-1">2-5年</span>
                                <span class="num-2">${profession.salaryTwo}</span>
                            </div>
                            <div class="item-j">
                                <span class="num-1">0-1年</span>
                                <span class="num-2">${profession.salaryThree}</span>
                            </div>
                            <div class="item-k">
                                <span>有</span>
                                <span style="color: red">286</span>
                                <span>人正在学</span>
                            </div>
                            <div class="item-l">
                                <span>提示:在你学习之前你应该已经掌握XXXXX、XXXXX、XX等语言基础</span>
                            </div>
                            <div class="item-m">
                                <p>${profession.profession}</p>
                                <p>iOS是由苹果公司开发的移动操作系统，iOS与苹果的Mac OS
                                    X操作系统一样，也是以Darwin为基础的，因此同样属于类Unix的商业操作系统。国内iOS开发起步相对较晚，人才培养机制更是远远跟不上市场发展速度。有限的iOS开发人才成了国内企业必争的资源。国内iOS开发起步相对较晚，人才培养机制更是远远跟不上市场发展速度。有限的iOS开发人才成了国内企业必争的资源。</p>
                            </div>
                            <div class="item-l">
                                <span>更新时间：<date:date value="${profession.updateAt}"/></span>
                            </div>
                        </div>
                    </div>
                </c:if>
            </c:forEach>
        </div>
    </div>

</main>
</body>
</html>