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
<div class="container">
  <p><a class="btn btn-primary btn-lg" href="#" role="button">戳这里</a></p>
  <ul class="list-group">
    <c:forEach items="${demos}" var="demo">
      <li class="list-group-item list-group-item-info">${demo.id} ${demo.title}</li>
    </c:forEach>
  </ul>
</div>




<%--<script type="text/javascript">--%>
  <%--$("#inp").val("hhhhhhhhhhhhhhh");--%>
<%--</script>--%>
<script type="text/javascript" src="/static/js/jquery-3.2.1.js"/>
<script type="text/javascrpit">

</script>

</body>
</html>