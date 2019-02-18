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
    <div class="rightsidebar_box rt">	
        <!--标题栏-->
        <div class="rs_header">
            <span class="address_title">收获地址管理</span>
        </div>
        <!-----------------------------------------------------收货人信息填写栏------------------------------------------>
        <div class="rs_content">
        	<form id="address_form" method="post" >
	            <!--收货人姓名-->
	            <div class="recipients">
	                <span class="red">*</span><span class="kuan">收货人：</span><input type="text" name="recv_name" id="recv_name"/>
	            </div>
	            <!--收货人所在城市等信息-->
	            <div data-toggle="distpicker" class="address_content">
					 <span class="red">*</span><span class="kuan">省&nbsp;&nbsp;份：</span><select data-province="---- 选择省 ----" id="recv_province"></select>
					  城市：<select data-city="---- 选择市 ----" id="recv_city"></select>
					  区/县：<select data-district="---- 选择区 ----" id="recv_area"></select>
				</div> 
	            
	            
	            <!--收货人详细地址-->
	            <div class="address_particular">
	                <span class="red">*</span><span class="kuan">详细地址：</span><textarea name="recv_addr" id="recv_addr" cols="60" rows="3" placeholder="建议您如实填写详细收货地址"></textarea>
	            </div>
	            <!--收货人地址-->
	            <div class="address_tel">
	                <span class="red">*</span><span class="kuan">手机号码：</span><input type="tel" id="recv_phone" name="recv_phone"/>固定电话：<input type="text" name="recv_tel" id="recv_tel"/>
	            </div>
	            <!--邮政编码-->
	            <div class="address_postcode">
	                <span class="red">&nbsp;</span class="kuan"><span>邮政编码：</span>&nbsp;<input type="text" name="recv_zip" id="recv_zip"/>
	            </div>
	            <!--地址名称-->
	            <div class="address_name">
	                <span class="red">&nbsp;</span class="kuan"><span>地址名称：</span>&nbsp;<input type="text" id="addressName" name="addressName"/>如：<span class="sp">家</span><span class="sp">公司</span><span class="sp">宿舍</span>
	            </div>
	            <!--保存收货人信息-->
	            <div >
	                <button type="submit" class="save" id="insert">保存收货人信息 </button>
	            </div>
	
    		</form>
            <!--已有地址栏-->
            <div class="address_information_manage" >
            
                <div class="aim_title" >
                    <span class="dzmc dzmc_title">地址名称</span><span class="dzxm dzxm_title">姓名</span><span class="dzxq dzxq_title">地址详情</span><span class="lxdh lxdh_title">联系电话</span><span class="operation operation_title">操作</span>
                </div>
<!------------------------------------------------------------------- 循环打印地址------------------------------------------------------------------------- -->              
			<div id="addressList"> 
                <c:forEach  items="${addresses}" var="address">
                <div class="aim_content_one aim_active" id="${address.id }" >
                    <span class="dzmc dzmc_active">${address.recv_tag}</span>
                    <span class="dzxm dzxm_normal">${address.recv_name}</span>
                    <span class="dzxq dzxq_normal">${address.recv_addr}</span>
                    <span class="lxdh lxdh_normal">${address.recv_phone}</span>
                    <span class="operation operation_normal">
                    	<span class="aco_change">修改</span>|<span class="aco_delete">删除</span>
                    </span>
                    <span class="swmr swmr_normal"><c:if test="${address.is_default==0 }"><c:out value="设为默认"></c:out></c:if></span>
                </div>
                </c:forEach>
            </div>     
                
            </div>
        </div>
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
<script type="text/javascript" src="../js/orders.js"></script>
<script type="text/javascript" src="../js/distpicker.data.js"></script>
<script type="text/javascript" src="../js/distpicker.js"></script>
<script type="text/javascript" src="../js/personal.js"></script>
<script type="text/javascript">
var SUCCESS = 1;
$(function(){
		//添加功能
		$(document).on('submit','#address_form',commitForm);
		//设置默认
		$(document).on('click',".swmr_normal",function(){
			var parent =$(this).parent();
			var is_default = $(this).val();
			console.log(is_default);
			if(is_default == "")
			{
			
			var id = parent[0].getAttribute("id");
			url="../orders/setDefault.do"
			$.getJSON(url,{is_default:1,id:id},function(result){
				if(result.state != SUCCESS){
					alert("修改默认值失败,请重新修改");
				}
			});
			}
			setDefault(this);
			
		});
		
		//删除功能
		$(document).on('click',".aco_delete",function(){
			var parent =$(this).parent().parent();
			var id = parent[0].getAttribute("id");
			if(confirm("确定删除吗？")){
				deleteAddress(id);
				return false;
			}
		});
		
		//修改功能
		$(document).on('click',".aco_change",function(){
			var parent =$(this).parent().parent();
			var id = parent[0].getAttribute("id");
			console.log(id);
			updateAddress(id);
			return false;
		});
		
				
	});
	
	function commitForm()
	{
		var recv_name = $('#recv_name').val();
		var recv_province = $('#recv_province').val();
		var recv_city = $('#recv_city').val();
		var recv_area = $('#recv_area').val();
		var recv_addr = $('#recv_addr').val();
		var recv_phone = $('#recv_phone').val();
		var recv_tel = $('#recv_tel').val();
		var recv_zip = $('#recv_zip').val();
		var recv_tag = $('#addressName').val();
		
		//判断是insert还是update
		var id = $(".save")[0].getAttribute("id");
		
		if(id=="insert"){
			var url = "../orders/addAddressAdmin.do";
		}
		else{
			var url = "../orders/updateAddress.do";
			 //把保存功能从update变为insert
			  
		}
	    
		
		if(!(recv_name&&recv_province&&recv_city&&recv_area&&recv_phone)){
			alert("收货人信息不全，请重新填写提交");
			return false;
		}
		var PhoneTest = /^\d{11}$/;
		if(!PhoneTest.test(recv_phone)){
			alert("手机号格式不正确，如:17287212817");
			return false;
		}

		var data = {
			recv_name : recv_name,
			recv_province : recv_province,
			recv_city : recv_city,
			recv_area : recv_area,
			recv_addr : recv_addr,
			recv_phone : recv_phone,
			recv_tel : recv_tel,
			recv_zip : recv_zip,
			recv_tag : recv_tag,
			id:id
		};

		$.post(url, data, function(result) {
			reFreshList(result);
		});
		if(id!="insert"){
			//把保存功能从update变为insert
			  	$('.save')[0].setAttribute("id","insert"); 
			  	$('#recv_name').val("");
				$('#recv_addr').val("");
				$('#recv_phone').val("");
				$('#recv_tel').val("");
				$('#recv_zip').val("");
				$('#addressName').val("");
		}
		
		return false;
	}
	
	//删除地址
	function deleteAddress(id)
	{
		var url="../orders/deleteAddress.do";
		$.getJSON(url,{id:id},function(result){
			reFreshList(result);	
		});
	
	}
	
	//更新功能
	function updateAddress(id){
		var url="../orders/getAddress.do";
		$.getJSON(url,{id:id},function(result){
			var data = result.data;
			  $('#recv_name').val(data.recv_name);                       
			  $('#recv_province').val(data.recv_province);   
			  $('#recv_province').change();
			  $('#recv_city').val(data.recv_city); 
			  $('#recv_city').change();
			  $('#recv_area').val(data.recv_area);                       
			  $('#recv_district').val(data.recv_district);               
			  $('#recv_addr').val(data.recv_addr);                       
			  $('#recv_phone').val(data.recv_phone);                     
			  $('#recv_tel').val(data.recv_tel);                         
			  $('#recv_zip').val(data.recv_zip);                         
			  $('#addressName').val(data.recv_tag);
			  
			  //把保存功能从insert变为update
			  $('.save')[0].setAttribute("id",id); 
			  
		});
		
		
		
	}
	
	function reFreshList(result)
	{
		if(result.state == SUCCESS){
			$("#addressList").empty();
			var addresses = result.data;
			
			for(var i=0;i<addresses.length;i++){
				address = addresses[i];
				$("#addressList").append(addressItem(address));
			}
		}
		else{
			console.log(result.message);
			alert("提交未成功，请重新提交");
		}
	}
	
	function addressItem(address)
	{
		var template = '<div class="aim_content_one aim_active" id="'+'{id}'+'">'+
		'<span class="dzmc dzmc_active">'+'{tag}'+'</span>'+
        '<span class="dzxm dzxm_normal">'+'{name}'+'</span>'+
        '<span class="dzxq dzxq_normal">'+'{addr}'+'</span>'+
        '<span class="lxdh lxdh_normal">'+'{phone}'+'</span>'+
        '<span class="operation operation_normal">'+
        	'<span class="aco_change">修改</span>|<span class="aco_delete">删除</span>'+
        '</span>'+
        '<span class="swmr swmr_normal">'+'{isDefault}'+'</span>'+
    '</div>';
    var str = template.replace('{id}',address.id).replace('{tag}',address.recv_tag).replace('{name}',address.recv_name).
    replace('{addr}',address.recv_addr). replace('{phone}',address.recv_phone);
    if(address.is_default==0){
    	str=str.replace("{isDefault}",'设为默认');
    }
    else{
    	str=str.replace("{isDefault}",'');
    }
    	
    return str;
	}
	

	//地址设置默认
	function setDefault(e){
		var parent = $(e).parent();
		if($(parent).siblings().hasClass("aim_active")){
			$(parent).siblings().removeClass("aim_active");
			$(parent).siblings().children(".dzmc_active").removeClass("dzmc_active").addClass("dzmc_normal");
			$(parent).siblings().children(".swmr_normal").html("设为默认")
		}
		$(parent).addClass("aim_active");
		$(parent).children(".dzmc_normal").removeClass("dzmc_normal").addClass("dzmc_active");
		$(e).html("");
	}
	
	
	
</script>
<script type="text/javascript">
	$(".lxdh_normal").each(function(i,e) {
		var phone = $(e).html();
		$(e).html(changePhone(phone));
	});
</script>
</html>