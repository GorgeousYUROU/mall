<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- 导航-->
<nav id="nav">
<c:url var="home" value="/pages/index.do"></c:url>
<c:url var="home1" value="/pages/index.do#computer"></c:url>
<c:url var="home2" value="/pages/index.do#stationery"></c:url>
    <ul>
        <li><a href="${home }" class="acti">首页</a></li>
        <li><a href="${home1 }" >电脑办公</a></li>
        <li><a href="${home2 }" >办公文具</a></li>
    </ul>
</nav>