<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
  <title>日常小程序</title>
  <meta http-equiv="pragma" content="no-cache" />
  <meta http-equiv="cache-control" content="no-cache" />
  <meta http-equiv="expires" content="0" />
  <meta http-equiv="keywords" content="企业信用,企业查询,工商信息,企业工商,工商查询,企业信用查询,企业工商信息查询" />
  <meta http-equiv="description" content="仅供日常娱乐使用" />
  <link href="/static/bootstrap/css/bootstrap.css" rel="stylesheet" type="text/css"/>

</head>
<body >
<header class="navbar navbar-static-top bs-docs-nav" id="top">
    <div class="container">
        <div class="navbar-header">
            <button class="navbar-toggle collapsed" type="button" data-toggle="collapse" data-target="#bs-navbar" aria-controls="bs-navbar" aria-expanded="false">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
          <%--  <a href="../" class="navbar-brand">嘿习惯</a>--%>
        </div>
        <nav id="bs-navbar" class="collapse navbar-collapse">
            <ul class="nav navbar-nav">
                <li>
                    <a href="../getting-started/" ></a>
                </li>
                <li>
                    <a href="../css/" >浏览信息</a>
                </li>
                <li class="active">
                    <a href="../components/" >个人定制</a>
                </li>
                <li>
                    <a href="../javascript/" >帅气</a>
                </li>
                <li>
                    <a href="../customize/" >啦啦啦</a>
                </li>
                <li><a href="http://www.youzhan.org"  target="_blank">网站实例</a></li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <!-- <li><a href="http://mb.bootcss.com" onclick="_hmt.push(['_trackEvent', 'docv3-navbar', 'click', 'themes'])" target="_blank">主题/模板</a></li> -->
                <li><a href="http://www.bootcss.com/" target="_blank">嘿习惯</a></li>
            </ul>
        </nav>
    </div>
</header>

<div class="container">

  <input type="hidden" id="demoCount" value="${demoCount}">
  <input type="hidden" id="currentId" value="-1">
  <p><a class="btn btn-primary btn-lg" id="randomSelectButton" href="javascript:void(0);" role="button">戳这里</a></p>
  <ul class="list-group">
    <c:forEach items="${demos}" var="demo" varStatus="status">
      <li class="list-group-item list-group-item-info" id="demotitle${status.index+1}">${status.index+1} ${demo.title}</li>
    </c:forEach>
  </ul>
</div>

<script type="text/javascript" src="/static/js/jquery-3.2.1.js"></script>
<script type="text/javascript">
    $(function(){
        Demo = function(){

        }
        Demo.prototype = {
            'init':function(){
                $("#randomSelectButton").on("click",function(){
                    //清空之前选择的
                    $(".list-group-item.list-group-item-danger").attr("class", "list-group-item list-group-item-info");
                    var total = parseInt($("#demoCount").val());
                    var id = getRandom(1,total);
                    var currentId = parseInt($("#currentId").val());
                    while(id == currentId){
                        id = getRandom(1,total);
                    }
                    $("#currentId").val(id);
                    //更改随机选中的颜色
                    $("#demotitle"+id).attr("class","list-group-item list-group-item-danger");
                })
            }
        }
        var demo = new Demo();
        function getRandom(min,max){
            var range = max - min;
            var rand = Math.random();
            return min + Math.round(range * rand);
        }

        demo.init();
    }())

</script>

</body>
</html>