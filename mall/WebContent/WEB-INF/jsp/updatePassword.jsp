<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>我的订单 - 达内学子商城</title>
    <link href="../css/orders.css" rel="stylesheet"/>
    <link href="../css/header.css" rel="stylesheet"/>
    <link href="../css/footer.css" rel="stylesheet"/>
    <link href="../css/personage.css" rel="stylesheet" />
 <style type="text/css">
 .hidden{
 display:none;
 }

.msg-default {
	width: 270px;
    color: #fff;
    padding: 4px;
    border-radius: 2px;
    background-color: #999;
    margin-left:20px;
}
.msg-error {
	width: 270px;
    color: #fff;
    padding: 4px;
    border-radius: 2px;;
    background-color: #d00;
    margin-left:20px;
}
 </style>
</head>
<body>
<!-- 页面顶部-->
<c:import url="/WEB-INF/jsp/head.jsp"></c:import> 
<!-- nav主导航-->
<c:import url="/WEB-INF/jsp/nav.jsp"></c:import> 
<!-- 我的订单导航栏-->
<div id="nav_order">
    <ul>
        <li><a href="">首页<span>&gt;</span>个人中心</a></li>
    </ul>
</div>
<!--我的订单内容区域 #container-->
<div id="container" class="clearfix">
 <!-- 左边栏-->
   <c:import url="/WEB-INF/jsp/OrderLeft.jsp"></c:import>
   
    <!-- 右边栏-->
    <!--个人信息头部-->
    <c:url var="updatePassword" value="../user/updatePassword.do"></c:url>
    <div class="rightsidebar_box rt">
        <div class="rs_header">
            <span ><a href="../web/personage.html">我的信息</a></span>
            <span class="rs_header_active"><a href="${updatePassword}">安全管理</a></span>
        </div>

        <!--安全管理 -->
        <form method="post" id="pawForm" >
	        <div class="rs_content">
	            <p class="change_password_title">更改密码</p>
	            <div class="new_password">
	                <span class="word">输入旧密码：</span><input type="password" id="oldPaw"/><span id="msg-tip-old" class="msg-default hidden" >hhh</span>
	            </div>
	            <div class="new_password">
	                <span class="word">输入新密码：</span><input type="password" id="newPaw" readonly="readonly"/><span id="msg-tip-new" class="msg-default hidden"></span>
	            </div>
	            <div class="new_password">
	                <span class="word">输入新密码：</span><input type="password" id="renewPaw" readonly="readonly"/><span id="msg-tip-renew" class="msg-default hidden"></span>
	            </div>
	            <button class="save_password" type="submit">
	                保存更改
	            </button>
	        </div>
        </form>
        


    </div>
</div>

<!-- 品质保障，私人定制等-->
<div id="foot_box">
    <div class="icon1 lf">
        <img src="../images/footer/icon1.png" alt=""/>

        <h3>品质保障</h3>
    </div>
    <div class="icon2 lf">
        <img src="../images/footer/icon2.png" alt=""/>

        <h3>私人定制</h3>
    </div>
    <div class="icon3 lf">
        <img src="../images/footer/icon3.png" alt=""/>

        <h3>学员特供</h3>
    </div>
    <div class="icon4 lf">
        <img src="../images/footer/icon4.png" alt=""/>

        <h3>专属特权</h3>
    </div>
</div>
<!-- 页面底部-->
<div class="foot_bj">
    <div id="foot">
        <div class="lf">
             <p class="footer1"><img src="../images/footer/logo.png" alt="" class=" footLogo"/></p>
             <p class="footer2"><img src="../images/footer/footerFont.png" alt=""/></p>
        </div>
        <div class="foot_left lf">
            <ul>
                <li><a href="#"><h3>买家帮助</h3></a></li>
                <li><a href="#">新手指南</a></li>
                <li><a href="#">服务保障</a></li>
                <li><a href="#">常见问题</a></li>
            </ul>
            <ul>
                <li><a href="#"><h3>商家帮助</h3></a></li>
                <li><a href="#">商家入驻</a></li>
                <li><a href="#">商家后台</a></li>
            </ul>
            <ul>
                <li><a href="#"><h3>关于我们</h3></a></li>
                <li><a href="#">关于达内</a></li>
                <li><a href="#">联系我们</a></li>
                <li>
                    <img src="../images/footer/wechat.png" alt=""/>
                    <img src="../images/footer/sinablog.png" alt=""/>
                </li>
            </ul>
        </div>
        <div class="service">
            <p>学子商城客户端</p>
            <img src="../images/footer/ios.png" class="lf">
            <img src="../images/footer/android.png" alt="" class="lf"/>
        </div>
        <div class="download">
            <img src="../images/footer/erweima.png">
        </div>
		<!-- 页面底部-备案号 #footer -->
        <div class="record">
            &copy;2017 达内集团有限公司 版权所有 京ICP证xxxxxxxxxxx
        </div>
    </div>

</div>
</body>
<script type="text/javascript" src="../js/jquery-3.1.1.min.js"></script>
<script src="../js/jquery.page.js"></script>
<script src="../js/index.js"></script>
<script type="text/javascript" src="../js/jquery-3.1.1.min.js"></script>

<script type="text/javascript" src="../js/orders.js"></script>
<script type="text/javascript">
var SUCCESS = 1;
$(function(){
	$(document).on('submit',"#pawForm",commitForm);
	$(document).on('change','#oldPaw',checkPassword);
	$(document).on('change','#newPaw',newPassword);
	
	$(document).on('input propertychange keyup','#renewPaw',renewPassword);
});


function checkPassword()
{
	var url="../user/checkPassword.do";
	var oldPaw=$("#oldPaw").val();
	$.getJSON(url,{oldPaw:oldPaw},function(result){
		if(result.state == SUCCESS){
			$("#msg-tip-old").hide();
			$("#newPaw")[0].readOnly=false;
			$("#renewPaw")[0].readOnly=false;
		}
		else{
			$("#msg-tip-old").removeClass().addClass("msg-error").html("原密码输入错误").show();
			$("#newPaw")[0].readOnly=true;
			$("#renewPaw")[0].readOnly=true;
		}
});
}

function newPassword(){
	var oldPaw=$("#oldPaw").val();
	var newPaw=$("#newPaw").val();
	if(oldPaw==newPaw){
		$("#msg-tip-new").removeClass().addClass("msg-error").html("请设置与原密码不一致的密码").show();
		return false;
	}
	else{
		var rule = /^\w{6,12}$/;
		if(!rule.test(newPaw)) {			
			$("#msg-tip-new").removeClass().addClass("msg-error").html("新设置的密码必须在6到12位之间").show();
			return false;
		}
		$("#msg-tip-new").hide();
		return true;
		}
		
	}

function renewPassword(){
	var password = $("#newPaw").val();
	var confirm = $("#renewPaw").val();
	var rule = /^\w{6,12}$/;
	
	if(!newPassword()) return false;
	if(password!=confirm){
		$("#msg-tip-renew").html("两次密码输入不一致").removeClass().addClass("msg-error").show();
	 return false;
	}
	else if(password==confirm){
		$("#msg-tip-renew").hide();
	}
	return true;
}

function commitForm(){
	var n=renewPassword()+newPassword();
	if(n!=2){
		return false;
	}
	var renewPaw=$("#renewPaw").val();
	var oldPaw=$("#oldPaw").val();
	var url="../user/rewewPassword.do";
	var newPaw=$("#newPaw").val();
	
	if(!(renewPaw&&oldPaw&&newPaw)){
		alert("密码不能为空");
		return false;
	}
	$.getJSON(url,{newPaw:newPaw},function(result){
		if(result.state ==SUCCESS){
			alert("密码修改成功，请重新登录");
			location.href ="../web/login.html"
		}
	});
	return false;
}
</script>

</html>