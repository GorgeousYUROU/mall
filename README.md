 
学子商城
基于SpringMVC框架
 

 	



功能实现

对当前地址列表的查询功能（用jsp实现）
地址的新增（用Ajax实现）
默认地址的设置（用Ajax实现）
地址的删除（用Ajax实现）
地址信息的更新（用Ajax实现）
安全管理即密码的修改及修改密码的各种判断（用Ajax实现）

图解SpringMVC对此次功能的应用
具体看作业说明


相关文件
控制器文件（Package：cn.tedu.mall.controller）
1.	 主控制器
》》基类（自动异常处理） (BaseController)
》》用户逻辑处理部分（UserController）
》》商品部分（GoodsController）

2.控制器部分
 	》》地址管理部分（OrdersController）
	》》用户密码重置部分（UserController）
	》》部分无功能的跳转页(PageController)

业务层文件（Package：cn.tedu.mall.service.implement）
每一个service都有对应接口
2.	上课讲的控制器
》》商品处理(GoodsService)
》》商品目录部分（GoodsCategoriesService）
》》用户逻辑部分（UserService）

2.自己写的业务层部分
 	》》地址管理部分（OrderService）
	》》用户密码重置部分（UserService）
	
Mapper接口（Package：cn.tedu.mall.mapper）
每一个mapper都有对应的xml文件
3.	上课讲的控制器
》》商品处理(GoodsMapper)
》》商品目录部分（GoodsCategoryMapper）
》》用户逻辑部分（MapperUser）

2.自己写的数据管理部分
 	》》地址管理部分（OrderMapper）
	》》用户密码重置部分（MapperUser）
jsp文件（WebContent\WEB-INF\jsp）
1.上课讲的控制器
》》页面共有顶部部分(head.jsp | nav.jsp)
》》主页（index.jsp）
》》测试用（ok.jsp | error.jsp）
》》商品详情页（page_detail.jsp）

2.自己写的前端处理部分
 	》》地址管理部分（addressAdmin.jsp）
	》》密码修改部分（updatePassword.jsp）
	》》订单主页（OrderManagement.jsp）
	》》订单页共有左边栏(OrderLeft.jsp)


所用数据库表（数据库：store）
》》user表
》》t_address表
》》t_dict_provinces表
》》t_dict_cities表
》》t_dict_areas表
》》t_goods表
》》t_goods_category表


错误集锦
	用了AJAX局部刷新，一些js方法失效
解决方法：用on事件绑定
$(document).on('注册事件',"标签选择器",事件处理方法);
例子：$(document).on('click',".aco_change",function(){})

	分清dom元素与JQuery元素
dom= JQuery [i]
JQuery=$(dom)

	跳转的地址要加上双引号
