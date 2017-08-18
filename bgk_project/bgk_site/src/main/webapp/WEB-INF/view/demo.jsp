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
<jsp:include page="header.jsp"/>
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
            init:function(){
                this.bindRandomSelectEvent();

            },
            // 绑定随机选择题目的事件
            bindRandomSelectEvent:function(){
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