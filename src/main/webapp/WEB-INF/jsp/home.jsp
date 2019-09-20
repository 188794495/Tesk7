<%@ page contentType="text/html;charset=utf-8" language="java" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="/tags" prefix="date" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <title>技能树首页</title>
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="/statics/css/task house.css">
    <link rel="stylesheet" href="/statics/css/task-15-carousel.css">
    <link rel="stylesheet" href="/statics/css/task15-1.css">

</head>
<body>
<div class="connection">
    <div class="viewport">
        <input type="radio" name="slider" id="pic1">
        <input type="radio" name="slider" id="pic2">
        <input type="radio" name="slider" id="pic3">
        <div class="wrap">
            <img src="/statics/img/1.png" alt="">
            <img src="/statics/img/2.jpeg" alt="">
            <img src="/statics/img/3.jpg" alt="">
        </div>
        <div class="page">
            <label for="pic1"></label>
            <label for="pic2"></label>
            <label for="pic3"></label>
        </div>
        <div class="arrow">
            <!--左箭头-->
            <label for="pic1"></label>
            <label for="pic2"></label>
            <label for="pic3"></label>
        </div>
        <div class="other">
            <!--右箭头-->
            <label for="pic1"></label>
            <label for="pic2"></label>
            <label for="pic3"></label>
        </div>
    </div>
</div>
<main>
    <div class="container container-d">
        <div class="row row-a">
            <div class="col-lg-3 col-md-6 col-sm-12 col-a">
                <div><img src="/statics/img/d.png"></div>
                <h3>高效</h3>
                <p>将五到七年的成长时间，缩短到一至三年</p>
            </div>
            <div class="col-lg-3 col-md-6 col-sm-12 col-a">
                <div><img src="/statics/img/e.png" height="62px"></div>
                <h3>规范</h3>
                <p>标准实战教程，不会走弯路</p>
            </div>
            <div class="col-lg-3 col-md-6 col-sm-12 col-a">
                <div><img src="/statics/img/f.png"></div>
                <h3>人脉</h3>
                <p>同班好友，同班学长，技术大师，入学就是混入职脉圈，为以后铺平道路</p>
            </div>
            <div class="col-lg-3 col-md-6 col-sm-12 col-a line">
                <div><img src="/statics/img/g.png">&nbsp;<span>12400</span></div>
                <p>累计在线学习人数</p><br>
                <div><img src="/statics/img/g.png">&nbsp;<span>12400</span></div>
                <p>学员已找到满意工作</p>
            </div>
        </div>
    </div>
    <!-- main第一部分 -->
    <h3 style="text-align: center">如何学习</h3>
    <!-- 如何学习过渡部分 -->
    <div class="container container-e" style="color: #9a9a9a; margin: 40px auto">
        <div class="row">
            <div class="col-lg-3 col-md-6 col-sm-12 col-c">
                <div><img class="col-img" src="/statics/img/5.png"></div>
                <div><span>匹配你现在的个人情况，寻找适合自己的岗位</span></div>
                <div><img src="/statics/img/i.png"></div>
            </div>
            <div class="col-lg-3 col-md-6 col-sm-12 col-c">
                <div><img class="col-img" src="/statics/img/6.png"></div>
                <div><span>了解职业前景薪金待遇、竞争压力等</span></div>
                <div><img src="/statics/img/i.png"></div>
            </div>
            <div class="col-lg-3 col-md-6 col-sm-12 col-c">
                <div><img class="col-img" src="/statics/img/7.png"></div>
                <div><span>掌握行内顶级技能</span></div>
                <div><img src="/statics/img/i.png"></div>
            </div>
            <div class="col-lg-3 col-md-6 col-sm-12 col-c">
                <div><img class="col-img" src="/statics/img/8.png"></div>
                <div><span>查看职业目标任务</span></div>
                <div><img src="/statics/img/i.png"></div>
            </div>
            <div class="col-lg-3 col-md-6 col-sm-12 col-c">
                <div><img class="col-img" src="/statics/img/9.png"></div>
                <div><span>参考学习资源，掌握技能点，逐个完成任务</span></div>
                <div><img src="/statics/img/i.png"></div>
            </div>
            <div class="col-lg-3 col-md-6 col-sm-12 col-c">
                <div><img class="col-img" src="/statics/img/10.png"></div>
                <div><span>加入班级，和小伙伴们互帮互助，一块学习</span></div>
                <div><img src="/statics/img/i.png"></div>
            </div>
            <div class="col-lg-3 col-md-6 col-sm-12 col-c">
                <div><img class="col-img" src="/statics/img/11.png"></div>
                <div><span>选择导师，一路引导，加速自己成长</span></div>
                <div><img src="/statics/img/i.png"></div>
            </div>
            <div class="col-lg-3 col-md-6 col-sm-12 col-c">
                <div><img class="col-img" src="/statics/img/12.png"></div>
                <div><span>完成职业技能，升级业内大牛</span></div>
                <div><img src="/statics/img/i.png"></div>
            </div>
        </div>
    </div>
    <!-- main第二部分 -->
    <h3 style="text-align: center">优秀学员展示</h3>
    <!-- 优秀学员展示过渡部分 -->
    <div class="container">
        <div class="row row-a" style=" margin: 40px 0;">
            <c:forEach items="${student}" var="student">
                <div class="col-lg-3 col-md-6 col-sm-12 col-a col-b">
                    <div class="col-d">
                        <div><img src=${student.img}></div>
                        <br>
                        <h3>${student.postion}：${student.name}</h3><br>
                        <p>${student.description}</p>
                    </div>
                </div>
            </c:forEach>
        </div>
    </div>
    <!-- main第三部分 -->
    <div class="box-wrap">
        <div class="box"></div>
        <div class="box"></div>
        <div class="box"></div>
        <div class="box"></div>
    </div>
    <!-- div过渡部分 -->
    <h3 class="tactic">战略合作企业</h3>
</main>
<footer>
    <div class="container">
        <div class="row justify-content-center">
            <div class="box1 col-lg-2 col-md-6 col-sm-12">
                <img src="/statics/img/n.png" width="150px"/>
            </div>
            <div class="box1 col-lg-2 col-md-6 col-sm-12">
                <img src="/statics/img/o.png" width="130px"/>
            </div>
            <div class="box1 col-lg-2 col-md-6 col-sm-12">
                <img src="/statics/img/p.png" width="130px"/>
            </div>
            <div class="box1 col-lg-2 col-md-6 col-sm-12">
                <img src="/statics/img/q.png" width="140px"/>
            </div>
            <div class="box1 col-lg-2 col-md-6 col-sm-12">
                <img src="/statics/img/r.png" width="142px"/>
            </div>
        </div>
    </div>
    <!-- footer第一部分 -->
    <h3 style="text-align: center;margin: 40px">友情链接</h3>
    <div class="container">
        <div class="row">
            <div class=" col-6 col-sm-3 col-md-3 footer-a ">
                <div class="dot-wrap">
                    <div class="dot"></div>
                    手机软件
                </div>
            </div>
            <div class=" col-6 col-sm-3 col-md-3 footer-a ">
                <div class="dot-wrap">
                    <div class="dot"></div>
                    教师招聘
                </div>
            </div>
            <div class=" col-6 col-sm-3 col-md-3 footer-a ">
                <div class="dot-wrap" style="width: 72px">
                    <div class="dot"></div>
                    找工作
                </div>
            </div>
            <div class=" col-6 col-sm-3 col-md-3 footer-a ">
                <div class="dot-wrap">
                    <div class="dot"></div>
                    教师招聘
                </div>
            </div>
            <div class=" col-6 col-sm-3 col-md-3 footer-a ">
                <div class="dot-wrap" style="width: 72px">
                    <div class="dot"></div>
                    找工作
                </div>
            </div>
            <div class=" col-6 col-sm-3 col-md-3 footer-a ">
                <div class="dot-wrap">
                    <div class="dot"></div>
                    手机软件
                </div>
            </div>
            <div class=" col-6 col-sm-3 col-md-3 footer-a ">
                <div class="dot-wrap">
                    <div class="dot"></div>
                    教师招聘
                </div>
            </div>
            <div class=" col-6 col-sm-3 col-md-3 footer-a ">
                <div class="dot-wrap">
                    <div class="dot"></div>
                    手机软件
                </div>
            </div>
            <div class=" col-6 col-sm-3 col-md-3 footer-a ">
                <div class="dot-wrap">
                    <div class="dot"></div>
                    手机软件
                </div>
            </div>
            <div class=" col-6 col-sm-3 col-md-3 footer-a ">
                <div class="dot-wrap" style="width: 72px">
                    <div class="dot"></div>
                    找工作
                </div>
            </div>
            <div class=" col-6 col-sm-3 col-md-3 footer-a ">
                <div class="dot-wrap">
                    <div class="dot"></div>
                    手机软件
                </div>
            </div>
            <div class=" col-6 col-sm-3 col-md-3 footer-a ">
                <div class="dot-wrap">
                    <div class="dot"></div>
                    教师招聘
                </div>
            </div>
            <div class=" col-6 col-sm-3 col-md-3 footer-a ">
                <div class="dot-wrap" style="width: 72px">
                    <div class="dot"></div>
                    找工作
                </div>
            </div>
            <div class=" col-6 col-sm-3 col-md-3 footer-a ">
                <div class="dot-wrap">
                    <div class="dot"></div>
                    教师招聘
                </div>
            </div>
            <div class=" col-6 col-sm-3 col-md-3 footer-a ">
                <div class="dot-wrap" style="width: 72px">
                    <div class="dot"></div>
                    找工作
                </div>
            </div>
            <div class=" col-6 col-sm-3 col-md-3 footer-a ">
                <div class="dot-wrap">
                    <div class="dot"></div>
                    手机软件
                </div>
            </div>
            <div class=" col-6 col-sm-3 col-md-3 footer-a ">
                <div class="dot-wrap">
                    <div class="dot"></div>
                    教师招聘
                </div>
            </div>
            <div class=" col-6 col-sm-3 col-md-3 footer-a ">
                <div class="dot-wrap">
                    <div class="dot"></div>
                    手机软件
                </div>
            </div>
            <div class=" col-6 col-sm-3 col-md-3 footer-a ">
                <div class="dot-wrap">
                    <div class="dot"></div>
                    手机软件
                </div>
            </div>
            <div class=" col-6 col-sm-3 col-md-3 footer-a ">
                <div class="dot-wrap" style="width: 72px">
                    <div class="dot"></div>
                    找工作
                </div>
            </div>
        </div>
    </div>

</footer>
<!-- footer第二部分 -->


</body>
</html>