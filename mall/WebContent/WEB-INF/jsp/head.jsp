<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- 页面顶部-->
<header id="top" class="fixed_nav">
    <div id="logo" class="lf">
        <img class="animated jello" src="../images/header/logo.png" alt="logo"/>
    </div>
    <div id="top_input" class="lf">
        <input id="input" type="text" placeholder="请输入您要搜索的内容"/>
        <a href="search.html" class="rt"><img id="search" src="../images/header/search.png" alt="搜索"/></a>
    </div>
    <div class="rt">
    <c:url var="favorites" value="/web/favorites.html" > </c:url>
    <c:url var="orders" value="/pages/OrdersManagement.do" > </c:url>
    <c:url var="cart" value="/web/cart.html" > </c:url>
    <c:url var="login" value="/web/login.html" > </c:url>
        <ul class="lf">
            <li><a href="${favorites}" title="我的收藏"><img class="care" src="../images/header/care.png" alt=""/></a><b>|</b></li>
            <li><a href="${orders}" title="我的订单"><img class="order" src="../images/header/order.png" alt=""/></a><b>|</b></li>
            <li><a href="${cart}" title="我的购物车"><img class="shopcar" src="../images/header/shop_car.png" alt=""/></a><b>|</b></li>
            <li><a href="../web/help.html">帮助</a><b>|</b></li>
            <li><a href="${login}">登录</a></li>
        </ul>
    </div>
</header>